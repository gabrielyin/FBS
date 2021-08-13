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
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyNewClass {
    Text TITLE;
    ToggleGroup TOGGLE;
    RadioButton ROUNDTRIP,ONEWAY;    
    HBox MID,ADULTBOX,INFANTBOX,RADIOBUTTONS;
    ChoiceBox DEPARTURE, ARRIVAL;    
    Integer CITYSELECT,DDAY;
    Object ITEM;    
    String GOCITY,BACKCITY,FILECONTENT;
    ComboBox CLASS;
    DatePicker GODATE,BACKDATE;
    Label ADULTS,INFANTS; 
    Button SEARCH;
    Boolean CONDI,TICONE=false;
    LocalDate TODAY,LPICK;    
    TextField IN,AD; 
    PrintWriter PAXINFO2;
    String[] PAXCONTENT,FILEDATA;
    Integer VAR5,PAXNUM;
    VBox MAINLEFT,MAINRIGHT,MAINRIGHT1,MAINRIGHT2;
    BorderPane PANE;
    Scene ENTRANCE;
    
    Decorum PROP;
    MenuFiller OPTIONS,OPTIONS2;  
    MyAccount MYACCOUNT;
    FlightStatus FLIGHTSTATUS;
    FlightResults FLIGHTRESULTS; 
    Passengers PASSENGERS;
    
    @SuppressWarnings("empty-statement")
    public MyNewClass(Stage MAINWINDOW, String NAMEUSER) throws IOException{
        PROP = new Decorum(); 

// Title management
        TITLE = new Text();
        TITLE.setText("Book a Flight");
  
// Date fields and management     
        GODATE = new DatePicker(LocalDate.now());
        GODATE.setMaxWidth(500);
        GODATE.setShowWeekNumbers(false);
        GODATE.setPrefHeight(40);
        GODATE.setPromptText("Departure Date");
        MAINRIGHT1 = new VBox(15);
        BACKDATE = new DatePicker(); 
        DPickMe();
        DPock();          
        
// Radio buttons management
        //round trip button
        TOGGLE = new ToggleGroup();
        ROUNDTRIP = new RadioButton();
        ROUNDTRIP.setText("Round Trip");
        ROUNDTRIP.setToggleGroup(TOGGLE);
        ROUNDTRIP.setDisable(true);
        ROUNDTRIP.setOnAction(e->{
            if(TICONE){
                MAINRIGHT1.getChildren().add(BACKDATE);
                MAINRIGHT1.setPadding(new Insets(0,0,0,0));                 
                TICONE=false;
            }
        });
        
        //oneway button
        ONEWAY = new RadioButton();
        ONEWAY.setText("One-Way");
        ONEWAY.setToggleGroup(TOGGLE);
        ONEWAY.setOnAction(e->{
            MAINRIGHT1.getChildren().remove(BACKDATE);
            MAINRIGHT1.setPadding(new Insets(0,0,55,0)); 
            TICONE = true;
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
        CLASS.getItems().addAll("Economy","Economy Plus","Business");
        CLASS.setOnAction((Event event) -> {
           System.out.println(CLASS.getValue()); 
        });
        
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

        SEARCH.setOnAction(e->{
            if (AD.getText()==null || AD.getText().trim().isEmpty()
                || IN.getText()==null || IN.getText().trim().isEmpty()    
                || DEPARTURE.getValue()==null
                || CLASS.getValue()==null
                || ARRIVAL.getValue()==null){
                System.out.println("Selection not completed");
            }else{
                //
                PAXCONTENT = new String[6];
                for (int i=0;i<6;i++){
                    PAXCONTENT[i]="0";
                    System.out.println();
                }
                    //storing departure and arrival airoprt in variabel
                PAXCONTENT[0] = (String) DEPARTURE.getSelectionModel().getSelectedItem();
                PAXCONTENT[1] = (String) ARRIVAL.getSelectionModel().getSelectedItem();
                BACKCITY = (String) ARRIVAL.getSelectionModel().getSelectedItem();
                PAXCONTENT[2] = GODATE.getValue().toString();

                //getting number of PASSENGERS
                PAXNUM = Integer.parseInt(AD.getText())+Integer.parseInt(IN.getText());
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!"+PAXNUM);
                if (!TICONE){
                    PAXCONTENT[3] = BACKDATE.getValue().toString();
                }
                    
                PAXCONTENT[4] = String.valueOf(Integer.parseInt(AD.getText())+Integer.parseInt(IN.getText()));

                //number = PAXCONTENT[4];
                //getting class
                PAXCONTENT[5] = (String) CLASS.getSelectionModel().getSelectedItem();
                try {
                    MyTrip(PAXCONTENT[0],PAXCONTENT[1],PAXCONTENT[2],PAXCONTENT[3],PAXCONTENT[4],PAXCONTENT[5]);
                    System.out.println("THIS IS NAMEUSER MYNEwclass"+ NAMEUSER);
                    FLIGHTRESULTS = new FlightResults(MAINWINDOW, NAMEUSER,GOCITY,BACKCITY);
                } catch (IOException ex) {
                    System.out.println("Error");
                }
                MAINWINDOW.setScene(FLIGHTRESULTS.getScreen());                
            }
        });
        
// Building the pane                
        MAINLEFT = new VBox(15);
        MAINLEFT.getChildren().addAll(TITLE,RADIOBUTTONS,DEPARTURE,GODATE,ADULTBOX,INFANTBOX);
        MAINLEFT.setPadding(new Insets(0,0,0,0));
        MAINLEFT.setAlignment(Pos.CENTER_LEFT);

        MAINRIGHT1.getChildren().addAll(ARRIVAL,BACKDATE);
        MAINRIGHT2 = new VBox(15);
        MAINRIGHT2.getChildren().addAll(CLASS,SEARCH);        
        MAINRIGHT = new VBox(15);        
        MAINRIGHT.getChildren().addAll(MAINRIGHT1,MAINRIGHT2);        
        MAINRIGHT.setPadding(new Insets(60,0,0,0));
        MAINRIGHT.setAlignment(Pos.CENTER_LEFT);

        MID = new HBox(10);
        MID.getChildren().addAll(MAINLEFT,MAINRIGHT);
        MID.setPadding(new Insets(0,0,10,0));
        MID.setAlignment(Pos.CENTER);   
                
        PANE = new BorderPane();
        PANE.setBackground(new Background(PROP.BCIMG));
        PANE.setTop(PROP.Bars(MAINWINDOW, NAMEUSER));
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
    
    public void MyTrip(String VAR1,String VAR2,String VAR3,String VAR4,String VAR5,String VAR6) throws IOException {
            PAXINFO2 = new PrintWriter(new FileWriter("test/paxinfo.txt",true));
            PAXINFO2.write(VAR1+","+VAR2+","+VAR3+","+VAR4+","+VAR5+","+VAR6+"\n");
            PAXINFO2.close();
    }
    
    public Scene getScreen(){
        return ENTRANCE;
    }
}
