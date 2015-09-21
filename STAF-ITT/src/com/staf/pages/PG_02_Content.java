package com.staf.pages;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.staf.common.Browser;
import com.staf.common.constants.DataConstants;
import com.staf.common.constants.ObjectConstants;
import com.staf.controls.Frame;
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
		String [] dataFields = new String[]{"Reading_Content"};
		this.setData(ExcelReader.readTestData(dataFields));
	}
	
	public void switchToContentFrame(){
		Browser.switchToDefaultContent();
		WebElement element = Frame.getEelement(this.getPageObjectsMap().get(ObjectConstants.PG_02_Content));
		Browser.switchToFrame(element);
	}
	
	public void verifyText(String s) throws IOException, InterruptedException{
		boolean b = false;
		b = Browser.isTextVisible(s);
		
		if(b == true){
			Browser.captureScreen("Expected text found");
		}else{
			Browser.captureScreen("Expected text not found");
		}
	}

}
