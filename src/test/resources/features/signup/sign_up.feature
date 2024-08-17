#language: en
#autor: Stiven Hernandez Ramirez

Feature: Product Store web site - User sign up
  I as a product store customer
  I want to register on the website
  To make online purchases

  @UserSignUp
  Scenario Outline: User registration successful
    Given that the user is on the login page
    When The user fills out the registration form
      | user   | password   |
      | <user> | <password> |
    Then The user will see a successful registration alert
    Examples:
      | user                 | password |
      | stivenAutomation2024 | 123      |

  @validateMessageEnterUsernameAndPassword
  Scenario Outline: validate presence of message enter username and password
    Given that the user is on the login page
    When The user fills out the registration form
      | user   | password   |
      | <user> | <password> |
    Then An alert will be displayed enter the username and password
    Examples:
      | user                     | password |
      | stivenhr21TestAutomation |          |

  @ExistingUserRegistration
  Scenario Outline: Existing user registration
    Given that the user is on the login page
    When The user fills out the registration form
      | user   | password   |
      | <user> | <password> |
    Then The user will see an existing user alert
    Examples:
      | user                 | password |
      | stivenAutomation2024 | 123      |