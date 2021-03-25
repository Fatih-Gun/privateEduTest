$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/fetaures/UIfeatures/EndToEnd.feature");
formatter.feature({
  "name": "End to End test for question",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@webEndToEnd"
    }
  ]
});
formatter.scenario({
  "name": "SuperAdmin should be able to create moderator and editor roles",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@webEndToEnd"
    },
    {
      "name": "@rolesCreate"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "login as a superadmin",
  "keyword": "Given "
});
formatter.match({
  "location": "EndToEndStepDef.login_as_a_superadmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "create a teacher and verify created teacher",
  "keyword": "And "
});
formatter.match({
  "location": "EndToEndStepDef.createATeacherAndVerifyCreatedTeacher()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "create a salesman and verify created salesman",
  "keyword": "And "
});
formatter.match({
  "location": "EndToEndStepDef.createASalesmanAndVerifyCreatedSalesman()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "create a schoolAdmin and verify schoolAdmin",
  "keyword": "And "
});
formatter.match({
  "location": "EndToEndStepDef.createASchoolAdminAndVerifySchoolAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});