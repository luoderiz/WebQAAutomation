package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.LoginConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static lippia.web.services.BlockAdService.blockAd;

public class LoginService extends ActionManager {

    public static void navigateWeb() {
        navigateTo(PropertyManager.getProperty("web.url"));
        blockAd();
    }
    //todo delete web.base.url from config.properties
    //todo delete web-app.url from pom

    public static void click(String locatorElement) {
        blockAd();
        WebElement element = waitClickable(locatorElement);
        click(element);
        blockAd();
    }

    public static void verify(String locatorElement, int expectedValue) {
        blockAd();
        List<WebElement> elements = getElements(locatorElement);
        int actualValue = elements.size();
        Assert.assertEquals(actualValue, expectedValue);
        blockAd();
    }

    public static void enter(String element, String data) {
        blockAd();
        setInput(element, data, true, false);
        blockAd();
    }

    public static void checkUrl(String actualValue, String expectedValue) {
        blockAd();
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void verifyPresence(String element) {
        blockAd();
        isPresent(element);
    }

    public static void verifyLogin(){
        /*
        String actualValue = DriverManager.getDriverInstance().getCurrentUrl();
        String expectedValue = PropertyManager.getProperty("my.account.url");
        LoginService.checkUrl(actualValue, expectedValue);
         */
        blockAd();
        isPresent(LoginConstants.WELCOME_MESSAGE);
    }
}
