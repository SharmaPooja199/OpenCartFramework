package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.*;

import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC002_LoginTestWithoutDDT extends BaseClass {

	@Test(groups = {"Sanity","Master"})
	public void verifyLogin() {
		logger.info("**Starting VerifyLoginTest**");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.goToLogin();

			LoginPage lp = new LoginPage(driver);
			lp.enterEmail(p.getProperty("email"));
			lp.enterPws(p.getProperty("password"));
			lp.clickLogin();

			// MyAccount
			MyAccountPage ap = new MyAccountPage(driver);
			boolean headingDisplayed = ap.isMyAccountMsgDisplayed();
			// Assert.assertEquals(headingDisplayed, true, "Login Failed");
			Assert.assertEquals(headingDisplayed, true);
		} 
		catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("*** Finished LoginTese ***");
	}
}
