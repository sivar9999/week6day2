package week6.Day2.CRA;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public static String[][] testData(String sheetName) throws IOException {
		// TODO Auto-generated method stub
		//ArrayList<String> data = new ArrayList<String>();
		XSSFWorkbook workBook = new XSSFWorkbook("./data/readData.xlsx");

		XSSFSheet workSheet = workBook.getSheet(sheetName);

		int rowCount = workSheet.getLastRowNum();
		int colCount = workSheet.getRow(0).getLastCellNum();
		System.out.println("Row count : "+ rowCount);
		System.out.println("Column count : "+ colCount);
	String[][] data = new String[rowCount] [colCount];
	//	ArrayList<String> data = new ArrayList<String>();
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data [i-1][j] = workSheet.getRow(i).getCell(j).getStringCellValue();
//String cellValue = workSheet.getRow(i).getCell(j).getStringCellValue();
//data.add(cellValue);
				//System.out.println(data[i-1][j]);
			}

		}
		workBook.close();
		return data;
	}
}

