
"""
 * @author biswarup
	
	Program to find the Minimum, Maximum without array
 	
 	How to run this code ?
 	- python3 SimpleMaxMinWithoutArray.py
	 	
	********************* ENTER INPUTS *****************************
    Enter your name with quotes::
    bis
    Enter numbers you want to check::
    asd
    You entered a non-integer. Please input a correct integer!
    Enter numbers you want to check::
    4
    Enter number1:: 12
    Enter number2:: -13.4
    Enter number3:: asca
    You entered a non-numeric. Please input a correct number!
    Enter number3:: 45.6
    Enter number4:: 78

    ********************* SEE RESULTS *************************************

    Minimum of the numbers bis entered::    -13.4
    Maximum of the numbers bis entered::    78.0
    ************************************************************************

"""

def obtainInput(dataType):
    isValidInput = False
    while isValidInput == False:
        try:
            if dataType == "int":
                var = int(input())
            if dataType == "float":
                var = float(input())
            isValidInput = True
        except ValueError:
            print("Input not in correct format. Please enter correctly!")
            isValidInput = False
    return var


def main():
    print("********************* ENTER INPUTS *****************************")
    print("Enter your name with quotes::\t")
    name = input()
    print("Enter numbers you want to check::\t")	
    totalNumbers = obtainInput("int")  
        
    print("Enter number" + repr(1) + "::\t", end = "")
    numberEntered = obtainInput("float")   # consider this as 0th entry
    minNum = numberEntered
    maxNum = numberEntered
    sumNum = numberEntered

    # For loop starting from 2nd entry to the last which is (totalNumber - 1)
    for i in range(1, totalNumbers):
        print("Enter number" + repr(i+1) + "::\t", end = "")    
        numberEntered = obtainInput("float")
        
        if numberEntered > maxNum:
            maxNum = numberEntered
        if numberEntered < minNum:
            minNum = numberEntered
        
        sumNum = sumNum + numberEntered
    # End of For loop

    # Showing results in the console
    print()
    print("********************* SEE RESULTS *************************************\n")

    print("Minimum of the numbers "+ name +" entered::\t" + repr(minNum))

    print("Maximum of the numbers "+ name +" entered::\t" + repr(maxNum))

    print("Average of the numbers "+ name +" entered::\t" + repr(round(sumNum/totalNumbers,2)))

    print("************************************************************************")
# end of main()

if __name__== "__main__":
  main()