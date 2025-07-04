package org.julienbreton.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserUtil {

	public static WebDriver createDriver(String browser) {
		WebDriver driver = null;
		switch (Browser.valueOf(browser.toUpperCase())) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		case CHROME_HEADLESS:
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
			break;
		case FIREFOX_HEADLESS:
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			driver = new FirefoxDriver(options);
			break;
		case FIREFOX_BIDI:
			FirefoxOptions optionsBidi = new FirefoxOptions();
			optionsBidi.enableBiDi();
			optionsBidi.setCapability("webSocketUrl", true);
			driver = new FirefoxDriver(optionsBidi);
			break;
		}
		return driver;
	}
}
