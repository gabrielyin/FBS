package Scenes;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Decorum {
    Image IMG;
    BackgroundImage BCIMG;
    HBox MENUBAR1;
    Button MENU1,MENU2,MENU3;
    
    MyAccount MYACCOUNT;
    FlightStatus FLIGHTSTATUS;
    
    public BackgroundImage Decorum(){
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);    
        return BCIMG;
    }
    
    public HBox Bars(Stage MAINWINDOW, String NAMEUSER) throws IOException{
        MENUBAR1 = new HBox();
        MENUBAR1.setId("MENUBAR");
        MYACCOUNT = new MyAccount(MAINWINDOW, NAMEUSER);
//        MYACCOUNT = new MyAccount(MAINWINDOW, NAMEUSER);
//        FLIGHTSTATUS = new FlightStatus(MAINWINDOW, NAMEUSER);
        //search flight
        MENU1 = new Button("Search Flights");
        //flight status
        MENU2 = new Button("Flight Status");
        MENU2.setOnAction(e->{
//            MAINWINDOW.setScene(FLIGHTSTATUS.getScreen());
        });
        //account
        MENU3 = new Button("My Account");
        MENU3.setOnAction(e->{
            MAINWINDOW.setScene(MYACCOUNT.getScreen());
        });
        //adding menu items to menubar
        MENUBAR1.getChildren().addAll(MENU1,MENU2,MENU3);        
        return MENUBAR1;
    }
}
