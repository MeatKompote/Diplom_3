package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends AbstractPage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    // заголовок "Вход"
    private By signInLabelLocator = By.xpath(".//h2[text()='Вход']");

    // поле email
    private By emailTextFieldLocator = By.xpath(".//label[text()='Email']/parent :: div/input");

    // поле Пароль
    private By passwordTextFieldLocator = By.xpath(".//label[text()='Пароль']/parent :: div/input");

    // кнопка "Войти"
    private By signInButtonLocator = By.xpath(".//button[text()='Войти']");

    // кнопка "Зарегистрироваться"
    private By registrationButtonLocator = By.xpath(".//a[text()='Зарегистрироваться']");

    public void logIn(String email, String password) {
        // ожидание загрузки
        waitTillElementIsVisible(signInLabelLocator);

        // заполнение полей
        insertTextIntoField(emailTextFieldLocator, email);
        insertTextIntoField(passwordTextFieldLocator, password);

        // нажатие на кнопку "Войти"
        clickToTheElement(signInButtonLocator);
    }


    // геттеры для локаторов
    public By getSignInLabelLocator() {
        return signInLabelLocator;
    }

    public By getEmailTextFieldLocator() {
        return emailTextFieldLocator;
    }

    public By getPasswordTextFieldLocator() {
        return passwordTextFieldLocator;
    }

    public By getSignInButtonLocator() {
        return signInButtonLocator;
    }

    public By getRegistrationButtonLocator() {
        return registrationButtonLocator;
    }
}
