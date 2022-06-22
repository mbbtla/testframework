Feature: Login tests
  As user of GitHub, I can login to GitHub.com

  Background: Home page of GitHub.com
    Given GitHub Home page without authorizations
    Given GitHub Login form in login page

#  @DataTableHeaders
#  Scenario: Login to GitHub.com using valid account
#    Given GitHub Login page is displayed
#    When Input GitHub credentials to login with headers table
#    | Email             | Password     |
#    | mbbtla@email.com    | tlasupport123 |
#    And Click signin button

  @SimplyDataTable
  Scenario: Login to GitHub.com using valid account using spreadsheet
    Given GitHub Login page is displayed
    When Input GitHub credentials to login using spreadsheet
    And Click signin button