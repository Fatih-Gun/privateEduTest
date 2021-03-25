@apiUserCreate
  Feature: user and roles create

    Scenario Outline: Superadmin should be able to create users and roles
      Given Superadmin send post request for users and "<roles>"
      Then verify with status code "<roles>"

      Examples:
      |users         |roles         |
      |Superadmin    |SUPER_ADMIN   |
      |Moderator     |MODERATOR     |
      |School Admin  |SCHOOL_ADMIN  |
      |Editor        |EDITOR        |
      |Salesman      |SALESMAN      |
      |Expert        |EXPERT        |
      |Teacher       |TEACHER       |
      |Student       |STUDENT       |
