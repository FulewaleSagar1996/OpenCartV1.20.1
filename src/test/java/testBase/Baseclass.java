package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	public static WebDriver driver;
	public Logger logger; //log4j
	public Properties p;
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		
		//loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());  //for generating logs into propertiesa files
		
		switch(br.toLowerCase())  //parallel cross browsing
		{
		case "chrome" : driver=new ChromeDriver();break;
		//case "firefox": driver=new FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default : System.out.println("Invalid browser name.."); return; //return bcz not corret then dont move
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(p.getProperty("appURL1")); //reading url from properties file	
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"sanity","regression","master"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String rndstring=RandomStringUtils.randomAlphabetic(10);
		return rndstring;
	}
	
	public String randomNumber()
	{
		String rndnumber=RandomStringUtils.randomNumeric(5);
		return rndnumber;
	}
	
	public String randomAlphaNumeric()
	{
		String rndstring=RandomStringUtils.randomAlphabetic(3);
		String rndnumber=RandomStringUtils.randomNumeric(3);
		return(rndstring+"@"+rndnumber);
	}
	
	public String captureScreen(String tname) throws IOException {
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    
	    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);
	    
	    sourceFile.renameTo(targetFile);
	    
	    return targetFilePath;
	}


}
