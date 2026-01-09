package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath ="//input[@name=\"firstname\"]")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@name=\"lastname\"]")
	WebElement lastName;
	
	@FindBy(xpath ="//input[@name=\"email\"]")
	WebElement email;
	
	@FindBy(xpath ="//input[@name=\"telephone\"]")
	WebElement phoneNumber;
	
	@FindBy(xpath ="//input[@name=\"password\"]")
	WebElement pws;
	
	@FindBy(xpath ="//input[@name=\"confirm\"]")
	WebElement confirmPws;
	
	@FindBy(xpath ="//input[@value=\"Continue\"]")
	WebElement continueButton;
	
	@FindBy(xpath ="//input[@name=\"agree\"]")
	WebElement checkPrivacy;
	
	@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement messageConfirmation;
	
	public void setFirstName(String frstname) {
		firstName.sendKeys(frstname);
	}
	
	public void setLastName(String lstname) {
		lastName.sendKeys(lstname);
	}
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setNumber(String tel) {
		phoneNumber.sendKeys(tel);
	}
	
	public void setpws(String pws) {
		confirmPws.sendKeys(pws);
	}
	
	public void confirmPassword(String confirmpws) {
		pws.sendKeys(confirmpws);
	}
	
	public void checkPrivacy() {
		checkPrivacy.click();
	}
	
	public void clickContinue() {
		continueButton.click();
		/*
		//2
		continueButton.submit();
		
		//3
		Actions act = new Actions(driver);
		act.moveToElement(continueButton).click().perform();
		
		//4
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", continueButton);
		
		//5
		continueButton.sendKeys(Keys.RETURN);
		
		//6
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
		
		*/
	}
	public String getConfirmationMessage() {
		try {
			return (messageConfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
