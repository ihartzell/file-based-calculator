import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
public class FileBluePrintCalculator 
{
	private double currentValue; 												// Field Variable Private to this class.
	ArrayList<String> myArrayOfStringObjects = new ArrayList < > ();			// The ArrayList creates an array of String objects from the 																		
	double operand1;															// myArrayOfStringObjects
		
	FileBluePrintCalculator()													// Constructor, It essentially constructs objects for the class.
	{
		currentValue = 0.0;	
		myArrayOfStringObjects.add("Initial value is 0");			// I put this here simply so it shows in the file what the initial value is.
	}
	
	public static int displayMenu()
	{
		Scanner userInput = new Scanner(System.in);
		int numberChoice;
		System.out.println("Menu");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Clear ");
		System.out.println("6. Quit \n");
		System.out.print("What would you like to do? Pick a number 1-6:");
		numberChoice = userInput.nextInt();
		
		while (numberChoice < 1 || numberChoice > 6)	// Menu Validation
		{
			System.out.println("I'm sorry," + numberChoice + " wasn't one of the options.\n");
			System.out.println("Menu");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Clear ");
			System.out.println("6. Quit \n");
			System.out.print("What would you like to do? Pick a number 1-6:");
			numberChoice = userInput.nextInt();
		}
			
		return numberChoice;
	}

	public static double getOperand(String prompt)	// Function prints out prompts,
	{
		Scanner userInput = new Scanner(System.in);
		
		double operand = 0;									// initialized to zero so the try block would work.
		
		System.out.print(prompt );
		
		try													// try catch block basically works like this, it'll try what I want it to and if the
		{													// user inputs a different data type for a variable and the program crashes and gives
			operand = userInput.nextDouble();				//	an exception, the catch part catches the exception and prints a nice message.		
		}													
		
		catch(InputMismatchException e)
		{
			System.out.println("Something went wrong chief, make sure you enter a number.");
		}
		
		return operand;
	}
	
	public double getCurrentValue()
	{
		return currentValue;
	}
	
	public void setCurrentValue(double currentValue) 
	{
		this.currentValue = currentValue;	// the "this" keyword points to the field variable, saying this "thing,"
	}										// aka currentValue is set to currentValue.
	
	public void add(double operand2)
	{
		operand1 = currentValue;								// operand1 = currentValue,This is so I have the initial currentValue  
		operand2 = getOperand("What is the second number?");	// for when I output the string  representation. I need three variables, thus
		currentValue += operand2;								// operand1, operand2, currentValue.
		
		String stringRepresentation = new String(operand1 + " + "  + operand2 + " =" + " " + currentValue );
		myArrayOfStringObjects.add(stringRepresentation);	
	}
	
	public void subtract(double operand2)
	{
		operand1 = currentValue;	
		operand2 = getOperand("What is the second number?");
		currentValue -= operand2;
		
		String stringRepresentation = new String(operand1 + " - "  + operand2 + " =" + " " + currentValue );
		myArrayOfStringObjects.add(stringRepresentation);	
	}
	
	public void multiply(double operand2)
	{
		operand1 = currentValue;
		operand2 = getOperand("What is the second number?");
		currentValue *= operand2;	
		
		String stringRepresentation = new String(operand1 + " * "  + operand2 + " =" + " " + currentValue );
		myArrayOfStringObjects.add(stringRepresentation);
	}
	
	public void divide(double operand2)
	{
		operand1 = currentValue;
		operand2 = getOperand("What is the second number?");
		currentValue /= operand2;
		
		if(operand2 < 0 || operand2 > 0)						// I did this so I wouldn't have both cases of operand2 display in the file.
		{
			String stringRepresentation = new String(operand1 + " / "  + operand2 + " =" + " " + currentValue );
			myArrayOfStringObjects.add(stringRepresentation);
		}
		
		else if (operand2 == 0.0)
		{
			 currentValue = Double.NaN;
			 String stringRepresentationNan = new String(operand1 + " / "  + operand2 + " =" + " " + currentValue );
			 myArrayOfStringObjects.add(stringRepresentationNan);
		}
	}
	
	public void clear()
	{
		currentValue = 0.0;
		myArrayOfStringObjects.add("Cleared");
	}
}
