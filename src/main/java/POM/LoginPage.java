package POM;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginPage {
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 username']")public WebElement username_click;
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 password']")public WebElement password_click;
	@FindBy(xpath="//input[@class='button r4 wide primary']")public WebElement loginbtn_click;
	String username;
	String password;
	String Day3;
	String latestDate;
	public WebDriver driver;

	public LoginPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
			
		this.driver=driver;
	
	}
	
	public void LoginDeal() throws CsvValidationException, IOException, InterruptedException {
		String CSV = "C:\\Users\\areya\\Downloads\\Salesforcetasksh (1)\\Salesforcetask\\Credentials.csv";
		CSVReader reader = new CSVReader(new FileReader(CSV));
	    String[] cell;
	    while((cell=reader.readNext())!=null) 
		{ 
			   for(int i=0; i<1 ; i++)
			{
			    username = cell[i];
			    password = cell[i+1];
			}
		}
	    username_click.sendKeys("ranjitha.ravikumar@areya.tech.irgqa");
	    Thread.sleep(2000);
	    password_click.sendKeys("Login@123456");
		Thread.sleep(2000);
		loginbtn_click.click();
		Thread.sleep(10000);
	}
}
