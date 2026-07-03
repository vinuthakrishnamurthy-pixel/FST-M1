@activity4
Feature: Login Test
  
  Scenario: Testing Login without Examples
    Given user is on the login page
    When  user enters "admin" and "password"
    And   click the submit button
    Then  get confirmation text and verify message as "Welcome Back, Admin!"
    