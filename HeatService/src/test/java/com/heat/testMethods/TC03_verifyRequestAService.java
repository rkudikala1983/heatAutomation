/*package com.heat.testMethods;

     import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
	 import org.testng.annotations.DataProvider;
	 import org.testng.annotations.Test;
	 import com.heat.pageObjects.LoginPage;
import com.heat.pageObjects.NetworkPortPage;
import com.heat.pageObjects.RequestAServicePage;
import com.heat.testBase.TestBase;


	 public class TC03_verifyRequestAService extends TestBase  {
	 	LoginPage loginPage;
	 	RequestAServicePage requestAService;
	 	NetworkPortPage networkPortPage;
	 	public  String requestGenericServiceId;

	 	// SerpPage serpPage;
	 	public TC03_verifyRequestAService() {

	 		super();
	 	}

	 	@DataProvider(name = "loginData")
	 	public String[][] loginData() {
	 		String[][] testdata = getData("TestData.xlsx", "loginData");
	 		return testdata;
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

	 	@Test(enabled = true, priority = 1, dataProvider = "loginData")
	 	public void requestAService( String username,String password,String selfServiceText,String pageTitle,String mainPage,String genericService,String inputSummaryOfRequestText,String inputDescriptionText,String sysUser,String compuLocation,String nameofOffice,String typeOfComputer,String computerNo) throws InterruptedException {
	 		
	 		try {
	 			test.log(Status.PASS, "***************TC002 Verify request service is created****************");

	 			test.log(Status.PASS, "Enter the User name :"+ username );
	 			loginPage.EnterUserName(username);
	 			test.log(Status.PASS, "Enter the Password: "+ password);
	 			loginPage.EnterPassword(password);
	 			test.log(Status.PASS, "Clicking on Login button");
	 			loginPage.ClickOnLoginButton();
	 			waitForPageToLoad(20);
				if (loginPage.getSelfServiceText().isDisplayed()) {
					Assert.assertEquals(loginPage.getSelfServiceText().getText(), selfServiceText);
					test.log(Status.PASS, "SelfService options is displaying in the list : "
							+ loginPage.getSelfServiceText().getText() + " : Is Displayed");}
				loginPage.clickSelfService();
				loginPage.clickSelfServiceSubmitBtn();
				waitForPageToLoad(20);
	 			test.log(Status.PASS, "Title of the page " + loginPage.getTitle());
	 			waitForPageToLoad(30);
	 			test.log(Status.PASS, "Clicking on Request A Service container");
	 			loginPage.clickOnRequestARequestContainer();
	 			waitForPageToLoad(60);
	 			
	 			List<WebElement> titleCount = requestAService.getServicePlatesTitles();
	 			
	 			test.log(Status.PASS, "The Number of Service Plates Title Count is "+ titleCount.size());
	 			
	 			for(WebElement serviceTitles : titleCount) {
	 				test.log(Status.PASS, "The Service Plates Titles are : "+ serviceTitles.getText());
	 			}
	 			test.log(Status.PASS, "Clicking on Generic Service Container");
	 			requestAService.getListContainer(genericService);
	 			waitForPageToLoad(20);
	 			loginPage.clickOnRequestButton();
	 			test.log(Status.PASS, "Users have to click on Request button to go to report the issue");
	 			waitForPageToLoad(20);
	 			//
	 			test.log(Status.PASS, "Clicking in on menu Container");
	 			waitForPageToLoad(20);
	 			
	 			test.log(Status.PASS, "Enter Summary Of Request by a Staff : " + inputSummaryOfRequestText);
				networkPortPage.enterServiceRequestInput(inputSummaryOfRequestText);
				waitForPageToLoad(20);
				test.log(Status.PASS, "Enter Description of request by a Staff  : " + inputDescriptionText);//inputDescriptionText
				networkPortPage.enterDescriptionInput(inputDescriptionText);
				waitForPageToLoad(20);
	 			loginPage.selectSystemUser(sysUser);
	 			test.log(Status.PASS, "User needs to mentioned wether he is a staff/student from drop down list");
	 			waitForPageToLoad(20);
	 			loginPage.selectComputerLocation(compuLocation);
	 			test.log(Status.PASS, "Users need to mentioned the location of PC");
	 			waitForPageToLoad(20);
	 			loginPage.enterNameOfOffice(nameofOffice);
	 			test.log(Status.PASS, "Users need to mentioned in which Building he/she is located");
	 			waitForPageToLoad(20);
	 			loginPage.enterTypeOfComputer(typeOfComputer);
	 			test.log(Status.PASS, "Users have to mentioned what type of system he/she is using");
	 			loginPage.enterAssetTagNo(computerNo);
	 			test.log(Status.PASS, "Users need to mentioned PC No. which is given by the IT Staff");
	 			waitForPageToLoad(20);
	 			loginPage.clickReviewAndSubmitBtn();
	 			test.log(Status.PASS, "Clicking on Review&Submit button Once Staff/Student completed the Form");
	 			waitForPageToLoad(20);
	 			loginPage.clickSubmitBtn();
	 			test.log(Status.PASS, "Clicking on the Submit button to generate the Service Desk No.");
	 			waitForPageToLoad(40);
	 			requestGenericServiceId= loginPage.getGenericsServiceID();
	 			test.log(Status.PASS, "Generic Service ID : "+ requestGenericServiceId);
	 			
	 			String[] value = requestGenericServiceId.split(" ");
	 			System.out.println(value[3]);
	 		    String finalValue = value[2];
	 		    test.log(Status.PASS, "Capturing screenshot of the service Desk No. generated by System");
	 			getScreenShot(finalValue);
	 			test.log(Status.PASS, "Clicking on Menu Icon Container");
	 			loginPage.clickMenuContainer();
	 			waitForPageToLoad(20);
	 			test.log(Status.PASS, "Clicking on LogOut Button to logout ");
	 			loginPage.clickLogOut();
	 			//Username placeholder
	 			
	 			//String unameplaceholder = loginPage.getUserNamePlaceHolder().getAttribute("placeholder");
	 			//if (unameplaceholder.contains(usernameplaceholder)) {
	 			//	loginPage.getUserNamePlaceHolder().sendKeys(username);
				//}
	 			
	 			} catch (Exception e) {
	 			// TODO: handle exception
	 			test.log(Status.FAIL, "fail to validate login page without password Credentials");
	 			}


	 		
	 	}
	 		 
	 	
	 	@AfterSuite
	 	public void closeBrowser() {

 		//extent.endTest(test);
	 		extent.flush();
	 		
	 	}

	 }

*/