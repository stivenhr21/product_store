#language: en
#autor: Stiven Hernandez Ramirez

Feature: Product Store web site - Login
  I as a Product Store user
  want to interact with the login functionality
  to validate its correct operation

  @LoginValidUser
  Scenario Outline: Log in successfully with a valid user
    Given that the user is on the login page
    When The user fills in his credentials
      | user   | password   |
      | <user> | <password> |
    Then The user will be logged into the website.
    Examples:
      | user                     | password |
      | stivenhr21TestAutomation | 123      |



