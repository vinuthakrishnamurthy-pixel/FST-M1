@activity5
Feature: Login Test
  
  Scenario Outline: Testing Login with Example
    Given user on the login page
    When  user enter "<Usernames>" and "<Passwords>"
    And   click submit button
    Then  got confirmation text and verify message as "Invalid credentials"
    
    Examples: 
      | Usernames | Passwords      |
      | Vinutha   | password123    |
      | Suraj     | wrongPassword  |
      | Aprameya  | Password       | 