package testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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

@Listeners(listenersUtility.listenersImplementation.class)

public class campaignWitStatusTest extends baseClass {


	@Test(groups = "sanity")
	public void createCampaignStatus() throws EncryptedDocumentException, IOException, InterruptedException {
	
	//base class interaction
	
	ExcelUtility eutil = new ExcelUtility();
	webdriverUtility wutil = new webdriverUtility();
	JavaUtility jutil = new JavaUtility();
//	int ran = jutil.getRandonNumber();
	
//	read the data from excel
	String campname = eutil.getDataFromExcel("Campaign", 1, 2);
	String size = eutil.getDataFromExcel("Campaign", 1, 3);
	String status = eutil.getDataFromExcel("Campaign", 1, 4);

	HomePage hp = new HomePage(driver);
	hp.getCampBtn().click();
	hp.getcreatecamp().click();;
	
	CampaignPage cp = new CampaignPage(driver);
	cp.getCampname().sendKeys(campname);
	cp.getTargetSize().sendKeys(size);
	cp.getCampaignStatus().sendKeys(status);
	cp.getCreateCampaign().click();
	
	Thread.sleep(2000);
//	validation
	WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
	wutil.WaitforVisbilityOfElement(driver, alert);
	
	Thread.sleep(2000);

	String msg = alert.getText();
	
//	if(msg.contains(campname)) {
//		System.out.println("created");
//	}
//	else {
//		System.out.println("not created");
//		Thread.sleep(2000);
//	}
//	Assert.assertTrue(msg.contains(campname));
	
	Assert.assertEquals(msg, "Campaign "+campname+" Successfully Added");
	
	driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
	}

}
