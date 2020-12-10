package Scenes;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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
    HBox BOXOPTIONS;
    MenuBar MENUBAR;
    Menu MENU1;
    Image IMG;
            
    public FlightResults(Stage MAINWINDOW) throws IOException{
        //background logo
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        //menu bar
        MENUBAR = new MenuBar();
        MENU1 = new Menu("MENU1");
        MENUBAR.getMenus().add(MENU1);
        
        BOXOPTIONS = new HBox();
        BOXOPTIONS.getChildren().addAll();
        
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR);

        ENTRANCE3 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE3.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE3;
    }
}
