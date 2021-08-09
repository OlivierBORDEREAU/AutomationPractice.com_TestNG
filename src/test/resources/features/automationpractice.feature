Feature: Login Feature
  Verify if user is able to Login in to the site

Scenario: An already registered user cannot create a new account with the same e-mail
    Given user is on homepage
    When an already known user navigates to Login Page
    And enters an already used email
    Then the error message "An account using this email address has already been registered. Please enter a valid password or request a new one." appears because the account already exists

Scenario: e-mail address matches on account creation page
    Given user is on homepage
    When a new user navigates to Login Page
    And enters his e-mail
    Then user is sent to the account creation page
    And the e-mail matches
  
Scenario: Login as a authenticated user
    Given user is on homepage
    When an already known user navigates to Login Page
    And user enters email and Password
    Then success message "Welcome to your account. Here you can manage all of your personal information and orders." is displayed
    
