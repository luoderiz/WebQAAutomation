package lippia.web.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.HomeConstants;
import lippia.web.services.HomePageService;
import lippia.web.services.LoginService;

public class HomePageSteps {

    @When("I click on Shop Menu")
    public void clickOnShopMenu() {
        LoginService.click(HomeConstants.HOME_MENU_BUTTON);
    }

    @When("I click on Home Menu Button")
    public void clickOnHomeMenuButton() {
        LoginService.click(HomeConstants.SHOP_MENU);
    }

    @Then("I can verify that the Home Page has {int} Sliders only")
    public void verifySliders(int amount) {
        HomePageService.verify(HomeConstants.SLIDER, amount);
    }

    @Then("I can verify that the Home Page has {int} Arrivals only")
    public void verifyArrivals(int amount) {
        HomePageService.verify(HomeConstants.NEW_ARRIVAL, amount);
    }

}
