package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Master","Sanity","Regression"})
	public void verify_LoginTest() {

		logger.info("********* verify_LoginTest ********");

		try {
		
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.SetPassword(p.getProperty("password"));
			lp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExist();
			
			if (targetpage) {
				Assert.assertTrue(true);
			} else {
				logger.info("Login Failed");
				Assert.fail();
			}
		} catch (Exception e) {
			logger.info("Login Failed");
			Assert.fail();
		}
		logger.info("********* verify_LoginTest ********");
	}
	
	@Test
	public void TestScenario2() {
		System.out.println("Test Scenario2 executed");
	}

	@Test
	public void TestScenario3() {
		System.out.println("Test Scenario3 executed");
	}
}
