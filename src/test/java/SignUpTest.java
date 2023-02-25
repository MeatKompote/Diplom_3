import actions.Actions;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class SignUpTest {

    private WebDriver driver;
    Actions actions = new Actions();

    String userName = actions.generateRandomName();
    String email = actions.generateRandomName() + "@test.ru";
    String password = "123456";

    @Before
    public void initialize() {
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/register");
    }


    @Test
    @DisplayName("Проверка успешной регистрации")
    public void registrationWithCorrectCredentials() {

        SignUpPage signUpPageObject = new SignUpPage(driver);
        SignInPage signInPageObject = new SignInPage(driver);
        BurgerConstructorPage burgerConstructorPageObject = new BurgerConstructorPage(driver);
        UserAccountPage userAccountPageObject = new UserAccountPage(driver);

        signUpPageObject.registration(userName, email, password);

        signInPageObject.logIn(email, password);

        // перейти в личный кабинет
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getPersonalCabinetButtonLocator());

        // в личном кабинете проверка username
        userAccountPageObject.waitTillElementIsVisible(userAccountPageObject.getAccountLabelLocator());
        assertEquals("Имя пользователя не соответствует ожидаемому", userName,
                userAccountPageObject.getElementAttribute(userAccountPageObject.getUserNameTextField(), "value"));
    }

    @Test
    @DisplayName("Проверка регистрации с паролем меньше 6 символов")
    public void registrationWithIncorrectPassword() {
        String incorrectPassword = "12345";

        SignUpPage signUpPageObject = new SignUpPage(driver);

        signUpPageObject.registration(userName, email, incorrectPassword);

        // проверка сообщения "Некорректный пароль"
        assertEquals("Не видна надпись Некорректны пароль", true, signUpPageObject.isElementDisplayed(signUpPageObject.getIncorrectPasswordTextLocator()));

    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
