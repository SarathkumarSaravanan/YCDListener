package com.bfm.project;

import java.awt.Robot;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddActivityMaint {
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
	public static WebDriver driver;
	@Test()
public static void login()
	{
	driver = new ChromeDriver();
	driver.get("https://dev.yourchildsday.com/");
	driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement usname= driver.findElement(By.xpath("(//input[@data-val='true'])[1]"));
System.out.println(usname.getCssValue("border-bottom-color"));
//usname.sendKeys("inntechadmin@yourchildsday.com");
//WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
//psw.sendKeys("02xU^lA4e4gz");
//WebElement btn=driver.findElement(By.xpath("//input[@type='submit']"));
//btn.click();
//}
//@Test(dependsOnMethods="login")
//public void addactiv() throws InterruptedException
//{
//WebElement cntr=driver.findElement(By.xpath("//a[text()='Centre']"));
//Actions act= new Actions(driver);
//act.moveToElement(cntr).perform();
//WebElement actmnt=driver.findElement(By.xpath("//a[text()='Activity Maintenance']"));
//JavascriptExecutor js= (JavascriptExecutor)driver;
//js.executeScript("arguments[0].click()", actmnt);
//WebElement addActBtn=driver.findElement(By.xpath("//button[@id='btnAddActivity']"));
//js.executeScript("arguments[0].click()", addActBtn);
//WebElement title=driver.findElement(By.xpath("//input[@id='title']"));
//title.sendKeys("Testingactivity"+dt1+"");
//WebElement agegrp=driver.findElement(By.xpath("//input[@class='k-input-inner k-readonly']"));
//js.executeScript("arguments[0].click()", agegrp);
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//WebElement casa=driver.findElement(By.xpath("//span[text()='Casa']"));
//js.executeScript("arguments[0].click()", casa);
//WebElement infan=driver.findElement(By.xpath("//span[text()='Infant Community']"));
//js.executeScript("arguments[0].click()", infan);
//WebElement slcinexp=driver.findElement(By.xpath("//input[@class='k-input-inner k-readonly']"));
//js.executeScript("arguments[0].click()", slcinexp);
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//WebElement mae=driver.findElement(By.xpath("//span[text()='Montessori Activity Experience']"));
//js.executeScript("arguments[0].click()", mae);
//WebElement ple=driver.findElement(By.xpath("//span[text()='Planned Learning Experience']"));
//js.executeScript("arguments[0].click()", ple);
//WebElement slcfile=driver.findElement(By.xpath("//input[@id='files']"));
//slcfile.sendKeys("C:\\Users\\TSI\\images\\photo-1579353977828-2a4eab540b9a.jpg");
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//WebElement readIndi=driver.findElement(By.xpath("//textarea[@id='ReadinessIndicator']"));
//readIndi.sendKeys("Testing READINESS INDICATOR");
//WebElement desexp=driver.findElement(By.xpath("//textarea[@id='Presentation']"));
//desexp.sendKeys("Testing DESCRIPTION OF THE EXPERIENCE");
//WebElement aimdir=driver.findElement(By.xpath("//textarea[@id='AimDirect']"));
//aimdir.sendKeys("Testing AIM DIRECT");
//WebElement assvoc=driver.findElement(By.xpath("//textarea[@id='AssociatedVocabulary']"));
//assvoc.sendKeys("Testing ASSOCIATED VOCABULARY");
//WebElement urlParent=driver.findElement(By.xpath("//input[@id='URLParent']"));
//urlParent.sendKeys("Testing URL FOR PARENTS");
//WebElement urledu=driver.findElement(By.xpath("//input[@id='URLEducator']"));
//urledu.sendKeys("Testing URL FOR EDUCATORS");
//WebElement btngol=driver.findElement(By.xpath("(//button[contains(@onclick,'toggleModal')])[1]"));
//js.executeScript("arguments[0].click()", btngol);
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//WebElement arbtn=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[4]/div/div/ul/li[1]/div/span[1]/span"));
//js.executeScript("arguments[0].click()", arbtn);
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//WebElement sltopt=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[4]/div/div/ul/li[1]/ul/li[1]/div/span[1]/input"));
//js.executeScript("arguments[0].click()", sltopt);
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//WebElement svgoal=driver.findElement(By.xpath("//button[@id='btnAddMontGoal']"));
//js.executeScript("arguments[0].click()", svgoal);
//WebElement followup=driver.findElement(By.xpath("//textarea[@id='FollowUpSuggestions']"));
//followup.sendKeys("Testing FOLLOW UP SUGGESTIONS");
//WebElement addact=driver.findElement(By.xpath("//button[contains(@onclick,'dvFollowUpModal_Add')]"));
//js.executeScript("arguments[0].click()", addact);
//Thread.sleep(5000);
//for(int i=0;i<=500;i++)
//{
//		if(i==13)
//		{
//		WebElement arrbtn=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[5]/div[2]/div[1]/div[4]/div/div/ul/li["+i+"]/div/span[1]/span"));
//		js.executeScript("arguments[0].click()", arrbtn);
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//
//		WebElement arrbtn2=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[5]/div[2]/div[1]/div[4]/div/div/ul/li["+i+"]/ul/li[1]/div/span[1]/span"));
//		js.executeScript("arguments[0].click()", arrbtn2);
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		WebElement arrbtn3=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[5]/div[2]/div[1]/div[4]/div/div/ul/li["+i+"]/ul/li[1]/ul/li[1]/div/span[1]/input"));
//		js.executeScript("arguments[0].click()", arrbtn3);
//		break;
//		}}
//WebElement addact1=driver.findElement(By.xpath("//button[@id='btnAddFollowUpActivity']"));
//js.executeScript("arguments[0].click()", addact1);
//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//WebElement addactmain=driver.findElement(By.xpath("//input[@id='btnUpdateactivity']"));
//js.executeScript("arguments[0].click()", addactmain);
//System.out.println("Activity updated successfully");

}
}




