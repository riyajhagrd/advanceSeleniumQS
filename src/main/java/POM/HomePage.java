package POM;

import java.awt.print.PageFormat;
import java.nio.file.WatchEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver ;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Campaigns")
	 private WebElement capmBtn;
	
	@FindBy(linkText = "Products")
	private WebElement prodBtn;
	
	@FindBy(linkText = "Contacts")
	private WebElement contBtn;
	
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createcamp;
	
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement createprod;
	
	
	@FindBy(className = "user-icon")
	private WebElement userIcon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logout;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alertmsg;
	
	@FindBy(xpath = "//button[@arial-label='close']")
	private WebElement closemsg;
	
	
	public WebElement getCampBtn() {
		return capmBtn;
	}
	
	public WebElement getProdBtn() {
		return prodBtn;
	}
	

	public WebElement getcreatecamp() {
		return createcamp;
	}
	
	public WebElement getcreateProd() {
		return createprod;
	}
	
	public WebElement getContBtn() {
		return contBtn;
	}
	public WebElement getuserIcon() {
		return userIcon;
	}

	
	public WebElement getLogout() {
		return logout;
	}


	public WebElement getAlertmsg() {
		return alertmsg;
	}

	public WebElement getClosemsg() {
		return closemsg;
	}

	
	
	
}
