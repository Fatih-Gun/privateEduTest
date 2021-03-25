@apiRegister

  Feature: Student register

    Scenario: Student should be able register succesfully
      Given student send post request with valid body and verify with status code