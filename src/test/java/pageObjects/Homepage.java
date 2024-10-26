package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends Baseclass{

	public Homepage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(xpath="//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span")
	WebElement myaccountlink;
	
	@FindBy(xpath="//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")
		WebElement register;
	@FindBy(linkText = "Login")
	WebElement loginlink;
	
public void clickmyaccount() {
	myaccountlink.click();
}
	
	
	public void clickmyregister () {
	
	register.click();
}

	public void clickmylogin() {
		loginlink.click();
	}

}


 