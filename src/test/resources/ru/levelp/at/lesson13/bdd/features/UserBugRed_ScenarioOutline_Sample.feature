Feature: Login to UserBugRed system

  Scenario Outline: Register as user to system
    Given I open Login Register page
    When I register user in Registration section on Login-Register page with credentials
      | username | <username> |
      | email    | <email>    |
      | password | <password> |
    Then profile button should contain '<username>' on Main page

    Examples:
      | username    | email                | password |
      | test_user12 | test_user12@mail.com | 12345678 |
      | test_user13 | test_user13@mail.com | 12345678 |
      | test_user14 | test_user14@mail.com | 12345678 |
      | test_user15 | test_user15@mail.com | 12345678 |

  Scenario Outline: Register as user to system with dynamic creds
    Given I open Login Register page
    When I register user in Registration section on Login-Register page with dynamic credentials
      | username | <username> |
      | email    | <email>    |
      | password | <password> |
    Then profile button should contain '<username>' on Main page

    Examples:
      | username   | email   | password   |
      | {username} | {email} | {password} |
      | {username} | {email} | {password} |
      | {username} | {email} | {password} |
      | {username} | {email} | {password} |
