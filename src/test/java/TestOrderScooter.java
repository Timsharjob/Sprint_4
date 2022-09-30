import PageObject.HomePageScooter;
import PageObject.OrderPageScooter;
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
public class TestOrderScooter {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String dateOrder;
    private final String comment;
    private final int index;
    private WebDriver driver;

    public TestOrderScooter(String firstName, String lastName, String address, String phoneNumber, String dateOrder, String comment, int index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOrder = dateOrder;
        this.comment = comment;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionData() {
        return new Object[][]{
                {"Имя", "Фамилия", "Пермь", "89504444444", "01.01.2023", "Тест", 0},
                {"Иван", "Золотой", "Москва", "89995554466", "25.11.2022", "Нужно больше тестов", 1},
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
    public void checkOrderScooter() {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        homePageScooter.clickOrderButton(index);
        orderPageScooter.setInputOrder(firstName, lastName, address, phoneNumber, dateOrder, comment);
    }

    @Test
    public void checkFirstOrderButton() {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickOrderButton(index);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
