package com.staf;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.staf.common.*;
import com.staf.common.constants.DataConstants;
import com.staf.common.constants.ObjectConstants;
import com.staf.controls.Span;
import com.staf.model.Actions;
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
	public void LeftPanelLinksContentVerify() throws Exception{
		
		//ConfigReader.getInstance().readConfiguration();
		Browser.report = extent.startTest("Left Panel Links", "Click Left Panel Links and verify its content");
		String methodname = new Object(){}.getClass().getEnclosingMethod().getName();

		
		ConfigReader.getInstance().setTestCaseName(methodname);
		
		Application app = new Application();
		Browser.launchBrowser(ConfigReader.getInstance().getBrowserType(), ConfigReader.getInstance().getUrl());
		Browser.maximize();

		WebElement elementMenu = Browser.driver.findElement(By.id("menu")); 
		WebElement elemContent = Browser.driver.findElement(By.id("content"));

		ConfigReader.getInstance().setDataRowsCount(0);
		
		for(int currentRow=0; currentRow<=ConfigReader.getInstance().getDataRowsCount(); currentRow++){
			ConfigReader.getInstance().setDataCurrentRow(currentRow);
			
			
			//Clicking Reading and verifying content
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
			Browser.driver.switchTo().defaultContent();

			//Clicking Project documents and verifying content
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickProjectDocuments();;
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.clickInitiationPhase();
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Initiationphase_Content)[currentRow]);
			app.PG_02_Content.clickClosePopup1();
			app.PG_02_Content.clickPlanningPhase();
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Planningphase_Content)[currentRow]);
			app.PG_02_Content.clickClosePopup2();
			app.PG_02_Content.clickExecutionPhase();
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Executionnphase_Content)[currentRow]);
			app.PG_02_Content.clickClosePopup3();
			app.PG_02_Content.clickClosingPhase();
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Closingphase_Content)[currentRow]);
			app.PG_02_Content.clickClosePopup4();
			Browser.driver.switchTo().defaultContent();
			
			//Clicking and verifying Project Concepts
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickProjectConcept();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_ProjectConcept_content)[currentRow]);
			Browser.driver.switchTo().defaultContent();
			
			//Clicking and verifying outline
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickOutLine();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Outline_content)[currentRow]);
			Browser.driver.switchTo().defaultContent();
			
			//Clicking and verifying Background
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickBackground();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Background_Content)[currentRow]);
			Browser.driver.switchTo().defaultContent();

			//Clicking and verifying Challenge
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickChallenge();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Challenge_Content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			

			//Clicking and verifying Suggested Solutions
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickSuggestedSolution();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Suggested_solution_content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			

			//Clicking and verifying MSProject Content
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickMSPOverview();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_MSProject_Content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			
			
			//Clicking and verifying Project guide Content
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickProjectGuide();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_ProjectGuide_Content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			
 
			//Clicking and verifying Frequently used Content
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickFrequentlyUsedViews();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Frequently_used_content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			
			
			//Clicking and verifying GantChart content
			Browser.driver.switchTo().frame(elementMenu);
			Browser.scrollView(app.PG_01_LessonMenu.getPageObjectsMap().get(ObjectConstants.PG_01_GanttChart));
			app.PG_01_LessonMenu.clickGantChart();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Gantchart_Content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			
			
			//Clicking and verifying Resource and cost sheet content
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickResourceAndCostSheet();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Resourcesheet_content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			

			//Clicking and verifying Project Introduction content
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickProjectIntroduction();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_ProjectIntroduction_content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			

			//Clicking and verifying Summary content
			Browser.driver.switchTo().frame(elementMenu);
			app.PG_01_LessonMenu.clickSummary();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Summary_content)[currentRow]);
			Browser.driver.switchTo().defaultContent();			
		
		}
		Browser.quit();
	}
	
//	@Test
	public void clickNextAndVerifyContent() throws Exception{
		//ConfigReader.getInstance().readConfiguration();
		Browser.report = extent.startTest("Navigation through bottom next", "Click bottom next Link and verify its content");
		String methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		//System.out.println(methodname);
		ConfigReader.getInstance().setTestCaseName(methodname);
		
		Application app = new Application();
		Browser.launchBrowser(ConfigReader.getInstance().getBrowserType(), ConfigReader.getInstance().getUrl());
		Browser.maximize();
		WebElement elementFooter = Browser.driver.findElement(By.id("footer")); 
		WebElement elemContent = Browser.driver.findElement(By.id("content"));
		
				
		ConfigReader.getInstance().setDataRowsCount(0);
		
		for(int currentRow=0; currentRow<=ConfigReader.getInstance().getDataRowsCount(); currentRow++){
			ConfigReader.getInstance().setDataCurrentRow(currentRow);

			Browser.driver.switchTo().frame(elementFooter);
			app.PG_03_Footer.clickNext();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Reading_Content)[currentRow]);
			Browser.driver.switchTo().defaultContent();
			
			//Clicking and verifying Introduction Overview
			Browser.driver.switchTo().frame(elementFooter);
			app.PG_03_Footer.clickNext();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Overview_Content1)[currentRow]);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_Overview_Content2)[currentRow]);
			Browser.driver.switchTo().defaultContent();
			
			//Clicking and verifying Introduction Projects
			Browser.driver.switchTo().frame(elementFooter);
			app.PG_03_Footer.clickNext();
			Browser.driver.switchTo().defaultContent();
			Browser.driver.switchTo().frame(elemContent);
			app.PG_02_Content.verifyText(app.PG_02_Content.getData().get(DataConstants.PG_02_IntroProject_Content)[currentRow]);
			Browser.driver.switchTo().defaultContent();

			//Clicking and verifying Importance Projects
			Browser.driver.switchTo().frame(elementFooter);
			app.PG_03_Footer.clickNext();
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
	
}


