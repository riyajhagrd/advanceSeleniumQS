package testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import ExcelFileUtility.ExcelUtility;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.webdriverUtility;
import javaUtility.JavaUtility;

public class selectProductTest extends baseClass {
	
	
	@Test
	public void AddProduct() throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub

		
//		create  Webdriver utility
		webdriverUtility wutil = new webdriverUtility();
		JavaUtility jutil = new JavaUtility();
		int ran = jutil.getRandonNumber();
//		Excel utility
		ExcelUtility eutil = new ExcelUtility();
		String pname = eutil.getDataFromExcel("Product", 1, 2);
		String quantity = eutil.getDataFromExcel("Product", 1, 3);
		String pprice = eutil.getDataFromExcel("Product", 1, 4);
		
		
//      home page
		HomePage hp = new HomePage(driver);
		hp.getProdBtn().click();;
		hp.getcreateProd().click();
		
//      product page
		ProductPage pp = new  ProductPage(driver);
		
		pp.getProductName().sendKeys(pname+ran);
		
		WebElement productType = pp.getProductCategory();
		wutil.select("Furniture",productType);
		pp.getQuantity().sendKeys(quantity);
		pp.getPrice().clear();
		pp.getPrice().sendKeys(pprice);
		
		
		WebElement vendor = pp.getVendorId();
		wutil.select(vendor, "VID_004");
		pp.getAddproductBtn().click();
		
		Thread.sleep(2000);
		WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
		
		wutil.WaitforVisbilityOfElement(driver, alert);
		
		Thread.sleep(2000);
		String msg = alert.getText();
		
//		if(msg.contains(pname+ran)) {
//			System.out.println(pname+ran+" successfully product created");
//		}
//		else {
//			System.out.println("not created");
//			
//		}
//		Thread.sleep(2000);
		
		Assert.assertEquals(msg, "Product "+pname+ran+" Successfully Added");
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		System.out.println("Created");
			
	}

}
