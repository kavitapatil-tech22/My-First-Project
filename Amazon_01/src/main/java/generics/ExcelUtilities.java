package generics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
/**
 * 
 * @author Kavita
 *
 */

public class ExcelUtilities {
	/**
	 * to get the data from excel
	 * @param sheetName
	 * @param rownum
	 * @param columnNum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	
	@DataProvider(name="LoginData")
	public String[][] FetchExcelLoginData() throws IOException 
	{
		FileInputStream fis=new FileInputStream(AutoConstant.LoginData_excelpath);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Login_Details");
		int noOfRows=sheet.getPhysicalNumberOfRows();
		int noOfColumns=sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[noOfRows-1][noOfColumns];
		
		for(int i=0;i<noOfRows-1;i++)
		{
			for(int j=0;j<noOfColumns;j++)
			{
				DataFormatter df= new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));						  				
			}
		}
		workbook.close();
		fis.close();
		return data;
		
	}
	@DataProvider(name="EditProfileData")
	public String[][] FetchExcel_EditProfileData() throws IOException 
	{
		FileInputStream fis=new FileInputStream(AutoConstant.ProfileData_excelpath);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Profile_Details");
		int noOfRows=sheet.getPhysicalNumberOfRows();
		int noOfColumns=sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[noOfRows-1][noOfColumns];
		
		for(int i=0;i<noOfRows-1;i++)
		{
			for(int j=0;j<noOfColumns;j++)
			{
				DataFormatter df= new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));						  				
			}
		}
		workbook.close();
		fis.close();
		return data;
		
	}
	
	String ExcelFilename="LoginData";
	public String getExcelData(String sheetName,int rownum,int columnNum) throws Throwable {
		FileInputStream fis=new FileInputStream(AutoConstant.LoginData_excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(ExcelFilename);
		Row row = sh.getRow(rownum);
		wb.close();
		return row.getCell(columnNum).getStringCellValue();
	}
	
	public String getusername(String username) throws EncryptedDocumentException, IOException {
		 
	    FileInputStream file=new FileInputStream(AutoConstant.LoginData_excelpath);
		Workbook w1 =WorkbookFactory.create(file);					
	    return  username= NumberToTextConverter.toText(w1.getSheet("Login_Details").getRow(1).getCell(0).getNumericCellValue());			
	}
	
	public String getpwd(String password) throws EncryptedDocumentException, IOException {
	  
	   FileInputStream file=new FileInputStream(AutoConstant.LoginData_excelpath);
	   Workbook w1 =WorkbookFactory.create(file);	
	   
	   return password = w1.getSheet("Login_Details").getRow(1).getCell(1).getStringCellValue();
	}
	
	/**
	 * to write the data in excel
	 * @param sheetname
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 * @throws IOException
	 */
	
	public void setExcelData(String sheetname,int rowNum,int colNum, String data) throws Throwable {
		FileInputStream fis=new FileInputStream(AutoConstant.LoginData_excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(AutoConstant.LoginData_excelpath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * to get the number of rows which are containing the data
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(AutoConstant.LoginData_excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		return sh.getLastRowNum();
	}
}
