package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.webdriverUtility;

public class CampaignPage {

	
	WebDriver driver;
	
	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="campaignName")
	private WebElement campname;
	
	@FindBy(name="campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(name="targetAudience")
	private WebElement targetAudience;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement CreateCampaign;

//	public WebDriver getDriver() {
//		return driver;
//	}

	public WebElement getCampname() {
		return campname;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getTargetAudience() {
		return targetAudience;
	}
	
	public WebElement getCreateCampaign() {
		return CreateCampaign;
	}
}
