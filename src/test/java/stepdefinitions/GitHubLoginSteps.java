package stepdefinitions;

import dataproviders.ExcelFileReader;
import dataproviders.UserPassword;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import org.testng.Assert;
import pageobjects.GitHubSignInPage;
import utilities.TestContext;

import java.util.List;
import java.util.Map;

public class GitHubLoginSteps {

    TestContext testContext;
    GitHubSignInPage loginPage;

    public GitHubLoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getGitHubLoginPage();
    }

    @Then("GitHub Login page is displayed")
    public void loginPageIsDisplayed() {
        Assert.assertTrue(loginPage.signInPageIsDisplayed());

        String actualLoginHeaderTitle = loginPage.getLoginHeaderTitle();
        System.out.println(actualLoginHeaderTitle);
        Assert.assertEquals("Sign in to GitHub", actualLoginHeaderTitle);

    }

    @When("Input {string} as email, {string} as password")
    public void inputAsEmailAsPasswordAsAccountType(String email, String password) {
        System.out.println("---" + email);
        System.out.println("---" + password);
    }

    @When("Input GitHub credentials to login without headers")
    public void inputCredentialsToLoginWithoutHeaders(DataTable dataTable) {
        List<String> dataRow = dataTable.row(0);
        String email = dataRow.get(0);

        System.out.println("row index 0 --- " + email);

        System.out.println("row index 1 --- " + dataRow.get(1));
        String password = dataRow.get(1);
        loginPage.signIn(email,password);
    }

    @When("Input GitHub credentials to login using spreadsheet")
    public void inputCredentialsToLoginUsingSpreadSheet() {
        UserPassword up = FileReaderManager.getInstance().getExcelFileReader().getUserPassword(0);

        String email = up.getUserName();

        String password = up.getPassword();;
        System.out.println(" Printing username "+email+" Password "+password);
        loginPage.signIn(email,password);
    }

    @When("Input GitHub credentials to login with headers table")
    public void inputCredentialsToLoginWithHeadersTable(DataTable dataTable) {
        List<Map<String,String>> dataRow = dataTable.asMaps(String.class,String.class);

        //Use for...loop if you have multiple data table
        for (Map<String, String> dataMap : dataRow) {
            String email = dataMap.get("Email");
            String password = dataMap.get("Password");
            loginPage.signIn(email,password);
            System.out.println("row header email " + email);
            System.out.println("row index 1 --- " + dataMap.get("Password"));
        }
    }

    @When("Click signin button")
    public void clickSelanjutnyaButton() {
        loginPage.clickOnSubmit();
    }
}
