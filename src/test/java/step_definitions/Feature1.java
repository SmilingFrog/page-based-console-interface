package step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pagedconsole.pagedconsole.Browser;
import pagedconsole.pagedconsole.BrowserImpl;
import pagedconsole.pagedconsole.Page;
import pagedconsole.pagedconsole.PageBuilder;
import pagedconsole.pagedconsole.PageElement;
import pagedconsole.pagedconsole.PageRepository;
import pagedconsole.pagedconsole.PageRepositoryImpl;

public class Feature1 {
	
	PageBuilder pageBuilder;
	Page page;
	Browser browser;

	@Given("^I have a page created$")
	public void i_have_a_page_created() throws Throwable {
		clean();
		setup();
		assertNotNull(pageBuilder);
		assertNotNull(page);
		clean();
	}

	private void setup() {
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
		browser.setPageRepository(pageRepository);
	}

	private void clean() {
		pageBuilder = null;
		page = null;
		browser = null;
	}

	@When("^I give the browser the page address and such page does exist$")
	public void i_give_the_browser_the_page_address_and_such_page_does_exist() throws Throwable {
		clean();
		setup();
		String pageName = "page_name";
		String expectedPageContent = "HEADER\nBODY\nFOOTER\n";
		String pageContent = browser.browse(pageName);
		assertEquals(expectedPageContent, pageContent);
		clean();
	}

	@Then("^The page is displayed$")
	public void the_page_is_displayed() throws Throwable {
		clean();
		setup();
		String pageName = "page_name";
		String expectedPageContent = "HEADER\nBODY\nFOOTER";
		String pageContent = browser.browse(pageName);
	}
	
	@When("^I give the browser a wrong page address$")
	public void i_give_the_browser_a_wrong_page_address() throws Throwable {
		clean();
		setup();
		String wrongPageName = "wrong_page_name";
		String expectedPageContent = "ERROR\nPAGE \"wrong_page_name\" NOT FOUND\nFOOTER\n";
		String pageContent = browser.browse(wrongPageName);
		assertEquals(expectedPageContent, pageContent);
		clean();
	}

	@Then("^error page is displayed$")
	public void error_page_is_displayed() throws Throwable {
		clean();
		setup();
		String wrongPageName = "wrong_page_name";
		String expectedPageContent = "ERROR\nPAGE \"wrong_page_name\" NOT FOUND\nFOOTER\n";
		String pageContent = browser.browse(wrongPageName);
		assertEquals(expectedPageContent, pageContent);
		clean();
	}
}
