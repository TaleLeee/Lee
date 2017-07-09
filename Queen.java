package com.Lee;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Piece{
	public Queen(){
	}
	
	public Queen(String piece, boolean isWhite)
	{
		this(piece, isWhite, false);
		
	}
	public Queen(String piece, boolean isWhite, boolean hasMoved)
	{
		super(piece, isWhite, hasMoved);
		
	}
	
	public ImageView getPieceImageView(){
		if(this.isWhite == true)
		{
			Image wQueenImage = new Image("Image/white_queen.png");
		    ImageView wQueen = new ImageView(wQueenImage);
		    return wQueen;
		}
		else
		{
			Image bQueenImage = new Image("Image/black_queen.png");
		    ImageView bQueen = new ImageView(bQueenImage);
		    return bQueen;
		}

	}
	public String getPieceName(){
		return "Q";
	}
	
	public boolean isLegalMove(int i, int j, int x, int y)
	{
		return (x != i || y != j) && 
				((x-i == j-y || i-j == x-y) || 
						(x == i || y == j));
	}
}	
