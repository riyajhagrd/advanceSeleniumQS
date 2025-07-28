package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class mutlipleRowData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		
		FileInputStream fis = new FileInputStream("./TestData/multipleRow.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		int rowCount = sh.getLastRowNum();
		System.out.println(rowCount);
		
		for(int row =1;row<=rowCount;row++) {
			String pcat = sh.getRow(row).getCell(0).getStringCellValue();
			String pname = sh.getRow(row).getCell(1).getStringCellValue();
			
			System.out.println(pcat+"==="+pname);
		}
	}

}
