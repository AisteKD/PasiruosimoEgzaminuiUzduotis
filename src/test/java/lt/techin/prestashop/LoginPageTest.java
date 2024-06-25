package lt.techin.prestashop;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPageTest extends BasePageTest{

    HomePage homePage;
    LoginPage loginPage;

    @Test
    @Tag("Login")
    @Order(4)
    void fillCorrectEmailAndPasswordForLogin(){

        homePage = new HomePage(driver);
        homePage.clickSignInButton();

        loginPage = new LoginPage(driver);

        String actualTitle = loginPage.getTitleLogInToYourAccount();
        String excpectedTitle = "Log in to your account";
        Assertions.assertEquals(excpectedTitle, actualTitle);

        String email = "aistekdkd@gmail.com";
        String password = "aiste_kada";

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickButtonSignIn();

        String actualMyAccountTitle = loginPage.getTitleMyAccountProfile();
        String excpectedMyAccountTitle = "Aistekd AisteKd";
        Assertions.assertEquals(excpectedMyAccountTitle, actualMyAccountTitle);

        loginPage.clickSignOutButton();

        String actualLogInAgainTitle = loginPage.getTitleLogInToYourAccount();
        String excpectedLogInAgainTitle = "Log in to your account";
        Assertions.assertEquals(excpectedLogInAgainTitle, actualLogInAgainTitle);
    }

    @Test
    @Tag("Login")
    @Order(5)
    void fillIncorrectEmailAndPasswordForLogin(){
        homePage = new HomePage(driver);
        homePage.clickSignInButton();

        loginPage = new LoginPage(driver);

        String actualTitle = loginPage.getTitleLogInToYourAccount();
        String excpectedTitle = "Log in to your account";
        Assertions.assertEquals(excpectedTitle, actualTitle);

        String email = "kadaa@test.com";
        String password = "aiste_kadaa";

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickButtonSignIn();

        String errorMessage = loginPage.getErrorMessage();
        String expectedMessage = "Authentication failed.";
        assertEquals(expectedMessage, errorMessage);
    }

    @ParameterizedTest
    @Order(6)
    @Timeout(5)
    @CsvFileSource(files = "src/main/resources/logins.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String EMAIL, String PASSWORD) {
        homePage = new HomePage(driver);
        homePage.clickSignInButton();

        loginPage = new LoginPage(driver);

        String actualTitle = loginPage.getTitleLogInToYourAccount();
        String expectedTitle = "Log in to your account";
        Assertions.assertEquals(expectedTitle, actualTitle);

        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);

        loginPage.clickButtonSignIn();

        String actualMyAccountTitle = loginPage.getTitleMyAccountProfile();
        String expectedMyAccountTitle = "Aistekd AisteKd";
        Assertions.assertEquals(expectedMyAccountTitle, actualMyAccountTitle);

        loginPage.clickSignOutButton();

        String actualLogInAgainTitle = loginPage.getTitleLogInToYourAccount();
        String expectedLogInAgainTitle = "Log in to your account";
        Assertions.assertEquals(expectedLogInAgainTitle, actualLogInAgainTitle);
    }
}
