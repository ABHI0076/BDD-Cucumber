
Feature: Verify login functionality
	
	@Regression
  Scenario Outline: Verify Login Page with valid credentials
    Given User navigate to the URL using prop file
    When User submit the "<UserName>" and "<Password>"
    Then User should login successfully
    And User validate the home page "<PageTitle>"
    When User logout from the application
    
    Examples: 
      | UserName  | Password | PageTitle  |
      | standard_user | secret_sauce | Swag Labs |
      | locked_out_user | secret_sauce | Swag Labs |
      | problem_user | secret_sauce | Swag Labs |
      | performance_glitch_user | secret_sauce | Swag Labs |
      | error_user | secret_sauce | Swag Labs |
      | visual_user | secret_sauce | Swag Labs |

