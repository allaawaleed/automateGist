package steps;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class RemoveLastComment extends BasePage {
	WebDriverWait wait;

	public RemoveLastComment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	@FindBy(xpath = "//*[@class='timeline-comment-actions flex-shrink-0']")
	List<WebElement> actionList;

	@FindBy(xpath = "//*[@type='submit' and @aria-label='Delete comment']")
	// WebElement deleteComment;
	WebElement deleteComment;

	public void removeLAstComment() {

		// Locate option in the last comment
		WebElement lastCommentOption = actionList.get(actionList.size() - 1);
		lastCommentOption.click();
		// wait until system displays list of action to click on delete
		wait.until(ExpectedConditions.visibilityOf(deleteComment));
		deleteComment.click();
		// Confirm in the alert after clicking on "Delete" button
		Alert acceptAlert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());

		acceptAlert.accept();
		Log.info("System delete last comment");
	}
}
