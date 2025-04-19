package com.hcl.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	

	
public boolean retry(ITestResult result) {
	
	int retryLimit=3; int counter=0;
	
	for(int i=0;i<retryLimit;i++) {
		if(!result.isSuccess()){
			if(counter<retryLimit) {
				counter++;
				result.setStatus(ITestResult.FAILURE);
				System.out.println(ITestResult.FAILURE);
				return true;
			}else {
				result.setStatus(ITestResult.FAILURE);
			}
			
		}else {
			result.setStatus(ITestResult.SUCCESS);
			System.out.println(ITestResult.SUCCESS);
		}
	}
	
	return false;
}

}
