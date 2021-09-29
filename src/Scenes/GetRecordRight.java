package Scenes;

import Controllers.BookingController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GetRecordRight {
    TextField DATE,RESERVATION,NAME,ORIGIN,DESTINATION,PAX;
    Button SAVE,BACK;
    VBox MID;
    BorderPane PANE;
    Scene ENTRANCE;
    
    Decorum PROP;
    StaffPortal SPORTAL;
    
    public GetRecordRight(Stage MAINWINDOW,Integer INDEX,BookingController BOOKINGCONTROLLER,
            String DATE2, Integer RESERV, String NAME2, String ORIGIN2, String DEST2, Integer PAX2) throws IOException{
        
        PROP = new Decorum();
        DATE = new TextField();
        DATE.setText(DATE2);        
        RESERVATION = new TextField();        
        RESERVATION.setText(String.valueOf(RESERV));        
        NAME = new TextField();
        NAME.setText(NAME2);
        ORIGIN = new TextField();
        ORIGIN.setText(ORIGIN2);
        DESTINATION = new TextField();
        DESTINATION.setText(DEST2);
        PAX = new TextField();
        PAX.setText(String.valueOf(PAX2));        
        SAVE = new Button("SAVE");
        SAVE.setOnAction(e->{
            try {            
                BOOKINGCONTROLLER.delete(INDEX);
            } catch (IOException ex) {
                Logger.getLogger(GetRecordRight.class.getName()).log(Level.SEVERE, null, ex);
            }
                BOOKINGCONTROLLER.create(DATE.getText(), Integer.parseInt(RESERVATION.getText()), NAME.getText(),
                        ORIGIN.getText(), DESTINATION.getText(), Integer.parseInt(PAX.getText()));            
        });         
        
        BACK = new Button("BACK");
        BACK.setOnAction(e->{
            SPORTAL = new StaffPortal(MAINWINDOW);
            MAINWINDOW.setScene(SPORTAL.getScreen()); 
        });        

        MID = new VBox(10);
        MID.getChildren().addAll(DATE,RESERVATION,NAME, ORIGIN, DESTINATION,PAX,SAVE,BACK);
        MID.setPadding(new Insets(0,150,10,150));
        MID.setAlignment(Pos.CENTER);           
        
        PANE = new BorderPane();
        PANE.setBackground(new Background(PROP.BCIMG));
        PANE.setTop(PROP.Bars(MAINWINDOW,"STAFF"));
        PANE.setCenter(MID);
        
        ENTRANCE = new Scene(PANE,600,800,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");        
    }
    
    public Scene getScreen(){
        return ENTRANCE;
    }    
}
