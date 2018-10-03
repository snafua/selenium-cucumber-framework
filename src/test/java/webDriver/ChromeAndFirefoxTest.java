package webDriver;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Test with Chrome and Firefox browsers.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class ChromeAndFirefoxTest {

    protected WebDriver chrome;
    protected WebDriver firefox;

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest(){
        chrome = new ChromeDriver();
        firefox = new FirefoxDriver();
    }

    @After
    public void teardown(){
        if (chrome != null){
            chrome.quit();
        }
        if (firefox != null){
            firefox.quit();
        }
    }

    @Test
    public void test(){
        // Test data
        int timeout = 30;
        String sutUrl = "https://en.wikipedia.org/wiki/Main_Page";

        // Implicit timeout
        chrome.manage().timeouts().implicitlyWait(timeout, SECONDS);
        firefox.manage().timeouts().implicitlyWait(timeout, SECONDS);

        // Open page in different browsers
        chrome.get(sutUrl);
        firefox.get(sutUrl);

        // Assertion
        assertEquals(chrome.getTitle(), firefox.getTitle());
    }

}
