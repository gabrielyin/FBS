package Scenes;

import Controllers.BookingController;
import Controllers.FlightController;
import Modules.Pax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Passengers {
    Scene ENTRANCE;
    BorderPane PANE;
    Button CONTINUE;
    SearchFlight HOME;
    MyAccount MYACCOUNT;
    VBox MAINBOX;
    HBox BOX1,BOX2,BOTTOM;
    HBox[] BOXARRAY;
    TextField[] PASSPORTNO,NAME,SURNAME;
    ComboBox[] GENDER,BAGS;
    FlightSummary FLIGHTSUMMARY;
    Integer PAXNUM, SUMBAGS;
    FileReader PAXINFO;
    String MYBOOK;
    BufferedReader BUFFEREDREADER;
    String[] FILEDATA;
    Pax PAX;
    SearchFlight MYNEWCLASS;
    private Scanner FILE;
    int RESERVATION;
    Random RANDOMM;

    FlightResults FLIGHTRESULTS;
    FlightController LINES;
    DateTimeFormatter DTF2;
    LocalDateTime NOW2;
    BookingController BOOKINGCONTROLLER;
    Decorum PROP;
    
    public Passengers(Stage MAINWINDOW,String USER,Integer index,
            Integer SUM1, Text FLIGHTNUM, String GOCITY,String BACKCITY, String STYLESEAT) throws IOException{
        PROP = new Decorum();
        BOOKINGCONTROLLER = new BookingController();
         
        //confirmation boxes
        MAINBOX = new VBox();
        LINES = new FlightController(); 
        SUMBAGS= 0;
        
        CountBags(SUM1);
      
        //bottom part of scene
        RANDOMM = new Random();
        MYBOOK ="";
        CONTINUE = new Button("Continue");
        CONTINUE.setOnAction(e->{
        for (int i = 0; i < 3; i++) {
            RESERVATION = RANDOMM.nextInt(10);
            MYBOOK=MYBOOK+MYBOOK.valueOf(RESERVATION);            
        }
        RESERVATION = Integer.parseInt(MYBOOK);
            try {
                FLIGHTSUMMARY = new FlightSummary(MAINWINDOW, USER, SUM1, GOCITY, BACKCITY,CountBags(SUM1),STYLESEAT);
            } catch (IOException ex) {
                Logger.getLogger(Passengers.class.getName()).log(Level.SEVERE, null, ex);
            }
            DTF2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
            NOW2 = LocalDateTime.now();
            BOOKINGCONTROLLER.create(DTF2.format(NOW2), RESERVATION, USER, GOCITY, BACKCITY, readStuff());
            MAINWINDOW.setScene(FLIGHTSUMMARY.getScreen());
        });
        
        //adding button to bottom hbox
        BOTTOM = new HBox();
        BOTTOM.setAlignment(Pos.BASELINE_RIGHT);
        BOTTOM.setPadding(new Insets(0,60,30,0));
        BOTTOM.getChildren().addAll(CONTINUE);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(PROP.BCIMG));
        PANE.setTop(PROP.Bars(MAINWINDOW, USER));
        PANE.setCenter(MAINBOX);
        PANE.setBottom(BOTTOM);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }

    public Integer CountBags(Integer SUM1){
        BOXARRAY = new HBox[SUM1];
        PASSPORTNO = new TextField[SUM1];
        NAME = new TextField[SUM1];
        SURNAME = new TextField[SUM1];
        GENDER = new ComboBox[SUM1];
        BAGS = new ComboBox[SUM1];
        
        for (int i = 0; i < SUM1; i++) {
            BOXARRAY[i] = new HBox();
            BOXARRAY[i].setPadding(new Insets(10,0,0,0));
            BOXARRAY[i].setSpacing(10);
            BOXARRAY[i].setAlignment(Pos.TOP_CENTER);

            PASSPORTNO[i] = new TextField();
            PASSPORTNO[i].setPromptText("Passport Number");
            NAME[i] = new TextField();
            NAME[i].setPromptText("Name");
            SURNAME[i] = new TextField();
            SURNAME[i].setPromptText("Surname");            
            GENDER[i] = new ComboBox();
            GENDER[i].setPromptText("Gender");
            GENDER[i].getItems().addAll("Male","Female");
            BAGS[i] = new ComboBox();
            BAGS[i].setPromptText("Bags");
            BAGS[i].getItems().addAll(1,2);
            BAGS[i].getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                SUMBAGS = SUMBAGS + (Integer)newValue;
                System.out.println("1:"+SUMBAGS);
            }); 
            BOXARRAY[i].getChildren().addAll(PASSPORTNO[i],NAME[i],SURNAME[i],GENDER[i],BAGS[i]);
            MAINBOX.getChildren().addAll(BOXARRAY[i]);
        }        
        return SUMBAGS;
    }
    
    public Scene getScreen(){
        return ENTRANCE;
    }
    
    public int readStuff(){
        try {
            PAXINFO = new FileReader("test/paxinfo.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Passengers.class.getName()).log(Level.SEVERE, null, ex);
        }
        FILE = new Scanner(PAXINFO);
        int last = 0;
        while(FILE.hasNext()){
            FILEDATA = FILE.nextLine().split(",");
//            System.out.println("Recorded passengers: " + FILEDATA[4]);
            last = Integer.valueOf(FILEDATA[4]);
        }
        
        return last;
    }
}
