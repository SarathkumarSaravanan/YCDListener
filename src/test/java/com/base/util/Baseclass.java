package com.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Baseclass {
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static  WebDriver driver;
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
	public TakesScreenshot tks;
	@BeforeSuite
	public static void createReport()
	{
	reporter = new ExtentSparkReporter("./target/extentReport.html");
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	
	}
	public static void createTest(String testName)
	{
		test=extent.createTest(testName);
	}

	public static void teststatus(String status, String description) throws IOException {
		
	switch(status)
	{
	case "pass":
	test.pass(description);
	break;
	case "fail":
	test.fail(description, MediaEntityBuilder.createScreenCaptureFromPath(addScreenshots()).build());
	break;
	case "skip":
	test.skip(description);
	break;
	case "fail with success percentage":
	test.fail(description);
	break;
	case "passScreenshot":
		test.pass(description, MediaEntityBuilder.createScreenCaptureFromPath(addScreenshots()).build());
	break;
	case "default":
	test.info(description);
	break;
	
	}
	
	}
	public static synchronized String addScreenshots() throws IOException
	{
	Long l = Calendar.getInstance().getTimeInMillis();
	String ScreenshotId = l.toString();
	String path=System.getProperty("user.dir")+"/ExtendReports/";
	File Screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String imagePath=path+ScreenshotId+".png";
	File dest= new File(imagePath);
	FileUtils.copyFile(Screenshot, dest);
	String Imagepath="../ExtendReports/"+ScreenshotId+".png";
	return Imagepath;
	}
	@AfterSuite
	public static void stop()
	{
	extent.flush();	
	}
		
	public static void openbrowser(String option)
	{
		switch(option)
		{
		case"chrome":
			driver = new ChromeDriver();
			break;
		case"firefox":
			driver = new FirefoxDriver();
			break;
		case"IE":
			driver = new InternetExplorerDriver();
			break;
		case"edge":
			driver= new EdgeDriver();
			break;
		}
	}
	public static void openURL(String url)
	{
		driver.get(url);
	}
	public static String getText(WebElement element)
	{
		String text=element.getText();
		return text;
	}
	public static String getAttrib(WebElement element,String atbName)
	{
	String atb=	element.getAttribute(atbName);
	return atb;
	}
	public static void winmax()
	{
		driver.manage().window().maximize();
	}
	public static void click(WebElement element)
	{
		element.click();
	}
	public static void close()
	{
		driver.close();
	}
	public static void quit()
	{
		driver.quit();
	}
	public static void submit(WebElement element)
	{
		element.submit();
	}
	public static Select sel;
	public static void selectbyid(WebElement element, int index)
	{
	sel= new Select(element);
	sel.selectByIndex(index);
	}
	public static void selectbyname(WebElement element, String value)
	{
	sel= new Select(element);
	sel.selectByValue(value);
	}
	public static void selectbyvisibletxt(WebElement element, String vtxt)
	{
	sel=new Select(element);
	sel.selectByVisibleText(vtxt);
					}
	public static void getoption(WebElement element)
	{
	
	sel=new Select(element);
	List<WebElement>opt=sel.getOptions();
	for(int i=0;i<opt.size();i++)
	{
	String ele=opt.get(i).getText();
	System.out.println(ele);
	}
	}
	public static void getseloption(WebElement element)
	{
	sel = new Select(element);
	List<WebElement>slcele=sel.getAllSelectedOptions();
	for(int i=0;i<slcele.size();i++)
	{
		String sltxt=slcele.get(i).getText();
		System.out.println(sltxt);
		
	}
	}
	public static String getfirstseloption(WebElement element)
	{
	sel= new Select(element);
	WebElement fsopt=sel.getFirstSelectedOption();
	String option=fsopt.getText();
	return option;
	}
	public static Actions act;
	public static void moveToElement(WebElement element)
	{
	act = new Actions(driver);
	act.moveToElement(element).perform();
	}
	public static void doubleClick(WebElement element) {
	act= new Actions(driver);
	act.doubleClick(element).perform();	
	}
	public static void contextClick(WebElement element) {
	act = new Actions(driver);
	act.contextClick(element).perform();
	}
	public static void dragAndDrop(WebElement src,WebElement dst)
	{
	act= new Actions(driver);
	act.dragAndDrop(src, dst).perform();
	}
	public static String getWindowHandle()
	{
	String parent=driver.getWindowHandle();
	return parent;
	}
	public static void getWindwoHandles(int index)
	{
		Set<String>child=driver.getWindowHandles();
		List<String>lst= new LinkedList<>();
		lst.addAll(child);
		driver.switchTo().window(lst.get(index));
	}
	public static void getScreenshot(String path) throws IOException
	{
		TakesScreenshot tks=(TakesScreenshot)driver;
	File src=tks.getScreenshotAs(OutputType.FILE);
	File dst=new File("path");
	FileHandler.copy(src, dst);
	
	}
	public static JavascriptExecutor js;
	public static void sendData(WebElement element,String value)
	{
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute("+value+");", element);
	}
	public static Object getData(WebElement element,String value)
	{
	js= (JavascriptExecutor)driver;
	Object data=js.executeScript("return arguments[0].getAttribute("+value+")", element);
	return data;
	}
	public static void jsclick(WebElement element)
	{
	js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()", element);
	}
	public static void navigateto(String url)
	{
	driver.navigate().to(url);
	}
	public static void forward()
	{
	driver.navigate().forward();
	}
	public static void back()
	{
	driver.navigate().back();
	}
	public static Alert al;
	public static void alerts(String choices, String data, WebElement element)
	{
		switch(choices)
		{
		case "accept":
		driver.switchTo().alert();
		al.accept();
		break;
		case "dismiss":
		driver.switchTo().alert();
		al.dismiss();
		break;
		case "senddata":
		driver.switchTo().alert();
		element.sendKeys(data);
		al.accept();
		break;
		}
	}
	public static void implicitewait(int time)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static String[][] getExcelData(String fileName, String sheetName) throws IOException {
    String[][] data = null;
    try {
    FileInputStream fis = new FileInputStream(fileName);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheet(sheetName);
    XSSFRow row = sheet.getRow(0);
    int noOfRows = sheet.getPhysicalNumberOfRows();
    int noOfCols = row.getLastCellNum();
    Cell cell;
    data = new String[noOfRows - 1][noOfCols];
    for (int i = 1; i < noOfRows; i++) {
    for (int j = 0; j < noOfCols; j++) {
    row = sheet.getRow(i);
    cell = row.getCell(j);
    data[i - 1][j] = cell.getStringCellValue();
    }
    }
    } catch (Exception e) {
    System.out.println("The exception is: " + e.getMessage());
    }
    return data;
    }



}
	

