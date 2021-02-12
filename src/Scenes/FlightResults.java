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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FlightResults {
    Scene ENTRANCE3;
    BackgroundImage BCIMG;
    BorderPane PANE;
    HBox MENUBAR1,BOX1,BOX2;
    VBox MAINBOX,AIRPORTS,ECON,ECONPLUS,BUS;
    Image IMG;
    Button MENU1,MENU2,MENU3,CONTINUE;
    ComboBox TIME,DURATION,DISTANCE;
    RadioButton NONSTOP;
    Label CURRENTDATE,FLIGHT,INFO1,INFO2,INFO3,INFO4;
    ScrollPane SCROLL;
    Passengers PASSENGERS;
    MyNewClass HOME;
    
    MyAccount MYACCOUNT;
            
    public FlightResults(Stage MAINWINDOW, String USER) throws IOException{
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
        MYACCOUNT = new MyAccount(MAINWINDOW, USER);
        //search flight
        MENU1 = new Button("Search Flights");
        MENU1.setOnAction(e->{
            try{
                HOME = new MyNewClass(MAINWINDOW, USER); 
                MAINWINDOW.setScene(HOME.getScreen());
            }catch(IOException MyAccountError){
                System.out.println("My Account doesnt reach My New Class");
            }
        });
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
        PASSENGERS = new Passengers(MAINWINDOW, USER);
        CONTINUE.setOnAction(e->{
            System.out.println("Continue");
            MAINWINDOW.setScene(PASSENGERS.getScreen());
        });
        
        //getting current date
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();
        CURRENTDATE = new Label((DTF.format(now)));
        
        //flight results
        
        
        //HBoxes
        BOX1 = new HBox();
        BOX1.setPadding(new Insets(10,0,0,0));
        BOX1.getChildren().addAll(CURRENTDATE,TIME,DURATION,DISTANCE,NONSTOP,CONTINUE);
        BOX1.setSpacing(30);
        BOX1.setAlignment(Pos.TOP_CENTER);
        
        //box2 information
        INFO1 = new Label("GIG-LAX");
        INFO2 = new Label("Price economy");
        INFO3 = new Label("Price economy plus");
        INFO4 = new Label("Price business");
        
        //classes results
        AIRPORTS = new VBox();
        AIRPORTS.getChildren().addAll(INFO1);
        ECON = new VBox();
        ECON.getChildren().addAll(INFO2);
        ECONPLUS = new VBox();
        ECONPLUS.getChildren().addAll(INFO3);
        BUS = new VBox();
        BUS.getChildren().addAll(INFO4);
        
        //hbox box2
        BOX2 = new HBox();
        BOX2.getChildren().addAll(AIRPORTS,ECON,ECONPLUS,BUS);

        //scrollpane management
        SCROLL = new ScrollPane();
        SCROLL.setContent(BOX2);
        
        //main center box
        MAINBOX = new VBox();
        MAINBOX.getChildren().addAll(BOX1,SCROLL);
        MAINBOX.setSpacing(10);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR1);
        PANE.setCenter(MAINBOX);

        ENTRANCE3 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE3.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE3;
    }
}
