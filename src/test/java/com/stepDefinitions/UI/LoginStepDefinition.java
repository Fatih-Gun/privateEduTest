package com.stepDefinitions.UI;

import com.UI_Test.page.Login;
import io.cucumber.java.en.*;

public class LoginStepDefinition {
    //create object
//    Login login=new Login();
    Login login=new Login();


    @Given("navigate login page")
    public void navigate_login_page() {
        login.navigateLoginPage();
    }

    @When("enter {string} credentials")
    public void enter_credentials(String role) {
       login.enterCredentials(role);
    }

    @When("click the login button")
    public void click_the_login_button() {
        login.clickLoginButton();
    }

    @Then("should see the {string}")
    public void should_see_the(String role) {
      login.verifyUserRole(role);
    }

    @Then("click the sign out button")
    public void click_the_sign_out_button() {
       login.clickSignoutButton();
    }

    @Then("should see home page")
    public void should_see_home_page() {
        login.signOutVerification();
    }
//
//    @Given("navigate login page")
//    public void navigate_login_page() {
//
//        login.navigateLoginPage();
//    }
//
//    @When("enter {string} credentials")
//    public void enter_credentials(String role) {
//
//        login.enterCredentials(role);
//    }
//
//    @When("click the login button")
//    public void click_the_login_button() {
//
//        login.clickLoginButton();
//    }
//
//    @Then("should see the {string}")
//    public void should_see_the(String usernameText) {
//        login.verifyUserRole(usernameText);
//
//    }
//
//    @Then("click the sign out button")
//    public void click_the_sign_out_button()
//    {
//        login.clickSignoutButton();
//    }
//
//    @Then("should see home page")
//    public void should_see_home_page() {
//
//        login.signOutVerification();
//    }


}
