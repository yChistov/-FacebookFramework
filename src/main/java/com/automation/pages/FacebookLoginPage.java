package com.automation.pages;

import com.automation.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BasePage{

    public static final String PAGE_TITLE = "Facebook.";
    public static final String PAGE_URL = "https://www.facebook.com/login.php";

    @FindBy(css = "._1tp8>a") WebElement error;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkError(String text){
        try {
            return error.getText().equals(text);
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
