package com.automation.pages;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookMainFeed extends BasePage{

    @FindBy(css = "._2dpb") WebElement fUserName;

    public FacebookMainFeed(WebDriver driver) {
        super(driver);
    }

    public String getUserName(){
        return fUserName.getText();
    }
}
