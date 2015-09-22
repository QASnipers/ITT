package com.staf.controls;


import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.staf.common.Browser;
import com.staf.model.Actions;
import com.staf.model.UIObject;

public class Checkbox extends Actions{
	
	
	public static void select(UIObject obj, String status){
		WebElement element = action(obj);
		if(status.equalsIgnoreCase("on")){
			if(element.getAttribute("checked")==null){
				element.click();
			}
		}else if(status.equalsIgnoreCase("off")){
			if(element.getAttribute("checked")!=null){
				element.click();
			}
		}
		Browser.report.log(LogStatus.INFO, "Clicked Checkbox " +element.getText());
	}
	//To do methods for List of Unchecked checkboxes and List of checked checkboxes

}

