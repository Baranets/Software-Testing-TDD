import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class JUHomePageSeleniumTest extends Assert {

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

    enum PostSort {
        MostViral("Most Viral"),
        UserSubmitted("User Submitted"),
        HighestScoring("Highest Scoring");

        private String title;

        PostSort(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }



    public void changePostSort(WebDriver driver, PostSort sort) {
        Util.shared.prepare(driver);

        driver.findElement(By.xpath("//span[@class='NewCover-change-sort-wrapper section']")).click();

        List<WebElement> dropdownOptions = new ArrayList<WebElement>();
        for (PostSort value: PostSort.values()) {
            WebElement element = driver.findElement(By.xpath("//div[contains(text(), \'"+ value.getTitle() +"\')]"));
            dropdownOptions.add(element);
        }

        switch (sort) {
            case MostViral:
                dropdownOptions.get(0).click();
                break;
            case UserSubmitted:
                dropdownOptions.get(1).click();
                break;
            case HighestScoring:
                dropdownOptions.get(2).click();
                break;
        }
        String newValue = driver.findElement(By.xpath("//span[@class='NewCover-change-sort-wrapper section']//div[@class='Dropdown-title']/span")).getText();

        assertEquals(sort.getTitle().toUpperCase(), newValue);
    }

    public void openLeaderBoard(WebDriver driver) {
        Util.shared.prepare(driver);

        driver.findElement(By.xpath("//div[@class='ProfileNavbar-item uScaleTransition']//a")).click();

        String headerText = driver.findElement(By.xpath("//h1[@class='Leaderboard-label']")).getText();

        assertEquals(headerText, "Best Comments");
    }

    public void openTrend(WebDriver driver) throws InterruptedException {
        Util.shared.prepare(driver);

        String trendText = driver.findElement(By.xpath("//div[@class='TrendingTags-container']//a[2]/div/div[@class=\"Tag-name\"]")).getText();
        driver.findElement(By.xpath("//div[@class='TrendingTags-container']//a[2]")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class=\"Cover-metadata\"]/h1[@class=\"Cover-name\"]")).getText());
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/h1[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//h1[1]")).getText());

        String resultText = driver.findElement(By.xpath("//h1[1]")).getText();

        assertEquals(resultText.toLowerCase(), trendText.toLowerCase());
    }

    @Test
    public void testChangePostSorting() {
        changePostSort(firefoxDriver, PostSort.HighestScoring);
        changePostSort(chromeDriver, PostSort.HighestScoring);
    }

    @Test
    public void testOpenLeaderBoard() {
        openLeaderBoard(firefoxDriver);
        openLeaderBoard(chromeDriver);
    }

    @Test
    public void testOpenTrend() throws InterruptedException {
        openTrend(firefoxDriver);
        openTrend(chromeDriver);
    }

}
