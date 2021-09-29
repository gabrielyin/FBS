package Main;

import Scenes.SearchFlight;
import Scenes.Mainwindow;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IA extends Application{
    Stage MAINWINDOW;
    Mainwindow MAINONE;
    SearchFlight MAINTWO;
    
    @Override
    public void start(Stage primaryStage)throws Exception {
        MAINWINDOW = primaryStage;
        
        MAINONE = new Mainwindow(MAINWINDOW);
        
        MAINWINDOW.setHeight(600);
        MAINWINDOW.setWidth(800);
        MAINWINDOW.centerOnScreen();
        MAINWINDOW.setTitle("FBS"); 
        MAINWINDOW.getIcons().add(new Image("IALOGO.png"));        
        MAINWINDOW.setResizable(false);
       
// Display the main window called via class MainClickMe
        MAINWINDOW.setScene(MAINONE.getScreen());
        MAINWINDOW.show();
    }
    public static void main(String[] args) {
        launch(args);
    } 
}
