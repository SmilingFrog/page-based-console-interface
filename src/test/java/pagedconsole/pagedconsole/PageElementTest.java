package pagedconsole.pagedconsole;

import static org.junit.Assert.*;

import javax.naming.InvalidNameException;

import org.junit.Test;

public class PageElementTest {

	@Test
	public void test() throws InvalidNameException {
		PageElement element = Page.createPageElement("HEADER", "HEADER");
		
	}

}
