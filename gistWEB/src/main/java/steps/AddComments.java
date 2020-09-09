package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;

public class AddComments extends BasePage {
	WebDriverWait wait;

	public AddComments(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	@FindBy(id = "new_comment_field")
	WebElement commentField;

	@FindBy(xpath = "//button[contains(text(),'Comment')]")
	WebElement commentButton;

	@FindBy(xpath = "//div[@class='TimelineItem js-comment-container']")
	WebElement commentAdded;

	public void addTwoComments() {
		addComment();
		wait.until(ExpectedConditions.visibilityOf(commentAdded));
		addComment();

	}

	public void addComment() {
		// TODO set comments from data provider 
		commentField.click();
		commentField.sendKeys("Fisrt comment");
		commentButton.click();
	}

}
