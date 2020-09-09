package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class EditGist extends BasePage {
	WebDriverWait wait;

	public EditGist(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	@FindBy(xpath = "//a[@class='btn btn-sm' and @aria-label='Edit this Gist']")
	WebElement editButton;

	@FindBy(xpath = "//button[@class='btn float-left js-add-gist-file']")
	WebElement addFileButton;
	@FindBy(xpath = "//div[@id='gists']//div[1]//div[1]//div[1]//input[2]")
	WebElement newFile;
	@FindBy(xpath = "//body/div/div/main/div/div/form/div/div/div/div[1]/div[2]/div[1]/div[5]")
	WebElement descriptionNewFile;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement updateButton;
//tried to verify that system upload 2 files succsffully by locate this 2 files
	// @FindBy(xpath="//*[@class='js-gist-file-update-container
	// js-task-list-container file-box']")
	@FindBy(xpath = "//a[@class='js-selected-navigation-item UnderlineNav-item']")
	WebElement verifyFiles;
	@FindBy(className = "Counter")
	WebElement counter;

	public void addNewFile() {
		editButton.click();
		newFile.sendKeys("Add new file from Edit Screen");
		descriptionNewFile.sendKeys("Hello Java :) ");
		updateButton.click();
	}

	public void verifyTwoFiles() {
		Log.info("System should display 3 and it returns   " + counter.getText());
		counter.getText();

	}
}
