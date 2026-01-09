package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_AccountRegistration extends BaseClass{
	

	
	@Test(groups = {"Regression","Master"})
	public void accountRegistration() {
		   logger.info("** Starting TC_AccountRegistration**");
		   
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Myaccount");
		
		hp.clickOnRegister();
		logger.info("Clicked on MyRegister Page");
		
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString() + "@gmail.com");
		rp.setNumber(randomNumber());
		//Password must be same but if we use randomAlphaNumeric in 
		//confirmpws then it may generate a different pws so store once generated pws and use that.
		String password = randomAlphaNumeric();
		rp.setpws(password);
		rp.confirmPassword(password);
		rp.checkPrivacy();
		rp.clickContinue();
		//Thread.sleep(5000);
		String confirmationMsg = rp.getConfirmationMessage();
		System.out.print("Message is:"+confirmationMsg);
		if(confirmationMsg.equals("Your Account Has Been Created!")) {
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.error("Debug Test");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confirmationMsg,"Your Account Has Been Created!");
	}
	
	

}
