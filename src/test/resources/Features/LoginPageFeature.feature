#dharma br code - revert this code
Feature: Login Page Validation

Background: 
Given Open a browser to access the application

  Scenario: Login Page Testing with Valid Data
    Given Open the Application
    When Login with username "dharma" and password "interOP@123"
    Then Home page will be displayed

  Scenario Outline: Login Page Testing with multiple Valid Data
    Given Open the Application
    When Login with username "<username>" and password "<password>" with valid data
    Then Home page will be displayed

    Examples: 
      | username | password   |
      | pramee   | pramee@123 |
      | aadya    | aadya@123  |

  Scenario: Login Page Testing with multiple datatable data
    Given Open the Application
    When Login with username and password
      | username | password   |
      | pramee   | pramee@123 |
      | aadya    | aadya@123  |
      | jhanu    | jhanu@123  |
    Then Home page will be displayed
    
    Scenario: Login Page Testing with multiple datatable data
    Given Open the Application
    When Login with username and password wo headers
      | pramee   | pramee@123 |
      | aadya    | aadya@123  |
      | jhanu    | jhanu@123  |
    Then Home page will be displayed
