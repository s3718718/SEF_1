package game;

import java.util.*;

import view.TurnDialog;
import view.MenuGUI;


public class Run 
{
	//Number of Players in the game
	public final static int NUM_PLAYERS = 2;
	
	//Array to hold the made accounts
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	//How many players are logged in
	private static int loggedIn;
	//Number of turns the game will have
	private static int turn = 0;
	//Reference to the main menu GUI
	private static MenuGUI gui;
	
	//Main method
	public static void main(String[] args) 
	{
		//Instantiate some values
		loggedIn = 0;
		boolean gameStart = false;
		//Open the main menu up
		gui = new MenuGUI();
		//Check if the game can start
		while (!gameStart)
		{
			//Check there are the correct number of players
			if(loggedIn == NUM_PLAYERS)
			{
				//Check for legal number of turns
				if(turn > 0)
				{
					gameStart = true;
				}
			}
		}
	}
	
	//Getter for the number of players logged in
	public int getLoggedIn()
	{
		return loggedIn;
	}
	
	//Method to login using the credentials provided
	public static boolean login(String user, String password)
	{
		//Boolean to see if the login succeeded
		boolean loginPass = false;
		//Check every account
		for(int i = 0; i < accounts.size(); i++)
		{
			//Check if the credentials match
			Account account = accounts.get(i); 
			if((account.getUsername()).equals(user))
			{
				if((account.getPassword()).equals(password))
				{
					if(account.getLoggedIn() == false)
					{
						//Log them in
						loggedIn++;
						accounts.get(i).setLoggedIn(true);
						loginPass = true;
					}
				}
			}
		}
		//Check for the correct number of players
		if(loggedIn == NUM_PLAYERS)
		{
			//Get the players inpt for their desired number of turns
			new TurnDialog(gui);
		}
		return loginPass;
	}
	
	//Method to register an account using the credentials
	public static boolean register(String user, String password)
	{
		boolean registered = false;
		boolean userCheck = true;
		//Check all of the accounts
		for(int i = 0; i < accounts.size(); i++)
		{
			//Check if the username is taken
			Account account = accounts.get(i); 
			if((account.getUsername()).equals(user))
			{
				userCheck = false;
			}
		}
		//If the username is unique
		if(userCheck)
		{
			//Make an account and add it to the array
			accounts.add(new Account(user, password));
			registered = true;
		}
		return registered;
	}
	
	//Method to process the desired number of turns
	public static boolean processTurn(String turn1, String turn2)
	{
		//Boolean to check if the processing is correct
		boolean turnCheck = false;
		//Validate the input is correct
		Validate test = new Validate();
		int turnWanted1 = test.isPositiveInt(turn1);
		int turnWanted2 = test.isPositiveInt(turn2);
		//Add numbers together for the turns
		turn = (turnWanted1 + turnWanted2) / 2;
		//Check the turn for correctness
		if(turn > 0 && turnWanted1 > 0 && turnWanted2 > 0)
		{
			turnCheck = true;
		}
		return turnCheck;
	}
}
