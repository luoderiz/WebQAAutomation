package lippia.web.steps;

import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import lippia.web.services.LoginService;
import lippia.web.constants.LoginConstants;

public class LoginSteps {

    @Given("I am in automationtesting site")
    public void home() {
        LoginService.navigateWeb();
    }

    @And("I click on My Account Menu")
    public void clickOnMyAccountMenu() {
        LoginService.click(LoginConstants.MY_ACCOUNT_MENU);
    }

    @When("I enter my valid existing username in the Login Textbox")
    public void enterValidUsername() {
        String username = PropertyManager.getProperty("valid.username");
        LoginService.enter(LoginConstants.USERNAME_TEXTBOX, username);
    }

    @And("I enter my valid password in the Login Textbox")
    public void enterValidPassword() {
        String password = PropertyManager.getProperty("valid.password");
        LoginService.enter(LoginConstants.PASSWORD_TEXTBOX, password);
    }

    @And("I click on Login Button")
    public void clickOnLoginButton() {
        LoginService.click(LoginConstants.LOGIN_BUTTON);
    }

    @Then("I am redirected to My Account Home Page")
    public void loginSuccessful() {
        LoginService.verifyLogin();
    }

    @When("I enter (.*) in Login User TextBox")
    public void enterUser(String username) {
        LoginService.enter(LoginConstants.USERNAME_TEXTBOX, username);
    }

    @And("I enter (.*) in Login Password Textbox")
    public void enterPassword(String password) {
        LoginService.enter(LoginConstants.PASSWORD_TEXTBOX, password);
    }

    @Then("An error message will announce Login failure")
    public void loginFail() {
        LoginService.verifyPresence(LoginConstants.ERROR_MESSAGE);
    }

}
