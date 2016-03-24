# SalesForceCodingChallenge


# Introduction
As part of the challenge, I had to build a project which takes into account user location and returns the list of three closest coffee shops.

# Approach 

## Design Structure
	The solution is divided into 4 classes as below
- CoffeeShopFutureForce.java: This class implements the main function
- Coordinates.java: This class defines x,y co-ordinates of location
- CoffeeShopDistance.java: This class stores coffee name and its distance from user
- CoffeeShopDistanceComparator.java: This is a comparator class to compare distances between two users.

## Data Structures Used

Max-Heap using Java Priority-Queue: The basic idea used is to read the input CSV file line-by-line and store the required data at every	instance. For storing the closest three coffee shops seen till now, a max-heap of  size three is maintained. Whenever a new coffee shop data is read, I compare the distance of current coffee shop with the root element of max-heap using my comparator class. If the distance of current coffee shop is less, the root element is pulled-out and current coffee shop is offered. 

ArrayList: After the entire file is read, all the CoffeeShopDistance objects are added to ArrayList and printed in the increasing order of distance.

# Time Complexity & Analysis 

Time to Parse the CSV file, read all the lines and compute Euclidean distances from user : O(n) where n is number of coffee shops (i.e. no of lines in the CSV file)
Time for single insertion into Max heap: O(logN) where N is the number of entries in the heap

# Run Environment  
Built in Java SE 1.8
