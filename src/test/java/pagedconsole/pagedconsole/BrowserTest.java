package pagedconsole.pagedconsole;

import static org.junit.Assert.*;

import java.rmi.server.ServerCloneException;

import javax.naming.InvalidNameException;

import org.junit.Before;
import org.junit.Test;

public class BrowserTest {
	
	PageBuilder pageBuilder;
	Page page;
	BrowserImpl browser;  
	ServerImpl server; 
	
	@Before
	public void setup() throws InvalidNameException{
		String pageName = "page_name";
		PageRepository pageRepository = new PageRepositoryImpl();
		pageBuilder = Page.getPageBuilder();
		pageBuilder.setPageName(pageName);
		PageElement pageElement = Page.createPageElement("HEADER", "HEADER");
		pageBuilder.append(pageElement);
		pageElement = Page.createPageElement("BODY", "BODY");
		pageBuilder.append(pageElement);
		pageElement = Page.createPageElement("FOOTER", "FOOTER");
		pageBuilder.append(pageElement);
		page = pageBuilder.build();
		pageRepository.add(page);
		browser = new BrowserImpl();
		server = new ServerImpl();
		server.setPageRepository(pageRepository);
		browser.setServer(server);		
	}
	
	@Test
	public void whenBrowsePageThatExistShowThePage() {
		String pageName = "page_name";
		String expectedPageContent = "HEADER\nBODY\nFOOTER\n";
		String pageContent = browser.browse(pageName);
		assertEquals(expectedPageContent, pageContent);
	}
	
	@Test
	public void whenBrowsePageThatDoesNotExistShowTheErrorPage() {
		String pageName = "wrong_page_name";
		String expectedPageContent = "ERROR\nPAGE \"wrong_page_name\" NOT FOUND\nFOOTER\n";
		String pageContent = browser.browse(pageName);
		assertEquals(expectedPageContent, pageContent);
	}
	
	@Test
	public void createListOfCommandsBasedOnPageElementsListInThePage() throws InvalidNameException{
		prepareData();
		String pageName = "first_page";
		browser.browse(pageName);
	}

	private void prepareData() throws InvalidNameException {
		pageBuilder = Page.getPageBuilder();
		PageElement element = Page.createPageElement("HEADER", "HEADER\n");
		CompositePageElement composite = (CompositePageElement) element;
		element = Page.createPageElement("TITLE", "THIS IS THE TITLE");
		composite.add(element);
		pageBuilder.append(composite);
		element = Page.createPageElement("BODY", "BODY\n");
		composite = (CompositePageElement) element;
		element = Page.createPageElement("TEXT", "And this is just some text in the BODY element");
		composite.add(element);
		element = Page.createPageElement("LINK", "Next Page");
		LeafPageElement leaf = (LeafPageElement) element;
		leaf.addAttribute("ref", "next_page");
		leaf.addAttribute("trigger", "1");
		composite.add(leaf);
		pageBuilder.append(composite);
		element = Page.createPageElement("FOOTER", "FOOTER\n");
		pageBuilder.append(element);
		pageBuilder.setPageName("first_page");
		page = pageBuilder.build();
		PageRepository pageRepository = new PageRepositoryImpl();
		pageRepository.add(page);
		browser = new BrowserImpl();
		server = new ServerImpl();
		server.setPageRepository(pageRepository);
		browser.setServer(server);	
	}

}
