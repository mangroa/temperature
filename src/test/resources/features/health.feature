Feature: The health can be retrieved


  Scenario: Client makes call to check the health of the application
    When the client checks the health of the application
    Then the application is up