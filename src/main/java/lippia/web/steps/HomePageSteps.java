package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.HomeConstants;
import lippia.web.constants.OrderConfirmationConstants;
import lippia.web.constants.PaymentGatewayConstants;
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
    public void verifyRedirectionToAddToBasket() {
        HomePageService.verifyRedirection("product");
        LoginService.verifyPresence(ProductConstants.ADD_TO_BASKET_BUTTON);
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

    @Then("I can see the final values where I can verify that subtotal < total, as taxes are added to the subtotal")
    public void verifyTotalValueIsMinorThanSubtotal() {
        HomePageService.compareValues(HomePageService.getValue(ProductConstants.BASKET_SUBTOTAL_VALUE), HomePageService.getValue(ProductConstants.BASKET_TOTAL_VALUE));
    }

    @Given("I add an Arrival to Basket and Proceed to Checkout")
    public void addToBasketArrival() {
        HomePageService.addToBasket();
    }

    @When("I click on Proceed to Checkout button")
    public void clickOnProceedToCheckout() {
        LoginService.click(ProductConstants.PROCEED_TO_CHECKOUT_BUTTON);
    }

    @And("I am led to payment gateway page")
    public void verifyRedirectionToPaymentGatewayPage() {
        HomePageService.verifyRedirection("/checkout/");
    }

    @And("I have the feasibility to add coupon")
    public void verifyFeasibilityToAddCoupon() {
        LoginService.verifyPresence(PaymentGatewayConstants.COUPON_ALERT);
        LoginService.click(PaymentGatewayConstants.COUPON_ALERT);
        LoginService.enter(PaymentGatewayConstants.COUPON_CODE_INPUT_BOX, "code1234");
        LoginService.click(PaymentGatewayConstants.APPLY_COUPON_BUTTON);
    }

    @And("I can view Billing Details, Order Details, Additional details and Payment gateway details")
    public void verifyDetailsVisibility() {
        LoginService.verifyPresence(PaymentGatewayConstants.FINAL_BILLING_DETAILS);
        LoginService.verifyPresence(PaymentGatewayConstants.FINAL_ORDER_REVIEW_DETAILS);
        LoginService.verifyPresence(PaymentGatewayConstants.FINAL_ADDITIONAL_DETAILS);
    }

    @And("I can fill my details in billing details form")
    public void fillBillingDetailsForm() throws Exception {
        HomePageService.completeBillingForm();
    }

    @And("I can opt any payment in the payment gateway, like Direct bank transfer, cheque, cash or paypal")
    public void optPaymentMethod() {
        HomePageService.click(PaymentGatewayConstants.PAYMENT_METHOD_CASH_ON_DELIVERY);
    }

    @When("I click on Place Order button to complete process")
    public void clickOnPlaceOrder() {
        LoginService.click(PaymentGatewayConstants.PLACE_ORDER_BUTTON);
    }

    @Then("I am led to Order confirmation page with order details, bank details, customer details and billing details")
    public void verifyRedirectionToOrderConfirmationPage() {
        HomePageService.verifyRedirection("/checkout/order-received");
        HomePageService.read(OrderConfirmationConstants.ORDER_NUMBER);
        HomePageService.read(OrderConfirmationConstants.ORDER_DATE);
        HomePageService.read(OrderConfirmationConstants.ORDER_TOTAL);
        HomePageService.read(OrderConfirmationConstants.ORDER_PAYMENT_METHOD);
        HomePageService.read(OrderConfirmationConstants.PRODUCT_NAME);
        HomePageService.read(OrderConfirmationConstants.PRODUCT_QUANTITY);
        HomePageService.read(OrderConfirmationConstants.PRODUCT_TOTAL);
        HomePageService.read(OrderConfirmationConstants.ORDER_DETAILS_SUBTOTAL);
        HomePageService.read(OrderConfirmationConstants.ORDER_DETAILS_TAX);
        HomePageService.read(OrderConfirmationConstants.ORDER_DETAILS_TOTAL);
    }

}
