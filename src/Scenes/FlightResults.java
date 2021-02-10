package Scenes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FlightResults {
    Scene ENTRANCE3;
    BackgroundImage BCIMG;
    BorderPane PANE;
    HBox MENUBAR1,BOX1,BOX2;
    Image IMG;
    Button MENU1,MENU2,MENU3,CONTINUE;
    ComboBox TIME,DURATION,DISTANCE;
    RadioButton NONSTOP;
    Label CURRENTDATE;
    ScrollPane SCROLL;
    
    MyAccount MYACCOUNT;
            
    public FlightResults(Stage MAINWINDOW) throws IOException{
        //background logo
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        //menu bar
        MENUBAR1 = new HBox();
        MENUBAR1.setId("MENUBAR");
        MYACCOUNT = new MyAccount(MAINWINDOW);
        //search flight
        MENU1 = new Button("Search Flights");
        //flight status
        MENU2 = new Button("Flight Status");
        //account
        MENU3 = new Button("My Account");
        MENU3.setOnAction(e->{
            System.out.println("My Account selected");
            MAINWINDOW.setScene(MYACCOUNT.getScreen());
        });
        //adding menu items to menubar
        MENUBAR1.getChildren().addAll(MENU1,MENU2,MENU3);
        
        //comboboxes
        TIME = new ComboBox();
        TIME.setEditable(true);
        DURATION = new ComboBox();
        DURATION.setEditable(true);
        DISTANCE = new ComboBox();
        DISTANCE.setEditable(true);

        //radiobuttons
        NONSTOP = new RadioButton();
        NONSTOP.setText("Nonstop");
        
        //button management
        CONTINUE = new Button("Continue");
        
        //getting current date
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();
        CURRENTDATE = new Label((DTF.format(now)));
        
        //HBoxes
        BOX1 = new HBox();
        BOX1.setPadding(new Insets(10,0,0,0));
        BOX1.getChildren().addAll(CURRENTDATE,TIME,DURATION,DISTANCE,NONSTOP,CONTINUE);
        BOX1.setSpacing(30);
        BOX1.setAlignment(Pos.TOP_CENTER);
        
        BOX2 = new HBox();
        BOX2.getChildren().addAll();

        //scrollpane management
        SCROLL = new ScrollPane();
        SCROLL.setContent(BOX2);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR1);
        PANE.setCenter(BOX1);

        ENTRANCE3 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE3.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE3;
    }
}
