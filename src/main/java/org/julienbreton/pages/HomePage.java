package org.julienbreton.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPageBase {

    private final By signInButton = By.cssSelector("[data-test='nav-sign-in']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the Practice Software Testing homepage")
    public HomePage open() {
        driver.get("https://practicesoftwaretesting.com/");
        return this;
    }

    @Step("Is Sign In button displayed")
    public boolean isSignInButtonDisplayed() {
        return driver.findElement(signInButton).isDisplayed();
    }

}
