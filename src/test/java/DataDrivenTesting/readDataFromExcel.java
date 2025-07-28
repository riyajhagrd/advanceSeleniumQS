package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class readDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("./TestData/TestScriptDataAdv.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Campaign");
		Row row = sh.getRow(1);
		 String campname = row.getCell(22).getStringCellValue();
		 String size = row.getCell(3).getStringCellValue();
		 
//		 
//		 WebDriver driver = new ChromeDriver();
//		 driver.manage().window().maximize();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		 
//		 driver.get("https://www.instagram.com/");
//		 driver.findElement(By.name("username")).sendKeys(c1);
//		 driver.findElement(By.name("password")).sendKeys(c2);
	}

}
