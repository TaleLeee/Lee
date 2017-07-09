package com.Lee;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece{
	boolean canMove;
	
	public Pawn(){
	}
	
	public Pawn(String piece, boolean isWhite)
	{
		this(piece, isWhite, false);
	}
	
	public Pawn(String piece, boolean isWhite, boolean hasMoved)
	{
		super(piece, isWhite, hasMoved);
		
	}
	
	public String getPieceName(){
		return "P";
	}
	
//	public boolean isLegalMove(int i, int j, int x, int y)
//    {
//        if(!this.getIsWhite())
//            if(i == x && (j+1 == y || (j+2 == y && !this.getHasMoved())) || (j == y-1 && (i == x-1 || i == x+1)))
//                return true;
//        if(this.getIsWhite())
//            if(i == x && (j-1 == y || (j-2 == y && !this.getHasMoved())) || (j == y+1 && (i == x-1 || i == x+1)))
//                return true;
//        return false;
//    }

	
}

