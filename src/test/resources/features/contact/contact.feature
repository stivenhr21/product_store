#language: en
#autor: Stiven Hernandez Ramirez

Feature: Product Store web site - Contact
  As a product store user,
  I want to send messages through the contact form
  to express my opinion or seek help

  @SendMessage
  Scenario Outline: Sending a message through the contact form
    Given that the user is on the login page
    When The user fills out the contact form
      | email   | name   | message   |
      | <email> | <name> | <message> |
    Then The user will see a thank you message
    Examples:
      | email                | name   | message                          |
      | stivenhr21@gmail.com | stiven | Esto es una prueba automatizada. |