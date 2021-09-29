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
    HBox MENUBAR1,BOX1,BOX11,BOX2,BOX3,INPLANE, HBOX1;
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
        BOBOX[0].setFill(Color.AQUA);
        BUSINESS = new Label(" Business   ",BOBOX[0]);
        BOBOX[1].setFill(Color.BURLYWOOD);         
        ECONOMYPLUS = new Label(" Economy Plus   ",BOBOX[1]);
        BOBOX[2].setFill(Color.GOLD);         
        ECONOMY = new Label(" Economy   ",BOBOX[2]);
        OCCUPIED = new Label(" Occupied   ",RECT);

        BOX2 = new HBox();        
        BOX2.setAlignment(Pos.TOP_CENTER);
        BOX2.setPadding(new Insets(10,0,10,0));
        BOX2.getChildren().addAll(BUSINESS,ECONOMYPLUS,ECONOMY,OCCUPIED);
        
        // Seat map
        VBOX1 = new VBox();
        HBOX1 = new HBox();
        Rectangle[][] rectA = new Rectangle[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Rectangle rect = new Rectangle();
                rect.setHeight(25);
                rect.setWidth(25);
                rect.setId("A" + (i+1+(j*4)));
                rect.setFill(Color.AQUA);
                rect.setOnMouseClicked((MouseEvent e) -> {
                    rect.setFill(Color.BLACK);
                });
                rectA[i][j] = rect;
                HBOX1.getChildren().add(rectA[i][j]);
            }
            VBOX1.getChildren().add(HBOX1);
        }
        
                
        VBOX2 = new VBox();
        Rectangle[][] rectB = new Rectangle[5][5];
                
        VBOX3 = new VBox();
        Rectangle[][] rectC = new Rectangle[7][10];
        
        BOX3 = new HBox();
        
        CONTINUE = new Button("Continue");
        CONTINUE.setOnAction(e->{
            SUM1 = 0;
            for (int k = 0;k<5;k++){
                for(int j = 0;j<4;j++){            
                    if(SEATS1[k][j].getFill().equals(Color.BLACK)){
                        SUM1 = SUM1 +1;
                    };                
                }
            } 
            SUM2 = 0;
            for (int k = 0;k<5;k++){
                for(int j = 0;j<8;j++){            
                    if(SEATS2[k][j].getFill().equals(Color.BLACK)){
                        SUM2 = SUM2 +1;
                    };                
                }
            }         
            SUM3 = 0;
            for (int k = 0;k<5;k++){
                for(int j = 0;j<10;j++){            
                    if(SEATS3[k][j].getFill().equals(Color.BLACK)){
                        SUM3 = SUM3 +1;
                    };                
                }
            }            
            SUM0 = SUM1+SUM2+SUM3;
            SUMX = Math.max(Math.max(SUM1,SUM2),SUM3);
            if (SUMX==SUM1){
                STYLESEAT = "Business";
            }
            else    if (SUMX==SUM2){
                        STYLESEAT = "Economy plus";                
                    }
                    else{
                        STYLESEAT = "Economy";                
                    }
            try {
                PASSENGER = new Passengers(MAINWINDOW, USER, index, SUM1,SUM0,
                        FLIGHTNUM, GOCITY, BACKCITY,STYLESEAT);
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
