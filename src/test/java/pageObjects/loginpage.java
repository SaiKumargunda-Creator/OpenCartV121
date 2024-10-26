package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends Baseclass {

	public loginpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath ="//input[@name='email']")
	WebElement email;
	@FindBy (xpath ="//input[@name ='password']")
	WebElement password;
	@FindBy (xpath = "//button[@type ='submit']")
	WebElement submit;
	
	public void setemail (String sendemail) {
		email.sendKeys(sendemail);
	}
	
	public void setpassword (String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clicksubmit () {
		submit.click();
	}

}

