package Controllers;

import Scenes.RibbonShapes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonFiller {
    File REFERENCE;
    Integer POS;
    public String MINILINE;
    RadioButton[] RADIOARRAY;
    ToggleGroup NEWTOGGLE;
    RadioButton SELECTED;
    Integer INDEX;
    RibbonShapes RIBBON;
    
    
    MenuFiller DING;
    
    public RadioButton[] RadioButtonFiller(String FILEME) throws FileNotFoundException, IOException{
        Scanner READER;
        DING = new MenuFiller();
        REFERENCE = new File(FILEME);
        READER = new Scanner (REFERENCE);
        
        String[] TEXTARRAY = new String[DING.FileMeasure(FILEME)];
        RADIOARRAY = new RadioButton[DING.FileMeasure(FILEME)];
        POS = 0;
        
        while (READER.hasNextLine()) {
            MINILINE = READER.nextLine();
            TEXTARRAY[POS] = MINILINE;
            RADIOARRAY[POS] = new RadioButton(TEXTARRAY[POS]);
            RADIOARRAY[POS].setStyle("-fx-font-weight: bold;-fx-text-fill: #0000FF");
            RADIOARRAY[POS].getStyleClass().add("top-radio-button");
            POS = POS + 1;
        }
        RADIOARRAY[POS-1].getStyleClass().add("autre-radio-button");
        return RADIOARRAY;
    }
    
    public RadioButton[] getArrayButtons(){
        return RADIOARRAY;
    }
    
    public void GraphicNext(Stage MAINWINDOW,String THEPIC, String CLICKUP,ImageView IVIMG){
        System.out.println(INDEX+"You Clicked:"+SELECTED.getText());
        IVIMG.setImage(new Image(THEPIC));
        IVIMG.setOnMouseClicked((MouseEvent d)->{
            if (!SELECTED.getText().equals("NOTHING")) {
                System.out.println("Selection: "+CLICKUP);
                RIBBON = new RibbonShapes();
                MAINWINDOW.setScene(RIBBON.getScreen());
            }
        });
    }
    
    public void RadioMe(Stage MAINWINDOW,VBox RADIOBOX,ImageView IVIMG) throws IOException{
        DING = new MenuFiller();
        NEWTOGGLE = new ToggleGroup();
        NEWTOGGLE.getToggles().addAll(RadioButtonFiller("test/Buttons.txt"));
        for (int i = 0; i < DING.FileMeasure("test/Buttons.txt"); i++) {
            RADIOBOX.getChildren().add(getArrayButtons()[i]);
        }
        NEWTOGGLE.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle TOG1) {
                SELECTED = (RadioButton)TOG1.getToggleGroup().getSelectedToggle();
                INDEX = NEWTOGGLE.getToggles().indexOf(NEWTOGGLE.getSelectedToggle());
                switch(INDEX){
                    case 0:
                        GraphicNext(MAINWINDOW,"H"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 1:
                        GraphicNext(MAINWINDOW,"H"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 2:
                        GraphicNext(MAINWINDOW,"H"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 3:
                        GraphicNext(MAINWINDOW,"H"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 4:
                        GraphicNext(MAINWINDOW,"H"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 5:
                        GraphicNext(MAINWINDOW,"H0.jpg",SELECTED.getText(),IVIMG);
                    break;
                }
            }
        });
    }
    public void RadioMe2(Stage MAINWINDOW,VBox RADIOBOX,ImageView IVIMG) throws IOException{
        DING = new MenuFiller();
        NEWTOGGLE = new ToggleGroup();
        NEWTOGGLE.getToggles().addAll(RadioButtonFiller("test/Buttons2.txt"));
        for (int i = 0; i < DING.FileMeasure("test/Buttons2.txt"); i++) {
            RADIOBOX.getChildren().add(getArrayButtons()[i]);
        }
        NEWTOGGLE.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle TOG1) {
                SELECTED = (RadioButton)TOG1.getToggleGroup().getSelectedToggle();
                INDEX = NEWTOGGLE.getToggles().indexOf(NEWTOGGLE.getSelectedToggle());
                switch(INDEX){
                    case 0:
                        GraphicNext(MAINWINDOW,"A"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 1:
                        GraphicNext(MAINWINDOW,"A"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 2:
                        GraphicNext(MAINWINDOW,"A"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 3:
                        GraphicNext(MAINWINDOW,"A"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                    case 4:
                        GraphicNext(MAINWINDOW,"A"+INDEX+".jpg",SELECTED.getText(),IVIMG);
                    break;
                }
            }
        });
    }
}
