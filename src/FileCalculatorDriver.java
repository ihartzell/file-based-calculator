import java.util.Scanner;

public class FileCalculatorDriver 
{

	public static void main(String[] args) 
	{
		int numberChoice = 0;
		double operand2 = 0;	
		
		FileCalculatorMenuModified primaryProgramObj = new FileCalculatorMenuModified();		// primaryProgramObj variable is the new object 		
																								// created from the super class.
		do																				
		{
			System.out.println("The current value is " + primaryProgramObj.getCurrentValue() + "\n");
			
			numberChoice = primaryProgramObj.displayMenu();
				
			if (numberChoice == 1)
			{
				primaryProgramObj.add(operand2);
			}
				
			else if (numberChoice == 2)
			{
				primaryProgramObj.subtract(operand2);
			}
				
			else if (numberChoice == 3)
			{
				primaryProgramObj.multiply(operand2);
			}
				
			else if (numberChoice == 4)
			{
				primaryProgramObj.divide(operand2);
			}
				
			else if (numberChoice == 5)
			{
				primaryProgramObj.clear();
			}
			
			else if (numberChoice == 6)
			{
				primaryProgramObj.fileSave();
			}
			
			else if (numberChoice == 7)	// Exit
			{
				System.out.println("Goodbye! Thank you for using Isaac's calculator.");	
			}
				
		}while(numberChoice >=1 && numberChoice <= 6);


	}

}
