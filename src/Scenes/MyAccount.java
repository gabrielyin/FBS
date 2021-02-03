package Scenes;

import java.io.IOException;
import javafx.geometry.Pos;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyAccount {
    Image IMG;
    BackgroundImage BCIMG;
    Scene ENTRANCE4;
    BorderPane PANE;
    MenuBar MENUBAR;
    Menu MENU1,MENU2,MENU3;
    VBox MAIN;
    Text T1,T2,T3,T4;
    
    public MyAccount(Stage MAINWINDOW) throws IOException {
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        
        MENUBAR = new MenuBar();
        MENU1 = new Menu("Search Flights");
        MENU2 = new Menu("Flight Status");
        MENU3 = new Menu("My Account");
        MENUBAR.getMenus().add(MENU1);
        MENUBAR.getMenus().add(MENU2);
        MENUBAR.getMenus().add(MENU3);

        T1 = new Text();
        T1.setText("Welcome Back: ");
        
        T2 = new Text();
        T2.setText("Name: ");
        
        T3 = new Text();
        T3.setText("Surname: ");
        
        MAIN = new VBox(2);
        MAIN.setAlignment(Pos.CENTER);
        MAIN.getChildren().addAll(T1,T2,T3);

        
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(MENUBAR);
        PANE.setCenter(MAIN);
        
        ENTRANCE4 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE4.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE4;
    }
}
