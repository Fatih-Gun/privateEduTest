package com.stepDefinitions.BE;

import com.BE_Test.page.UserController;
import io.cucumber.java.en.*;

public class userControllerStepDef {
//    UserCreateBEiam create = new UserCreateBEiam();
    UserController create =new UserController();

    @Given("Superadmin send post request for users and {string}")
    public void superadmin_send_post_request_for_users_and(String role) {
       create.createNewUser(role);
    }

    @Then("verify with status code {string}")
    public void verify_with_status_code(String role) {
        create.roleVerify(role);
    }


    @Then("verify with status code {int}")
    public void verifyWithStatusCode(int statuscode) {
        create.searchByIdVerify(statuscode);
        
    }

    @Given("search by {string} and first {int} users")
    public void searchByAndFirstUsers(String userrole, int pagesize) {
        create.searchUsersAll(pagesize,userrole);
    }

    @Given("search by given {int}")
    public void searchByGiven(int id) {
        create.searchUsersById(id);
    }

    @Then("verify match the {string}")
    public void verifyMatchThe(String role) {

    }
}
