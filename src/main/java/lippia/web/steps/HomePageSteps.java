package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.HomeConstants;
import lippia.web.constants.ProductConstants;
import lippia.web.services.HomePageService;
import lippia.web.services.LoginService;

public class HomePageSteps {

    @When("I click on Shop Menu")
    public void clickOnShopMenu() {
        LoginService.click(HomeConstants.SHOP_MENU);
    }

    @When("I click on Home Menu Button")
    public void clickOnHomeMenuButton() {
        LoginService.click(HomeConstants.HOME_MENU_BUTTON);
    }

    @Then("I can verify that the Home Page has (\\d+) Sliders only")
    public void verifySliders(int amount) {
        HomePageService.verify(HomeConstants.SLIDER, amount);
    }

    @Then("I can verify that the Home Page has (\\d+) Arrivals only")
    public void verifyArrivals(int amount) {
        HomePageService.verify(HomeConstants.NEW_ARRIVAL, amount);
    }

    @Given("I Test that the Home Page has (\\d+) Arrivals only")
    public void testHomePageHasArrivals(int amount) {
        LoginService.navigateWeb();
        LoginService.click(HomeConstants.SHOP_MENU);
        LoginService.click(HomeConstants.HOME_MENU_BUTTON);
        HomePageService.verify(HomeConstants.NEW_ARRIVAL, amount);
    }

    @When("I click on the image in the Arrivals in stock")
    public void clickOnImageInArrivals() {
        LoginService.click(HomeConstants.NEW_ARRIVAL_IN_STOCK);
    }

    @Then("I am redirected to the Add to Basket Page")
    @And("I am redirected to the Basket Page")
    public void verifyRedirectionToAddToBasket() {
        HomePageService.verifyRedirection("product");
       // LoginService.verifyPresence(ProductConstants.ADD_TO_BASKET_BUTTON);
    }

    @And("I click on the Add to Basket button")
    public void clickOnAddToBasketButton() {
        LoginService.click(ProductConstants.ADD_TO_BASKET_BUTTON);
    }

    @And("I can view my chosen item in the Products menu with its price")
    public void verifyItemInMenuWithPrice() {
        LoginService.verifyPresence(ProductConstants.PRODUCT_PRICE);
    }

    @When("I go to View Basket")
    public void clickOnItem() {
        LoginService.click(ProductConstants.VIEW_BASKET_BUTTON);
    }

    @Then("I am led to final review of Basket page")
    public void verifyRedirectionToBasketPage() {
        HomePageService.verifyRedirection("/basket/");
    }

}
