package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilites.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dependsOnMethods = {"verify_LoginTest"}, dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	//,groups = {"Sanity"}
	public void verify_LoginPage(String email, String pwd, String validate) {

		logger.info("********* Start Executing LoginDDT test ********");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.SetPassword(pwd);
			lp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExist();

			if (validate.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (validate.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("********* Finish Executing LoginDDT test ********");

	}
}
