package com.UI_Test.page;


import com.UI_Test.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditorsPage {

    WebDriver driver= Driver.get();

    public void Editors(){
        PageFactory.initElements(driver,this);
    }



}
