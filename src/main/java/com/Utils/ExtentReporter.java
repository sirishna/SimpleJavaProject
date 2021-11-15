package com.Utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReporter {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports report = new ExtentReports();
	private static ExtentTest logger;
	private static ThreadLocal<ExtentTest> threadSafe = new InheritableThreadLocal<>();

	public static synchronized void setReportName(String fileName) {

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "//test-output//Extent_Reports//" + fileName + ".html");

		htmlReporter.loadXMLConfig("ExtentReportconfig.xml");
	}

	public static synchronized void testCase(String tsName) {
		report.attachReporter(htmlReporter);
		logger = report.createTest(tsName);
		logger.assignCategory("Sample Java Testing");
		threadSafe.set(logger);
	}

	public static synchronized void pass(String message) throws IOException {
		threadSafe.get().pass(message);
		report.flush();
	}

	public static synchronized void fail(String message) throws IOException {
		threadSafe.get().fail(message);
		report.flush();
	}

	public static synchronized void info(String message) throws IOException {
		threadSafe.get().info(message);
		report.flush();
	}

	public static synchronized void endTest(int failureCount) throws Exception {
		if (failureCount > 0) {
			fail("Validation of test case failed. Total failied validations :" + failureCount);
			report.flush();
		} else {
			pass("Validation on test case passed");
			report.flush();
		}
	}

}