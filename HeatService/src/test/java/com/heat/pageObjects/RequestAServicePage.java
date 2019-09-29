package com.heat.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RequestAServicePage{
	WebDriver driver;

	public RequestAServicePage(WebDriver driver) {

		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Objects for Request a Service Title
	// RequesttServiceTitle = Request a Service
	By requestAServiceTitle = By.cssSelector("#dashboardWidgetHeader-1750-btnInnerEl");
	// By.xpath("//span[@id='dashboardWidgetHeader-1750-btnInnerEl']");

	public String verifyRequestAServiceTitle() {
		return driver.findElement(requestAServiceTitle).getText();
	}

	// Objects for Request a Service All Request Container

	By allRequestsContainer = By.xpath("//*[@id='dashboardWidgetHeader-1413-btnInnerEl']");

	public void clickOnRequestARequestContainer() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(allRequestsContainer);

		executor.executeScript("arguments[0].click();", element);
	}

	// Objects for AllRequests Text in Container
	By allRequestsText = By.cssSelector("#dashboardWidgetButton-1770-btnInnerEl");

	public String verifyAllRequestsText() {
		return driver.findElement(allRequestsText).getText();
	}
	// Objects to verifying Service Catalog Page under service catalog page

	By serviceCatalog = By.cssSelector("#title-1097-textEl");
	// By.xpath("//*[@id='title-1097-textEl']")

	public String verifyServiceCatalogPage() {
		return driver.findElement(serviceCatalog).getText();
	}
	// Objects for Generic Service title

	By genericService = By.xpath("//span[contains(text(),'Generic Service')]");

	public String verifyGenericServiceTitle() {
		return driver.findElement(genericService).getText();
	}

	// Objects for Generic Service Image Container
	By genericServiceImageContainer = By.xpath("//div[@id='container-1016']//li[2]");

	public void clickOnGenericServiceImageContainer() {
		driver.findElement(genericServiceImageContainer).click();
	}
	// Objects for Generic Service Request Offering
	// genericRequestOfferingText = If your enquiry relates to one of the other
	// categories, you will receive a faster response by selecting the correct
	// request offering.
	
	By listContainer= By.xpath("//*[contains(@id,\"dataview\")]/ul/li/div/div[5]/span[1]");
	
	public void getListContainer(String serviceCatalogcontainer) {
	List<WebElement> li =	driver.findElements(listContainer);
	for(WebElement options : li)
	{
		if(options.getText().trim().contains(serviceCatalogcontainer)) {
			options.click();
			break;
		}
	}
	}

	By genericServiceRequestOffering = By.cssSelector("#panel-1860-innerCt");
	// By.xpath("//div[@id='panel-1860-innerCt']");

	public String verifyGenericServiceRequestOfferingText() {
		return driver.findElement(genericServiceRequestOffering).getText();
	}
	// Objects for Request button on Generic Service Request Offering Panel

	By requestButton = By.xpath("//*[@id='button-1413-btnInnerEl']");
	// By.xpath("//span[@id='button-1862-btnInnerEl']")

	public void clickOnRequestButton() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		WebElement element = driver.findElement(requestButton);

		executor.executeScript("arguments[0].click();", element);
	}
	// Objects for Close Button on Generic Service request offering Panel

	By closeButton = By.cssSelector("#button-1863-btnInnerEl");

	// By.xpath("//span[@id='button-1863-btnInnerEl']");
	public void clickCloseButton() {
		driver.findElement(closeButton).click();
	}

	// Objects for Title Appeared on Page in Generic Service Main Page
	// GenericServicePageTitle = If your enquiry relates to one of the other
	// categories, you will receive a faster response by selecting the correct
	// request offering.
	By genericServiceCatalogPageTitle = By.cssSelector("#pagetitle-2196-descriptionEl");

	// By.xpath("//p[@id='pagetitle-2196-descriptionEl']")
	public String verifyGenericServiceCatalogPageTitle() {
		return driver.findElement(genericServiceCatalogPageTitle).getText();
	}
	// Objects for Summary Of Request Text field under Generic Service Request

	By summaryOfRequestInput = By.xpath("//*[@id='textfield-1444-inputEl']");

	public void enterSummaryOfRequestInput(String summaryOfRequest) {
		driver.findElement(summaryOfRequestInput).clear();
		driver.findElement(summaryOfRequestInput).sendKeys(summaryOfRequest);
	}
	// Objects for Description on Generic Service Request

	By description = By.xpath("//*[@id='textarea-1446-inputEl']");
	// By.xpath("//textarea[@id='textarea-2219-inputEl']");

	public void enterDescriptionInputText(String enterDescription) {
		driver.findElement(description).clear();
		driver.findElement(description).sendKeys(enterDescription);
	}
	/*
	 * //Objects for Status--------------------------------
	 * ----------------------------------------------
	 * ----------------------------------------------------
	 * 
	 * //Objects for Computer Location -------------------------
	 * -----------------------------------------------------------
	 * -----------------------------------------------------------
	 * 
	 * //Objects for Type of Computer -------------------------------
	 * -------------------------------------------------------------
	 * --------------------------------------------------------------
	 */

	// Objects for Review and Submit button

	By reviewAndSubmitBtn = By.xpath("//*[@id='button-1428-btnInnerEl']");

	public void clickReviewAndSubmitBtn() {
		driver.findElement(reviewAndSubmitBtn).isDisplayed();
		driver.findElement(reviewAndSubmitBtn).isEnabled();
		driver.findElement(reviewAndSubmitBtn).click();
	}
	// Objects for Submit button

	By submitBtn = By.xpath("//*[@id='button-1429-btnInnerEl']");
	// By.xpath("//span[@id='button-1429-btnInnerEl']");

	public void clickSubmitBtn() {
		driver.findElement(submitBtn).isDisplayed();
		driver.findElement(submitBtn).isEnabled();
		driver.findElement(submitBtn).click();
	}

	//
	By itSupportPortalText = By.xpath("//*[@id=\"box-1019\"]");

	public WebElement getTextSupportPortalPage() {
		return driver.findElement(itSupportPortalText);
	}

	

	// Objects for Staff
	By systemuser = By.id("combo-1450-inputEl");

	public void selectSystemUser(String sysUser) {
		driver.findElement(systemuser).clear();
		// new Select(driver.findElement(systemuser)).selectByVisibleText(sysUser);
		driver.findElement(systemuser).sendKeys(sysUser);
		driver.findElement(systemuser).sendKeys(Keys.TAB);
	}

	// Objects for Computer Location
	By computerLocation = By.xpath("//*[@id='combo-1454-inputEl']");

	public void selectComputerLocation(String compuLocation) {
		driver.findElement(computerLocation).clear();
		driver.findElement(computerLocation).sendKeys(compuLocation);
		driver.findElement(computerLocation).sendKeys(Keys.TAB);
	}
	
	//Objects for  Service Plate view
	
	By servicePlatesDataView = By.id("dataview-1131");
	By servicePlatesDataViewTitle = By.xpath("//*[@class='title']");
	
	public List<WebElement> getServicePlatesTitles() {
		WebElement ele = driver.findElement(servicePlatesDataView);
		List<WebElement> li = ele.findElements(servicePlatesDataViewTitle);
		return li;
			}
	
	public void clickServicePlatesTitlesLink(String networkPortContainer) {
		WebElement ele = driver.findElement(servicePlatesDataView);
		List<WebElement> li = ele.findElements(servicePlatesDataViewTitle);
		for (WebElement options:li ) {
			if (options.getText().contains(networkPortContainer)) {
				options.click();
				break;
			}
		}
			}

	//Objects for Name 
	By nameOfOffice = By.xpath("//*[@id='textfield-1468-inputEl']");
	public void enterNameOfOffice(String nameofOffice) {
		driver.findElement(nameOfOffice).clear();
		driver.findElement(nameOfOffice).sendKeys(nameofOffice);
		driver.findElement(nameOfOffice).sendKeys(Keys.TAB);
	}
	//Objects for Type Of Computer
	By typeOfSystem = By.xpath("//*[@id='combo-1470-inputEl']");
	public void enterTypeOfComputer(String typeOfComputer) {
		driver.findElement(typeOfSystem).clear();
		driver.findElement(typeOfSystem).sendKeys(typeOfComputer);
		driver.findElement(typeOfSystem).sendKeys(Keys.TAB);
	}
	
	//Objects for AssetTag Number of Computer
	By assetTagNo = By.xpath("//*[@id='textfield-1483-inputEl']");
	public void enterAssetTagNo(String computerNo) {
		driver.findElement(assetTagNo).clear();
		driver.findElement(assetTagNo).sendKeys(computerNo);
	}
	


	By requestGenericserviceId = By.xpath("//*[@id='box-1141']/h2");
	public String getGenericsServiceID() {
		String id = driver.findElement(requestGenericserviceId).getText();
		System.out.println("Complete message : "+ id); // Request "Generic Service (#2000397)" has been created.
		
		return id;
		
	}
}

