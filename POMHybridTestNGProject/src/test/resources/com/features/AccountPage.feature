#Account Page feature
@All @AccountFeature
Feature: Account feature

  #Background: Open login url
  #Given open url "http://automationpractice.com/"
  Background: 
    Given User is signed in with valid credentials
      | userId       | password |
      | demo@gkm.com | abc123   |

  @account
  Scenario: Account page title
    Given user is on account page
    When user gets the title of account page
    Then account page title should be "My account - My Store"

  @account @critical
  Scenario: Personal informtion and order details
    Given user is on account page
    When user gets the details
    Then following details are displayed
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |

  Scenario: Shopping cart is empty

  Scenario: Shopping cart is not empty
