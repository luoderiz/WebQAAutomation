package lippia.web.steps;

import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import lippia.web.constants.LoginConstants;
import lippia.web.services.HomePageService;
import lippia.web.services.LoginService;

public class LoginSteps {

    @Given("I am in automationtesting site")
    public void goToHome() {
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
    public void verifySuccessfulLogin() {
        HomePageService.verifyRedirection("/my-account/");
        LoginService.verifyPresence(LoginConstants.WELCOME_MESSAGE);
    }

    @When("I enter a case changed username in Login User TextBox")
    public void enterCaseChangedUsername() {
        String upperCaseUsername = PropertyManager.getProperty("valid.username").toUpperCase();
        LoginService.enter(LoginConstants.USERNAME_TEXTBOX, upperCaseUsername);
    }

    @And("I enter a case changed password in Login Password Textbox")
    public void enterCaseChangedPassword() {
        String upperCasePassword = PropertyManager.getProperty("valid.password").toUpperCase();
        LoginService.enter(LoginConstants.PASSWORD_TEXTBOX, upperCasePassword);
    }

    @Then("An error message will announce Login failure")
    public void verifyFailLogin() {
        LoginService.verifyPresence(LoginConstants.ERROR_MESSAGE);
    }

    @And("I am logged in")
    public void login() {
        String username = PropertyManager.getProperty("valid.username");
        LoginService.enter(LoginConstants.USERNAME_TEXTBOX, username);
        String password = PropertyManager.getProperty("valid.password");
        LoginService.enter(LoginConstants.PASSWORD_TEXTBOX, password);
        LoginService.click(LoginConstants.LOGIN_BUTTON);
        LoginService.verifyPresence(LoginConstants.WELCOME_MESSAGE);
    }

    @When("I log out of the site")
    public void logout() {
        LoginService.click(LoginConstants.LOGOUT_BUTTON);
    }

    @And("I press the back button of my browser")
    public void goBack() {
        LoginService.navigateBack();
    }

    @Then("The login page must be visible")
    public void verifySite() {
        LoginService.verifyPresence(LoginConstants.LOGIN_BUTTON);
    }

    @And("I shouldn’t be signed in to my account")
    public void VerifySuccessfulLogout() {
        LoginService.click(LoginConstants.MY_ACCOUNT_MENU);
        LoginService.verifyPresence(LoginConstants.LOGIN_BUTTON);
    }

}
