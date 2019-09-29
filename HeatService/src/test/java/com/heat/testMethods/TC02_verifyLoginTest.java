package com.heat.testMethods;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.heat.pageObjects.LoginPage;
import com.heat.testBase.TestBase;
			/**
			 * 
			 * @author Pankaj Kumar
			 *
			 */
			public class TC02_verifyLoginTest extends TestBase {
			
				// Create an Instance for Login Page
				LoginPage loginPage;
			
				public TC02_verifyLoginTest() {
					super();
				}
			
				@BeforeSuite
				public void setUp() throws InterruptedException {
					try {
						initialize();
						loginPage = new LoginPage(driver);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
                 /**
                  * test Data for test Method
                  * @return
                  */
			
				@DataProvider(name = "validLoginCredentials")
				public String[][] validUser() {
					String[][] testdata = getData("TestData.xlsx", "loginData");
					return testdata;
				}

				@DataProvider(name = "invalidpassword")
				public String[][] invalidPwd() {
					String[][] testdata = getData("TestData.xlsx", "invalidpassword");
					return testdata;
				}

				@DataProvider(name = "invalidusername")
				public String[][] invalidUserName() {
					String[][] testdata = getData("TestData.xlsx", "invalidusername");
					return testdata;
				}
				
				/**
				 * VerifyHeatServiceLoginWithValidCredentials
				 * @param uname
				 * @param password
				 */
				@Test(priority = 4, dataProvider="validLoginCredentials")
				public void TS01_VerifyHeatServiceLoginWithValidCredentials(String uname, String password) {
					test = extent.startTest("TS01_VerifyHeatServiceLoginWIthValidCredentials");
					LoginPage.IsUserAbletoEnterUserName(uname);
					LoginPage.IsUserAbletoEnterPassword(password);
					LoginPage.IsUserAbletoClickOnLogin();
				}
			
				/**
				 * VerifyHeatServicewithInvalidUsername
				 * @param uname
				 * @param password
				 * @param errormsg
				 */
				@Test(priority = 0, dataProvider="invalidusername")
				public void TS02_VerifyHeatServicewithInvalidUsername(String uname, String password, String errormsg) {
					test = extent.startTest("TS02_VerifyHeatServicewithInvalidUsername");
					LoginPage.IsUserAbletoEnterUserName(uname);
					LoginPage.IsUserAbletoEnterPassword(password);
					LoginPage.IsUserAbletoClickOnLogin();
					LoginPage.IsUsernameErrorMessageDisplayed();
				}
				
				/**
				 * VerifyHeatServicewithInvalidPassword
				 * @param uname
				 * @param password
				 * @param errormsg
				 */
				@Test(priority = 1, dataProvider="invalidpassword")
				public void TS03_VerifyHeatServicewithInvalidPassword(String uname, String password, String errormsg) {
					test = extent.startTest("TS03_VerifyHeatServicewithInvalidPassword");
					LoginPage.IsUserAbletoEnterUserName(uname);
					LoginPage.IsUserAbletoEnterPassword(password);
					LoginPage.IsUserAbletoClickOnLogin();
					LoginPage.IsPasswordErrormessageDisplayed();
					
				}
			
				/**
				 * VerifyForgotPasswordLinkClick
				 */
				@Test(priority = 2)
				public void TS04_VerifyForgotPasswordLinkClick() {
					test = extent.startTest("TS04_VerifyForgotPasswordLinkClick");
					LoginPage.IsForgotPasswordLinkDisplayed();
				}
			
				@AfterMethod
				public void takeSnapShot(ITestResult result) throws Exception {
					getResult(result);
				}
			
				@AfterTest
				public void quit() {
					driver.close();
					extent.flush();
					extent.close();
					System.out.println("End");
				}
			}
