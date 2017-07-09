package com.Lee;


import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Chess extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setResizable(false);
		StackPane stackPane = new StackPane();
		BorderPane pane = new BorderPane();
	    ChessBoard chessBoard = new ChessBoard();
	    Menu menu1 = new Menu("设置");
	    
	    
	    Menu menu2 = new Menu("选择");
	    MenuItem back = new MenuItem("重新开始");
	    back.setOnAction(e ->{
	    	
				stage.close();
				stage.show();
				
			
	    });
	    MenuItem close = new MenuItem("结束游戏");
	    close.setOnAction(e ->{
	    	stage.close();
	    });
	    menu2.getItems().addAll(back, close);
	    
	    Menu menu3 = new Menu("帮助");
	    MenuItem aboutGame = new MenuItem("关于游戏");
	    aboutGame.setOnAction(e ->{
	    	
	    	Stage stageHelp = new Stage();
	    	VBox vPane = new VBox();
	    	
	    	Image helpImage = new Image("Image/timg.jpg");
	    	
	    	ImageView help = new ImageView(helpImage);
	    	help.setFitHeight(100);
	    	help.setFitWidth(200);
	    	Text textHelp = new Text();
	    	textHelp.setText("此游戏由李宇晗制作\n" + "在开发中遇到很多问题\n" +
	    	"比如实现吃棋子的功能，\n" + "和棋子可移动位置的判断\n" + "知道自己仍有不足还需努力");
	    	textHelp.setFont(Font.font ("Verdana", 20));
	    	textHelp.setFill(Color.RED);
	    	vPane.getChildren().addAll(help, textHelp);
	    	Scene sceneHelp = new Scene(vPane);
	        stageHelp.setScene(sceneHelp);
	        stageHelp.show();
	    });
	    menu3.getItems().add(aboutGame);
	    
	    MenuBar menuBar = new MenuBar();
	    menuBar.getMenus().addAll(menu1, menu2, menu3);
	    
	    Button btOK = new Button("开始");
	    btOK.setMinHeight(80);
	    btOK.setMinWidth(200);
	    btOK.setOnMouseClicked(e ->{
	    	try {
				stackPane.getChildren().add(chessBoard.chess());
				
			} 
	    	catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	  
	   
	    stackPane.getChildren().add(chessBoard.addRectangle());
	    pane.setCenter(stackPane);
	    pane.setRight(chessBoard.textField());
	    pane.setBottom(btOK);
	    pane.setTop(menuBar);
	    Scene scene = new Scene(pane); 
	    stage.setScene(scene);
	    stage.setTitle("Chess");
	    stage.getIcons().add(new Image("Image/chess.jpg"));
	    
	    stage.show();
	        
	    
	   
	   
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}

