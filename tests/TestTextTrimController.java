package tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import controllers.TextTrimController;
import controllers.UrlController;

/*
 * unit test of TextTrimController is to test the TrimKeyWord, TrimPageNumber, IsNumeric function of Text Trim Controller
 */
public class TestTextTrimController extends TestCase {

	TextTrimController textTrimController = new TextTrimController();
	
	@Test
	public void testTrimKeyWord() {
		String keyWord = textTrimController.trimKeyWord("   digital    camera   ");
		assertEquals("digital camera", keyWord);
	}

	@Test
	public void testTrimPageNumber() {
		String pageNumber = textTrimController.trimPageNumber("    12  "); 
		assertEquals("12", pageNumber);
	}

	@Test
	public void testIsNumeric() {
		boolean result = textTrimController.isNumeric("123A213");
		assertEquals(false, result);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestTextTrimController.class);
	}

}
