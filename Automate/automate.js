let rp = require(`request-promise`);
var fs = require('fs');
let domain = "https://movietickets.com";
let names = [];
let links = [];
let movies = [];
let num = 0;
//Create movie class
class Movie {
    constructor(){
    this.name = "";
    this.genre = "";
    this.description = "";
    this.actors = [];
    this.rating = "";
    }
}
//Send promise request to movietickets.com/now-playing
rp(domain + "/now-playing").then(d => {
    //Make the data buffer into a strnig, then split by summary-short html code
    var tag = d.toString().split("summary-short");
    console.log(tag.length);
    //Special cases for the first members
    names[0] = tag[1].split(">")[1].split("<")[0];
    links[0] = tag[0].split("href=\"")[33].split("\"")[0];
    //For the rest of the tags, automate population
    for(let i = 2; i < tag.length; i++){
    names[i-1] = tag[i].split(">")[1].split("<")[0]; //Isolate name from html tag
    links[i-1] = tag[i].split("href=\"")[1].split("\"")[0]; //Get link from each movie
    nextStep(tag.length-1, names[i-1], links[i-2]);  //Move forward
    }
});

//Second step, goes into each individual link
function nextStep(count, name, link){
        rp(domain + link).then(d => { //Probe each link
            movies[num] = new Movie(); //Create movie object
            movies[num].name = name; //Populate movie object name
            let people = d.toString().split("data-qa=\"person\""); //Split by person tag, used to indicate actors/directors
            for(let i = 1; i < people.length; i++){
             movies[num].actors[i-1] = people[i].split("title=\"")[1].split("\"")[0]; 
            }
            movies[num].description = d.toString().split("summary-short")[1].split(">")[1].split("<")[0]; //Grab text from summary-short tag
            let genre = d.toString().split("\"genre\"")[1].split(">")[1].split("<")[0]; // Grab text from genre tag
            genre = genre.split("&amp\;").join(","); //Replace amp with comma, will make json implimentation cleaner
            movies[num].genre = genre;
            console.log(movies[num]); //Output to console
        });
        num++; //Increment counter
}
