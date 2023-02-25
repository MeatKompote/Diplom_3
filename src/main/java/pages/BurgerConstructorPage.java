package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerConstructorPage extends AbstractPage {

    public BurgerConstructorPage(WebDriver driver) {
        super(driver);
    }

    // заголовок "Соберите бургер"
    private By createBurgerLabelLocator = By.xpath(".//h1[text()='Соберите бургер']");

    // кнопка "Личный Кабинет"
    private By personalCabinetButtonLocator = By.xpath(".//p[text()='Личный Кабинет']");

    // кнопка "Войти в аккаунт"
    private By enterAccountButtonLocator = By.xpath(".//button[text()='Войти в аккаунт']");

    // кнопка "Булки"
    private By bulkiButtonLocator = By.xpath(".//span[text()='Булки']");

    // кнопка "Соусы"
    private By sousesButtonLocator = By.xpath(".//span[text()='Соусы']");

    // кнопка "Начинки"
    private By nachinkiButtonLocator = By.xpath(".//span[text()='Начинки']");

    // заголовок "Булки"
    private By bulkiLabelLocator = By.xpath(".//h2[text()='Булки']");

    // заголовок "Соусы"
    private By sousesLabelLocator = By.xpath(".//h2[text()='Соусы']");

    // заголовок "Начинки"
    private By nachinkiLabelLocator = By.xpath(".//h2[text()='Начинки']");

    // геттеры для локаторов
    @Step("Получение локатора: заголовок \"Соберите бургер\"")
    public By getCreateBurgerLabelLocator() {
        return createBurgerLabelLocator;
    }

    @Step("Получение локатора: кнопка \"Личный Кабинет\"")
    public By getPersonalCabinetButtonLocator() {
        return personalCabinetButtonLocator;
    }

    @Step("Получение локатора: кнопка \"Войти в аккаунт\"")
    public By getEnterAccountButtonLocator() {
        return enterAccountButtonLocator;
    }

    @Step("Получение локатора: кнопка \"Булки\"")
    public By getBulkiButtonLocator() {
        return bulkiButtonLocator;
    }

    @Step("Получение локатора: кнопка \"Соусы\"")
    public By getSousesButtonLocator() {
        return sousesButtonLocator;
    }

    @Step("Получение локатора: кнопка \"Начинки\"")
    public By getNachinkiButtonLocator() {
        return nachinkiButtonLocator;
    }

    @Step("Получение локатора: заголовок \"Булки\"")
    public By getBulkiLabelLocator() {
        return bulkiLabelLocator;
    }

    @Step("Получение локатора: заголовок \"Соусы\"")
    public By getSousesLabelLocator() {
        return sousesLabelLocator;
    }

    @Step("Получение локатора: заголовок \"Начинки\"")
    public By getNachinkiLabelLocator() {
        return nachinkiLabelLocator;
    }
}
