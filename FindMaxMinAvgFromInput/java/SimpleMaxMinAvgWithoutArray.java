import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author biswarup
	
	Program to find the Minimum, Maximum without array
 	
 	How to run this code ?
 	1. Compile the JAVA code in command prompt, which will create .class file (compiled version of the java code)
 	javac SimpleMaxMinAvgWithoutArray.java
 	2. Run the code by running as below:
 	java SimpleMaxMinAvgWithoutArray
	 	
	********************* ENTER INPUTS *****************************
	Enter your name::	bis
	Enter numbers you want to check::	7
	Enter number1::	23.5
	Enter number2::	12.34
	Enter number3::	-234.04
	Enter number4::	-123.56
	Enter number5::	34.56
	Enter number6::	134.7
	Enter number7::	889.5
	
	
	********************* SEE RESULTS *************************************
	
	Minimum of the numbers bis entered::	-234.04
	Maximum of the numbers bis entered::	889.5
	************************************************************************

 **/

public class SimpleMaxMinAvgWithoutArray {

	public static void main(String[] args) {
		// Gathering inputs
		System.out.println("********************* ENTER INPUTS *****************************");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name::\t");
		String name = scanner.next();		
		
		System.out.println("Enter numbers you want to check::\t");
		int totalNumbers = scanner.nextInt();

		System.out.print("Enter number" + 1 + "::\t");
		double numberEntered = scanner.nextDouble();   // consider this as 0th entry
		
		double minNum = numberEntered;
		double maxNum = numberEntered;
		double sumNum = numberEntered;
		
		// For loop starting from 2nd entry to the last which is (totalNumber - 1)
		for (int i = 1; i < totalNumbers; i++) {     
			System.out.print("Enter number" + (i+1) + "::\t");
			numberEntered = scanner.nextDouble();
			
			if(numberEntered > maxNum)
				maxNum = numberEntered;
			if(numberEntered < minNum)
				minNum = numberEntered;
			
			sumNum = sumNum + numberEntered;
		}
		scanner.close();
		System.out.println("\n");
		
		// Showing results in the console
		System.out.println("********************* SEE RESULTS *************************************");
		System.out.println();
		
		System.out.println("Minimum of the numbers "+ name +" entered::\t" + minNum); 

		System.out.println("Maximum of the numbers "+ name +" entered::\t" + maxNum); 
		
		DecimalFormat format = new DecimalFormat("##.00");
		System.out.println("Average of the numbers "+ name +" entered::\t" + format.format(sumNum/totalNumbers)); 
		
		System.out.println("************************************************************************");

				
	}

}
