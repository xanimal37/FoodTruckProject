# FoodTruck Application
- This is a simple food truck rating app. 

# Description
- Initially the user is presented with a simple choice of either entering trucks or quitting the program. If the user chooses to enter trucks, the program will keep asking to add more trucks until the limit (5) is reached or the user types "QUIT" for a truck name. Once trucks have been entered the user will see the additional options of displaying all the trucks and their info, viewing the average rating for all trucks, or displaying the data of the truck with the highest overall rating. The program loop continues until the user chooses "QUIT" or "quit" from the main menu.

# Technologies Used
- Java, git

# Lessons Learned
- copied the code structure of the 'MadLibs' app. I studied this app to understand its flow.
- Modeling my app on the 'MadLibs' app structure helped me to understand how the 'MadLibs' app worked and what is a good way to structure programs
- For example, within the main method of the app, the app can be instantiated. The scanner can be passed to it and all of the app's methods, which is a nice way to handle the pesky scanner. Also all methods can be called within the app OBJECT, which keeps the main method nice and clean with only an entry and exit point.
- Have to keep track of what's in an array. Way easier than checking for a 'null' spot
- Having objects do their own things (like toString) keeps the main code simpler (reduces println()s)

# Features
- I added a confirmation that the user entered the correct data for their truck. If they say NO, the truck is not added and the addTruck method starts over.

# Things I might like to add
- a way to delete food trucks
- a way to have unlimited food trucks
- more data options for food trucks
- a GUI but I have no idea how to do that!
- right now it doesn't check that the user enters a number between 1 and 10 for the rating (this is an arbitrary limit)
