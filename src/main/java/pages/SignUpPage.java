package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends AbstractPage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    // заголовок "Регистрация"
    private By registrationLabelLocator = By.xpath(".//h2[text()='Регистрация']");

    // текстовое поле "Имя"
    private By nameTextFieldLocator = By.xpath(".//label[text()='Имя']/parent :: div/input");

    // текстовое поле "Email"
    private By emailTextFieldLocator = By.xpath(".//label[text()='Email']/parent :: div/input");

    // текстовое поле "Пароль"
    private By passwordTextFieldLocator = By.xpath(".//label[text()='Пароль']/parent :: div/input");

    // кнопка "Зарегистрироваться"
    private By registrationButtonLocator = By.xpath(".//button[text()='Зарегистрироваться']");

    // кнопка "Войти"
    private By singInButtonLocator = By.xpath(".//a[text()='Войти']");

    // текст "Некорректный пароль"
    private By incorrectPasswordTextLocator = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("Регистрация пользователя")
    public void registration(String userName, String email, String password) {

        // ожидание загрузки
        waitTillElementIsVisible(registrationButtonLocator);

        // заполнение полей
        insertTextIntoField(nameTextFieldLocator, userName);
        insertTextIntoField(emailTextFieldLocator, email);
        insertTextIntoField(passwordTextFieldLocator, password);

        // нажатие на кнопку "Войти"
        clickToTheElement(registrationButtonLocator);
    }

    // геттеры для локаторов
    @Step("Получение локатора: заголовок \"Регистрация\"")
    public By getRegistrationLabelLocator() {
        return registrationLabelLocator;
    }

    @Step("Получение локатора: текстовое поле \"Имя\"")
    public By getNameTextFieldLocator() {
        return nameTextFieldLocator;
    }

    @Step("Получение локатора: текстовое поле \"Email\"")
    public By getEmailTextFieldLocator() {
        return emailTextFieldLocator;
    }

    @Step("Получение локатора: текстовое поле \"Пароль\"")
    public By getPasswordTextFieldLocator() {
        return passwordTextFieldLocator;
    }

    @Step("Получение локатора: кнопка \"Зарегистрироваться\"")
    public By getRegistrationButtonLocator() {
        return registrationButtonLocator;
    }

    @Step("Получение локатора: кнопка \"Войти\"")
    public By getSingInButtonLocator() {
        return singInButtonLocator;
    }

    @Step("Получение локатора: текст \"Некорректный пароль\"")
    public By getIncorrectPasswordTextLocator() {
        return incorrectPasswordTextLocator;
    }
}
