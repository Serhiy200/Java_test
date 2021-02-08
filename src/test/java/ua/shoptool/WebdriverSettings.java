package ua.shoptool;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class WebdriverSettings {
    public WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        System.out.println("Test start");
    }

    @After
    public void close(){
        System.out.println("Test close");
        driver.quit();

    }

    public static int count(int n) {
        Random rnd = new Random();
        return rnd.nextInt(n);
    }


}
