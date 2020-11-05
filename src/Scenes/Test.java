package Scenes;

import Controllers.MenuFiller;
import Controllers.RadioButtonFiller;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class Test {
    MenuFiller options;
    HBox boxoptions;
    ComboBox boxme2;
    ChoiceBox boxme;
    Scene ENTRANCE3;
    BorderPane PANE;
    Image IMG;
    BackgroundImage BCIMG;
    Mainwindow NAMEUSER;
    HBox rightbox;
    VBox imgbox,radiobox;
    RadioButtonFiller ding;
    ImageView ivimg;
    
    public Test(Stage MAINWINDOW) throws FileNotFoundException, IOException{
        MAINWINDOW.setTitle("Test");
        
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        System.out.println("hello: "+NAMEUSER);
        
        boxme = new ChoiceBox();
        boxme.setPrefWidth(500);
        boxme.setPrefHeight(40);
        
        boxme2 = new ComboBox();
        boxme2.setPrefWidth(500);
        boxme2.setPrefHeight(40);
        boxme2.setPromptText("Pick up the item");
        
        boxoptions = new HBox();
        options = new MenuFiller("test/exam.txt",MAINWINDOW);
        options.BoxFiller("test/exam.txt",boxme);
        boxoptions.getChildren().add(options.getMenuBar());
        options.BoxFiller3("test/materials.txt",boxme2);
        
        ivimg = new ImageView();
        ivimg.setImage(null);
        ivimg.setFitWidth(75);
        ivimg.setFitHeight(100);
        ivimg.setPreserveRatio(true);
        ivimg.setSmooth(true);
        ivimg.setCache(true);
        
        imgbox = new VBox(20);
        imgbox.getChildren().addAll(ivimg);
        radiobox = new VBox(10);
        
        rightbox = new HBox(10);
        rightbox.setPadding(new Insets(70,200,0,0));
        rightbox.getChildren().addAll(imgbox,radiobox);
        
        ding = new RadioButtonFiller();
        ding.RadioMe2(MAINWINDOW,radiobox,ivimg);
        
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(boxoptions);
        PANE.setLeft(boxme);
        PANE.setRight(boxme2);
        PANE.setBottom(rightbox);
        
        ENTRANCE3 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE3.getStylesheets().add("Decor.css");
    }
    
    public Scene getScreen(){
        return ENTRANCE3;
    }
}
