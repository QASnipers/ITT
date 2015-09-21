package com.staf;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.staf.common.*;
import com.staf.common.constants.DataConstants;
import com.staf.reader.ConfigReader;

public class MainClass  {
	
	List<WebElement> elem = new ArrayList<WebElement>();
	
	@Test
	public void runScript() throws Exception{
		
		ConfigReader.getInstance().readConfiguration();
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
			
			Browser.driver.switchTo().frame(elementMenu);
			
			app.PG_01_LessonMenu.clickIntroductionOverview();
			
			Browser.driver.switchTo().defaultContent();
			
			app.PG_02_Content.verifyText("Project documentation and communication form the glue that binds the stakeholders together and provide a clear understanding of project requirements.");
			

		}
		Browser.quit();
	}
}


