package tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import controllers.UrlController;

/*
 * unit test of ConstructURL is to test the construct function of URL Controller
 */
public class TestConstructURL extends TestCase {

	@Test
	public void testConstruct() {
		UrlController urlController = new UrlController();
		String queryURL = urlController.construct("digital camera children", "1");
		assertEquals("http://www.sears.com/search=digital%20camera%20children?pageNum=1&viewItems=25&autoRedirect=false", queryURL);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestConstructURL.class); 
	}
}
