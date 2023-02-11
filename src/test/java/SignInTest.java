import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;

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

    public static String generateRandomName() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public void assertCorrectLogin() {

        // ожидание загрузки главной страницы
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // клик по конпке "Личный кабинет"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getPersonalCabinetButtonLocator());

        // ожидание загрузки страницы
        userAccountPageObject.waitTillElementIsVisible(userAccountPageObject.getAccountLabelLocator());

        // проверка правильного имени пользователя в профиле
        assertEquals("Имя пользователя не соответствует ожидаемому", userName,
                userAccountPageObject.getElementAttribute(userAccountPageObject.getUserNameTextField(), "value"));
    }

    public void signOut() {

        // ожидание загрузки страницы
        userAccountPageObject.waitTillElementIsVisible(userAccountPageObject.getAccountLabelLocator());

        // клик по кнопке "Выход"
        userAccountPageObject.clickToTheElement(userAccountPageObject.getSignOutButtonLocator());
        signInPageObject.waitTillElementIsVisible(signInPageObject.getSignInLabelLocator());
    }


    @Before
    public void createRandomUser() {
        driver = new ChromeDriver();
        userName = generateRandomName();
        email = generateRandomName() + "@test.ru";
        driver.get("https://stellarburgers.nomoreparties.site/register");

        signUpPageObject = new SignUpPage(driver);

        // создаем случайного тест юзера
        signUpPageObject.insertTextIntoField(signUpPageObject.getNameTextFieldLocator(), userName);
        signUpPageObject.insertTextIntoField(signUpPageObject.getEmailTextFieldLocator(), email);
        signUpPageObject.insertTextIntoField(signUpPageObject.getPasswordTextFieldLocator(), password);
        signUpPageObject.clickToTheElement(signUpPageObject.getRegistrationButtonLocator());
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
        assertCorrectLogin();

        // выход из аккаунта
        signOut();

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
        assertCorrectLogin();

        // выход из аккаунта
        signOut();
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
        assertCorrectLogin();

        // выход из аккаунта
        signOut();

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
        assertCorrectLogin();

        // выход из аккаунта
        signOut();
    }

    @Test
    @DisplayName("проверка перехода на страницу конструктора при нажатии на логотип в личном кабинете")
    public void transferFromUserAccountPageToBurgerConstructor() {
        driver.get("https://stellarburgers.nomoreparties.site/login");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);
        signInPageObject = new SignInPage(driver);
        userAccountPageObject = new UserAccountPage(driver);

        signInPageObject.logIn(email, password);

        // ожидание загрузки главной страницы
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // клик по конпке "Личный кабинет"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getPersonalCabinetButtonLocator());

        // ожидание загрузки страницы
        userAccountPageObject.waitTillElementIsVisible(userAccountPageObject.getAccountLabelLocator());

        // нажатие на логотип Stellar Burgers
        userAccountPageObject.clickToTheElement(userAccountPageObject.getStellarBurgersLogoLocator());

        // ожидание загрузки страницы
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // проверка
        assertEquals("Не удалось перейти на страницу конструктора", true, burgerConstructorPageObject.isElementDisplayed(burgerConstructorPageObject.getCreateBurgerLabelLocator()));

        // переход в личный кабинет для логаута
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getPersonalCabinetButtonLocator());

        // выход из аккаунта
        signOut();

    }

    @Test
    @DisplayName("проверка корректного логаута из личного кабинета")
    public void correctSignOut() {
        driver.get("https://stellarburgers.nomoreparties.site/login");

        burgerConstructorPageObject = new BurgerConstructorPage(driver);
        signInPageObject = new SignInPage(driver);
        userAccountPageObject = new UserAccountPage(driver);

        signInPageObject.logIn(email, password);

        // ожидание загрузки главной страницы
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // клик по конпке "Личный кабинет"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getPersonalCabinetButtonLocator());

        // выход из аккаунта
        signOut();

        assertEquals("Не удалось разлогиниться", true, signInPageObject.isElementDisplayed(signInPageObject.getSignInLabelLocator()));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
