// Name: Leon Singleton
// User Name:aca16ls

import sheffield.* ;
public class Assignment1 {
	public static void main(String[] args) {
		//Assigns the Easyreader method to a variable so i can read input from the console
		EasyReader Keyboard = new EasyReader();
		EasyWriter screen = new EasyWriter();
		
		//Asks the user to enter values for their decimal currecny and and allows the user to input them
		double poundsNew = Keyboard.readDouble("How many pounds? ");
		double shillingsNew = Keyboard.readDouble("How many Shillings? ");
		double penceNew = Keyboard.readDouble("How many Pence? ");
		//Calculates the decimal currency based on the user's inputs
		double decimalCurrency = (poundsNew + (shillingsNew / 20) + (penceNew/240));
		//writes the new converted currecny to the console to 2 decimal places
		System.out.print("That is ");
		screen.print(decimalCurrency, 2);
		System.out.println(" in decimal currency");

		//Assigns a new easyreader method to a variable in order to read from the text file money.txt
		EasyReader fileInput = new EasyReader("money.txt") ;
		//Reads the first line in the text file and assigns it to a variable
		String inputString = fileInput.readString();
		//Using the string obtained from the file the substring method extracts just the number from the file
		inputString = inputString.substring(26,inputString.length() -0) ;
		//The number is then converted from a string to a double in order to carry out calculations
		double stringValue = Double.valueOf(inputString);
		//creates new integer variables to represent and calculate the number of each type of coin used to represent the value
		int poundsOld = (int)stringValue;
		int shillingsOld = (int)((stringValue - poundsOld) / 0.05);
		//I used a shortened value to represent one pence in new money for calculations as the results tend towards infinity
		int penceOld = (int)((stringValue - poundsOld - (shillingsOld * 0.05)) / (0.0041666));
		//Outputs the number of each type of coin in old money the in an appropriate format
		System.out.println(stringValue + " in old money is " + "L" + poundsOld + "." + shillingsOld + "s" + "." + penceOld + "d");
		
		//Here I write the headings of the columns for the table format to the console
		System.out.println("    old    L  s  d");
		//Here I specify the number of characters assigned to each Variable output whilst right-justifying them in a table format
		screen.print(stringValue, 2 ,7 );
		screen.print(poundsOld, 5);
		screen.print(shillingsOld, 3);
		screen.println(penceOld, 3);
		
		//using the same method above i read the second value from the second line of the file
		double inputNum = fileInput.readDouble();
		//I then calculate the number of each type of coin used to represent this value
		poundsOld = (int)inputNum;
		shillingsOld = (int)((inputNum - poundsOld) / 0.05);
		penceOld = (int)((inputNum - poundsOld - (shillingsOld * 0.05)) / (0.0041666));
		screen.print(inputNum, 2 ,7 );
		screen.print(poundsOld, 5);
		screen.print(shillingsOld, 3);
		screen.print(penceOld, 3);
	}
}