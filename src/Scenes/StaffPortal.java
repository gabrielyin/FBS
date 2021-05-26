package Scenes;

import Controllers.BookingController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    BookingController BOOKINGCONTROLLER;
    
    public StaffPortal(Stage MAINWINDOW){
        BOOKINGCONTROLLER = new BookingController();
        
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
        
        //adding columns to table
        TABLE.setItems(FXCollections.observableList(BOOKINGCONTROLLER.read()));
        
        //columns
        DATE = new TableColumn("Date");
        DATE.setCellValueFactory(new PropertyValueFactory<>("Date"));
        DATE.setMinWidth(200);
        RESERVATION = new TableColumn("Reservation");
        RESERVATION.setCellValueFactory(new PropertyValueFactory<>("Reservation"));
        RESERVATION.setMinWidth(200);
        NAME = new TableColumn("Name");
        NAME.setCellValueFactory(new PropertyValueFactory<>("Name"));
        NAME.setMinWidth(200);
        SURNAME = new TableColumn("Surname");
        SURNAME.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        SURNAME.setMinWidth(200);
        ORIGIN = new TableColumn("Origin");
        ORIGIN.setCellValueFactory(new PropertyValueFactory<>("Origin"));
        ORIGIN.setMinWidth(200);
        DEST = new TableColumn("Dest");
        DEST.setCellValueFactory(new PropertyValueFactory<>("Dest"));
        DEST.setMinWidth(200);
        PAX = new TableColumn("Pax");
        PAX.setCellValueFactory(new PropertyValueFactory<>("Pax"));
        PAX.setMinWidth(200);
        
        
        
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
