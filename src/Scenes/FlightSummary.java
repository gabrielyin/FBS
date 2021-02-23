package Scenes;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FlightSummary {
    Scene ENTRANCE;
    Image IMG;
    BackgroundImage BCIMG;
    HBox MENUBAR1,BOTTOM;
    Button MENU1,MENU2,MENU3;
    MyNewClass HOME;
    MyAccount MYACCOUNT;
    BorderPane PANE;
    VBox MAINLEFT,MAINRIGHT;
    HBox CONTAINER;
    Text SUMMARY,FLIGHTNUM,DEP,ARR,DEPARDATE,FTIME,DIS,PLANE,SEATS,BAG,HANDBAGS,RESCODE,FINA,CLASS,PRICE,FEES;
    
    public FlightSummary(Stage MAINWINDOW,String USER) throws IOException{
        //background image
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        //menu bar management
        MENUBAR1 = new HBox();
        MENUBAR1.setId("MENUBAR");
        //search flight
        MENU1 = new Button("Search Flights");
        MENU1.setOnAction(e->{
            System.out.println("Search Flight Selected");
            try{
                HOME = new MyNewClass(MAINWINDOW, USER); 
                MAINWINDOW.setScene(HOME.getScreen());
            }catch(IOException MyAccountError){
                System.out.println("My Account doesnt reach My New Class");
            }
        });
        //flight status
        MENU2 = new Button("Flight Status");
        //account
        MENU3 = new Button("My Account");
        MYACCOUNT = new MyAccount(MAINWINDOW, USER);
        MENU3.setOnAction(e->{
            System.out.println("My Account selected");
            MAINWINDOW.setScene(MYACCOUNT.getScreen());
        });
        //adding menu items to menubar
        MENUBAR1.getChildren().addAll(MENU1,MENU2,MENU3);
        
        //left box
        MAINLEFT = new VBox();
        SUMMARY = new Text("SUMMARY");
        FLIGHTNUM = new Text("Flight Number: ");
        DEP = new Text("Departure Airport: ");
        ARR = new Text("Arrival Airport: ");
        DEPARDATE = new Text("Departs: ");
        FTIME = new Text("Flight Time: ");
        DIS = new Text("Distance: ");
        PLANE = new Text("Aircraft: ");
        SEATS = new Text("Seat(s): ");
        BAG = new Text("Bags: ");
        HANDBAGS = new Text("Hand Baggage: ");
        MAINLEFT.setPadding(new Insets(80,70,0,0));
        MAINLEFT.setSpacing(20);
        MAINLEFT.getChildren().addAll(SUMMARY,FLIGHTNUM,DEP,ARR,DEPARDATE,FTIME,DIS,PLANE,SEATS,BAG,HANDBAGS);
        
        //right box
        MAINRIGHT = new VBox();
        RESCODE = new Text("Reservation Code: ");
        FINA = new Text("FINANCIAL SUMMARY");
        CLASS = new Text("Class: ");
        PRICE = new Text("Ticket Price: ");
        FEES = new Text("Fees & Costs: ");
        MAINRIGHT.setPadding(new Insets(80,0,0,70));
        MAINRIGHT.setSpacing(20);
        MAINRIGHT.getChildren().addAll(RESCODE,FINA,CLASS,PRICE,FEES);
        
        //main container
        CONTAINER = new HBox();
        CONTAINER.setAlignment(Pos.CENTER);
        CONTAINER.getChildren().addAll(MAINLEFT,MAINRIGHT);
        
        //continue button & price
        Button CONTINUE = new Button("Continue");
        CONTINUE.setOnAction(e->{
          
        });
        
        //bottom hbox
        BOTTOM = new HBox();
        BOTTOM.setAlignment(Pos.BASELINE_RIGHT);
        BOTTOM.setPadding(new Insets(0,60,30,0));
        BOTTOM.getChildren().addAll(CONTINUE);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR1);
        PANE.setCenter(CONTAINER);
        PANE.setBottom(BOTTOM);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE;
    }
}
