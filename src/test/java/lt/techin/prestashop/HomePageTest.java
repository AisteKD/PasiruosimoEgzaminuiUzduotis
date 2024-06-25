package lt.techin.prestashop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BasePageTest {

    HomePage homePage;

    @Test
    @Order(1)
    void clickCreateAccountButton() {
        homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        String actualTitle = registrationPage.getTitleRegistration();
        String expectedTitle = "Create an account";
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}

