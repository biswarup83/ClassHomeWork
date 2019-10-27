
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author biswarup
	
	Program to find the Minimum, Maximum and Average of array of integers 
 	using JAVA Collections and Array class methods
 	
 	How to run this code ?
 	1. Compile the JAVA code in command prompt, which will create .class file (compiled version of the java code)
 	javac FindMaxMinAvgOfNumArrWithoutArraySort.java
 	2. Run the code by running as below:
 	java FindMaxMinAvgOfNumArrWithoutArraySort
 	
	*********************** ENTER INPUTS *****************************
	Enter your name::	bis
	Enter numbers you want to check::	4
	Enter number1::	2.32
	Enter number2::	1.1
	Enter number3::	1.01
	Enter number4::	2.34
	
	
	BIS entered::	
	2.32	1.1	1.01	2.34	
	
	***********************************************************************
	********************* SEE RESULTS **************************
	
	Numbers after sorting::	
	1.01	1.1	2.32	2.34	
	
	Minimum of the numbers::	1.01
	Maximum of the numbers::	2.34
	Average of the Numbers::	1.69
	
	************************************************************************
 **/
public class FindMaxMinAvgOfNumArrWithoutArraySort {

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
		double[] sortedarrayOfNums = applyBubbleSorting(arrayOfNums);  // apply bubble sorting which returns arrays sorted ascending

		// Showing results in the console
		System.out.println("********************* SEE RESULTS *************************************");
		System.out.println();

		System.out.println("Numbers after sorting::\t");
		printArray(arrayOfNums);
		System.out.println();
		
		System.out.println();
		System.out.println("Minimum of the numbers::\t" + sortedarrayOfNums[0]); // First element of the sorted array should be the minimum

		System.out.println("Maximum of the numbers::\t" + sortedarrayOfNums[sortedarrayOfNums.length - 1]); // Last element of the sorted array would be the maximum
		
		DecimalFormat format = new DecimalFormat("##.00");
		System.out.println("Average of the Numbers::\t" + format.format(calculateAverage(arrayOfNums)));
		System.out.println();
		System.out.println("************************************************************************");

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
	 * @return array of double
	 * 
	 * Performs Bubble Sorting
	 */
	private static double[] applyBubbleSorting(double[] arr) {
		
	    for (int i = 0; i < arr.length; i++) {			// First loop to loop through the input array from first element i
	        for (int j = i + 1; j < arr.length; j++) {	// Second loop start from i + 1
	            double tmp = 0;
	            if (arr[i] > arr[j]) {					// If the next element i + 1 is > previous element i then exchange elements using a temporary variable
	                tmp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = tmp;
	            }
	        }
	    }
		
		return arr;
		
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
