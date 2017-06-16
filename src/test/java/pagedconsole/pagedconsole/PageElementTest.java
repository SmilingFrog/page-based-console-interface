package pagedconsole.pagedconsole;

import static org.junit.Assert.*;

import javax.naming.InvalidNameException;

import org.junit.Test;

public class PageElementTest {

	@Test
	public void test() throws InvalidNameException {
		PageBuilder pb = Page.getPageBuilder();
		PageElement element = Page.createPageElement("HEADER", "HEADER\n");
		CompositePageElement composite = (CompositePageElement) element;
		element = Page.createPageElement("TITLE", "THIS IS THE TITLE");
		composite.add(element);
		pb.append(composite);
		element = Page.createPageElement("BODY", "BODY\n");
		composite = (CompositePageElement) element;
		element = Page.createPageElement("TEXT", "And this is just some text in the BODY element");
		composite.add(element);
		pb.append(composite);
		element = Page.createPageElement("FOOTER", "FOOTER\n");
		pb.append(element);
		Page page = pb.build();
		System.out.println(page.getContent());
	}
	

}
