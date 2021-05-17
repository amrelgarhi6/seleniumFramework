package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{

	static FileInputStream fis = null;

	String filePath  = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userdata.xlsx";


	public FileInputStream getFileInputStream () 
	{

		try {

			File source = new File(filePath);
			fis = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data File Not Found : Terminating Process !! Please Check Data File");
			//System.exit(0);
		}
		return fis;


	}



	public Object [] [] getExcelFile() throws IOException
	{

		fis = getFileInputStream();

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet   sheet = wb.getSheetAt(0);

		int TotalNumOfRows = (sheet.getLastRowNum());
		int TotalNumOfCols = 4 ;

		String [][] arrayExcelDataStrings = new String [TotalNumOfRows][TotalNumOfCols] ;

		for (int i = 0; i <TotalNumOfRows; i++) 
		{
			for (int j = 0; j <TotalNumOfCols; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelDataStrings[i][j] = row.getCell(j).toString();
			}	
		}
		wb.close();
		return arrayExcelDataStrings;
	}



}
