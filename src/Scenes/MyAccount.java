package Scenes;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyAccount {
    Scene ENTRANCE4;
    BorderPane PANE;
    MyAccount MYACCOUNT;
    VBox MAIN;
    Text T1,T2,T3,T4,T5,T6,T7,T8;
    
    Decorum PROP;
    Mainwindow MW;
    SearchFlight HOME;
    
    public MyAccount(Stage MAINWINDOW, String NAMEUSER) throws IOException {
        PROP = new Decorum(); 
        
        T1 = new Text();
        T1.setText("Welcome Back: ");
        
        T2 = new Text();
        T2.setText("Name: ");
        
        T3 = new Text();
        T3.setText("Surname: ");
        
        T4 = new Text();
        T4.setText("Email: ");
        
        T5 = new Text();
        T5.setText("Password: ");
        
        T6= new Text();
        T6.setText("Phone Number: ");
        
        T7 = new Text();
        T7.setText("Miles Flown: ");
        
        T8 = new Text();
        T8.setText("Loyalty Status: ");
        
        MAIN = new VBox();
        MAIN.setSpacing(30);
        MAIN.setPadding(new Insets(0,100,0,100));
        MAIN.setAlignment(Pos.CENTER_LEFT);
        MAIN.getChildren().addAll(T1,T2,T3,T4,T5,T6,T7,T8);

        
        PANE = new BorderPane();
        PANE.setBackground(new Background(PROP.BCIMG));
        PANE.setTop(PROP.Bars(MAINWINDOW, NAMEUSER));
        PANE.setCenter(MAIN);
        
        ENTRANCE4 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE4.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE4;
    }
}
