#Author: gkm010@gmail.com
#Imdb Search feature
#Tags- @AllScenario, @FailureScenario, @SearchScenario
@AllScenario
Feature: Search imdb
  
  Search for following content in imdb search box:
  1.Titles
  2.TV Episodes
  3.Celebs
  4.Companies
  5.Keywords

  Background: 
    Given imdb website is opened
    And search box is present

  @FailureScenario @Regression
  Scenario: Search for invalid keywords
    When User chooses "Titles"
    And Types following keywords:
      | "HJASGw6e732"   |
      | "dfkjbhg8r47yt" |
      | "%$^(*&"        |
    And click on search
    Then Error message is displayed

  @SearchScenario @Smoke
  Scenario: Search for valid keywords
    When User chooses "Celebs"
    And Types following keywords:
      | "Vidyul Jammwal" |
      | "Selena Gomez"   |
      | "Terry Watson"   |
    And click on search
    Then results are displayed
