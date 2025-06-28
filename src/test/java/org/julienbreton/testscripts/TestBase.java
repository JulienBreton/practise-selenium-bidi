package org.julienbreton.testscripts;

import io.testsmith.support.listeners.*;
import org.julienbreton.utils.BrowserUtil;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Network;
import org.openqa.selenium.bidi.network.AddInterceptParameters;
import org.openqa.selenium.bidi.network.InterceptPhase;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private Network network;

	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeClass
	public void setup() {
		final String browser = System.getProperty("browser", "firefox_bidi");
		WebDriver originalDriver = BrowserUtil.createDriver(browser);
		driver.set(new EventFiringDecorator<WebDriver>(new WebDriverLoggingListener(),
				new SavePageSourceOnExceptionListener(originalDriver, "target/log/pagesources"),
				new SaveScreenshotOnExceptionListener(originalDriver, "target/log/screenshots"),
				new HighlightElementsListener()).decorate(originalDriver));
		driver.set(originalDriver);
		originalDriver.manage().window().maximize();
		network = new Network(originalDriver);
		network.addIntercept(new AddInterceptParameters(InterceptPhase.AUTH_REQUIRED));
		network.onAuthRequired(responseDetails -> network.continueWithAuth(responseDetails.getRequest().getRequestId(),
				new UsernameAndPassword("admin", "admin")));
	}

	@AfterClass
	public void teardown() {
		getDriver().quit();
	}

}
