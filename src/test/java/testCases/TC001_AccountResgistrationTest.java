package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.Baseclass;

public class TC001_AccountResgistrationTest  extends Baseclass {

	
	
	@Test(groups="regression")
	public void Varify_account_reg_page()
	{
		logger.info("---------Starting test case-----");
		try 
		{
		HomePage hp=new HomePage(driver);
		hp.clickmyAccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setContactNo(randomNumber().toUpperCase());
		
		String password=randomAlphaNumeric();
		regpage.setPass(password);
		regpage.setconfirmPass(password);
		regpage.chkPrivacypolicy();
		regpage.clickContinue();
		
		logger.info("Validating expecting message");
		String cnfmsg=regpage.getconfirmationmsg();
		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed...");
			logger.debug("Debugs logs");
			Assert.fail();
		}
		logger.info("*****Finished test case***");
	}
	
}

