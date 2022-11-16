package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.LoginConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.crowdar.core.actions.WebActionManager.navigateTo;

public class LoginService extends ActionManager {

    public static void navigateWeb() {
        navigateTo(PropertyManager.getProperty("web.url"));
    }
    //todo delete web.base.url from config.properties
    //todo delete web-app.url from pom

    public static void click(String locatorElement) {
        WebElement element = waitClickable(locatorElement);
        click(element);
    }

    public static void verify(String locatorElement, int expectedValue) {
        List<WebElement> elements = getElements(locatorElement);
        int actualValue = elements.size();
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void enter(String element, String data) {
        setInput(element, data, true, false);
    }

    public static void checkUrl(String actualValue, String expectedValue) {
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void verifyPresence(String element) {
        isPresent(element);
    }

    public static void verifyLogin(){
        /*
        String actualValue = DriverManager.getDriverInstance().getCurrentUrl();
        String expectedValue = PropertyManager.getProperty("my.account.url");
        LoginService.checkUrl(actualValue, expectedValue);
         */
        isPresent(LoginConstants.WELCOME_MESSAGE);
    }
}
