package classroomtask;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel {

		public static String[][] readData(String filename) throws IOException  {

			XSSFWorkbook wb =  new XSSFWorkbook("./data/"+filename+".xlsx");

			XSSFSheet ws = wb.getSheetAt(0);

			//XSSFRow row = ws.getRow(0);
			//XSSFCell cell = row.getCell(0);

			int rowsCount = ws.getLastRowNum();
			
			int cellCount = ws.getRow(0).getLastCellNum();
			
			String[][] data = new String[rowsCount][cellCount];			

			for (int i = 1; i <=rowsCount; i++) {
				for (int j = 0; j <cellCount; j++) {

					String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
					data[i-1][j] = stringCellValue;
					//System.out.println(stringCellValue);	
				}
			}

			wb.close();

  return data;

		}
	}

