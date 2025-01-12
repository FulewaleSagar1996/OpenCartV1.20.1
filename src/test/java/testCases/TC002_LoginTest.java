package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;
import testBase.Baseclass;

public class TC002_LoginTest extends Baseclass
{
	@Test (groups={"sanity","master"})
	public void varify_login()
	{
		logger.info("starting TC002_login test");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickmyAccount();
		hp.clicklogin();
		
		logger.info("--Login page start--");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setpass(p.getProperty("password"));
		lp.clickLogin();
		
		logger.info("myaccount page is start");
		myAccountPage myacc=new myAccountPage(driver);
		boolean targetpage=myacc.ismyAccountexit();
		
		Assert.assertTrue(targetpage);
		//Assert.assertEquals(targetpage, true,"login failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("#####Finished TC002_Login test");
		
	}
	

}
