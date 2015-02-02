package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.DomDocument;
import models.Product;

/*
 * The controller of query is to retrieve dom document from website, count total number of results, and query all results details
 */

public class QueryController {
	
	DomDocument domDocument = null;
	
	/*
	 * retrieve dom document from website
	 */
	public void retrieve (String keyWord, String pageNumber) {
		UrlController urlController = new UrlController();
		String queryURL = urlController.construct(keyWord, pageNumber);
		Document doc = null;
		try {
			doc = Jsoup.connect(queryURL).timeout(10*1000).get();
		} catch (IOException e) {
			System.out.println("Time out! Please check the network");
		}
		
		domDocument = new DomDocument();
		domDocument.setDoc(doc);

		return;
	}
	
	/*
	 * return the total number of results
	 */
	public String count (String keyWord) {
		retrieve (keyWord, "1");
		Document doc = domDocument.getDoc();
		Elements result = doc.select("div#nmbProdItems");
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(result.text());
		int count = 0;
		while (m.find()) {
		  count++;
		  if (count == 3) {
			  String tmp = m.group();
			  if (tmp.equals("500")) {
				  tmp += '+';
			  }
			  return tmp;
		  }
		}
		return "0";
	}
	
	/*
	 * return the arraylist of all results object
	 */
	public ArrayList<Product> query (String keyWord, String pageNumber) {
		ArrayList<Product> resultObjects = new ArrayList<Product>();
		retrieve (keyWord, pageNumber);
		Document doc = domDocument.getDoc();
		Elements results = doc.select("div.cardInner");
		for (Element result : results) {
			String productName = result.select("div.cardProdTitle a").attr("title");
			String productPrice = "";
			Element productPriceElement = result.select("span.price_v2.intShipHide").first();
			
			if (productPriceElement != null) {
				productPrice = productPriceElement.text();
			} else {
				productPrice = "";
			}
			
			String productVendor = "";
			Element productVendorElement = result.select("#mrkplc p").first();
			
			if (productVendorElement != null) {
				productVendor = productVendorElement.text();
			} else {
				productVendor = "Sears.com";
			}
			
			Product product = new Product(productName, 
											productPrice,
											productVendor);
			resultObjects.add(product);
		}
		
		return resultObjects;
	}

	public DomDocument getDomDocument() {
		return domDocument;
	}

	public void setDomDocument(DomDocument domDocument) {
		this.domDocument = domDocument;
	}
}
