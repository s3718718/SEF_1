package game;

public class Account
{
	//Details of the Account
	private String username;
	private String password;
	//Whether the user is currently logged in or not
	private boolean loggedIn;
	
	//Constructor
	public Account(String id, String password)
	{
		this.username = id;
		this.password = password;
		loggedIn = false;
	}
	
	//Getters and Setters
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public boolean getLoggedIn()
	{
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn)
	{
		this.loggedIn = loggedIn;
	}
}
