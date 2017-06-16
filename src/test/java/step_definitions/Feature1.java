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
		pageBuilder = Page.getPageBuilder();
		page = pageBuilder.build();
		browser = new BrowserImpl();
	}

	private void clean() {
		pageBuilder = null;
		page = null;
		browser = null;
	}

	@When("^I give the browser the page name$")
	public void i_give_the_browser_the_page_name() throws Throwable {
		clean();
		setup();
		String pageName = "page_name";
		String expectedPageContent = "HEADER\nBODY\nFOOTER";
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
}
