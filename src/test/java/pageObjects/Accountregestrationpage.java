package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Accountregestrationpage extends Baseclass {

	public Accountregestrationpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@name='firstname']")//name="firstname"
	WebElement txtfirst_name;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlast_name;
	@FindBy(xpath="//input[@name='email']")
	WebElement txtemail;
	 @FindBy(xpath="//input[@id='input-password']")
	 WebElement txtpassword;
	 @FindBy(xpath="//input[@id='input-newsletter']")
	 WebElement btnnewsletter;
	 @FindBy(xpath="//input[@name='agree']")
	 WebElement btnagree;
	 @FindBy(xpath= "//button[@type='submit']")
	 WebElement btncontinue;
	 @FindBy(xpath="//*[@id=\"content\"]/h1")
	 WebElement congratulationstxt;



public void setfirstname(String fname) {
	txtfirst_name.sendKeys(fname);
}

public void setlastname(String lname) {
	txtlast_name.sendKeys(lname);
}
public void setemail (String email) {
	txtemail.sendKeys(email);
}

public void setpassword(String pwd) {
	txtpassword.sendKeys(pwd);
}
public void clicknewletters() {
	Actions act = new Actions(driver);
	act.moveToElement(btnnewsletter).click().perform();
}
public void clickagree() {
	Actions act1 = new Actions(driver);
	act1.moveToElement(btnagree).click().perform();
}
public void clickcontinue() {
	Actions act2 = new Actions(driver);
	act2.moveToElement(btncontinue).click().perform();
}

public String msgconfirmation() {
	try {
	return(	congratulationstxt.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
	}
}
	
}

	


