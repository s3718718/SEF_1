package view;

import java.awt.BorderLayout;
import javax.swing.JFrame; //imports JFrame library

import game.Board;
import game.Game;

public class ChessGui extends JFrame
{
	//Variables to hold the two panels for references
	private InfoPanel infoPanel;
	private BoardPanel boardPanel;

	//Constructor
	public ChessGui(int width, int length, Game game) 
	{
		//Set up the frame
		super("The Chess Game");
		this.setLayout(new BorderLayout(5, 5)); // set layout
		this.setLocationRelativeTo(null);
		this.setBounds(100, 100, 640, 480);
		//Ensure frame closes at program termination
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Make the panels providing the information needed
		infoPanel = new InfoPanel(game);
		boardPanel = new BoardPanel(width, length, game);

		//Add the panels to the frame
		this.add(infoPanel, BorderLayout.LINE_START);
		this.add(boardPanel, BorderLayout.CENTER);
		//Show the frame to the user
		this.setVisible(true);
	}

	//Getters
	public BoardPanel getBoardPanel()
	{
		return boardPanel;
	}
	
	public InfoPanel getInfoPanel()
	{
		return infoPanel;
	}
	
	//Method to disable the current game as a new one has started
	public void newGame()
	{
		this.setVisible(false);
		this.setEnabled(false);
	}
}