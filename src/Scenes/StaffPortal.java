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
        RESERVATION = new TableColumn("Reservation");
        NAME = new TableColumn("Name");
        SURNAME = new TableColumn("Surname");
        ORIGIN = new TableColumn("Origin");
        DEST = new TableColumn("Dest");
        PAX = new TableColumn("Pax");
        
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
