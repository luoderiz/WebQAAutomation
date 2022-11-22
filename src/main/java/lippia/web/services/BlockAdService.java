package lippia.web.services;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.AdConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlockAdService extends WebActionManager {

    public static void closeAds() {
        WebDriver driver = DriverManager.getDriverInstance();
        try {
            WebElement iframe1 = getElement(AdConstants.AD_IFRAME1);
            if (iframe1.isDisplayed()) {
                driver.switchTo().frame(iframe1);
                try {
                    getElement(AdConstants.AD_CLOSE_BUTTON).click();
                } catch (Exception e) {
                    WebElement iframe2 = getElement(AdConstants.AD_IFRAME2);
                    driver.switchTo().frame(iframe2);
                    click(AdConstants.AD_CLOSE_BUTTON);
                }
                driver.switchTo().defaultContent();
            }
        } catch (Exception e) {
        }
    }

}
