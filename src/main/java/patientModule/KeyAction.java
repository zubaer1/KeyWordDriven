package patientModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;

import patientModuleTest.KeywordBaseTest;

public class KeyAction extends KeywordBaseTest {

	WebElement element = null;
	KeyElementAndFunction key = new KeyElementAndFunction();

	public void readExcel(String sheetName) throws EncryptedDocumentException, IOException, InterruptedException{
		
//		String path = "C:\\Users\\Zubaer\\Desktop\\keywordMMP.xlsx";
		String path = "C:\\Users\\Zubaer\\Desktop\\keywordMMP.xlsx";
						
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		//sheet name:  "keywordLogin" 
		Sheet sheet = workbook.getSheet(sheetName); 
		int size = sheet.getLastRowNum();
		System.out.println("Last row number "+size); 
		
		for(int i=5; i<size; i++){
			String action = sheet.getRow(i).getCell(4).toString().trim();
			String locatorType = sheet.getRow(i).getCell(5).toString().trim();
			String locatorValue = sheet.getRow(i).getCell(6).toString().trim();
			String validation = sheet.getRow(i).getCell(7).toString().trim();
			String value = sheet.getRow(i).getCell(8).toString().trim();
			
			System.out.println("Excel line "+(i-4)+" => "+action); 
	
//==========action, value=================
			switch(action){
			case "openBrowser":
				driver = initDriver("chrome");
				break;
			case "enterUrl":   
				openBrowser(value);
				break;
			case "quit":
				driver.quit();
				break;
			case "sendKeys": 
				key.findElement(locatorType, locatorValue, driver).clear();
				key.findElement(locatorType, locatorValue, driver).sendKeys(value);  
				Thread.sleep(1000);
				break;
			case "click":
				key.findElement(locatorType, locatorValue, driver).click();	
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
				break;
			case "validateList":
				key.validatePatientLoginButton(locatorType,locatorValue, driver, validation);
				break;
			case "verifyText":
				key.validateText(locatorType,locatorValue, driver, validation);
				break; 
	
			
			} //closing switch 
	} //closing for loop

	}//closing method
}//closing class
 









