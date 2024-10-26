package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.loginpage;
import pageObjects.myaccountpage;

public class TC002_logintest extends Baseclass {
	
	@Test (groups ={"Regression","master"})
	public void Verify_login() {
		try {
		Homepage hp = new Homepage (driver);
		hp.clickmyaccount();
		hp.clickmylogin();
		loginpage lp = new loginpage(driver);
		lp.setemail(prop.getProperty("email"));
		lp.setpassword(prop.getProperty("password"));
		lp.clicksubmit();
		myaccountpage mp = new myaccountpage(driver);
Boolean	targetpage =	mp.accountpage();

//Assert.assertEquals(targetpage, true, "loginfailed");
Assert.assertTrue (targetpage)	;
}
	catch (Exception e)
			{
		Assert.fail();
			
		}
	

	
	}

}
