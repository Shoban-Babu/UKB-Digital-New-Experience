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
  "name": "To validate that if the customer is getting meter read details when giving valid details for Single Registers",
  "description": "",
  "id": "submit-meter-read-for-anonymous-read;to-validate-that-if-the-customer-is-getting-meter-read-details-when-giving-valid-details-for-single-registers",
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
  "duration": 14335647934,
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
  "duration": 6157373356,
  "status": "passed"
});
formatter.match({
  "location": "SubmitMeterReadStep.verify_meter_details_step()"
});
formatter.result({
  "duration": 3914135003,
  "status": "passed"
});
formatter.match({
  "location": "SubmitMeterReadStep.Submit_meter_read_SingleRegister()"
});
formatter.result({
  "duration": 28988337051,
  "status": "passed"
});
});