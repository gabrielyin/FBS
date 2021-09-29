package Scenes;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
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
    HBox BOTTOM;
    SearchFlight HOME;
    MyAccount MYACCOUNT;
    BorderPane PANE;
    VBox MAINLEFT,MAINRIGHT;
    HBox CONTAINER;
    Text SUMMARY,FLIGHTNUM,DEP,ARR,DEPARDATE,FTIME,DIS,PLANE,SEATS,BAG,HANDBAGS,RESCODE,FINA,CLASS,PRICE,FEES;
    String CODEME; 
    
    Random RESV;
    Decorum PROP;
    FlightResults FRES;
    
    public FlightSummary(Stage MAINWINDOW,String USER, Integer SUM1, String GOCITY, String BACKCITY, Integer SUMBAGS,String STYLESEAT) throws IOException{
        PROP = new Decorum();
        FRES = new FlightResults(MAINWINDOW,USER,GOCITY,BACKCITY);
        
        //left box
        MAINLEFT = new VBox();
        SUMMARY = new Text("SUMMARY");
        FLIGHTNUM = new Text("Flight Number: "+FRES.INFO01.getText());
        DEP = new Text("Departure Airport: "+GOCITY);
        ARR = new Text("Arrival Airport: "+BACKCITY);
        DEPARDATE = new Text("Departs: "+FRES.INFO03.getText());
        FTIME = new Text("Flight Time: "+FRES.INFO04.getText());
        DIS = new Text("Distance: "+FRES.INFO06.getText()+"kms");
        PLANE = new Text("Aircraft: "+FRES.INFO02.getText());
        SEATS = new Text("Seat(s): "+String.valueOf(SUM1));
        BAG = new Text("Bags: "+SUMBAGS);
        HANDBAGS = new Text("Hand Baggage: "+String.valueOf(SUM1));
        MAINLEFT.setPadding(new Insets(80,70,0,0));
        MAINLEFT.setSpacing(20);
        MAINLEFT.getChildren().addAll(SUMMARY,FLIGHTNUM,DEP,ARR,DEPARDATE,FTIME,DIS,PLANE,SEATS,BAG,HANDBAGS);
            
        //right box
        MAINRIGHT = new VBox();
        RESV = new Random();
        for (int k = 0;k<3;k++){
            int N = RESV.nextInt(10);
            if (k>0){
                CODEME = CODEME+String.valueOf(N);
            }else{
                CODEME = String.valueOf(N);                
            }
        }    
        RESCODE = new Text("Reservation Code: "+FRES.INFO1.getText().substring(0,3)+CODEME);
        FINA = new Text("FINANCIAL SUMMARY");
        CLASS = new Text("Class: "+STYLESEAT);
        PRICE = new Text("Ticket Price: £"+FRES.INFO07.getText());
        FEES = new Text("Fees & Costs: £"+SUM1*Integer.parseInt(FRES.INFO07.getText()));
        MAINRIGHT.setPadding(new Insets(80,0,0,70));
        MAINRIGHT.setSpacing(20);
        MAINRIGHT.getChildren().addAll(RESCODE,FINA,CLASS,PRICE,FEES);
      
        //main container
        CONTAINER = new HBox();
        CONTAINER.setAlignment(Pos.CENTER);
        CONTAINER.getChildren().addAll(MAINLEFT,MAINRIGHT);
        
        //continue button & price
        Button CONTINUE = new Button("Purchase");
        CONTINUE.setOnAction(e->{
            try {
                HOME = new SearchFlight(MAINWINDOW,USER);
            } catch (IOException ex) {
                Logger.getLogger(FlightSummary.class.getName()).log(Level.SEVERE, null, ex);
            }
            MAINWINDOW.setScene(HOME.getScreen());
        });
        
        //bottom hbox
        BOTTOM = new HBox();
        BOTTOM.setAlignment(Pos.BASELINE_RIGHT);
        BOTTOM.setPadding(new Insets(0,60,30,0));
        BOTTOM.getChildren().addAll(CONTINUE);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(PROP.BCIMG));
 
        PANE.setCenter(CONTAINER);
 
        PANE.setBottom(BOTTOM);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE;
    }
}
