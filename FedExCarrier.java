package eShipslogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FedExCarrier {
	@Test
	public void editFedExcarrier() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://qa-eshipz.herokuapp.com/");
		driver.findElement(By.id("email")).sendKeys("automation@eshipz.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login-submit")).click();
		if(driver.getTitle().contains("eShipz")) {
			System.out.println("My HomePage is displayed..");
		}else {
		     System.out.println("HomePage is not displayed..");	
			}
		
		WebElement settings = driver.findElement(By.xpath("//a[@data-activates='settings']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(settings).perform();
		driver.findElement(By.linkText("Carriers")).click();
		driver.findElement(By.xpath("(//i[text()='edit'])[3]")).click();
		driver.findElement(By.xpath("//input[@value='Testing']")).click();
		WebElement description = driver.findElement(By.name("desc"));
		description.clear();
		description.sendKeys("FedEx test[use this 2]");
		WebElement accountNumber = driver.findElement(By.id("account_number"));
		accountNumber.clear();
		accountNumber.sendKeys("510087100");
		WebElement Key = driver.findElement(By.id("key"));
		Key.clear();
		Key.sendKeys("5uSSCMb0vyaUnhAt");
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("d42p4xSuYxuaP60J5Az77VbHO");
		WebElement meterNumber = driver.findElement(By.id("meter_number"));
		meterNumber.clear();
		meterNumber.sendKeys("118828179");
		driver.findElement(By.xpath("//label[text()='I Agree to the ']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
