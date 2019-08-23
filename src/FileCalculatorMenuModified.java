import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.InputMismatchException;
import javax.swing.JFrame;

public class FileCalculatorMenuModified extends FileBluePrintCalculator	// This is an extension or subclass of FileBluePrintCalculator
{
	
	public static int displayMenu()	// Overridden Menu
	{
		
		Scanner userInput = new Scanner(System.in);
		int numberChoice;
		System.out.println("Menu");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Clear ");
		System.out.println("6. Save ");		// Option added
		System.out.println("7. Quit \n");
		System.out.print("What would you like to do? Pick a number 1-6:");
		numberChoice = userInput.nextInt();
			
		while (numberChoice < 1 || numberChoice > 7)							// Menu validation
		{
			System.out.println("I'm sorry," + numberChoice + " wasn't one of the options.\n");
			System.out.println("Menu");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Clear ");
			System.out.println("6. Save ");
			System.out.println("7. Quit \n");
			System.out.print("What would you like to do? Pick a number 1-6:");
			numberChoice = userInput.nextInt();		
		}
			return numberChoice;
		
	}
	public void fileSave()										// Method handles everything relating to the saving to a file and JFilerChooser.
	{
		JFrame parentFrame = new JFrame();							// This is essentially the java frame for JFileChooser, and I'm creating								
		parentFrame.setAlwaysOnTop(true);							// an object from that class to allow me to pass
																	// into the setAlwaysOnTop method true, this makes it so the JFileChooser
		File from = null;											// Will not show behind eclipse.										
		File to = null;
		
		JFileChooser fileChooserMenu = new JFileChooser();							// JFileChooser Class to allow the pop up JFileChooser menu.
		
			int returnVal = fileChooserMenu.showOpenDialog(parentFrame);
		
				if( returnVal == JFileChooser.APPROVE_OPTION)						// If user selects the approve option, I get the selected
				{																	// file and that's stored in from.
					from = fileChooserMenu.getSelectedFile();
				}
				returnVal = fileChooserMenu.showSaveDialog(null);
		
				if (returnVal == JFileChooser.APPROVE_OPTION)						// If user selects the approve option, I get the selected			
				{																	// file and that's stored in to.
					to = fileChooserMenu.getSelectedFile();							
				}
		
		if (from == null || to == null)										// If the user doesn't select a file from or to then error message.
		{
			System.out.println("An issue occured.. and the file couldn't be initiated.");
			System.exit(-1);
		}
		
		Scanner input = null;															// Scanner for reading in
		PrintWriter output = null;														// PrintWriter is for writing to file.

		try
		{
			input = new Scanner(from);
			output = new PrintWriter(to);
			
			for (int i = 0; i < myArrayOfStringObjects.size(); i++)	// Iterates through the array list and only prints the elements of
			{														// array list thus, it won't have the brackets show. [ , ].
				output.println(myArrayOfStringObjects.get(i));
				output.println("\n");
			}
			
			while(input.hasNext())
			{
				String current = input.nextLine();
				output.println(current);
			}
			 System.out.println("Data successfully saved to a file!");
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("Something went wrong! please try again.");
		}
		
		finally
		{
			input.close();
			output.close();
		}
		
	}
	
	
}
