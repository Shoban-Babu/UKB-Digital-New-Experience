package bgb.CommonProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import bgb.CommonProperties.PropertyLoader;
import bgb.CommonProperties.BasePage;

public class BrowserProperties extends BasePage{

    private final static String CONFIG_FILE_NAME = "BGB/CommonProperties/Dev.properties";;
    private static Properties pageProperties = new PropertyLoader(CONFIG_FILE_NAME).load();

    /*	@BeforeClass*/
    public void getWebdriver()
    {
        if(browser==null)
            System.out.println(pageProperties.getProperty("Common.browser"));
        {
            if(pageProperties.getProperty("Common.browser").equalsIgnoreCase("firefox"))
            {
                System.out.println("I am in For Webdriver Firefox");
                System.setProperty("webdriver.gecko.driver", "D://FireFox - Selenium Add -Ons//Drivers//geckodriver.exe");

                DesiredCapabilities dc = DesiredCapabilities.firefox();
                dc.setCapability("marionette", true);
                browser =new FirefoxDriver(dc);
                browser_operations();
            }

            else if(pageProperties.getProperty("Common.browser").equalsIgnoreCase("Chrome"))
            {
                System.setProperty("webdriver.chrome.driver", "D://FireFox - Selenium Add -Ons//Drivers//chromedriver.exe");
                browser =new ChromeDriver();
                browser_operations();
            }

            else if(pageProperties.getProperty("Common.browser").equalsIgnoreCase("IE"))
            {
                System.setProperty("webdriver.ie.driver", "D://FireFox - Selenium Add -Ons//Drivers//IEDriverServer.exe");
                /*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);*/

		        /*DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);*/

                browser =new InternetExplorerDriver();
                browser_operations();

                browser.findElement(By.id("overridelink")).click();
            }
        }
    }

    public static void browser_operations()
    {
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get(pageProperties.getProperty("Common.BGBURL"));
        browserWait(1500);
		try
		{
        if(browser.findElement(By.xpath(".//*[@class='fa fa-close']")).isDisplayed())
        {
            browser.findElement(By.xpath(".//*[@class='fa fa-close']")).click();
        }
		}
		catch(Exception e)
		{

		}
    }
}
