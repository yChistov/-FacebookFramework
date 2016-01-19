package com.automation.pages;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookMainPage extends BasePage {

    @FindBy(css = "#email") WebElement fEmail;
    @FindBy(css = "#pass") WebElement fPass;

    @FindBy(css = "#loginbutton") WebElement fButton;
    @FindBy(css = "#u_0_1") WebElement fName;
    @FindBy(css = "#u_0_3") WebElement fLastName;
    @FindBy(css = "#u_0_5") WebElement fRegEmail;
    @FindBy(css = "#u_0_8") WebElement fRepeatRegEmail;
    @FindBy(css = "#u_0_a") WebElement fRegPass;

    @FindBy(css = "#day") WebElement fDay;
    @FindBy(css = "#month") WebElement fMonth;
    @FindBy(css = "#year") WebElement fYear;

    @FindBy(css = "#u_0_d") WebElement fFemale;
    @FindBy(css = "#u_0_e") WebElement fMale;

    @FindBy(css = "#u_0_i") WebElement fReg;

    public FacebookMainPage(WebDriver driver){
        super(driver);
        this.PAGE_TITLE = "Добро пожаловать на Фейсбук - заходите, регистрируйтесь и находите друзей.";
        this.PAGE_URL = "https://www.facebook.com/";
    }

    public void login(String email, String pass){
        wait.until(ExpectedConditions.elementToBeClickable(fEmail));
        setTextEmail(email);
        setTextPass(pass);
        clickButton();
    }
    public void setTextEmail(String text){
        setElementText(fEmail, text);
    }
    public void setTextPass(String text){
        setElementText(fPass, text);
    }
    public void clickButton(){
        clickElement(fButton);
    }
    public void setTextName(String text){
        setElementText(fName, text);
    }
    public void setTextLastName(String text){
        setElementText(fLastName, text);
    }
    public void setTextRegEmail(String text){
        setElementText(fRegEmail, text);
    }
    public void setTextRepeatRegEmail(String text){
        setElementText(fRepeatRegEmail, text);
    }
    public void setTextRegPass(String text){
        setElementText(fRegPass, text);
    }
    public void selectDay(String value){
        selectDropdown(fDay, value);
    }
    public void selectMonth(String value){
        selectDropdown(fMonth, value);
    }
    public void selectYear(String value){
        selectDropdown(fYear, value);
    }
    public void selectFemale(){
        fFemale.click();
    }
    public void selectMale(){
        clickElement(fMale);
    }
    public void selectReg(){
        clickElement(fReg);
    }

}
