package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
public static void explicitWait_clickAction(WebDriver driver, WebElement element )
{
	WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait3.until(ExpectedConditions.elementToBeClickable(element));
	element.click();
	
}
public static void explicitWait_sendkAction(WebDriver driver, WebElement element, String Data )
{
	WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait3.until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(Data);
}
}
