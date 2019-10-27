/**
	Program to find the Minimum, Maximum and Average without array
 	
 	How to run this code ?
    
    - Compile SimpleMaxMinWithoutArray.cpp
    - run compiled script

    ********************* ENTER INPUTS *****************************
    Enter your name::
    bis

    Enter numbers you want to check::
    4

    Enter number1:: 11.23
    Enter number2:: 45.6
    Enter number3:: -34.6
    Enter number4:: 34

    ********************* SEE RESULTS *************************************
    Minimum of the numbers bis entered::    -34.6
    Maximum of the numbers bis entered::    45.6
    ************************************************************************
**/

#include <iostream>
using namespace std;


float round(float var) 
{ 
    // 37.66666 * 100 =3766.66 
    // 3766.66 + .5 =3767.16    for rounding off value 
    // then type cast to int so value is 3767 
    // then divided by 100 so the value converted into 37.67 
    float value = (int)(var * 100 + .5); 
    return (float)value / 100; 
} 

int main() {
// Gathering inputs
    string name;
    int totalNumbers;
    double numberEntered;
    double minNum;
	double maxNum;
    double sumNum;

    cout << "********************* ENTER INPUTS *****************************\n";
	cout << "Enter your name::\t\n";
	cin >> name;		
	cout << "\n";

	cout << "Enter numbers you want to check::\t\n";
	cin >> totalNumbers;
    cout << "\n";


	cout << "Enter number" << 1 << "::\t";
	cin >> numberEntered;   // consider this as 0th entry

	minNum = numberEntered;
    maxNum = numberEntered;
    sumNum = numberEntered;

	// For loop starting from 2nd entry to the last which is (totalNumber - 1)
    for (int i = 1; i < totalNumbers; i++) {
        cout << "Enter number" << (i+1) << "::\t";
        cin >> numberEntered;

        if (numberEntered > maxNum) {
            maxNum = numberEntered;
        }
        if (numberEntered < minNum) {
            minNum = numberEntered;
        }

        sumNum = sumNum + numberEntered;
    }

// Showing results in the console
    cout << "\n********************* SEE RESULTS *************************************\n";
    
    cout << "Minimum of the numbers " << name  << " entered::\t" << minNum << "\n"; 

    cout << "Maximum of the numbers " << name  << " entered::\t" << maxNum << "\n"; 
    
    cout << "Average of the numbers " << name  << " entered::\t" << round(sumNum/totalNumbers) << "\n"; 

    cout << "************************************************************************\n";

  return 0;
}
