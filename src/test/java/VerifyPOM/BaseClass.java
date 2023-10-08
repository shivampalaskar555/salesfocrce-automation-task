package VerifyPOM;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import POM.ClinicalSiteCreation;
import POM.LoginPage;
import POM.ProjectAccountCreation;
import POM.ProjectCreation;
import POM.ProjectTeamRecordCreation;
import POM.VisitCreation;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	 public static WebDriver driver;
	 public static ChromeOptions options;
	 public static ExtentHtmlReporter HtmlReporter;
	 public static ExtentReports report;
	 public static ExtentTest test;

     LoginPage lg  ;
     VisitCreation vs;
     ClinicalSiteCreation cc;
     ProjectAccountCreation pac;
     ProjectTeamRecordCreation ptc;
     ProjectCreation pc;
	
	@BeforeSuite
	void launchBrowser() {
		WebDriverManager.chromedriver().setup();	
		options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://test.salesforce.com/");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.navigate().refresh();
	    HtmlReporter = new ExtentHtmlReporter("C:\\Users\\areya\\Downloads\\Salesforcetasksh (1)\\Salesforcetask\\Extent Report\\report.html");
	    HtmlReporter.config().setTheme(Theme.DARK);  	
		report = new ExtentReports();  	
	    report.attachReporter(HtmlReporter);
	   
	    
	};
	
	@BeforeClass
	void objects ()
	{
		 lg=new LoginPage(driver);
		 vs= new  VisitCreation (driver);
		 cc=new ClinicalSiteCreation(driver);
		 pac=new ProjectAccountCreation (driver);
		 ptc=new ProjectTeamRecordCreation (driver);
		 pc=new ProjectCreation (driver);
		
	}
	
    @AfterMethod
    void screen(ITestResult result) throws IOException
    {
    	File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	String path0 = "C:\\Users\\areya\\Downloads\\Salesforcetasksh (1)\\Salesforcetask\\screenshot\\failed.png";
    	File path =new File(path0);
    	FileHandler.copy(file1, path);
    	if (result.getStatus()== ITestResult.FAILURE)
    		{
    			test.fail("Test case is failed",MediaEntityBuilder.createScreenCaptureFromPath(path0).build());
    			test.log(Status.FAIL, result.getName());
    			test.log(Status.FAIL, result.getThrowable());				
    		}
    		else
    		{
    			 test.pass("Test case is passed");
    		}
    		report.flush();
    }
    @AfterSuite
    void quiteBrowser()
    {
          driver.quit();
    }
	
}
