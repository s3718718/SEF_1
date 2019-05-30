package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Game;

public class GameDialog extends JDialog
{	
	//Constructor
	public GameDialog(Game game)
	{
		//Set up the dialog
		setTitle("Game Over");
		this.setBounds(200, 200, 450, 350);
		GridLayout dialogLayout = new GridLayout(2,  1);
		this.setLayout(dialogLayout);
		
		//Make the panels and the layouts
		GridLayout infoLayout = new GridLayout(7, 1);
		JPanel infoPanel = new JPanel(infoLayout);
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		//Add a yes button and a listener to start a new game up
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(new ActionListener() 
		{ 
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Game newGame = new Game(game.getTurns());
				game.getGUI().newGame();
				dispose();
				newGame.runGame();
			}
		});
		//Make a no button and a listener to terminate the program
		JButton noButton = new JButton("No");
		noButton.addActionListener(new ActionListener() 
		{ 
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
				game.getGUI().dispose();
			}
		});
		
		//Get Scores and the overall winner
		int player1Score = game.getPlayer1().getScore();
		int player2Score = game.getPlayer2().getScore();
		String gameWinner = "";
		if(player1Score == player2Score)
		{
			gameWinner = "The Game ends in a Draw";
		}else if(player1Score > player2Score)
		{
			gameWinner = "White Side Wins the Game";
		}else
		{
			gameWinner = "Black Side Wins the Game";
		}
		
		//Add winner and scores to a panel
		infoPanel.add(new JLabel("Game Done", SwingConstants.CENTER));
		infoPanel.add(new JLabel("The Final Scores are", SwingConstants.CENTER));
		infoPanel.add(new JLabel("White Side at " + player1Score
				, SwingConstants.CENTER));
		infoPanel.add(new JLabel("Black Side at " + player2Score
				, SwingConstants.CENTER));
		infoPanel.add(new JLabel(gameWinner, SwingConstants.CENTER));
		infoPanel.add(new JLabel());
		infoPanel.add(new JLabel("Do you want to play another Game?"
				, SwingConstants.CENTER));
		
		//Add Buttons to a panel
		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		
		//Add the panels and show the dialog
		this.add(infoPanel);
		this.add(buttonPanel);
		this.setVisible(true);
	}
}
