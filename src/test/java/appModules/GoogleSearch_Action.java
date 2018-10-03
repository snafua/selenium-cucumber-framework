package appModules;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.HomePage;
import webDriver.Driver;


public class GoogleSearch_Action {

	static WebDriver driver = Driver.getCurrentDriver();
	static WebDriverWait wait = new WebDriverWait(driver, 10);

	public static void search(String searchCriteria) {

		String googleUrl = "https://www.google.co.uk";
		driver.get(googleUrl);
		final ExpectedCondition<WebElement> webElementExpectedCondition = ExpectedConditions.elementToBeClickable(HomePage.searchField());
		//wait.until();
		//wait.until(webElementExpectedCondition);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.searchField()));

		HomePage.searchField().clear();
		HomePage.searchField().sendKeys(searchCriteria);
		HomePage.searchField().sendKeys(Keys.RETURN);

		wait.until(ExpectedConditions.titleContains("Google Search"));
	}

}
