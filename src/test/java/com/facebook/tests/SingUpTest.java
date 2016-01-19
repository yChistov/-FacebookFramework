package com.facebook.tests;

import com.automation.pages.FacebookMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingUpTest {
    public WebDriver driver;
    public WebDriverWait wait;
    FacebookMainPage fbMainPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }

    @Test(groups = {"p1"})
    public void singUpMainPage() {
        driver.manage().deleteAllCookies();

        fbMainPage.loadPage();
        fbMainPage.setTextName("Tony");
        fbMainPage.setTextLastName("Fat");
        fbMainPage.setTextRegEmail("fattonny@facebook.com");
        fbMainPage.setTextRepeatRegEmail("fattonny@facebook.com");
        fbMainPage.setTextRegPass("password");

        fbMainPage.selectDay("16");
        fbMainPage.selectMonth("8");
        fbMainPage.selectYear("2016");
        fbMainPage.selectMale();
        fbMainPage.selectReg();
    }
}
