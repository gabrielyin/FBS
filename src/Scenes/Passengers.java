package Scenes;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Passengers {
    Image IMG;
    BackgroundImage BCIMG;
    Scene ENTRANCE;
    BorderPane PANE;
    HBox MENUBAR1;
    Button MENU1,MENU2,MENU3;
    MyNewClass HOME;
    MyAccount MYACCOUNT;
    VBox MAINBOX;
    HBox BOX1;
    TextField PASSPORTNO,NAME,SURNAME;
    ComboBox GENDER,BAGS;
    
    public Passengers(Stage MAINWINDOW,String NAMEUSER) throws IOException{
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        //mrnu bar management
        MENUBAR1 = new HBox();
        MENUBAR1.setId("MENUBAR");
        //search flight
        MENU1 = new Button("Search Flights");
        MENU1.setOnAction(e->{
            System.out.println("Search Flight Selected");
            try{
                HOME = new MyNewClass(MAINWINDOW, NAMEUSER); 
                MAINWINDOW.setScene(HOME.getScreen());
            }catch(IOException MyAccountError){
                System.out.println("My Account doesnt reach My New Class");
            }
        });
        //flight status
        MENU2 = new Button("Flight Status");
        //account
        MENU3 = new Button("My Account");
        MYACCOUNT = new MyAccount(MAINWINDOW, NAMEUSER);
        MENU3.setOnAction(e->{
            System.out.println("My Account selected");
            MAINWINDOW.setScene(MYACCOUNT.getScreen());
        });
        //adding menu items to menubar
        MENUBAR1.getChildren().addAll(MENU1,MENU2,MENU3);
        
        //confirmation boxes
        MAINBOX = new VBox();
        
        PASSPORTNO = new TextField("Passport Number");
        NAME = new TextField("Name");
        SURNAME = new TextField("Surname");
        BOX1 = new HBox();
        BOX1.setPadding(new Insets(10,0,0,0));
        BOX1.setSpacing(10);
        BOX1.setAlignment(Pos.TOP_CENTER);
        BOX1.getChildren().addAll(PASSPORTNO,NAME,SURNAME);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR1);
        PANE.setCenter(BOX1);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE;
    }
}
