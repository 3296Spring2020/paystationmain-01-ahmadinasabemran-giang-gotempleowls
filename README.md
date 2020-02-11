# Software Design CIS 3296
## Lab 4
### Ahmadi Nasab Emran and Giang

#### Lab Requirements

This lab required that the team members work together to complete the implementation of the paystation from the previous project, while making consistent use of GitHub functionalities.
The implementation includes a main function that allows the user to perform various actions at will, which demonstrate the functionality of the paystation. These actions include the following:
 * Deposit coins for payment
 * Display time bought 
 * Buy ticket and print receipt
 * Cancel purchase, print returned coin values, and number of each coin type
 * Change Rate Strategy
The three rate strategies include linear, progressive, and alternating strategies which have their own equations and conditions which can be found within the program files.
Completing the program also entails the implementation of a menu which allows for a clear conveyance of information to the user, and allows them to easily choose actions to perform.

Everything required for the project was completed, but we hardly went beyond the scope of the initial given task.

Our group decided to use a parametric method to implement the different rate strategies, where we changed the value of a global currentRate variable, which we checked with a switch to determine which function to call.
This method seemed the simplest for us to read because there is little to no redundant code, and the switches are relatively small as there are only three towns. 
Each strategy only changes behavior slightly, so making a separate class for each strategy seemed excessive.

#### UML Diagram

![UML Diagram](/images/uml.png)

#### Testing

For testing, we performed system testing. The individual units were simple enough that only a few problems arose when implementing the different methods. The majority of the project was making sure everything functioned as a whole,
which meant most parts could be validated through confirming the use of proper logic. Ultimately, testing involved confirming that values were consistent, methods could be called without errors, and that the menu was readable.

The tests were all manually performed. This involved iterating through the menu multiple times during one run, and making sure that calling the methods in different orders would not result in the program ceasing to function.
For example, we tested using different coin combinations and whether empty mappings would result in any issues. We also confirmed that the timeBought would retroactively update if currentRate was changed while coins were already entered.
After every test, we also attempted to improve the format of the menu, until finally settling on syntax that was straightforward and readable.

A few bugs were discovered. A NullPointerException occurred because of failure to call setup() before attempting to use methods from other classes. 
The initial implementation for cancel() did not work because of a misunderstanding of how values were mapped, were the keys were thought to be 5, 10, and 25, rather than 1, 2, and 3.
Additionally, the copied values held in the main class were not initialized if the corresponding key in coinMap was null.
The scanner in main would cease to function after calling other methods which called for user input because we would close scanners after their use in minor functions, which unexpectedly closed the scanner in main as well.

The person in charge of the code also performed the testing.

No automated tests were written, so everything was tested after the completion of the design.

#### Team
 * Parsa Ahmadi Nasab Emran
 
	* I have created three methods for rate strategy requirement for this lab assignment. I have implemented the following three Rate Strategies: Linear Rate Strategy, Progressive Rate Strategy, and Alternating Rate Strategy. My partner have done the rest of this lab assignment. I have done about 40% - 50% of the work.
 
 * Steven Giang
	
	I completed the entire Main.java class, including the menus, made changes to legibility throughout the code, and created comments where I thought it necessary on other classes. 
	Created an edited online representation of the UML diagram based on a guideline for RateStrategyImpl, RateStrategy, PayStation, and PayStationImpl provided by Parsa. 
	Adapted the implementation of calculateTimeAlternating to make use of Calendar, which allows the program to get the current day from the system rather than manually inputting it.
	Edited PayStationImpl.addPayment to call the necessary method based on the currentRate value, and changed PayStationImpl.changeRate to retroactively udpate timeBought if the rate strategy was switched.
	Edited the calculateTimeAlternating method to make a call to calculateTimeProgressive rather than copy and pasting code. Also changed the functions to be int values rather than double, as there are no fractions of minutes in this scenario.
	Created the readme, except for Parsa's individual section. I performed all the manual tests of the final product, and completed most of the revisions.
	
	In terms of collaboration, there was some miscommunication and misunderstandings concerning the workloads. In terms of speed relative to content created, it was fairly similar. 

##### Proof of these contributions are available through the github repository.