package Controllers;

import java.io.FileNotFoundException;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ToggleHome extends HBox {
    TreeDisplay TREEMEDOWN;
    static Integer GENDER = 0;
    private final Label LABEL = new Label();
    private final Button BUTTON = new Button();
    private SimpleBooleanProperty SWITCHEDON = new SimpleBooleanProperty(false);
    public SimpleBooleanProperty switchOnProperty(){
        return SWITCHEDON;
    }
    
    private void init() {
        LABEL.setText("\u2642");
        LABEL.setMinWidth(25);
        LABEL.setMinHeight(25);
        LABEL.setFont(new Font("Arial",16));
        setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 0;" +
                "-fx-border-insets: 1;" +
                "-fx-border-radius: 0;" +
                "-fx-border-color: black;");        
        getChildren().addAll(LABEL, BUTTON);
        BUTTON.setStyle("-fx-background-radius: 3em; " +
               "-fx-min-width: 25px; " +
               "-fx-min-height: 25px; " +
               "-fx-max-width: 25px; " +
               "-fx-max-height: 25px;"                
        );
        BUTTON.setOnAction((e) -> {
            SWITCHEDON.set(!SWITCHEDON.get());
        });
        setOnMouseClicked((e) -> {
            SWITCHEDON.set(!SWITCHEDON.get());
        });
        setWidth(25);
        LABEL.setAlignment(Pos.CENTER);
        LABEL.setStyle("-fx-background-color: lightblue; -fx-text-fill:black; -fx-background-radius: 4;");
        LABEL.setAlignment(Pos.CENTER_LEFT);
        LABEL.setMaxWidth(30);
        BUTTON.setMaxWidth(30);        
    }
    
    public ToggleHome(TreeItem<String> TREEITEM) throws FileNotFoundException {
        init();
        GENDER = 0;
        SWITCHEDON = new SimpleBooleanProperty(false);
        SWITCHEDON.addListener((a,b,c) -> {
            if(c) {
                LABEL.setText("\u2640");
                LABEL.setStyle("-fx-background-color: lightpink; -fx-background-radius: 4");
                LABEL.toFront();
                GENDER = 2;
                try {
                    TREEMEDOWN = new TreeDisplay(GENDER,TREEITEM);
                } catch (FileNotFoundException ex) {
                    System.out.println("ERROR");
                }
            } else {
                LABEL.setText("\u2642");
                LABEL.setStyle("-fx-background-color: lightblue; -fx-background-radius: 4");
                BUTTON.toFront();
                GENDER = 1;
                try {
                    TREEMEDOWN = new TreeDisplay(GENDER,TREEITEM); 
                } catch (FileNotFoundException ex) {
                    System.out.println("Error");
                }
            }
                LABEL.setMinWidth(25);
                LABEL.setMinHeight(25);
                LABEL.setFont(new Font("Arial",16));
                LABEL.setAlignment(Pos.CENTER);
        });
    }
    
    public Integer BackMeUp(){
        return GENDER;
    }
}
