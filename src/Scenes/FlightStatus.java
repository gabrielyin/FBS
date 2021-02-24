package Scenes;

import java.io.IOException;
import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FlightStatus {
    Scene ENTRANCE;
    Image IMG;
    BackgroundImage BCIMG;
    HBox MENUBAR1;
    Button MENU1,MENU2,MENU3;
    MyAccount MYACCOUNT;
    BorderPane PANE;
    MyNewClass HOME;
    ScrollPane SCROLL;
    HBox BOX1,BOX2;
    VBox TOPCONTAINER,SCROLLCONTAINER,MAINCONTAINER,FLIGHTRESULTS;
    RadioButton ROUTE,NUMBER;
    ToggleGroup TOGGLE;
    ComboBox DEPARTURE,ARRIVAL;
    DatePicker GODATE;
    Button CONTINUE;
    Text AIRPORT,FLIGHTNUM,STATUS,DEPAR,ARRAR,DEPTIME,ARRTIME;
    
    public FlightStatus(Stage MAINWINDOW, String USER) throws IOException{
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
        
        //radial buttons
        TOGGLE = new ToggleGroup();
        ROUTE = new RadioButton();
        ROUTE.setText("Route");
        ROUTE.setToggleGroup(TOGGLE);
        
        NUMBER = new RadioButton();
        NUMBER.setText("Flight Number");
        
        //prompt boxes
        DEPARTURE = new ComboBox();
        DEPARTURE.setPrefHeight(40);
        DEPARTURE.setPrefWidth(300);
        DEPARTURE.setPromptText("Departure Airport");
        
        ARRIVAL = new ComboBox();
        ARRIVAL.setPrefHeight(40);
        ARRIVAL.setPrefWidth(300);
        ARRIVAL.setPromptText("Arrival Airport");
        
        //date calendar
        GODATE = new DatePicker(LocalDate.now());
        GODATE.setPrefWidth(300);
        GODATE.setMaxWidth(500);
        GODATE.setShowWeekNumbers(false);
        GODATE.setPrefHeight(40);
        GODATE.setPromptText("Departure Date");
        
        //continue button
        CONTINUE = new Button("Search");
        CONTINUE.setMinHeight(40);
        CONTINUE.setMinWidth(300);
        CONTINUE.setOnAction(e->{
        
        });
        
        //flight results
        FLIGHTRESULTS = new VBox();
        HBox INFO1 = new HBox();
        VBox INFO2 = new VBox();
        
        AIRPORT = new Text();
        AIRPORT.setText("GIG-LAX");
        FLIGHTNUM = new Text();
        FLIGHTNUM.setText("A001");
        STATUS = new Text();
        STATUS.setText("On Time");
        
        INFO1.setSpacing(40);
        INFO1.setMinSize(1250 , 40);
        INFO1.setPadding(new Insets(0,20,0,20));
        INFO1.setAlignment(Pos.CENTER_LEFT);
        INFO1.getChildren().addAll(AIRPORT,FLIGHTNUM,STATUS);
        
        DEPAR = new Text();
        DEPAR.setText("Galeão Interational Airport");
        ARRAR = new Text();
        ARRAR.setText("Los Angeles Interational Airport");
        DEPTIME = new Text();
        DEPTIME.setText("Departure date");
        ARRTIME = new Text();
        ARRTIME.setText("Arrival date");
        
        INFO2.setSpacing(10);
        INFO2.setMinWidth(1250);
        INFO2.setPadding(new Insets(0,20,0,20));
        INFO2.getChildren().addAll(DEPAR,ARRAR,DEPTIME,ARRTIME);
        FLIGHTRESULTS.getChildren().addAll(INFO1,INFO2);
        
        //scrollPane
        SCROLL = new ScrollPane();
        SCROLL.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        SCROLL.setMinHeight(500);
        SCROLL.setContent(FLIGHTRESULTS);
        
        //first hbox
        BOX1 = new HBox();
        BOX1.setSpacing(30);
        BOX1.getChildren().addAll(ROUTE,NUMBER);
        
        //second hbox
        BOX2 = new HBox();
        BOX2.setSpacing(30);
        BOX2.getChildren().addAll(DEPARTURE,ARRIVAL,GODATE,CONTINUE);
        
        //Top Container
        TOPCONTAINER = new VBox(30);
        TOPCONTAINER.getChildren().addAll(BOX1,BOX2);
        
        //scroll container
        SCROLLCONTAINER = new VBox();
        SCROLLCONTAINER.getChildren().addAll(SCROLL);
        
        //main container
        MAINCONTAINER = new VBox(30);
        MAINCONTAINER.setPadding(new Insets(50,50,50,50));
        MAINCONTAINER.getChildren().addAll(TOPCONTAINER,SCROLLCONTAINER);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR1);
        PANE.setCenter(MAINCONTAINER);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE;
    }
}
