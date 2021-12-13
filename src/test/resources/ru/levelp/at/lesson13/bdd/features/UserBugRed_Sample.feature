Feature: Login to UserBugRed system

  Scenario: Login as user to system
    Given I open Login Register page
    When I login with credentials 'test_user11@mail.com:12345678' in Login section on Login-Register page
    Then profile button should contain 'test_user11' on Main page
