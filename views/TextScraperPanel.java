package views;

import java.util.ArrayList;

import models.Product;
import controllers.QueryController;
import controllers.TextTrimController;
import exceptions.EmptyInputException;
import exceptions.InvalidNumberOfInputException;
import exceptions.NonNumericPageNumber;

/*
 * TextScraperPanel is the main process and user interface to get query and display corresponding results
 */
public class TextScraperPanel {

	/**
	 * @param args
	 * the valid number of args is 1 or 2, otherwise the program would throw responding exceptions.
	 * 
	 */
	public static void main(String[] args) {
		
		try {
			int numArgs = args.length;
			if (numArgs < 1 || numArgs > 2) {
				// inValid input;
				throw new InvalidNumberOfInputException();
			} else {
				QueryController queryController = new QueryController();
				TextTrimController textTrimController = new TextTrimController();
				if (numArgs == 1) {
					String args1 = args[0];
					args1 = textTrimController.trimKeyWord(args1);
					
					/*
					 * if the input is empty, just return and display notification
					 */
					if (args1 == null || args1.length() == 0) {
						throw new EmptyInputException();
					}
					String totalNumberOfResults = queryController.count(args1);
					System.out.println("The total number of results found is " + totalNumberOfResults);
				} else if (numArgs == 2) {
					String keyWord = args[0];
					String pageNumber = args[1];
					keyWord = textTrimController.trimKeyWord(keyWord);
					pageNumber = textTrimController.trimPageNumber(pageNumber);
					
					/*
					 * if the input is empty, just return and display notification
					 */
					if (keyWord == null || keyWord.length() == 0 || pageNumber == null || pageNumber.length() == 0) {
						throw new EmptyInputException();
					} else if (!textTrimController.isNumeric(pageNumber)) {
						
						/*
						 * if the page number is not numeric, return and display notification
						 */
						throw new NonNumericPageNumber();
						
					} else {
						
						/*
						 * if the page number is larger then "20", reset it to "1"
						 */
						if (pageNumber.compareTo("20") > 0 || pageNumber.length() > 2) {
							pageNumber = "1";
						}
						ArrayList<Product> resultObjects = queryController.query(keyWord, pageNumber);
						if (resultObjects != null && resultObjects.size() > 0) {
							printLine();
							for (int i = 0; i < resultObjects.size(); i++) {
								Product result = resultObjects.get(i);
								System.out.println(    "The product ID       : " + (i + 1));
								if (result.getProductName().equals("")) {
									System.out.println("The product name     : " + "Not available");
								} else {
									System.out.println("The product name     : " + result.getProductName());
								}
								if (result.getProductPrice().equals("")) {
									System.out.println("Price of the product : " + "Not available");
								} else {
									System.out.println("Price of the product : " + result.getProductPrice());
								}
								if (result.getProductVendor().equals("")) {
									System.out.println("Vendor               : " + "Not available");
								} else {
									System.out.println("Vendor               : " + result.getProductVendor());
								}
								printLine();
							}
						} else {
							System.out.println("We found 0 results for " + keyWord + " in page " + pageNumber);
							return;
						}
					}
				}
			}
		} catch (InvalidNumberOfInputException e) {
			System.out.println("Please input the valid number of arguments which is 1 or 2.");
		} catch (EmptyInputException e) {
			System.out.println("The input is empty.");
		} catch (NonNumericPageNumber e) {
			System.out.println("The input is invalid and the second argument should be Numeric.");
		} 
	}
	
	static void printLine() {
		for (int i = 0; i < 79; i++) {
			System.out.print("~");
		}
		System.out.println();
	}
}
