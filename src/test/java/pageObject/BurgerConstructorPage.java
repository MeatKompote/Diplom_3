package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerConstructorPage extends AbstractPage{

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
    public By getCreateBurgerLabelLocator() {
        return createBurgerLabelLocator;
    }

    public By getPersonalCabinetButtonLocator() {
        return personalCabinetButtonLocator;
    }

    public By getEnterAccountButtonLocator() {
        return enterAccountButtonLocator;
    }

    public By getBulkiButtonLocator() {
        return bulkiButtonLocator;
    }

    public By getSousesButtonLocator() {
        return sousesButtonLocator;
    }

    public By getNachinkiButtonLocator() {
        return nachinkiButtonLocator;
    }

    public By getBulkiLabelLocator() {
        return bulkiLabelLocator;
    }

    public By getSousesLabelLocator() {
        return sousesLabelLocator;
    }

    public By getNachinkiLabelLocator() {
        return nachinkiLabelLocator;
    }
}
