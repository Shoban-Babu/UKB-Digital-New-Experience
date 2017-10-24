$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/Feature_File/SubmitMeterRead.feature");
formatter.feature({
  "line": 1,
  "name": "Submit Meter Read for Anonymous Read",
  "description": "",
  "id": "submit-meter-read-for-anonymous-read",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 44,
  "name": "To validate that if the customer is getting meter read deatils when giving valid deatils for Single Registers",
  "description": "",
  "id": "submit-meter-read-for-anonymous-read;to-validate-that-if-the-customer-is-getting-meter-read-deatils-when-giving-valid-deatils-for-single-registers",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 42,
      "name": "@singleRegister"
    },
    {
      "line": 42,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 46,
  "name": "I should navigate to the SMR page",
  "keyword": "Given "
});
formatter.step({
  "line": 47,
  "name": "I should enter the account number as \"602028090\" ,postcode as \"PL5 1QY\" and email address as \"shobanbabasdeu.manohar@cognizant.com\"",
  "keyword": "When "
});
formatter.step({
  "line": 48,
  "name": "I should verify UI of meter deatils",
  "keyword": "Then "
});
formatter.step({
  "line": 49,
  "name": "I should submit the meter read for Single Registers",
  "keyword": "Then "
});
formatter.match({
  "location": "SubmitMeterReadStep.navigate_to_SMR_Anonympus()"
});
formatter.result({
  "duration": 11758093744,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "602028090",
      "offset": 38
    },
    {
      "val": "PL5 1QY",
      "offset": 63
    },
    {
      "val": "shobanbabasdeu.manohar@cognizant.com",
      "offset": 94
    }
  ],
  "location": "SubmitMeterReadStep.enter_smr_details(String,String,String)"
});
formatter.result({
  "duration": 13200635027,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\".//*[@class\u003d\u0027meter-read container\u0027]/div/h2\"}\n  (Session info: chrome\u003d61.0.3163.91)\n  (Driver info: chromedriver\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233),platform\u003dWindows NT 6.1.7601 SP1 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 10.05 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.4.0\u0027, revision: \u0027unknown\u0027, time: \u0027unknown\u0027\nSystem info: host: \u0027PC354424\u0027, ip: \u0027192.168.56.1\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233), userDataDir\u003dC:\\Users\\473415\\AppData\\Local\\Temp\\scoped_dir8288_17235}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d61.0.3163.91, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, unexpectedAlertBehaviour\u003d}]\nSession ID: 5451f13e5788b629b9a94b64fe18f1cd\n*** Element info: {Using\u003dxpath, value\u003d.//*[@class\u003d\u0027meter-read container\u0027]/div/h2}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:671)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:410)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:509)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:402)\r\n\tat bgb.Service.Page.SubmitMeterReadPage.verify_smr_page_title(SubmitMeterReadPage.java:56)\r\n\tat bgb.Service.StepDefenition.SubmitMeterReadStep.enter_smr_details(SubmitMeterReadStep.java:60)\r\n\tat ✽.When I should enter the account number as \"602028090\" ,postcode as \"PL5 1QY\" and email address as \"shobanbabasdeu.manohar@cognizant.com\"(src/Feature_File/SubmitMeterRead.feature:47)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "SubmitMeterReadStep.verify_meter_details_step()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "SubmitMeterReadStep.Submit_meter_read_SingleRegister()"
});
formatter.result({
  "status": "skipped"
});
});