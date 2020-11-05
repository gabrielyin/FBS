package Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TreeDisplay {
    Scanner READER;
    int COUNTER =1;
    String MINILINE,NAME;
    String SPLIT[];
    
    public TreeDisplay (String TEXT,TreeItem<String> TREEITEM) throws FileNotFoundException{
        TREEITEM.getChildren().clear();
        READER = new Scanner(new File("test/search.txt"));
        try {
            Integer.parseInt(TEXT);
            while (READER.hasNextLine())
            {
                MINILINE = READER.nextLine();
                SPLIT = MINILINE.split(",");
                if (SPLIT[2].contains(TEXT)) {
                    NAME = COUNTER+": "+SPLIT[0];
                    TREEITEM.getChildren().add(createItem(NAME,TREEITEM));
                }
            }
        }
        catch (NumberFormatException e)
        {
            while (READER.hasNextLine()){
                MINILINE = READER.nextLine();
                SPLIT = MINILINE.split(",");
                if (SPLIT[0].contains(TEXT) || SPLIT[1].contains(TEXT)) {
                    NAME = SPLIT[1];
                    System.out.println(NAME);
                    TREEITEM.getChildren().add(createVItem(NAME,TREEITEM));
                }
            }
        }
    }
    public TreeDisplay (Integer INDEX,TreeItem<String> TREEITEM) throws FileNotFoundException{
        TREEITEM.getChildren().clear();
        READER = new Scanner(new File("test/search.txt"));
        while (READER.hasNextLine())
        {
            MINILINE = READER.nextLine();
            SPLIT = MINILINE.split(",");
            if (INDEX == 1) {
                if (SPLIT[3].contains("M")) {
                    NAME = SPLIT[0];
                    TREEITEM.getChildren().add(createItem(NAME,TREEITEM));
                }
            }else{
                if (SPLIT[3].contains("F")) {
                    NAME = SPLIT[0];
                    TREEITEM.getChildren().add(createItem(NAME,TREEITEM));
                }
            }
        }
    }
    
    public TreeItem<String> createItem(String LINE, TreeItem<String> TREEITEM)
    {
        TreeItem<String> LINELEAF = new TreeItem<> (LINE);
        LINELEAF.setExpanded(true);
        return LINELEAF;
    }
    public TreeItem<String> createVItem(String LINE, TreeItem<String> TREEITEM)
    {
        ImageView ROOTICON = new ImageView(new Image ("logo.png"));
        TreeItem<String> LINELEAF = new TreeItem<> (LINE,ROOTICON);
        LINELEAF.setExpanded(true);
        return LINELEAF;
    }    
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        