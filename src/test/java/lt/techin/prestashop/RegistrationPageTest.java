package lt.techin.prestashop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomEmailGenerator;
import utils.RandomNameGenerator;
import utils.RandomPasswordGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest extends BasePageTest {

    RegistrationPage registrationPage;
    HomePage homePage;

    @Test
    @Tag("Registration")
    @Order(2)
    void fillSuccessfulRegisterForm(){

        registrationPage = new RegistrationPage(driver);
        driver.get("http://192.168.8.150/registration");

        String randomName = RandomNameGenerator.generateRandomFirstname();
        String firstName = randomName;
        String randomLastname = RandomNameGenerator.generateRandomLastname();
        String lastName = randomLastname;
        String randomEmail = RandomEmailGenerator.generateRandomEmail();
        String email = randomEmail;
        String password = RandomPasswordGenerator.generateRandomPassword();
        String date = "01/01/1990";

        registrationPage.clickRadioMr();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.enterBirthday(date);
        registrationPage.clickCheckboxTermsConditions();
        registrationPage.clickCheckboxCustomerPrivacy();
        registrationPage.clickButtonSave();
        registrationPage.clickButtonMyAccountProfile();

        String actualTitle = registrationPage.getTitleSuccessfullyRegisterAccount();
        String excpectedTitle = "Your account";
        Assertions.assertEquals(excpectedTitle, actualTitle);

        registrationPage.clickLogoutButton();

        homePage = new HomePage(driver);
        String actualLogoutTitle = homePage.getTitleLogout();
        String expectedLogoutTitle = "Sign in";
        Assertions.assertEquals(expectedLogoutTitle, actualLogoutTitle);
    }

    @Test
    @Tag("Registration")
    @Order(3)
    void fillIncorrectRegisterForm(){

        homePage = new HomePage(driver);
        homePage.clickCreateAccountButton();

        registrationPage = new RegistrationPage(driver);
        String actualTitle = registrationPage.getTitleRegistration();
        String expectedTitle = "Create an account";
        Assertions.assertEquals(expectedTitle, actualTitle);

        registrationPage.clickRadioMr();
        registrationPage.enterFirstName("Aistek");
        registrationPage.enterLastName("25Aiste_");
        registrationPage.enterEmail("25aiste@gmail.com");
        registrationPage.enterPassword("5676768687");
        registrationPage.enterBirthday("1970-05-31");
        registrationPage.clickCheckboxTermsConditions();
        registrationPage.clickCheckboxCustomerPrivacy();
        registrationPage.clickButtonSave();

        String errorMessage = registrationPage.getErrorMessage();
        String expectedMessage = "Invalid format.";
        assertEquals(expectedMessage, errorMessage);
    }
}
