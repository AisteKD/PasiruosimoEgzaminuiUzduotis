package lt.techin.prestashop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePageTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("http://192.168.8.150/");
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if(driver!=null){
            driver.quit();}
    }

    public void palaukti() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
