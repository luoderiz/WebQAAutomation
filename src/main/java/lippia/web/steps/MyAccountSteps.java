package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.MyAccountConstants;
import lippia.web.services.HomePageService;
import lippia.web.services.LoginService;

public class MyAccountSteps {


    @When("I click on Account Details Button")
    public void clickOnAccountDetails() {
        LoginService.click(MyAccountConstants.ACCOUNT_DETAILS_BUTTON);
    }

    @Then("I can view my Details")
    public void verifyRedirectionToAccountDetailsPage() {
        HomePageService.verifyRedirection("/my-account/edit-account/");
    }

    @And("I can change my password")
    public void verifyOptionToChangePassword() {
        LoginService.verifyPresence(MyAccountConstants.CURRENT_PASSWORD_INPUT_BOX);
        LoginService.verifyPresence(MyAccountConstants.NEW_PASSWORD_INPUT_BOX);
        LoginService.verifyPresence(MyAccountConstants.CONFIRM_NEW_PASSWORD_INPUT_BOX);
    }

    @And("I click on My Account link")
    public void clickOnMyAccount() {
        LoginService.click(MyAccountConstants.DASHBOARD_BUTTON);
    }
}
