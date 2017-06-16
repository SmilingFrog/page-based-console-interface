package step_definitions;

import static org.junit.Assert.assertNotNull;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pagedconsole.pagedconsole.Page;
import pagedconsole.pagedconsole.PageBuilder;

public class Feature1 {
	@Given("^I have a page created$")
	public void i_have_a_page_created() throws Throwable {
		PageBuilder pageBuilder = Page.getPageBuilder();
		Page page = pageBuilder.build();
		assertNotNull(pageBuilder);
		assertNotNull(page);
	}

	@When("^I give the browser the page name$")
	public void i_give_the_browser_the_page_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The page is displayed$")
	public void the_page_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
