package com.automation.data;

import org.testng.annotations.DataProvider;

public class FacebookData {

    @DataProvider(name = "pages")
    public static Object[][] pages(){
        return new Object[][]{
                {"https://www.facebook.com/",
                        "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей."},
                {"https://www.google.com.ua/", "Google"}
        };
    }

    @DataProvider(name = "login")
    public static Object[][] login(){
        return new Object[][] {
                {"misteriys@ukr.net", "ghjuhfvvbcn", null},
                {"", "ghjuhfvvbcn", "Зарегистрируйте аккаунт."}
        };
    }
}
