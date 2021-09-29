package Scenes;

import Controllers.BookingController;
import Modules.Booking;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StaffPortal {
    Label LABEL;
    TextField TFIELD;
    TableView<Booking> TABLE;
    TableColumn DATE,RESERVATION,NAME,ORIGIN,DEST,PAX;
    TableViewSelectionModel SELECT; 
    ObservableList GETIT;
    Integer INDEX;
    Button CHECKP, CHECKA, CHECKD, CHECKN, BACK;
    HBox BTABLE,CCBOX;
    VBox BBOX;
    BorderPane PANE;
    Scene ENTRANCE;

    Mainwindow MAINONE;
    BookingController BOOKINGCONTROLLER;
    Decorum PROP;
    GetRecordRight GETIT2;
    
    public StaffPortal(Stage MAINWINDOW){
        PROP = new Decorum();         
        BOOKINGCONTROLLER = new BookingController();

        LABEL = new Label("STAFF CHECKING");
        TFIELD = new TextField();
        TFIELD.setMaxWidth(80);
        
        //tableview
        TABLE = new TableView();
        TABLE.setEditable(true);
        TABLE.setPlaceholder(new Label("No rows to display"));        
        
        PopulateColumns();        

        TABLE.getColumns().addAll(DATE,RESERVATION,NAME,ORIGIN,DEST,PAX);
        TABLE.setItems(FXCollections.observableList(BOOKINGCONTROLLER.read()));        
        SELECT = TABLE.getSelectionModel();
        SELECT.setSelectionMode(SelectionMode.SINGLE);
        GETIT = SELECT.getSelectedItems();
        TABLE.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("Selected row: "
                + newValue.getName()+ " | "
                + newValue.getOrigin() + " | " + newValue.getDest());
                INDEX = newValue.getReservation();
            }
            try {
                GETIT2 = new GetRecordRight(MAINWINDOW,INDEX,BOOKINGCONTROLLER,
                        newValue.getDate(),newValue.getReservation(),newValue.getName(),
                        newValue.getOrigin(),newValue.getDest(),newValue.getPax());
             } catch (IOException ex) {
                Logger.getLogger(StaffPortal.class.getName()).log(Level.SEVERE, null, ex);
            }
            MAINWINDOW.setScene(GETIT2.getScreen());
        });     
        
        CHECKD=new Button("DATE");   
        CHECKD.setOnAction(e->{
            TFIELD.getText();            
            Checkme(0);
        }); 
        CHECKN=new Button("NAME");   
        CHECKN.setOnAction(e->{
            TFIELD.getText();            
            Checkme(2);
        });
        
        CHECKP=new Button("DEPARTURE");   
        CHECKP.setOnAction(e->{
            TFIELD.getText();            
            Checkme(3);
        }); 
        CHECKA=new Button("ARRIVAL");   
        CHECKA.setOnAction(e->{
            TFIELD.getText();            
            Checkme(4);
        });        
        
        BACK=new Button("BACK");
        BACK.setOnAction(e->{        
            MAINONE = new Mainwindow(MAINWINDOW);
            MAINWINDOW.setScene(MAINONE.getScreen());            
        }); 
        
        BTABLE = new HBox();
        BTABLE.getChildren().add(TABLE);
        BTABLE.setAlignment(Pos.CENTER);
        CCBOX = new HBox(5);
        CCBOX.getChildren().addAll(TFIELD,CHECKD,CHECKN,CHECKP,CHECKA);
        CCBOX.setAlignment(Pos.CENTER);          
        BBOX = new VBox(20);
        BBOX.getChildren().addAll(LABEL,CCBOX,BTABLE,BACK);
        BBOX.setAlignment(Pos.CENTER);        
        
        PANE = new BorderPane();
        PANE.setBackground(new Background(PROP.BCIMG));        
        PANE.setCenter(BBOX);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    
    public void PopulateColumns(){
        //columns
        DATE = new TableColumn("Date");
        DATE.setMinWidth(100);        
        DATE.setCellValueFactory(new PropertyValueFactory<>("Date"));

        RESERVATION = new TableColumn("Reservation");
        RESERVATION.setMinWidth(80);
        RESERVATION.setCellValueFactory(new PropertyValueFactory<>("Reservation"));
        RESERVATION.setStyle( "-fx-alignment: CENTER;");        

        NAME = new TableColumn("Name");
        NAME.setMinWidth(80);
        NAME.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
        ORIGIN = new TableColumn("Departure");
        ORIGIN.setCellValueFactory(new PropertyValueFactory<>("Origin"));
        ORIGIN.setMinWidth(80);
        DEST = new TableColumn("Arrival");
        DEST.setCellValueFactory(new PropertyValueFactory<>("Dest"));
        DEST.setMinWidth(80);
        
        PAX = new TableColumn("Pax");
        PAX.setMinWidth(50);
        PAX.setCellValueFactory(new PropertyValueFactory<>("Pax"));
        PAX.setStyle( "-fx-alignment: CENTER;");         
    }
    
    public void Checkme(Integer CHECK){
        if(TFIELD.getText().length() != 0) {
            TABLE.getItems().clear();
            TABLE.setItems(FXCollections.observableList(BOOKINGCONTROLLER.readme(TFIELD.getText(),CHECK)));        
        }   
    }
    
    public Scene getScreen(){
        return ENTRANCE;
    }
}
