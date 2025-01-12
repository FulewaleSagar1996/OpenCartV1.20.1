package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath="(//input[@id='input-firstname'])")
WebElement txtFirstname;
@FindBy(xpath="(//input[@id='input-lastname'])")
WebElement txtLastname;
@FindBy(xpath="(//input[@id='input-email'])")
WebElement txtEmail;
@FindBy(xpath="(//input[@id='input-telephone'])")
WebElement txtcontactno;
@FindBy(xpath="(//input[@id='input-password'])")
WebElement txtpassword;
@FindBy(xpath="(//input[@id='input-confirm'])")
WebElement txtconfirmpassword;
@FindBy(xpath="(//input[@name='agree'])")
WebElement chkPolicy;
@FindBy(xpath="(//input[@value='Continue'])")
WebElement btnContinue;
@FindBy(xpath="(//div[@id=\"content\"]/child::h1)")
WebElement confirmsg;

public void setFirstname(String fname)
{
	txtFirstname.sendKeys(fname);
}

public void setLastname(String lname)
{
	txtLastname.sendKeys(lname);
}

public void setEmail(String email)
{
	txtEmail.sendKeys(email);
}
public void setContactNo(String contact)
{
	txtcontactno.sendKeys(contact);
}

public void setPass(String pass)
{
	txtpassword.sendKeys(pass);
}
public void setconfirmPass(String cnfpass)
{
	txtconfirmpassword.sendKeys(cnfpass);
}

public void chkPrivacypolicy()
{
	chkPolicy.click();
}

public void clickContinue()
{
	btnContinue.click();
}	

//it is not validation..it alwys in test cases not here..
public String getconfirmationmsg() {
	try {
		return (confirmsg.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}
}

}
