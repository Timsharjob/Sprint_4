package PageObject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.startsWith;

public class OrderPageScooter {
    private final WebDriver driver;
    //Имя
    private final By inputFirstName = By.cssSelector("input[placeholder='* Имя']");
    //Фамилия
    private final By inputLastName = By.cssSelector("input[placeholder='* Фамилия']");
    //Адрес
    private final By inputAddress = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    //Станция метро
    private final By inputMetroStation = By.cssSelector("input[placeholder='* Станция метро']");
    private final By inputMetroStationSelect = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button");
    //Номер телефона
    private final By inputPhoneNumber = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Дата доставки
    private final By inputDateDelivery = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    //Период аренды
    private final By inputRentalPeriod = By.cssSelector(".Dropdown-arrow");
    private final By dropdownOption = By.xpath(".//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    //Цвет чёрный
    private final By checkBoxBlack = By.id("black");
    //Цвет Серый
    private final By checkBoxGrey = By.id("grey");
    //Комментарий для курьера
    private final By inputComment = By.cssSelector("input[placeholder='Комментарий для курьера']");
    //Кнопка "Далее"
    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][1]");
    //Кнопка "Да"
    private final By buttonOrderComplete = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    //Текст после оформления заказа
    private final By orderCompleteMessage = By.cssSelector(".Order_ModalHeader__3FDaJ");


    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputOrder(String firstName, String lastName, String address, String phoneNumber, String dateOrder, String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(inputFirstName));
        driver.findElement(inputFirstName).sendKeys(firstName);
        driver.findElement(inputLastName).sendKeys(lastName);
        driver.findElement(inputAddress).sendKeys(address);
        driver.findElement(inputMetroStation).click();
        driver.findElement(inputMetroStationSelect).click();
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
        driver.findElement(buttonNext).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(inputDateDelivery));
        driver.findElement(inputDateDelivery).sendKeys(dateOrder);
        driver.findElement(inputRentalPeriod).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(dropdownOption));
        driver.findElement(dropdownOption).click();
        driver.findElement(checkBoxBlack).click();
        driver.findElement(inputComment).sendKeys(comment);
        driver.findElement(buttonOrder).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(buttonOrderComplete)));
        driver.findElement(buttonOrderComplete).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderCompleteMessage)));
        String checkText = driver.findElement(orderCompleteMessage).getText();
        MatcherAssert.assertThat(checkText, startsWith("Заказ оформлен"));
    }

    public By getInputFirstName() {
        return inputFirstName;
    }
}
