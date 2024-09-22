package com.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FF_signIn_PageFactory extends TestBase{

    public FF_signIn_PageFactory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "emailId")
    WebElement userName_L;
    @FindBy(xpath = "//input[@placeholder=\"Enter your Password\"]")
    WebElement password_L;
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInButton_L;
    @FindBy(xpath = "//img[@src=\"/static/media/fireFlinkPlatform.170adc43.svg\"]")
    WebElement FFPlatForm_L;
    @FindBy(xpath = "//button[text()='+ Project']")
    WebElement PlusProject_L;
    @FindBy(xpath = "//a[text()=\"Users\"]")
    WebElement users_L;

    public WebElement userName(){
        return userName_L;
    }
    public WebElement password(){
        return password_L;
    }
    public WebElement signInButton(){
        return signInButton_L;
    }
    public WebElement FFPlatForm(){
        return FFPlatForm_L;
    }
    public WebElement plusProject(){
        return PlusProject_L;
    }
    public WebElement users(){
        return users_L;
    }
}
