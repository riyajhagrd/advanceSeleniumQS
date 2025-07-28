package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverUtility {

	
//	implicit Wait
	
	public void WaitForPageToLoad(WebDriver driver) {
//		 = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
//	explicitWait 
	public void WaitforVisbilityOfElement(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(element));
	}
	
//	switchTo Frame by  index
	
	public void SwitchToFrame(WebDriver driver , int index) {
		
		driver.switchTo().frame(index);
	}
	
//	switch to frame by name  o rid
	public void SwitchToFrame(WebDriver driver , String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	
//  switch to frame by web element
	public void SwitchToFrame(WebDriver driver , WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		}
		public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		}
		
		public String SwitchToAlertAndgetText(WebDriver driver) {
			String text = driver.switchTo().alert().getText();
			return text;
		}
		
		public void switchToAlertAndSendkeys(WebDriver driver,
				String text) {
				driver.switchTo().alert().sendKeys(text);
				}
		public void select(WebElement element , int index) {
				Select sel = new Select(element);
				sel.selectByIndex(index);
				}
		public void select(WebElement element , String value) {
				Select sel = new Select(element);
				sel.selectByValue(value);
				}
		
		
		public void select(String text , WebElement element) {
				Select sel = new Select(element);
				sel.selectByVisibleText(text);
				}
		
		
		
		public void mouseHoverOnWebElement(WebDriver driver,WebElement element) {
				Actions act = new Actions(driver);
				act.moveToElement(element).perform();
				}
		public void clickonWebElement(WebDriver driver,WebElement element) {
				Actions act = new Actions(driver);
				act.moveToElement(element).click().perform();
		}
		
		public void doubleclickOnWebElement(WebDriver driver,WebElement element) {
				Actions act = new Actions(driver);
				act.doubleClick(element).perform();
				}
		
		public void rightclickOnWebElement(WebDriver driver,WebElement element) {
				Actions act = new Actions(driver);
				
				act.contextClick(element).perform();
		}
		
		public void passinput(WebDriver driver , WebElement element, String text) {
				Actions act = new Actions(driver);
				act.click(element).sendKeys(text).perform();
				}
		
		public void switchToWindow(WebDriver driver) {
				Set<String> allwindId = driver.getWindowHandles();
				for(String id : allwindId) {
				driver.switchTo().window(id);
				   }
				}
		
		
				public void takesScreenshot(WebDriver driver , String filename) throws IOException
				{
				TakesScreenshot ts = (TakesScreenshot)driver;
				File temp = ts.getScreenshotAs(OutputType.FILE);
				File perm = new File("./errorShots"+filename+".png");
				FileHandler.copy(temp,perm);
						}
						
				
		public void toscrollby(WebDriver driver , int x, int y)
						{
						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("window.scrollBy("+x+", "+y+")");
						}
	
				
	public void closewindow(WebDriver driver) {
		driver.close();
	}
	
	public void closeAllWindow(WebDriver driver) {
		driver.quit();
	}
}

