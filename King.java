package com.Lee;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class King extends Piece{
	public King(){
	}
	
	public King(String piece, boolean isWhite){
		this(piece, isWhite, false);
	}
	
	public King(String piece, boolean isWhite, boolean hasMoved)
	{
		super(piece, isWhite, hasMoved);
	}
	
	
	
	public String getPieceName()
	{
		return "K";
	}
	
	public boolean isLegalMove(int i, int j, int x, int y)
	{
		if(x == i + 1)
		{
			if(y == j + 1 || y == j || y ==j - 1)
			{
				return true;
			}
			else 
				return false;
		}
		else if(x == i - 1)
		{
			if(y == j + 1 || y == j || y == j - 1)
			{
				return true;
			}
			else
				return false;
		}
		else if(y == j + 1)
		{
			if(x == i || x == i - 1 || x == i + 1)
			{
				return true;
			}
			else
				return false;
		}
		else if(y == i - 1)
		{
			if(x == i || x == i - 1 || x == i + 1)
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

