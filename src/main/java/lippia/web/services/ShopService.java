package lippia.web.services;

import gherkin.deps.com.google.gson.Gson;
import lippia.web.constants.OrderConfirmationConstants;
import lippia.web.constants.PaymentGatewayConstants;
import lippia.web.constants.User;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShopService {

    public static double calculateActualTaxPercentage(String country) throws Exception {
        if (country.equals("abroad")) {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/data/billingDataDiegoArmando.json"));
            User userDiego = gson.fromJson(reader, User.class);
            String billingCountryLocator = String.format(PaymentGatewayConstants.BILLING_COUNTRY_SELECTED_OPTION, userDiego.getBillingCountry());
            LoginService.click(PaymentGatewayConstants.BILLING_COUNTRY_DISPLAY_OPTIONS_BUTTON);
            LoginService.click(billingCountryLocator);
        } else {
            String billingCountryLocator = String.format(PaymentGatewayConstants.BILLING_COUNTRY_SELECTED_OPTION, country);
            LoginService.click(PaymentGatewayConstants.BILLING_COUNTRY_DISPLAY_OPTIONS_BUTTON);
            LoginService.click(billingCountryLocator);
        }
        double tax = HomePageService.getValue(OrderConfirmationConstants.ORDER_DETAILS_TAX);
        double subtotal = HomePageService.getValue(OrderConfirmationConstants.ORDER_DETAILS_SUBTOTAL);
        return tax * 100 / subtotal;
    }
}
