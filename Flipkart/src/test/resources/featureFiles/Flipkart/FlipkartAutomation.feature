Feature: FlipkartAutomation.feature.feature - To prepare test cases for login scenario 

Background: 
	Given the open google web application is open 
	
Scenario: Test Flipkart Automation Scenario 
And Search for "Flipkart" Print all the search options displayed in the console from googles search field while we write Flipkart in that 
And Press enter to give out the search results and open the link for the flipkart website available
And Close the login popup on the website 
And Click on TV & Appliances dropdown button Navigate to AirConditioners Window ACs page
And Click on the Add To Compare checkbox of the second third and sixth products displayed 
And Click on the COMPARE button Print Name and price of all three products in the console
And Add all the three products into the cart, one by one
And Go to the cart and add your area Pincode "382470" check the availability of the product delivery there Print the message getting displayed for the availability delivery of the product
And Click the Deliver to input box add 
And another pin code "382424" check the availability of the product delivery there Print the message getting displayed for the availability delivery of the product
And Close the browser
	
	