package ru.alexinho.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageAuth {

    private static final Logger log = LogManager.getRootLogger();

    public SelenideElement login = $(By.cssSelector("#loginform-login"));
    public SelenideElement password = $(By.cssSelector("#loginform-password"));
    public SelenideElement buttonLogin = $(By.cssSelector("#buttonLogin"));
    public SelenideElement allertAfterInvalidPassword = $(By.xpath("//p[starts-with(text(), 'Неверно указаны данные для входа в')]"));

    public void setLogin(String login){
        log.info("Вводим логин");
        this.login.shouldBe(Condition.enabled).sendKeys(login);
        log.info("Логин " + login + " введен");
    }

    public void setPassword(String password){
        log.info("Вводим пароль");
        this.password.shouldBe(Condition.enabled).sendKeys(password);
        log.info("Пароль " + password + " введен");
    }

    public void clickButtonLogin(){
        log.info("Нажимаем кнопку Войти");
        buttonLogin.shouldBe(Condition.enabled).click();
    }

    public void checkAllertAfterInvalidPassword(){
        log.info("Проверяем наличие текста \"Неверно указаны данные для входа в систему.\"");
        allertAfterInvalidPassword.shouldBe(Condition.enabled);
    }

}

