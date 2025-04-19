Feature: Login Page Validation

  Background: 
    Given Acces the application

#Version 1.0
#Updated on: 19th Apr 2025
#Change: Testdata updated in the Examples
  @loginpage
  Scenario Outline: Login Page Testing with multiple Valid Data
    When Login with username "<username>" and password "<password>" to an app
    Then Home page gets be displayed

    Examples: 
      | username           | password    |
      | ramsethu@gmail.com | ramsethu123 |

  @webtable
  Scenario Outline: Verify products to validate webtable
    When Login with username "<username>" and password "<password>" to an app
    And User navigated to "Products" page
    Then Verified all the products in the landing page

    Examples: 
      | username           | password    |
      | ramsethu@gmail.com | ramsethu123 |

  @brokenlinks
  Scenario Outline: Verify products to validate webtable
    When Login with username "<username>" and password "<password>" to an app
    And User navigated to "Products" page
    Then Verified all the products in the landing page

    Examples: 
      | username           | password    |
      | ramsethu@gmail.com | ramsethu123 |
