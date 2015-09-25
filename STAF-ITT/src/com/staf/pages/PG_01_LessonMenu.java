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
		WebElement element = Frame.getElement(this.getPageObjectsMap().get(ObjectConstants.PG_01_Menu));
		//System.out.println(element.getTagName());
		Browser.switchToFrame(element);
	}
	
	public void clickCourseIntroduction() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_CourseIntroduction));
	}
	
	public void clickReadings() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Readings));
	}
	
	public void clickIntroductionOverview() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_IntroductionandOverview));
	}
	
	public void clickIntroductionProject() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_IntroductionProject));
	}	

	public void clickImportanceProject() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_ImportanceOfProjectDocumentation));
	}	

	public void clickProjectManagement() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_ProjectManagementPhases));
	}	

	public void clickProjectDocuments() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_ProjectDocuments));
	}
	
	public void clickProjectConcept() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_ProjectConcept));
	}

	public void clickOutLine() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Outline));
	}	

	public void clickBackground() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Background));
	}
	
	public void clickChallenge() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Challenge));
	}
	
	public void clickSuggestedSolution() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_SuggestedSolution));
	}
	
	public void clickMSPOverview() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_MicrosoftProject));
	}
	
	public void clickProjectGuide() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_ProjectGuide));
	}
	
	public void clickFrequentlyUsedViews() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_FequentlyUsedViews));
	}
	
	public void clickGantChart() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_GanttChart));
	}
	
	public void clickResourceAndCostSheet() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_ResourceAndCostSheet));
	}
	
	public void clickProjectIntroduction() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_ProjectIntroduction));
	}
	
	public void clickSummary() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Summary));
	}
	
}
