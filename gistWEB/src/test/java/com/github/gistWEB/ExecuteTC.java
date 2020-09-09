package com.github.gistWEB;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Data.LoadProperties;
import Utilities.Log;
import steps.AddComments;
import steps.CreateGist;
import steps.EditGist;
import steps.Login;
import steps.RemoveLastComment;

public class ExecuteTC {
	WebDriver driver;
	Login objLogin;
	CreateGist objCreate;
	EditGist objEdit;
	AddComments objComment;
	RemoveLastComment objRemove;
	String email = LoadProperties.userData.getProperty("setEmail");
	String password = LoadProperties.userData.getProperty("setPassword");

	@BeforeSuite
	public void setup() throws InterruptedException {
		Log.info("------ Launch browser ------");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://github.com/");
		// driver.manage().window().maximize();
	}

	@BeforeMethod
	public void startNewTestCase() {
		Log.info("--------------------------New Test Case-------------------------------");
	}

	@AfterMethod
	public void endTestCase() {
		Log.info("------------------Test Case Execution DONE-----------------------");
	}

	@Test(priority = 1, description = "Verify that system open homepage sucessfully without login")

	public void verifyHomeScreen() throws InterruptedException {
		Log.info("Verify that system open homepage sucessfully without login");
		objLogin = new Login(driver);
		// Click on The Sign In Button
		objLogin.ClickOnSignIn();
		Assert.assertTrue(objLogin.SignInDisplay());
		Log.info("System assert that Sign form is returing with: ->>>>>" + objLogin.SignInDisplay());

	}

	@Test(priority = 2, description = "Verify that user logged in successfully")

	public void verifyLogin() throws InterruptedException {
		Log.info("Verify that user logged in successfully");
		Log.info("Login Test Case");
		objLogin = new Login(driver);
		objLogin.enterEmailandPassowrd(email, password);
		Assert.assertTrue(objLogin.devHeaderDisplay());
		Log.info("System asserts user logged in successfully and dev header is displaying: ->>>>>"
				+ objLogin.devHeaderDisplay());
	}

	@Test(priority = 3, description = "Create new public gist")

	public void createNewGist() throws InterruptedException {
		Log.info("Create nrw public gist ");
		objCreate = new CreateGist(driver);
		objCreate.createGist();
		Assert.assertTrue(objCreate.createdGistDisplay());
		Log.info("System asserts that gist created sucssuflly and displaying: ->>>>>" + objCreate.createdGistDisplay());
	}

	@Test(priority = 4, description = "Edit gist and add new file")

	public void addNewFile() throws InterruptedException {
		Log.info("Create nrw public gist ");
		objEdit = new EditGist(driver);
		objEdit.addNewFile();
		// TODO
		// Assert.assertTrue(objEdit.verifyTwoFiles());
		// Log.info("System asserts that gist created sucssuflly and displaying: ->>>>>"
		// + objCreate.createdGistDisplay());
	}

	@Test(priority = 5, description = "Add 2 comments")

	public void addComment() throws InterruptedException {
		Log.info("Add new comments ");
		objComment = new AddComments(driver);
		objComment.addTwoComments();

	}

	@Test(priority = 6, description = "Remove the last comment")

	public void removeLastComment() throws InterruptedException {
		Log.info("Remove the last comment");
		objRemove = new RemoveLastComment(driver);
		objRemove.removeLAstComment();

	}

	@AfterClass
	public void CloseBrowser() {

		driver.quit();
	}
}
