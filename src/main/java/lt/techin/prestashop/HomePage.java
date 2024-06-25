package lt.techin.prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

   @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[3]/a")
    WebElement createAccountButton;

    @FindBy(css = "#_desktop_user_info > div > a > span")
    WebElement logoutTitle;

    @FindBy (xpath = "//*[@id=\"footer_account_list\"]/li[2]/a")
    WebElement SignInButton;

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }

    public String getTitleLogout() {
        waitForElement(logoutTitle);
        return logoutTitle.getText();
    }

    public void clickSignInButton(){
        SignInButton.click();
    }
}
