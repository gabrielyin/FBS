package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuFillerPlus extends MenuFiller {
    Menu OPTION3;
    Image IMG4;
    
    public MenuFillerPlus(String FILEME, Stage MAINWINDOW) throws FileNotFoundException, IOException{
        super(FILEME,MAINWINDOW);
        IMG4 = new Image("IALOGO.png");
        for (int i = 0; i <POS; i++) {
            MENUARRAY[i].setGraphic(new ImageView(IMG4));
        }
        OPTION3 = new Menu("INHERIT");
        OPTION3.getItems().add(new MenuItem("AA"));
        OPTION3.getItems().add(new MenuItem("BB"));
        MYMENU.getMenus().add(OPTION3);
    }
}
