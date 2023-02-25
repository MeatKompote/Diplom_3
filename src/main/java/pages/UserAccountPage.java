package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccountPage extends AbstractPage {

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    // заголовок "Профиль"
    private By accountLabelLocator = By.xpath(".//a[text()='Профиль']");

    // кнопка "Конструктор"
    private By constructorButtonLocator = By.xpath(".//p[text()='Конструктор']");

    // логотип "Stellar Burgers"
    private By stellarBurgersLogoLocator = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    // кнопка "Выход"
    private By signOutButtonLocator = By.xpath(".//button[text()='Выход']");

    // поле "Имя"
    private By userNameTextField = By.xpath(".//label[text()='Имя']/parent :: div/input");


    // геттеры для локаторов
    @Step("Получение локатора: заголовок \"Профиль\"")
    public By getAccountLabelLocator() {
        return accountLabelLocator;
    }

    @Step("Получение локатора: кнопка \"Конструктор\"")
    public By getConstructorButtonLocator() {
        return constructorButtonLocator;
    }

    @Step("Получение локатора: логотип \"Stellar Burgers\"")
    public By getStellarBurgersLogoLocator() {
        return stellarBurgersLogoLocator;
    }

    @Step("Получение локатора: кнопка \"Выход\"")
    public By getSignOutButtonLocator() {
        return signOutButtonLocator;
    }

    @Step("Получение локатора: поле \"Имя\"")
    public By getUserNameTextField() {
        return userNameTextField;
    }
}
