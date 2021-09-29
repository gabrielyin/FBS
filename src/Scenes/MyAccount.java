package Scenes;

import Controllers.UserController;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyAccount {
    Text T1,T4,T5;
    Button BACK;
    VBox MAIN;
    BorderPane PANE;
    Scene ENTRANCE4;
    
    Decorum PROP;  
    Mainwindow SEARCH;
    UserController USER;
    
    public MyAccount(Stage MAINWINDOW, String NAMEUSER) throws IOException{
        PROP = new Decorum(); 
        SEARCH = new Mainwindow(MAINWINDOW);
        USER = new UserController();
    
        T1 = new Text();
        T1.setText("Welcome Back: "+NAMEUSER);
        
        T4 = new Text();
        T4.setText("Email: "+USER.readUserEM(NAMEUSER));
        
        T5 = new Text();
        T5.setText("Password: "+USER.readUserPW(NAMEUSER));
        
        BACK = new Button("Start");
        BACK.setOnAction(e->{
            MAINWINDOW.setScene(SEARCH.getScreen());
        });        
        
        MAIN = new VBox();
        MAIN.setSpacing(30);
        MAIN.setPadding(new Insets(0,100,0,100));
        MAIN.setAlignment(Pos.CENTER_LEFT); 
        MAIN.getChildren().addAll(T1,T4,T5,BACK);        
        
        PANE = new BorderPane(); 
        PANE.setBackground(new Background(PROP.BCIMG));        
        PANE.setCenter(MAIN);
        
        ENTRANCE4 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE4.getStylesheets().add("Decor.css");        
    }
    public Scene getScreen(){
        return ENTRANCE4;
    }    
}
