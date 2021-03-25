@api
Feature: Login


  @loginApi
 Scenario Outline:users should be able to login based on the role
   Given user attemp to login with "<role>" and verify user "<roles>"


   Examples:
     |role            |roles             |
     |superadmin      |SUPER_ADMIN      |
     |moderator       |MODERATOR         |
      |editor          |EDITOR            |
      |teacher         |TEACHER           |
      |student         |STUDENT           |
      |salesman        |SALESMAN          |
      |schooladmin     |SCHOOL_ADMIN      |
      |expert          |EXPERT            |
