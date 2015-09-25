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
import com.staf.controls.Image;
import com.staf.model.Page;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;


public class PG_03_Footer extends Page {
	private Map<String, String[]> data = new HashMap<String, String[]>(); 
	//private int index =  ConfigReader.getInstance().getDataCurrentRow();
	public Map<String, String[]> getData() {
		return data;
	}
	public void setData(Map<String, String[]> data) {
		this.data = data;
	}
	public PG_03_Footer() throws Exception {
		super("PG_03_Footer");
		String [] dataFields = new String[]{};
		this.setData(ExcelReader.readTestData(dataFields));
	}
	
	
	public void clickNext() throws IOException, InterruptedException{
		Image.click(this.getPageObjectsMap().get(ObjectConstants.PG_03_Next));
	}


	
}
