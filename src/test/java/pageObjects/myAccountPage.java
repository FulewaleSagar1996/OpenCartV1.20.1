package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage{
	
	public myAccountPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="By.xpath(\"//h2[normalize-space()='My Account']\")")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public boolean ismyAccountexit()
	{
		try
		{
		return( msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
