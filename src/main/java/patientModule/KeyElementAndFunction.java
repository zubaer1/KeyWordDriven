package patientModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class KeyElementAndFunction { 
	
	WebElement element;

		List<WebElement> lists;

	public  List<WebElement> findElements(String locatorType, String locatorValue, WebDriver driver){		
		switch(locatorType){
		case "cssSelector": 
			lists = driver.findElements(By.cssSelector(locatorValue)); 
			return lists;
		case "xpath":
			lists = driver.findElements(By.xpath(locatorValue)); 
			return lists;	 	 
		}
		return lists;   
	}
//------------------------------------------------------------------
	
	public  WebElement findElement(String locatorType, String locatorValue, WebDriver driver){		
		switch(locatorType){
			case "name":
				element = driver.findElement(By.name(locatorValue)); 
				return element;
			case "id":
				element = driver.findElement(By.id(locatorValue));  
				return element;
			case "cssSelector":
				element = driver.findElement(By.cssSelector(locatorValue)); 
				return element;
			case "xpath":
				element = driver.findElement(By.xpath(locatorValue));
				return element;
			case "linkText":
				element = driver.findElement(By.linkText(locatorValue));
				return element;
			case "partialLink":
				element = driver.findElement(By.partialLinkText(locatorValue));
				return element;
			case "className":
				element = driver.findElement(By.className(locatorValue));
				return element;
			case "tagname":
				element = driver.findElement(By.tagName(locatorValue)); 
				return element; 
			default:
			//throw exception; 
			}
			return element;  		
	}
//----------------------------------------------------------------------
	public boolean validatePatientLoginButton(String locatorType,String locatorValue,WebDriver driver, String validation){
		boolean result = false; 
		lists = findElements(locatorType,locatorValue,driver);
		int size = lists.size();
		System.out.println("Navbar Size--> " + size); 
 
		for(int i=0; i<size; i++){ 
			if((lists.get(i).getText()).contains(validation)){  
				result = true;
			}	
		}
		System.out.println("'"+validation +"'"+" present --> " + result); 
		Reporter.log(validation +" present --> " + result); 
		return result;
	}
//-------------------------------------------------------------------------
	public boolean validateText(String locatorType,String locatorValue,WebDriver driver, String validation){ 
		String actual = findElement(locatorType,locatorValue,driver).getText();
		System.out.println(actual); 
		String expected = validation ; // "Patient Portal";
		boolean bool = false;
		if(actual.contains(expected)){
			bool = true;
		}
		System.out.println("Registration page displayed--> "+bool); 
		return bool; 
	} 
//-------------------------------------------------------------------------

}//closing class
