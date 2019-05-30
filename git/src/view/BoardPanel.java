package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import game.Game;
import game.Tile;
import piece.Piece;

public class BoardPanel extends JPanel
{
	//Size of the piece images - Scale to
	public final int IMAGE_SIZE = 60;
	
	//Grid of buttons to represent the board
	JButton[][] grid;
	//The width and length of the board
	private int width;
	private int length;
	
	//Constructor
	public BoardPanel(int width, int length, Game game)
	{
		//Instantiate values
		this.width = width;
		this.length = length;
		this.setLayout(new GridLayout(width, length)); // set layout of the panel
		this.grid = new JButton[width][length];
		Border buttonBorder = new LineBorder(Color.black, 1); // border for the buttons
		//Generate the buttons in the grid
		for (int y = 0; y < length; y++) 
		{
			for (int x = 0; x < width; x++) 
			{
				//Make the button and add listener
				grid[x][y] = new JButton();
				grid[x][y].setBorder(buttonBorder);
				grid[x][y].addActionListener(new addActionListener(game, x, y));
				//Create grid pattern
				if(y%2 == 0)
				{
					if(x%2 == 0)
					{
						grid[x][y].setBackground(Color.darkGray);
					}
				}else
				{
					if(x%2 == 1)
					{
						grid[x][y].setBackground(Color.darkGray);
					}
				}
				//Add the button to the grid
				this.add(grid[x][y]);
			}
		}
		//Place the pieces initially
		pieceIntialPlace();
		//Repaint the entire panel
		this.revalidate();
		this.repaint();
	}
	
	//Method to initially place the pieces
	private void pieceIntialPlace()
	{
		//Go over the entire board
		for(int y = 0; y < length; y++)
		{
			for(int x = 0; x < width; x++)
			{
				//White Side - Start
				if(y == 0)
				{
					//Rook
					if(x == 0 || x == 5)
					{
						ImageIcon pieceImage = new ImageIcon("resources/white-rook.png");
						pieceImage = scaleImage(IMAGE_SIZE,  IMAGE_SIZE, pieceImage);
						grid[x][y].setIcon(pieceImage);
					} //Bishop
					if(x == 1 || x == 4)
					{
						ImageIcon pieceImage = new ImageIcon("resources/white-bishop.png");
						pieceImage = scaleImage(IMAGE_SIZE,  IMAGE_SIZE, pieceImage);
						grid[x][y].setIcon(pieceImage);
					} //Knight
					if(x == 2 || x == 3)
					{
						ImageIcon pieceImage = new ImageIcon("resources/white-knight.png");
						pieceImage = scaleImage(IMAGE_SIZE,  IMAGE_SIZE, pieceImage);
						grid[x][y].setIcon(pieceImage);
					} //Black Side - Start
				}else if(y == 5)
				{
					//Rook
					if(x == 0 || x == 5)
					{
						ImageIcon pieceImage = new ImageIcon("resources/black-rook.png");
						pieceImage = scaleImage(IMAGE_SIZE,  IMAGE_SIZE, pieceImage);
						grid[x][y].setIcon(pieceImage);
					} //Bishop
					if(x == 1 || x == 4)
					{
						ImageIcon pieceImage = new ImageIcon("resources/black-bishop.png");
						pieceImage = scaleImage(IMAGE_SIZE,  IMAGE_SIZE, pieceImage);
						grid[x][y].setIcon(pieceImage);
					} //Knight
					if(x == 2 || x == 3)
					{
						ImageIcon pieceImage = new ImageIcon("resources/black-knight.png");
						pieceImage = scaleImage(IMAGE_SIZE,  IMAGE_SIZE, pieceImage);
						grid[x][y].setIcon(pieceImage);
					}
				}
			}
		}
	}
		
	//Method to move a piece on the GUI only
	public void pieceMove(Piece piece, Tile targetTile)
	{
		//Remove previous position
		removePiece(piece.getTile());
		//Get the image to display
		ImageIcon pieceImage = piece.display();
		//Scale the piece image
		pieceImage = scaleImage(IMAGE_SIZE, IMAGE_SIZE, pieceImage);
		//Set the image in place on the new position
		grid[targetTile.getYPosition()][targetTile.getXPosition()].setIcon(pieceImage);
		//Repaint the grid
		revalidate();
		repaint();
	}
		
	//Method to remove a piece from the grid GUI only
	public void removePiece(Tile tile)
	{
		//Remove the image
		grid[tile.getYPosition()][tile.getXPosition()].setIcon(null);
		//Repaint the grid
		revalidate();
		repaint();
	}

	//Method to highlight all of the tiles the piece can move to
	public void highlightMoves(ArrayList<Tile> moveList)
	{
		//Make a new border
		Border buttonBorder = new LineBorder(Color.green, 3);
		//Highlight the tile of each move
		for(int i = 0; i < moveList.size(); i++)
		{
			Tile tile = moveList.get(i);
			int xPosition = tile.getXPosition();
			int yPosition = tile.getYPosition();
			grid[yPosition][xPosition].setBorder(buttonBorder);
		}
		//Repaint the grid
		revalidate();
		repaint();
	}
		
	//Method to clear all of the hightlights on the tiles
	public void clearHighlightMoves(ArrayList<Tile> moveList)
	{
		//Get the old border
		Border buttonBorder = new LineBorder(Color.black, 1);
		//Clear the highlight of each move
		for(int i = 0; i < moveList.size(); i++)
		{
			Tile tile = moveList.get(i);
			int xPosition = tile.getXPosition();
			int yPosition = tile.getYPosition();
			grid[yPosition][xPosition].setBorder(buttonBorder);
		}
		//Repaint the grid
		revalidate();
		repaint();
	}
		
	//Method to scale an imageicon
	private ImageIcon scaleImage(int width, int height, ImageIcon origImage)
	{
		//Convert the imageicon to an image
		Image converter = origImage.getImage();
		//scale the image smoothly
		Image usedImage = converter.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		//Return the image to an imageicon (now scaled)
		return new ImageIcon(usedImage);
	}
}
