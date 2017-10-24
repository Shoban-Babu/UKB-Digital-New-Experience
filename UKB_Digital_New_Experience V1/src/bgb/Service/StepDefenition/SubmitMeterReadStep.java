package bgb.Service.StepDefenition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

import bgb.Service.Page.LoginPage;
import bgb.Service.Page.SubmitMeterReadPage;

public class SubmitMeterReadStep{

    @Given("^I launch the application$")
    public void I_launch_the_application() throws Throwable

    {
        System.out.println("i am launching the application");
        LoginPage login = new LoginPage();
        login.login_verify();
    }

    @Given("^I am login with the credentials")
    public void I_navigate_to_accountoverview()
    {
        LoginPage login = new LoginPage();
        login.login_to_account_overview();
    }

    @When("^I should navigate to account summary page$")
    public void I_launch_the_application1()
    {
        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.Click_SMR_Link();

    }

    @Then("^I should verify the submit meter read landing page$")
    public void I_launch_the_application2()

    {
        // Write code here that turns the phrase above into concrete actions
        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.verify_SMR_Page();
    }

    @Given("^I should navigate to the SMR page$")
    public void navigate_to_SMR_Anonympus() throws IOException
    {
        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.navigate_to_SMR();

    }

    @When("^I should enter the account number as \"([^\"]*)\" ,postcode as \"([^\"]*)\" and email address as \"([^\"]*)\"$")
    public void enter_smr_details(String accountno,String postcode,String email) throws IOException
    {
        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.verify_smr_page_title();
        smr.enter_smr_deatils(accountno, postcode, email);
        smr.Click_On_next_button();

    }

    @Then("^I click on next button$")
    public void Click_on_next_buton()

    {
        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.Click_On_next_button();
    }

    @Then("^I should verify UI error message$")
    public static void SMR_Error_Message_step1()

    {
        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.error_message_validation_step1();

    }

    @Then("^I should verify UI error message with invalid deatils$")
    public static void error_message_validation_invalid()

    {
        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.error_message_validation_invalid();
    }

    @Then("^I should verify UI of meter deatils$")
    public static void verify_meter_details_step() throws IOException
    {
        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.verify_meter_details_page();

    }


    @Then("I should submit the meter read for Single Registers$")

    public static void Submit_meter_read_SingleRegister() throws IOException
    {

        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.Date_Picker_Fuctionality();
        smr.get_meter_multi_register_count();

    }

    @Then("I should submit the meter for Multiple Registers$")

    public static void Submit_meter_read_MultipleRegister() throws IOException
    {

        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.Date_Picker_Fuctionality();
        smr.get_meter_multi_register_count();

    }

    @Then("I should submit the meter for Multiple Meter$")

    public static void Submit_meter_read_MultiMeter() throws IOException
    {

        SubmitMeterReadPage smr = new SubmitMeterReadPage();
        smr.get_Dialscount_multimeter();

    }

}
