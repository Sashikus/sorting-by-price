package com.example.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseHelper {

	public static WebDriver driver;
	public static String baseUrl;

	public static final String BASE_URL = "http://www.goeuro.de/";
	public static final String FILTER_FROM = "Berlin, Deutschland";
	public static final String FILTER_TO = "Prag, Tschechien";

	public static final String CHECKBOX_ACCOMODATION = "//div[@class='hotel-checkbox']/label/span";
	public static final String PRICE_CONTAINER = "div.Result__priceContainer___3s9kI";
	public static final String PRICE_MAIN = "span.Result__priceMain___25qv5";
	public static final String PRICE_FRACTION = "span.Result__priceFraction___16hVT";
	public static final String SUBMIT_BUTTON = "search-form__submit-btn";

	public BaseHelper() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		baseUrl = BASE_URL;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void stop() {
		driver.quit();
	}

	public void openMainPage() {
		if (!onMainPage()) {
			driver.get(baseUrl);
		}
	}

	private boolean onMainPage() {
		return (driver.getCurrentUrl() == BASE_URL);
	}

	public void fillInSearchParameters(String filter1, String filter2) {
		type(By.id("from_filter"), filter1);
		type(By.id("to_filter"), filter2);
	}

	public void checkmarkAccomodationBox() {
		click(By.xpath(CHECKBOX_ACCOMODATION));
	}

	public void submitMainSearch() {
		if (isElementPresent(By.id(SUBMIT_BUTTON))) {
			submit(By.id(SUBMIT_BUTTON));
		}
	}

	private void submit(By locator) {
		driver.findElement(locator).submit();
	}

	public void type(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void goToResultsPage() {
		fillInSearchParameters(FILTER_FROM, FILTER_TO);
		checkmarkAccomodationBox();
		submitMainSearch();
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public List<Float> getListOfPrices() {
		List<Float> prices = new ArrayList<Float>();
		List<WebElement> elements = driver.findElements(By.cssSelector(PRICE_CONTAINER));
		for (WebElement element : elements) {
			String priceMain = element.findElement(By.cssSelector(PRICE_MAIN)).getText();
			String pricePoint = ".";
			String priceFraction = element.findElement(By.cssSelector(PRICE_FRACTION)).getText();
			Float wholePrice = Float.valueOf(priceMain + pricePoint + priceFraction);
			prices.add(wholePrice);
		}
		return prices;
	}
}
