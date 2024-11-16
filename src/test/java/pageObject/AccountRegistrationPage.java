package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setTxtFirstname(String firstname) {
		txtFirstname.sendKeys(firstname);
	}

	public void setTxtLastname(String lastname) {
		txtLastname.sendKeys(lastname);
	}

	public void setTxtEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTxtTelephone(String telno) {
		txtTelephone.sendKeys(telno);
	}

	public void setTxtPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setTxtConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}

	public void setChkPolicy() {
		this.chkPolicy.click();
	}

	public void setBtnContinue() {
		// sol-1
		btnContinue.click();

		// sol-2
//		btnContinue.submit();

		// sol-3
//		Actions act=new Actions(driver);
//		act.moveToElement(btnContinue).click().perform();

		// sol-4
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", btnContinue);

		// sol-5
//		btnContinue.sendKeys(Keys.RETURN);

		// sol-6
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();

	}

	public String getMsgConfirmation() {
		
		try {
			return msgConfirmation.getText();
		}catch (Exception e) {
			return e.getMessage();
		}
		
	}

}
