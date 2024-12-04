package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HDFCLoginPage extends BasePage {
	
	public HDFCLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//input[@name='fldLoginUserId']")
	WebElement UserName;
	
	@FindBy(xpath="//a[@class='btn btn-primary login-btn']")
	WebElement ContinueButton;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement Password;
	
	@FindBy(xpath="//*//*[text()='LOGIN']")
	WebElement LoginButton;
	
	public void UserName(String txtUserName) {
		UserName.sendKeys(txtUserName);
	}
	
	public void Password(String txtPassword) {
		Password.sendKeys(txtPassword);
	}
	
	public void ContinueButton() {
		ContinueButton.click();
	}
	
	public void LoginButton() {
		LoginButton.click();
	}
	
	
	

}
