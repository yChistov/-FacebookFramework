package com.facebook.tests;

import com.automation.data.FacebookData;
import com.automation.pages.FacebookLoginPage;
import com.automation.pages.FacebookMainFeed;
import com.automation.pages.FacebookMainPage;
import com.automation.utilities.DriverFactory;
import com.sun.org.apache.xerces.internal.impl.PropertyManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static com.automation.utilities.DriverFactory.browserType;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    protected WebDriver driver;
    browserType type = browserType.CHROME;
    FacebookMainPage fbMainPage;
    FacebookLoginPage fbLoginPage;
    FacebookMainFeed fbMainFeed;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        String browserName = PropertyManager.getProperty("BROWSER");
        driver = new DriverFactory().getDriver(type);
        fbMainPage = PageFactory.initElements(driver, FacebookMainPage.class);
        fbLoginPage = PageFactory.initElements(driver, FacebookLoginPage.class);
        fbMainFeed = PageFactory.initElements(driver, FacebookMainFeed.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Parameters({"browserType"})
    @Test(groups = {"p1", "pageLoads"})
    public void loadPage(@Optional("Firefox") String browserType){
        System.out.println("Browser: " + browserType);
        fbMainPage.loadPage();
    }

    @Test(groups = {"p2", "field"}, dependsOnMethods = "loadPage")
    public void fillMail(){
        String email = "misteriys@ukr.net";
        fbMainPage.setTextEmail(email);
    }

    @Test(groups = {"p2", "field"}, dependsOnMethods = "fillMail")
    public void fillPass(){
        String pass = "ghjuhfvvbcn";
        fbMainPage.setTextPass(pass);
    }

    @Test(groups = {"p1"}, dataProviderClass = FacebookData.class, dataProvider = "login")
    public void loginMainPage(String email, String pass, String result){
        driver.manage().deleteAllCookies();

        System.out.println("loadPage loginMain");
        fbMainPage.loadPage();
        fbMainPage.login(email, pass);
        System.out.println("loaded the page. LoginMain");
        // Verify what to test based on data passed in
        if (!StringUtils.isBlank(result)){
            boolean resultError = fbLoginPage.checkError(result);
            assertTrue(resultError, "Expected error: " + result);
        }else {
            assertTrue(!fbMainFeed.getUserName().isEmpty());
        }
    }
}
