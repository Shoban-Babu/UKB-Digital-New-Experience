package bgb.Service.Page;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Listener.Reporter;
import bgb.CommonProperties.PropertyLoader;
import bgb.CommonProperties.BasePage;

public class LoginPage extends BasePage{

    private final static String Login_File = "BGB/CommonProperties/Dev.properties";
    private static Properties Loginproperties = new PropertyLoader(Login_File).load();

    private final static String File_Load = "BGB/Service/Properties/LoginPageProperties";
    private static Properties pageProperties = new PropertyLoader(File_Load).load();


    public void login_verify() throws Throwable
    {
        browserWait(5000);
        browser.get(Loginproperties.getProperty("Common.BGBURL") + "/business/login/");
        Reporter.addScenarioLog("Automation Log");
        Reporter.addStepLog("Login Page Entered Successfully");
        Reporter.addScreenCaptureFromPath("C:/Users/473415/git/Lift and Shift New/test-output/Cucmber-ExtendReport/reportdate1.png", "LoginPage");
    }

    public void login_to_account_overview()
    {
        browserWait(8000);
        verifyInputByXpath(pageProperties.getProperty("Login.Username"),"bgbqas02_563@bgdigitaltest.co.uk","User name");
        verifyInputByXpath(pageProperties.getProperty("Login.password"),"password12","password");
        verifyAndClickwithXpath(pageProperties.getProperty("Login.LoginButton"),"Login Button");

    }

    public void enter_username()
    {
        browserWait(3000);
        verifyInputByID(pageProperties.getProperty("Login.Username"),"bgbqas02_563bgdigitaltest.co.uk","User name");

        verifyInputByID(pageProperties.getProperty("Login.password"),"password","password");

        Assert.assertTrue("Hello", browser.findElement(By.id(pageProperties.getProperty("Login.password"))).isDisplayed());
        System.out.println("AssertDone");
    }

    public void Error_validation()
    {
        String user = "Please check your email address, it doesn't seem right.";
        String password = "Your password needs to be between 8-32 characters, must contain letters & numbers, may include: ! # % *";

        String usererror = verifyAndGetTextByXpath(pageProperties.getProperty("Login.usernameerror"));
        browserWait(3000);

        System.out.println(usererror);

        new WebDriverWait(browser,2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(pageProperties.getProperty("Login.usernameerror"))));
        Assert.assertTrue(user+"Message Displayed Successfully", browser.findElement(By.xpath(pageProperties.getProperty("Login.usernameerror"))).getText().contains(user));


		/*if(user.equals(usererror))
		{
			Reporter.addStepLog("Error message ' " +user+ " ' is  successfully matched" );
			Assert.assertTrue(true);

	    }
		else
		{
			Reporter.addStepLog("Error message is not matching with the String and Expected is :" +user);
			Assert.assertTrue(false);

		}*/

        browserWait(1000);
        verifyAndClickwithid(pageProperties.getProperty("Login.dummyclick"),"");
        browserWait(1000);
        String passworderror = verifyAndGetTextByXpath(pageProperties.getProperty("Login.passworderror"));
        System.out.println(passworderror);
        browserWait(1000);
        if(password.equals(passworderror))
        {
            Reporter.addStepLog("Error message ' " +password+ " ' is  successfully matched");
            Assert.assertTrue(true);
        }
        else
        {
            Reporter.addStepLog("Error message is not matching with the String :" +password);
            Assert.assertTrue(false);
        }
    }
}
