import PageObject.HomePageScooter;
import PageObject.OrderPageScooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestOrderScooter {

    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkOrderScooter1() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        homePageScooter.clickOrderButton0();
        orderPageScooter.setInputOrder("Имя", "Фамилия", "Пермь", "89504444444", "01.01.2023", "Тест");
    }

    @Test
    public void checkOrderScooter2() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        homePageScooter.clickOrderButton0();
        orderPageScooter.setInputOrder("Иван", "Золотой", "Москва", "89995554466", "25.11.2022", "Нужно больше тестов");
    }

    @Test
    public void checkFirstOrderButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickOrderButton0();
    }

    @Test
    public void checkSecondOrderButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickOrderButton1();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
