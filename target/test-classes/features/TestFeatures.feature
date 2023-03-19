Feature: Cumulative test

  @success_scenarios
  Scenario Outline: Test User Login with valid credentials
    Given Launch actitime Login page
    When Input '<user>' and '<password>'
    And Click on login button
    Then User is logged in
    Examples:
      | user  | password |
      | admin | manager  |

  @fail_scenarios
  Scenario Outline: Test User Login invalid credentials
    Given Launch actitime Login page
    When Input '<user>' and '<password>'
    And Click on login button
    Then User is not logged in
    Examples:
      | user  | password |
      | admin | managers |


  @success_scenarios
  Scenario Outline: Create new user
    Given Navigate to user panel
    When Click on new user button
    And Fill the mandatory fields '<firstname>' , '<lastname>' ,'<email>'
    And Save and send invitation
    Then Validate that new user created successfully
    Examples:
      | firstname | lastname | email              |
      | Oliver    | Jake     | ict18807@sjp.ac.lk |


  @success_scenarios
  Scenario Outline: Logout from account
    Given Click on logout button
    Then User is logged out and on '<page>' page
    Examples:
      | page  |
      | Login |
