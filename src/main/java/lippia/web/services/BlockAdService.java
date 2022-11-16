package lippia.web.services;
import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class BlockAdService extends WebActionManager {

    public static void blockAd() {

        String actualValue = DriverManager.getDriverInstance().getCurrentUrl();
        String expectedValue = PropertyManager.getProperty("ad.vignette");
        boolean adToBlock = actualValue.equals(expectedValue);
        if (adToBlock) {
            WebDriver.close();
        }
    }

    public static void nosirveBlockAd() {
        WebDriver driver = DriverManager.getDriverInstance();
        int windowHandle = driver.getWindowHandles().size();

        if (windowHandle > 1) {
            driver.close();
        }
    }
}
