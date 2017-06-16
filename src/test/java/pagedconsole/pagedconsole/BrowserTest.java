package pagedconsole.pagedconsole;

import static org.junit.Assert.*;

import java.rmi.server.ServerCloneException;

import org.junit.Before;
import org.junit.Test;

public class BrowserTest {
	
	PageBuilder pageBuilder;
	Page page;
	BrowserImpl browser;  
	ServerImpl server; 
	
	@Before
	public void setup(){
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
	public void test() {
		String pageName = "page_name";
		String expectedPageContent = "HEADER\nBODY\nFOOTER\n";
		String pageContent = browser.browse(pageName);
		assertEquals(expectedPageContent, pageContent);
	}

}
