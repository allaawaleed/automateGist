package Utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected static Logger log;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void waitForVisabilty(By locator, int time) {
		final WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	protected static void setTextElementText(WebElement textElement, String value) {
		textElement.sendKeys(value);
	}

	public boolean waitForInVisabilty(By locator, int time) {
		final WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

}
