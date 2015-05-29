package org.keyword;
//read the excel sheet and POI jar
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	public static String[][] readSheet(String dataTablePath, String sheetName) throws IOException{

		String xlData[][] = null;

		File xlFile = new File(dataTablePath);

		/*step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);

		/*Step3: Access the work book */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount = sheet.getLastRowNum()+1;
		int iColumnCount = sheet.getRow(0).getLastCellNum();

		xlData = new String [iRowCount][iColumnCount];

		for(int i = 0; i <iRowCount; i++ ){
			for(int j = 0; j<iColumnCount; j++){
				HSSFCell cell = sheet.getRow(i).getCell(j);
				xlData[i][j] = cell.getStringCellValue();
			}
		}
		return xlData;
	}

}

/*//Workbook wbWorkbook;
HSSFWorkbook wbWorkbook;
// = new HSSFWorkbook(xlDoc);

//Sheet shSheet;
HSSFSheet shSheet; 
//= wb.getSheet(sheetName);

public void openSheet(String filePath) {
	FileInputStream fs;
	try {
		fs = new FileInputStream(filePath);

		wbWorkbook = new HSSFWorkbook(fs);
		//wbWorkbook = Workbook.getWorkbook(fs);

		shSheet = wbWorkbook .getSheet(0);
		//shSheet = wbWorkbook.getSheet(0);

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public String getValueFromCell(int iColNumber, int iRowNumber) {
	return shSheet.getCell(iColNumber, iRowNumber).getContents();
}

public int getRowCount() {
	return shSheet.getRows();
}

public int getColumnCount() {
	return shSheet.getColumns();
}*/