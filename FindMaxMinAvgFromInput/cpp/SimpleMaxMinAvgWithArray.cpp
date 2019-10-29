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


double round(double var) 
{ 
    // 37.66666 * 100 =3766.66 
    // 3766.66 + .5 =3767.16    for rounding off value 
    // then type cast to int so value is 3767 
    // then divided by 100 so the value converted into 37.67 
    float value = (int)(var * 100 + .5); 
    return (float)value / 100; 
} 

double findMin(double arrayOfNums[], int totalNumbers) 
{ 
    double minNum = arrayOfNums[0];
    for (int i = 1; i < totalNumbers; i++) {
        if ( arrayOfNums[i] < minNum) {
            minNum = arrayOfNums[i];
        }
    }

    return minNum;
} 

double findMax(double arrayOfNums[], int totalNumbers) 
{ 
    double maxNum = arrayOfNums[0];
    for (int i = 1; i < totalNumbers; i++) {
        if ( arrayOfNums[i] > maxNum) {
            maxNum = arrayOfNums[i];
        }
    }

    return maxNum;
} 

double calculateAverage(double arrayOfNums[], int totalNumbers) 
{ 
    double sumNum = 0;
    for (int i = 1; i < totalNumbers; i++) {
        sumNum = sumNum + arrayOfNums[i];
    }

    return sumNum/totalNumbers;
} 

double printArray(double arrayOfNums[], int totalNumbers) 
{ 
    double sumNum = 0;
    for (int i = 1; i < totalNumbers; i++) {
        sumNum = sumNum + arrayOfNums[i];
    }

    return sumNum/totalNumbers;
} 

int main() {
// Gathering inputs
    string name;
    int totalNumbers;
    double numberEntered;

    cout << "********************* ENTER INPUTS *****************************\n";
	cout << "Enter your name::\t\n";
	cin >> name;		
	cout << "\n";

	cout << "Enter numbers you want to check::\t\n";
	cin >> totalNumbers;
    cout << "\n";
    double arrayOfNums[totalNumbers];

    for (int i = 0; i < totalNumbers; i++) {
        cout << "Enter number" << (i+1) << "::\t";
        cin >> numberEntered;
        arrayOfNums[i] = numberEntered;
    }

// Showing results in the console
    cout << "\n********************* SEE RESULTS *************************************\n";
    
    cout << "Minimum of the numbers " << name  << " entered::\t" << findMin(arrayOfNums, totalNumbers) << "\n"; 

    cout << "Maximum of the numbers " << name  << " entered::\t" << findMax(arrayOfNums, totalNumbers) << "\n"; 
    
    cout << "Average of the numbers " << name  << " entered::\t" << round(calculateAverage(arrayOfNums, totalNumbers)) << "\n"; 

    cout << "************************************************************************\n";

  return 0;
}
