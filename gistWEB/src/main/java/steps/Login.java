package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class Login extends BasePage {
	WebDriverWait wait;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	@FindBy(xpath = "//a[@href='/login']")
	WebElement LoginButton;

	@FindBy(className = "auth-form-header")
	WebElement signinForm;

	@FindBy(name = "login")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "commit")
	WebElement signinButton;

	// @FindBy(tagName="//details[@class='details-overlay details-reset']")
	@FindBy(tagName = "nav")
	WebElement header;

	public void ClickOnSignIn() {
		waitForVisabilty(By.xpath("//a[@href='/login']"), 5);
		WebElement checkLogin = wait.until(ExpectedConditions.visibilityOf(LoginButton));
		if (checkLogin != null) {
			Log.info("System found that login button displayed and returns it with     " + checkLogin.isDisplayed());
			Log.info("System can locate login button and text is: " + LoginButton.getText());
			LoginButton.click();
		} else {
			Log.info("System couldn't locate Login Button");
		}

	}

	public void enterEmailandPassowrd(String setEmail, String setPassword) {
		wait.until(ExpectedConditions.visibilityOf(signinForm));
		Log.info("System open Login page and title is:   " + signinForm.getText());
		// TODO implement Data Driven use JSON
		// email.sendKeys(jsonObject.getJsonValue("email"));
		setTextElementText(email, setEmail);
		setTextElementText(password, setPassword);
		signinButton.click();
		wait.until(ExpectedConditions.visibilityOf(header));

	}

	public boolean SignInDisplay() {
		return signinForm.isDisplayed();
	}

	public boolean devHeaderDisplay() {
		return header.isDisplayed();

	}
}
