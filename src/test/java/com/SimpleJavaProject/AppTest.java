package com.SimpleJavaProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.Utils.ExtentReporter;

public class AppTest {

	@BeforeSuite
	public void setUp() {
		System.out.println("Started Tests");
		ExtentReporter.setReportName("Sample_Java_Tests");
	}

	@Test
	public void testFindMax1() throws IOException {
		ExtentReporter.testCase("testFindMax1");
		ExtentReporter.info("testFindMax1");
		int maxNumberfromArray1 = App.findMax(new int[] { 456, 58, 44561, 256 });
		System.out.println(maxNumberfromArray1);
		System.out.println("Test 1 Executed Successfully!");
	}

	@Test
	public void testFindMax2() throws IOException {
		ExtentReporter.testCase("testFindMax2");
		ExtentReporter.info("testFindMax2");
		int maxNumberfromArray2 = App.findMax(new int[] { 1, 3, 4, 2 });
		System.out.println(maxNumberfromArray2);
		System.out.println("Test 2 Executed Successfully!");
	}

	@Test
	public void testFindMax3() throws IOException {
		ExtentReporter.testCase("testFindMax3");
		ExtentReporter.info("testFindMax3");
		int maxNumberfromArray3 = App.findMax(new int[] { 111, 6568, 89, 235 });
		System.out.println(maxNumberfromArray3);
		System.out.println("Test 3 Executed Successfully!");
	}

	@Test
	public void testFindMax4() throws IOException {
		ExtentReporter.testCase("testFindMax4");
		ExtentReporter.info("testFindMax4");
		int maxNumberfromArray4 = App.findMax(new int[] { 7, 9, 5, 4 });
		System.out.println(maxNumberfromArray4);
		System.out.println("Test 4 Executed Successfully!");
	}
	
	@AfterTest
	public void closeUp() {
		System.out.println("Completed Tests");
	}
}
