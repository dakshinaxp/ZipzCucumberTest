Feature: Signup new user registration in native app

  Scenario: Customer sign up page in android emulator
    Given step up maven dependency for netive app
    When getting current app active page name
    And Enter valid zipcode
    And click on Go button
    And Select Sign in option in menu bar
    And Checking the current app page
    And Click thr Creare an account button
    And Checking the current app page
    And populate all values in excel sheet
    And checking the validation pass or fail
    Then close the app
