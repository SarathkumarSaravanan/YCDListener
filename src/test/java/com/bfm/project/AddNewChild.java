package com.bfm.project;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewChild {
public static WebDriver driver;
public static Date dt = new Date();
public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
public static  String date=sdf.format(dt);
public static String dt1=date.replace(":","");
	@Test
	public static void loginpage() {
		driver = new ChromeDriver();
		driver.get("https://dev.yourchildsday.com/");
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement usname= driver.findElement(By.xpath("(//input[@data-val='true'])[1]"));
	usname.sendKeys("inntechadmin@yourchildsday.com");
	WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
	psw.sendKeys("02xU^lA4e4gz");
	WebElement btn=driver.findElement(By.xpath("//input[@type='submit']"));
	btn.click();
	String actual="My Profile";
	WebElement text=driver.findElement(By.xpath("//h2[@class='page-title']"));
	String expected=text.getText();
	Assert.assertEquals(actual, expected);
	System.out.println("Login suceesfully move to home page");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement child=driver.findElement(By.xpath("(//div[contains(@class,'text-sm font-medium group relative menucolor')])[1]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(child).perform();
		WebElement chlist=driver.findElement(By.xpath("//a[text()='Child List']"));
		chlist.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement newchld=driver.findElement(By.xpath("//a[contains(@class,'cursor-pointer flex sm:inline-flex')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", newchld);
		WebElement fname=driver.findElement(By.xpath("//input[@id='FirstName']"));
		fname.sendKeys("NameTesting"+dt1+"");
		WebElement slcmp=driver.findElement(By.xpath("(//span[@role='combobox'])[1]"));
		slcmp.click();
		WebElement bldf=driver.findElement(By.xpath("//li[@role='option']//span[text()='Building Futures Pty Ltd']"));
		bldf.click();
		WebElement middlenm=driver.findElement(By.xpath("//input[@id='MiddleName']"));
		middlenm.sendKeys("MiddlenameTesting"+dt1+"");
		WebElement centre=driver.findElement(By.xpath("(//span[@role='combobox'])[2]"));
JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", centre);
		WebElement slcentre=driver.findElement(By.xpath("//li[@role='option']//span[text()='AQUA']"));
		js.executeScript("arguments[0].click();", slcentre);
		WebElement lname=driver.findElement(By.xpath("//input[@id='LastName']"));
		lname.sendKeys("LastNameTesting"+dt1+"");
		WebElement childfeerate=driver.findElement(By.xpath("//input[@id='ChildFeesRate']"));
		childfeerate.sendKeys("1"+dt1+"");
		WebElement childdob=driver.findElement(By.xpath("//input[@id='BirthDate']"));
		childdob.sendKeys("08/01/2019");
		WebElement savebtn=driver.findElement(By.xpath("//button[@type='submit']"));
		savebtn.click();
		WebElement cnfrmbtn=driver.findElement(By.xpath("(//button[@id='Yes'])[2]"));
		cnfrmbtn.click();	
		
	}

}
