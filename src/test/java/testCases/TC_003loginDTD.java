package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.loginpage;
import pageObjects.myaccountpage;
import ultlities.Dataprovider;

/* Data is valid - login success - test pass -logout
data is valid -- login failed - test fail
Data is invalid - login success - test fail - logout

 */

public class TC_003loginDTD extends Baseclass {
	
	@Test (dataProvider ="LoginData", dataProviderClass=Dataprovider.class, groups ="datadriven"  )
	public void verify_loginDTD(String email, String pwd, String exp) {
	Homepage hp = new Homepage (driver );
		hp.clickmyaccount();
		hp.clickmylogin();
		loginpage lp = new loginpage (driver);
		lp.setemail(email);
		lp.setpassword(pwd);
		lp.clicksubmit();
		myaccountpage macc = new myaccountpage(driver);
	Boolean targetpage =	macc.accountpage();
	 if (exp.equalsIgnoreCase("valid")) {
		 if (targetpage ==true) {
			 macc.clicklogout();
			 Assert.assertTrue(true);
			 
		 }
		 else {
			 Assert.assertTrue (false);
		 }
		if (exp.equalsIgnoreCase("invalid")) {
			if (targetpage==true) {
				macc.clicklogout();
				Assert.assertTrue (false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	 }
	}
}
		 
	
	



