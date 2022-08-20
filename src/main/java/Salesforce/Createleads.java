package Salesforce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createleads {

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
		WebElement leads=driver.findElement(By.xpath("//span[text()='Leads']"));
		js.executeScript("arguments[0].click();", leads);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		driver.findElementByXPath("//span[@class=\"slds-media__body\"]/span[@title=\"Mr.\"]").click();
		driver.findElement(By.xpath("(//span[text()='Prof.']/following::input)[2]")).sendKeys("kumar");
	
		driver.findElement(By.xpath("//label[text()='Company']/following::input[1]")).sendKeys("testleaf");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		 WebElement verify = driver.findElementByXPath("//span[text()='Lead']");
	        if(verify.isDisplayed()) {
	        	System.out.println("New Leads should be created Sucessfully");
	        }
	        	else {
	        		System.out.println("Testcase failed");
	        	}
		
		
	}

}
