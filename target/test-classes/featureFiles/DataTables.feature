Feature: Verify login functionality using Datatables
	
	@Smoke
  Scenario: Verify Login Page with valid credentials
    Given User navigate to the URL
    | https://www.saucedemo.com |
    When User sign in to the application
    | standard_user | secret_sauce |  
    Then User should login successfully
    And User validate the home page
    | Swag Labs |
    When User logout from the application
