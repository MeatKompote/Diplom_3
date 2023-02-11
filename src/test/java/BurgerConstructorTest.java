import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.BurgerConstructorPage;

import static org.junit.Assert.assertEquals;

public class BurgerConstructorTest {

    WebDriver driver;

    BurgerConstructorPage burgerConstructorPageObject;

    @Before
    public void initialize() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("проверка отображения нужной секции при нажатии на кнопку \"Булки\"")
    public void clickOnBulkiButtonShowsBulkiSection() {
        driver.get("https://stellarburgers.nomoreparties.site/");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);

        // ожидание загрузки страницы
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // прокручиваем до секции "Начинки"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getNachinkiButtonLocator());

        // клик по кнопке "Булки"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getBulkiButtonLocator());

        // проверка видимости нужной секции
        assertEquals("Секция Булки не видна", true, burgerConstructorPageObject.isElementDisplayed(burgerConstructorPageObject.getBulkiLabelLocator()));

    }

    @Test
    @DisplayName("проверка отображения нужной секции при нажатии на кнопку \"Соусы\"")
    public void clickOnSousesButtonShowsSousesSection() {
        driver.get("https://stellarburgers.nomoreparties.site/");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);

        // ожидание загрузки страницы
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // прокручиваем до секции "Начинки"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getNachinkiButtonLocator());

        // клик по кнопке "Соусы"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getSousesButtonLocator());

        // проверка видимости нужной секции
        assertEquals("Секция Соусы не видна", true, burgerConstructorPageObject.isElementDisplayed(burgerConstructorPageObject.getSousesLabelLocator()));
    }

    @Test
    @DisplayName("проверка отображения нужной секции при нажатии на кнопку \"Начинки\"")
    public void clickOnNachinkiButtonShowsNachinkiSection() {
        driver.get("https://stellarburgers.nomoreparties.site/");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);

        // ожидание загрузки страницы
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // клик по кнопке "Начинки"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getNachinkiButtonLocator());

        // проверка видимости нужной секции
        assertEquals("Секция Начинки не видна", true, burgerConstructorPageObject.isElementDisplayed(burgerConstructorPageObject.getNachinkiLabelLocator()));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}


