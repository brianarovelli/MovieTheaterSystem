
public enum Advisory {
	G("G"), PG("PG"), PG13("PG13"), R("R");
	
	public final String Advisory;
    
	/** private Advisory(String Advisory)
	 * Sets Advisory
	 * @param Advisory - parental rating of event
	 */
	private Advisory(String Advisory) {
        this.Advisory = Advisory;
    }
}
