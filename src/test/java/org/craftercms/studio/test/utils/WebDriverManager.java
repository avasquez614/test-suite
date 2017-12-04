package org.craftercms.studio.test.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class WebDriverManager {
	WebDriver driver;
	private ConstantsPropertiesManager constantsPropertiesManager;
	private int defaultTimeOut;

	public void openConnection() {

		final Properties runtimeProperties = new Properties();
		try {
			runtimeProperties.load(WebDriverManager.class.getResourceAsStream("/runtime.properties"));
			String enviromentPropertiesPath = runtimeProperties.getProperty("crafter.test.location");
			final Properties envProperties = new Properties();
			try {
				envProperties.load(new FileInputStream(enviromentPropertiesPath));
				String webBrowserProperty = envProperties.getProperty("webBrowser");
				DesiredCapabilities capabilities;
				switch (webBrowserProperty.toLowerCase()) {
				case "phantomjs":
					capabilities = DesiredCapabilities.phantomjs();
					System.setProperty("phantomjs.binary.path", envProperties.getProperty("phantomjs.binary.path"));
					driver = new PhantomJSDriver(capabilities);
					break;
				case "firefox":
					capabilities = DesiredCapabilities.firefox();
					// capabilities.setCapability("marionette", true);
					System.setProperty("webdriver.gecko.driver", envProperties.getProperty("firefox.driver.path"));
					driver = new FirefoxDriver(capabilities);
					break;
				case "edge":
					capabilities = DesiredCapabilities.edge();
					System.setProperty("webdriver.edge.driver", envProperties.getProperty("edge.driver.path"));
					EdgeOptions options = new EdgeOptions();
					options.setPageLoadStrategy("eager");
					driver = new EdgeDriver();
					break;
				case "ie":
					capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
					System.setProperty("webdriver.ie.driver", envProperties.getProperty("ie.driver.path"));
					driver = new InternetExplorerDriver(capabilities);
					break;
				case "chrome":
					capabilities = DesiredCapabilities.chrome();
					System.setProperty("webdriver.chrome.driver", envProperties.getProperty("chrome.driver.path"));
					driver = new ChromeDriver(capabilities);
					break;
				default:
					throw new IllegalArgumentException(
							"webBrowser property is needed, valid values are:" + "chrome,edge,ie,firefox,phantomjs");
				}

				driver.get(envProperties.getProperty("baseUrl"));
				this.defaultTimeOut = Integer.parseInt(
						constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

				if (!webBrowserProperty.equalsIgnoreCase("firefox")) {
					this.maximizeWindow();
				}

			} catch (IOException ex) {
				throw new FileNotFoundException("Unable to read runtime properties file");
			}
		} catch (IOException ex) {
			throw new TestException("Required Files are not found.");
		}

	}

	public void closeConnection() {
		// this.driver.close();
		this.driver.quit();
	}

	public void maximizeWindow() {
		// Getting the size width and height
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int) toolkit.getScreenSize().getWidth();
		int height = (int) toolkit.getScreenSize().getHeight();
		// locating webdriver at coordinate 0,0
		this.driver.manage().window().setPosition(new Point(0, 0));
		// maximize the window at normal size
		// this.driver.manage().window().maximize();
		// //scaling to full screen
		this.driver.manage().window().setSize(new Dimension(width, height));

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement driverWaitUntilElementIsPresentAndDisplayed(String typeOfSelector, String selectorValue) {
		WebElement element = null;

		switch (typeOfSelector.toLowerCase()) {
		case "cssselector":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectorValue)))))
				element = this.driver.findElement(By.cssSelector(selectorValue));

			break;
		case "xpath":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorValue)))))
				element = this.driver.findElement(By.xpath(selectorValue));
			break;
		case "id":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.id(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.id(selectorValue)))))
				element = this.driver.findElement(By.id(selectorValue));
			break;
		case "classname":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.className(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.className(selectorValue)))))
				element = this.driver.findElement(By.className(selectorValue));
			break;
		case "tagname":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.tagName(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.tagName(selectorValue)))))
				element = this.driver.findElement(By.tagName(selectorValue));
			break;
		case "linktext":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.linkText(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.linkText(selectorValue)))))
				element = this.driver.findElement(By.linkText(selectorValue));
			break;
		case "partialLinktext":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(ExpectedConditions
					.and(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(selectorValue)))))
				element = this.driver.findElement(By.partialLinkText(selectorValue));
			break;
		case "name":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.name(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.name(selectorValue)))))
				element = this.driver.findElement(By.name(selectorValue));
			break;
		default:
			throw new IllegalArgumentException("selectortype is needed, valid values are:"
					+ "xpath,cssselector,id,tagname,classname,linktext,partiallinkText,name");
		}
		return element;
	}

	public WebElement driverWaitUntilElementIsPresentAndDisplayedAndClickable(String typeOfSelector,
			String selectorValue) {
		WebElement element = null;

		switch (typeOfSelector.toLowerCase()) {
		case "cssselector":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectorValue)),
							ExpectedConditions.elementToBeClickable(By.cssSelector(selectorValue)))))
				element = this.driver.findElement(By.cssSelector(selectorValue));
			
			break;
		case "xpath":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorValue)),
							ExpectedConditions.elementToBeClickable(By.xpath(selectorValue)))))
				element = this.driver.findElement(By.xpath(selectorValue));
			break;
		case "id":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.id(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.id(selectorValue)),
							ExpectedConditions.elementToBeClickable(By.id(selectorValue)))))
				element = this.driver.findElement(By.id(selectorValue));
			break;
		case "classname":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.className(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.className(selectorValue)),
							ExpectedConditions.elementToBeClickable(By.className(selectorValue)))))
				element = this.driver.findElement(By.className(selectorValue));
			break;
		case "tagname":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.tagName(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.tagName(selectorValue)),
							ExpectedConditions.elementToBeClickable(By.tagName(selectorValue)))))
				element = this.driver.findElement(By.tagName(selectorValue));
			break;
		case "linktext":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.linkText(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.linkText(selectorValue)),
							ExpectedConditions.elementToBeClickable(By.linkText(selectorValue)))))
				element = this.driver.findElement(By.linkText(selectorValue));
			break;
		case "partialLinktext":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut)).until(ExpectedConditions
					.and(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(selectorValue)),
							ExpectedConditions.elementToBeClickable(By.partialLinkText(selectorValue)))))
				element = this.driver.findElement(By.partialLinkText(selectorValue));
			break;
		case "name":
			if ((new WebDriverWait(this.driver, this.defaultTimeOut))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.name(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.name(selectorValue)),
							ExpectedConditions.elementToBeClickable(By.name(selectorValue)))))
				element = this.driver.findElement(By.name(selectorValue));
			break;
		default:
			throw new IllegalArgumentException("selectortype is needed, valid values are:"
					+ "xpath,cssselector,id,tagname,classname,linktext,partiallinkText,name");
		}
		return element;
	}

	public void dragAndDropElement(WebElement fromWebElement, WebElement toWebElement) {
		// Creating an actions builder
		Actions builder = new Actions(this.getDriver());

		// Creating the action for click and hold from the origin web element
		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement)
				.build();

		// commit the actions above
		dragAndDrop.perform();
	}

	public boolean isElementPresentByXpath(String xpathOfTheElement) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayed("xpath", xpathOfTheElement);
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentAndClickableByXpath(String xpathOfTheElement) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					xpathOfTheElement);
			// this.getDriver().findElement(By.xpath(xpathOfTheElement));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentById(String id) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayed("id", id);
			// this.getDriver().findElement(By.xpath(xpathOfTheElement));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentAndClickableByName(String name) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayedAndClickable("name", name);
			// this.getDriver().findElement(By.xpath(xpathOfTheElement));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentAndClickableById(String id) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", id);
			// this.getDriver().findElement(By.xpath(xpathOfTheElement));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentBycssSelector(String cssSelector) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", cssSelector);
			// this.getDriver().findElement(By.cssSelector(cssSelector));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentAndClickableBycssSelector(String cssSelector) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayedAndClickable("cssSelector",
					cssSelector);
			// this.getDriver().findElement(By.cssSelector(cssSelector));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public void contextClick(WebDriver driver, WebElement element, Boolean executeThroughJavaScript) {
		if (executeThroughJavaScript) {
			String script = "var element = arguments[0];" + "var event = document.createEvent('HTMLEvents');"
					+ "event.initEvent('contextmenu', true, false);" + "element.dispatchEvent(event);";
			((JavascriptExecutor) driver).executeScript(script, new Object[] { element });
		} else {
			(new Actions(driver)).contextClick(element).build().perform();
		}
	}

	public void scrollUp() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
	}

	public void scrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,2000)");
	}

	public ConstantsPropertiesManager getConstantsPropertiesManager() {
		return constantsPropertiesManager;
	}

	public void setConstantsPropertiesManager(ConstantsPropertiesManager constantsPropertiesManager) {
		this.constantsPropertiesManager = constantsPropertiesManager;
	}

	public boolean elementHasChildsByXPath(String childsLocator) {
		boolean hasChilds = false;
		List<WebElement> childs = this.driver.findElements(By.xpath(childsLocator));

		if (!(childs.isEmpty()))
			hasChilds = true;

		return hasChilds;
	}

	public void moveMouseToElement(WebElement toElement) {
		// Creating an actions builder
		Actions builder = new Actions(this.getDriver());
		// Creating the action for click and hold from the origin web element
		Action action = builder.moveToElement(toElement).build();

		// commit the actions above
		action.perform();
	}

	public void waitWhileElementIsDisplayedAndClickableByXpath(String xpath) {
		Boolean isPresent = this.isElementPresentAndClickableByXpath(xpath);

		while (!isPresent) {
			isPresent = this.isElementPresentAndClickableByXpath(xpath);
		}
	}

	public void waitWhileElementIsPresentByXpath(String xpath) {
		Boolean isPresent = this.isElementPresentByXpath(xpath);

		while (!isPresent) {
			try {
				this.getDriver().findElement(By.xpath(xpath));
				isPresent = true;
			} catch (NoSuchElementException e) {
				isPresent = false;
			} catch (Exception e) {
				isPresent = false;
			}
		}
	}

	public void waitWhileElementIsNotDisplayedByXpath(String xpath) {
		Boolean isPresent = this.isElementPresentAndClickableByXpath(xpath);

		while (isPresent) {
			isPresent = this.isElementPresentAndClickableByXpath(xpath);
			this.getDriver().navigate().refresh();
		}
	}

	public void waitUntilPageLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		
		Boolean isLoaded = new WebDriverWait(this.driver, this.defaultTimeOut).until(expectation);
		while(!isLoaded){
			isLoaded = new WebDriverWait(this.driver, this.defaultTimeOut).until(expectation);
		}

	}

	public void waitForPageLoad(WebDriver driver) {
		Boolean pageIsReady = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		
		while (!pageIsReady){
		 pageIsReady =
		            ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		}
	}

}