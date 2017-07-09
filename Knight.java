package com.Lee;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece{
	public Knight()
	{
	}
	
	public Knight(String piece, boolean isWhite)
	{
		this(piece, isWhite, false);
		
	}
	
	public Knight(String piece, boolean isWhite, boolean hasMoved)
	{
		super(piece, isWhite, hasMoved);
		
	}
	
	public String getPieceName()
	{
		return "Kn";
	}
	
	public boolean isLegalMove(int i, int j, int x, int y)
	{
		if(this.getIsWhite())
		{
			if(((x == i + 1) || (x == i - 1)) && 
					(y == j - 2))
			{
				return true;
			}
			else
				return false;
		}
		else if(!this.getIsWhite())
		{
			if(((x == i + 1) || (x == i - 1)) && 
					(y == j + 2))
			{
				return true;
			}
			else
				return false;
		}
		else 
			return false;
	}
}

