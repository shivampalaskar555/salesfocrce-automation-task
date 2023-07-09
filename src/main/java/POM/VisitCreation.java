package POM;

import java.time.Duration;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class VisitCreation {
	WebDriver driver;
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 username']")WebElement username_click;
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 password']")WebElement password_click;
	@FindBy(xpath="//input[@class='button r4 wide primary']")WebElement loginbtn_click;
	@FindBy(xpath="//div[@class='slds-icon-waffle']")WebElement ClickOnDots;
	@FindBy(xpath="(//input[@class='slds-input'])[2]")WebElement SearchButton;
	@FindBy(xpath="//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']")WebElement MainSchedule_click;
	@FindBy(xpath="//iframe[@title='accessibility title']")WebElement Iframe;
	@FindBy(xpath="//li[@class='wt-Schedule']")WebElement Schedule_click;
	@FindBy(xpath=" //tr[@id='sirenumHeaderRow']//th")WebElement validateuser_click;
	@FindBy(xpath="//a[@id='menuNextWeek']")WebElement next_click;
	@FindBy(xpath="//table//tr/following-sibling::tr[@id='lockedRowsPlaceholder']/following-sibling::tr/td[2]")WebElement date_click;
	@FindBy(xpath="//div[contains(text(),'New Visit')]")WebElement new_visit;
//	@FindBy(xpath="//tr[@id='sirenumRow_*']/td[2]/div[2]")WebElement Sourcelocator;
	@FindBy(xpath="(//div[@class='staffShift'])[2]")WebElement Sourcelocator;
//	@FindBy(xpath="//tr[@id='sirenumRow_*']/td[2]/div[2]")WebElement Sourcelocator;
	@FindBy(xpath="(//tr[@rownum='17']/td)[2]")WebElement Destinationlocator;
	@FindBy(xpath="//div[@class='sirenumFormElement'][4]//input")WebElement SelectProject;
	@FindBy(xpath="//div[@class='sirenumFormElement'][6]//input")WebElement VisitType;
	@FindBy(xpath="//div[@class='sirenumFormElement'][7]//input")WebElement VisitNumber ;
	@FindBy(xpath="//div[@class='sirenumFormElement'][8]//input")WebElement Participant ;
	@FindBy(xpath="//div[@class='sirenumFormElement'][9]//input")WebElement ParticipantLocation ;
	@FindBy(xpath="//*[@id='miniFormSave']")WebElement FormSave ;
	@FindBy(xpath="//*[@id='menuTopSave']")WebElement TopSave ;
	@FindBy(xpath="//span[@class='uiImage']")WebElement ClickonProfile ;
	
	@FindBy(xpath="//a[@class='profile-link-label logout uiOutputURL']")WebElement Logout ;
	
	@FindBy(xpath="//tr[@id='sirenumHeaderRow']")WebElement scale ;

	
public VisitCreation(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
}
public void VisitCreations() throws InterruptedException, CsvValidationException, IOException
{
	  
	String CSV = "C:\\Users\\areya\\eclipse-workspace\\Salesforcetask\\Credentials.csv";
	CSVReader reader = new CSVReader(new FileReader(CSV));
    String[] cell;
    while((cell=reader.readNext())!=null)  // check for file should have the data
	{ 
		   for(int i=0; i<1 ; i++)
		{
		   String username = cell[i];
		   String password = cell[i+1];
		username_click.sendKeys(username);
    	Thread.sleep(2000);
    	password_click.sendKeys(password);
		}
	}
	Thread.sleep(2000);
	loginbtn_click.click();
	Thread.sleep(10000);
    ClickOnDots.click();
    WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(150));
	wait2.until(ExpectedConditions.visibilityOf(SearchButton));
	SearchButton.click();
	SearchButton.sendKeys("Illingworth");
	SearchButton.sendKeys(Keys.ENTER);
	Thread.sleep(10000);
    
	wait2.until(ExpectedConditions.visibilityOf(MainSchedule_click));
	MainSchedule_click.click();			
	
    Thread.sleep(20000);
    driver.switchTo().frame(Iframe);
	
  String Date= scale.getText();
   if(Date.contains("Saturday, 15/07/2023"))
   {System.out.println("date is visible");}
   else {
	   next_click.click();
	   Thread.sleep(10000);
   }
  
   List<WebElement> xyz=driver.findElements(By.xpath("//table//tr//th[@id='sirenumStatus']/following-sibling::th"));
   System.out.println(xyz.size());  
   for (int i=1; i<=xyz.size(); i++)
   {
	   String Text =driver.findElement(By.xpath("(//table//tr//th[@id='sirenumStatus']/following-sibling::th)["+i+"]")).getText();
	   System.out.println(Text);
	   System.out.println(i);
	   if(Text.equalsIgnoreCase("Tuesday, 18/07/2023"))
	   {
		   System.out.println(Text);
	//	   String Text1 =driver.findElement(By.xpath("(//table//tr//th[@id='sirenumStatus']/following-sibling::th/parent::tr/following-sibling::tr[@id='sirenumRow_*']//td)["+i+"]")).getText();
		 WebElement pqr=driver.findElement(By.xpath("(//tr[@id='sirenumRow_*']/td)["+(i+1)+"]"));
		   Actions act1 = new Actions(driver);
			act1.moveToElement(pqr).contextClick().build().perform();
			new_visit.click();
			break;
	   }   
   }
   
//   String Date1= scale.getText();
//   System.out.println(Date1);
	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(150));
//	wait1.until(ExpectedConditions.visibilityOf(validateuser_click));
//	wait1.until(ExpectedConditions.visibilityOf(next_click));
//	next_click.click();
	Thread.sleep(10000);
	wait1.until(ExpectedConditions.visibilityOf(date_click));
	
//	String beforexpath="(//table//tr/following-sibling::tr[@id='lockedRowsPlaceholder']/following-sibling::tr/td[";
//	String afterxpath="])";
//	
//	
//	for(int i=2; i<=15; i++)9
//   {
//		
//		String date=driver.findElement(By.xpath(beforexpath+ i +afterxpath)).getText();
//		System.out.println(date);
//		if(date.equalsIgnoreCase("Tuesday, 18/07/2023"))
//			
//		{
//			System.out.println(i+"My port");
//			WebElement pott=driver.findElement(By.xpath("(//table//tr/following-sibling::tr[@id='lockedRowsPlaceholder']/following-sibling::tr/td["+i+"])"));
//			System.out.println(pott);
//			pott.click();
//			Actions act1 = new Actions(driver);
//			act1.moveToElement(pott)[.contextClick().build().perform();
//			new_visit.click();
//		}
//		
//	}
//	Actions act1 = new Actions(driver);
//	act1.moveToElement(date_click).contextClick().build().perform();
//	new_visit.click();
//	
//	
	String CSV1 = "C:\\Users\\areya\\eclipse-workspace\\Salesforcetask\\Visitdetails.csv";
	CSVReader reader1 = new CSVReader(new FileReader(CSV1));
    String[] cell1;
    while((cell1=reader1.readNext())!=null)  // check for file should have the data
	{ 
		   for(int i=0; i<1 ; i++)
		{
		   String selectproject = cell1[i];
		   String visittype = cell1[i+1];
		   String visitnumber = cell1[i+2];
		   String noofParticipants = cell1[i+3];
		   String location = cell1[i+4];
		   
		SelectProject.sendKeys(selectproject);
    	Thread.sleep(4000);
    	SelectProject.sendKeys(Keys.ENTER);
      	Thread.sleep(4000);
      	VisitType.sendKeys(visittype);
    	Thread.sleep(5000);
    	VisitType.sendKeys(Keys.ENTER);
    	VisitNumber.sendKeys(visitnumber);
    	VisitType.sendKeys(Keys.TAB);
    	Thread.sleep(4000);
    	Participant.sendKeys(noofParticipants);
    	Thread.sleep(4000);
    	Participant.sendKeys(Keys.ENTER);
    	ParticipantLocation.sendKeys(location);
    	Thread.sleep(3000);
    	ParticipantLocation.sendKeys(Keys.ENTER);
		}
	}
	//*******************************************************************************************//
////	act1.moveToElement(date_click).doubleClick(date_click).build().perform();
//	SelectProject.sendKeys("123: Test Project");
//	Thread.sleep(4000);
//	SelectProject.sendKeys(Keys.ENTER);	
//	Thread.sleep(4000);
//	VisitType.sendKeys("Test Visit Type 1");
//	Thread.sleep(4000);
//	VisitType.sendKeys(Keys.ENTER);	
//	VisitNumber.sendKeys("73");
//	VisitType.sendKeys(Keys.TAB);
//	Thread.sleep(4000);
//	Participant.sendKeys("100");
//	Thread.sleep(4000);
//	Participant.sendKeys(Keys.ENTER);
//	ParticipantLocation.sendKeys("100-USA");
//	Thread.sleep(3000);
//	ParticipantLocation.sendKeys(Keys.ENTER);
//	
//	//****************************************************************************************************//
//	Thread.sleep(10000);
//	wait1.until(ExpectedConditions.visibilityOf(FormSave));
//	JavascriptExecutor j32= (JavascriptExecutor) driver;
//	j32.executeScript("arguments[0].click();", FormSave);
//	Thread.sleep(20000);
//	act1.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
//	Thread.sleep(7000);
//	TopSave.click();
//	Thread.sleep(5000);
//    driver.quit();

}	
}
