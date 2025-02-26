package com.hcl.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			ExtentSparkReporterConfig config=sparkReporter.config();
			
			config.setReportName("Automation Test Results");
			config.setDocumentTitle("Extent Report");
			config.setTheme(Theme.DARK);
			config.setTimeStampFormat("dd-MM-yyyy hh:mm::ss");
				

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Tester", "Dharmrao Marada");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser", "Chrome");
		}
		return extent;
	}
}
