package Salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccounts {

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
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement acc = driver.findElement(By.xpath("//span[text()='Accounts']"));
		js.executeScript("arguments[0].click();", acc);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("vinoth");
		WebElement ownership =driver.findElementByXPath("//label[text()='Ownership']/following::button[1]");
		js.executeScript("arguments[0].click();", ownership);
		//js.executeScript("arguments[0].scrollIntoView()");
	    WebElement rating = driver.findElementByXPath("//span[text()='Public']");
        js.executeScript("arguments[0].click();", rating);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        WebElement verify = driver.findElementByXPath("//span[text()='Account']");
        if(verify.isDisplayed()) {
        	System.out.println("Account should be created Successfully");
        }
        	else {
        		System.out.println("Testcase failed");
        	}
        		
        }
		
		
		
	}


