This repo contains an implementation of a code test requested by Dius. This demo is using Java and it was implemented using Eclipse IDE. 
As requested, I tried not taking longer than 2hours working on this project and therefore I did not finish the way I would like. I can, however, complete the unit testing if I am given more time.
The mains objectives I tried to achieve are:
- Easy to manage(CRUD) items and discounts
- Clean code
- Reusale code
- Easy interface to create new discounts


- Main Class
The main class is Dius and it is inside the package luiz.glingani. This is only an entry point to the checkout. This class has a main method that received a list of item codes to be processed.

-Items
List of items available. The information about all items "stored" into the system are inside ItemsDatbase. It is possible to see information about the discount associated to the item. New items as well as discounts can easily be added to the list

-Testing
So far I have only added really basic testing but I am happy to spend more time if you think it is necessary. I tried not to take hours and hours as requested. 

-Libraries
To run the unit tests, remember to add the lib folder to the classpath

-Run testing
The class DiusTest.java contains all the Example scenarios mentioned on the page.

-Output
Fell free to add/change the unit tests if you want to test a different variation of checkout lists. The application will also prompt a list of the items and the price.
This is an example of the output:

--------------------
MacBook Pro			1399.99
VGA adapter			0.0
Super iPad			549.99
Total: 				1949.98
   