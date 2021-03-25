package com.stepDefinitions.BE;

import com.BE_Test.page.RegisterBEiam;
import io.cucumber.java.en.*;

public class RegisterStepDef {


    RegisterBEiam registerBEiam=new RegisterBEiam();



    @Given("student send post request with valid body and verify with status code")
    public void student_send_post_request_with_valid_body_and_verify_with_status_code() {

        registerBEiam.register();
    }

}
