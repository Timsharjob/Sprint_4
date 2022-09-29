package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class HomePageScooter {
    private final WebDriver driver;
    //Кнопка принять куки
    private final By appCookieButton = By.className("App_CookieButton__3cvqF");
    //Вопросы о важном 0
    private final By accordionHeading0 = By.id("accordion__heading-0");
    //Вопросы о важном 1
    private final By accordionHeading1 = By.id("accordion__heading-1");
    //Вопросы о важном 2
    private final By accordionHeading2 = By.id("accordion__heading-2");
    //Вопросы о важном 3
    private final By accordionHeading3 = By.id("accordion__heading-3");
    //Вопросы о важном 4
    private final By accordionHeading4 = By.id("accordion__heading-4");
    //Вопросы о важном 5
    private final By accordionHeading5 = By.id("accordion__heading-5");
    //Вопросы о важном 6
    private final By accordionHeading6 = By.id("accordion__heading-6");
    //Вопросы о важном 7
    private final By accordionHeading7 = By.id("accordion__heading-7");
    //Текст вопроса о важном 0
    private final By accordionPanelText0 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст вопроса о важном 1
    private final By accordionPanelText1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст вопроса о важном 2
    private final By accordionPanelText2 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст вопроса о важном 3
    private final By accordionPanelText3 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст вопроса о важном 4
    private final By accordionPanelText4 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст вопроса о важном 5
    private final By accordionPanelText5 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст вопроса о важном 6
    private final By accordionPanelText6 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст вопроса о важном 7
    private final By accordionPanelText7 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Кнопка заказать в шапке сайта
    private final By orderScooter0 = By.cssSelector(".Button_Button__ra12g");
    //Кнопка заказать в теле сайта
    private final By orderScooter1 = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAppCookieButton() {
        driver.findElement(appCookieButton).click();
    }

    public void clickOrderButton0() {
        clickAppCookieButton();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderScooter0));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderScooter0));
        driver.findElement(orderScooter0).click();
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderPageScooter.getInputFirstName()));
    }

    public void clickOrderButton1() {
        clickAppCookieButton();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderScooter1));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderScooter1));
        driver.findElement(orderScooter1).click();
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orderPageScooter.getInputFirstName()));
    }

    public void checkAccordionHeadingText(String expectedText, int index) {
        clickAppCookieButton();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("accordion__heading-" + index)));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-" + index)));
        driver.findElement(By.id("accordion__heading-" + index)).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@id='accordion__panel-" + index + "']/p"))));
        String checkText = driver.findElement(By.xpath(".//div[@id='accordion__panel-" + index + "']/p")).getText();
        assertEquals(expectedText, checkText);
    }
}
