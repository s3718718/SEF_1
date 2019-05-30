package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;

public class addActionListener implements ActionListener 
{
	//Reference to the current game
	Game game;
	//The position of the button attached
	int x;
	int y;
	
	//Constructor
	public addActionListener(Game game, int x, int y) 
	{
		//Instantiate values
		this.game = game;
		this.x = x;
		this.y = y;
	}
	
	@Override
	//The button is clicked
	public void actionPerformed(ActionEvent e) 
	{
		//Select or move a piece
		game.selectOrMovePiece(x, y);
	}

}
