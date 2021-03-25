package com.UI_Test.page;

import com.UI_Test.utilities.BrowserUtils;
import com.UI_Test.utilities.ConfigurationReader;
import com.UI_Test.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver= Driver.get();


    public Login(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class=\"css-calkr4\"]/div/div[1]")
    public WebElement userRoleText;

    @FindBy(xpath = "//span[contains(text(),'Sign out')]")
    public WebElement signOutButton;

    @FindBy(xpath = "//span[text()=\"home\"]")
    public WebElement signOutVerificationText;

    @FindBy(xpath = "//span[text()=\"Sign-in\"]")
    public WebElement signInButton;



    public static void main(String[] args) {
        System.out.println("Work");
    }



    public void navigateLoginPage(){
        BrowserUtils.waitFor(2);
        signInButton.click();
    }

    public void enterCredentials(String role){
        String username="";
        String password=ConfigurationReader.get("commonPassword");

        if (role.equalsIgnoreCase("superadmin")){
            username= ConfigurationReader.get("superAdminEmail");
        }else if(role.equalsIgnoreCase("moderator")){
            username=ConfigurationReader.get("moderatorEmail");

        }else if (role.equalsIgnoreCase("editor")){
            username= ConfigurationReader.get("editorEmail");
        }else if (role.equalsIgnoreCase("teacher")){
            username= ConfigurationReader.get("teacherEmail");
        }else if (role.equalsIgnoreCase("student")){
            username=ConfigurationReader.get("studentEmail");
        }else if (role.equalsIgnoreCase("salesman")){
            username=ConfigurationReader.get("salesmanEmail");
        }else if (role.equalsIgnoreCase("schooladmin")){
            username=ConfigurationReader.get("schoolAdminEmail");
        }else if (role.equalsIgnoreCase("expert")){
            username=ConfigurationReader.get("expertEmail");
        }else{
            System.out.println("Email or Password invalid");
        }
        emailInput.sendKeys(username);
//        BrowserUtils.waitFor(3);
        passwordInput.sendKeys(password);
//        BrowserUtils.waitFor(3);

    }

    public void clickLoginButton(){
            loginButton.click();
            BrowserUtils.waitFor(1);
    }

    public void verifyUserRole(String usernameText){
        String expectedText=usernameText;
        String actualText=userRoleText.getText().substring(0,userRoleText.getText().indexOf("-"));
        System.out.println("User Role: "+actualText);

        Assert.assertEquals(expectedText,actualText);
        BrowserUtils.waitFor(2);

    }

    public void clickSignoutButton(){
        signOutButton.click();
        BrowserUtils.waitFor(1);
    }

    public void signOutVerification(){
        String expectedText= "HOME";
        String actualText=signOutVerificationText.getText();
        System.out.println(actualText);

        Assert.assertEquals(expectedText,actualText);
    }


}
