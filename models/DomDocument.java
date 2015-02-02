package models;

import org.jsoup.nodes.Document;

/*
 * This is the model of dom document from the website which would be loaded and parsed.
 * Therefore, it should be easier to be taken used of by different modules.
 */
public class DomDocument {
	private Document doc;

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
}
