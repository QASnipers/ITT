package com.staf.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.staf.common.Browser;
import com.staf.common.constants.DataConstants;
import com.staf.common.constants.ObjectConstants;
import com.staf.controls.*;
import com.staf.model.Page;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;

public class PG_01_LessonMenu extends Page{
	
	private Map<String, String[]> data = new HashMap<String, String[]>(); 
	//private int index =  ConfigReader.getInstance().getDataCurrentRow();
	public Map<String, String[]> getData() {
		return data;
	}


	public void setData(Map<String, String[]> data) {
		this.data = data;
	}

	public PG_01_LessonMenu() throws Exception  {
		super("PG_01_LessonMenu");

	}

	public void switchToMenuFrame(){
		WebElement element = Frame.getEelement(this.getPageObjectsMap().get(ObjectConstants.PG_01_Menu));
		//System.out.println(element.getTagName());
		Browser.switchToFrame(element);
	}
	
	public void clickCourseIntroduction() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_CourseIntroduction));
		Browser.captureScreen("Clicked " + this.getPageObjectsMap().get(ObjectConstants.PG_01_CourseIntroduction).getObjectName() );
	}
	
	public void clickReadings() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Readings));
		Browser.captureScreen("Clicked " + this.getPageObjectsMap().get(ObjectConstants.PG_01_Readings).getObjectName() );
	}
	
	public void clickIntroductionOverview() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_IntroductionandOverview));
		Browser.captureScreen("Clicked " + this.getPageObjectsMap().get(ObjectConstants.PG_01_IntroductionandOverview).getObjectName() );
	}
	
	

}
