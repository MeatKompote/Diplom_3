package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    // конструктор
    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    // ______________________ Прокрутка вниз до элемента ___________________
    @Step("Прокрутка вниз до элемента")
    public void scrollDownToTheElement(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //___________________ Нажатие на элемент ____________________
    @Step("Нажатие на элемент")
    public void clickToTheElement(By elementLocator) {
        driver.findElement(elementLocator).click();
    }

    //___________________ Ожидание прогрузки элемента ___________
    @Step("Ожидание прогрузки элемента")
    public void waitTillElementIsVisible (By elementLocator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    //___________________ Получение текста элемента ________________
    @Step("Получение текста элемента")
    public String getTextFromElement(By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }

    //___________________ Вставить тескт в поле ________________
    @Step("Вставить тескт в поле")
    public void insertTextIntoField(By elementLocator, String newText) {
        driver.findElement(elementLocator).clear();
        driver.findElement(elementLocator).sendKeys(newText);
    }

    @Step("Получение аттрибута элемента")
    public String getElementAttribute(By elementLocator, String attribute) {
        return driver.findElement(elementLocator).getAttribute(attribute);
    }

    @Step("Проверка видимости элемента")
    public boolean isElementDisplayed (By elementLocator) {
        return driver.findElement(elementLocator).isDisplayed();
    }

}
