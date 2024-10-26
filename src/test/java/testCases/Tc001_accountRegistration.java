package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Accountregestrationpage;
import pageObjects.Homepage;

public class Tc001_accountRegistration extends Baseclass {


	@Test (groups ={"sanity", "master"})
	public void verify_account_registeration() {
		
		Homepage hp =new Homepage(driver);
		
		hp.clickmyaccount();
		
		hp.clickmyregister();
		
	    
		Accountregestrationpage ap =new Accountregestrationpage(driver);
		ap.setfirstname("david");
		ap.setlastname("john");
		ap.setemail("johndavid@gmail.com");
		ap.setpassword("test123");
		ap.clicknewletters();
		ap.clickagree();
		ap.clickcontinue();
	
		
	String confmsg =	ap.msgconfirmation();
	Assert.assertEquals(confmsg, confmsg);
	
		
	}
}

		
	
	

