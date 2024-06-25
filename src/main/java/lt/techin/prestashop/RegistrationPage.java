package lt.techin.prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id=\"main\"]/header/h1")
    WebElement registerAccountTitle;

    @FindBy (id = "field-id_gender-1")
    WebElement radioMr;

    @FindBy (id = "field-id_gender-2")
    WebElement radioMrs;

    @FindBy (id = "field-firstname")
    WebElement inputFirstName;

    @FindBy (id = "field-lastname")
    WebElement inputLastName;

    @FindBy (id = "field-email")
    WebElement inputEmail;

    @FindBy (id = "field-password")
    WebElement inputPassword;

    @FindBy (id = "field-birthday")
    WebElement inputBirthday;

    @FindBy (css = "[name='psgdpr']")
    private WebElement checkboxTermsConditions;


    @FindBy (css = "[name='customer_privacy']")
    private WebElement checkboxCustomerPrivacy;

    @FindBy (css = "#customer-form > footer > button")
    WebElement buttonSave;

    @FindBy (xpath= "//*[@id=\"_desktop_user_info\"]/div/a[2]")
    WebElement buttonMyAccountProfile;

    @FindBy (xpath = "//*[@id=\"main\"]/header/h1")
    WebElement registerSuccessfullyAccountTitle;

    @FindBy (css = "#_desktop_user_info > div > a.logout.hidden-sm-down")
    WebElement logoutButton;

    @FindBy (css = ".alert-danger")
    WebElement errorMessage;

    public String getTitleRegistration() {
        return registerAccountTitle.getText();
    }

    public void clickRadioMr() {
        radioMr.click();
    }

//    public void clickRadioMrs() {
//        radioMrs.click();
//    }

    public void enterFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastname) {
        inputLastName.sendKeys(lastname);
    }

    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void enterBirthday(String birthday) {
        inputBirthday.sendKeys(birthday);
    }

    public void clickCheckboxTermsConditions() {
        checkboxTermsConditions.click();
    }

    public void clickCheckboxCustomerPrivacy() {
        checkboxCustomerPrivacy.click();
    }

    public void clickButtonSave() {
        buttonSave.click();
    }

    public void clickButtonMyAccountProfile() {
        buttonMyAccountProfile.click();
    }

    public String getTitleSuccessfullyRegisterAccount() {
        return registerSuccessfullyAccountTitle.getText();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public String getErrorMessage() {
        waitForElement(errorMessage);
        return errorMessage.getText();
    }
}
