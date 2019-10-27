

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author biswarup
	
	Program to find the Minimum, Maximum and Average of array of integers 
 	using JAVA Collections and Array class methods
 	
 	How to run this code ?
 	1. Compile the JAVA code in command prompt, which will create .class file (compiled version of the java code)
 	javac FindMaxMinAvgOfNumArrWithArraySort.java
 	2. Run the code by running as below:
 	java FindMaxMinAvgOfNumArrWithArraySort
 	
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

public class FindMaxMinAvgOfNumArrWithArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("********************* ENTER INPUTS *****************************");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name::\t");
		String name = scanner.next();		
		System.out.print("Enter numbers you want to check::\t");
		int arraySize = scanner.nextInt();
		

		Double[] arrayOfNums = new Double[arraySize];
		for (int i = 0; i < arrayOfNums.length; i++) {
			System.out.print("Enter number" + (i+1) + "::\t");
			arrayOfNums[i] = scanner.nextDouble();
		}
		scanner.close();
		
		System.out.println("\n\n");
		
		System.out.println(name + " entered array of "+ arraySize +" numbers::\t" + Arrays.toString(arrayOfNums));

		Arrays.sort(arrayOfNums);

		System.out.println("***********************************************************************");
		// Showing results in the console
		
		System.out.println("********************* SEE RESULTS *************************************");
		System.out.println();
		System.out.println("Numbers after sorting::\t" + Arrays.toString(arrayOfNums));

		System.out.println("Minimum of the numbers::\t" + Collections.min(Arrays.asList(arrayOfNums)));

		System.out.println("Maximum of the numbers::\t" + Collections.max(Arrays.asList(arrayOfNums)));
		
		DecimalFormat format = new DecimalFormat("##.00");
		System.out.println("Average of the Numbers::\t" + format.format(calculateAverage(arrayOfNums)));
		System.out.println();
		System.out.println("*************************************************************************");

		

	}
	
	
	/**
	 * 
	 * @param array of double 
	 * @return double
	 * 
	 * Calculate Average of the array of the doubles
	 */
	private static double calculateAverage(Double[] numbers) {
	    if (numbers == null || numbers.length == 0) {
	        return 0;
	    }

	    double sum = 0;
		for (int i = 0; i < numbers.length; i++) {
	        sum += numbers[i];
	    }

	    return sum / numbers.length;
	}
	


}
