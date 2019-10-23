import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUSignInSeleniumTest extends Assert {

    private ChromeDriver chromeDriver;
    private FirefoxDriver firefoxDriver;

    @Before
    public void setUp() {
        Util.shared.setProperties();
        firefoxDriver = new FirefoxDriver();
        chromeDriver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }

    public void signIn(WebDriver driver) {
        Util.shared.prepare(driver);

        driver.findElement(By.xpath("//a[@class='Navbar-signin']")).click();
        driver.findElement(By.xpath("//a[@href=\"/signin/facebook\"]")).click();

        facebookDataPass(driver, "username", "password");

        boolean isEnabled = driver.findElement(By.xpath("//span[@class='UserAvatar NavbarAvatar-navbar NavbarAvatar']")).isEnabled();

        assertTrue(isEnabled);
    }

    public void facebookDataPass(WebDriver driver, String login, String pass) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    public void signOut(WebDriver driver) {
        signIn(driver);

        driver.findElement(By.xpath("//div[@class='Dropdown NavbarUserMenu']//div[@class='Dropdown-title']")).click();

        driver.findElement(By.xpath("//div[@class='Dropdown-option-group Dropdown-option-footer']//div[@class='Dropdown-option']")).click();

        String signOutText = driver.findElement(By.xpath("//div[@class=\"center\"]/h1")).getText();

        assertTrue(signOutText.contains("signed out"));
    }

    @Test
    public void testSignInByFacebook() {
        signIn(firefoxDriver);
        signIn(chromeDriver);
    }

    @Test
    public void testSignOut() {
        signOut(firefoxDriver);
        signOut(chromeDriver);
    }

}
