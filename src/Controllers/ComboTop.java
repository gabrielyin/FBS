package Controllers;

import Modules.Item;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ComboTop extends ListCell<Item> {
    Label TYPELIST;
    AnchorPane CONTENT;
    GridPane GRIDPANE;
    
    public ComboTop(){
       TYPELIST = new Label();
       TYPELIST.setStyle("-fx-font-weight: bold; -fx-font-size: 0.9em;");

       CONTENT = new AnchorPane();
       GRIDPANE = new GridPane();        
       GRIDPANE.getChildren().setAll(TYPELIST);
       CONTENT.getChildren().add(GRIDPANE);  
   }

// in the box  
   protected void updateItem(Item ITEM, boolean EMPTY) {
       super.updateItem(ITEM, EMPTY);
       setGraphic(null);
       setText(null);
       setContentDisplay(ContentDisplay.LEFT);
       if (!EMPTY && ITEM != null) {
           TYPELIST.setText(ITEM.getItem());
           setText(null);
       }
   }    
}
