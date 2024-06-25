package lt.techin.prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "field-email")
    WebElement inputEmail;

    @FindBy (id = "field-password")
    WebElement inputPassword;

    @FindBy (id = "submit-login")
    WebElement buttonSignIn;

    @FindBy (xpath = "//*[@id=\"main\"]/header/h1")
    WebElement logInToYourAccountTitle;

    @FindBy (xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    WebElement myAccountProfileTitle;

    @FindBy (xpath = "//*[@id=\"_desktop_user_info\"]/div/a[1]")
    WebElement signOutButton;

    @FindBy (xpath = "//*[@id=\"content\"]/section/div")
    WebElement errorMessage;

    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickButtonSignIn() {
       buttonSignIn.click();
    }

    public String getTitleLogInToYourAccount() {
        return logInToYourAccountTitle.getText();
    }

    public String getTitleMyAccountProfile() {
        return myAccountProfileTitle.getText();
    }

    public void clickSignOutButton(){
        signOutButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
