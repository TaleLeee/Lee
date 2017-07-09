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
	    Menu menu1 = new Menu("����");
	    
	    
	    Menu menu2 = new Menu("ѡ��");
	    MenuItem back = new MenuItem("���¿�ʼ");
	    back.setOnAction(e ->{
	    	
				stage.close();
				stage.show();
				
			
	    });
	    MenuItem close = new MenuItem("������Ϸ");
	    close.setOnAction(e ->{
	    	stage.close();
	    });
	    menu2.getItems().addAll(back, close);
	    
	    Menu menu3 = new Menu("����");
	    MenuItem aboutGame = new MenuItem("������Ϸ");
	    aboutGame.setOnAction(e ->{
	    	
	    	Stage stageHelp = new Stage();
	    	VBox vPane = new VBox();
	    	
	    	Image helpImage = new Image("Image/timg.jpg");
	    	
	    	ImageView help = new ImageView(helpImage);
	    	help.setFitHeight(100);
	    	help.setFitWidth(200);
	    	Text textHelp = new Text();
	    	textHelp.setText("����Ϸ������������\n" + "�ڿ����������ܶ�����\n" +
	    	"����ʵ�ֳ����ӵĹ��ܣ�\n" + "�����ӿ��ƶ�λ�õ��ж�\n" + "֪���Լ����в��㻹��Ŭ��");
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
	    
	    Button btOK = new Button("��ʼ");
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

