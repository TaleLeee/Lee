package com.Lee;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class ChessBoard {
	private final Image WHITEPAWN = new Image("Image/white_pawn.png");
    private final Image BLACKPAWN = new Image("Image/black_pawn.png");
    private final Image WHITEKING = new Image("Image/white_king.png");
    private final Image BLACKKING = new Image("Image/black_king.png");
    private final Image WHITEQUEEN = new Image("Image/white_queen.png");
    private final Image BLACKQUEEN = new Image("Image/black_queen.png");
    private final Image WHITEROOK = new Image("Image/white_rook.png");
    private final Image BLACKROOK = new Image("Image/black_rook.png");
    private final Image WHITEKNIGHT = new Image("Image/white_knight.png");
    private final Image BLACKKNIGHT = new Image("Image/black_knight.png");
    private final Image WHITEBISHOP = new Image("Image/white_bishop.png");
    private final Image BLACKBISHOP = new Image("Image/black_bishop.png");
    private final Image OPENFIELD = new Image("Image/open_field.png");
    private final Image OPENFIELD1 = new Image("Image/open_field1.png");
	private  Piece[][] piece = new Piece[8][8];
	private Rectangle[][] rectangle = new Rectangle[8][8];
	private  GridPane chessPane = new GridPane();

	int coloumn;
	int row;
	int a;
	int b;
	int i;
	int j;
	public static TextArea textField = new TextArea();
	//建立棋盘
	public ChessBoard(){
		
		for(i = 0; i < 8; i++)
		{
			for(j = 0; j < 8; j++)
			{	
				if(i % 2 == 0)
				{
					if(j % 2 == 0)
					{
						rectangle[i][j] = new Rectangle();
						rectangle[i][j].setFill(Color.GOLD);
						rectangle[i][j].setHeight(100);
						rectangle[i][j].setWidth(100);
					}
					else
					{
						rectangle[i][j] = new Rectangle();
						rectangle[i][j].setFill(Color.GRAY);
						rectangle[i][j].setHeight(100);
						rectangle[i][j].setWidth(100);
					}
				}
				else if(i % 2 == 1)
				{
					if(j % 2 == 1)
					{
						rectangle[i][j] = new Rectangle();
						rectangle[i][j].setFill(Color.GOLD);
						rectangle[i][j].setHeight(100);
						rectangle[i][j].setWidth(100);
					}
					else
					{
						rectangle[i][j] = new Rectangle();
						rectangle[i][j].setFill(Color.GRAY);
						rectangle[i][j].setHeight(100);
						rectangle[i][j].setWidth(100);
					}
				}
				
			}
		}
		
	}
	//将棋盘放入GridPane 并返回该GridPane
	public GridPane addRectangle(){
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		for(i = 0; i < 8; i++)
		{
			for(j = 0; j < 8; j ++)
			{
				gridPane.add(rectangle[i][j], j, i);
			}
		}
		return gridPane;
	}
	
	public GridPane chess() throws IOException {
		
		for(i = 0; i < 8; i++) {
	        ColumnConstraints column = new ColumnConstraints(100);
	        chessPane.getColumnConstraints().add(column);
	    }

	    for( i = 0; i < 8; i++) {
	        RowConstraints row = new RowConstraints(100);
	        chessPane.getRowConstraints().add(row);
	    }
	    chessPane.setMaxHeight(800);
	    chessPane.setMaxWidth(800);
	    
		for (int i = 0; i < 8; i++)
        {
            piece[i][1] = new Pawn("bPawn", false);
            piece[i][1].setImage(BLACKPAWN);
            chessPane.add(piece[i][1].getImageView(), i, 1);
            piece[i][6] = new Pawn("wPawn", true);
            piece[i][6].setImage(WHITEPAWN);
            chessPane.add(piece[i][6].getImageView(), i, 6);
        }
        piece[0][0] = new Rook("bRook", false, false);//车
        piece[0][0].setImage(BLACKROOK);
        chessPane.add(piece[0][0].getImageView(), 0, 0);
        piece[7][0] = new Rook("bRook", false, false);
        piece[7][0].setImage(BLACKROOK);
        chessPane.add(piece[7][0].getImageView(), 7, 0);
        piece[0][7] = new Rook("wRook", true, false);
        piece[0][7].setImage(WHITEROOK);
        chessPane.add(piece[0][7].getImageView(), 0, 7);
        piece[7][7] = new Rook("wRook", true, false);
        piece[7][7].setImage(WHITEROOK);
        chessPane.add(piece[7][7].getImageView(), 7, 7);
        piece[1][0] = new Knight("bKnight", false);//ma
        piece[1][0].setImage(BLACKKNIGHT);
        chessPane.add(piece[1][0].getImageView(), 1, 0);
        piece[6][0] = new Knight("bKnight", false);
        piece[6][0].setImage(BLACKKNIGHT);
        chessPane.add(piece[6][0].getImageView(), 6, 0);
        piece[1][7] = new Knight("wKnight", true);
        piece[1][7].setImage(WHITEKNIGHT);
        chessPane.add(piece[1][7].getImageView(), 1, 7);
        piece[6][7] = new Knight("wKnight", true);
        piece[6][7].setImage(WHITEKNIGHT);
        chessPane.add(piece[6][7].getImageView(), 6, 7);
        piece[2][0] = new Bishop("bBishop", false);//xiang
        piece[2][0].setImage(BLACKBISHOP);
        chessPane.add(piece[2][0].getImageView(), 2, 0);
        piece[5][0] = new Bishop("bBishop", false);
        piece[5][0].setImage(BLACKBISHOP);
        chessPane.add(piece[5][0].getImageView(), 5, 0);
        piece[2][7] = new Bishop("wBishop", true);
        piece[2][7].setImage(WHITEBISHOP);
        chessPane.add(piece[2][7].getImageView(), 2, 7);
        piece[5][7] = new Bishop("wBishop", true);
        piece[5][7].setImage(WHITEBISHOP);
        chessPane.add(piece[5][7].getImageView(), 5, 7);
        piece[3][0] = new Queen("bQueen", false);
        piece[3][0].setImage(BLACKQUEEN);
        chessPane.add(piece[3][0].getImageView(), 3, 0);
        piece[3][7] = new Queen("wQueen", true);
        piece[3][7].setImage(WHITEQUEEN);
        chessPane.add(piece[3][7].getImageView(), 3, 7);
        piece[4][0] = new King("bKing", false, false);
        piece[4][0].setImage(BLACKKING);
        chessPane.add(piece[4][0].getImageView(), 4, 0);
        piece[4][7] = new King("wKing", true, false);
        piece[4][7].setImage(WHITEKING);
        chessPane.add(piece[4][7].getImageView(), 4, 7);
        for(a = 0; a < 8; a++)
        {
        	for(b = 2; b < 6; b++)
        	{
        		piece[a][b] = new Openfield();
        		piece[a][b].setImage(OPENFIELD);
        	}
        }
       
        
        
	
        	piece[0][6].getImageView().setOnMouseClicked(e ->{
        	
        		  if(!piece[0][6].getHasMoved())
        		  {
        			  piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].getImageView(), 0, chessPane.getRowIndex(piece[0][6].getImageView()) - 1);
	                    piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                    	
	                    	chessPane.getChildren().removeAll(
	                        		piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 2].getImageView(),
	                                piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[0][6].getPieceName() + "" + "5" +
	                    		"0" + "->\n");
	                    	chessPane.add(piece[0][6].getImageView(), 0, chessPane.getRowIndex(piece[0][6].getImageView()) - 1);
	                    	
	                    });
                      piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 2] = new Openfield();
	                  piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 2].setImage(OPENFIELD);
	                  chessPane.add(piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 2].getImageView(), 0, chessPane.getRowIndex(piece[0][6].getImageView()) - 2);
	                    piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 2].getImageView(),
	                                piece[0][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[0][6].getPieceName() + "" + "4" + 
	                    		"0" + "->\n");
	                    	chessPane.add(piece[0][6].getImageView(), 0, chessPane.getRowIndex(piece[0][6].getImageView()) - 2);
	                    });
	                    textField.setText(textField.getText() + "white" +
	                    		piece[0][6].getPieceName() + "" + (chessPane.getRowIndex(piece[0][6].getImageView())) + "" +
                    		(chessPane.getColumnIndex(piece[0][6].getImageView()) ) + "->\n");
	                   piece[0][6].setHasMoved(true);
      		  }
      		  else if(piece[0][6].getHasMoved())
      		  {
      			  piece[chessPane.getColumnIndex(piece[0][6].getImageView())][chessPane.getRowIndex(piece[0][6].getImageView()) - 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[0][6].getImageView())][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[0][6].getImageView())][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[0][6].getImageView()), chessPane.getRowIndex(piece[0][6].getImageView()) - 1);
	                    piece[chessPane.getColumnIndex(piece[0][6].getImageView())][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                    	
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[0][6].getImageView())][chessPane.getRowIndex(piece[0][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[0][6].getPieceName() + "" + (chessPane.getRowIndex(piece[0][6].getImageView()) - 1) + "" +
	                    		(chessPane.getColumnIndex(piece[0][6].getImageView())  ) + "->\n");
	                     	chessPane.add(piece[0][6].getImageView(), chessPane.getColumnIndex(piece[0][6].getImageView()), chessPane.getRowIndex(piece[0][6].getImageView()) - 1);
	                    	
	                    	});
	                  

        	  }
        		  
        		  File file = new File("E:" + File.separator + "chess manule.txt");
        			OutputStream output = null;
					try {
						output = new FileOutputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			String str = textField.getText();
        			byte data[] = str.getBytes();
        			try {
						output.write(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        });
        	piece[0][6].getImageView().setOnMouseReleased(e ->{
        		if((piece[chessPane.getColumnIndex(piece[0][6].getImageView())][chessPane.getRowIndex(piece[0][6].getImageView())].getImageView().equals("BLACKPAWN")))
        		{
        			System.out.println("6");
        			chessPane.getChildren().remove(piece[chessPane.getColumnIndex(piece[0][6].getImageView())][chessPane.getRowIndex(piece[0][6].getImageView())].getImageView());
	
        		}
        	});
        
        	piece[1][6].getImageView().setOnMouseClicked(e ->{
      		  if(!piece[1][6].getHasMoved())
      		  {
      			  piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView(), 1, chessPane.getRowIndex(piece[1][6].getImageView()) - 1);
	                    piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 2].getImageView(),
	                                piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[0][6].getPieceName() + "5" +
	                    		"1" + "->\n");
	                    	chessPane.add(piece[1][6].getImageView(), 1, chessPane.getRowIndex(piece[1][6].getImageView()) - 1);
	                    });
                    piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 2] = new Openfield();
	                  piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 2].setImage(OPENFIELD);
	                  chessPane.add(piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 2].getImageView(), 1, chessPane.getRowIndex(piece[1][6].getImageView()) - 2);
	                    piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 2].getImageView(),
	                                piece[1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[1][6].getPieceName() + "4" +
	                    		"1" + "->\n");
	                    	chessPane.add(piece[1][6].getImageView(), 1, chessPane.getRowIndex(piece[1][6].getImageView()) - 2);
	                    });
	                    textField.setText(textField.getText() + "white" +
	                    		piece[1][6].getPieceName() + "" + (chessPane.getRowIndex(piece[0][6].getImageView()) ) + "" +
                    		(chessPane.getColumnIndex(piece[1][6].getImageView()) ) + "->\n");
	                   piece[1][6].setHasMoved(true);
    		  }
    		  else if(piece[1][6].getHasMoved())
    		  {
    			  piece[chessPane.getColumnIndex(piece[1][6].getImageView())][chessPane.getRowIndex(piece[1][6].getImageView()) - 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[1][6].getImageView())][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[1][6].getImageView())][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[1][6].getImageView()), chessPane.getRowIndex(piece[1][6].getImageView()) - 1);
	                    piece[chessPane.getColumnIndex(piece[1][6].getImageView())][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[1][6].getImageView())][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView(),
	                                piece[chessPane.getColumnIndex(piece[1][6].getImageView()) + 1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[1][6].getPieceName() + "" + (chessPane.getRowIndex(piece[1][6].getImageView()) - 1) + "" +
	                    		(chessPane.getColumnIndex(piece[1][6].getImageView()) ) + "->\n");
	                     	chessPane.add(piece[1][6].getImageView(), chessPane.getColumnIndex(piece[1][6].getImageView()), chessPane.getRowIndex(piece[1][6].getImageView()) - 1);
	                     	});
	                  
	              piece[chessPane.getColumnIndex(piece[1][6].getImageView()) + 1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].setImage(OPENFIELD);
	              chessPane.add(piece[chessPane.getColumnIndex(piece[1][6].getImageView()) + 1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[1][6].getImageView()) + 1, chessPane.getRowIndex(piece[1][6].getImageView()) - 1);
	              piece[chessPane.getColumnIndex(piece[1][6].getImageView()) + 1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView().setOnMouseClicked(b ->{
	            	  chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[1][6].getImageView()) + 1][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView(),
	            			  piece[chessPane.getColumnIndex(piece[1][6].getImageView())][chessPane.getRowIndex(piece[1][6].getImageView()) - 1].getImageView());
	            	  textField.setText(textField.getText() + "white" +
	                    		piece[1][6].getPieceName() + "" + (chessPane.getRowIndex(piece[0][6].getImageView()) - 1) + "" +
                  		(chessPane.getColumnIndex(piece[1][6].getImageView()) + 1 ) + "->\n");
	            	  chessPane.add(piece[1][6].getImageView(), chessPane.getColumnIndex(piece[1][6].getImageView()) + 1, chessPane.getRowIndex(piece[1][6].getImageView()) - 1);
	              });
      	  }
      		  
      		File file = new File("E:" + File.separator + "chess manule.txt");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = textField.getText();
			byte data[] = str.getBytes();
			try {
				output.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      });
        	piece[2][6].getImageView().setOnMouseClicked(e ->{
        		  if(!piece[2][6].getHasMoved())
        		  {
        			  piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].setImage(OPENFIELD);
  	                    chessPane.add(piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView(), 2, chessPane.getRowIndex(piece[2][6].getImageView()) - 1);
  	                    piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
  	                    	chessPane.getChildren().removeAll(
  	                        		piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 2].getImageView(),
  	                                piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView());
  	                    	
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[2][6].getPieceName() + "5" + 
  	                    		"2" + "->\n");
  	                    	chessPane.add(piece[2][6].getImageView(), 2, chessPane.getRowIndex(piece[2][6].getImageView()) - 1);
  	                    });
                      piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 2] = new Openfield();
  	                  piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 2].setImage(OPENFIELD);
  	                  chessPane.add(piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 2].getImageView(), 2, chessPane.getRowIndex(piece[2][6].getImageView()) - 2);
  	                    piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 2].getImageView().setOnMouseClicked(a ->{
  	                    	chessPane.getChildren().removeAll(
  	                        		piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 2].getImageView(),
  	                                piece[2][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView());
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[2][6].getPieceName() + "4" + 
  	                    		"2" + "->\n");
  	                    	chessPane.add(piece[2][6].getImageView(), 2, chessPane.getRowIndex(piece[2][6].getImageView()) - 2);
  	                    });
  	                  textField.setText(textField.getText() + "white" +
	                    		piece[0][6].getPieceName() + "" + (chessPane.getRowIndex(piece[0][6].getImageView()) ) + "" +
                  		(chessPane.getColumnIndex(piece[0][6].getImageView()) ) + "->\n");
  	                   piece[2][6].setHasMoved(true);
      		  }
      		  else if(piece[2][6].getHasMoved())
      		  {
      			  piece[chessPane.getColumnIndex(piece[2][6].getImageView())][chessPane.getRowIndex(piece[2][6].getImageView()) - 1] = new Openfield();
  	                  piece[chessPane.getColumnIndex(piece[2][6].getImageView())][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].setImage(OPENFIELD);
  	                    chessPane.add(piece[chessPane.getColumnIndex(piece[2][6].getImageView())][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[2][6].getImageView()), chessPane.getRowIndex(piece[2][6].getImageView()) - 1);
  	                    piece[chessPane.getColumnIndex(piece[2][6].getImageView())][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
  	                   
  	                    	chessPane.getChildren().removeAll(
  	                                piece[chessPane.getColumnIndex(piece[2][6].getImageView())][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView(),
  	                                piece[chessPane.getColumnIndex(piece[2][6].getImageView()) + 1][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView());
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[2][6].getPieceName() + "" + (chessPane.getRowIndex(piece[2][6].getImageView()) - 1) + "" +
  	                    		(chessPane.getColumnIndex(piece[2][6].getImageView())  ) + "->\n");
  	                     	chessPane.add(piece[2][6].getImageView(), chessPane.getColumnIndex(piece[2][6].getImageView()), chessPane.getRowIndex(piece[2][6].getImageView()) - 1);
  	                     	});
  	                  
  	              piece[chessPane.getColumnIndex(piece[2][6].getImageView()) + 1][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].setImage(OPENFIELD);
  	              chessPane.add(piece[chessPane.getColumnIndex(piece[2][6].getImageView()) + 1][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[2][6].getImageView()) + 1, chessPane.getRowIndex(piece[2][6].getImageView()) - 1);
  	              piece[chessPane.getColumnIndex(piece[2][6].getImageView()) + 1][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView().setOnMouseClicked(b ->{
  	            	  chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[2][6].getImageView()) + 1][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView(),
  	            			  piece[chessPane.getColumnIndex(piece[2][6].getImageView())][chessPane.getRowIndex(piece[2][6].getImageView()) - 1].getImageView());
  	            	textField.setText(textField.getText() + "white" +
                    		piece[2][6].getPieceName() + "" + (chessPane.getRowIndex(piece[2][6].getImageView()) - 1) + "" +
                		(chessPane.getColumnIndex(piece[2][6].getImageView()) + 1 ) + "->\n");
  	            	  chessPane.add(piece[2][6].getImageView(), chessPane.getColumnIndex(piece[2][6].getImageView()) + 1, chessPane.getRowIndex(piece[2][6].getImageView()) - 1);
  	              });
        	  }
        		  
        		  File file = new File("E:" + File.separator + "chess manule.txt");
      			OutputStream output = null;
					try {
						output = new FileOutputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      			String str = textField.getText();
      			byte data[] = str.getBytes();
      			try {
						output.write(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      			try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        });  
        	piece[3][6].getImageView().setOnMouseClicked(e ->{
      		  if(!piece[3][6].getHasMoved())
      		  {
      			  piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView(), 3, chessPane.getRowIndex(piece[3][6].getImageView()) - 1);
	                    piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 2].getImageView(),
	                                piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[3][6].getPieceName() + "5" +
	                    		"3" + "->\n");
	                    	chessPane.add(piece[3][6].getImageView(), 3, chessPane.getRowIndex(piece[3][6].getImageView()) - 1);
	                    });
                    piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 2] = new Openfield();
	                  piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 2].setImage(OPENFIELD);
	                  chessPane.add(piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 2].getImageView(), 3, chessPane.getRowIndex(piece[3][6].getImageView()) - 2);
	                    piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 2].getImageView(),
	                                piece[3][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[3][6].getPieceName() + "4" + 
  	                    		"3" + "->\n");
	                    	chessPane.add(piece[3][6].getImageView(), 3, chessPane.getRowIndex(piece[3][6].getImageView()) - 2);
	                    });
	                    textField.setText(textField.getText() + "white" +
	                    		piece[3][6].getPieceName() + "" + (chessPane.getRowIndex(piece[3][6].getImageView()) ) + "" +
                    		(chessPane.getColumnIndex(piece[3][6].getImageView()) ) + "->\n");
	                   piece[3][6].setHasMoved(true);
    		  }
    		  else if(piece[3][6].getHasMoved())
    		  {
    			  piece[chessPane.getColumnIndex(piece[3][6].getImageView())][chessPane.getRowIndex(piece[3][6].getImageView()) - 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[3][6].getImageView())][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[3][6].getImageView())][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[3][6].getImageView()), chessPane.getRowIndex(piece[3][6].getImageView()) - 1);
	                    piece[chessPane.getColumnIndex(piece[3][6].getImageView())][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[3][6].getImageView())][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView(),
	                                piece[chessPane.getColumnIndex(piece[3][6].getImageView()) + 1][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[3][6].getPieceName() + "" + (chessPane.getRowIndex(piece[3][6].getImageView()) - 1) + "" +
	                    		(chessPane.getColumnIndex(piece[3][6].getImageView())) + "->\n");
	                     	chessPane.add(piece[3][6].getImageView(), chessPane.getColumnIndex(piece[3][6].getImageView()), chessPane.getRowIndex(piece[3][6].getImageView()) - 1);
	                     	});
	                  
	              piece[chessPane.getColumnIndex(piece[3][6].getImageView()) + 1][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].setImage(OPENFIELD);
	              chessPane.add(piece[chessPane.getColumnIndex(piece[3][6].getImageView()) + 1][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[3][6].getImageView()) + 1, chessPane.getRowIndex(piece[3][6].getImageView()) - 1);
	              piece[chessPane.getColumnIndex(piece[3][6].getImageView()) + 1][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView().setOnMouseClicked(b ->{
	            	  chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[3][6].getImageView()) + 1][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView(),
	            			  piece[chessPane.getColumnIndex(piece[3][6].getImageView())][chessPane.getRowIndex(piece[3][6].getImageView()) - 1].getImageView());
	            	  textField.setText(textField.getText() + "white" +
	                    		piece[3][6].getPieceName() + "" + (chessPane.getRowIndex(piece[3][6].getImageView()) - 1) + "" +
                  		(chessPane.getColumnIndex(piece[3][6].getImageView()) + 1 ) + "->\n");
	            	  chessPane.add(piece[3][6].getImageView(), chessPane.getColumnIndex(piece[3][6].getImageView()) + 1, chessPane.getRowIndex(piece[3][6].getImageView()) - 1);
	              });
      	  }
      		  
      		File file = new File("E:" + File.separator + "chess manule.txt");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = textField.getText();
			byte data[] = str.getBytes();
			try {
				output.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      });  
        	piece[4][6].getImageView().setOnMouseClicked(e ->{
        		  if(!piece[4][6].getHasMoved())
        		  {
        			  piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].setImage(OPENFIELD);
  	                    chessPane.add(piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView(), 4, chessPane.getRowIndex(piece[4][6].getImageView()) - 1);
  	                    piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
  	                    	chessPane.getChildren().removeAll(
  	                        		piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 2].getImageView(),
  	                                piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView());
  	                    	
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[4][6].getPieceName() + "5" +
  	                    		"4" + "->\n");
  	                    	chessPane.add(piece[4][6].getImageView(), 4, chessPane.getRowIndex(piece[4][6].getImageView()) - 1);
  	                    });
                      piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 2] = new Openfield();
  	                  piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 2].setImage(OPENFIELD);
  	                  chessPane.add(piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 2].getImageView(), 4, chessPane.getRowIndex(piece[4][6].getImageView()) - 2);
  	                    piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 2].getImageView().setOnMouseClicked(a ->{
  	                    	chessPane.getChildren().removeAll(
  	                        		piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 2].getImageView(),
  	                                piece[4][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView());
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[4][6].getPieceName() + "5" + 
  	                    		"4" + "->\n");
  	                    	chessPane.add(piece[4][6].getImageView(), 4, chessPane.getRowIndex(piece[4][6].getImageView()) - 2);
  	                    });
  	                  textField.setText(textField.getText() + "white" +
	                    		piece[4][6].getPieceName() + "" + (chessPane.getRowIndex(piece[4][6].getImageView())) + "" +
                  		(chessPane.getColumnIndex(piece[4][6].getImageView())  ) + "->\n");
  	                   piece[4][6].setHasMoved(true);
      		  }
      		  else if(piece[4][6].getHasMoved())
      		  {
      			  piece[chessPane.getColumnIndex(piece[4][6].getImageView())][chessPane.getRowIndex(piece[4][6].getImageView()) - 1] = new Openfield();
  	                  piece[chessPane.getColumnIndex(piece[4][6].getImageView())][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].setImage(OPENFIELD);
  	                    chessPane.add(piece[chessPane.getColumnIndex(piece[4][6].getImageView())][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[4][6].getImageView()), chessPane.getRowIndex(piece[4][6].getImageView()) - 1);
  	                    piece[chessPane.getColumnIndex(piece[4][6].getImageView())][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
  	                   
  	                    	chessPane.getChildren().removeAll(
  	                                piece[chessPane.getColumnIndex(piece[4][6].getImageView())][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView(),
  	                                piece[chessPane.getColumnIndex(piece[4][6].getImageView()) + 1][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView());
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[4][6].getPieceName() + "" + (chessPane.getRowIndex(piece[4][6].getImageView()) - 1) + "" +
  	                    		(chessPane.getColumnIndex(piece[4][6].getImageView())  ) + "->\n");
  	                     	chessPane.add(piece[4][6].getImageView(), chessPane.getColumnIndex(piece[4][6].getImageView()), chessPane.getRowIndex(piece[4][6].getImageView()) - 1);
  	                     	});
  	                  
  	              piece[chessPane.getColumnIndex(piece[4][6].getImageView()) + 1][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].setImage(OPENFIELD);
  	              chessPane.add(piece[chessPane.getColumnIndex(piece[4][6].getImageView()) + 1][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[4][6].getImageView()) + 1, chessPane.getRowIndex(piece[4][6].getImageView()) - 1);
  	              piece[chessPane.getColumnIndex(piece[4][6].getImageView()) + 1][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView().setOnMouseClicked(b ->{
  	            	  chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[4][6].getImageView()) + 1][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView(),
  	            			  piece[chessPane.getColumnIndex(piece[4][6].getImageView())][chessPane.getRowIndex(piece[4][6].getImageView()) - 1].getImageView());
  	            	textField.setText(textField.getText() + "white" +
                    		piece[4][6].getPieceName() + "" + (chessPane.getRowIndex(piece[4][6].getImageView()) - 1) + "" +
                		(chessPane.getColumnIndex(piece[4][6].getImageView()) + 1 ) + "->\n");
  	            	  chessPane.add(piece[4][6].getImageView(), chessPane.getColumnIndex(piece[4][6].getImageView()) + 1, chessPane.getRowIndex(piece[4][6].getImageView()) - 1);
  	              });
        	  }
        		  
        		  File file = new File("E:" + File.separator + "chess manule.txt");
      			OutputStream output = null;
					try {
						output = new FileOutputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      			String str = textField.getText();
      			byte data[] = str.getBytes();
      			try {
						output.write(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      			try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        });  
        	piece[5][6].getImageView().setOnMouseClicked(e ->{
      		  if(!piece[5][6].getHasMoved())
      		  {
      			  piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView(), 5, chessPane.getRowIndex(piece[5][6].getImageView()) - 1);
	                    piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 2].getImageView(),
	                                piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[5][6].getPieceName() + "5" + 
  	                    		"5" + "->\n");
	                    	chessPane.add(piece[5][6].getImageView(), 5, chessPane.getRowIndex(piece[5][6].getImageView()) - 1);
	                    });
                    piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 2] = new Openfield();
	                  piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 2].setImage(OPENFIELD);
	                  chessPane.add(piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 2].getImageView(), 5, chessPane.getRowIndex(piece[5][6].getImageView()) - 2);
	                    piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 2].getImageView(),
	                                piece[5][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[5][6].getPieceName() + "4" + 
  	                    		"2" + "->\n");
	                    	chessPane.add(piece[5][6].getImageView(), 5, chessPane.getRowIndex(piece[5][6].getImageView()) - 2);
	                    });
	                    textField.setText(textField.getText() + "white" +
	                    		piece[5][6].getPieceName() + "" + (chessPane.getRowIndex(piece[5][6].getImageView()) ) + "" +
                    		(chessPane.getColumnIndex(piece[5][6].getImageView())  ) + "->\n");
	                   piece[5][6].setHasMoved(true);
    		  }
    		  else if(piece[5][6].getHasMoved())
    		  {
    			  piece[chessPane.getColumnIndex(piece[5][6].getImageView())][chessPane.getRowIndex(piece[5][6].getImageView()) - 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[5][6].getImageView())][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[5][6].getImageView())][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[5][6].getImageView()), chessPane.getRowIndex(piece[5][6].getImageView()) - 1);
	                    piece[chessPane.getColumnIndex(piece[5][6].getImageView())][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[5][6].getImageView())][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView(),
	                                piece[chessPane.getColumnIndex(piece[5][6].getImageView()) + 1][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[0][6].getPieceName() + "" + (chessPane.getRowIndex(piece[0][6].getImageView()) - 1) + "" +
	                    		(chessPane.getColumnIndex(piece[5][6].getImageView())  ) + "->\n");
	                     	chessPane.add(piece[5][6].getImageView(), chessPane.getColumnIndex(piece[5][6].getImageView()), chessPane.getRowIndex(piece[5][6].getImageView()) - 1);
	                     	});
	                  
	              piece[chessPane.getColumnIndex(piece[5][6].getImageView()) + 1][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].setImage(OPENFIELD);
	              chessPane.add(piece[chessPane.getColumnIndex(piece[5][6].getImageView()) + 1][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[5][6].getImageView()) + 1, chessPane.getRowIndex(piece[5][6].getImageView()) - 1);
	              piece[chessPane.getColumnIndex(piece[5][6].getImageView()) + 1][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView().setOnMouseClicked(b ->{
	            	  chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[5][6].getImageView()) + 1][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView(),
	            			  piece[chessPane.getColumnIndex(piece[5][6].getImageView())][chessPane.getRowIndex(piece[5][6].getImageView()) - 1].getImageView());
	            	  textField.setText(textField.getText() + "white" +
	                    		piece[5][6].getPieceName() + "" + (chessPane.getRowIndex(piece[5][6].getImageView()) - 1) + "" +
                  		(chessPane.getColumnIndex(piece[5][6].getImageView()) + 1 ) + "->\n");
	            	  chessPane.add(piece[5][6].getImageView(), chessPane.getColumnIndex(piece[5][6].getImageView()) + 1, chessPane.getRowIndex(piece[5][6].getImageView()) - 1);
	              });
      	  }
      		  
      		File file = new File("E:" + File.separator + "chess manule.txt");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = textField.getText();
			byte data[] = str.getBytes();
			try {
				output.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      });  
        	piece[6][6].getImageView().setOnMouseClicked(e ->{
        		  if(!piece[6][6].getHasMoved())
        		  {
        			  piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].setImage(OPENFIELD);
  	                    chessPane.add(piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView(), 6, chessPane.getRowIndex(piece[6][6].getImageView()) - 1);
  	                    piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
  	                    	chessPane.getChildren().removeAll(
  	                        		piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 2].getImageView(),
  	                                piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView());
  	                    	
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[6][6].getPieceName() + "5" + 
  	                    		"6" + "->\n");
  	                    	chessPane.add(piece[6][6].getImageView(), 6, chessPane.getRowIndex(piece[6][6].getImageView()) - 1);
  	                    });
                      piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 2] = new Openfield();
  	                  piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 2].setImage(OPENFIELD);
  	                  chessPane.add(piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 2].getImageView(), 6, chessPane.getRowIndex(piece[6][6].getImageView()) - 2);
  	                    piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 2].getImageView().setOnMouseClicked(a ->{
  	                    	chessPane.getChildren().removeAll(
  	                        		piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 2].getImageView(),
  	                                piece[6][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView());
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[6][6].getPieceName() + "4" + 
  	                    		"6" + "->\n");
  	                    	chessPane.add(piece[6][6].getImageView(), 6, chessPane.getRowIndex(piece[6][6].getImageView()) - 2);
  	                    });
  	                  textField.setText(textField.getText() + "white" +
	                    		piece[6][6].getPieceName() + "" + (chessPane.getRowIndex(piece[6][6].getImageView()) ) + "" +
                  		(chessPane.getColumnIndex(piece[6][6].getImageView())  ) + "->\n");
  	                   piece[6][6].setHasMoved(true);
      		  }
      		  else if(piece[6][6].getHasMoved())
      		  {
      			  piece[chessPane.getColumnIndex(piece[6][6].getImageView())][chessPane.getRowIndex(piece[6][6].getImageView()) - 1] = new Openfield();
  	                  piece[chessPane.getColumnIndex(piece[6][6].getImageView())][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].setImage(OPENFIELD);
  	                    chessPane.add(piece[chessPane.getColumnIndex(piece[6][6].getImageView())][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[6][6].getImageView()), chessPane.getRowIndex(piece[6][6].getImageView()) - 1);
  	                    piece[chessPane.getColumnIndex(piece[6][6].getImageView())][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
  	                   
  	                    	chessPane.getChildren().removeAll(
  	                                piece[chessPane.getColumnIndex(piece[6][6].getImageView())][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView(),
  	                                piece[chessPane.getColumnIndex(piece[6][6].getImageView()) + 1][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView());
  	                    	textField.setText(textField.getText() + "white" +
  		                    		piece[6][6].getPieceName() + "" + (chessPane.getRowIndex(piece[0][6].getImageView()) - 1) + "" +
  	                    		(chessPane.getColumnIndex(piece[6][6].getImageView()) ) + "->\n");
  	                     	chessPane.add(piece[6][6].getImageView(), chessPane.getColumnIndex(piece[6][6].getImageView()), chessPane.getRowIndex(piece[6][6].getImageView()) - 1);
  	                     	});
  	                  
  	              piece[chessPane.getColumnIndex(piece[6][6].getImageView()) + 1][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].setImage(OPENFIELD);
  	              chessPane.add(piece[chessPane.getColumnIndex(piece[6][6].getImageView()) + 1][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[6][6].getImageView()) + 1, chessPane.getRowIndex(piece[6][6].getImageView()) - 1);
  	              piece[chessPane.getColumnIndex(piece[6][6].getImageView()) + 1][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView().setOnMouseClicked(b ->{
  	            	  chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[6][6].getImageView()) + 1][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView(),
  	            			  piece[chessPane.getColumnIndex(piece[6][6].getImageView())][chessPane.getRowIndex(piece[6][6].getImageView()) - 1].getImageView());
  	            	textField.setText(textField.getText() + "white" +
                    		piece[6][6].getPieceName() + "" + (chessPane.getRowIndex(piece[6][6].getImageView()) - 1) + "" +
                		(chessPane.getColumnIndex(piece[6][6].getImageView()) + 1 ) + "->\n");
  	            	  chessPane.add(piece[6][6].getImageView(), chessPane.getColumnIndex(piece[6][6].getImageView()) + 1, chessPane.getRowIndex(piece[6][6].getImageView()) - 1);
  	              });
  	              
        	  }
        		  
        		  File file = new File("E:" + File.separator + "chess manule.txt");
      			OutputStream output = null;
					try {
						output = new FileOutputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      			String str = textField.getText();
      			byte data[] = str.getBytes();
      			try {
						output.write(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      			try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        });  
        	piece[7][6].getImageView().setOnMouseClicked(e ->{
      		  if(!piece[7][6].getHasMoved())
      		  {
      			  piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].getImageView(), 7, chessPane.getRowIndex(piece[7][6].getImageView()) - 1);
	                    piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 2].getImageView(),
	                                piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[7][6].getPieceName() + "5" + 
	                    		"7" + "->\n");
	                    	chessPane.add(piece[7][6].getImageView(), 7, chessPane.getRowIndex(piece[7][6].getImageView()) - 1);
	                    });
                    piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 2] = new Openfield();
	                  piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 2].setImage(OPENFIELD);
	                  chessPane.add(piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 2].getImageView(), 7, chessPane.getRowIndex(piece[7][6].getImageView()) - 2);
	                    piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 2].getImageView(),
	                                piece[7][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[7][6].getPieceName() + "4" + 
	                    		"7" + "->\n");
	                    	chessPane.add(piece[7][6].getImageView(), 7, chessPane.getRowIndex(piece[7][6].getImageView()) - 2);
	                    });
	                  textField.setText(textField.getText() + "white" +
	                    		piece[7][6].getPieceName() + "" + (chessPane.getRowIndex(piece[7][6].getImageView()) ) + "" +
                		(chessPane.getColumnIndex(piece[7][6].getImageView())  ) + "->\n");
	                   piece[7][6].setHasMoved(true);
    		  }
    		  else if(piece[7][6].getHasMoved())
    		  {
    			  piece[chessPane.getColumnIndex(piece[7][6].getImageView())][chessPane.getRowIndex(piece[7][6].getImageView()) - 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[7][6].getImageView())][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[7][6].getImageView())][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[7][6].getImageView()), chessPane.getRowIndex(piece[7][6].getImageView()) - 1);
	                    piece[chessPane.getColumnIndex(piece[7][6].getImageView())][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[7][6].getImageView())][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].getImageView(),
	                                piece[chessPane.getColumnIndex(piece[7][6].getImageView()) + 1][chessPane.getRowIndex(piece[7][6].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[7][6].getPieceName() + "" + (chessPane.getRowIndex(piece[7][6].getImageView()) - 1) + "" +
	                    		(chessPane.getColumnIndex(piece[7][6].getImageView()) ) + "->\n");
	                     	chessPane.add(piece[7][6].getImageView(), chessPane.getColumnIndex(piece[6][6].getImageView()), chessPane.getRowIndex(piece[7][6].getImageView()) - 1);
	                     	});
	                  
	            
      	  }
      		  
      		File file = new File("E:" + File.separator + "chess manule.txt");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = textField.getText();
			byte data[] = str.getBytes();
			try {
				output.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      });
        	piece[1][7].getImageView().setOnMouseClicked(e ->{
        		if(!piece[1][7].hasMoved)
        		{
        			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].setImage(OPENFIELD);
        			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 1,chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
        			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView().setOnMouseClicked(E ->{
        				chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
        						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView());
        				
        				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView()) + "->\n");
        				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
        			});
        			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].setImage(OPENFIELD);
        			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 1,chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
        			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView().setOnMouseClicked(E ->{
        				chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
        						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView());
        				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
        				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
        			});
        			textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
        			piece[1][7].setHasMoved(true);
        		}
        		else if(piece[1][7].hasMoved)
        		{
         			if(chessPane.getColumnIndex(piece[1][7].getImageView()) == 0)
         			{
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].setImage(OPENFIELD);
         				chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView().setOnMouseClicked(E ->{
         					chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
         							piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
         							piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView());
         					textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
         					chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
         				});
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].setImage(OPENFIELD);
         				chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) - 1);
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView().setOnMouseClicked(E ->{
         					chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
         							piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
         							piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView());
         					textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
         					chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) - 1);
         				});
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].setImage(OPENFIELD);
         				chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) + 1);
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView().setOnMouseClicked(E ->{
         					chessPane.getChildren().removeAll(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
         							piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
         							piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView());
         					textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
         					chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) + 1);
         				});
         				
         				
         			}
         			else if(chessPane.getColumnIndex(piece[1][7].getImageView()) == 7)
         			{
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].setImage(OPENFIELD);
         				chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView().setOnMouseClicked(E ->{
         					chessPane.getChildren().remove(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView());
         					textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView()) + "->\n");
         					chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
         				});
         			}
         			//else if(chessPane.getRowIndex(piece[1][7].getImageView()))
         			else if((chessPane.getColumnIndex(piece[1][7].getImageView()) == 2 ||
         					chessPane.getColumnIndex(piece[1][7].getImageView()) == 3 ||
         					chessPane.getColumnIndex(piece[1][7].getImageView()) == 4 ||
         					chessPane.getColumnIndex(piece[1][7].getImageView()) == 5) &&
         					(chessPane.getRowIndex(piece[1][7].getImageView()) == 2 ||
         					chessPane.getRowIndex(piece[1][7].getImageView()) == 3 ||
         					chessPane.getRowIndex(piece[1][7].getImageView()) == 4 ||
         					chessPane.getRowIndex(piece[1][7].getImageView()) == 5))
         			{
         				piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].setImage(OPENFIELD);
            			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 1,chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView().setOnMouseClicked(E ->{
            				chessPane.getChildren().removeAll(
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView());
            				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
            				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
            			});
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].setImage(OPENFIELD);
            			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 1,chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView().setOnMouseClicked(E ->{
            				chessPane.getChildren().removeAll(
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView());
            				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
            				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
            			});
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].setImage(OPENFIELD);
            			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 2, chessPane.getRowIndex(piece[1][7].getImageView()) + 1);
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView().setOnMouseClicked(E ->{
            				chessPane.getChildren().removeAll(
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView());
            				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
            				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) + 1);
            			});
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].setImage(OPENFIELD);
            			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 2, chessPane.getRowIndex(piece[1][7].getImageView()) + 1);
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView().setOnMouseClicked(E ->{
            				chessPane.getChildren().removeAll(
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView());
            				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
            				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) - 1);
            			});
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].setImage(OPENFIELD);
            			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView().setOnMouseClicked(E ->{
            				chessPane.getChildren().removeAll(
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView());
            				
            				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
            				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) - 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
            			});
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].setImage(OPENFIELD);
            			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView().setOnMouseClicked(E ->{
            				chessPane.getChildren().removeAll(
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView());
            				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
            				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 1, chessPane.getRowIndex(piece[1][7].getImageView()) - 2);
            			});
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].setImage(OPENFIELD);
            			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) + 1);
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView().setOnMouseClicked(E ->{
            				chessPane.getChildren().removeAll(
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView());
            				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView()) + "->\n");
            				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) + 1);
            			});
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].setImage(OPENFIELD);
            			chessPane.add(piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) - 1);
            			piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView().setOnMouseClicked(E ->{
            				chessPane.getChildren().removeAll(
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) - 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 1][chessPane.getRowIndex(piece[1][7].getImageView()) - 2].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) + 1].getImageView(),
            						piece[chessPane.getColumnIndex(piece[1][7].getImageView()) + 2][chessPane.getRowIndex(piece[1][7].getImageView()) - 1].getImageView());
            				textField.setText(textField.getText() + "white" + piece[1][7].getPieceName() + chessPane.getColumnIndex(piece[1][7].getImageView()) + chessPane.getRowIndex(piece[1][7].getImageView())+ "->\n");
            				chessPane.add(piece[1][7].getImageView(), chessPane.getColumnIndex(piece[1][7].getImageView()) + 2, chessPane.getRowIndex(piece[1][7].getImageView()) - 1);
            			});
         			}
         				
        		}
        		File file = new File("E:" + File.separator + "chess manule.txt");
    			OutputStream output = null;
				try {
					output = new FileOutputStream(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			String str = textField.getText();
    			byte data[] = str.getBytes();
    			try {
					output.write(data);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			try {
					output.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
        	});
        	piece[0][7].getImageView().setOnMouseClicked(e ->{
        		if(!piece[0][7].getHasMoved())
        		{
        			
        		}
        	});
        	//黑色棋子	
        	piece[0][1].getImageView().setOnMouseClicked(e ->{
            	
      		  if(!piece[0][1].getHasMoved())
      		  {
      			  piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].getImageView(), 0, chessPane.getRowIndex(piece[0][1].getImageView()) + 1);
	                    piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	
	                    	chessPane.getChildren().removeAll(
	                        		piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 2].getImageView(),
	                                piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[0][1].getPieceName() + "" + "2" +
	                    		"0" + "->\n");
	                    	
	                    	chessPane.add(piece[0][1].getImageView(), 0, chessPane.getRowIndex(piece[0][1].getImageView()) + 1);
	                    	
	                    });
                    piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 2] = new Openfield();
	                  piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 2].setImage(OPENFIELD);
	                  chessPane.add(piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 2].getImageView(), 0, chessPane.getRowIndex(piece[0][1].getImageView()) + 2);
	                    piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 2].getImageView(),
	                                piece[0][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[0][1].getPieceName() + "" + "3" +
	                    		"0" + "->\n");
	                    	chessPane.add(piece[0][1].getImageView(), 0, chessPane.getRowIndex(piece[0][1].getImageView()) + 2);
	                    });
	                    textField.setText(textField.getText() + "black" +
	                    		piece[0][1].getPieceName() + "" + chessPane.getRowIndex(piece[0][1].getImageView()) + "" +
                  		chessPane.getColumnIndex(piece[0][1].getImageView())  + "->\n");
	                   piece[0][1].setHasMoved(true);
    		  }
    		  else if(piece[0][1].getHasMoved())
    		  {
    			  piece[chessPane.getColumnIndex(piece[0][1].getImageView())][chessPane.getRowIndex(piece[0][1].getImageView()) + 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[0][1].getImageView())][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[0][1].getImageView())][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[0][1].getImageView()), chessPane.getRowIndex(piece[0][1].getImageView()) + 1);
	                    piece[chessPane.getColumnIndex(piece[0][1].getImageView())][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[0][1].getImageView())][chessPane.getRowIndex(piece[0][1].getImageView()) + 1].getImageView());
	                                
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[0][1].getPieceName() + "" + (chessPane.getRowIndex(piece[0][1].getImageView()) + 1) + "" +
	                    		(chessPane.getColumnIndex(piece[0][1].getImageView())  ) + "->\n");
	                     	chessPane.add(piece[0][1].getImageView(), chessPane.getColumnIndex(piece[0][1].getImageView()), chessPane.getRowIndex(piece[0][1].getImageView()) + 1);
	                    	
	                    	});
	                  
	              
      	  }
      		  
      		  File file = new File("E:" + File.separator + "chess manule.txt");
      			OutputStream output = null;
					try {
						output = new FileOutputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      			String str = textField.getText();
      			byte data[] = str.getBytes();
      			try {
						output.write(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      			try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      });
      	
      	
      
      	piece[1][1].getImageView().setOnMouseClicked(e ->{
    		  if(!piece[1][1].getHasMoved())
    		  {
    			  piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].getImageView(), 1, chessPane.getRowIndex(piece[1][1].getImageView()) + 1);
	                    piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 2].getImageView(),
	                                piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[1][1].getPieceName() + "2" +
	                    		"1" + "->\n");
	                    	chessPane.add(piece[1][1].getImageView(), 1, chessPane.getRowIndex(piece[1][1].getImageView()) + 1);
	                    });
                  piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 2] = new Openfield();
	                  piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 2].setImage(OPENFIELD);
	                  chessPane.add(piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 2].getImageView(), 1, chessPane.getRowIndex(piece[1][1].getImageView()) + 2);
	                    piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 2].getImageView(),
	                                piece[1][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[1][1].getPieceName() + "3" +
	                    		"1" + "->\n");
	                    	chessPane.add(piece[1][1].getImageView(), 1, chessPane.getRowIndex(piece[1][1].getImageView()) + 2);
	                    });
	                    textField.setText(textField.getText() + "black" +
	                    		piece[1][1].getPieceName() + "" + (chessPane.getRowIndex(piece[0][1].getImageView()) ) + "" +
                  		(chessPane.getColumnIndex(piece[1][1].getImageView()) ) + "->\n");
	                   piece[1][1].setHasMoved(true);
  		  }
  		  else if(piece[1][1].getHasMoved())
  		  {
  			  piece[chessPane.getColumnIndex(piece[1][1].getImageView())][chessPane.getRowIndex(piece[1][1].getImageView()) + 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[1][1].getImageView())][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[1][1].getImageView())][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[1][1].getImageView()), chessPane.getRowIndex(piece[1][1].getImageView()) + 1);
	                    piece[chessPane.getColumnIndex(piece[1][1].getImageView())][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[1][1].getImageView())][chessPane.getRowIndex(piece[1][1].getImageView()) + 1].getImageView()
	                                );
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[1][1].getPieceName() + "" + (chessPane.getRowIndex(piece[1][1].getImageView()) + 1) + "" +
	                    		(chessPane.getColumnIndex(piece[1][1].getImageView()) ) + "->\n");
	                     	chessPane.add(piece[1][1].getImageView(), chessPane.getColumnIndex(piece[1][1].getImageView()), chessPane.getRowIndex(piece[1][1].getImageView()) + 1);
	                     	});
	                  
	              
    	  }
    		  
    		File file = new File("E:" + File.separator + "chess manule.txt");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = textField.getText();
			byte data[] = str.getBytes();
			try {
				output.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    });
      	piece[2][1].getImageView().setOnMouseClicked(e ->{
      		  if(!piece[2][1].getHasMoved())
      		  {
      			  piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].getImageView(), 2, chessPane.getRowIndex(piece[2][1].getImageView()) + 1);
	                    piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 2].getImageView(),
	                                piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[2][1].getPieceName() + "2" + 
	                    		"2" + "->\n");
	                    	chessPane.add(piece[2][1].getImageView(), 2, chessPane.getRowIndex(piece[2][1].getImageView()) + 1);
	                    });
                    piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 2] = new Openfield();
	                  piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 2].setImage(OPENFIELD);
	                  chessPane.add(piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 2].getImageView(), 2, chessPane.getRowIndex(piece[2][1].getImageView()) + 2);
	                    piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 2].getImageView(),
	                                piece[2][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[2][1].getPieceName() + "3" + 
	                    		"2" + "->\n");
	                    	chessPane.add(piece[2][1].getImageView(), 2, chessPane.getRowIndex(piece[2][1].getImageView()) + 2);
	                    });
	                  textField.setText(textField.getText() + "black" +
	                    		piece[2][1].getPieceName() + "" + (chessPane.getRowIndex(piece[2][1].getImageView()) ) + "" +
                		(chessPane.getColumnIndex(piece[2][1].getImageView()) ) + "->\n");
	                   piece[2][1].setHasMoved(true);
    		  }
    		  else if(piece[2][1].getHasMoved())
    		  {
    			  piece[chessPane.getColumnIndex(piece[2][1].getImageView())][chessPane.getRowIndex(piece[2][1].getImageView()) + 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[2][1].getImageView())][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[2][1].getImageView())][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[2][1].getImageView()), chessPane.getRowIndex(piece[2][1].getImageView()) + 1);
	                    piece[chessPane.getColumnIndex(piece[2][1].getImageView())][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[2][1].getImageView())][chessPane.getRowIndex(piece[2][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[2][1].getPieceName() + "" + (chessPane.getRowIndex(piece[2][1].getImageView()) + 1) + "" +
	                    		(chessPane.getColumnIndex(piece[2][1].getImageView())  ) + "->\n");
	                     	chessPane.add(piece[2][1].getImageView(), chessPane.getColumnIndex(piece[2][1].getImageView()), chessPane.getRowIndex(piece[2][1].getImageView()) + 1);
	                     	});
	                  
	              
      	  }
      		  
      		  File file = new File("E:" + File.separator + "chess manule.txt");
    			OutputStream output = null;
					try {
						output = new FileOutputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			String str = textField.getText();
    			byte data[] = str.getBytes();
    			try {
						output.write(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      });  
      	piece[3][1].getImageView().setOnMouseClicked(e ->{
    		  if(!piece[3][1].getHasMoved())
    		  {
    			  piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 1].getImageView(), 3, chessPane.getRowIndex(piece[3][1].getImageView()) + 1);
	                    piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 2].getImageView(),
	                                piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[3][1].getPieceName() + "2" +
	                    		"3" + "->\n");
	                    	chessPane.add(piece[3][1].getImageView(), 3, chessPane.getRowIndex(piece[3][1].getImageView()) + 1);
	                    });
                  piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 2] = new Openfield();
	                  piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 2].setImage(OPENFIELD);
	                  chessPane.add(piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 2].getImageView(), 3, chessPane.getRowIndex(piece[3][1].getImageView()) + 2);
	                    piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 2].getImageView(),
	                                piece[3][chessPane.getRowIndex(piece[3][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[3][1].getPieceName() + "3" + 
	                    		"3" + "->\n");
	                    	chessPane.add(piece[3][1].getImageView(), 3, chessPane.getRowIndex(piece[3][1].getImageView()) + 2);
	                    });
	                    textField.setText(textField.getText() + "black" +
	                    		piece[3][1].getPieceName() + "" + (chessPane.getRowIndex(piece[3][1].getImageView()) ) + "" +
                  		(chessPane.getColumnIndex(piece[3][1].getImageView()) ) + "->\n");
	                   piece[3][1].setHasMoved(true);
  		  }
  		  else if(piece[3][1].getHasMoved())
  		  {
  			  piece[chessPane.getColumnIndex(piece[3][1].getImageView())][chessPane.getRowIndex(piece[3][1].getImageView()) + 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[3][1].getImageView())][chessPane.getRowIndex(piece[3][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[3][1].getImageView())][chessPane.getRowIndex(piece[3][1].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[3][1].getImageView()), chessPane.getRowIndex(piece[3][1].getImageView()) + 1);
	                    piece[chessPane.getColumnIndex(piece[3][1].getImageView())][chessPane.getRowIndex(piece[3][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[3][1].getImageView())][chessPane.getRowIndex(piece[3][1].getImageView()) - 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[3][1].getPieceName() + "" + (chessPane.getRowIndex(piece[3][1].getImageView()) + 1) + "" +
	                    		(chessPane.getColumnIndex(piece[3][1].getImageView())) + "->\n");
	                     	chessPane.add(piece[3][1].getImageView(), chessPane.getColumnIndex(piece[3][1].getImageView()), chessPane.getRowIndex(piece[3][1].getImageView()) + 1);
	                     	});
	             
    	  }
    		  
    		File file = new File("E:" + File.separator + "chess manule.txt");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = textField.getText();
			byte data[] = str.getBytes();
			try {
				output.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    });  
      	piece[4][1].getImageView().setOnMouseClicked(e ->{
      		  if(!piece[4][1].getHasMoved())
      		  {
      			  piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].getImageView(), 4, chessPane.getRowIndex(piece[4][1].getImageView()) + 1);
	                    piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 2].getImageView(),
	                                piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "white" +
		                    		piece[4][1].getPieceName() + "2" +
	                    		"4" + "->\n");
	                    	chessPane.add(piece[4][1].getImageView(), 4, chessPane.getRowIndex(piece[4][1].getImageView()) + 1);
	                    });
                    piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 2] = new Openfield();
	                  piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 2].setImage(OPENFIELD);
	                  chessPane.add(piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 2].getImageView(), 4, chessPane.getRowIndex(piece[4][1].getImageView()) + 2);
	                    piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 2].getImageView(),
	                                piece[4][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[4][1].getPieceName() + "3" + 
	                    		"4" + "->\n");
	                    	chessPane.add(piece[4][1].getImageView(), 4, chessPane.getRowIndex(piece[4][1].getImageView()) + 2);
	                    });
	                  textField.setText(textField.getText() + "black" +
	                    		piece[4][1].getPieceName() + "" + (chessPane.getRowIndex(piece[4][1].getImageView())) + "" +
                		(chessPane.getColumnIndex(piece[4][1].getImageView())  ) + "->\n");
	                   piece[4][1].setHasMoved(true);
    		  }
    		  else if(piece[4][1].getHasMoved())
    		  {
    			  piece[chessPane.getColumnIndex(piece[4][1].getImageView())][chessPane.getRowIndex(piece[4][1].getImageView()) + 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[4][1].getImageView())][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[4][1].getImageView())][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[4][1].getImageView()), chessPane.getRowIndex(piece[4][1].getImageView()) + 1);
	                    piece[chessPane.getColumnIndex(piece[4][1].getImageView())][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[4][1].getImageView())][chessPane.getRowIndex(piece[4][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[4][1].getPieceName() + "" + (chessPane.getRowIndex(piece[4][1].getImageView()) + 1) + "" +
	                    		(chessPane.getColumnIndex(piece[4][1].getImageView())  ) + "->\n");
	                     	chessPane.add(piece[4][1].getImageView(), chessPane.getColumnIndex(piece[4][1].getImageView()), chessPane.getRowIndex(piece[4][1].getImageView()) + 1);
	                     	});
	                  
	              
      	  }
      		  
      		  File file = new File("E:" + File.separator + "chess manule.txt");
    			OutputStream output = null;
					try {
						output = new FileOutputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			String str = textField.getText();
    			byte data[] = str.getBytes();
    			try {
						output.write(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      });  
      	piece[5][1].getImageView().setOnMouseClicked(e ->{
    		  if(!piece[5][1].getHasMoved())
    		  {
    			  piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 1].getImageView(), 5, chessPane.getRowIndex(piece[5][1].getImageView()) + 1);
	                    piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 2].getImageView(),
	                                piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[5][1].getPieceName() + "2" + 
	                    		"5" + "->\n");
	                    	chessPane.add(piece[5][1].getImageView(), 5, chessPane.getRowIndex(piece[5][1].getImageView()) + 1);
	                    });
                  piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 2] = new Openfield();
	                  piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 2].setImage(OPENFIELD);
	                  chessPane.add(piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 2].getImageView(), 5, chessPane.getRowIndex(piece[5][1].getImageView()) + 2);
	                    piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 2].getImageView(),
	                                piece[5][chessPane.getRowIndex(piece[5][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[5][1].getPieceName() + "3" + 
	                    		"2" + "->\n");
	                    	chessPane.add(piece[5][1].getImageView(), 5, chessPane.getRowIndex(piece[5][1].getImageView()) + 2);
	                    });
	                    textField.setText(textField.getText() + "black" +
	                    		piece[5][1].getPieceName() + "" + (chessPane.getRowIndex(piece[5][1].getImageView()) ) + "" +
                  		(chessPane.getColumnIndex(piece[5][1].getImageView())  ) + "->\n");
	                   piece[5][1].setHasMoved(true);
  		  }
  		  else if(piece[5][1].getHasMoved())
  		  {
  			  piece[chessPane.getColumnIndex(piece[5][1].getImageView())][chessPane.getRowIndex(piece[5][1].getImageView()) + 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[5][1].getImageView())][chessPane.getRowIndex(piece[5][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[5][1].getImageView())][chessPane.getRowIndex(piece[5][1].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[5][1].getImageView()), chessPane.getRowIndex(piece[5][1].getImageView()) + 1);
	                    piece[chessPane.getColumnIndex(piece[5][1].getImageView())][chessPane.getRowIndex(piece[5][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[5][1].getImageView())][chessPane.getRowIndex(piece[5][6].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[5][1].getPieceName() + "" + (chessPane.getRowIndex(piece[5][1].getImageView()) + 1) + "" +
	                    		(chessPane.getColumnIndex(piece[5][1].getImageView())  ) + "->\n");
	                     	chessPane.add(piece[5][1].getImageView(), chessPane.getColumnIndex(piece[5][1].getImageView()), chessPane.getRowIndex(piece[5][1].getImageView()) + 1);
	                     	});
	                  
	             
    	  }
    		  
    		File file = new File("E:" + File.separator + "chess manule.txt");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = textField.getText();
			byte data[] = str.getBytes();
			try {
				output.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    });  
      	piece[6][1].getImageView().setOnMouseClicked(e ->{
      		  if(!piece[6][1].getHasMoved())
      		  {
      			  piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].getImageView(), 6, chessPane.getRowIndex(piece[6][1].getImageView()) + 1);
	                    piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 2].getImageView(),
	                                piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[6][1].getPieceName() + "2" + 
	                    		"6" + "->\n");
	                    	chessPane.add(piece[6][1].getImageView(), 6, chessPane.getRowIndex(piece[6][1].getImageView()) + 1);
	                    });
                    piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 2] = new Openfield();
	                  piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 2].setImage(OPENFIELD);
	                  chessPane.add(piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 2].getImageView(), 6, chessPane.getRowIndex(piece[6][1].getImageView()) + 2);
	                    piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 2].getImageView(),
	                                piece[6][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[6][1].getPieceName() + "3" + 
	                    		"6" + "->\n");
	                    	chessPane.add(piece[6][1].getImageView(), 6, chessPane.getRowIndex(piece[6][1].getImageView()) + 2);
	                    });
	                  textField.setText(textField.getText() + "black" +
	                    		piece[6][1].getPieceName() + "" + (chessPane.getRowIndex(piece[6][1].getImageView()) ) + "" +
                		(chessPane.getColumnIndex(piece[6][1].getImageView())  ) + "->\n");
	                   piece[6][1].setHasMoved(true);
    		  }
    		  else if(piece[6][1].getHasMoved())
    		  {
    			  piece[chessPane.getColumnIndex(piece[6][1].getImageView())][chessPane.getRowIndex(piece[6][1].getImageView()) + 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[6][1].getImageView())][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[6][1].getImageView())][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[6][1].getImageView()), chessPane.getRowIndex(piece[6][1].getImageView()) + 1);
	                    piece[chessPane.getColumnIndex(piece[6][1].getImageView())][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[6][1].getImageView())][chessPane.getRowIndex(piece[6][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[6][1].getPieceName() + "" + (chessPane.getRowIndex(piece[6][1].getImageView()) + 1) + "" +
	                    		(chessPane.getColumnIndex(piece[6][1].getImageView()) ) + "->\n");
	                     	chessPane.add(piece[6][1].getImageView(), chessPane.getColumnIndex(piece[6][1].getImageView()), chessPane.getRowIndex(piece[6][1].getImageView()) + 1);
	                     	});
	                  
	             
	              
      	  }
      		  
      		  File file = new File("E:" + File.separator + "chess manule.txt");
    			OutputStream output = null;
					try {
						output = new FileOutputStream(file);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			String str = textField.getText();
    			byte data[] = str.getBytes();
    			try {
						output.write(data);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			try {
						output.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
      });  
      	piece[7][1].getImageView().setOnMouseClicked(e ->{
    		  if(!piece[7][1].getHasMoved())
    		  {
    			  piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].getImageView(), 7, chessPane.getRowIndex(piece[7][1].getImageView()) + 1);
	                    piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 2].getImageView(),
	                                piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].getImageView());
	                    	
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[7][1].getPieceName() + "2" + 
	                    		"7" + "->\n");
	                    	chessPane.add(piece[7][1].getImageView(), 7, chessPane.getRowIndex(piece[7][1].getImageView()) + 1);
	                    });
                  piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 2] = new Openfield();
	                  piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 2].setImage(OPENFIELD);
	                  chessPane.add(piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 2].getImageView(), 7, chessPane.getRowIndex(piece[7][1].getImageView()) + 2);
	                    piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 2].getImageView().setOnMouseClicked(a ->{
	                    	chessPane.getChildren().removeAll(
	                        		piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 2].getImageView(),
	                                piece[7][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[7][1].getPieceName() + "3" + 
	                    		"7" + "->\n");
	                    	chessPane.add(piece[7][1].getImageView(), 7, chessPane.getRowIndex(piece[7][1].getImageView()) + 2);
	                    });
	                  textField.setText(textField.getText() + "black" +
	                    		piece[7][1].getPieceName() + "" + (chessPane.getRowIndex(piece[7][1].getImageView()) ) + "" +
              		(chessPane.getColumnIndex(piece[7][1].getImageView())  ) + "->\n");
	                   piece[7][1].setHasMoved(true);
  		  }
  		  else if(piece[7][1].getHasMoved())
  		  {
  			  piece[chessPane.getColumnIndex(piece[7][1].getImageView())][chessPane.getRowIndex(piece[7][1].getImageView()) + 1] = new Openfield();
	                  piece[chessPane.getColumnIndex(piece[7][1].getImageView())][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].setImage(OPENFIELD);
	                    chessPane.add(piece[chessPane.getColumnIndex(piece[7][1].getImageView())][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].getImageView(), chessPane.getColumnIndex(piece[7][1].getImageView()), chessPane.getRowIndex(piece[7][1].getImageView()) + 1);
	                    piece[chessPane.getColumnIndex(piece[7][1].getImageView())][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].getImageView().setOnMouseClicked(a ->{
	                   
	                    	chessPane.getChildren().removeAll(
	                                piece[chessPane.getColumnIndex(piece[7][1].getImageView())][chessPane.getRowIndex(piece[7][1].getImageView()) + 1].getImageView());
	                    	textField.setText(textField.getText() + "black" +
		                    		piece[7][1].getPieceName() + "" + (chessPane.getRowIndex(piece[7][1].getImageView()) + 1) + "" +
	                    		(chessPane.getColumnIndex(piece[7][1].getImageView()) ) + "->\n");
	                     	chessPane.add(piece[7][1].getImageView(), chessPane.getColumnIndex(piece[7][1].getImageView()), chessPane.getRowIndex(piece[7][1].getImageView()) + 1);
	                     	});
	                  
	            
    	  }
    		  
    		File file = new File("E:" + File.separator + "chess manule.txt");
			OutputStream output = null;
			try {
				output = new FileOutputStream(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str = textField.getText();
			byte data[] = str.getBytes();
			try {
				output.write(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    });
        return chessPane;
        
	}
	

	public TextArea textField() {
		
		textField.setMaxWidth(200);
		textField.setMaxHeight(800);
		return textField;
	}
	
	
    	
    
}    	
	
	
	

