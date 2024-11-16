package testCases;

import org.testng.annotations.Test;

import testBase.BaseClass;

public class test extends BaseClass {
	@Test
	public void abs() {
		TC002_LoginTest tc1=new TC002_LoginTest();
		tc1.verify_LoginTest();
		System.out.println("Execute test");
	}

}
