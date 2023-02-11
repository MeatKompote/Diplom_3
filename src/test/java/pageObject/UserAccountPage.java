package pageObject;

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

    // поле Имя
    private By userNameTextField = By.xpath(".//label[text()='Имя']/parent :: div/input");



    // геттеры для локаторов
    public By getAccountLabelLocator() {
        return accountLabelLocator;
    }

    public By getConstructorButtonLocator() {
        return constructorButtonLocator;
    }

    public By getStellarBurgersLogoLocator() {
        return stellarBurgersLogoLocator;
    }

    public By getSignOutButtonLocator() {
        return signOutButtonLocator;
    }

    public By getUserNameTextField() {
        return userNameTextField;
    }
}
