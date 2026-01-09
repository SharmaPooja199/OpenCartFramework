package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends BasePage {
	WebDriver driver;
     
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logOut;
	
	public boolean isMyAccountMsgDisplayed() {
		try {
			return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clkLogout() {
		logOut.click();
	}
}
