package Scenes;

import Controllers.MenuFiller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    String GOCITY,BACKCITY;
    Integer CITYSELECT,DDAY;
    Object ITEM;
    Boolean CONDI,SELECT;
    Image IMG;
    BackgroundImage BCIMG;
    Text TITLE;
    ToggleGroup TOGGLE;
    RadioButton ROUNDTRIP,ONEWAY;
    ChoiceBox DEPARTURE, ARRIVAL;
    ComboBox CLASS;
    DatePicker GODATE,BACKDATE;
    LocalDate TODAY,LPICK;    
    TextField DEPDATE,IN,ARRDATE,AD; 
    Label ADULTS,INFANTS;     
    Button SEARCH,MENU1,MENU2,MENU3;
    VBox MAINLEFT,MAINRIGHT;
    HBox MID,ADULTBOX,INFANTBOX,RADIOBUTTONS,MENUBAR1;
    BorderPane PANE;
    Scene ENTRANCE;
    MyAccount MYACCOUNT;
    FlightStatus FLIGHTSTATUS;
    String VAR1,VAR2,VAR3,VAR4,VAR6;
    PrintWriter PAXINFO;
    Integer VAR5;
    
    MenuFiller OPTIONS,OPTIONS2;   
    FlightResults FLIGHTRESULTS;    
    
    public MyNewClass(Stage MAINWINDOW, String NAMEUSER) throws IOException{
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);

// Menubar management
        MENUBAR1 = new HBox();
        MENUBAR1.setId("MENUBAR");
        MYACCOUNT = new MyAccount(MAINWINDOW, NAMEUSER);
        FLIGHTSTATUS = new FlightStatus(MAINWINDOW, NAMEUSER);
        //search flight
        MENU1 = new Button("Search Flights");
        //flight status
        MENU2 = new Button("Flight Status");
        MENU2.setOnAction(e->{
            MAINWINDOW.setScene(FLIGHTSTATUS.getScreen());
        });
        //account
        MENU3 = new Button("My Account");
        MENU3.setOnAction(e->{
            MAINWINDOW.setScene(MYACCOUNT.getScreen());
        });
        //adding menu items to menubar
        MENUBAR1.getChildren().addAll(MENU1,MENU2,MENU3);

// Title management
        TITLE = new Text();
        TITLE.setText("Book a Flight");
        
// Radio buttons management
        //roud trip button
        TOGGLE = new ToggleGroup();
        ROUNDTRIP = new RadioButton();
        ROUNDTRIP.setText("Round Trip");
        ROUNDTRIP.setToggleGroup(TOGGLE);
        ROUNDTRIP.setDisable(true);
        ROUNDTRIP.setOnAction(e->{
            MAINRIGHT.getChildren().add(3,BACKDATE);
        });
        
        //oneway button
        ONEWAY = new RadioButton();
        ONEWAY.setText("One-Way");
        ONEWAY.setToggleGroup(TOGGLE);
        ONEWAY.setOnAction(e->{
            MAINRIGHT.getChildren().remove(BACKDATE);
            ROUNDTRIP.setDisable(false);
        });
        
        RADIOBUTTONS = new HBox(30);
        RADIOBUTTONS.getChildren().addAll(ROUNDTRIP,ONEWAY);
        RADIOBUTTONS.setAlignment(Pos.CENTER_LEFT);

// ChoiceBox management        
        DEPARTURE = new ChoiceBox();
        DEPARTURE.setMaxWidth(500);
        DEPARTURE.setPrefHeight(40);
        DEPARTURE.setTooltip(new Tooltip("Select Departure Airport"));
        ARRIVAL = new ChoiceBox();
        ARRIVAL.setMaxWidth(500);
        ARRIVAL.setPrefHeight(40);
        ARRIVAL.setTooltip(new Tooltip("Select Arrival Airport"));
        
        OPTIONS = new MenuFiller();
        OPTIONS.BoxFiller("test/Destination.txt", DEPARTURE,true,"");
        DEPARTURE.setOnAction((Event event) -> {
            CITYSELECT = DEPARTURE.getSelectionModel().getSelectedIndex();
            ITEM = DEPARTURE.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + CITYSELECT + "] " + ITEM);
            System.out.println("   DEPARTURE.getValue(): " + DEPARTURE.getValue());
            GOCITY = (String)DEPARTURE.getValue();
            OPTIONS2 = new MenuFiller(); 
            try {
                OPTIONS2.BoxFiller("test/Destination.txt", ARRIVAL,false,GOCITY);
            } catch (IOException ex) {
                System.out.println("Error"); 
            }
        });         
        
        CLASS = new ComboBox();
        CLASS.setMaxWidth(500);
        CLASS.setPrefHeight(40);
        CLASS.setPrefWidth(500);
        CLASS.setPromptText("Class");
        CLASS.setTooltip(new Tooltip("Select Class"));
        CLASS.getItems().add("Economy");
        CLASS.getItems().add("Economy Plus");
        CLASS.getItems().add("Business");

// Date fields and management        
        GODATE = new DatePicker(LocalDate.now());
        GODATE.setMaxWidth(500);
        GODATE.setShowWeekNumbers(false);
        GODATE.setPrefHeight(40);
        GODATE.setPromptText("Departure Date");
        BACKDATE = new DatePicker();
        DPickMe();
        DPock();        
        
//FAKE TITLTE
        Text TITLE2 = new Text();
        TITLE2.setText("");
        
        Text TITLE3 = new Text();
        TITLE2.setText("");
        
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
        FLIGHTRESULTS = new FlightResults(MAINWINDOW, NAMEUSER);
        SEARCH.setOnAction(e->{
            try{
            //storing departure and arrival airoprt in variabel
            VAR1 = (String) DEPARTURE.getSelectionModel().getSelectedItem();
            VAR2 = (String) ARRIVAL.getSelectionModel().getSelectedItem();
            //adding dates to variable
            VAR3 = GODATE.getValue().toString();
            VAR4 = BACKDATE.getValue().toString();
            //getting number of passengers
            VAR5 = Integer.parseInt(AD.getText())+Integer.parseInt(IN.getText());
            //getting class
            VAR6 = (String) CLASS.getSelectionModel().getSelectedItem();
            //adding these variables to txt file
            MyTrip(VAR1,VAR2,VAR3,VAR4,VAR5,VAR6);
            MAINWINDOW.setScene(FLIGHTRESULTS.getScreen());
            } catch (IOException ex){
                System.out.println("PROBLBEMS");
            }
        });
        
// Building the pane                
        MAINLEFT = new VBox(15);
        MAINLEFT.getChildren().addAll(TITLE,RADIOBUTTONS,DEPARTURE,GODATE,ADULTBOX,INFANTBOX);
        MAINLEFT.setPadding(new Insets(0,0,0,0));
        MAINLEFT.setAlignment(Pos.CENTER_LEFT);

        MAINRIGHT = new VBox(15);
        MAINRIGHT.getChildren().addAll(TITLE2,TITLE3,ARRIVAL,BACKDATE,CLASS,SEARCH);
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
    
    public void MyTrip(String VAR1,String VAR2,String VAR3,String VAR4,Integer VAR5,String VAR6) throws IOException {
            PAXINFO = new PrintWriter(new FileWriter("test/paxinfo.txt",true));
            PAXINFO.write(VAR1+","+VAR2+","+VAR3+","+VAR4+","+VAR5+","+VAR6+"\n");
            PAXINFO.close();
    }
    
    public Scene getScreen(){
        return ENTRANCE;
    }
}
