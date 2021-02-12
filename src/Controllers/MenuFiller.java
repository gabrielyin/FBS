package Controllers;

    import Modules.Item;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.io.LineNumberReader;
    import java.util.Scanner;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.scene.control.ChoiceBox;
    import javafx.scene.control.ComboBox;
    import javafx.scene.control.Menu;
    import javafx.scene.control.MenuBar;
    import javafx.scene.control.MenuItem;
    import javafx.scene.image.Image;
    import javafx.stage.Stage;

public class MenuFiller {
    Scanner READER;
    Integer POS, IN, NBRITEMS;
    String MINILINE, MEPIC;
    Image[] IMG;
    Item[] ITEM;
    MenuItem[] MENUARRAY;
    Menu[] OPTIONARRAY;
    Character LETTER;
    MenuBar MYMENU;
    
    public MenuFiller(){
        
    }
    
    public MenuFiller(String FILEME,Stage MAINWINDOW) throws FileNotFoundException, IOException{
        READER = new Scanner(new File(FILEME));
        MENUARRAY = new MenuItem[FileMeasure(FILEME)];
        OPTIONARRAY = new Menu[FileMeasure(FILEME)];
        POS = 0;
        NBRITEMS = 0;
//      getting menu items

        while (READER.hasNextLine()){
            MINILINE = READER.nextLine();
//      Turn last letter of string into characters      
            LETTER = (MINILINE.substring(MINILINE.length()-1)).charAt(0);
            if (LETTER.isDigit(LETTER)) {
                MINILINE = MINILINE.substring(1,MINILINE.length()-1);
                OPTIONARRAY[NBRITEMS] = new Menu(MINILINE);
                feedMenuItems(READER,OPTIONARRAY[NBRITEMS]);
                NBRITEMS = NBRITEMS + 1;
            }     
        }
        MYMENU = new MenuBar();
        for (int i = 0; i < NBRITEMS; i++) {
            MYMENU.getMenus().add(OPTIONARRAY[i]);
        }
    }
    
    public void BoxFiller(String FILEME, ChoiceBox POWER,Boolean YES,String ITEM) throws IOException{
        POWER.getItems().clear();
            try{
                READER = new Scanner (new File(FILEME));
                while(READER.hasNextLine()){
                    MINILINE = READER.nextLine();
                    if (YES){
                        POWER.getItems().add(MINILINE);                    
                    }
                    else{
                        if (!MINILINE.equals(ITEM)) {
                            POWER.getItems().add(MINILINE);
                        }
                    }        
                }
            }
            catch (IOException ex){
                System.out.println("ERROR");
            }
        }

    public void feedMenuItems(Scanner READER, Menu OPTIONARRAY){
        int NBR = Character.getNumericValue(LETTER);
        for (int i = 0; i < NBR; i++) {
            MINILINE = READER.nextLine();
            MENUARRAY[POS] = new MenuItem(MINILINE);
            OPTIONARRAY.getItems().add(MENUARRAY[POS]);
            POS = POS + 1; 
        }
        MENUARRAY[0].setOnAction((ActionEvent e) -> {
            System.out.println("Option 1 selected");
        });
        MENUARRAY[1].setOnAction((ActionEvent e) -> {
            System.out.println("Option 2 selected");
        });
        MENUARRAY[2].setOnAction((ActionEvent e) -> {
            System.out.println("Option 3 selected");
        });
    }
    
    public void BoxFiller2(String FILEME, ComboBox BOXME2) throws IOException {
        ObservableList<Item> LISTM = Dico(FILEME);
        BOXME2.setItems(LISTM);
        BOXME2.setButtonCell(new ComboTop());
        BOXME2.setCellFactory(listView -> new ComboBottom());
    }
    
    public ObservableList<Item> Dico(String FILEME) throws IOException {
        Scanner READER;
        
        IN = 0;
        ITEM = new Item[FileMeasure(FILEME)];
        IMG = new Image[FileMeasure(FILEME)];
        for (int i = 0; i < FileMeasure(FILEME); i++) {
            MEPIC = "H"+Integer.toString(i)+".jpg";
            IMG[i] = new Image(MEPIC);
        }
        
        try {
            READER = new Scanner (new File(FILEME));
            while (READER.hasNextLine()) {
                MINILINE = READER.nextLine();
                ITEM[IN] = new Item(MINILINE,IMG[IN]);
                IN = IN + 1;
            }
        }
        catch (IOException ex) {
            System.out.println("error");
        }
        ObservableList<Item> LISTM = FXCollections.observableArrayList(ITEM);
        return LISTM;
    }
    
    public void BoxFiller3(String FILEME, ComboBox BOXME2) throws IOException {
        ObservableList<Item> LISTM = Dico2(FILEME);
        BOXME2.setItems(LISTM);
        BOXME2.setButtonCell(new ComboTop());
        BOXME2.setCellFactory(listView -> new ComboBottom());
    }
    
    public ObservableList<Item> Dico2(String FILEME) throws IOException {
        Scanner READER;
        
        IN = 0;
        ITEM = new Item[FileMeasure(FILEME)];
        IMG = new Image[FileMeasure(FILEME)];
        for (int i = 0; i < FileMeasure(FILEME); i++) {
            MEPIC = "M"+Integer.toString(i)+".jpg";
            IMG[i] = new Image(MEPIC);
        }
        
        try {
            READER = new Scanner (new File(FILEME));
            while (READER.hasNextLine()) {
                MINILINE = READER.nextLine();
                ITEM[IN] = new Item(MINILINE,IMG[IN]);
                IN = IN + 1;
            }
        }
        catch (IOException ex) {
            System.out.println("error");
        }
        ObservableList<Item> LISTM = FXCollections.observableArrayList(ITEM);
        return LISTM;
    }
    
    public Integer FileMeasure(String FILEME) throws FileNotFoundException, IOException{
        LineNumberReader LNR;
        FileReader FIREADER;
        
        POS = 0;
        FIREADER = new FileReader(FILEME);
        LNR = new LineNumberReader(FIREADER);
        while (LNR.readLine() != null){
            POS++;
        }
        LNR.close();
        return POS;
    }
    
    public MenuBar getMenuBar(){
        return MYMENU;
    }
}