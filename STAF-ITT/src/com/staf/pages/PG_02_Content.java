package com.staf.pages;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.staf.common.Browser;
import com.staf.common.constants.DataConstants;
import com.staf.common.constants.ObjectConstants;
import com.staf.controls.Div;
import com.staf.controls.Frame;
import com.staf.controls.Span;
import com.staf.model.Page;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;


public class PG_02_Content extends Page {
	private Map<String, String[]> data = new HashMap<String, String[]>(); 
	//private int index =  ConfigReader.getInstance().getDataCurrentRow();
	public Map<String, String[]> getData() {
		return data;
	}
	public void setData(Map<String, String[]> data) {
		this.data = data;
	}
	public PG_02_Content() throws Exception {
		super("PG_02_Content");
		String [] dataFields = new String[]{"Reading_Content","Overview_Content1","IntroProject_Content","Overview_Content2","Importance_Project_Uniformity_Content",	
											"Importance_Project_Audience_Content",	"Importance_Project_Backtracking_Content",	
											"Importance_Project_Replacement_Content","Initiationphase_Content","Planningphase_Content",
											"Executionphase_Content","Closingphase_Content","ProjectConcept_content","Outline_content",	"Background_Content",	
											"Challenge_Content","Suggested_solution_content","MSProject_Content","ProjectGuide_Content","Frequently_used_content","Gantchart_Content",
											"Resourcesheet_content","ProjectIntroduction_content","Summary_content"};
		
		this.setData(ExcelReader.readTestData(dataFields));
	}
	
	public void switchToContentFrame(){
		Browser.switchToDefaultContent();
		WebElement element = Frame.getElement(this.getPageObjectsMap().get(ObjectConstants.PG_02_Content));
		Browser.switchToFrame(element);
	}
	
	public void verifyText(String s) throws IOException, InterruptedException {
		boolean b = false;
		b = Browser.isTextVisible(s);
		
		if(b == true){
			Browser.captureScreen("Expected text found");
			Browser.report.log(LogStatus.PASS, "Expected text: "+ s +" found in page " +Browser.driver.getTitle());
		}else{
				Browser.captureScreen("Expected text not found");
				Browser.report.log(LogStatus.FAIL, "Expected text: "+ s +" not found in page " +Browser.driver.getTitle());
		}
	}
	
	public void clickContentBox1() throws IOException, InterruptedException{
		Div.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_ContentBox1));
	}

	public void clickContentBox2() throws IOException, InterruptedException{
		Div.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_ContentBox2));
	}


	public void clickContentBox3() throws IOException, InterruptedException{
		Div.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_ContentBox3));
	}

	public void clickContentBox4() throws IOException, InterruptedException{
		Div.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_ContentBox4));
	}
	
	public void clickInitiationPhase() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_initiationphase));
	}
	
	public void clickPlanningPhase() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_planningphase));
	}
	
	public void clickExecutionPhase() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_executionphase));
	}
	
	public void clickClosingPhase() throws IOException, InterruptedException{
		Span.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_closingphase));
	}
	
	public void clickClosePopup1() throws IOException, InterruptedException{
		Div.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_closepopup1));
	}
	
	public void clickClosePopup2() throws IOException, InterruptedException{
		Div.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_closepopup2));
	}

	public void clickClosePopup3() throws IOException, InterruptedException{
		Div.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_closepopup3));
	}

	public void clickClosePopup4() throws IOException, InterruptedException{
		Div.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_closepopup4));
	}
}
