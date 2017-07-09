package com.Lee;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece{
	public Rook(){
	}
	
	public Rook(String piece, boolean isWhite)
	{
		this(piece, isWhite, false);
	}
	
	public Rook(String piece, boolean isWhite, boolean hasMoved)
	{
		super(piece, isWhite, hasMoved);
	}
	
	
	public String getPieceName(){
		return "R";
	}
	
	public boolean isLegalMove(int i, int j, int x, int y)
	{
		if(x == i )
		{
			return true;
		}
		else if(y == j)
		{
			return true;
		}
		else
			return false;
	}
}

