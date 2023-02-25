package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage extends AbstractPage {

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }

    // заголовок "Восстановление пароля"
    private By restorePasswordLabelLocator = By.xpath(".//h2[text()='Восстановление пароля']");

    // кнопка "Войти"
    private By signInButtonLocator = By.xpath(".//a[text()='Войти']");

    // геттеры для локаторов
    @Step("Получение локатора: заголовок \"Восстановление пароля\"")
    public By getRestorePasswordLabelLocator() {
        return restorePasswordLabelLocator;
    }

    @Step("Получение локатора: кнопка \"Войти\"")
    public By getSignInButtonLocator() {
        return signInButtonLocator;
    }
}
