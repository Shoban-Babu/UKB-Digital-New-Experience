package CucumberProperties;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import Listener.Reporter;
import bgb.CommonProperties.BrowserProperties;
import bgb.CommonProperties.PropertyLoader;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/Feature_File/SubmitMeterRead.feature",
        glue={"bgb.Service.StepDefenition"},
        plugin={"pretty","html:D:/UKB_Digital_New_Experience V1/Cucumber Results/cucumber-html-report.html",
                "Listener.ExtentCucumberFormatter:D:/UKB_Digital_New_Experience V1/test-output/Cucumber-ExtendReport/CucumberExtendReport.html"},
        tags = {"@singleRegister"}
)

public class CucumberRunner {

    public static String date;
    public static String path;
    public static String path1;
    private final static String CONFIG_FILE_NAME = "BGB/CommonProperties/Dev.properties";;
    private static Properties pageProperties = new PropertyLoader(CONFIG_FILE_NAME).load();

    @BeforeClass
    public static void startbowser()
    {
        BrowserProperties bp = new BrowserProperties();
        bp.getWebdriver();
        Folder_Creation();

    }

    public static void Copy_the_Report() throws InterruptedException, IOException
    {
        // TimeUnit.SECONDS.sleep(50);
        System.out.println("I am in copy the file");
        File Source = new File("D:/UKB_Digital_New_Experience V1/test-output/Cucumber-ExtendReport/CucumberExtendReport.html");
        File Dest = new File(path+"/ExtendReport.html");
        FileUtils.copyFile(Source, Dest);
    }


    @AfterClass
    public static void reportsetup() throws InterruptedException, IOException
    {

        reportsetupexist();
        Copy_the_Report();

    }

    public static void reportsetupexist()
    {

        Reporter.loadXMLConfig(new File("src/CucumberProperties/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("Directory",System.getProperty("user.dir"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("OS", "Windows OS");
        Reporter.setSystemInfo("Browser", pageProperties.getProperty("Common.browser"));
        Reporter.setSystemInfo("JAVA", "1.8.0_131");
        Reporter.setSystemInfo("Frame Work", "Cucmber With Junit");
        Reporter.setTestRunnerOutput("Sample test runner output message");
        System.out.println("I completed picking User Details");

    }

    public static void Folder_Creation()
    {

        DateFormat Dat = new SimpleDateFormat("YYYYMMdd_HHmmss");
        Calendar cal = Calendar.getInstance();
        date = Dat.format(cal.getTime());
        System.out.println("System Date is:" + date);

        path = System.getProperty("user.dir") + "/test-output/"+date+"";
        File folder = new File(path);
        folder.mkdirs();
        path1 = path + "/Screenshots";
        File folder1 = new File(path1);
        folder1.mkdirs();

    }


}
