package com.pack.PageObjectFramework.listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pack.PageObjectFramework.InvokeBrowser;
import com.pack.PageObjectFramework.constants.ApplicationConstants;
import com.pack.PageObjectFramework.extentReport.ExtentReporterNG;
import com.pack.PageObjectFramework.utility.Utilities;

public class Listeners extends InvokeBrowser implements ITestListener {

	ExtentTest tests;

	Utilities utilities = new Utilities();

	ExtentReports extentReports = ExtentReporterNG.getReportObject();

	ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();

	@Override

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		String testMethodName = result.getMethod().getMethodName();
		tests = extentReports.createTest(testMethodName);
		threadLocalTest.set(tests);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		threadLocalTest.get().log(Status.PASS, ApplicationConstants.PASS_STATUS);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		threadLocalTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ITestListener.super.onTestFailure(result);
		String testMethodName = result.getMethod().getMethodName();
		threadLocalTest.get().addScreenCaptureFromPath(utilities.takeScreenShot(driver, testMethodName),
				testMethodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extentReports.flush();
	}

}
