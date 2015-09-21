package com.staf.common;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.staf.model.UIObject;
import com.staf.reader.ConfigReader;

public class Browser {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	static Logger log=Logger.getLogger(Browser.class.getClass());
	private static int i =0;

	public static void launchBrowser(String type, String appurl){
		if (type.equalsIgnoreCase("FF")){
			driver = new FirefoxDriver();
			log.info("starting the firefox browser");
		}else if(type.equalsIgnoreCase("CHROME")){
			//download chrome driver and keep it under drivers of the current project
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe" );
			driver = new ChromeDriver();
		}else if(type.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
		}
		driver.get(appurl);
		
	}
	//Maximize
	public static void maximize(){
			driver.manage().window().maximize();
			log.info("maximized the browser");
	}
	
	public static void quit(){
		driver.quit();
		log.info("browser is closed and session is quit");
	}
	
	public static void back(){
		driver.navigate().back();
		log.info("browser is navigated to back");
	}
	
	public static void forward(){
		driver.navigate().forward();
		log.info("browser is navigated to forward");
	}
	
	public static void clearCookies(){
		driver.manage().deleteAllCookies();
		log.info("deleted all the cookies");
	}
	
	public static void waitForElement(UIObject obj) throws Exception{

		wait=new WebDriverWait(driver, 320);
		//wait.until(ExpectedConditions.visibilityOf(element));
		log.info("waiting for element " +obj);
		try{
			
		if(obj.getIdentifier().equalsIgnoreCase("Byid")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(obj.getId())));
		}
		
		else if(obj.getIdentifier().equalsIgnoreCase("Byname")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(obj.getName())));
		}
		
		
		else if(obj.getIdentifier().equalsIgnoreCase("Byxpath")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getXpath())));
			
		}
		
		else if(obj.getIdentifier().equalsIgnoreCase("BycssSelector")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(obj.getCssselector())));
		}
		
		
		else if(obj.getIdentifier().equalsIgnoreCase("Byclassname")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(obj.getClassname())));
		}
		
		}catch(Exception e){
	
			String str=e.getMessage();
			log.info(str);
			throw new Exception(str);
		}
		
		}
		

	
	
	public static boolean isTextVisible(String s){
		boolean visible = false;
		try{
			visible = driver.findElement(By.cssSelector("body")).getText().contains(s);
			
		} catch (NoSuchElementException e){
			visible = false;
		}
		return visible;
	}
	

	public static void captureScreen(String s) throws IOException, InterruptedException{
		Calendar c = GregorianCalendar.getInstance();
		String v = String.format("%1$tm%1$te%1$tY", c);
		Thread.sleep(1000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="D:\\ITT\\Screenshots\\"+ConfigReader.getInstance().getTestCaseName()+"\\" +v+"\\"+i+"_"+s+".png";
		FileUtils.copyFile(src, new File(path));
		log.info(s);
		i = i+1;
	}
	
	public static void switchToFrame(WebElement frame){
		driver.switchTo().frame(frame);
//		System.out.println(frame.getAttribute("id"));
		log.info("Switching to frame: " + frame.getAttribute("id"));
	}

	public static void switchToDefaultContent(){
		driver.switchTo().defaultContent();
		log.info("Switching to defautl Content");
	}
	
}

