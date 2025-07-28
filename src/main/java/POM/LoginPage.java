package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="username")
	private WebElement UN;
	
	@FindBy(id="inputPassword")
	private WebElement Pass;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement loginBtn;
	

	public WebElement getUN() {
		return UN;
	}

	
	public WebElement getPass() {
		return Pass;
	}

	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
	
