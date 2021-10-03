package Scenes;

import Controllers.FlightController;
import Modules.LineFlight;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.Region;
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
    HBox MENUBAR1,BOX1,BOX11,BOX2,BOX3,INPLANE,HBOX;
    HBox[] SEATMAP1,SEATMAP2,SEATMAP3;
    VBox CONTAINER,VBOX1,VBOX2,VBOX3;
    MyAccount MYACCOUNT;
    Button MENU1,MENU2,MENU3,CONTINUE;
    Text FLIGHTNUM,FLIGHT,PLANE;
    Label BUSINESS,ECONOMYPLUS,ECONOMY,OCCUPIED;
    Passengers PASSENGER;
    Region RECT;
    Rectangle[] BOBOX;
    Rectangle[][] SEATS1,SEATS2,SEATS3;
    Integer[][] ALLOCATION1,ALLOCATION2,ALLOCATION3;
    Integer SUM0, SUM1, SUM2, SUM3,SUMX;
    StackPane STACK;
    String STYLESEAT;
    final int INDEX = 0;
    
    Decorum PROP;
    FlightController LINES;
    LineFlight LINEFLIGHT;  
    
    public SeatMap(Stage MAINWINDOW, String USER, Integer index, String GOCITY, String BACKCITY) throws IOException{
        LINEFLIGHT = new LineFlight();
        LINES = new FlightController();        
        PROP = new Decorum();
        //first hbox
        BOX1 = new HBox();
        
        FLIGHTNUM = new Text();
        FLIGHTNUM.setText(LINES.getStructure().get(index).getFlightN2());
        FLIGHTNUM.setStyle("-fx-font: 18 arial;");
        
        FLIGHT = new Text();
        FLIGHT.setText(LINES.getStructure().get(index).getFlightItself());
        FLIGHT.setStyle("-fx-font: 18 arial;");
        
        PLANE = new Text();
        PLANE.setText(LINES.getStructure().get(index).getFlightN1());
        PLANE.setStyle("-fx-font: 18 arial;");
        
        BOX1.setAlignment(Pos.TOP_CENTER);
        BOX1.setPadding(new Insets(10,0,10,0));
        BOX1.setSpacing(50);
        BOX1.getChildren().addAll(FLIGHTNUM,FLIGHT,PLANE);
        
        //second hbox
        BOBOX = new Rectangle[3];        
        for (int k = 0;k<3;k++){
            BOBOX[k] = new Rectangle();
            BOBOX[k].setHeight(20);
            BOBOX[k].setWidth(20);              
        } 
        RECT = new Region();
        RECT.setStyle("-fx-background-color: red; -fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black; -fx-min-width: 20; -fx-min-height:20; -fx-max-width:20; -fx-max-height: 20;");        
        BOBOX[0].setFill(Color.GOLD);
        BUSINESS = new Label(" Business   ",BOBOX[0]);
        BOBOX[1].setFill(Color.SILVER);         
        ECONOMYPLUS = new Label(" Economy Plus   ",BOBOX[1]);
        BOBOX[2].setFill(Color.BURLYWOOD);         
        ECONOMY = new Label(" Economy   ",BOBOX[2]);
        OCCUPIED = new Label(" Occupied   ",RECT);

        BOX2 = new HBox();        
        BOX2.setAlignment(Pos.TOP_CENTER);
        BOX2.setPadding(new Insets(10,0,10,0));
        BOX2.getChildren().addAll(BUSINESS,ECONOMYPLUS,ECONOMY,OCCUPIED);
        
        // Seat map A
        VBOX1 = new VBox(4);
        Rectangle[][] rectA = new Rectangle[4][4];
        for (int i = 0; i < 4; i++) {
            HBOX = new HBox(4);
            for (int j = 0; j < 4; j++) {
                rectA[i][j] = new Rectangle();
                rectA[i][j].setHeight(25);
                rectA[i][j].setWidth(25);
                rectA[i][j].setId("A" + (j+1+(i*4)));
                rectA[i][j].setFill(Color.GOLD);
                
                int I = i;
                int J = j;
                rectA[i][j].setOnMouseClicked((MouseEvent e) -> {
                    rectA[I][J].setFill(Color.BLACK);
                    System.out.println(rectA[I][J].getId());
                });
                HBOX.getChildren().add(rectA[i][j]);
            }
            VBOX1.setPadding(new Insets(4,0,0,0));
            VBOX1.getChildren().add(HBOX);
        }
        
        // Seat map B
        VBOX2 = new VBox(3.2);
        Rectangle[][] rectB = new Rectangle[5][5];
        for (int i = 0; i < 5; i++) {
            HBOX = new HBox(3.2);
            for (int j = 0; j < 5; j++) {
                rectB[i][j] = new Rectangle();
                rectB[i][j].setHeight(20);
                rectB[i][j].setWidth(20);
                rectB[i][j].setId("B" + (j+1+(i*5)));
                rectB[i][j].setFill(Color.SILVER);
                
                int I = i;
                int J = j;
                rectB[i][j].setOnMouseClicked((MouseEvent e) -> {
                    rectB[I][J].setFill(Color.BLACK);
                });
                HBOX.getChildren().add(rectB[i][j]);
            }
            VBOX2.setPadding(new Insets(3.2,0,0,0));
            VBOX2.getChildren().add(HBOX);
        }
        
        // Seat map C
        VBOX3 = new VBox(2.28);
        Rectangle[][] rectC = new Rectangle[7][10];
        for (int i = 0; i < 7; i++) {
            HBOX = new HBox(2.28);
            for (int j = 0; j < 10; j++) {
                rectC[i][j] = new Rectangle();
                rectC[i][j].setHeight(14.28);
                rectC[i][j].setWidth(14.28);
                rectC[i][j].setId("C" + (j+1+(i*7)));
                rectC[i][j].setFill(Color.BURLYWOOD);
                
                int I = i;
                int J = j;
                rectC[i][j].setOnMouseClicked((MouseEvent e) -> {
                    rectC[I][J].setFill(Color.BLACK);
                });
                HBOX.getChildren().add(rectC[i][j]);
            }
            VBOX3.setPadding(new Insets(2.28,0,0,0));
            VBOX3.getChildren().add(HBOX);
        }
                    
        BOX3 = new HBox();
        CONTINUE = new Button("Continue");
        CONTINUE.setOnAction(e->{
            int totalPassengers = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (rectA[i][j].getFill().equals(Color.BLACK)) totalPassengers++;
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (rectB[i][j].getFill().equals(Color.BLACK)) totalPassengers++;
                }
            }
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 10; j++) {
                    if (rectC[i][j].getFill().equals(Color.BLACK)) totalPassengers++;
                }
            }

            STYLESEAT = "Economy";
            try {
                PASSENGER = new Passengers(MAINWINDOW, USER, index, totalPassengers,FLIGHTNUM, GOCITY, BACKCITY,STYLESEAT);
            } catch (IOException ex) {
                Logger.getLogger(SeatMap.class.getName()).log(Level.SEVERE, null, ex);
            }
            MAINWINDOW.setScene(PASSENGER.getScreen());
        });
        
        BOX3.setPadding(new Insets(10,0,10,0));
        BOX3.setAlignment(Pos.CENTER);
        BOX3.setSpacing(400);
        BOX3.getChildren().add(CONTINUE);
        
        //main container
        BG= new BackgroundImage(new Image("Plane.png",1000,300,false,true),
            BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, 
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        
        // Boxes to distribute the seat map
        INPLANE = new HBox(20);
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
        
        ENTRANCE = new Scene(PANE,600,800,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    
    public Scene getScreen(){
        return ENTRANCE;
    }
}
