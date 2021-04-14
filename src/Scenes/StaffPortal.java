package Scenes;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StaffPortal {
    Scene ENTRANCE;
    Image IMG;
    BackgroundImage BCIMG;
    TableView TABLE;
    TableColumn DATE,RESERVATION,NAME,SURNAME,ORIGIN,DEST,PAX;
    BorderPane PANE;
    
    public StaffPortal(Stage MAINWINDOW){
        //background image    
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        //tableview
        TABLE = new TableView();
        TABLE.setEditable(true);
        
        //columns
        DATE = new TableColumn("Date");
        DATE.setMinWidth(200);
        RESERVATION = new TableColumn("Reservation");
        RESERVATION.setMinWidth(200);
        NAME = new TableColumn("Name");
        NAME.setMinWidth(200);
        SURNAME = new TableColumn("Surname");
        SURNAME.setMinWidth(200);
        ORIGIN = new TableColumn("Origin");
        ORIGIN.setMinWidth(200);
        DEST = new TableColumn("Dest");
        DEST.setMinWidth(200);
        PAX = new TableColumn("Pax");
        PAX.setMinWidth(200);
        
        //adding columns to table
        TABLE.getColumns().addAll(DATE,RESERVATION,NAME,SURNAME,ORIGIN,DEST,PAX);
        
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setCenter(TABLE);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE;
    }
}
