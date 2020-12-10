package Scenes;

import Controllers.MenuFiller;
import Controllers.MenuFillerPlus;
import Controllers.PopUp;
import Controllers.RadioButtonFiller;
import Controllers.ToggleHome;
import Controllers.TreeDisplay;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyNewClass {
    TreeItem<String> TREEITEM;
    TreeView<String> VTREE;
    Button FLIGHTS,FLIGHTSTAT,ACCOUNT,SEARCH,CHECK;
    Scene ENTRANCE2;
    BorderPane PANE,TOPPANE;
    Image IMG;
    ImageView IVIMG;
    BackgroundImage BCIMG;
    HBox MENUBAR,MID,MENUBAR2,RADIOBUTTONS,ADULTBOX,INFANTBOX,BOXOPTIONS,RIGHTBOX;
    VBox MAINRIGHT,MAINLEFT,IMGBOX,RADIOBOX,TREEBOX;
    Text TITLE,TITLE2,TITLE3;
    TextField DEPARTURE,DEPDATE,ARRIVAL,ARRDATE,AD,IN,ENTERME;
    RadioButton ROUNDTRIP,ONEWAY;
    ComboBox CLASS;
    Label ADULTS,INFANTS; 
    Test TEST;
    String MINILINE;
    
    MenuFiller OPTIONS;
    ChoiceBox BOXME;
    ComboBox BOXME2;
    Mainwindow NAMEUSER;
    MenuFillerPlus OPTION3;
    RadioButtonFiller DING;
    ToggleHome TOGGLEME;
    TreeDisplay TREEMEDOWN;
    PopUp POP;
    StackPane TREEDISPLAY;
    FlightResults FLIGHTRESULTS;
    
    
    public MyNewClass(Stage MAINWINDOW,String NAMEUSER) throws IOException{
        IMG = new Image("background.png");
        BCIMG = new BackgroundImage(IMG,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT);
        System.out.println("hello: "+NAMEUSER);
        
        TREEITEM = new TreeItem<>();
        TREEITEM.setValue("MYROOT");
        TREEITEM.setExpanded(true);
        
        VTREE = new TreeView<> (TREEITEM);
        VTREE.getStyleClass().add("myTree");
        VTREE.setShowRoot(false);
        VTREE.setOnMouseClicked(e -> {
            MINILINE = VTREE.getSelectionModel().getSelectedItem().getValue();
            try {
                POP = new PopUp(MAINWINDOW,MINILINE);
            } catch (IOException ex) {
                System.out.println("Error");            
            }
        });
        
        CHECK = new Button("Check");
        CHECK.setOnAction(e ->{
            try {
                TREEMEDOWN = new TreeDisplay(ENTERME.getText(),TREEITEM);
            } catch (FileNotFoundException ex) {
                System.out.println("Error");
            }
        });
        
        TREEDISPLAY = new StackPane();
        TREEDISPLAY.getChildren().add(VTREE);
        TREEBOX = new VBox(5);
        TREEBOX.setStyle("-fx-background-color: #FF0000;");
        TREEBOX.getChildren().addAll(TREEDISPLAY);
        TREEBOX.setPadding(new Insets(10,0,0,0));
        
//      radiobuttons image
        IVIMG = new ImageView();
        IVIMG.setImage(null);
        IVIMG.setFitWidth(75);
        IVIMG.setFitHeight(100);
        IVIMG.setPreserveRatio(true);
        IVIMG.setSmooth(true);
        IVIMG.setCache(true);
        
        TOGGLEME = new ToggleHome(TREEITEM);
        ENTERME = new TextField();
        ENTERME.setPrefWidth(190);
        ENTERME.setId("enterme");
        
//      radiobutton vbox
        IMGBOX = new VBox(20);
        IMGBOX.getChildren().addAll(ENTERME,TOGGLEME,IVIMG);
        RADIOBOX = new VBox(10);
        
        RIGHTBOX = new HBox(10);
        RIGHTBOX.setPadding(new Insets(70,200,0,0));
        RIGHTBOX.getChildren().addAll(IMGBOX,RADIOBOX,TREEBOX,CHECK);
        
        
//      combobox with textfile
        BOXME = new ChoiceBox();
        BOXME.setPrefWidth(500);
        BOXME.setPrefHeight(40);
        
//      combobox delete
        BOXME2 = new ComboBox();
        BOXME2.setPrefWidth(500);
        BOXME2.setPrefHeight(40);
        BOXME2.setPromptText("Pick up the item");
        
        BOXOPTIONS = new HBox();
//        different dynamic menus according to user
        switch(NAMEUSER){
            case "Oscar":
                OPTION3 = new MenuFillerPlus("test/menus.txt",MAINWINDOW);
                OPTION3.BoxFiller("test/menus.txt",BOXME);
                BOXOPTIONS.getChildren().add(OPTION3.getMenuBar());
                OPTION3.BoxFiller2("test/headshots.txt",BOXME2);
               break;
            case "Billy":
                OPTIONS = new MenuFiller("test/menus2.txt",MAINWINDOW);
                OPTIONS.BoxFiller("test/menus2.txt",BOXME);
                BOXOPTIONS.getChildren().add(OPTIONS.getMenuBar());
                OPTIONS.BoxFiller2("test/headshots.txt",BOXME2);
                break;
            default:
                OPTIONS = new MenuFiller("test/menus.txt",MAINWINDOW);
                OPTIONS.BoxFiller("test/menus.txt",BOXME);
                BOXOPTIONS.getChildren().add(OPTIONS.getMenuBar());
                OPTIONS.BoxFiller2("test/Headshots2.txt", BOXME2);
                break;
        }
        
        FLIGHTS = new Button("Search Flights");
        FLIGHTS.setId("MENUITEMS");
        
        FLIGHTSTAT = new Button("Flight Status");
        FLIGHTSTAT.setId("MENUITEMS");
        
        ACCOUNT = new Button("Account");
        ACCOUNT.setId("MENUITEMS");
        
        TITLE = new Text();
        TITLE.setText("Book a Flight");
      
        TITLE2 = new Text();
        TITLE2.setText("");
        
        TITLE3 = new Text();
        TITLE3.setText("");
        
        ADULTS = new Label();
        ADULTS.setText("Adults 12+");
        ADULTS.setPrefWidth(400);
        
        INFANTS = new Label();
        INFANTS.setText("Infants 0-11");
        INFANTS.setPrefWidth(400);
        
//      Input fields Left
        DEPARTURE = new TextField();
        DEPARTURE.setMaxWidth(500);
        DEPARTURE.setPrefHeight(40);
        DEPARTURE.setPromptText("Departure Airport");
        
        DEPDATE = new TextField();
        DEPDATE.setMaxWidth(500);
        DEPDATE.setPrefHeight(40);
        DEPDATE.setPromptText("Departure Date");
        
        ROUNDTRIP = new RadioButton();
        ROUNDTRIP.setText("Round Trip");
        
        ONEWAY = new RadioButton();
        ONEWAY.setText("One-Way");
        
        RADIOBUTTONS = new HBox(30);
        RADIOBUTTONS.getChildren().addAll(ROUNDTRIP,ONEWAY);
        RADIOBUTTONS.setAlignment(Pos.CENTER_LEFT);
        
        AD = new TextField();
        AD.setPrefWidth(90);
        AD.setPrefHeight(40);
        AD.setPromptText("0");
        AD.setAlignment(Pos.CENTER);
        
        ADULTBOX = new HBox(10);
        ADULTBOX.getChildren().addAll(ADULTS,AD);
        ADULTBOX.setAlignment(Pos.CENTER_LEFT);
        
        IN = new TextField();
        IN.setPrefWidth(90);
        IN.setPrefHeight(40);
        IN.setPromptText("0");
        IN.setAlignment(Pos.CENTER);

        
        INFANTBOX = new HBox(10);
        INFANTBOX.getChildren().addAll(INFANTS,IN);
        INFANTBOX.setAlignment(Pos.CENTER_LEFT);

        
        // Input fields right
        ARRIVAL = new TextField();
        ARRIVAL.setMaxWidth(500);
        ARRIVAL.setPrefHeight(40);
        ARRIVAL.setPromptText("Arrival Aiport");
        
        ARRDATE = new TextField();
        ARRDATE.setMaxWidth(500);
        ARRDATE.setPrefHeight(40);
        ARRDATE.setPromptText("Arrival Date");
        
        CLASS = new ComboBox();
        CLASS.getItems().addAll(
            "Class",
            "Business",
            "Economy Plus",
            "Economy"
        );
        CLASS.setPrefWidth(500);
        CLASS.setPrefHeight(40);
        CLASS.setPromptText("Class");
        
        SEARCH = new Button();
        SEARCH.setId("SEARCH");
        SEARCH.setText("Search");
        SEARCH.setPrefWidth(500);
        SEARCH.setPrefHeight(40);
        FLIGHTRESULTS = new FlightResults(MAINWINDOW);
        SEARCH.setOnAction(e->{
            MAINWINDOW.setScene(FLIGHTRESULTS.getScreen());
        });
       
        //hboxes and vboxes
        MENUBAR = new HBox(20);
        MENUBAR.getChildren().addAll(FLIGHTS,FLIGHTSTAT);
        MENUBAR.setPadding(new Insets(20,20,20,20));
        MENUBAR.setAlignment(Pos.CENTER_LEFT);
        
        MENUBAR2 = new HBox(20);
        MENUBAR2.getChildren().addAll(ACCOUNT);
        MENUBAR2.setPadding(new Insets(20,20,20,20));
        MENUBAR2.setAlignment(Pos.CENTER_RIGHT);
        
        TOPPANE = new BorderPane();
        TOPPANE.setBackground(new Background(new BackgroundFill(Color.BEIGE,CornerRadii.EMPTY,Insets.EMPTY)));
        TOPPANE.setLeft(MENUBAR);
        TOPPANE.setRight(MENUBAR2);
        
        MAINRIGHT = new VBox(15);
        MAINRIGHT.setPrefWidth(500);
//        MAINRIGHT.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));
        MAINRIGHT.getChildren().addAll(TITLE2,TITLE3,ARRIVAL,ARRDATE,BOXME,SEARCH);
        MAINRIGHT.setPadding(new Insets(0,0,0,0));
        MAINRIGHT.setAlignment(Pos.CENTER_LEFT);
        
        MAINLEFT = new VBox(15);
        MAINLEFT.setPrefWidth(500);
//        MAINLEFT.setBackground(new Background(new BackgroundFill(Color.GREEN,CornerRadii.EMPTY,Insets.EMPTY)));
        MAINLEFT.getChildren().addAll(TITLE,RADIOBUTTONS,DEPARTURE,DEPDATE,ADULTBOX,INFANTBOX,BOXME2);
        MAINLEFT.setPadding(new Insets(0,0,0,0));
        MAINLEFT.setAlignment(Pos.CENTER_LEFT);
        
        MID = new HBox(10);
        MID.getChildren().addAll(MAINLEFT,MAINRIGHT);
        MID.setPadding(new Insets(0,0,10,0));
        MID.setAlignment(Pos.CENTER);
        
        DING = new RadioButtonFiller();
        DING.RadioMe(MAINWINDOW,RADIOBOX,IVIMG);
        
        PANE = new BorderPane();
        PANE.setBackground(new Background(BCIMG));
        PANE.setTop(BOXOPTIONS);
        PANE.setCenter(MID);
        PANE.setRight(RIGHTBOX);
        
        ENTRANCE2 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE2.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE2;
    }
}
