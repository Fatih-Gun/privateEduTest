@apiUserController
  Feature: user and roles create

    @userCreate
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

#      @userSearchAll
#      Scenario Outline: Superadmin should be able to search all users
#        Given search by "<userrole>" and first <pagesize> users
#        Then verify with status code 200
#
#        Examples:
#        |pagesize|userrole  |
#        |100     |superadmin|
#        |50      |moderator |
      @searchAllUsers
      Scenario Outline: Superadmin should be able to search all users
        Given search by "<userrole>" and first <PAGESIZE> users
        Then verify with status code 200

        Examples:
        |userrole   |PAGESIZE|
        |SUPER_ADMIN|100     |
        |MODERATOR  |50      |
        |EDITOR     |150     |
        |TEACHER    |30      |
        |SALESMAN   |20      |
        |SCHOOL_ADMIN  |40   |
        |EXPERT     |50      |
        |STUDENT    |500     |

        @searchUsersById
        Scenario: Superadmin should be able to search by user id
          Given search by given 100
          Then verify with status code 200
#          Then verify match the "role"
