package view;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuGUI extends JFrame
{
	//Constructor
	public MenuGUI() 
	{
		super("The Chess Game");
		this.setLocationRelativeTo(null);
		this.setBounds(100, 100, 420, 240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure Frame Closes
		
		//Make the panel for the buttons
		this.setLayout(new GridLayout(2, 1));
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//Make the button to login the user
		JButton logButton = new JButton("Login");
		logButton.addActionListener(new ActionListener() 
		{ 
			@Override
			//When button is clicked make a dialog to login the user
			public void actionPerformed(ActionEvent e) 
			{
				LoginDialog login = new LoginDialog();
			}
		});
		//Make the button to register a user
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() 
		{ 
			@Override
			//When button is clicked make a dialog to register the user
			public void actionPerformed(ActionEvent e) 
			{
				RegisterDialog register = new RegisterDialog();
			}
		});
		
		//Add components to the panel
		mainPanel.add(logButton);
		mainPanel.add(registerButton);
		
		//Add components to the Frame
		this.add(new JLabel("Welcome to the Chess Game", SwingConstants.CENTER));
		this.add(mainPanel);
		this.revalidate();
		//Repaint the frame and show it
		this.repaint();
		this.setVisible(true); // makes frame visible
	}
}
