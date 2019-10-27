import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author biswarup
	
	Program to find the Minimum, Maximum and Average of array of integers 
 	
 	How to run this code ?
 	1. Compile the JAVA code in command prompt, which will create .class file (compiled version of the java code)
 	javac SimpleMaxMinAvgFromArray.java
 	2. Run the code by running as below:
 	java SimpleMaxMinAvgFromArray
	 	
	********************* ENTER INPUTS *****************************
	Enter your name::	bis
	Enter numbers you want to check::	6
	Enter number1::	2.3
	Enter number2::	4.5
	Enter number3::	6.1
	Enter number4::	1.2
	Enter number5::	6.3
	Enter number6::	1.1
	
	
	BIS entered::	
	2.3	4.5	6.1	1.2	6.3	1.1	
	
	***********************************************************************
	********************* SEE RESULTS *************************************
	
	Minimum of the numbers::	1.1
	Maximum of the numbers::	6.3
	Average of the Numbers::	3.58
	
	************************************************************************

 **/

public class SimpleMaxMinAvgFromArray {

	public static void main(String[] args) {
		// Gathering inputs
		System.out.println("********************* ENTER INPUTS *****************************");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name::\t");
		String name = scanner.next();		
		System.out.print("Enter numbers you want to check::\t");
		int arraySize = scanner.nextInt();
		

		double[] arrayOfNums = new double[arraySize];
		for (int i = 0; i < arrayOfNums.length; i++) {
			System.out.print("Enter number" + (i+1) + "::\t");
			arrayOfNums[i] = scanner.nextDouble();
		}
		scanner.close();
		System.out.println("\n");
		
		System.out.println(name.toUpperCase() + " entered::\t");
		printArray(arrayOfNums);
		
		System.out.println("\n");

		System.out.println("***********************************************************************");
		
		// Showing results in the console
		System.out.println("********************* SEE RESULTS *************************************");
		System.out.println();
		
		System.out.println("Minimum of the numbers::\t" + findMin(arrayOfNums)); // First element of the sorted array should be the minimum

		System.out.println("Maximum of the numbers::\t" + findMax(arrayOfNums)); // Last element of the sorted array would be the maximum
		
		DecimalFormat format = new DecimalFormat("##.00");
		System.out.println("Average of the Numbers::\t" + format.format(calculateAverage(arrayOfNums)));
		System.out.println();
		System.out.println("************************************************************************");

		
	}
	
	
	/**
	 * 
	 * @param array of double
	 * @return array of double
	 * 
	 * Performs Bubble Sorting
	 */
	private static double findMax(double[] arr) {
		double tmp = arr[0];
		for (int i = 1; i < arr.length; i++) { // First loop to loop through the input array from second element i
			if (arr[i] > tmp) { 							
				tmp = arr[i];
			}
		}
		return tmp;
		
	}
	
	/**
	 * 
	 * @param array of double
	 * @return array of double
	 * 
	 * Performs Bubble Sorting
	 */
	private static double findMin(double[] arr) {
		double tmp = arr[0];
		for (int i = 1; i < arr.length; i++) { // First loop to loop through the input array from second element i
			if (arr[i] < tmp) { 							
				tmp = arr[i];
			}
		}
		return tmp;
		
	}
	
	/**
	 * 
	 * @param array of double 
	 * @return double
	 * 
	 * Calculate Average of the array of the doubles
	 */
	private static double calculateAverage(double[] numbers) {
	    if (numbers == null || numbers.length == 0) {
	        return 0;
	    }

	    double sum = 0;
		for (int i = 0; i < numbers.length; i++) {
	        sum += numbers[i];
	    }

	    return sum / numbers.length;
	}
	
	
	/**
	 * 
	 * @param array of double
	 * 
	 * Prints contents of the array
	 */
	private static void printArray(double[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

}
