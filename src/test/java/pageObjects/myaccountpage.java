package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myaccountpage extends Baseclass {

	public myaccountpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath ="//h2[@xpath='1']")
	WebElement msgheading;
	@FindBy(xpath ="//div[@Class =\"list-group mb-3\"]/a[text() = \"Logout\"]")
	WebElement lnklogout;
	
  public boolean accountpage() {
	  try {
		  return (msgheading.isDisplayed());
	  }
		  
	  catch (Exception e){
		  return false;
		  
	  }
		  
	  
		  }
  
  public void clicklogout() {
	  lnklogout.click();
  }
	  }
