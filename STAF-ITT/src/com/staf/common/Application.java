package com.staf.common;

import com.staf.pages.*;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;

public class Application {
	public Browser browser = new Browser();
	public PG_01_LessonMenu PG_01_LessonMenu = new PG_01_LessonMenu();
	public PG_02_Content PG_02_Content = new PG_02_Content();
	public PG_03_Footer PG_03_Footer  = new PG_03_Footer() ;
	
	public Application() throws Exception {		
		//ConfigReader.getInstance().readConfiguration();
		String testDataFile = ConfigReader.getInstance().getTestDataFilesPath();
		String sheetName = ConfigReader.getInstance().getTestCaseName();
		int rowCount = ExcelReader.getDataRowCount(testDataFile, sheetName);
		  if(rowCount <= 0){
			  System.out.println("No column names or data found in the data file. File Name: "+ testDataFile 
					  			 + " Sheet Name: "+sheetName);
		  }else if(rowCount == 1){
			  rowCount = 0;
		  }
		  else {
			  ConfigReader.getInstance().setDataRowsCount(rowCount-2);
		  }
	}

}
