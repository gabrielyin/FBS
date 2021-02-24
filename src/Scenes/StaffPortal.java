package Scenes;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

public class StaffPortal {
    Scene ENTRANCE;
    Image IMG;
    BackgroundImage BCIMG;
    
    public StaffPortal(Stage MAINWINDOW){
        //background image    
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
    }
    public Scene getScreen(){
        return ENTRANCE;
    }
}
