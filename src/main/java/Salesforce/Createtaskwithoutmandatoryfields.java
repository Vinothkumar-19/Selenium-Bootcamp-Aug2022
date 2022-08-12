package Salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createtaskwithoutmandatoryfields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		//Disable notification 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.findElementById("username").sendKeys("hari.radhakrishnan@qeagle.com ");
		driver.findElementById("password").sendKeys("India$321");
		driver.findElementById("Login").click();
		driver.findElementByClassName("slds-r5").click();
		driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		 driver.findElement(By.xpath("//a[@title='Tasks']/following-sibling::one-app-nav-bar-item-dropdown/div/one-app-nav-bar-menu-button/a")).click();
		  driver.findElement(By.xpath("//div[@class='menuItemsWrapper']/slot/one-app-nav-bar-menu-item")).click();
		  
		
		   driver.findElement(By.xpath("(//div[@class='autocompleteWrapper slds-grow'])[2]")).click();
		    driver.findElement(By.xpath("//div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']/div")).click();
		    driver.findElement(By.xpath("//textarea[contains(@class,'textarea textarea')]")).click();
		    driver.findElement(By.xpath("//textarea[contains(@class,'textarea textarea')]")).sendKeys("SALES FORCE Automation Using Selenium");
		    driver.findElement(By.xpath("//span[text()='Save']")).click();
		    
		    WebElement verify = driver.findElement(By.xpath("//li[text()='These required fields must be completed: Subject']"));
		    if(verify.isDisplayed()) {
	        	System.out.println("These required fields must be completed: Subject");
	        }
	        	else {
	        		System.out.println("Testcase failed");
	        	}
					driver.close();
	}

}
