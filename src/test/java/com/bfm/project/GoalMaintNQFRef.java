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
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoalMaintNQFRef {
	public static WebDriver driver;
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");

	@Test()
	public static void login()
		{
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
	

}
	@Test(dependsOnMethods="login")
	public static void nqfRef() throws InterruptedException
	{
		WebElement centre=driver.findElement(By.xpath("(//a[@id='hideclass'])[4]"));
		Actions act= new Actions(driver);
		act.moveToElement(centre).perform();
		WebElement goal=driver.findElement(By.xpath("//a[text()='Goals Maintenance']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", goal);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		WebElement nqfref=driver.findElement(By.xpath("(//a[@class='left-menu-link'])[1]"));
		nqfref.click();
		WebElement newgoal=driver.findElement(By.xpath("//button[@id='btnEYLFAdd']"));
		js.executeScript("arguments[0].click()", newgoal);
		WebElement goalText=driver.findElement(By.xpath("//textarea[@id='txtMaterial1']"));
		goalText.sendKeys("TestingTextParent"+dt1+"");
		WebElement addgoal=driver.findElement(By.xpath("//button[@id='btnAddEYLFSave']"));
		js.executeScript("arguments[0].click()", addgoal);
		WebElement newParnt=driver.findElement(By.xpath("//span[text()='TestingTextParent"+dt1+"']"));
		System.out.println("New Parent Created successfully:   "+newParnt.getText());
		newParnt.click();
		Thread.sleep(5000);
		WebElement goalTextUP=driver.findElement(By.xpath("//textarea[@id='txtMaterial1']"));
		goalTextUP.clear();
		goalTextUP.sendKeys("TestingTextParent"+dt1+"123");
		WebElement updategoal=driver.findElement(By.xpath("//button[@id='btnAddEYLFSave']"));
		js.executeScript("arguments[0].click()", updategoal);
		Thread.sleep(5000);
		WebElement updatetxt=driver.findElement(By.xpath("//span[text()='TestingTextParent"+dt1+"123']"));
		System.out.println("Update Parent Name:  "+updatetxt.getText());
		WebElement newgoal2=driver.findElement(By.xpath("//button[@id='btnEYLFAdd']"));
		js.executeScript("arguments[0].click()", newgoal);
		WebElement goalText1=driver.findElement(By.xpath("//textarea[@id='txtMaterial1']"));
		goalText.sendKeys("TestingTextChild"+dt1+"123");
		WebElement addgoal1=driver.findElement(By.xpath("//button[@id='btnAddEYLFSave']"));
		js.executeScript("arguments[0].click()", addgoal);
		Thread.sleep(3000);
		WebElement src=driver.findElement(By.xpath("//span[text()='TestingTextParent"+dt1+"123']"));
		WebElement dst=driver.findElement(By.xpath("//span[text()='TestingTextChild"+dt1+"123']"));
		act.dragAndDrop(dst, src).perform();
		Thread.sleep(2000);
		WebElement dst1=driver.findElement(By.xpath("//span[text()='TestingTextChild"+dt1+"123']"));
		js.executeScript("arguments[0].click()", dst1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement box1=driver.findElement(By.xpath("//input[@id='650']"));
		js.executeScript("arguments[0].click()", box1);
		WebElement box2=driver.findElement(By.xpath("//input[@id='649']"));
		js.executeScript("arguments[0].click()", box2);
		WebElement svbtn=driver.findElement(By.xpath("//button[@id='btnAddEYLFSave']"));
		js.executeScript("arguments[0].click()", svbtn);
		
		
	}
}