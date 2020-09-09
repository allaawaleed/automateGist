package execution;

// TODO to execute TC one by one
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilities.Log;
import steps.Login;

public class LoginTest {
	WebDriver driver;
	// protected static Logger log;

	Login objLogin;

	@BeforeSuite
//	public void openBrowser() {
//		String chromePath = System.getProperty("user.dir") + "/chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", chromePath);
//		driver = new ChromeDriver();
//		driver.get("https://github.com/");
//		driver.manage().window().maximize();
//	}
	public void setup() throws InterruptedException {
		Log.info("------ Staaart------");
		driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://github.com/");
		// driver.manage().window().maximize();
	}

	@Test(priority = 1)

	public void testSignIn() throws InterruptedException {
		// log.info("Start Login Test Case");
		objLogin = new Login(driver);
		// Click on The Sign In Button
		objLogin.ClickOnSignIn();
		// Reporter.log("Sign In");
	}

	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}
}
