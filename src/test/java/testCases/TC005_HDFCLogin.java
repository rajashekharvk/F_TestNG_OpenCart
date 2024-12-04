package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HDFCLoginPage;
import testBase.BaseClass;

public class TC005_HDFCLogin extends BaseClass {
	
	@Test()  // invocationCount =4 --if the steps failed, then in next iteration its passing but it ownt execute from the 1st step
	public void HDFCLogin() {
		boolean flag=true;
		logger.info("********* verify_HDFCLoginTest ********");
		try {
			List<WebElement> lst=driver.findElements(By.xpath("//frame"));
			for(int i=0;i<lst.size();i++) {
				driver.switchTo().frame(i);
				try {
					HDFCLoginPage LoginPage=new HDFCLoginPage(driver);
					LoginPage.UserName("asvas");
					LoginPage.ContinueButton();
//					driver.switchTo().defaultContent();
					LoginPage.Password("vasvasv");
					LoginPage.LoginButton();
					System.out.println("Executed Successfully");
					break;
				}catch(Exception e) {
					System.out.println("Object Not Found"); //will not print in Console as we executing as TestNG Suite
					driver.quit();
					flag=false;
//					Assert.fail("Object Not Found"); 
				}
			}
			
		}catch (Exception e) {
			System.out.println(" frame -- Object Not Found");
			flag=false;
			driver.quit();
			Assert.fail("Object Not Found");
		}finally {
			if(flag) {
			logger.info("All Steps Executed Successfully");
			System.out.println("All Steps Executed Successfully");
			}else {
				logger.info("Failed to xecute Successfully");
				System.out.println("Failed to Execute Successfully");
				Assert.fail();
			}
		}
	}

}
