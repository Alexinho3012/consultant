package ru.alexinho;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.alexinho.configuration.ConfigProperties;
import ru.alexinho.pageobject.PageAuth;

import static com.codeborne.selenide.Selenide.*;

public class MainTest {

    PageAuth pageAuth = new PageAuth();

    @BeforeClass
    public void setUp(){
        open("https://login.consultant.ru/");
    }

    @AfterClass
    public void tearDown(){
        clearBrowserCookies();
        closeWebDriver();
    }

    @Test
    public void testConsultant(){
        pageAuth.setLogin(ConfigProperties.getProperty("login"));
        pageAuth.setPassword(ConfigProperties.getProperty("password"));
        pageAuth.clickButtonLogin();
        pageAuth.checkAllertAfterInvalidPassword();
    }
}
