import actions.Actions;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class UserAccountTest {

    WebDriver driver;

    String userName;
    String email;
    String password = "123456";

    Actions actions = new Actions();
    SignUpPage signUpPageObject;
    BurgerConstructorPage burgerConstructorPageObject;
    SignInPage signInPageObject;
    UserAccountPage userAccountPageObject;

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
    @DisplayName("проверка перехода на страницу конструктора при нажатии на логотип в личном кабинете")
    public void transferFromUserAccountPageToBurgerConstructor() {
        boolean testResult;
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

        testResult = burgerConstructorPageObject.isElementDisplayed(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // переход в личный кабинет для логаута
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getPersonalCabinetButtonLocator());

        // выход из аккаунта
        actions.signOut(driver);

        // проверка
        assertEquals("Не удалось перейти на страницу конструктора", true, testResult);
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
        actions.signOut(driver);

        assertEquals("Не удалось разлогиниться", true, signInPageObject.isElementDisplayed(signInPageObject.getSignInLabelLocator()));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
