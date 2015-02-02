package controllers;

import java.util.regex.Pattern;

/*
 * The controller of textTrim is to trim the keyword, page number and check whether page number is Numeric
 */
public class TextTrimController {
	
	/*
	 * omit the leading and trailing whitespace and just leave one whitespace between each word
	 */
	public String trimKeyWord (String keyWord) {
		keyWord = keyWord.trim();
		keyWord = keyWord.replaceAll("\\s{2,}", " ");
		return keyWord;
	}
	
	/*
	 * omit all whitespace for page numebr 
	 */
	public String trimPageNumber (String pageNumber) {
		pageNumber = pageNumber.replaceAll(" ", "");
		return pageNumber;
	}
	
	/*
	 * check whether page number is Numeric
	 */
	public static boolean isNumeric (String pageNumber) { 
		Pattern pattern = Pattern.compile("[0-9]*"); 
		return pattern.matcher(pageNumber).matches();    
	} 
}
