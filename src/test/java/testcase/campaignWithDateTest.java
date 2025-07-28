package testcase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import ExcelFileUtility.ExcelUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.webdriverUtility;
import javaUtility.JavaUtility;
import listenersUtility.listenersImplementation;

@Listeners(listenersUtility.listenersImplementation.class)

public class campaignWithDateTest extends baseClass {
	
	
	@Test(groups = "smoke")
	public  void campaignDate() throws IOException, InterruptedException {
//		 TODO Auto-generated method stub

		ExcelUtility eutil = new ExcelUtility();
		webdriverUtility wutil = new webdriverUtility();
		JavaUtility jutil = new JavaUtility();
		
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);
		
//		int ran = jutil.getRandonNumber();
		
		
//		to select date 
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
		sim.format(date);	
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,31);
		String datereq = sim.format(cal.getTime());
		jutil.getCurrentDate();
		String requireDate = jutil.getRequiredDate(50);


// click on click camapign
		HomePage hp = new HomePage(driver);
		hp.getCampBtn().click();
		hp.getcreatecamp().click();
		
		
//		Campaign page
		
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampname().sendKeys(campname);
		cp.getTargetSize().sendKeys(size);
		WebElement closedate = driver.findElement(By.xpath("//input[@type='date']"));
		wutil.passinput(driver, closedate, requireDate);
		cp.getCreateCampaign().click();
	
//		validation 
		Thread.sleep(2000);
		WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
		wutil.WaitforVisbilityOfElement(driver, alert);	
		
		Thread.sleep(2000);
		String msg = alert.getText();
		
//		if(msg.contains(campname+ran)) {
//			System.out.println("successfully created");
//		}
//		else {
//			System.out.println("not created");
//			Thread.sleep(2000);
//		}
		
		Assert.assertEquals(msg, "Campaign "+campname+" Successfully Added");
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		
			
	}

}
