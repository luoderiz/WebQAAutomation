package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.WebElement;

public class LoginService extends ActionManager {

    public static void navigateWeb() {
        WebActionManager.navigateTo(PropertyManager.getProperty("web.url"));
        BlockAdService.closeAds();
    }

    public static void navigateBack() {
        DriverManager.getDriverInstance().navigate().back();
        BlockAdService.closeAds();
    }

    public static void click(String locatorElement) {
        WebElement element = waitClickable(locatorElement);
        click(element);
        BlockAdService.closeAds();
    }

    public static void enter(String element, String data) {
        setInput(element, data, true, false);
    }

    public static void verifyPresence(String element) {
        isPresent(element);
    }

}
