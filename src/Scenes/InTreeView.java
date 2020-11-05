/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Scenes;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author 2021g
 */
public class InTreeView {
    Label CHARACTER;
    Button FERME;
    Label LABEL;
    VBox DROITE,GAUCHE;
    BorderPane XPANE;
    ImageView IVIMG;
    Scene PERSON;
    String SURNAMEME,NAMEME,FEEDBACK;
            
    public InTreeView(Stage FILE, String SPLIT) throws IOException{
        CHARACTER = new Label(SPLIT);
        CHARACTER.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        
        NAMEME = "logo.png";
        IVIMG = new ImageView(new Image(NAMEME));
        IVIMG.setFitWidth(250);
        IVIMG.setFitHeight(300);
        IVIMG.setPreserveRatio(true);
        IVIMG.setSmooth(true);
        IVIMG.setCache(true);
        
        FERME = new Button("CLOSE");
        FERME.setOnAction(e -> {
            FILE.close();
        });
        
        DROITE = new VBox();
        DROITE.getChildren().add(IVIMG);
        DROITE.setPadding(new Insets(0,0,0,0));
        DROITE.setAlignment(Pos.CENTER);
        
        SURNAMEME = SPLIT+".txt";
        
        LABEL = new Label(FEEDBACK);
        
        GAUCHE = new VBox(5);
        GAUCHE.getChildren().addAll(CHARACTER,LABEL,FERME);
        GAUCHE.setAlignment(Pos.CENTER);
        
        XPANE = new BorderPane();
        XPANE.setLeft(GAUCHE);
        XPANE.setRight(DROITE);
        XPANE.setPadding(new Insets(0,0,0,0));
        
        PERSON = new Scene(XPANE, 400, 300);
        PERSON.getStylesheets().add("Decor.css");
    }
    
    public Scene getTreeSceneScreen(){
        return PERSON;
    }
}
