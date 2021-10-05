Feature:Accounts Page feature

  Background:
  Given user has already logged into application
    |username            |password      |
    |sriyazu584@gmail.com|Development#10|

    Scenario: Accounts Page Title
      Given user is on accounts page
      When user gets title of the page
      Then page title should be "My account - My Store"

      Scenario:Accounts Page section
        Given user is on accounts page
        Then user gets account section
        |ORDER HISTORY AND DETAILS|
        |MY CREDIT SLIPS          |
        |MY ADDRESSES             |
        |MY PERSONAL INFORMATION  |
        |MY WISHLISTS             |
        |Home                     |
        And accounts section should be 6
