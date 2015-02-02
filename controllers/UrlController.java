package controllers;

/*
 * This is the controller of URL.
 * The major functionality of URL controller is to construct the query URL by input
 */
public class UrlController {

	private final static String baseURL = "http://www.sears.com/search=";
	private final static String viewItemsNumber = "&viewItems=25";
	private final static String cancelRedirect = "&autoRedirect=false";
	private String pageNumber = "&page=2&cat_id=0";
	private String queryURL = "";
	
	/*
	 * construct the complete query URL
	 * the complete URL consists of 5 parts:
	 * 1. base of URL£º  http://www.sears.com/search=
	 * 2. the query key word: ex. "digital camera"
	 * 3. the page number: ex. "1"
	 * 4. how many items would be reviewed: ex. "25"
	 * 5. set autoRedirect to false
	 */
	public String construct (String keyWord, String pageNumber) {
		
		this.pageNumber = "?pageNum=" + pageNumber;
		String curKeyWord = "";
		/*
		 * change every space to "%20"
		 */
		for (int i = 0; i < keyWord.length(); i++) {
			if (keyWord.charAt(i) == ' ') {
				curKeyWord += "%20";
			} else {
				curKeyWord += keyWord.charAt(i);
			}
		}
		keyWord = curKeyWord;
		queryURL = baseURL 
				+ keyWord 
				+ this.pageNumber
				+ viewItemsNumber
				+ cancelRedirect;
		return queryURL;
	}
}
