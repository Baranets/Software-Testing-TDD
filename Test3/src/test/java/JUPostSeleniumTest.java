import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class JUPostSeleniumTest extends Assert {
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

    @Test
    public void testOpenPost() {
        openPost(firefoxDriver);
        openPost(chromeDriver);
    }

    @Test
    public void testPostLike() {
        postLike(firefoxDriver);
        postLike(chromeDriver);
    }

    @Test
    public void testNewPost() {
        newPost(firefoxDriver);
        newPost(chromeDriver);
    }

    public void postLike(WebDriver driver) {
        Util.shared.prepare(driver);

        new JUSignInSeleniumTest().signIn(driver);
        openPost(driver);

        if (driver.findElements( By.xpath("//button[@class='post-action-icon post-action-favorite icon-favorite-fill aqua']") ).size() != 0) {
            WebElement likedButton = driver.findElement(By.xpath("//button[@class='post-action-icon post-action-favorite icon-favorite-fill aqua']"));
            if (likedButton != null) {
                likedButton.click();
            }
        }

        WebElement notLikedButton = driver.findElement(By.xpath("//button[@class='post-action-icon post-action-favorite icon-favorite-outline']"));
        assertNotNull(notLikedButton);

        notLikedButton.click();

        assertNotNull(driver.findElement(By.xpath("//button[@class='post-action-icon post-action-favorite icon-favorite-fill aqua']")));
    }

    public void openPost(WebDriver driver) {
        Util.shared.prepare(driver);

        String openedPostTitle = driver.findElement(By.xpath("(//div[@class=\"Post-item-title\"]/span)[1]")).getText();

        driver.findElement(By.xpath("//div[@class='Grid-column']//div[1]//a[1]")).click();

        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title']"));
        String headerTitle = header.getText();

        assertEquals(openedPostTitle, headerTitle);
    }

    public void newPost(WebDriver driver) {
        Util.shared.prepare(driver);

        new JUSignInSeleniumTest().signIn(driver);

        driver.findElement(By.xpath("//a[@class='Button upload']")).click();

        WebElement input = driver.findElement(By.xpath("//div[@class='PopUpActions-textPicker']/input"));
        input.sendKeys("https://sun9-39.userapi.com/c854220/v854220718/12e817/n4MjcSiTyeU.jpg");

        WebElement postTitle = driver.findElement(By.xpath("//div[@class='UploadPost-postTitle']//span"));
        postTitle.click();
        postTitle.sendKeys("Lazy Css");

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='Button Button-community']"));
        while (!submitButton.isEnabled()) {
            continue;
        }

        driver.findElement(By.xpath("//button[@class='Button Button-community isActive']")).click();

        String tabTitle = driver.findElement(By.xpath("//div[@class='CommonUploadDialog-head']/span")).getText();
        assertEquals("Confirm Public Post", tabTitle);
    }


}
