package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.Game;
import game.Run;

public class TurnDialog extends JDialog
{
	//Constructor
	public TurnDialog(MenuGUI gui)
	{
		//Set up the dialog
		setTitle("Submit Turns");
		this.setBounds(200, 200, 450, 350);
		GridLayout dialogLayout = new GridLayout(2,  1);
		this.setLayout(dialogLayout);
		
		//Make the empty panels
		GridLayout mainLayout = new GridLayout(4, 1);
		JPanel mainPanel = new JPanel(mainLayout);
		JPanel buttonPanel = new JPanel(dialogLayout);
		JPanel firstPanel = new JPanel(new GridLayout(1, 2));
		JPanel secondPanel = new JPanel(new GridLayout(1, 2));
		
		//Make the labels and input fields
		JLabel turnLabel1 = new JLabel("Wanted Turns: ");
		turnLabel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
		JLabel turnLabel2 = new JLabel("Wanted Turns: ");
		turnLabel2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
		JTextField turn1Field = new JTextField();
		JTextField turn2Field = new JTextField();
		JLabel error = new JLabel("");
		//Make the button to submit the input
		JButton login = new JButton("Submit");
		login.addActionListener(new ActionListener() 
		{ 
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Attempt to process the input
				if(Run.processTurn(turn1Field.getText(), turn2Field.getText()))
				{
					//If input is correct then start a game with the desired turns
					int turn = (Integer.parseInt(turn1Field.getText()) + 
							Integer.parseInt(turn2Field.getText())) / 2;
					gui.dispose();
					dispose();
					Game game = new Game(turn);
					game.runGame();
				}else
				{
					//If input is wrong, show the user an error message
					error.setText("Incorrect Input");
					revalidate();
					repaint();
				}
			}
		});
		//Add components to the relevant panels
		buttonPanel.add(login);
		buttonPanel.add(error);
		
		firstPanel.add(turnLabel1);
		firstPanel.add(turn1Field);
		
		secondPanel.add(turnLabel2);
		secondPanel.add(turn2Field);
		
		mainPanel.add(new JLabel("Player 1"));
		mainPanel.add(firstPanel);
		mainPanel.add(new JLabel("Player 2"));
		mainPanel.add(secondPanel);
		
		//Add the panels to the dialog
		this.add(mainPanel);
		this.add(buttonPanel);
		//Repaint and show the dialog
		revalidate();
		repaint();
		this.setVisible(true);
	}
}
