package com.tricentis.dataprovider;

import org.testng.annotations.DataProvider;


import com.tricentis.util.DataUtil;
import com.tricentis.util.MyXLSReader;

public class ForgotPasswordDataProvider {
	MyXLSReader excelReader;

	
	@DataProvider
	public Object dataForVerRcyOfPwdWithWrongEmailTxt() {
		Object data = null;
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\TestData.xlsx");
			data = DataUtil.getTestData(excelReader, "verRcyOfPwdWithWrongEmailTxt", "Forgot Password");
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data; 
	}
	@DataProvider
	public Object dataForVerRcyOfPwdWithNotResEmailTxt() {
		Object data = null;
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\TestData.xlsx");
			data = DataUtil.getTestData(excelReader, "verRcyOfPwdWithNotResEmailTxt", "Forgot Password");
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data; 
	}
	
	@DataProvider
	public Object dataForVerRcyOfPwdWithVldResEmailAdd() {
		Object data = null;
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\TestData.xlsx");
			data = DataUtil.getTestData(excelReader, "verRcyOfPwdWithVldResEmailAdd", "Forgot Password");
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data; 
	}
	
	
}
