package com.heat.pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import com.heat.testBase.TestBase;

public class NetworkPortPage {
	WebDriver driver;

	public NetworkPortPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	//Objects for NetworkPort Data Ref Title
	By dataRefTitle = By.xpath("//*[@data-ref ='titleEl' and @class='title']");
	public WebElement getDataRefTitle() {
		return driver.findElement(dataRefTitle);
	}

	//Objects for Service Required  as Staff
    By staffRequired = By.xpath("//input[@id='combo-1467-inputEl']");

	public Object getStaff(String Staff) {
		 
		   //Javascript command
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   return js.executeScript("arguments[0].value='"+Staff+"';", driver.findElement(staffRequired));
		
	}
	/*public void enterStaffInput(String staffServiceRequired) {
		driver.findElement(serviceRequiredInput).clear();
		driver.findElement(serviceRequiredInput).sendKeys(staffServiceRequired);
	}*/
	
//Objects for Service Required by A Staff
	By serviceRequiredInput = By.xpath("//span[text()='Service Required:']//following::input[1]");
	
     public void enterServiceRequiredInput(String inputServiceRequiredText) {
		driver.findElement(serviceRequiredInput).clear();
		driver.findElement(serviceRequiredInput).sendKeys(inputServiceRequiredText);
	}
	//Objects for Summary Of request
     By summaryOfRequestText = By.xpath("//span[text()='Summary of Request:']//following::input[1]");
 	
     public void enterServiceRequestInput(String inputSummaryOfRequestText) {
		driver.findElement(summaryOfRequestText).clear();
		driver.findElement(summaryOfRequestText).sendKeys(inputSummaryOfRequestText);
	}
	//Objects for Description
     By descriptionInput = By.xpath("//span[text()='Description:']//following::textarea[1]");
 	
     public void enterDescriptionInput(String inputDescriptionText) {
		driver.findElement(descriptionInput).clear();
		driver.findElement(descriptionInput).sendKeys(inputDescriptionText);
	}
	
//Objects for Location on Campus
	By locationOnCampusInput = By.xpath("//span[text() = 'Location on Campus:']//following::input[1]");//input[@id='textfield-1454-inputEl
	
	public void enterLocationOfCampus(String inputLocationOnServiceText) {
		driver.findElement(locationOnCampusInput).clear();
		driver.findElement(locationOnCampusInput).sendKeys(inputLocationOnServiceText);
	}
	//Objects for Budget Code on Staff service required
		By budgetCodeInput = By.xpath("//span[text() = 'Budget Code:']//following::input[1]");//input[@id='textfield-1457-inputEl']
		
		public void enterBudgetCodeText(String inputBudgetCodeText) {
			driver.findElement(budgetCodeInput).clear();
			driver.findElement(budgetCodeInput).sendKeys(inputBudgetCodeText);
		}	
		
		//Objects for Number of Ports Required on Staff service required
				By numberOfPortsReqInput = By.xpath("//span[text() = 'Number of ports required:']//following::input[1]");
				
				public void enterNoOfPortsReqText(String numberOfPortsReqText) {
					driver.findElement(numberOfPortsReqInput).clear();
					driver.findElement(numberOfPortsReqInput).sendKeys(numberOfPortsReqText);	
	}
				//textarea[@id='textarea-1461-inputEl']
				
				//Objects for Purpose on Staff service required
				By purposeDesOnServiceReqInput = By.xpath("//span[text() = 'Purpose?:']//following::div[3]/textarea");
				
				public void enterPurposeOfDesText(String purposeOfDesText) {
					driver.findElement(purposeDesOnServiceReqInput).clear();
					driver.findElement(purposeDesOnServiceReqInput).sendKeys(purposeOfDesText);	
	}
				
				//span[@id='button-1413-btnInnerEl']
				By reviewAndSubmitBtn = By.xpath("//*[text()='Review & Submit']");

				public void clickReviewAndSubmitBtn() {
					driver.findElement(reviewAndSubmitBtn).isDisplayed();
					driver.findElement(reviewAndSubmitBtn).isEnabled();
					driver.findElement(reviewAndSubmitBtn).click();
				}
				
				By submitBtn = By.xpath("//*[text()='Submit']");
				public void clickSubmitBtn() {
					driver.findElement(submitBtn).isDisplayed();
					driver.findElement(submitBtn).isEnabled();
					driver.findElement(submitBtn).click();
				}
				//Objects for return a service Catalog Button

	  By requestAServiceCatalogBtn = By.xpath("//*[text() ='Return to Service Catalog']");
	  public void clickReturnAServiceBtn() {
		  driver.findElement(requestAServiceCatalogBtn).isDisplayed();
           driver.findElement(requestAServiceCatalogBtn).isEnabled();
		  driver.findElement(requestAServiceCatalogBtn).click();		
	  }
		//Objects for  Ports Number Required on Staff service required
		By portNumberInput = By.xpath("//span[text() = 'Port Number:']//following::input[1]");
		
		public void enterPortNumberText(String numberOfPorts) {
			driver.findElement(portNumberInput).clear();
			driver.findElement(portNumberInput).sendKeys(numberOfPorts);	
}
		//Objects for Details 
		By detailsInput = By.xpath("//span[text() = 'Details:']//following::div[3]/textarea");
		
		public void enterDetailsText(String detailsText) {
			driver.findElement(detailsInput).clear();
			driver.findElement(detailsInput).sendKeys(detailsText);		}
		
		//Objects for Budget Code 
				By budgetCodeID = By.xpath("//span[text()='Budget Code:']//following::div[3]/input");
				
				public void enterBudgetCodeNo(String budgetCode) {
					driver.findElement(budgetCodeID).clear();
					driver.findElement(budgetCodeID).sendKeys(budgetCode);		}
		
		//Objects for Line Manager
				By getLineManager = By.xpath("//*[contains(text(),'Are you')]//following::div[3]/input");
				
				public void enterLineManager(String lineManager) {
					driver.findElement(getLineManager).clear();
					driver.findElement(getLineManager).sendKeys(lineManager);	
				}
		//Objects for UserName
				By getUserName = By.xpath("//*[contains(text(),'Username')]//following::div[3]/input");
				
				public void enterUserName(String userNameText) {
					driver.findElement(getUserName).clear();
                    driver.findElement(getUserName).sendKeys(userNameText);
				}
		//Objects for Department
				
			By getDepartment = By.xpath("//*[contains(text(),'Department')]//following::div[3]/input");
			
			public void enterDepartment(String departmentText) {
				driver.findElement(getDepartment).clear();
				driver.findElement(getDepartment).sendKeys(departmentText);}
			
		//Objects for Current Fob Details
			By getCurrentFob = By.xpath("//*[contains(text(),'fob details')]//following::div[3]/textarea");
			
			public void enterCurrentFob(String fobDetails) {
				driver.findElement(getCurrentFob).clear();
                driver.findElement(getCurrentFob).sendKeys(fobDetails);
			}
			
		//Objects for Location on Campus
			By getLocation = By.xpath("//*[contains(text(),'Location')]//following::div[8]/input");
			
			public void enterLocation(String locationInCampus) {
				driver.findElement(getLocation).clear();
                 driver.findElement(getLocation).sendKeys(locationInCampus);
			}
		//Objects for Device Type
			
           By getDeviceType = By.xpath("//*[contains(text(),'Device Type')]//following::div[3]/input");
			
			public void enterDeviceType(String deviceType) {
				driver.findElement(getDeviceType).clear();
                 driver.findElement(getDeviceType).sendKeys(deviceType);
			}
		//Objects for Mac Address

	     By getMACAddress= By.xpath("//*[contains(text(),'MAC')]//following::div[11]/input");
				
				public void enterMacAddress(String macAddress) {
					driver.findElement(getMACAddress).clear();
	                 driver.findElement(getMACAddress).sendKeys(macAddress);
				}
				
		//Objects for Terms And Condition
			
		 By getTermsAndCond = By.xpath("//*[contains(text(),'I have read')]//following::div[2]/div/input");
			 
			 public void enterTermsAndCondition(String termsAndConditionText) {
				 driver.findElement(getTermsAndCond).clear();
				 driver.findElement(getTermsAndCond).sendKeys(termsAndConditionText);
		 }
}







