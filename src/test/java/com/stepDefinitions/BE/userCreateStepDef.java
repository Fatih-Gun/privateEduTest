package com.stepDefinitions.BE;

import com.BE_Test.page.UserCreateIAM;
import io.cucumber.java.en.*;

public class userCreateStepDef {
//    UserCreateBEiam create = new UserCreateBEiam();
    UserCreateIAM create =new UserCreateIAM();

    @Given("Superadmin send post request for users and {string}")
    public void superadmin_send_post_request_for_users_and(String role) {
       create.createNewUser(role);
    }

    @Then("verify with status code {string}")
    public void verify_with_status_code(String role) {
        create.roleVerify(role);
    }

}
