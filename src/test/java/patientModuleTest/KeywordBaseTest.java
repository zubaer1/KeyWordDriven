package patientModuleTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import patientModule.KeyAction;
import patientModule.KeyElementAndFunction;

public class KeywordBaseTest{
	
	public WebDriver driver; 
	protected Properties prop;

	 
	public WebDriver initDriver(String browserName){

		if(browserName.equalsIgnoreCase("chrome")){
//			if(prop.getProperty("headless").equalsIgnoreCase("no")){
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless");
//				driver = new ChromeDriver(options);
//			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			//code
		}
		return driver;
	}
//--------------------------------------------------	
	public Properties initProp() throws IOException{
		String file = "E:\\Project-oldeclipse\\mmp_iit_zubaer\\src\\test\\resources\\utilTest\\base.properties";
		prop = new Properties();
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		return prop;
	}
//--------------------------------------------------
	public void openBrowser(String url){
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
} 
