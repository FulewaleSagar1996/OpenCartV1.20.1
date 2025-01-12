package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC003_DDTLogin extends Baseclass{

	@Test(dataProvider="Logindata",dataProviderClass=DataProviders.class,groups="datadrivengroup")//getting dataprovider from diffrent class
	
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("***Starting TC003_DDTLogin test case");
		try {
			
		
		HomePage hp=new HomePage(driver);
		hp.clickmyAccount();
		hp.clicklogin();
		
		logger.info("--Login page start--");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setpass(pwd);
		lp.clickLogin();
		
		logger.info("myaccount page is start");
		myAccountPage myacc=new myAccountPage(driver);
		boolean targetpage=myacc.ismyAccountexit();

		
		if (exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				Assert.assertTrue(true);
				myacc.clickLogout();	
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if (targetpage==true)
			{
				myacc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);

			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC003_DDTLogin test case");
	}
}
