package lippia.web.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.OrderConfirmationConstants;
import lippia.web.constants.PaymentGatewayConstants;
import lippia.web.constants.ProductConstants;
import lippia.web.services.HomePageService;
import lippia.web.services.LoginService;

public class shopSteps {

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

    @When("I fill my details in billing details form")

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

    @Then("I can verify that the tax rate for India is (\\d+)% and for abroad it is (\\d+)%")
    public void verifyTaxRateForIndiaAndForAbroad(double indiaTax, double abroadTax) {
        HomePageService.calculateTaxRate();
        HomePageService.verifyTaxRate(indiaTax, abroadTax);
    }
}
