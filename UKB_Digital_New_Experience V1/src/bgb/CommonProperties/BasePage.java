package bgb.CommonProperties;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Listener.Reporter;
import CucumberProperties.CucumberRunner;


public class BasePage {

    public static String Desr;
    public static WebDriver browser = null;
    public static String reportdate;

    public void systemdate()
    {
        DateFormat date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        reportdate = date1.format(cal);
        System.out.println(reportdate);
    }

    public void verifyAndClickwithXpath(String value,String message)
    {
        WebElement Element;
        Element = browser.findElement(By.xpath(value));

        if(Element.isDisplayed())
        {
            Reporter.addStepLog(message+ " clicked successfully");
            browser.findElement(By.xpath(value)).click();
        }

        else
        {
            Reporter.addStepLog(message+ " not clicked");

        }
    }

    public void verifyAndClickwithXpathJS(String value,String message)
    {
        WebElement Element;
        Element = browser.findElement(By.xpath(value));

        if(Element.isDisplayed())
        {

            JavascriptExecutor executor = (JavascriptExecutor)browser;
            executor.executeScript("arguments[0].click();", Element);
            Reporter.addStepLog(message+ " clicked successfully");
        }

        else
        {
            Reporter.addStepLog(message+ " not clicked");

        }
    }


    public void verifyAndClickwithid(String value,String message)
    {
        WebElement Element;
        Element = browser.findElement(By.id(value));

        if(Element.isDisplayed())
        {
            Reporter.addStepLog(message+ " entered successfully");
            browser.findElement(By.id(value)).click();
        }

        else
        {
            Reporter.addStepLog(message+ " not entered");
        }
    }

    public void verifyInputByID(String property, String value,String message)
    {
        WebElement Element;
        Element = browser.findElement(By.id(property));

        if(Element.isDisplayed())
        {
            Reporter.addStepLog(message+ " entered successfully");
            browser.findElement(By.id(property)).sendKeys(value);
        }

        else
        {
            Reporter.addStepLog(message+ " not entered");
        }

    }

    public void verifyInputByXpath(String property, String value,String message)
    {
        WebElement Element;
        Element = browser.findElement(By.xpath(property));

        if(Element.isDisplayed())
        {
            Reporter.addStepLog(message+ " entered successfully");
            browser.findElement(By.xpath(property)).sendKeys(value);

        }

        else
        {
            Reporter.addStepLog(message+ " not entered");
        }

    }

    public void verifyInputByName(String property, String value,String message)
    {
        WebElement Element;
        Element = browser.findElement(By.name(property));

        if(Element.isDisplayed())
        {
            Reporter.addStepLog(message+ " entered successfully");
            browser.findElement(By.name(property)).sendKeys(value);
        }

        else
        {
            Reporter.addStepLog(message+" not entered");
        }

    }

    public void verifyIsElementVisibleWithId(String property,String message)
    {
        WebElement Element;
        Element = browser.findElement(By.id(property));
        if(Element.isDisplayed())
        {
            Reporter.addStepLog(message+ " is displayed successfully in the application");

        }
        else
        {
            Assert.assertTrue(!Element.isDisplayed());

            Reporter.addStepLog(message+ " is not displayed successfully in the application");

        }

    }

    public void verifyIsElementVisibleWithXpath(String property,String message)
    {
        WebElement Element;
        Element = browser.findElement(By.xpath(property));

        if(Element.isDisplayed())
        {
            Reporter.addStepLog(message+ " is displayed successfully in the application");
        }

        else
        {
            Assert.assertTrue(!Element.isDisplayed());
            Reporter.addStepLog(message+ " is not displayed successfully in the application");
        }
    }

    public String verifyAndGetTextByXpath(String property)
    {

        WebElement Element;
        Element = browser.findElement(By.xpath(property));
        if(Element.isDisplayed())
        {
            Reporter.addStepLog(browser.findElement(By.xpath(property)).getText()+"  is Displayed SuccessFully");
        }

        else
        {

            Reporter.addStepLog("Element is not displayed successfully in the application");
        }
        return property;
    }

    public int VerifyAndGetCountWithXpath(String Proeprty,String message)
    {
        Reporter.addStepLog(browser.findElements(By.xpath(Proeprty)).size() +message);
        return browser.findElements(By.xpath(Proeprty)).size();


    }

    public int VerifyAndGetTableRows(String Proeprty)
    {

        return browser.findElements(By.xpath(Proeprty +"/table/tbody/tr")).size();

    }

    public int VerifyAndGetTableColumns(String Proeprty)
    {

        return browser.findElements(By.xpath(Proeprty +"/table/tbody/tr[1]/td")).size();

    }


    public static void browserWait(int WaitTime)
    {
        try
        {
            Thread.sleep(WaitTime);
        }
        catch(Exception e)
        {

        }
    }

    public void VerifyAndTakeScreenshot(String name) throws IOException
    {
        TakesScreenshot takescreenshot = (TakesScreenshot)BasePage.browser;
        File scr = takescreenshot.getScreenshotAs(OutputType.FILE);
        Desr = CucumberRunner.path1 + "/" +name +".png";
        File destination = new File(Desr);
        FileUtils.copyFile(scr, destination);
        Reporter.addScreenCaptureFromPath(Desr, name);
    }



}