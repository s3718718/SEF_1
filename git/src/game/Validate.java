package game;
public class Validate
{
	//Method to turn a String input into a positive integer
	int isPositiveInt(String input)
	{
		int number;
		//Check if the string is an integer or not
		if (tryParseInt(input) == true)
		{
			//Convert the number to an integer
			number = Integer.parseInt(input);
			if (number < 0)
			{
				//Integer is negative so return -1
				number =-1;
			}
		}
		else
		{
			//String is not an integer so return -1
			number = -1;
		}
		return number;
	}
	
	//Method to test if the string can be converted into an integer
	boolean tryParseInt(String string)
	{
		try
		{
			Integer.parseInt(string);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
}
