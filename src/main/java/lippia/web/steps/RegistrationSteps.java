package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.RegistrationConstants;
import lippia.web.services.LoginService;

public class RegistrationSteps {

    @And("I enter (.*) in Register EmailAddress TextBox")
    public void enterEmail(String email) {
        LoginService.enter(RegistrationConstants.EMAIL_TEXTBOX, email);
    }
    @And("I enter (.*) in Register Password Textbox")
    public void enterPassword(String password) {
        LoginService.enter(RegistrationConstants.PASSWORD_TEXTBOX, password);
    }

    @When("I click on Register Button")
    public void clickOnRegisterButton() {
        LoginService.click(RegistrationConstants.REGISTER_BUTTON);
    }

    @Then("An error message will announce Registration failure")
    public void registrationFail() {
        LoginService.verifyPresence(RegistrationConstants.ERROR_MESSAGE);
    }

}
