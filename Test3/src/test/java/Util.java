import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Util {

    static Util shared = new Util();

    String baseUrl = "https://imgur.com/";
    String rootPath = System.getProperty("user.dir");
    String chromeWebDriverPath  = rootPath + "/drivers/chromedriver";
    String firefoxWebDriverPath = rootPath + "/drivers/geckodriver";

    public Util() {
        setProperties();
    }

    public void prepare(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    public void setProperties() {
        System.setProperty("webdriver.gecko.driver", firefoxWebDriverPath);
        System.setProperty("webdriver.chrome.driver", chromeWebDriverPath);
    }

}
