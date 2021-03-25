@weblogin
  Feature: Login

    @LoginUI
    Scenario Outline: User should login with valid credentials
      Given navigate login page
      When enter "<role>" credentials
      And click the login button
      Then should see the "<user role and name>"
      And click the sign out button
      Then should see home page

Examples:
      |role            |user role and name|
      |superadmin      |Super Admin       |
      |moderator       |Moderator         |
#      |editor          |Editor            |
#      |teacher         |Teacher           |
#      |student         |Student           |
#      |salesman        |Salesman          |
#      |schooladmin     |School Admin      |
#      |expert          |Expert            |


