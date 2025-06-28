package org.julienbreton.testscripts;

import org.julienbreton.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ToolshopTest extends TestBase {

	public void verifySignInButton() {
		HomePage homePage = new HomePage(getDriver())
				.open();
		Assert.assertTrue(homePage.isSignInButtonDisplayed());
	}

	public void verifySignInButton_failOnPurpose() {
		HomePage homePage = new HomePage(getDriver())	
				.open();
		Assert.assertFalse(homePage.isSignInButtonDisplayed());
	}
}
