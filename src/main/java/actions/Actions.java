package actions;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pages.BurgerConstructorPage;
import pages.SignInPage;
import pages.SignUpPage;
import pages.UserAccountPage;

public class Actions {

    @Step("Генерация случайного имени пользователя")
    public String generateRandomName() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    @Step("Генерация создание пользователя")
    public void generateRandomUser (WebDriver driver, String userName, String email, String password) {
        SignUpPage signUpPageObject = new SignUpPage(driver);

        signUpPageObject.insertTextIntoField(signUpPageObject.getNameTextFieldLocator(), userName);
        signUpPageObject.insertTextIntoField(signUpPageObject.getEmailTextFieldLocator(), email);
        signUpPageObject.insertTextIntoField(signUpPageObject.getPasswordTextFieldLocator(), password);
        signUpPageObject.clickToTheElement(signUpPageObject.getRegistrationButtonLocator());
    }

    @Step("Разлогирование")
    public void signOut(WebDriver driver) {
        UserAccountPage userAccountPageObject = new UserAccountPage(driver);
        SignInPage signInPageObject = new SignInPage(driver);

        // ожидание загрузки страницы
        userAccountPageObject.waitTillElementIsVisible(userAccountPageObject.getAccountLabelLocator());

        // клик по кнопке "Выход"
        userAccountPageObject.clickToTheElement(userAccountPageObject.getSignOutButtonLocator());
        signInPageObject.waitTillElementIsVisible(signInPageObject.getSignInLabelLocator());
    }

    @Step("Получение userName залогированного пользователя")
    public String getUserNameAfterLogin(WebDriver driver) {
        BurgerConstructorPage burgerConstructorPageObject = new BurgerConstructorPage(driver);
        UserAccountPage userAccountPageObject = new UserAccountPage(driver);


        // ожидание загрузки главной страницы
        burgerConstructorPageObject.waitTillElementIsVisible(burgerConstructorPageObject.getCreateBurgerLabelLocator());

        // клик по конпке "Личный кабинет"
        burgerConstructorPageObject.clickToTheElement(burgerConstructorPageObject.getPersonalCabinetButtonLocator());

        // ожидание загрузки страницы
        userAccountPageObject.waitTillElementIsVisible(userAccountPageObject.getAccountLabelLocator());

        return userAccountPageObject.getElementAttribute(userAccountPageObject.getUserNameTextField(), "value");
    }
}
