package Salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createlegalentity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement legal=driver.findElementByXPath("//p[text()='Legal Entities']");
		js.executeScript("arguments[0].scrollIntoView();",legal);
		js.executeScript("arguments[0].click();", legal);
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[contains(@class,'navItem slds-is-unsaved')]//div")).click();
		WebElement  newlegal=driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		js.executeScript("arguments[0].click();", newlegal);
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("vinoth");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		 WebElement verify = driver.findElementByXPath("//span[text()='Legal Entity']");
	        if(verify.isDisplayed()) {
	        	System.out.println("Account should be created Successfully");
	        }
	        	else {
	        		System.out.println("Testcase failed");
	        	}
	        		
	        }
	}


