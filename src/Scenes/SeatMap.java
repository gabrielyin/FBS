package Scenes;

import Controllers.FlightController;
import Modules.LineFlight;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SeatMap {
    Image IMG;
    BackgroundImage BG;
    Scene ENTRANCE;
    BorderPane PANE;
    HBox MENUBAR1,BOX1,BOX2,BOX3,HBOX1,INPLANE;
    HBox[] SEATMAP1,SEATMAP2,SEATMAP3;
    VBox CONTAINER,VBOX1,VBOX2,VBOX3;
    MyAccount MYACCOUNT;
    Button MENU1,MENU2,MENU3,CONTINUE;
    Text FLIGHTNUM,FLIGHT,PLANE,SM,SELECTED;
    Label BUSINESS,ECONOMYPLUS,ECONOMY,OCCUPIED;
    Passengers PASSENGER;
    Rectangle[][] SEATS1,SEATS2,SEATS3;
    Integer LIGNE, COL;
    StackPane STACK;
    String F;
    
    Decorum PROP;
    FlightController LINES;
    LineFlight LINEFLIGHT;    
    
    public SeatMap(Stage MAINWINDOW, String USER, Integer i) throws IOException{
        LINEFLIGHT = new LineFlight();
        LINES = new FlightController();        
        PROP = new Decorum();
        //first hbox
        BOX1 = new HBox();
        
        FLIGHTNUM = new Text();
        FLIGHTNUM.setText(LINES.getStructure().get(i).getFlightN2());
        FLIGHTNUM.setStyle("-fx-font: 18 arial;");
        
        FLIGHT = new Text();
        FLIGHT.setText(LINES.getStructure().get(i).getFlightItself());
        FLIGHT.setStyle("-fx-font: 18 arial;");
        
        PLANE = new Text();
        PLANE.setText(LINES.getStructure().get(i).getFlightN1());
        PLANE.setStyle("-fx-font: 18 arial;");
        
        BOX1.setAlignment(Pos.TOP_CENTER);
        BOX1.setPadding(new Insets(10,0,10,0));
        BOX1.setSpacing(50);
        BOX1.getChildren().addAll(FLIGHTNUM,FLIGHT,PLANE);
        
        //second hbox
        BOX2 = new HBox();
        
        SM = new Text();
        SM.setText("Seat Map");
        
        BUSINESS = new Label("Business");
        ECONOMYPLUS = new Label("Economy Plus");
        ECONOMY = new Label("Economy");
        OCCUPIED = new Label("Occupied");
        
        BOX2.setAlignment(Pos.TOP_CENTER);
        BOX2.setPadding(new Insets(10,0,10,0));
        BOX2.setSpacing(200);
        BOX2.getChildren().addAll(SM,BUSINESS,ECONOMYPLUS,ECONOMY,OCCUPIED);
       
        //seat map
        HBOX1 = new HBox();
        
        //seatmap
        SEATMAP1 = new HBox[5];
        SEATS1 = new Rectangle[5][5];
        VBOX1 = new VBox(8);
          
        for (int k = 0;k<5;k++){
            SEATMAP1[k] = new HBox(8);
            for(int j = 0;j<4;j++){
                SEATS1[k][j] = new Rectangle();
                SEATS1[k][j].setHeight(20);
                SEATS1[k][j].setWidth(20);
                SEATS1[k][j].setFill(Color.AQUA); 
                LIGNE = k;
                COL = j;  
                SEATS1[k][j].setOnMouseClicked((MouseEvent e) -> {
                    Touch(LIGNE,COL);
                });
                
                
                SEATMAP1[k].getChildren().addAll(SEATS1[k][j]);
            }    
            VBOX1.getChildren().addAll(SEATMAP1[k]);            
        }
        
        SEATMAP2 = new HBox[5];
        SEATS2 = new Rectangle[5][15];
        VBOX2 = new VBox(8);
        
        for (int k = 0;k<5;k++){
            SEATMAP2[k] = new HBox(8);
            for(int j = 0;j<14;j++){
                SEATS2[k][j] = new Rectangle();
                SEATS2[k][j].setHeight(20);
                SEATS2[k][j].setWidth(20);
                SEATS2[k][j].setFill(Color.BURLYWOOD);            
                SEATMAP2[k].getChildren().addAll(SEATS2[k][j]);
            }    
            VBOX2.getChildren().addAll(SEATMAP2[k]);            
        }
        
        SEATMAP3 = new HBox[5];
        SEATS3 = new Rectangle[5][15];
        VBOX3 = new VBox(8);
        
        for (int k = 0;k<5;k++){
            SEATMAP3[k] = new HBox(8);
            for(int j = 0;j<14;j++){
                SEATS3[k][j] = new Rectangle();
                SEATS3[k][j].setHeight(20);
                SEATS3[k][j].setWidth(20);
                SEATS3[k][j].setFill(Color.GOLD);            
                SEATMAP3[k].getChildren().addAll(SEATS3[k][j]);
            }    
            VBOX3.getChildren().addAll(SEATMAP3[k]);            
        }        
        
        BOX3 = new HBox();
        
        SELECTED = new Text();
        SELECTED.setText("Seat(s) Selected: ");
        CONTINUE = new Button("Continue");
        PASSENGER = new Passengers(MAINWINDOW, USER);
        System.out.println("read done");
        CONTINUE.setOnAction(e->{
            MAINWINDOW.setScene(PASSENGER.getScreen());
        });
        
        BOX3.setPadding(new Insets(10,0,10,0));
        BOX3.setAlignment(Pos.CENTER);
        BOX3.setSpacing(800);
        BOX3.getChildren().addAll(SELECTED,CONTINUE);
        
        //main container
        INPLANE = new HBox(20);
        BG= new BackgroundImage(new Image("Plane.png",1000,300,false,true),
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
//then you set to your node
        INPLANE.setBackground(new Background(BG));        
        INPLANE.getChildren().addAll(VBOX1,VBOX2,VBOX3);
        INPLANE.setAlignment(Pos.CENTER);
        CONTAINER = new VBox();
        CONTAINER.getChildren().addAll(BOX1,BOX2,INPLANE,BOX3);
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(PROP.BCIMG));
        PANE.setTop(PROP.Bars(MAINWINDOW, USER));        
        PANE.setCenter(CONTAINER);
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public void Touch(Integer k, Integer j){
        System.out.println(LIGNE+"and"+COL);        
    }
    
    
    public Scene getScreen(){
        return ENTRANCE;
    }
}
