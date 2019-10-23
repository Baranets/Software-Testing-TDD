import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUSearchSeleniumTest extends Assert {

    private ChromeDriver chromeDriver;
    private FirefoxDriver firefoxDriver;

    private boolean doSearch(WebDriver driver, String searchText){
        Util.shared.prepare(driver);

        WebElement searchBar = driver.findElement(By.xpath("//input[@class='Searchbar-textInput']"));

        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(searchText);
        searchBar.sendKeys(Keys.ENTER);

        By searchedTextXpath = By.xpath("//span[@class='search-term-text sorting-text-align']");

        WebElement searchedTextSpan = driver.findElement(searchedTextXpath);
        String searchedText = searchedTextSpan.getText();

        assertEquals(searchedText,searchText);

        int postSize = driver.findElements(By.className("post")).size();

        return postSize > 0;
    }

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

    @Test
    public void testSuccessfulWithResultsSearch() {
        String searchText = "developer";

        boolean foo = doSearch(firefoxDriver, searchText);
        boolean bar = doSearch(chromeDriver, searchText);

        assertTrue(foo);
        assertTrue(bar);
    }

    @Test
    public void testWrongWithoutResultsSearch() {
        String searchText = "asdsdnaja dskanjflkajbflwjkb asdasjnfkd.";

        boolean foo = doSearch(firefoxDriver, searchText);
        boolean bar = doSearch(chromeDriver, searchText);

        assertFalse(foo);
        assertFalse(bar);
    }
}
