package com.Lee;

public class Openfield extends Piece{
	public Openfield(){
		
	}
	
	public Openfield(String piece)
	{
		super(piece);
	}
	
	public String getPieceName(){
		return "null";
	}
	 
	public boolean isLegalMove(int i, int j ,int x,int y)
	{
		return true;
	}
}
