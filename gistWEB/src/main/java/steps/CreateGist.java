package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class CreateGist extends BasePage {
	WebDriverWait wait;

	public CreateGist(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
	}

	@FindBy(xpath = "//div[contains(@class,'Header-item position-relative d-none d-md-flex')]")
	WebElement plusButton;

	@FindBy(xpath = "//a[contains(text(),'New gist')]")
	WebElement createGistButton;

	@FindBy(xpath = "//div[@class='container-lg px-3']")
	WebElement gistTitle;

	// @FindBy(xpath = "//input[@placeholder='Filename including extension…']")
	@FindBy(name = "gist[description]")
	WebElement gistDiscreption;
	@FindBy(name = "gist[contents][][name]")
	WebElement fileName;

	// @FindBy(className = "CodeMirror-sizer")
	@FindBy(xpath = "//div[@role='presentation']")
	WebElement clicktowrite;

	@FindBy(xpath = "//div[@class='CodeMirror-code' and @contenteditable='true']")
	WebElement writeCode;

	@FindBy(xpath = "//summary[@class='btn btn-primary BtnGroup-item select-menu-button float-none']")
	WebElement changeToPublic;

	@FindBy(xpath = "//label[2]//div[1]")
	WebElement publicGistButton;

	@FindBy(xpath = "//button[contains(text(),'Create public gist')]")
	WebElement createPublicGistButton;

	@FindBy(xpath = "//div[@class='gisthead pagehead bg-gray-light pb-0 pt-3 mb-4']")
	WebElement createdGistHeader;

	@FindBy(xpath = "//div[@class='note m-0']")
	WebElement createdTime;

	public void createGist() {
		plusButton.click();
		waitForVisabilty(By.tagName("details-menu"), 3);
		Log.info("System displays list and can locate: " + createGistButton.getText());
		createGistButton.click();
		wait.until(ExpectedConditions.visibilityOf(gistTitle));
		if (gistTitle.isDisplayed()) {
			Log.info("System should start now to enter requried data");
			Log.info("--------------");
			enterRequriedDatat();
			wait.until(ExpectedConditions.visibilityOf(publicGistButton));
			if (publicGistButton.isDisplayed()) {
				publicGistButton.click();
				wait.until(ExpectedConditions.visibilityOf(createPublicGistButton));
				Log.info("System change button to: " + createPublicGistButton.getText());
				createPublicGistButton.click();
				wait.until(ExpectedConditions.visibilityOf(createdGistHeader));
				Log.info("System created gist successfully and time from: " + createdTime.getText());
			} else {
				Log.info("System change it to public");

			}
		} else {
			Log.info("System couldn't locate gist Tile");
		}
	}

	public boolean createdGistDisplay() {
		return createdTime.isDisplayed();
	}

	public void enterRequriedDatat() {
		Log.info("System navigates successfully to create gist and title is: " + gistTitle.getText());
		gistDiscreption.click();
		gistDiscreption.sendKeys("Create new gist automated by java");
		// fileName.click();
		fileName.sendKeys("First gist file");
		clicktowrite.click();
		writeCode.sendKeys("hello world");
		changeToPublic.click();
	}

}
