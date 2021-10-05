Feature: Login Page feature
  Scenario: Login Page title
    Given user is on login page
    When user gets title of the page
    Then page title should be "Login - My Store"

    Scenario: Forgot Password Link
      Given user is on login page
      Then forgot password link should be displayed

      Scenario: Login with correct credentials
        Given user is on login page
        When user enters username "sriyazu584@gmail.com"
        And user enters password "Development#10"
        And user clicks on login button
        Then user gets title of the home page
        And page title should be "My account - My Store"