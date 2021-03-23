package Scenes;

import Modules.Pax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import javafx.stage.Stage;

public class Passengers {
    Scene ENTRANCE;
    BorderPane PANE;
    Button CONTINUE;
    MyNewClass HOME;
    MyAccount MYACCOUNT;
    VBox MAINBOX;
    HBox BOX1,BOX2,BOTTOM;
    HBox[] BOXARRAY;
    TextField PASSPORTNO,NAME,SURNAME;
    ComboBox GENDER,BAGS;
    FlightSummary FLIGHTSUMMARY;
    Integer COUNTER,PAXNUM;
    FileReader PAXINFO;
    String FILECONTENT;
    BufferedReader BUFFEREDREADER;
    String[] FILEDATA;
    Pax PAX;
    MyNewClass MYNEWCLASS;
    private Scanner FILE;
    
    Decorum PROP;
    
    public Passengers(Stage MAINWINDOW,String NAMEUSER) throws IOException{
        PROP = new Decorum();
         
        //confirmation boxes
        MAINBOX = new VBox();
        
        //prompt passport no
        PASSPORTNO = new TextField();
        PASSPORTNO.setPromptText("Passport Number");
        
        //prompt name & surname
        NAME = new TextField();
        NAME.setPromptText("Name");
        SURNAME = new TextField();
        SURNAME.setPromptText("Surname");
        
        //prompt gender
        GENDER = new ComboBox();
        GENDER.setPromptText("Gender");
        GENDER.getItems().addAll(
            "Male","Female"        
        );
        
        //prompt bags
        BAGS = new ComboBox();
        BAGS.setPromptText("Bags");
        BAGS.getItems().addAll(
            1,2
        );
      
        // read stuff
          
//        System.out.println("Last line " + FILE);
        BOXARRAY = new HBox[10];
        
        for (int i = 0; i < readStuff(); i++) {
//            System.out.println("gabriel to triste " + readStuff());
            BOX1 = new HBox();
            BOX1.setPadding(new Insets(10,0,0,0));
            BOX1.setSpacing(10);
            BOX1.setAlignment(Pos.TOP_CENTER);
             //prompt passport no
            PASSPORTNO = new TextField();
            PASSPORTNO.setPromptText("Passport Number");
        
            //prompt name & surname
            NAME = new TextField();
            NAME.setPromptText("Name");
            SURNAME = new TextField();
            SURNAME.setPromptText("Surname");

        
            //prompt gender
            GENDER = new ComboBox();
            GENDER.setPromptText("Gender");
            GENDER.getItems().addAll(
                "Male","Female"        
            );
        
            //prompt bags
            BAGS = new ComboBox();
            BAGS.setPromptText("Bags");
            BAGS.getItems().addAll(
                1,2
            );
            BOX1.getChildren().addAll(PASSPORTNO,NAME,SURNAME,GENDER,BAGS);
            BOXARRAY[i] = BOX1;
            MAINBOX.getChildren().addAll(BOXARRAY[i]);
        }
        
        //bottom part of scene
        CONTINUE = new Button("Continue");

        FLIGHTSUMMARY = new FlightSummary(MAINWINDOW, NAMEUSER);
        CONTINUE.setOnAction(e->{
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
        System.out.println("OSHHKAR"); 
//        PANE.setTop(PROP.Bars(MAINWINDOW, NAMEUSER));

        PANE.setCenter(MAINBOX);
        PANE.setBottom(BOTTOM);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
       
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
//        System.out.println("last is " + last);
        
        return last;
    }
}
