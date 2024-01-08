package com.bfm.project;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.util.Baseclass;

public class Sample extends Baseclass {
//	@Test(dataProvider="getData1")
//
//public static void access(String usname,String Psw) throws InterruptedException, IOException {
//	openbrowser("chrome");
//	driver.get("https://dev.yourchildsday.com/v1/Account/Login");
//	
//	driver.manage().window().maximize();
//WebElement inntecadmin=driver.findElement(By.xpath("//input[@id='Email']"));
//inntecadmin.sendKeys(usname);
//WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
//psw.sendKeys(Psw);
//WebElement	btn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
//btn.click();
//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//WebElement acces=driver.findElement(By.xpath("(//button[@id='user-menu'])[1]"));
//Actions act= new Actions(driver);
//act.moveToElement(acces).perform();
//WebElement accessrig=driver.findElement(By.xpath("//a[text()='Access Requests']"));
//accessrig.click();
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//WebElement filter=driver.findElement(By.xpath("//a[@aria-label='UserName filter column settings']"));
//filter.click();
//WebElement filtxt=driver.findElement(By.xpath("//span[contains(@class,'k-textbox k-input k-input')]//input[@class='k-input-inner']"));
//filtxt.sendKeys("AutoTesting6");
//WebElement fiter=driver.findElement(By.xpath("//button[@title='Filter']"));
//fiter.click();
//	}
//	@DataProvider
//	public String[][] getData1() throws IOException
//	{
//		String data[][]=getExcelData("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\src\\test\\resources\\TestData\\Sample.xlsx", "Sheet1");
//	return data;
//	}
//	
@BeforeSuite
public void beforesuite(){
		
	System.out.println("One");
}
	
   @BeforeTest
	public void beforetest(){
		
		System.out.println("Two");
}

@BeforeClass
public void beforeclass(){
	
	System.out.println("Three");
}

@BeforeMethod
public void beforemethod(){
	
	System.out.println("Four");
}

@Test
public void test1(){
	
	System.out.println("five");

}
	
@org.testng.annotations.AfterMethod
public void AfterMethod(){
	
	System.out.println("Six");

}

@org.testng.annotations.AfterClass
public void AfterClass(){
	
System.out.println("Seven");
}


@org.testng.annotations.AfterTest
public void AfterTest(){
	
	System.out.println("Eight");
}

@org.testng.annotations.AfterSuite
public void AfterSuite(){
	
	System.out.println("Nine");
}

}
