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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import utility.Wait;

public class ProjectCreation {
	WebDriver driver;
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 username']")WebElement username_click;
	@FindBy(xpath="//input[@class='input r4 wide mb16 mt8 password']")WebElement password_click;
	@FindBy(xpath="//input[@class='button r4 wide primary']")WebElement loginbtn_click;
	@FindBy(xpath="//div[@class='slds-icon-waffle']")WebElement ClickOnDots;
	@FindBy(xpath="//input[contains(@placeholder,'Search apps and items...')]")WebElement SearchButton;
	@FindBy(xpath="//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']")WebElement MainSchedule_click;
	@FindBy(xpath="//iframe[@title='accessibility title']")WebElement Iframe;
	@FindBy(xpath="//li[@class='wt-Schedule']")WebElement Schedule_click;
	@FindBy(xpath="//tr[@id='sirenumHeaderRow']//th")WebElement validateuser_click;
	@FindBy(xpath="//a[@id='menuNextWeek']")WebElement next_click;
	@FindBy(xpath="//table//tr/following-sibling::tr[@id='lockedRowsPlaceholder']/following-sibling::tr/td[2]")WebElement date_click;
	@FindBy(xpath="//div[contains(text(),'New Visit')]")WebElement new_visit;
	@FindBy(xpath="(//table//tr/following-sibling::tr[@ID='sirenumRow_*']//td)[12]/div[2]")WebElement Sourcelocator;
	@FindBy(xpath="(//tr[@rownum='19']/td)[5]")WebElement Destinationlocator;
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
    String url ="https://illingworthresearchgroup--irgqa.sandbox.lightning.force.com/lightning/page/home";
    SoftAssert pick=new SoftAssert ();
    String username;
    String password;
    String Day3;
    String latestDate;
    @FindBy(xpath="//a[@id='Project_Team__c']//parent::div")WebElement Project_teams;
    @FindBy(xpath="//a[@title='New']")WebElement Clickon_New ;
    @FindBy(xpath="//div[@class='slds-form-element__control slds-grow']")WebElement Give_Project_Name ;
    @FindBy(xpath="//button[@class='slds-button slds-button_brand']")WebElement Save_Button ;
    @FindBy(xpath="//lightning-button-icon[@class='slds-shrink-none change-owner-trigger']")WebElement click_edit ;
    @FindBy(xpath="//div[@class='entityMenu slds-p-left--xxx-small uiMenu']")WebElement click_downward_arrow ;
    @FindBy(xpath="//span[@title='Queues']")WebElement click_queus ;
    @FindBy(xpath="//div[@class='autocompleteWrapper slds-grow']//input")WebElement click_search ;
    @FindBy(xpath="//div[@title='Automation Test']")WebElement click_auotmation_test ;
    @FindBy(xpath="//button[@class='slds-button slds-button_brand']")WebElement change_owner ;
    @FindBy(xpath="//button[contains(text(),'Change Owner')]")WebElement change_owner2 ;
    
    //Account creation
    
    @FindBy(xpath="(//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'])[2]")WebElement click_account;
    @FindBy(xpath="//a[@title='New']")WebElement click_new;
    @FindBy(xpath="//span[@class='slds-radio--faux']")WebElement click_create_account;
    @FindBy(xpath="//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']")WebElement click_next;
    @FindBy(xpath="//div[@class='slds-form-element__control slds-grow']")WebElement click_provide_account_name;
    @FindBy(xpath="//button[@class='slds-button slds-button_brand']")WebElement click_save;
    @FindBy(xpath="(//span[@class='slds-radio--faux'])[3]")WebElement click_project_account;
    @FindBy(xpath="//one-app-nav-bar-menu-button[@class='slds-dropdown-trigger slds-dropdown-trigger--click']")WebElement click_account2;
    @FindBy(xpath="//lightning-icon[@class='slds-icon-text-default slds-m-right--x-small slds-shrink-none slds-icon-utility-add slds-icon_container']//following-sibling::span")WebElement click_new_account;
    @FindBy(xpath="(//input[@class='slds-combobox__input slds-input'])[1]")WebElement click_provide_parent_account;
    @FindBy(xpath="//div//ul//li//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-listbox__option_entity']//span[@class='slds-media__body']")WebElement click_test_account;
    @FindBy(xpath="//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none']")WebElement click_home;
    @FindBy(xpath="(//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-listbox__option_entity'])[2]")WebElement click_TestAutomationproject_account; 
    @FindBy(xpath="//A[@title='Test Automation Project Account']")WebElement click_test_automation_project;
    @FindBy(xpath="(//a[@class='slds-tabs_default__link'])[2]")WebElement click_related;
    @FindBy(xpath="(//button[@class='slds-button slds-button_neutral'])[5]")WebElement click_project_new;
    @FindBy(xpath="//div[@class='slds-form-element__control slds-grow']")WebElement click_project_name;
    @FindBy(xpath="(//div[@class='slds-form-element__control slds-grow'])[4]")WebElement click_opp_number;
    @FindBy(xpath="(//div[@class='slds-form-element__control slds-grow'])[5]")WebElement click_oracle_project;
    @FindBy(xpath="//input[@class='slds-combobox__input slds-input']")WebElement click_project_team;
    @FindBy(xpath="//div//ul//li//lightning-base-combobox-item//span[@class='slds-media__body']")WebElement click_automation_task;
    @FindBy(xpath="(//div[@class='slds-form-element__control slds-grow'])[13]")WebElement click_RN;
    @FindBy(xpath="(//div[@class='slds-form-element__control slds-grow textarea-container'])[4]")WebElement click_off_side_activities;
    
    
    
    @FindBy(xpath="//span[@class='slds-grid slds-grid_align-spread']")WebElement click_Test_auto;
    @FindBy(xpath="//button[contains(text(),'New Site Clinical Trial')]")WebElement click_New_clinical;
    @FindBy(xpath="//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//following-sibling::input")WebElement click_Site_name;
    @FindBy(xpath="(//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//following-sibling::input)[4]")WebElement click_Site_number;
    @FindBy(xpath="(//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//following-sibling::input)[5]")WebElement click_Clinical_site_name;
    @FindBy(xpath="(//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//following-sibling::input)[6]")WebElement click_City;
    @FindBy(xpath="(//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//following-sibling::textarea)[2]")WebElement click_Street_address;
    @FindBy(xpath="//a[@class='select']")WebElement click_Site_region;
    @FindBy(xpath="//div//ul//li//a[contains(text(),'R6')]")WebElement click_R6;
    @FindBy(xpath="(//a[@class='select'])[2]")WebElement click_country;
    @FindBy(xpath="//div//ul//li//a[@title='USA']")WebElement click_USA;
    @FindBy(xpath="(//a[@class='select'])[3]")WebElement click_State;
    @FindBy(xpath="//div//ul//li//a[@title='Alabama']")WebElement click_Albama;
    @FindBy(xpath="//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']")WebElement click_New_clicnicalsite_Save;
    @FindBy(xpath="//a[contains(text(),'Test Automation Project Account')]")WebElement click_Test_auto_projct;
    
 
  
    @FindBy(xpath="(//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'])[4]")WebElement click_Projects;
    @FindBy(xpath="//a[@Title='191: Test Automation Project']")WebElement click_191_Project;
    
    //change//
    @FindBy(xpath="//span[contains(text(),'Test Clinical3 site')]")WebElement click_Test_clinical_site;
    
    @FindBy(xpath="(//lightning-button//button[@class='slds-button slds-button_neutral'])[14]")WebElement click_Partcipants_new;
    @FindBy(xpath="(//div[@class='slds-form-element__control slds-grow']//input[@class='slds-input'])[1]")WebElement click_Partcipants_numbers;
    @FindBy(xpath="(//button[@class='slds-button slds-button_brand'])[2]")WebElement click_New_Partcipants_save;
    @FindBy(xpath="(//a[@class='slds-tabs_default__link'])[2]")WebElement click_Related_191_project;
 //   @FindBy(xpath="(//a[@class='slds-tabs_default__link'])[9]")WebElement click_Related_191_project2;
    @FindBy(xpath="(//a[@id='relatedListsTab__item'])[2]")WebElement click_Related_191_project2;
    
    @FindBy(xpath="//li[@class='slds-tabs_default__item slds-is-active']")WebElement click_Details_191_project;
    
    @FindBy(xpath="(//lightning-formatted-text[contains(text(),'Test Clinical3 site')])[1]")WebElement click_Get_Title;
   
    ///we need to delete all the sites then do the operation
    
public ProjectCreation(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
}    
    public void ProjectCreation() throws InterruptedException {
    	driver.navigate().refresh();
     try {
    	 Wait.explicitWait_clickAction(driver, click_related);
    	 }
    	 catch (Exception e1){
    		 System.out.println("exception is handle");
    	 }
	 Thread.sleep(5000);
	 Wait.explicitWait_clickAction(driver, click_project_new);
	 Wait.explicitWait_sendkAction(driver, click_project_name, "191: Test Automation Project");
	 Thread.sleep(3000);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].scrollIntoView();", click_opp_number);
	 Wait.explicitWait_clickAction(driver, click_opp_number);
	 Wait.explicitWait_sendkAction(driver, click_opp_number, "191");
	 Wait.explicitWait_clickAction(driver, click_oracle_project);
	 Wait.explicitWait_sendkAction(driver, click_oracle_project, "OPP00191");
	 Wait.explicitWait_clickAction(driver, click_project_team);
	 Thread.sleep(3000);
	 Wait.explicitWait_sendkAction(driver, click_project_team, "Automation");
	 Thread.sleep(3000);
	 try {
	 js.executeScript("arguments[0].click();", click_automation_task);
	 }
	 catch (Exception e1){
		 System.out.println("exception is handle");
	 }
	 Thread.sleep(1000);
	 js.executeScript("arguments[0].scrollIntoView();", click_RN);
	 Wait.explicitWait_clickAction(driver, click_RN);
	 Wait.explicitWait_sendkAction(driver, click_RN, "12 Weeks");
	 Thread.sleep(1000);
	 js.executeScript("arguments[0].scrollIntoView();", click_off_side_activities);
	 Wait.explicitWait_clickAction(driver, click_off_side_activities);
	 Wait.explicitWait_sendkAction(driver, click_off_side_activities, "Blood Test, Sugar Test");	
	 Wait.explicitWait_clickAction(driver, click_save);
    }
//    public void ClinicalSiteCreation()throws InterruptedException {
////    	Thread.sleep(3000);
////    	Wait.explicitWait_clickAction(driver, click_home);
////    	Thread.sleep(3000);
////    	
////    	Wait.explicitWait_clickAction(driver, click_account);
////        Wait.explicitWait_clickAction(driver, click_Test_auto_projct);
////        Wait.explicitWait_clickAction(driver, click_related);
////        Thread.sleep(1000);
////    	Wait.explicitWait_clickAction(driver, click_Test_auto);
////    	Wait.explicitWait_clickAction(driver, click_New_clinical);
////    	Wait.explicitWait_clickAction(driver, click_Site_name);
////    	Wait.explicitWait_sendkAction(driver, click_Site_name, "Test Clinical3 site");
////    	Wait.explicitWait_clickAction(driver, click_Site_number);
////    	Wait.explicitWait_sendkAction(driver, click_Site_number, "1290");
////    	Wait.explicitWait_clickAction(driver, click_Clinical_site_name);
////    	Wait.explicitWait_sendkAction(driver, click_Clinical_site_name, "Clinical test3 site");
////    	Wait.explicitWait_clickAction(driver, click_Site_region);
////    	Wait.explicitWait_clickAction(driver, click_R6);
////    	Thread.sleep(1000);
////    	Wait.explicitWait_clickAction(driver, click_Street_address);
////    	Wait.explicitWait_sendkAction(driver, click_Street_address, "12 Test");
////    	Wait.explicitWait_clickAction(driver, click_City);
////    	Wait.explicitWait_sendkAction(driver, click_City, "New York");
////    	Wait.explicitWait_clickAction(driver, click_country);
////    	Wait.explicitWait_clickAction(driver, click_USA);
////    	Wait.explicitWait_clickAction(driver, click_State);
////    	Wait.explicitWait_clickAction(driver, click_Albama);
////    	Wait.explicitWait_clickAction(driver, click_New_clicnicalsite_Save);
////    	Thread.sleep(3000);
//
//    	Wait.explicitWait_clickAction(driver, click_home);
//    	Thread.sleep(5000);
//    	Wait.explicitWait_clickAction(driver, click_Projects);
//    	Thread.sleep(5000);
//    	Wait.explicitWait_clickAction(driver, click_191_Project);
//    	Wait.explicitWait_clickAction(driver, click_Related_191_project);
//    	Wait.explicitWait_clickAction(driver, click_Test_clinical_site);
//    	Thread.sleep(4000);
//    	String xv= click_Get_Title.getText();
//    	System.out.println("here is the title"+ xv);
//    	Wait.explicitWait_clickAction(driver, click_Related_191_project2);
//    	Wait.explicitWait_clickAction(driver, click_Partcipants_new);
//    	Wait.explicitWait_clickAction(driver, click_Partcipants_numbers);
//    	Wait.explicitWait_sendkAction(driver, click_Partcipants_numbers, "1000-1001");
//    	Wait.explicitWait_clickAction(driver, click_New_Partcipants_save);
//  
//    }
//    
}
