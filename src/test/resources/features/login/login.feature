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
    Then The user will be logged into the website
    Examples:
      | user                     | password |
      | stivenhr21TestAutomation | 123      |

  @validateMessageEnterUsernameAndPassword
  Scenario Outline: validate presence of message enter username and password
    Given that the user is on the login page
    When The user fills in his credentials
      | user   | password   |
      | <user> | <password> |
    Then The user will see an alert enter the username and password
    Examples:
      | user                     | password |
      | stivenhr21TestAutomation |          |

  @validateMessageUserDoesNoExist
  Scenario Outline: validate presence of message user does no exist
    Given that the user is on the login page
    When The user fills in his credentials
      | user   | password   |
      | <user> | <password> |
    Then The user will see an alert user does no exist
    Examples:
      | user                       | password |
      | stivenhr21TestAutomationxx | 123      |