package org.julienbreton.testscripts;

import org.julienbreton.pages.PageBasicAuth;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class BidiBasicAuthTest extends TestBase {

	public void verifyBasicAuth() {
		PageBasicAuth pageBasicAuth = new PageBasicAuth(getDriver())
				.open();
		String successMessage = "Congratulations! You must have the proper credentials.";	       
		Assert.assertEquals(successMessage, pageBasicAuth.isUserAuthenticated());
	}
}
