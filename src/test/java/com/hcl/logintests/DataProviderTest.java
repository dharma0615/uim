package com.hcl.logintests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@DataProvider(name="testSetProvider")
	public Object[][] testSet(){
		
		Object[][] data=new Object[2][2];
		
		data[0][0]="qa1";
		data[0][1]="Dharmarao";
		data[1][0]="qa2";
		data[1][1]="pramee";
		
		return data;
		
	}
	
	@Test (dataProvider="testSetProvider")
	public void useTestSet(String sec, String author) {
		
		System.out.println(sec+"-----"+author);
		
	}

}
