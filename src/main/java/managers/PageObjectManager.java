package managers;

import pageobjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;


    private GitHubHomePage gitHubHomePage;

    private GitHubSignInPage gitHubSignInPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public GitHubHomePage getGitHubHomePage() {
        return (gitHubHomePage == null) ? gitHubHomePage = new GitHubHomePage(webDriver) : gitHubHomePage;
    }

    public GitHubSignInPage getGitHubLoginPage() {
        return (gitHubSignInPage == null) ? gitHubSignInPage = new GitHubSignInPage(webDriver) : gitHubSignInPage;
    }
}
