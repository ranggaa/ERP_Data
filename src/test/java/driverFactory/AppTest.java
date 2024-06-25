package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.pages.CustomerPage;

import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil{
	String inputpath ="./FileInput/TestData.xlsx";
	String outputpath ="./FileOutPut/DataDrivenResults.xlsx";
	String TestData="Customer";
	@Test
	public void startTest() throws Throwable
	{
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int rc =xl.rowCount(TestData);
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String cname =xl.getCellData(TestData, i, 0);
			String Address =xl.getCellData(TestData, i, 1);
			String City =xl.getCellData(TestData, i, 2);
			String Country =xl.getCellData(TestData, i, 3);
			String Cperson =xl.getCellData(TestData, i, 4);
			String pnumber =xl.getCellData(TestData, i, 5);
			String email =xl.getCellData(TestData, i, 6);
			String Mnumber =xl.getCellData(TestData, i, 7);
			String notes =xl.getCellData(TestData, i, 8);
			CustomerPage cus =PageFactory.initElements(driver, CustomerPage.class);
			boolean res =cus.addCustomer(cname, Address, City, Country, Cperson, pnumber, email, Mnumber, notes);
			if(res)
			{
				xl.setCellData(TestData, i, 9, "Pass", outputpath);
			}
			else
			{
				xl.setCellData(TestData, i, 9, "Fail", outputpath);
			}
		}
	}

}
