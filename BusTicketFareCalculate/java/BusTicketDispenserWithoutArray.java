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

- This solution is without any array.

- passenger enters how many kms they are going to travel.

- Considering a user can enter any letters when asked to enter how many kms he/she wants to travel, the system would fail if 
an user enters non-numeric letter. So the function isNumeric uses regular expressions to check if the string entered by the user 
is a number or not. If not then it asks the user to re-enter. 

- Once the user enter the number of kms he/she wants to travel the getFare() function takes care of the calculations of how much fare
would be charged and returns it.

- Now when the travel is completed the driver/conductor enters "end" to generate sum of all fares and the total number of passengers traveled. 


*/

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class BusTicketDispenserWithoutArray {

	public static void main(String[] args) {

		// Main code
		String string_entered = null;
		Double total_fare_received = 0.0;
		Double fare_charged = 0.0;
		int total_passenger_count = 0;
		// Obtaining number of passengers first

		while (true) {
			System.out.println("Enter how many kms you wanto travel OR enter \"end\" to print out summary : ");
			string_entered = getInputFromUser();
			if (!string_entered.equals("end")) {
				if (!isNumeric(string_entered)) {
					System.out.print("Invalid number. Please enter a correct number: ");
				}
				else {
					fare_charged = getFare(Double.parseDouble(string_entered));

					System.out.println();
					System.out.println("############ Ticket Reciept ########");
					System.out.println("Kilometers travelling: " + string_entered);
					System.out.println("Fare charged: " + fare_charged);
					System.out.println("Safe travel. Thank you!");
					System.out.println("#####################################");
					System.out.println();

					total_fare_received = total_fare_received + fare_charged;
					total_passenger_count = total_passenger_count + 1;
				}
			}
			if (string_entered.equals("end")) {

				System.out.println();
				System.out.println("################# Travel Summary ######################### ");
				System.out.println("Total Fare Received: " + total_fare_received);
				System.out.println("Total Number of Passengers Travelled: " + total_passenger_count);
				System.out.println("########################################################### ");

				break;
			}

		} // End of while loop

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

	// Function to calculate the fare based of kms entered
	public static double getFare(Double distance_travelling) {

		Double fare_charged = null;

		// ##### Logic for calculation of fare ####
		if (distance_travelling <= 10)
			fare_charged = 50.0;
		if (distance_travelling > 10 && distance_travelling <= 25)
			fare_charged = 50.0 + 4.5 * (distance_travelling - 10);
		if (distance_travelling > 25)
			fare_charged = 50.0 + 4.0 * (distance_travelling - 10);
		// ############### end of fare calculation #####

		return fare_charged;
	}

	// check if a string is numeric or not
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

}
