package org.julienbreton.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class PageBasicAuth extends AbstractPageBase {

	public PageBasicAuth(WebDriver driver) {
		super(driver);
	}
	
    @Step("Open the basic-auth page")
    public PageBasicAuth open() {
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        return this;
    }
   
    @Step("Is User Authenticated ?")
    public String isUserAuthenticated() {
        WebElement elementMessage = driver.findElement(By.tagName("p"));
        return elementMessage.getText();
    }

}
