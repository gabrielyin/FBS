package Controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Sesame {
    Text T1;
    VBox LAYOUT1, LAYOUT2;
    Scene ASDF;
    Image Background, IMG;
    BackgroundImage BCIMG;
    Button B1;
    boolean GRANTACCESS, TIC;
    
    UserController TESTUSER;
    
    public boolean sesame(Stage MAINWINDOW, TextField LOGIN, PasswordField PASSWORD) throws IOException{
        GRANTACCESS = false;
        try{
            TESTUSER = new UserController();
            if (TESTUSER.readUser(LOGIN.getText(), PASSWORD.getText())) {
                GRANTACCESS = true;
            }
            else{
                TIC = false;
                IsNoGood(TIC);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Problems");
        }    
        return GRANTACCESS;
    }
    
    public void IsNoGood(Boolean TIC){
                //popup MINIWINDOW when Username or Password is incorrect
                Stage MINIWINDOW = new Stage();
                MINIWINDOW.getIcons().add(new Image("IALOGO.png"));
                IMG = new Image("background.png");
                BCIMG = new BackgroundImage(IMG,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
                    
                MINIWINDOW.initModality(Modality.APPLICATION_MODAL);
                MINIWINDOW.setMinWidth(250);
                MINIWINDOW.setMinHeight(250);
                
                T1 = new Text();
                if (!TIC){
                    T1.setText("Incorrect username or password");
                }else{
                    T1.setText("Emails do not match");
                }
                
                //Button 1
                B1 = new Button("Close");
                B1.setOnAction(e->{
                    MINIWINDOW.close();
                });
                
                LAYOUT1 = new VBox(30);
                LAYOUT1.getChildren().addAll(T1, B1);
                LAYOUT1.setAlignment(Pos.CENTER);
                LAYOUT1.setBackground(new Background(BCIMG));
                
                ASDF = new Scene(LAYOUT1);
                ASDF.getStylesheets().add("Decor.css");
                MINIWINDOW.setScene(ASDF);
                MINIWINDOW.showAndWait();
    }
     
}
