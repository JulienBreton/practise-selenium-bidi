package org.julienbreton.testscripts;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.bidi.browsingcontext.CreateContextParameters;
//import org.julienbreton.pages.PageContextUser;
import org.openqa.selenium.bidi.browsingcontext.Locator;
import org.openqa.selenium.bidi.browsingcontext.ReadinessState;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.bidi.module.Input;
import org.openqa.selenium.bidi.script.NodeProperties;
import org.openqa.selenium.bidi.script.RemoteValue;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class BidiUserContextTest extends TestBase {

	/*
	 * public void canSwitchToBlue() {
	 * 
	 * String defaultBackgroundColor = "rgb(255, 255, 255)"; String
	 * backgroundColorBlue = "rgb(173, 216, 230)";
	 * 
	 * PageContextUser pageContextUser = new PageContextUser(getDriver());
	 * 
	 * getContext().navigate(
	 * "https://www.selenium.dev/selenium/web/cookie-background.html",
	 * ReadinessState.COMPLETE);
	 * 
	 * // Background color is white
	 * Assert.assertEquals(pageContextUser.getBackgroundColor(),
	 * defaultBackgroundColor);
	 * 
	 * pageContextUser = new PageContextUser(getDriver()).open();
	 * 
	 * pageContextUser.setBackgroundColorBlue();
	 * 
	 * // Background color is blue
	 * Assert.assertEquals(pageContextUser.getBackgroundColor(),
	 * backgroundColorBlue);
	 * 
	 * System.out.println(Thread.currentThread().getName() + " " +
	 * Thread.currentThread().getStackTrace()[1].getMethodName() +
	 * " => executed successfully"); }
	 * 
	 * public void canSwitchToGreen() {
	 * 
	 * String defaultBackgroundColor = "rgb(255, 255, 255)"; String
	 * backgroundColorGreen = "rgb(144, 238, 144)";
	 * 
	 * PageContextUser pageContextUser = new PageContextUser(getDriver());
	 * 
	 * getContext().navigate(
	 * "https://www.selenium.dev/selenium/web/cookie-background.html",
	 * ReadinessState.COMPLETE);
	 * 
	 * // Background color is white
	 * Assert.assertEquals(pageContextUser.getBackgroundColor(),
	 * defaultBackgroundColor);
	 * 
	 * pageContextUser.setBackgroundColorGreen();
	 * 
	 * // Background color is green
	 * Assert.assertEquals(pageContextUser.getBackgroundColor(),
	 * backgroundColorGreen);
	 * 
	 * System.out.println(Thread.currentThread().getName() + " " +
	 * Thread.currentThread().getStackTrace()[1].getMethodName() +
	 * " => executed successfully"); }
	 */

	private static BrowsingContext context;

	private static BrowsingContext getContext() {
		return context;
	}

	@BeforeMethod
	public void beforeMethod() {
		Browser bidiBrowser = new Browser(getDriver());
		String userContext = bidiBrowser.createUserContext();

		CreateContextParameters parameters = new CreateContextParameters(WindowType.TAB);
		parameters.userContext(userContext);

		context = new BrowsingContext(getDriver(), parameters);
	}

	public void canSwitchToBlue() {
		getContext().navigate("https://www.selenium.dev/selenium/web/cookie-background.html", ReadinessState.COMPLETE);

		RemoteValue value = getContext().locateNode(Locator.xpath("/html/body/button[1]"));

		Input inputModule = new Input(getDriver());
		Actions actions = new Actions(getDriver());

		RemoteWebElement element = new RemoteWebElement();
		element.setId(value.getSharedId().get());
		actions.moveToElement(element).click();

		inputModule.perform(getContext().getId(), actions.getSequences());

		value = getContext().locateNode(Locator.xpath("/html/body"));

		NodeProperties properties = (NodeProperties) value.getValue().get();
		String bgColor = properties.getAttributes().get().get("style");

		Assert.assertEquals(bgColor, "background-color: lightblue;");
		System.out.println(Thread.currentThread().getName() + " "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " => executed successfully");
	}

	public void canSwitchToGreen() {
		getContext().navigate("https://www.selenium.dev/selenium/web/cookie-background.html", ReadinessState.COMPLETE);

		RemoteValue value = getContext().locateNode(Locator.xpath("/html/body"));

		NodeProperties properties = (NodeProperties) value.getValue().get();
		String bgColor = properties.getAttributes().get().get("style");

		Assert.assertEquals(bgColor, "background-color: white;");

		value = getContext().locateNode(Locator.xpath("/html/body/button[2]"));

		Input inputModule = new Input(getDriver());
		Actions actions = new Actions(getDriver());

		RemoteWebElement element = new RemoteWebElement();
		element.setId(value.getSharedId().get());
		actions.moveToElement(element).click();

		inputModule.perform(getContext().getId(), actions.getSequences());

		value = getContext().locateNode(Locator.xpath("/html/body"));

		properties = (NodeProperties) value.getValue().get();
		bgColor = properties.getAttributes().get().get("style");

		Assert.assertEquals(bgColor, "background-color: lightgreen;");
		System.out.println(Thread.currentThread().getName() + " "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " => executed successfully");
	}

	public void canHaveTheDefaultBackgroundColor() {
		getContext().navigate("https://www.selenium.dev/selenium/web/cookie-background.html", ReadinessState.COMPLETE);

		RemoteValue value = getContext().locateNode(Locator.xpath("/html/body"));

		NodeProperties properties = (NodeProperties) value.getValue().get();
		String bgColor = properties.getAttributes().get().get("style");

		Assert.assertEquals(bgColor, "background-color: white;");
		System.out.println(Thread.currentThread().getName() + " "
				+ Thread.currentThread().getStackTrace()[1].getMethodName() + " => executed successfully");
	}

}
