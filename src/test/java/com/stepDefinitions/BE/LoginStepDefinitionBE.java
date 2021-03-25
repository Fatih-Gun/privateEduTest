package com.stepDefinitions.BE;

import com.BE_Test.page.LoginBEiam;
import io.cucumber.java.en.*;

public class LoginStepDefinitionBE {



    LoginBEiam loginBE=new LoginBEiam();




    @Given("user attemp to login with {string} and verify user {string}")
    public void user_attemp_to_login_with_and_verify_user(String role, String roles) {
       loginBE.loginWithRoles(role,roles);
    }



}
