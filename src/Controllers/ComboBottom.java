package Controllers;

import Modules.Item;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ComboBottom extends ListCell<Item> {
   ImageView HEADICON = new ImageView();
   Label TYPELIST = new Label();
   GridPane GRIDPANE = new GridPane();
   AnchorPane CONTENT = new AnchorPane();

   public ComboBottom(){
       HEADICON.setFitWidth(20);
       HEADICON.setPreserveRatio(true);
       GridPane.setConstraints(HEADICON, 0, 0, 1, 3);
       GridPane.setValignment(HEADICON, VPos.TOP);        

       TYPELIST.setStyle("-fx-font-weight: bold; -fx-font-size: 1.2em;");
       GridPane.setConstraints(TYPELIST, 1, 0);
       
       // MiniPane for drop down menu        
       GRIDPANE.getChildren().setAll(HEADICON, TYPELIST);
       CONTENT.getChildren().add(GRIDPANE);
   }
 
   @Override
   protected void updateItem(Item ITEM, boolean EMPTY) {
       super.updateItem(ITEM, EMPTY);
       setGraphic(null);
       setText(null);
       setContentDisplay(ContentDisplay.LEFT);
       if (!EMPTY && ITEM != null) {
           TYPELIST.setText(ITEM.getItem());
           HEADICON.setImage(ITEM.getImg());
           setText(null);
           setGraphic(CONTENT);
           setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
       }        
   }    
}
