package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import models.Product;

import org.junit.Test;

import controllers.QueryController;
import controllers.UrlController;

/*
 * unit test of QueryController is to test the retrieve, count, query function of query controller
 */
public class TestQueryController extends TestCase{
	
	QueryController queryController = new QueryController();
	@Test
	public void testRetrieve() {
		
		queryController.retrieve("1232g", "1");
		
		assert queryController.getDomDocument() != null;
	}

	@Test
	public void testCount() {
		
		String numberOfResults = queryController.count("1232g");
		assertEquals("5", numberOfResults);
	}

	@Test
	public void testQuery() {
		ArrayList<Product> resultObjects = queryController.query("digital", "1");
		assert resultObjects.size() == 25;
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestQueryController.class); 
	}
}
