/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Scenes;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import static javafx.scene.layout.BackgroundPosition.CENTER;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author 2021g
 */
public class RibbonShapes {
    Scene ENTRANCE;
    BorderPane BPANE;
    Image IMG;
    BackgroundImage BCIMG;
    Button APRES,AVANT;
    Button[] HOUSE;
    HBox[] BOXSEAT;
    HBox BOXOPTIONS,MINIBOX;
    VBox BOXES;
    ScrollPane SCROLL;
    ImageView INTER;
    ImageView[] V1IMG;
    Integer[] ACTION;
    Integer MAKE,BINTER;
    
    public RibbonShapes(){
        BPANE = new BorderPane();
        
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        APRES = new Button(">");
        APRES.setOnAction((f) -> {
            MINIBOX.getChildren().clear();
            INTER = V1IMG[4];
            BINTER = ACTION[4];
            for (int i = 4; i > 0; i--) {
                V1IMG[i] = V1IMG[i-1];
                ACTION[i] = ACTION[i-1];
            }
            V1IMG[0]=INTER;
            ACTION[0]=BINTER;
            for (int i = 0; i < 5; i++) {
                MINIBOX.getChildren().addAll(V1IMG[i]);
            }
        });
        
        AVANT = new Button("<");
        AVANT.setOnAction((e) -> {
            MINIBOX.getChildren().clear();
            INTER = V1IMG[0];
            BINTER = ACTION[0];
            for (int i = 0; i < 4; i++) {
                V1IMG[i] = V1IMG[i+1];
                ACTION[i] = ACTION[i+1];
            }
            V1IMG[4] = INTER;
            ACTION[4] = BINTER;
            for (int i = 0; i < 5; i++) {
                MINIBOX.getChildren().addAll(V1IMG[i]);
            }
        });
        
        MINIBOX = new HBox();
        V1IMG = new ImageView[5];
        ACTION = new Integer[5];
        
        for (MAKE = 0;  MAKE< 5; MAKE++) {
            ACTION[MAKE] = MAKE;
            V1IMG[MAKE] = new ImageView(new Image("H"+MAKE+".jpg"));
        }
        MINIBOX.getChildren().addAll(V1IMG);
        V1IMG[0].setOnMouseClicked((MouseEvent)->{
            Action(0);
        });
        V1IMG[1].setOnMouseClicked((MouseEvent)->{
            Action(1);
        });
        V1IMG[2].setOnMouseClicked((MouseEvent)->{
            Action(2);
        });
        V1IMG[3].setOnMouseClicked((MouseEvent)->{
            Action(3);
        });
        V1IMG[4].setOnMouseClicked((MouseEvent)->{
            Action(4);
        });
        
        SCROLL = new ScrollPane();
        SCROLL.setContent(MINIBOX);
        SCROLL.pannableProperty().set(true);
        
        BOXOPTIONS = new HBox(20);
        BOXOPTIONS.getChildren().addAll(AVANT,SCROLL,APRES);
        BOXOPTIONS.setPadding(new Insets(40,40,0,40));
        BOXOPTIONS.setAlignment(Pos.CENTER);
        
        BOXSEAT = new HBox[4];
        BOXES = new VBox(2);
        for (int i = 0; i < 4; i++) {
            BOXSEAT[i] = new HBox(5);
            switch(i){
                case 0:
                    LineSeat(BOXSEAT[i],'A',3);
                    break;
                case 1:
                    LineSeat(BOXSEAT[i],'B',7);
                    break;
                case 2:
                    LineSeat(BOXSEAT[i],'C',7);
                    break;
                case 3:
                    LineSeat(BOXSEAT[i],'D',3);
                    break;
            }
        }
        
        BPANE.setTop(BOXOPTIONS);
        BPANE.setCenter(BOXES);
        BPANE.setBackground(new Background(BCIMG));
        ENTRANCE = new Scene(BPANE,450,800,Color.BLACK);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    
        public void Action(Integer ACTION){
            switch(ACTION){
                case 0:
                    System.out.println("ACTION A");
                    break;
                case 1:
                    System.out.println("ACTION B");
                    break;
                case 2:
                    System.out.println("ACTION C");
                    break;
                case 3:
                    System.out.println("ACTION D");
                    break;
                case 4:
                    System.out.println("ACTION E");
                    break;    
                
            }
        }
//testing changes
//        changes
        public void LineSeat(HBox BOXSEAT,Character LETTER,Integer NUMBER){
            HOUSE = new Button[NUMBER];
            for (int INDEX = 0; INDEX < NUMBER; INDEX++) {
                HOUSE[INDEX] = new Button(LETTER+Integer.toString(INDEX));
                HOUSE[INDEX].setGraphic(new ImageView(new Image("seat.png")));
                HOUSE[INDEX].setOnAction((ActionEvent e) -> {
                    System.out.println("Button pressed" + ((Button) e.getSource()).getText());
                });
                BOXSEAT.getChildren().add(HOUSE[INDEX]);
                if (NUMBER > 5) {
                    BOXSEAT.setPadding(new Insets(5,40,0,100));
                }else{
                    BOXSEAT.setPadding(new Insets(5,40,0,214));
                }
            }
            BOXES.getChildren().add(BOXSEAT);
        }
    
    public Scene getScreen(){
        return ENTRANCE;
    }    
}
