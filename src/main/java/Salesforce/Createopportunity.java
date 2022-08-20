package Salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createopportunity {

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
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		// Click on Opportunity tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement opportunities =driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", opportunities);
		//Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		// Choose Close date as Tomorrow Date
		//driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("13/08/2022");
		// Click on save 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//Verify the Alert message (Complete this field) displayed for Name and Stage
		WebElement opportunity =driver.findElementByXPath("//h2[text()='We hit a snag.']");
		if(opportunity.isDisplayed()) {
        	System.out.println("Complete this field");
        }
        	else {
        		System.out.println("Testcase failed");
        	}

	}

}
