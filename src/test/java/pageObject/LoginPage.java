package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement textEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String EmailAddress) {
		textEmailAddress.sendKeys(EmailAddress);
	}
	
	public void SetPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	

}
