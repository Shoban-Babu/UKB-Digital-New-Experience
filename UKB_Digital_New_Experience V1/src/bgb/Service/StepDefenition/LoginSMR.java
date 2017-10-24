package bgb.Service.StepDefenition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import bgb.Service.Page.LoginPage;

public class LoginSMR{

    @When("^user enter the username and password$")
    public void Enter_username_password()
    {
        LoginPage login = new LoginPage();
        login.enter_username();

    }

    @Then("^user verify the error scenario$")
    public void verify_ClientSide_Validation()
    {

        LoginPage login = new LoginPage();
        login.Error_validation();

    }




}



