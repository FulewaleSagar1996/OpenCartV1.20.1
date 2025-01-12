package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//constructor
public class HomePage extends BasePage 
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}

//locators
@FindBy(xpath="//span[text()='My Account']")
WebElement lnkmyaccount;
@FindBy(xpath="//a[text()='Register']")
WebElement lnkRegister; 
@FindBy(xpath="By.xpath(\"//a[normalize-space()='Login']\")")
WebElement lnklogin;

//actions
public void clickmyAccount()
{
	lnkmyaccount.click();
}
public void clickRegister()
{
	lnkRegister.click();
}
public void clicklogin()
{
	lnklogin.click();
}

}
