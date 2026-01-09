package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
  WebDriver driver;
  
  public LoginPage(WebDriver driver) {
	  super(driver);
  }
  
  @FindBy(xpath ="//input[@name='email']")
  WebElement emailId;
  
  @FindBy(xpath ="//input[@name='password']")
  WebElement pws;
  
  @FindBy(xpath ="//input[@value='Login']")
  WebElement loginBtn;
  
  public void enterEmail(String emailId) {
	  this.emailId.sendKeys(emailId);
  }
  
  public void enterPws(String pwsd) {
	  pws.sendKeys(pwsd);
  }
  
  public void clickLogin() {
	  loginBtn.click();
  }
}
