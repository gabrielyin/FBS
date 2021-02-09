package Scenes;

import Controllers.MenuFiller;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyNewClass {
    Image IMG;
    BackgroundImage BCIMG;
    Text TITLE;
    ToggleGroup TOGGLE;
    RadioButton ROUNDTRIP,ONEWAY;
    ChoiceBox DEPARTURE, ARRIVAL;
    DatePicker GODATE,BACKDATE;
    LocalDate TODAY,LPICK;    
    Boolean CONDI; 
    Integer DDAY;
    TextField DEPDATE,IN,ARRDATE,AD; 
    Label ADULTS,INFANTS;     
    Button SEARCH,MENU1,MENU2,MENU3;
    VBox MAINLEFT,MAINRIGHT;
    HBox MID,ADULTBOX,INFANTBOX,RADIOBUTTONS,MENUBAR1;
    BorderPane PANE;
    Scene ENTRANCE;
    MyAccount MYACCOUNT;
    
    MenuFiller OPTIONS;   
    FlightResults FLIGHTRESULTS;    
    
    public MyNewClass(Stage MAINWINDOW,String NAMEUSER) throws IOException{
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);

// Menubar management
        MENUBAR1 = new HBox();
        MENUBAR1.setId("MENUBAR");
        MYACCOUNT = new MyAccount(MAINWINDOW);
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

// Title management
        TITLE = new Text();
        TITLE.setText("Book a Flight");
        
// Radio buttons management
        TOGGLE = new ToggleGroup();
        ROUNDTRIP = new RadioButton();
        ROUNDTRIP.setText("Round Trip");
        ROUNDTRIP.setToggleGroup(TOGGLE);
        ONEWAY = new RadioButton();
        ONEWAY.setText("One-Way");
        ONEWAY.setToggleGroup(TOGGLE);        
        
        RADIOBUTTONS = new HBox(30);
        RADIOBUTTONS.getChildren().addAll(ROUNDTRIP,ONEWAY);
        RADIOBUTTONS.setAlignment(Pos.CENTER_LEFT);

// ChoiceBox management        
        DEPARTURE = new ChoiceBox();
        DEPARTURE.setMaxWidth(500);
        DEPARTURE.setPrefHeight(40);
        OPTIONS = new MenuFiller();
        OPTIONS.BoxFiller("test/Destination.txt", DEPARTURE);
        DEPARTURE.setPrefWidth(500);
        DEPARTURE.setPrefHeight(40);
        
        ARRIVAL = new ChoiceBox();
        ARRIVAL.setMaxWidth(500);
        ARRIVAL.setPrefHeight(40);
        OPTIONS = new MenuFiller();
        OPTIONS.BoxFiller("test/Destination.txt", ARRIVAL);
        ARRIVAL.setPrefWidth(500);
        ARRIVAL.setPrefHeight(40);        

// Date fields and management        
        GODATE = new DatePicker(LocalDate.now());
        GODATE.setMaxWidth(500);
        GODATE.setShowWeekNumbers(false);
        GODATE.setPrefHeight(40);
        GODATE.setPromptText("Departure Date");
        BACKDATE = new DatePicker();
        DPickMe();
        DPock();        
        
// Elements to complete the scene        
        ADULTS = new Label();
        ADULTS.setText("Adults 12+");
        ADULTS.setPrefWidth(400);
        AD = new TextField();
        AD.setPrefWidth(90);
        AD.setPrefHeight(40);
        AD.setPromptText("0");
        AD.setAlignment(Pos.CENTER);
        ADULTBOX = new HBox(10);
        ADULTBOX.getChildren().addAll(ADULTS,AD);
        ADULTBOX.setAlignment(Pos.CENTER_LEFT);
        
        INFANTS = new Label();
        INFANTS.setText("Infants 0-11");
        INFANTS.setPrefWidth(400);
        IN = new TextField();
        IN.setPrefWidth(90);
        IN.setPrefHeight(40);
        IN.setPromptText("0");
        IN.setAlignment(Pos.CENTER);        
        INFANTBOX = new HBox(10);
        INFANTBOX.getChildren().addAll(INFANTS,IN);
        INFANTBOX.setAlignment(Pos.CENTER_LEFT);

        SEARCH = new Button();
        SEARCH.setId("SEARCH");
        SEARCH.setText("Search");
        SEARCH.setPrefWidth(500);
        SEARCH.setPrefHeight(40);
        FLIGHTRESULTS = new FlightResults(MAINWINDOW);
        SEARCH.setOnAction(e->{
            MAINWINDOW.setScene(FLIGHTRESULTS.getScreen());
        });
        
// Building the pane
        MAINLEFT = new VBox(15);
        MAINLEFT.setPrefWidth(500);
        MAINLEFT.getChildren().addAll(TITLE,RADIOBUTTONS,DEPARTURE,GODATE,ADULTBOX,INFANTBOX);
        
        MAINLEFT.setPadding(new Insets(0,0,0,0));
        MAINLEFT.setAlignment(Pos.CENTER_LEFT);

        MAINRIGHT = new VBox(15);
        MAINRIGHT.setPrefWidth(500);
        MAINRIGHT.getChildren().addAll(ARRIVAL,BACKDATE,SEARCH);
        MAINRIGHT.setPadding(new Insets(0,0,0,0));
        MAINRIGHT.setAlignment(Pos.CENTER_LEFT);

        MID = new HBox(10);
        MID.getChildren().addAll(MAINLEFT,MAINRIGHT);
        MID.setPadding(new Insets(0,0,10,0));
        MID.setAlignment(Pos.CENTER);        

        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR1);
        PANE.setCenter(MID);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public void DPickMe(){
        // Automatically add 7 days to check-out from check-in
        GODATE.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
                BACKDATE.setValue(newValue.plusDays(7));
            }
        }); 
        
        GODATE.setDayCellFactory(picker -> new DateCell(){
            @Override
            public void updateItem(LocalDate BONJOUR, boolean empty) {
                super.updateItem(BONJOUR, empty);  
                //Today date is yellow
                TODAY = LocalDate.now();
                if (BONJOUR.isEqual(TODAY)) {
                    setStyle("-fx-background-color: #FFFF00");                
                } 
                //Blocks booking before today - no back in time
                CONDI = (BONJOUR.isBefore(LocalDate.now().plusDays(1)));
                if (CONDI){
                    setDisable(true);
                    setStyle("-fx-background-color: #d3d3d3;");
                }else{
                    setDisable(false);
                    setStyle("-fx-background-color: #CCFFFF;");
                    setStyle("-fx-font-fill: black;");
                }                 
            }    
        });        
    }   
    public void DPock(){
        BACKDATE.setOnAction(e -> {
            BACKDATE.setTooltip(new Tooltip(ChronoUnit.DAYS.between(GODATE.getValue(),BACKDATE.getValue())+ " days"));
            DDAY= (int)(long)(ChronoUnit.DAYS.between(GODATE.getValue(),BACKDATE.getValue())); 
        });
        
        BACKDATE.setMaxWidth(500);
        BACKDATE.setShowWeekNumbers(false);
        BACKDATE.setPrefHeight(40);
        BACKDATE.setPromptText("Arrival Date");        
        BACKDATE.setDayCellFactory(picker -> new DateCell(){
            @Override
            public void updateItem(LocalDate BONJOUR, boolean empty) {
                super.updateItem(BONJOUR, empty);  
                //Blocks booking before today - no back in time
                LPICK = GODATE.getValue().plusDays(1);
                CONDI = (BONJOUR.isBefore(LPICK));
                if (CONDI){
                    setDisable(true);
                    setStyle("-fx-background-color: #d3d3d3;");
                }else{
                    setDisable(false);
                    setStyle("-fx-background-color: #CCFFFF;");
                    setStyle("-fx-font-fill: black;");
                } 
                if (BONJOUR.isAfter(LPICK.minusDays(1)) && BONJOUR.isBefore(BACKDATE.getValue().plusDays(1))) {
                    setStyle("-fx-background-color: #ff6600;");
                    setFont(new Font("Comic Sans MS", 11));
                }
            }   
        });                
    } 
    
    public Scene getScreen(){
        return ENTRANCE;
    }
}
