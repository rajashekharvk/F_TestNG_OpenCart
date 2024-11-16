package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Master","Sanity"})
	public void verify_account_registration() {

		logger.info("***** Starting execution TC001_AccountRegistrationTest ****** ");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Click on MyAccount menu ");
			hp.clickRegister();
			logger.info("Click on Register sub menu option ");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Updating User details for registration ");
			regpage.setTxtFirstname(randomString().toUpperCase());
			regpage.setTxtLastname(randomString().toUpperCase());
			regpage.setTxtEmail(randomString() + "@gmail.com");
			regpage.setTxtTelephone(randomNumber());
			String Password = randomAlphaNumeric();
			regpage.setTxtPassword(Password);
			regpage.setTxtConfirmPassword(Password);
			regpage.setChkPolicy();
			regpage.setBtnContinue();
			logger.info("Validating expected message ");
			String confmmsg = regpage.getMsgConfirmation();
			if (confmmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug Logs..");
				Assert.fail();
			}

		} catch (Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug Logs..");
			Assert.fail();
		}

		logger.info("***** Ending execution TC001_AccountRegistrationTest ****** ");

	}

}
