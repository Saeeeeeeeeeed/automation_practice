package base;

import com.beust.jcommander.Parameter;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utilites.PropertiesReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    NgWebDriver ngDriver;
    JavascriptExecutor jse;
    public SoftAssert softAssert = new SoftAssert();
    public Logger log = LogManager.getLogger(BaseTest.class);

    private final PropertiesReader propHandler = new PropertiesReader();
    public Properties generalConfigurationProps = propHandler.loadPropertiesFromFile("generalConfig.properties");

    @Parameters({"url"})
    @BeforeTest
    public void setUp (@Optional("http://www.automationpractice.pl/index.php")String url) {
        try {
            log.info("Initialize Selenium WebDriver before tests' Class");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(setChromeOption());
            jse = (JavascriptExecutor) driver;
            ngDriver = new NgWebDriver(jse).withRootSelector("\"app-root\"");
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            log.info("Selenium web driver was initialized successfully");
            log.info("user logged successfully");
        } catch (Exception e) {
            log.error("Error occurred while initializing selenium web driver", e);
        }
    }


    private ChromeOptions setChromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> ChromePrefs = new HashMap<>();
        ChromePrefs.put("profile.default.content_settings.popups", 0);
        options.setExperimentalOption("prefs", ChromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.addArguments("window-size=1024,768");
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        return options;
    }

    @AfterTest
    public void quit() {
        log.info("Closing selenium Web driver after test");
        driver.quit();
    }

}
