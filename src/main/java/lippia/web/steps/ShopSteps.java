package lippia.web.steps;

import io.cucumber.java.en.And;
import lippia.web.constants.ShopConstants;
import lippia.web.services.LoginService;
import lippia.web.services.ShopService;
import org.testng.Assert;

public class ShopSteps {

    @And("I click on an item")
    public void clickOnItem() {
        LoginService.click(ShopConstants.IN_STOCK_ITEM);
    }

    @And("Tax rate for (.*) should be (.*)% and for (.*) it should be (.*)%")
    public void verifyTaxRates(String taxCountry1, double taxAmount1, String taxCountry2, double taxAmount2) throws Exception {
        Assert.assertEquals(ShopService.calculateActualTaxPercentage(taxCountry1), taxAmount1);
        Assert.assertEquals(ShopService.calculateActualTaxPercentage(taxCountry2), taxAmount2);
    }


}
