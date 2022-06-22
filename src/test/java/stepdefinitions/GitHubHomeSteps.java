package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.GitHubHomePage;
import utilities.TestContext;

public class GitHubHomeSteps {

    GitHubHomePage homePage;
    TestContext testContext;

    public GitHubHomeSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getGitHubHomePage();
    }

    @Given("GitHub Home page without authorizations")
    public void homePageWithoutAuthorizations() {
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
    }

    @Given("GitHub Login form in login page")
    public void goToLoginPage() {
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
        homePage.clickSignInButton();
    }

    @Then("This is for invalid webelements")
    public void thisIsForInvalidLocators() {
        homePage.getInvalidLocators();
    }
}
