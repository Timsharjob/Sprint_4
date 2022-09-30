import PageObject.HomePageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@RunWith(Parameterized.class)
public class TestScooterAccordion {

    private final String accordionTextForCheck;
    private final int index;
    private WebDriver driver;

    public TestScooterAccordion(String accordionTextForCheck, int index) {
        this.accordionTextForCheck = accordionTextForCheck;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionData() {
        return new Object[][]{
                {MyConstants.ACCORDING_TEXT_FOR_CHECK_0, 0},
                {MyConstants.ACCORDING_TEXT_FOR_CHECK_1, 1},
                {MyConstants.ACCORDING_TEXT_FOR_CHECK_2, 2},
                {MyConstants.ACCORDING_TEXT_FOR_CHECK_3, 3},
                {MyConstants.ACCORDING_TEXT_FOR_CHECK_4, 4},
                {MyConstants.ACCORDING_TEXT_FOR_CHECK_5, 5},
                {MyConstants.ACCORDING_TEXT_FOR_CHECK_6, 6},
                {MyConstants.ACCORDING_TEXT_FOR_CHECK_7, 7},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkAccordionHeadingText() {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.checkAccordionHeadingText(accordionTextForCheck, index);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}