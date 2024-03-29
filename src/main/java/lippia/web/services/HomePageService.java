package lippia.web.services;

import com.crowdar.core.actions.ActionManager;

import com.crowdar.driver.DriverManager;
import gherkin.deps.com.google.gson.Gson;
import lippia.web.constants.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Math.abs;

public class HomePageService extends ActionManager {
    private static final double epsilon = 0.1;

    public static void verify(String locatorElement, int expectedValue) {
        List<WebElement> elements = getElements(locatorElement);
        int actualValue = elements.size();
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void verifyRedirection(String path) {
        String page = DriverManager.getDriverInstance().getCurrentUrl();
        if(!page.contains(path)) {
            Assert.fail("User was not redirected to the expected page");
        }    }

    public static Double getValue(String element) {
        String text = getText(element);
        String onlyNumbers = text.replaceAll("[^\\d+\\.\\d+]", "");
        return Double.valueOf(onlyNumbers);
    }

    public static void compareValues(double lessValue, double greaterValue) {
        Assert.assertTrue(lessValue < greaterValue);
    }

    public static void chooseFromOption(String locatorElement, String chosenOption) throws Exception {
        List<WebElement> Options = getElements(locatorElement);
        for (WebElement option : Options) {
            String displayedOption = option.getText();
            if (chosenOption.equals(displayedOption)) {
                click(option);
            }
        }
    }

    public static void completeBillingForm() throws Exception {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/data/billingDataDiegoArmando.json"));
        User userDiego = gson.fromJson(reader, User.class);
        LoginService.enter(PaymentGatewayConstants.BILLING_FIRST_NAME_INPUT_BOX, userDiego.getBillingFirstName());
        LoginService.enter(PaymentGatewayConstants.BILLING_LAST_NAME_INPUT_BOX, userDiego.getBillingLastName());
        LoginService.enter(PaymentGatewayConstants.BILLING_COMPANY_INPUT_BOX, userDiego.getBillingCompany());
        LoginService.enter(PaymentGatewayConstants.BILLING_EMAIL_INPUT_BOX, userDiego.getBillingEmail());
        LoginService.enter(PaymentGatewayConstants.BILLING_PHONE_INPUT_BOX, userDiego.getBillingPhone());
        String billingCountryLocator = String.format(PaymentGatewayConstants.BILLING_COUNTRY_SELECTED_OPTION, userDiego.getBillingCountry());
        LoginService.click(PaymentGatewayConstants.BILLING_COUNTRY_DISPLAY_OPTIONS_BUTTON);
        LoginService.click(billingCountryLocator);
        LoginService.enter(PaymentGatewayConstants.BILLING_STREET_ADDRESS_INPUT_BOX, userDiego.getBillingStreetAddress());
        LoginService.enter(PaymentGatewayConstants.BILLING_ADDRESS_APARTMENT_INPUT_BOX, userDiego.getBillingAddressApartment());
        LoginService.enter(PaymentGatewayConstants.BILLING_CITY_INPUT_BOX, userDiego.getBillingCity());
        String state = userDiego.getBillingState();
        chooseFromOption(PaymentGatewayConstants.BILLING_STATE_OPTIONS, state);
        LoginService.enter(PaymentGatewayConstants.BILLING_POSTCODE_INPUT_BOX, userDiego.getBillingPostcode());
    }

    public static void addToBasket() {
        LoginService.click(HomeConstants.NEW_ARRIVAL_IN_STOCK);
        HomePageService.verifyRedirection("/product/");
        LoginService.verifyPresence(ProductConstants.ADD_TO_BASKET_BUTTON);
        LoginService.click(ProductConstants.ADD_TO_BASKET_BUTTON);
        LoginService.verifyPresence(ProductConstants.PRODUCT_PRICE);
        LoginService.click(ProductConstants.VIEW_BASKET_BUTTON);
        HomePageService.verifyRedirection("/basket/");
        HomePageService.compareValues(HomePageService.getValue(ProductConstants.BASKET_SUBTOTAL_VALUE), HomePageService.getValue(ProductConstants.BASKET_TOTAL_VALUE));
    }

    public static void read(String locatorElement) {
        String details = getText(locatorElement);
        if (details.isEmpty()) {
            Assert.fail("Missing order details at Confirm Order Page");
        }
    }

    public static Double calculateTaxRate() {
        double taxValue = getValue(OrderConfirmationConstants.ORDER_DETAILS_TAX);
        double totalValue = getValue(OrderConfirmationConstants.ORDER_DETAILS_TOTAL);
        return taxValue * 100 / totalValue;
    }

    public static void verifyTaxRate(double indiaTax, double abroadTax) {
        String location = getText(OrderConfirmationConstants.ORDER_LOCATION);
        if (location.equals("India")) {
            Assert.assertTrue(abs(indiaTax - calculateTaxRate()) <= epsilon);
        } else { Assert.assertTrue(abs(abroadTax - calculateTaxRate()) <= epsilon);
        }
    }
}
