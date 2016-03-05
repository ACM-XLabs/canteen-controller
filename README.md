# ACM XLABS : DIGITAL CANTEEN

## Android Section - Controller Module


This module of the project will undertake the creation of an android application for the canteen employee who serves the food at the counter.

Key tasks for this app:

* A live display of all orders
* System for authenticating/accepting orders

The flow of the app is as follows; once a person places an order, a token number will be generated and the same order will appear on the food-server app. The food-server will then announce the order in the kitchen. Once the order is ready, the food-server will select the order from his list which will generate a notification on the user’s app. The user will then show his token number to the food server and collect his order. The food-server will then remove the order from his list.
To provide a method for authentication, we have decided to generate a shape* along with the token number for each order component. Hence, to remove the order from his list, the food-server will have to select the correct shape from the given options.

*using shapes is a temporary measure just to portray the idea, this will almost definitely be changed to something else. The idea is to have some set of easily distinguishable objects that are at least 9 in number that the food-server can select easily.


The food-server will have the orders listed to him in three separate queues, as explained below.

* The first queue will contain the list of all pending orders which have not been sent out to the customer yet.
* The second queue contains orders that have been completed but not delivered due to the customer’s absence.
* The third queue will be specific to ready-to-eat items that the food-server presently deals with directly.

When an order component on the list is ready, the food-server will select the top item in the queue with the matching component. If the customer does not arrive in a set amount of time (say, 30 seconds) the order will be given away to the next customer and the original customer’s order will be placed into the second queue, giving him the highest priority when the same order component comes by next.

The app has to focus on getting every task within a very limited number of taps.
We will be using a tablet for this for more screen space, but development for now will be done on phones, but the layout should be mindful of a larger screen.
There should be only one activity and main fragment.

**Document will be updated further with more details.**
