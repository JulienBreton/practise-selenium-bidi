package org.julienbreton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class PageContextUser extends AbstractPageBase {

	public PageContextUser(WebDriver driver) {
		super(driver);
	}

	@Step("Open the page to test context user")
	public PageContextUser open() {
		driver.get("https://www.selenium.dev/selenium/web/cookie-background.html");
		return this;
	}

	public String getBackgroundColor() {

		WebElement body = driver.findElement(By.tagName("body"));
		return body.getCssValue("background-color");
	}
	
	public void setBackgroundColorBlue() {
		
		 driver.findElement(By.id("blue-btn")).click();
	}
	
	public void setBackgroundColorGreen() {
		
		 driver.findElement(By.id("green-btn")).click();
	}

}
