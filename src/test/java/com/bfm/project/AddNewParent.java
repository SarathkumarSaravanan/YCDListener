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


public class AddNewParent {
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
public static WebDriver driver;
@Test
public static void newParent()
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
WebElement paren=driver.findElement(By.xpath("//a[text()='Parent']"));
Actions act= new Actions(driver);
act.moveToElement(paren).perform();
WebElement parenList=driver.findElement(By.xpath("//a[text()='Parent List']"));
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", parenList);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement addparen=driver.findElement(By.xpath("//a[@href='/v1/Parents/0']"));
js.executeScript("arguments[0].click();", addparen);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement fname=driver.findElement(By.xpath("//input[@id='FirstName']"));
fname.sendKeys("TestingFirstname"+dt1+"");
WebElement lname=driver.findElement(By.xpath("//input[@id='LastName']"));
lname.sendKeys("TestingLastname"+dt1+"");
WebElement signinpin=driver.findElement(By.xpath("//input[@id='SignInPIN']"));
signinpin.sendKeys("4444");
WebElement mail=driver.findElement(By.xpath("//input[@id='Email']"));
mail.sendKeys("Testingsar6"+dt1+"@yopmail.com");
WebElement sltcenter=driver.findElement(By.xpath("(//span[contains(@class,'dropdownlist k-picker-solid k-picker')])[2]"));
sltcenter.click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement centerfuter=driver.findElement(By.xpath("//span[text()='Building Futures Care']"));
centerfuter.click();
WebElement save=driver.findElement(By.xpath("//button[@type='submit']"));
save.click();
WebElement confirm=driver.findElement(By.xpath("(//button[@id='Yes'])[2]"));
confirm.click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement btnon=driver.findElement(By.xpath("//div[contains(@class,'bg-gray-600 w-14 h-8 rounded')]"));
js.executeScript("arguments[0].click();", btnon);
WebElement srctxt=driver.findElement(By.xpath("//input[@id='SearchText']"));
srctxt.sendKeys("TestingLastname");
//srctxt.submit();
System.out.println("New Parent Created Successfully");
}

}
