package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import game.Run;

public class RegisterDialog extends JDialog
{
	//Constructor
	public RegisterDialog()
	{
		//Set up the dialog
		setTitle("Register User");
		this.setBounds(200, 200, 450, 350);
		GridLayout dialogLayout = new GridLayout(2,  1, 20, 20);
		this.setLayout(dialogLayout);
		
		//Make the empty panels
		GridLayout mainLayout = new GridLayout(3, 2, 10, 10);
		JPanel mainPanel = new JPanel(mainLayout);
		JPanel buttonPanel = new JPanel(dialogLayout);
		
		//Make the labels and the fields for user input
		JLabel userLabel = new JLabel("Username: ");
		userLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
		JTextField userField = new JTextField();
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		JPasswordField passwordField = new JPasswordField();
		JLabel error = new JLabel("");
		//Make the button to log in
		JButton login = new JButton("Register");
		login.addActionListener(new ActionListener() 
		{ 
			@Override
			//When the button is pressed attempt to login
			public void actionPerformed(ActionEvent e) 
			{
				//Check if the login is successful
				String password = String.valueOf(passwordField.getPassword());
				if(Run.register(userField.getText(), password))
				{
					//If login works, dispose of the dialog
					dispose();
				}else
				{
					//If log in fails, show an error message
					error.setText("Username Taken");
					revalidate();
					repaint();
				}
			}
		});
		//Add components to relevant panels
		mainPanel.add(userLabel);
		mainPanel.add(userField);
		mainPanel.add(passwordLabel);
		mainPanel.add(passwordField);
		
		buttonPanel.add(login);
		buttonPanel.add(error);
		
		//Add the panels to the dialog
		this.add(mainPanel);
		this.add(buttonPanel);
		//Paint and show the dialog
		revalidate();
		repaint();
		this.setVisible(true);
	}
}
