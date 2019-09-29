package com.heat.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.heat.testBase.TestBase;

public class LoginPage {
	
	public static WebDriver driver;

	// Login Page Constructor with Driver to connect to TestBase driver.
	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	private static String nmusernametxt = "Username";
	private static String nmpasswordtxt = "Password";
	private static String nmloginbtn = "Sign In Button";
	private static String nmforgotpasslnk ="Forgot Password?";
	private static String nmpasswordError= "Access Denied.";
	
	static By usernametxt = By.id("UserName");
	public static void IsUserAbletoEnterUserName(String uname) {
		
		TestBase.IsElementVisible(LoginPage.driver, usernametxt, nmusernametxt);
		TestBase.EnterText(LoginPage.driver, usernametxt, uname, nmusernametxt);
	}

	static By passwordtxt = By.id("Password");
	public static void IsUserAbletoEnterPassword(String pass) {
		TestBase.IsElementVisible(LoginPage.driver, passwordtxt, nmpasswordtxt);
		TestBase.EnterText(LoginPage.driver, passwordtxt, pass, nmpasswordtxt);
	}
	
	static By signInbtn = By.xpath("//*[@type='submit']");
	public static void IsUserAbletoClickOnLogin() {
		TestBase.IsElementVisible(LoginPage.driver, signInbtn, nmloginbtn);
		TestBase.IsElementClickable(LoginPage.driver, signInbtn, nmloginbtn);
		TestBase.waitForPageToBeReady();
	}
	
	static By accessdeniederrormsg = By.xpath("//*[@class='alert alert-danger alert-dismissable']");
	public static void IsPasswordErrormessageDisplayed() {
		TestBase.IsElementVisible(LoginPage.driver, accessdeniederrormsg, nmpasswordError);
		TestBase.IsElementPresent(LoginPage.driver, accessdeniederrormsg, nmpasswordError);
		TestBase.waitForPageToBeReady();
	}

	public static void IsUsernameErrorMessageDisplayed() {
		TestBase.IsElementVisible(LoginPage.driver, accessdeniederrormsg, nmpasswordError);
		TestBase.IsElementPresent(LoginPage.driver, accessdeniederrormsg, nmpasswordError);
		TestBase.waitForPageToBeReady();
	}

	static By forgotpasslnk = By.xpath("//*[contains(text(),'Forgot Password?')]");
	public static void IsForgotPasswordLinkDisplayed() {
     TestBase.IsElementVisible(LoginPage.driver, forgotpasslnk, nmforgotpasslnk);
		
	}
}