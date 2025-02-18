Feature: Switching windows

  Scenario: Switching tabs and windows
    Given I visit web "https://demoqa.com/browser-windows"
    When I switch open new window
    Then I should get "This is a sample page"