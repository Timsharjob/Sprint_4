import PageObject.HomePageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestScooterAccordion {

    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkAccordionHeadingText0() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(MyConstants.ACCORDING_TEXT_FOR_CHECK_0, 0);
    }

    @Test
    public void checkAccordionHeadingText1() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(MyConstants.ACCORDING_TEXT_FOR_CHECK_1, 1);
    }

    @Test
    public void checkAccordionHeadingText2() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(MyConstants.ACCORDING_TEXT_FOR_CHECK_2, 2);
    }

    @Test
    public void checkAccordionHeadingText3() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(MyConstants.ACCORDING_TEXT_FOR_CHECK_3, 3);
    }

    @Test
    public void checkAccordionHeadingText4() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(MyConstants.ACCORDING_TEXT_FOR_CHECK_4, 4);
    }

    @Test
    public void checkAccordionHeadingText5() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(MyConstants.ACCORDING_TEXT_FOR_CHECK_5, 5);
    }

    @Test
    public void checkAccordionHeadingText6() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(MyConstants.ACCORDING_TEXT_FOR_CHECK_6, 6);
    }

    @Test
    public void checkAccordionHeadingText7() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(MyConstants.ACCORDING_TEXT_FOR_CHECK_7, 7);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}