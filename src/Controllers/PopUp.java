/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Scenes.InTreeView;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author 2021g
 */
public class PopUp {
    String[] SPLIT;
    Stage FILE;
    
    InTreeView CONTENT;
    public PopUp(Stage MAINWINDOW, String MINILINE) throws IOException{
        SPLIT = MINILINE.split("\\s+");
        FILE = new Stage();
        FILE.setTitle(MINILINE);
        FILE.setHeight(350);
        FILE.setWidth(400);
        FILE.setX(MAINWINDOW.getX()+ 200);
        FILE.setY(MAINWINDOW.getY()+ 350);
        CONTENT = new InTreeView(FILE,SPLIT[1]);
        FILE.setScene(CONTENT.getTreeSceneScreen());
        FILE.getIcons().add(new Image("logo.png"));
        FILE.show();
    }
}
