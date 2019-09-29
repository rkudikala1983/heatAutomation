package com.heat.pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	//Objects for ITSupportPortal
	By itSupportPortal = By.xpath("//div[text()='IT Support Portal']");
	
	public WebElement getItSupportPortal() {
		return driver.findElement(itSupportPortal);
	}
	
	//Objects for Report A Fault
	By reportAFault = By.xpath("//span[text() = 'Report a Fault']");
	
	public WebElement verifyReportAFault() {
		return driver.findElement(reportAFault);
	}
	
	//Objects for  report an issue Text
	By reportAnIssueText = By.xpath("//span[text() = 'Click here to report an issue ']");
	
	public void verifyReportAnIssueText() {
		driver.findElement(reportAnIssueText);
			}
	
//Objects for Request A Service
	By requestAService = By.xpath("//span[text() = 'Request a Service']");
	
	public WebElement verifyRequestAService() {
		return driver.findElement(requestAService);
	}
	//Objects for All Request
	
	//Objects for My Items
	By myItems = By.xpath("//span[@id='dashboardWidgetHeader-1456-btnInnerEl']");
	
	public WebElement verifyMyItems() {
		return driver.findElement(myItems);
	}
	
	By computerlocationdrpdown = By.xpath("//*[contains(text(),'Computer Location:')]//following::div[3]");

	public void selectCompLocation(String value) throws InterruptedException {
		Thread.sleep(1500);
		List<WebElement> ele = driver.findElements(computerlocationdrpdown);
		ele.get(0);
		Select dropdown = new Select(ele.get(0));
		dropdown.selectByVisibleText(value);
			

	}
	By dashboardItems = By.xpath("//span[@class = 'x-btn-inner x-btn-inner-dashboard-header-medium']");
	
	public boolean getITSupportDashItems(String item)
	{
		List<WebElement> li = driver.findElements(dashboardItems);
		for(WebElement options: li) {
			if (options.getText().contains(item)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
		
		
	}
	
	// This method is used to click on It Supporet dash board items
	public void ClickITSupportDashItems(String item)
	{
		List<WebElement> li = driver.findElements(dashboardItems);
		for(WebElement options: li) {
			if (options.getText().contains(item)) {
			options.click();
			} else {
				throw new NoSuchElementException("Unable to Find Element "+ item);
			}
		}
				
	}
	
     public void getITSupportDashBoardItemReturning200orNot() throws IOException {
    	 HttpURLConnection httpURLConnect;
    			try {
    				List<WebElement> links = driver.findElements(dashboardItems);

    				System.out.println("Total links are " + links.size());

    				for (int i = 0; i < links.size(); i++) {

    					WebElement ele = links.get(i);

    					String linkUrl = ele.getAttribute("href");
    							System.out.println("Links are :"+linkUrl);
    					URL url = new URL(linkUrl);

    					 httpURLConnect = (HttpURLConnection) url.openConnection();

    					httpURLConnect.setConnectTimeout(3000);

    					httpURLConnect.connect();

    					if (httpURLConnect.getResponseCode() == 200) {
    						System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - Code :"
    								+ httpURLConnect.getResponseCode());
    					}
    					if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
    						System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
    								+ HttpURLConnection.HTTP_NOT_FOUND);
    					}
    				}
    			} catch (Exception e) {
                 e.printStackTrace();
    			}
				//return httpURLConnect.getResponseCode();
     
     }
    			

	
	//Objects for issues and approval requests
	By issuesApproval = By.xpath("//span[@id='dashboardWidgetButton-1457-btnInnerEl']");
	
	public void validateIssuesApproval() {
		driver.findElement(issuesApproval);
	}
	
	//Objects for Home
	By home = By.xpath("//ul[@id='ext-widget-1']/li[1]");
	public WebElement verifyHome() {
		return driver.findElement(home);
	}
	//Objects for service Catalog
	By serviceCatalog = By.xpath("//ul[@id='ext-widget-1']/li[2]");
	public WebElement verifyServiceCatalogLink() {
		return driver.findElement(serviceCatalog);
	}
	//Objects for MyItems
		By myItem1 = By.xpath("//ul[@id='ext-widget-1']/li[5]");
		public WebElement verifyMyItemsInTreeList() {
			return driver.findElement(myItem1);
	}
     //Objects for Settings
		
		By settings = By.xpath("//ul[@id='ext-widget-1']/li[8]");
		public WebElement verifySettings() {
			return driver.findElement(settings);
	}
		
		//Objects for Logout
		
				By logoutBtn = By.xpath("//ul[@id='ext-widget-1']/li[9]");
				public WebElement verifyLogoutBtn() {
					return driver.findElement(logoutBtn);
			}
		
	//Objects for Personal Settings
		By personalSettings = By.xpath("//div[@id='box-1350']");
		public WebElement verifyPersonalSettingsText() {
			return driver.findElement(personalSettings);
		}
		
// Objects for NewIncident
	By newIncident = By.xpath("//span[text() = 'Report a Fault']");
	public void verifyNewIncident() {
	driver.findElement(newIncident);
	}
	
	// Objects for Staff Login
	By loginStaff = By.xpath("//div[text()='Test Staff']");

	public WebElement getLoginStaffName() {
		return driver.findElement(loginStaff);
	}
	
	
	//Objects for Report a Fault
	//By reportAFault = By.cssSelector("#dashboardWidgetHeader-1495-btnInnerEl");
	//Objects for Self Service text on dashboard page
	
	By getSelfServiceText = By.xpath("//div[text()='Self Service Mobile']");
	
	public WebElement getSelfService() {
		return driver.findElement(getSelfServiceText);
	}


}
