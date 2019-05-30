package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;

public class InfoPanel extends JPanel
{
	//Variables to hold the turn timer and the players scores
	private JLabel turnLabel;
	private JLabel scoreBoard2;
	private JLabel scoreBoard3;
	
	//Constructor
	public InfoPanel(Game game)
	{
		//Set up the panel
		this.setSize(100, 480);
		this.setLayout(new GridLayout(10, 1)); // set layout
		
		//Make a 'title' label for the section
		JLabel title = new JLabel("Welcome to the Chess Game");
		
		//Set up the turn timer
		int turns = game.getTurns();
		int currentTurn = game.getCurrentTurn();
		turnLabel = new JLabel("Turn " + currentTurn + " / " + turns);
		
		//Set up the scoreboard part of the panel
		int score1 = game.getPlayer1().getScore();
		int score2 = game.getPlayer2().getScore();
		JLabel scoreBoard1 =  new JLabel("Scoreboard");
		scoreBoard2 = new JLabel("White Side at " + score1);
		scoreBoard3 = new JLabel("Black Side at " + score2);
		
		//Add the components to the panel and paint it
		add(title);
		add(turnLabel);
		add(scoreBoard1);
		add(scoreBoard2);
		add(scoreBoard3);
		revalidate();
		repaint();
	}
	
	//Method to update the turn counter
	public void updateTurn(int turns, int currentTurn)
	{
		turnLabel.setText("Turn " + currentTurn + " / " + turns);
		revalidate();
		repaint();
	}
	
	//Method to update the score
	public void updateScore(int score1, int score2)
	{
		scoreBoard2.setText("White Side at " + score1);
		scoreBoard3.setText("Black Side at " + score2);
		revalidate();
		repaint();
	}
}
