#include <iostream>
using namespace std;

int main() {
// Gathering inputs
    string name;
    int totalNumbers;
    double numberEntered;
    double minNum;
	double maxNum;

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

    for (int i = 1; i < totalNumbers; i++) {
        cout << "Enter number" << (i+1) << "::\t";
        cin >> numberEntered;

        if (numberEntered > maxNum) {
            maxNum = numberEntered;
        }
        if (numberEntered < minNum) {
            minNum = numberEntered;
        }
    }

// Showing results in the console
    cout << "\n********************* SEE RESULTS *************************************\n";
    
    cout << "Minimum of the numbers " << name  << " entered::\t" << minNum << "\n"; 

    cout << "Maximum of the numbers " << name  << " entered::\t" << maxNum << "\n"; 
    
    cout << "************************************************************************\n";

  return 0;
}