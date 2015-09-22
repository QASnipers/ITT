package com.staf;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.staf.common.*;
import com.staf.common.constants.DataConstants;
import com.staf.reader.ConfigReader;

public class MainClass  {
	
	List<WebElement> elem = new ArrayList<WebElement>();
	ExtentReports extent;

	 @BeforeClass
	 public void M1() throws IOException{
		 ConfigReader.getInstance().readConfiguration();
		 extent = Browser.Instance();
	 }	
	 
	 @AfterClass
	 public void tear()
	 {
	  extent.endTest(Browser.report);
	  extent.flush();
	  extent.close();
	 }	 
	
	@Test
	public void clickLeftPaneLinksAndVerifyContent() throws Exception{
		
		//ConfigReader.getInstance().readConfiguration();
		Browser.report = extent.startTest("Left Panel Links", "Click Left Panel Links and verify its content");
		String methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(methodname);
		ConfigReader.getInstance().setTestCaseName("MainClass");
		
		Application app = new Application();
		Browser.launchBrowser(ConfigReader.getInstance().getBrowserType(), ConfigReader.getInstance().getUrl());
		Browser.maximize();
				
		ConfigReader.getInstance().setDataRowsCount(0);
		
		for(int currentRow=0; currentRow<=ConfigReader.getInstance().getDataRowsCount(); currentRow++){
			ConfigReader.getInstance().setDataCurrentRow(currentRow);

			WebElement elementMenu = Browser.driver.findElement(By.id("menu")); 
			WebElement elemContent = Browser.driver.findElement(By.id("content"));
			
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickReadings();
			Browser.driver.switchTo().defaultContent();
			

			Browser.driver.switchTo().frame(elemContent);
			
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Reading_Content)[currentRow]);
			
			Browser.driver.switchTo().defaultContent();
			
			//Clicking and verifying Introduction Overview
			Browser.driver.switchTo().frame(elementMenu);
			
			app.PG_01_LessonMenu.clickIntroductionOverview();
			
			Browser.driver.switchTo().defaultContent();
			
			Browser.driver.switchTo().frame(elemContent);
			
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Overview_Content1)[currentRow]);
			
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Overview_Content2)[currentRow]);

			Browser.driver.switchTo().defaultContent();
			
			//Clicking and verifying Introduction Projects
			
			Browser.driver.switchTo().frame(elementMenu);
			
			app.PG_01_LessonMenu.clickIntroductionProject();
			
			Browser.driver.switchTo().defaultContent();
			
			Browser.driver.switchTo().frame(elemContent);
			
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_IntroProject_Content)[currentRow]);

			Browser.driver.switchTo().defaultContent();

			//Clicking and verifying Importance Projects
			
			Browser.driver.switchTo().frame(elementMenu);
			
			app.PG_01_LessonMenu.clickImportanceProject();
			
			Browser.driver.switchTo().defaultContent();
			
			Browser.driver.switchTo().frame(elemContent);
			
			app.PG_02_Content.clickContentBox1();
			
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Importance_Project_Uniformity_Content)[currentRow]);

			app.PG_02_Content.clickContentBox2();
			
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Importance_Project_Audience_Content)[currentRow]);

			app.PG_02_Content.clickContentBox3();
			
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Importance_Project_Backtracking_Content)[currentRow]);

			app.PG_02_Content.clickContentBox4();
			
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Importance_Project_Replacement_Content)[currentRow]);
			
			
		}
		Browser.quit();
	}
	
	@Test
	public void clickNextAndVerifyContent() throws Exception{
		
	}
	
	
}


