package bgb.Service.Page;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Listener.Reporter;
import bgb.CommonProperties.BasePage;
import bgb.CommonProperties.PropertyLoader;


public class SubmitMeterReadPage extends BasePage
{
    private final static String File_Get = "BGB/CommonProperties/Dev.properties";
    private static Properties pageProperties = new PropertyLoader(File_Get).load();

    private final static String File_load = "BGB/Service/Properties/SubmitMeterReadPageProperties";
    private static Properties SMRproperties = new PropertyLoader(File_load).load();

    public static int text;
    int register;
    int m=1;
    int tagcount;
    int temp,cal=5,number = 4,rows,column;
    int loop;
    int count;
    String Temp;


    public void Click_SMR_Link()
    {
        browserWait(5000);
        verifyAndClickwithXpath(SMRproperties.getProperty("SMR.Link"),"Submit Meter Read Link");

    }

    public void verify_SMR_Page()
    {
        browserWait(5000);
        System.out.println("i in SMR page");
    }

    public void navigate_to_SMR() throws IOException
    {
        browser.get(pageProperties.getProperty("Common.BGBURL")+"/business/account/submit-reading/account-detail");
        VerifyAndTakeScreenshot("SMR Home Page");
    }

    public void verify_smr_page_title()
    {
        browserWait(3000);
        String text = browser.findElement(By.xpath(SMRproperties.getProperty("SMR.SMRheading"))).getText();
        System.out.println(text);
        Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.SMRheading"))).getText().contains("Submit an meter reading"));
        Reporter.addStepLog("Submit Meter read Page Title is matched with String");
        Assert.assertTrue(browser.getTitle().contains("British Gas Business"));

    }

    public void enter_smr_deatils(String accountno,String postcode,String email) throws IOException
    {
        verifyInputByName(SMRproperties.getProperty("SMR.EmailId"),email,"Email ID");
        verifyInputByName(SMRproperties.getProperty("SMR.AccountNumber"),accountno,"Account Number");
        verifyInputByName(SMRproperties.getProperty("SMR.PostCode"),postcode,"Post Code");
        Reporter.addStepLog("SMR Details Entered Successfully");
        VerifyAndTakeScreenshot("Submit Meter Details Entered");
    }

    public void Click_On_next_button()
    {
        browserWait(1000);
        verifyAndClickwithXpath(SMRproperties.getProperty("SMR.Nextbutton"),"Next Button");
    }

    public void error_message_validation_step1()
    {
        browserWait(1000);
        WebElement email = browser.findElement(By.name(SMRproperties.getProperty("SMR.EmailId")));
        WebElement accountno = browser.findElement(By.name(SMRproperties.getProperty("SMR.AccountNumber1")));
        WebElement postcode = browser.findElement(By.name(SMRproperties.getProperty("SMR.PostCode")));

        email.sendKeys(Keys.TAB);
        browserWait(1000);
        Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.Emailerrormessage"))).getText().contains("Please tell us your email address."));
        accountno.sendKeys(Keys.TAB);
        browserWait(1000);
        Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.accountnoerrormessage"))).getText().contains("Please enter your account number starting with 6"));
        postcode.sendKeys(Keys.TAB);
        browserWait(1000);
        Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.postcodeerrormessage"))).getText().contains("Please enter your site postcode"));
    }

    public void error_message_validation_invalid()
    {
        WebElement postcode = browser.findElement(By.name(SMRproperties.getProperty("SMR.PostCode")));
        Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.Emailerrormessage"))).getText().contains("Please check your email address, it doesn't seem right."));
        Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.accountnoerrormessage"))).getText().contains("Please enter your account number starting with 6"));
        postcode.sendKeys(Keys.TAB);
        Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.postcodeerrormessage"))).getText().contains("Please enter a valid postcode"));
    }

    public void verify_meter_details_page() throws IOException
    {
        browserWait(3000);
        verifyIsElementVisibleWithXpath(SMRproperties.getProperty("SMR.step2"),"Step Two Details");
        verifyAndGetTextByXpath(SMRproperties.getProperty("SMR.Accountnumber1"));
        verifyAndGetTextByXpath(SMRproperties.getProperty("SMR.MeterSerialNumber"));
        verifyAndGetTextByXpath(SMRproperties.getProperty("SMR.EstimationDate"));
        verifyIsElementVisibleWithXpath(SMRproperties.getProperty("SMR.DatePicker"),"DatePicker");
        VerifyAndTakeScreenshot("SMR Home Meter Details page Step 2");

    }

    //Date picker functionality to select the date
    public void Date_Picker_Fuctionality()
    {

        try{

            browserWait(2000);
            verifyAndClickwithXpath(SMRproperties.getProperty("SMR.DatePicker"),"Date Picker");

            Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.PrevoiusMonth"))).isDisplayed());
            for(int y=0;y<=3;y++)
            {
                browser.findElement(By.xpath(SMRproperties.getProperty("SMR.PrevoiusMonth"))).click();
            }
            browserWait(2000);
        }
        catch(Exception e)
        {

        }

        calender_Funtions();
    }



    // Date picker using rows and columns
    public void calender_Funtions()
    {
        rows = VerifyAndGetTableRows(SMRproperties.getProperty("SMR.DateTableCount"));
        System.out.println("rows ="+rows);
        column = VerifyAndGetTableColumns(SMRproperties.getProperty("SMR.DateTableCount"));
        System.out.println("columns ="+column);

        try
        {
            for(int row=1;row<=rows;row++)
            {
                for(int col=1;col<=column;col++)
                {
                    browser.findElement(By.xpath("//*[@class='pika-lendar']/table/tbody/tr["+row+"]/td["+col+"]")).click();
                    browserWait(500);
                }

            }
        }

        catch(Exception e)
        {

        }


    }


    public int get_meter_dials_Count()
    {
        text = VerifyAndGetCountWithXpath(SMRproperties.getProperty("SMR.Dialscount")," Dials are displayed in the application");
        System.out.println(text+"@#@#@");
        return text;
    }

    public String getpreviousMeterReading()
    {
        String concatmeterread = "";

        for(int i=0;i<text;i++)
        {
            String meter = browser.findElement(By.xpath("//*[@id='meter-read']/div[2]/div/div[3]/div/div/div/div/div[4]//*[@class='meter-register']/div/div//*[@name='dial"+i+"']")).getAttribute("value");
            concatmeterread = concatmeterread.concat(meter);
            System.out.println("Meter read value:"+meter);
            System.out.println("Previous meter read with concatination:"+concatmeterread);
        }
        return concatmeterread;
    }

    public void enter_meter_read_into_inputDial()
    {
        int Dialscount = VerifyAndGetCountWithXpath(SMRproperties.getProperty("SMR.DialsInputCount"),"  Input dials are displayed in the application");
        String previousmeterread =getpreviousMeterReading();
        System.out.println("Previous Meter read before adding value" +previousmeterread);
        previousmeterread = (Integer.parseInt(previousmeterread)+1)+"";
        System.out.println("Updated meter read"+previousmeterread);

        int update = previousmeterread.length();
        System.out.println(update);
        if(Dialscount == update)
        {
            System.out.println("i am in for loop");

            for(int i=0; i<Dialscount;i++)
            {
                browser.findElement(By.xpath(SMRproperties.getProperty("SMR.DialsInputCount1").replaceAll("num", ""+i))).sendKeys(previousmeterread.substring(i));
            }
        }
    }

	/*Meter Read Functionality for multiple registers*/
    // To get the register count

    public int new_register_count()
    {
        try
        {
            //for(loop=4;;loop++)
            for(loop=6;;loop++)
            {
                if(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.RegisterCount").replaceAll("reg", ""+loop))).isDisplayed())
                {
                    temp = loop;
                    System.out.println(temp+"$@%@$@@T@%@%");
                }
                else
                {
                    break;
                }

            }
        }
        catch(Exception e){
        }
        System.out.println("^#^#^#^#^#"+temp);
        return temp;
    }

    //get meter reading from existing meter

    public String get_meter_multi_register_count() throws IOException
    {
        new_register_count();

        tagcount = temp + 2;

        int multiregister = VerifyAndGetCountWithXpath(SMRproperties.getProperty("SMR.DialsCountforMultiReg")," Dials are displayed in the application");
        System.out.println(multiregister+"Multi Dials Displayed");

        String concatmeterread = "";
        try
        {
            //for(int m=4;;m++)
                for(int m=6;;m++)
            {
                System.out.println("i am in for first loop");
                for(int i=0;i<multiregister;i++)
                {
                    System.out.println("i am in for second loop");
                    String meter = browser.findElement(By.xpath(".//*[@class=\"meter-read container\"]/div/div/div/div/div["+m+"]//*[@class='meter-register']/div/div//input[@data-test-dial='"+i+"']")).getAttribute("value");
                    //String meter = browser.findElement(By.xpath("//*[@class='meter-read']/div[2]/div/div[3]/div/div/div/div/div["+m+"]//*[@class='meter-register']/div/div//input[@data-test-dial='"+i+"']")).getAttribute("value");
                    //String meter = browser.findElement(By.xpath(".//*[@class='meter-read container']/div[2]/div/div/div/div["+m+"]//*[@class='meter-register']/div/div//input[@data-test-dial='"+i+"']")).getAttribute("value");
                    concatmeterread = concatmeterread.concat(meter);
                    System.out.println("Meter read value:"+meter);

                }
                System.out.println("Previous meter read with concatination:"+concatmeterread);
                String temoptxt = concatmeterread;
                System.out.println("Current Meter read"+temoptxt);

                enter_into_Dials(temoptxt);
                concatmeterread= "";
            }
        }

        catch (Exception e)
        {

        }
        VerifyAndTakeScreenshot("SMR Meter Deatils Submitted");
        return concatmeterread;
    }

    //Enter input dials
    public void enter_into_Dials(String temoptxt)
    {
        String combinepath;
        System.out.println(tagcount);

        System.out.println(temp+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(m);
        System.out.println(temoptxt);

        String ipath1 = SMRproperties.getProperty("SMR.InputDialsforMultiMeter1").replaceAll("reg",""+tagcount);
        String ipath2 = SMRproperties.getProperty("SMR.InputDialsforMultiMeter2").replaceAll("count",""+m);
        String combineinput = ipath1 + ipath2;

        //System.out.println(combineinput+"@%@%@%@%@%");

        int DialCount = VerifyAndGetCountWithXpath(combineinput,"  Input dials are displayed in the application");
        System.out.println(DialCount+"Input DialsCount");
        String previousmeterread = temoptxt;
        System.out.println("Previous Meter read before adding value " +previousmeterread);
        previousmeterread =  (Integer.parseInt(previousmeterread)+1)+"";
        previousmeterread = pad_Zeros(previousmeterread, DialCount);
        System.out.println("Updated meter read "+previousmeterread);
        Reporter.addStepLog("Previous Meter Read for Register "+m+ " is:" +temoptxt);
        Reporter.addStepLog("Updated Meter Read for Register " +m+ " is"+ previousmeterread);
        int update = previousmeterread.length();
        Assert.assertEquals(DialCount, update);
        //Assert.assertNotEquals(DialCount, update);
        Reporter.addStepLog("Dials count and Input Dials are matched");


            for (int i = 0; i < DialCount; i++) {
                //System.out.println("i am in for loop");
                String Path1 = SMRproperties.getProperty("SMR.InputValuesPart1").replaceAll("count", "" + tagcount);
                String Path2 = SMRproperties.getProperty("SMR.InputValuesPart2").replaceAll("num", "" + i);
                //combinepath = Path1 + "[" + m + "]" + Path2;
                combinepath = Path1 + Path2;
                browser.findElement(By.xpath(combinepath)).sendKeys(previousmeterread.substring(i));
            }
            temoptxt = "";
            m++;
            tagcount++;

    }

	/*Multiple meter Code*/

    public String get_Dialscount_multimeter() throws IOException
    {
        for(loop=4;loop<=12;)
        {
            System.out.println(loop+"Current loop is");
            count = VerifyAndGetCountWithXpath(SMRproperties.getProperty("SMR.MultiMeterReadCount").replaceAll("Dcount", ""+loop), "Dials Count");
            System.out.println("Dials Count Displayed is :"+count);
            Date_Picker_Fuctionality_MultiMeter();
            get_multi_Meter_Previous_read();
            enter_multi_meter_read();
            loop = loop + 2;
            System.out.println(loop+"Updated loop is");
        }

        VerifyAndTakeScreenshot("SMR Meter Deatils Submitted");
        return null;
    }

    public String get_multi_Meter_Previous_read()
    {
        String concatmeterread = "";

        for(int i=0;i<count;i++)
        {
            String Part1 = SMRproperties.getProperty("SMR.MultiMeterRegisterpreviousMeter1").replaceAll("tag", ""+loop);
            String Part2 = SMRproperties.getProperty("SMR.MultiMeterRegisterpreviousMeter2").replaceAll("num", ""+i);
            String concat = Part1 + Part2;
            String meter = browser.findElement(By.xpath(concat)).getAttribute("value");
            concatmeterread = concatmeterread.concat(meter);
            System.out.println("Meter read value:"+meter);
            System.out.println("Previous meter read with concatination:"+concatmeterread);
            Temp = concatmeterread;
        }

        return concatmeterread;
    }

    public void enter_multi_meter_read()
    {
        loop = loop+2;

        int DialsCount = VerifyAndGetCountWithXpath(SMRproperties.getProperty("SMR.multiMeterInputReadCount").replaceAll("Dcount", ""+loop), "Dials Count");
        System.out.println("Input Dials Count:"+DialsCount);

        String previousmeterread = Temp;
        previousmeterread = (Integer.parseInt(previousmeterread)+1)+"";
        previousmeterread = pad_Zeros(previousmeterread, DialsCount);
        System.out.println("Updated meter read:"+previousmeterread);

        int update = previousmeterread.length();
        Reporter.addStepLog("Previous Meter Read for Register "+m+ " is:" +Temp);
        Reporter.addStepLog("Updated Meter Read for Register " +m+ " is"+ previousmeterread);
        Assert.assertEquals(DialsCount, update);

        for(int i=0;i<DialsCount;i++)
        {

            String Part1 = SMRproperties.getProperty("SMR.multiMterInputValues1").replaceAll("tag", ""+loop);
            String Part2 = SMRproperties.getProperty("SMR.multiMterInputValues2").replaceAll("num", ""+i);
            String concat = Part1 + Part2;
            //System.out.println(concat);
            browser.findElement(By.xpath(concat)).sendKeys(previousmeterread.substring(i));
        }

    }

    public void Date_Picker_Fuctionality_MultiMeter()
    {

        browserWait(2000);
        verifyAndClickwithXpathJS(SMRproperties.getProperty("SMR.DatePickermultiMeter").replaceAll("num", ""+cal),"Date Picker");
        browserWait(1000);
        Assert.assertTrue(browser.findElement(By.xpath(SMRproperties.getProperty("SMR.PreviousDatePickermulti").replaceAll("calnum", ""+number))).isDisplayed());
        for(int y=0;y<=3;y++)
        {
            browser.findElement(By.xpath(SMRproperties.getProperty("SMR.PreviousDatePickermulti").replaceAll("calnum", ""+number))).click();
        }
        browserWait(2000);
        calender_Funtions_multi();
        cal = cal + 4;
        number++;

    }

    public void calender_Funtions_multi()
    {
        rows = VerifyAndGetTableRows(SMRproperties.getProperty("SMR.DatePickerMultiCount").replaceAll("calnum", ""+number));
        System.out.println("rows ="+rows);
        column = VerifyAndGetTableColumns(SMRproperties.getProperty("SMR.DatePickerMultiCount").replaceAll("calnum", ""+number));
        System.out.println("columns ="+column);

        try
        {
            for(int row=1;row<=rows;row++)
            {
                for(int col=1;col<=column;col++)
                {
                    browser.findElement(By.xpath("//body[@class='ember-application']/div[" +number+ "]/div/table/tbody/tr["+row+"]/td["+col+"]")).click();
                    browserWait(500);
                }

            }
            rows = 0;
            column = 0;
        }
        catch(Exception e)
        {
        }

    }


    //Padding Zeros

    public String pad_Zeros(String previousmeterread, int Dialscount)
    {

        for(int i = previousmeterread.length();i<Dialscount;i++)
        {
            System.out.println("I am In for padding the Zeros");
            previousmeterread = "0" + previousmeterread;
            System.out.println("+++++++++++++++++++++++++++++++++"+previousmeterread);
        }

        return previousmeterread;

    }








}

