package com.hcl.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentReportManager.getInstance();
	private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
	private static WebDriver driver; // WebDriver instance for taking screenshots

	public static void setDriver(WebDriver driver) {
		TestListener.driver = driver;
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		testThread.set(test);
		test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testThread.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testThread.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
		String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
		if (screenshotPath != null) {
			testThread.get().addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testThread.get().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	private String captureScreenshot(String methodName) {
		if (driver == null) {
			return null;
		}
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + methodName + "_"
				+ timestamp + ".png";
		System.out.println(screenshotPath);
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotPath);

		try {
			Files.copy(srcFile.toPath(), destFile.toPath());
			return screenshotPath;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}