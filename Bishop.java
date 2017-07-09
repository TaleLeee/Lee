package com.Lee;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Piece{
	public Bishop()
	{
	}
	
	public Bishop(String piece, boolean isWhite)
	{
		this(piece, isWhite, false);
		
	}
	
	public Bishop(String piece , boolean isWhite, boolean hasMoved)
	{
		super(piece, isWhite, hasMoved);
		
	}
	
	public String getPieceName()
	{
		return "B";
	}
	
	public boolean isLegalMove(int i, int j, int x, int y)
	{
		if((x + y) == (i + j))
		{
			return true;
		}
		else if(Math.abs(((i + j) - (x + y))) % 2 == 0)
		{
			return true;
		}
		else 
			return false;
	}

} 
