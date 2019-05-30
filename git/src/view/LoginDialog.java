package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import game.Run;

public class LoginDialog extends JDialog
{
	//Constructor
	public LoginDialog()
	{
		//Set up the dialog
		setTitle("User Login");
		this.setBounds(200, 200, 450, 350);
		GridLayout dialogLayout = new GridLayout(2,  1, 20, 20);
		this.setLayout(dialogLayout);
		
		//Make the empty panels and layouts
		GridLayout mainLayout = new GridLayout(3, 2, 10, 10);
		JPanel mainPanel = new JPanel(mainLayout);
		JPanel buttonPanel = new JPanel(dialogLayout);
		
		//Set up the various labels and add padding to some
		JLabel userLabel = new JLabel("Username: ");
		userLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));
		JTextField userField = new JTextField();
		JComponent passwordLabel = new JLabel("Password: ");
		passwordLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		JPasswordField passwordField = new JPasswordField();
		JLabel error = new JLabel("");
		//Make the button
		JButton login = new JButton("Login");
		login.setSize(new Dimension(200, 100));
		login.addActionListener(new ActionListener() 
		{ 
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//Use the info in the fields to attempt to  login
				String password = String.valueOf(passwordField.getPassword());
				if(Run.login(userField.getText(), password))
				{
					//Dispose of the dialog if it works
					dispose();
				}else
				{
					//Show an error message to the user
					error.setText("Login Failed");
					revalidate();
					repaint();
				}
			}
		});
		//Add the components to the panels
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
