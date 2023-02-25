import actions.Actions;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class SignInTest {

    WebDriver driver;

    String userName;
    String email;
    String password = "123456";

    SignUpPage signUpPageObject;
    BurgerConstructorPage burgerConstructorPageObject;
    SignInPage signInPageObject;
    UserAccountPage userAccountPageObject;
    RestorePasswordPage restorePasswordPageObject;
    Actions actions = new Actions();

    @Before
    public void createRandomUser() {
        driver = new ChromeDriver();
        userName = actions.generateRandomName();
        email = actions.generateRandomName() + "@test.ru";
        driver.get("https://stellarburgers.nomoreparties.site/register");

        signUpPageObject = new SignUpPage(driver);

        // создаем случайного тест юзера
        actions.generateRandomUser(driver, userName, email, password);
    }

    @Test
    @DisplayName("проверка логина при нажатии на кнопку \"Войти в аккаунт\"")
    public void loginWithGetIntoAccountButton() {

        driver.get("https://stellarburgers.nomoreparties.site/");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);
        signInPageObject = new SignInPage(driver);
        userAccountPageObject = new UserAccountPage(driver);

        // ожидание загрузки
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // клик по кнопке "Войти в аккаунт"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getEnterAccountButtonLocator());

        signInPageObject.logIn(email, password);

        // проверка на удачный логин
        assertEquals("Имя пользователя не соответствует ожидаемому", userName,
                actions.getUserNameAfterLogin(driver));
    }

    @Test
    @DisplayName("проверка логина при нажатии на кнопку \"Личный кабинет\"")
    public void loginWithPersonalCabinetButton() {
        driver.get("https://stellarburgers.nomoreparties.site/");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);
        signInPageObject = new SignInPage(driver);
        userAccountPageObject = new UserAccountPage(driver);

        // ожидание загрузки
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // нажатие на кнопку "Личный кабинет"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getPersonalCabinetButtonLocator());

        signInPageObject.logIn(email, password);

        // проверка на удачный логин
        assertEquals("Имя пользователя не соответствует ожидаемому", userName,
                actions.getUserNameAfterLogin(driver));
    }

    @Test
    @DisplayName("проверка логина при нажатии на кнопку \"Войти\" на странице регистрации")
    public void loginUsingButtonOnRegistrationForm() {
        driver.get("https://stellarburgers.nomoreparties.site/register");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);
        signInPageObject = new SignInPage(driver);
        signUpPageObject = new SignUpPage(driver);
        userAccountPageObject = new UserAccountPage(driver);

        // ожидание загрузки
        signUpPageObject.waitTillElementIsVisible(signUpPageObject.getRegistrationLabelLocator());

        // прокрутка вниз до кнопки "Войти"
        signUpPageObject.scrollDownToTheElement(signUpPageObject.getSingInButtonLocator());

        // нажатие на кнопку "Войти"
        signUpPageObject.clickToTheElement(signUpPageObject.getSingInButtonLocator());

        signInPageObject.logIn(email, password);

        // проверка на удачный логин
        assertEquals("Имя пользователя не соответствует ожидаемому", userName,
                actions.getUserNameAfterLogin(driver));
    }

    @Test
    @DisplayName("проверка логина при нажатии на кнопку \"Войти\" на странице восстановления пароля")
    public void loginFromRestorePasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);
        signInPageObject = new SignInPage(driver);
        restorePasswordPageObject = new RestorePasswordPage(driver);
        userAccountPageObject = new UserAccountPage(driver);

        // ожидание загрузки
        restorePasswordPageObject.waitTillElementIsVisible(restorePasswordPageObject.getRestorePasswordLabelLocator());

        // прокрутка вниз до кнопки "Войти"
        restorePasswordPageObject.scrollDownToTheElement(restorePasswordPageObject.getSignInButtonLocator());

        // нажатие на кнопку "Войти"
        restorePasswordPageObject.clickToTheElement(restorePasswordPageObject.getSignInButtonLocator());

        signInPageObject.logIn(email, password);

        // проверка на удачный логин
        assertEquals("Имя пользователя не соответствует ожидаемому", userName,
                actions.getUserNameAfterLogin(driver));
    }

    @After
    public void teardown() {
        actions.signOut(driver);
        driver.quit();
    }
}

