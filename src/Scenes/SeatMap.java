package Scenes;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SeatMap {
    Image IMG;
    BackgroundImage BCIMG;
    Scene ENTRANCE;
    BorderPane PANE;
    HBox MENUBAR1,BOX1,BOX2,BOX3,HBOX1;
    VBox CONTAINER;
    MyAccount MYACCOUNT;
    Button MENU1,MENU2,MENU3,CONTINUE;
    Text FLIGHTNUM,FLIGHT,PLANE,SM,SELECTED;
    Label BUSINESS,ECONOMYPLUS,ECONOMY,OCCUPIED;
    Passengers PASSENGER;
    Rectangle SEATS;
    StackPane STACK;
    
    public SeatMap(Stage MAINWINDOW, String USER) throws IOException{
        //background image    
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        // Menubar management
        MENUBAR1 = new HBox();
        MENUBAR1.setId("MENUBAR");
        MYACCOUNT = new MyAccount(MAINWINDOW, USER);
        //search flight
        MENU1 = new Button("Search Flights");
        //flight status
        MENU2 = new Button("Flight Status");
        //account
        MENU3 = new Button("My Account");
        MENU3.setOnAction(e->{
            System.out.println("My Account selected");
            MAINWINDOW.setScene(MYACCOUNT.getScreen());
        });
        //adding menu items to menubar
        MENUBAR1.getChildren().addAll(MENU1,MENU2,MENU3);
        
        //first hbox
        BOX1 = new HBox();
        
        FLIGHTNUM = new Text();
        FLIGHTNUM.setText("A001");
        
        FLIGHT = new Text();
        FLIGHT.setText("GIG-LAX");
        
        PLANE = new Text();
        PLANE.setText("767-300");
        
        BOX1.setAlignment(Pos.TOP_CENTER);
        BOX1.setPadding(new Insets(10,0,10,0));
        BOX1.setSpacing(50);
        BOX1.getChildren().addAll(FLIGHTNUM,FLIGHT,PLANE);
        
        //second hbox
        BOX2 = new HBox();
        
        SM = new Text();
        SM.setText("Seat Map");
        
        BUSINESS = new Label("Business");
        
        ECONOMYPLUS = new Label("Economy Plus");
        
        ECONOMY = new Label("Economy");
        
        OCCUPIED = new Label("Occupied");
        
        BOX2.setAlignment(Pos.TOP_CENTER);
        BOX2.setPadding(new Insets(10,0,10,0));
        BOX2.setSpacing(200);
        BOX2.getChildren().addAll(SM,BUSINESS,ECONOMYPLUS,ECONOMY,OCCUPIED);
        
        //seat map
        HBOX1 = new HBox();
        
        //rectangle
        SEATS = new Rectangle();
        SEATS.setHeight(10);
        SEATS.setWidth(10); 
//      SEATMAP.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
        //adding seats to hbox
        HBOX1.setMinSize(1000, 580);
        HBOX1.getChildren().addAll(SEATS);
        
        //adding hbox1 to vbox1
        VBox VBOX1 = new VBox();
        VBOX1.getChildren().addAll(HBOX1);

        //third hbox
        BOX3 = new HBox();
        
        SELECTED = new Text();
        SELECTED.setText("Seat(s) Selected: ");
        
        CONTINUE = new Button("Continue");
        PASSENGER = new Passengers(MAINWINDOW, USER);
        CONTINUE.setOnAction(e->{
            MAINWINDOW.setScene(PASSENGER.getScreen());
        });
        
        BOX3.setPadding(new Insets(10,0,10,0));
        BOX3.setAlignment(Pos.CENTER);
        BOX3.setSpacing(800);
        BOX3.getChildren().addAll(SELECTED,CONTINUE);
        
        //main container
        CONTAINER = new VBox();
        CONTAINER.getChildren().addAll(BOX1,BOX2/*add seat map here*/,BOX3);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR1);
        PANE.setCenter(CONTAINER);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE;
    }
}
