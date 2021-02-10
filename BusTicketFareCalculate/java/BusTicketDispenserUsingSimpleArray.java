/*

Question:

A computerised bus charges fare from each of its passengers based on the distance travelled
as per the tariff given below:-
Distance(in km) Charges
First 10 km Rs. 50
Next 15 km Rs.Rs.4.50/km
More than 25 km Rs. 4.00/km
As the passenger enters the bus, the computer prompts ‘Enter distance you intend to travel’.
On entering the distance, it prints the ticket and the control goes back for the next passenger.
At the end of journey, the computer prints the following :-
1) The number of passenger travelled. 2) Total fare received.
Write a program to perform the above task.[ Hints: perform the task based on user
 controlled loop ]



Solution analysis:

- First the password for summary generator is loaded from config.properties file. 

- In this solution simple array is used. First user is asked how many passengers are going to travel. And based of that 
array is defined. A number format check is done considering user can enter any number.

- Once array is initialized For loop iterates over the array to gather from each passengers where passenger enters how many
kms they are going to travel.

- Considering a user can enter any letters when asked to enter how many kms he/she wants to travel, the system would fail if 
an user enters non-numeric letter. So the function isNumeric uses regular expressions to check if the string entered by the user 
is a number or not. If not then it asks the user to re-enter. 

- Once the user enter the number of kms he/she wants to travel the getFare() function takes care of the calculations of how much fare
would be charged and returns it which then is stored in the arrayList all_fares.

- Now when the travel is completed the driver/conductor puts the password (in this case X12345) and the program them iterates 
over the arrayList all_fares to generate sum of all fares and the total number of passengers traveled. 


*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class BusTicketDispenserUsingSimpleArray {

	public static void main(String[] args) {

		// Main code
		String string_entered = null;
		Double distance_travelling = null;
		
		// This section loads the password to print the summary. default: X12345
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String pwd = prop.getProperty("pwd");

		// Obtaining number of passengers first
		System.out.println("Enter how many passengers boarding (enter number greater than zero): ");
		while (true) {
			string_entered = getInputFromUser();
			if (!isNumeric(string_entered) || Integer.parseInt(string_entered) == 0)
				System.out.print("Invalid number. Please enter a correct number: ");
			else
				break;
		}

		// Initializing the primary array of double for fares
		// which will hold the number of elements entered above at maximum initialized
		// with 0.0
		double all_fares[] = new double[Integer.parseInt(string_entered)];

		// For loop to enter passengers one by one and fill up array all_fares
		for (int i = 0; i < all_fares.length; i++) {
			// Boarding completion password(default): X12345
			System.out.println("******************************");
			System.out.println(
					"Enter password to complete boarding and generate summary OR press any key and enter to continue as new passenger: ");

			string_entered = getInputFromUser();

			// primary if-else start
			if (string_entered.equals(pwd)) { // if all passengers boarded
				printSummary(all_fares);
				break;
			} else { // if new passenger wants to enter kms
				System.out.print("Enter number of km : ");
				while (true) {
					string_entered = getInputFromUser();
					if (!isNumeric(string_entered))
						System.out.print("Invalid number format. Please enter a correct number: ");
					else {
						distance_travelling = Double.parseDouble(string_entered);
						all_fares[i] = getFare(distance_travelling);
						break;
					}
				}
				if (i == all_fares.length - 1) { // last passenger
					// Boarding completion password(default): X12345
					System.out
							.println("Maximum limit of passengers reached. Please enter password to generate summary: ");
					string_entered = getInputFromUser();
					while (true) {
						if (string_entered.equals(pwd)) {
							printSummary(all_fares);
							break;
						}
					}
				} // last passenger reached if loop end
			} // primary if-else start
		} // End of For loop

	} // End of main

	// Function to get input string from user.
	private static String getInputFromUser() {

		BufferedReader bufferRead = null;
		String string_entered = null;

		try {
			bufferRead = new BufferedReader(new InputStreamReader(System.in));
			string_entered = bufferRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return string_entered;

	}

	// Function to print summary of the travel (printing no of travelers and total
	// fare received)
	private static void printSummary(double[] all_fares) {

		double total_fare_charged = 0.0;
		int passenger_count = 0;
		for (int j = 0; j < all_fares.length; j++) {
			total_fare_charged = total_fare_charged + all_fares[j];
			if (all_fares[j] > 0)
				passenger_count = passenger_count + 1;
		}

		System.out.println();
		System.out.println("################# Travel Summary ######################### ");
		System.out.println("Total Fare Received: " + total_fare_charged);
		System.out.println("Total Number of Passengers Travelled: " + passenger_count);
		System.out.println("########################################################### ");
	}

	// Function to calculate the fare based of kms entered
	public static double getFare(Double distance_travelling) {

		Double fare_charged = null;

		// ##### Logic for calculation of fare ####
		if (distance_travelling < 10)
			fare_charged = 50.0;
		if (distance_travelling >= 10 && distance_travelling <= 25)
			fare_charged = 50.0 + 4.5 * (distance_travelling - 10);
		if (distance_travelling > 25)
			fare_charged = 50.0 + 4.0 * (distance_travelling - 10);
		// ############### end of fare calculation #####

		System.out.println();
		System.out.println("############ Ticket Reciept ########");
		System.out.println("Kilometers travelling: " + distance_travelling);
		System.out.println("Fare charged: " + fare_charged);
		System.out.println("Safe travel. Thank you!");
		System.out.println("#####################################");
		System.out.println();

		return fare_charged;
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

}
