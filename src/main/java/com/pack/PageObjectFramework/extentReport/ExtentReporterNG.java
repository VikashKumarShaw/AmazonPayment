package com.pack.PageObjectFramework.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pack.PageObjectFramework.constants.ApplicationConstants;

public class ExtentReporterNG {
	
	static ExtentReports extentReport;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty(ApplicationConstants.BASE_DIRECTORY) + ApplicationConstants.REPORT_PATH;
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName(ApplicationConstants.REPORT_NAME);
		reporter.config().setDocumentTitle(ApplicationConstants.DOCUMENT_TITLE);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo(ApplicationConstants.TESTER, ApplicationConstants.AUTHOR);
		
		return extentReport;		
	}
}
