/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Scenes;

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
    HBox BOXOPTIONS,MINIBOX;
    ScrollPane SCROLL;
    ImageView[] V1IMG;
    Integer[] ACTION;
    Integer MAKE;
    
    public RibbonShapes(){
        BPANE = new BorderPane();
        
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        APRES = new Button(">");
        
        AVANT = new Button("<");
        
        MINIBOX = new HBox();
        V1IMG = new ImageView[5];
        ACTION = new Integer[5];
        
        for (MAKE = 0;  MAKE< 5; MAKE++) {
            ACTION[MAKE] = MAKE;
            V1IMG[MAKE] = new ImageView(new Image("H"+MAKE+".jpg"));
        }
        MINIBOX.getChildren().addAll(V1IMG);
        V1IMG[0].setOnMouseClicked((MouseEvent)->{
//            Action(0);
        });
        
        SCROLL = new ScrollPane();
        SCROLL.setContent(MINIBOX);
        SCROLL.pannableProperty().set(true);
        
        BOXOPTIONS = new HBox(20);
        BOXOPTIONS.getChildren().addAll(APRES,AVANT,SCROLL);
        BOXOPTIONS.setPadding(new Insets(40,40,0,40));
        BOXOPTIONS.setAlignment(Pos.CENTER);
        
        BPANE.setTop(BOXOPTIONS);
        BPANE.setBackground(new Background(BCIMG));
        ENTRANCE = new Scene(BPANE,450,800,Color.BLACK);
        ENTRANCE.getStylesheets().add("Decor.css");
//testing changes
//        changes
    }
    
    public Scene getScreen(){
        return ENTRANCE;
    }    
}
