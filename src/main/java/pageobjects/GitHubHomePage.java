package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubHomePage {
    //Page URL
    private static String PAGE_URL = "https://github.com/";
    private WebDriver driver;

    //Locators
    //SignIn Button
    //@FindBy(xpath = "//a[@class='HeaderMenu-link no-underline mr-3']")
    @FindBy(xpath="/html/body/div[1]/header/div/div[2]/div[2]/div[2]/a")
    private WebElement signInButton;
    //UserAvatar
    @FindBy(xpath = "//span[@class='flex-shrink-0 css-truncate css-truncate-target']")
    private WebElement userAvatar;

    @FindBy(xpath ="/html/body/div[1]/header/div/div[2]/div[2]/div[1]/div/div/form/label/input[1]")
    private WebElement searchInput;


    @FindBy(xpath = "//*[invalid junk locators]")
    private WebElement invalidLocators;

    //Constructor
    public GitHubHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getNameOfLoggedInUser() {
        return userAvatar.getText();
    }

    public boolean defaultHomePageIsDisplayed() {
        signInButton.isDisplayed();
        searchInput.isDisplayed();
        return true;
    }

    public void getInvalidLocators() {
        invalidLocators.isDisplayed();
    }

    public void setSearchInput(String repoName) {
        searchInput.isEnabled();
        searchInput.click();
        searchInput.sendKeys(repoName);
    }
}
