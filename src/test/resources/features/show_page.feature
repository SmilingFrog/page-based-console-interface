Feature: Show page

Scenario: Create and show page

Given I have a page created
When I give the browser the page address and such page does exist  
Then The page is displayed

#Scenario: Wrong page address is given to the browser

#Given I have a page created
#When I give the browser a wrong page address 
#Then error page is displayed