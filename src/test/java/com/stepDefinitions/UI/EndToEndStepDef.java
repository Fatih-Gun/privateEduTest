package com.stepDefinitions.UI;


import com.UI_Test.page.EndToEndPage;
import io.cucumber.java.en.*;

public class EndToEndStepDef {

    EndToEndPage endToEndPage=new EndToEndPage();


    @Given("login as a superadmin")
    public void login_as_a_superadmin() {
       endToEndPage.LoginAsSuperAdmin();
    }

    @When("create a moderator and verify created moderator")
    public void createAModeratorAndVerifyCreatedModerator() {
        endToEndPage.createModerator();
        endToEndPage.verifyCreatedModerator();
    }

    @And("create an editor and verify created editor")
    public void createAnEditorAndVerifyCreatedEditor() {
        endToEndPage.createEditor();
        endToEndPage.verifyCreatedEditor();
    }

    @And("create a teacher and verify created teacher")
    public void createATeacherAndVerifyCreatedTeacher() {
        endToEndPage.createTeacher();
        endToEndPage.verifyCreatedTeacher();

    }
    @And("create a salesman and verify created salesman")
    public void createASalesmanAndVerifyCreatedSalesman() {
        endToEndPage.createSalesman();
        endToEndPage.verifyCreatedSalesman();

    }

    @And("create a schoolAdmin and verify schoolAdmin")
    public void createASchoolAdminAndVerifySchoolAdmin() {
        endToEndPage.createSchoolAdmin();
        endToEndPage.verifyCreatedSchoolAdmin();
    }

    @Given("login as a moderator")
    public void login_as_a_moderator() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("create an exam type and verify created exam type")
    public void create_an_exam_type_and_verify_created_exam_type() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("create a subject and verify created subject")
    public void create_a_subject_and_verify_created_subject() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("create a section and verify created section")
    public void create_a_section_and_verify_created_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("create a topic and verify created topic")
    public void create_a_topic_and_verify_created_topic() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }



}
