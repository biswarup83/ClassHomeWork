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

Solution Flow:

- Main section of the code user is first asked to enter any key to proceed if he/she is a new passenger. 
- Once the passenger hits a key it asks him/her how many kms he/she wants to travel
- Once he/she enters number of kms and hits enter, it prints how many kms traveling and how much fare is to be charged. 
- Once the hourly is completed driver/conductor can put pasword "X1234" to print out how many passengers traveled and 
how much total fare is received. 

Solution analysis:

- As the question does not specific how many passengers are going to board the bus at the beginning, we cannot use a simmple
array of double. Instead we are using ArrayList<double> where you can dynamically add new entries, without initializing the 
ArrayList object with a specific size to it. 
On the other hand if we knew e.g. 40 passenger is to added then we could have defined an array of 40 elements of type double. 
The problem with that approach is if there are less than 40 passengers then the loop must need to be finished before you can print
the travel summary. Also if you have more than 40 passengers then you cannot add them into the system.

- Considering a user can enter any letters when asked to enter how many kms he/she wants to travel, the system would fail if 
an user enters non-numeric letter. So the function isNumeric uses regular expressions to check if the string entered by the user 
is a number or not. If not then it asks the user to re-enter. 

- Once the user enter the number of kms he/she wants to travel the IF loop logic take care of the calculations of how much fare
would be charged and returns it in the function getFare(). Once the fare is returned it then stores in the arrayList all_fares.

- Now when the travel is completed the driver/conductor puts the password (in this case X1234) and the program them iterates 
over the arrayList all_fares to generate sum of all fares. Also the size() function gives the total number of passengers traveled. 


*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BusTicketDispenser {

	public static void main(String[] args) {
		// Main code
		
		ArrayList<Double> all_fares = new ArrayList<Double>();
		BufferedReader bufferRead = null;
        String string_entered = null;
        double total_fare_charged = 0.0;
	    while(true) {
    		// Boarding completion password: X1234 
    		System.out.println("******************************");
    		System.out.println("Enter password to complete boarding OR press any key and enter to continue as new passenger: ");
    		
    		try{
        	bufferRead = new BufferedReader(new InputStreamReader(System.in));
        	string_entered = bufferRead.readLine();
		    }
		    catch(IOException e)
		    {
		        e.printStackTrace();
		    }
	    	
    		if(string_entered.equals("X1234")) {
    			for (Double each_fare : all_fares) {
					total_fare_charged = total_fare_charged + each_fare;
				}
    			
    			System.out.println();
    			System.out.println("################# Travel Summary ######################### ");
    			System.out.println("Total Fare Received: "+total_fare_charged);
    			System.out.println("Total Number of Passengers Travelled: "+all_fares.size());
    			System.out.println("########################################################### ");
    			break;
    		} else {
    			all_fares.add(getFare());
    		}
    		
	    	
	    }// End of While loop
	    
	}
	
	public static double getFare() {
        System.out.print("Enter number of km : ");
        BufferedReader bufferRead = null;
        String string_entered = null;
        Double distance_travelling = null;
        Double fare_charged = null;


	        while(true) {
	    		try{
	        	bufferRead = new BufferedReader(new InputStreamReader(System.in));
	        	string_entered = bufferRead.readLine();
		    }
		    catch(IOException e)
		    {
		        e.printStackTrace();
		    }

		        if(!isNumeric(string_entered))
		        	System.out.print("Invalid format. Please enter a correct number: ");
		        else {
		        	distance_travelling = Double.parseDouble(string_entered);
		        	
		        	// ##### Logic for calculation of fare ####
		        	if (distance_travelling < 10)
		        		fare_charged = 50.0;
		        	if (distance_travelling >= 10 && distance_travelling <= 25)
		        		fare_charged = 50.0 + 4.5 * (distance_travelling - 10);
		        	if (distance_travelling > 25 )
		        		fare_charged = 50.0 + 4.0 * (distance_travelling - 10);
		        	// ############### end of fare calculation #####
		        	
		        	System.out.println();
		        	System.out.println("############ Ticket Reciept ########");
		        	System.out.println("Kilometers travelling: "+ distance_travelling);
		        	System.out.println("Fare charged: "+ fare_charged);
		        	System.out.println("Safe travel. Thank you!");
		        	System.out.println("#####################################");
		        	System.out.println();
		        	break;
		        }
	        }

		return fare_charged;
	}
	
	public static boolean isNumeric(String str) {
		  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

}
