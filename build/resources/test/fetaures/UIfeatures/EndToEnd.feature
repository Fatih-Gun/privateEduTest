# End to End

@webEndToEnd

Feature: End to End test for question

  @rolesCreate
  Scenario: SuperAdmin should be able to create moderator and editor roles
    Given login as a superadmin
    When create a moderator and verify created moderator
    And create an editor and verify created editor
    And create a teacher and verify created teacher
    And create a salesman and verify created salesman
    And create a schoolAdmin and verify schoolAdmin



  Scenario: Moderator should be able to create exam type, subject and topic
    Given login as a moderator
    When create an exam type and verify created exam type
    And create a subject and verify created subject
    And create a section and verify created section
    And create a topic and verify created topic


