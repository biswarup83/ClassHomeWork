import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindAtomicWeight {

	public static void main(String[] args) {

		/* ********************* SCAN ATMOIC NUMBER INPUT FRO< USER *********/

		int a = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter atomic no. btwn 1 and 109:-");

		a = sc.nextInt();

		/* ********************* READ ALL ATOMS' DATA FROM CSV FILE *********/
		
		/* Comma Separated File (CSV) has 12 Fields */
		/*
		 * AtomicNumber,AtomicWeight,Name,Symbol,MeltingPoint(C),BoilingPoint(C),Density
		 * (g/cm3),EarthCrust(%),DiscoveryYear, /*
		 * Group,ElectronConfiguration,IonizationEnergy (eV)
		 */

		BufferedReader reader;
		String[] tokens;
		int line_number = 1;
		try {
			reader = new BufferedReader(new FileReader("atomicWeights.csv"));
			String line = reader.readLine();
			while (line != null) {
				// System.out.println(line);

				if (line_number > 1) { // skip the first line as it contains header fields
					tokens = line.split(","); // string split function creates string array of 12 strings which contains the field values
					if (a == Integer.parseInt(tokens[0])) { // Compare if the atomic number entered matches with first field of each line.
															// If true then print the splits 
						System.out.println("AtomicNumber:: "+tokens[0]);
						System.out.println("AtomicWeight:: "+tokens[1]);
						System.out.println("Name:: "+tokens[2]);
						System.out.println("Symbol:: "+tokens[3]);
						System.out.println("MeltingPoint(C):: "+tokens[4]);
						System.out.println("BoilingPoint(C):: "+tokens[5]);
						System.out.println("Density(g/cm3):: "+tokens[6]);
						System.out.println("EarthCrust(%):: "+tokens[7]);
						System.out.println("DiscoveryYear:: "+tokens[8]);
						System.out.println("Group:: "+tokens[9]);
						System.out.println("ElectronConfiguration:: "+tokens[10]);
						System.out.println("IonizationEnergy(eV):: "+tokens[11]);
					}
				}
				// read next line
				line = reader.readLine();
				line_number++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
