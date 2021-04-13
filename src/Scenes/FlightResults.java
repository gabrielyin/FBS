package Scenes;

import Controllers.FlightController;
import Modules.LineFlight;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FlightResults {
    ImageView FLAGA, FLAGB, FLAGC, FLAGD;
    ComboBox STOPOVER,EARLY;
    RadioButton NONSTOP;
    Button CONTINUE,FILTER;
    VBox MINBOX01,OTHERINFO,V1BOX,BOX1,MAINBOX,AIRPORTS,ECON,
            ECONPLUS,BUS,AIRPORTS2,ECON2,ECONPLUS2,BUS2,BIGONE;
    DateTimeFormatter DTF;  
    LocalDateTime NOW;    
    Label CURRENTDATE,INFO01,INFO02,INFO03,INFO04,INFO05,INFO06,INFO07,FLIGHT,
            INFO1,INFO22,INFO32,INFO42,INFO21,INFO31,INFO41;
    HBox[] CONTAINER;
    Button[] BCONTAINER;
    private int lastClickedIndex = -1;     
    HBox TITLEBOX,BOX01,BOX02,BOXUNIT,BOX3,BOX4,BOX5;
    ScrollPane SCROLL;
    BorderPane PANE;
    Scene ENTRANCE3;
    String EARLYSELECTED,NUM,AIRPLANE;
    Integer NUMBER1,FLAG;
    
    Decorum PROP;    
    FlightController LINES;
    LineFlight LINEFLIGHT;
    SeatMap SEATMAP;
    MyNewClass HOME;
    MyAccount MYACCOUNT;
    String INDEX;
            
    public FlightResults(Stage MAINWINDOW, String USER, String GOCITY, String BACKCITY) throws IOException{
        PROP = new Decorum();         
        FLAGA = new ImageView(new Image("RIO.jpg"));
        FLAGB = new ImageView(new Image("PAR.jpg"));
        FLAGC = new ImageView(new Image("LON.jpg"));
        FLAGD = new ImageView(new Image("LIS.jpg"));
        
        //comboboxes
        STOPOVER = new ComboBox();
        STOPOVER.setPromptText("Stop over");
        STOPOVER.getItems().addAll("0","1","2","more");
        EARLY = new ComboBox();
        EARLY.setPromptText("Day part"); 
        EARLY.getItems().addAll("Early","Late");
//        EARLY.setOnAction(e->{
//            EARLYSELECTED = (String) EARLY.getSelectionModel().getSelectedItem();
//            for (int i = CONTAINER.length; i < 10; i++) {
//                NUMBER1 = LINES.getStructure().get(i).getDepart();
//                if (>12) {
//                    
//                }
//            }
//        });
        
        //button management
        CONTINUE = new Button("Continue");
//        SEATMAP = new SeatMap(MAINWINDOW, USER);
//        CONTINUE.setOnAction(e->{
//            System.out.println("Continue");
//            MAINWINDOW.setScene(SEATMAP.getScreen());
//        });
        
        FILTER = new Button("Filter");
        FILTER.setOnAction(e->{
            EARLYSELECTED = (String) EARLY.getSelectionModel().getSelectedItem();
            BIGONE.getChildren().clear();
            if (EARLYSELECTED.equals("early")) {
                FlightBox(GOCITY,BACKCITY,MAINWINDOW,USER);
                for (int i=0;i<CONTAINER.length;i++) {
                    if (Integer.parseInt(LINES.getStructure().get(i).getDepart().substring(9,11))>12) {
                        BIGONE.getChildren().remove(CONTAINER[i]);
                    }
                }
            }else{
                FlightBox(GOCITY,BACKCITY,MAINWINDOW,USER);
                for (int i=0;i<CONTAINER.length;i++) {
                    if (Integer.parseInt(LINES.getStructure().get(i).getDepart().substring(9,11))<12) {
                        BIGONE.getChildren().remove(CONTAINER[i]);
                    }
                }
            }
        });
        
        //getting current date
        DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        NOW = LocalDateTime.now();
        CURRENTDATE = new Label((DTF.format(NOW)));
        
        //Top window
        BOX01 = new HBox(30);
        BOX01.setPadding(new Insets(10,0,0,0));
        BOX01.getChildren().addAll(STOPOVER,EARLY,FILTER);
        BOX01.setAlignment(Pos.TOP_CENTER);
        BOX02 = new HBox(220);
        BOX02.setPadding(new Insets(0,0,0,0));
        BOX02.setAlignment(Pos.TOP_CENTER);        
        BOX02.getChildren().addAll(CURRENTDATE,CONTINUE);          
        BOX1 = new VBox(20);
        BOX1.setPadding(new Insets(0,0,0,100));        
        BOX1.getChildren().addAll(BOX01,BOX02);        

        //Labels
        LINEFLIGHT = new LineFlight();
        LINES = new FlightController();
        
        //scrollpane
        SCROLL = new ScrollPane();
        SCROLL.setMaxWidth(900);
        SCROLL.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        //Fake dynamic array
        CONTAINER = new HBox[LINES.getStructure().size()];
        BCONTAINER = new Button[LINES.getStructure().size()];        

        BIGONE = new VBox();
        FLAG = 1;
        FlightBox(GOCITY,BACKCITY,MAINWINDOW,USER);
        //that will go into a scrool pane
        SCROLL.setContent(BIGONE);

        //main center box
        MAINBOX = new VBox(30);
        MAINBOX.setAlignment(Pos.TOP_CENTER);
        MAINBOX.getChildren().addAll(BOX1,SCROLL);
        MAINBOX.setPadding(new Insets(0,0,10,0));
        
        //pane management
        PANE = new BorderPane();
        PANE.setBackground(new Background(PROP.BCIMG));
        PANE.setTop(PROP.Bars(MAINWINDOW, USER));
        PANE.setCenter(MAINBOX);

        ENTRANCE3 = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE3.getStylesheets().add("Decor.css");
    }
    public Scene getScreen(){
        return ENTRANCE3;
    }
    
    public void FlightBox(String GOCITY,String BACKCITY,Stage MAINWINDOW,String USER){
        for (int i=0;i<LINES.getStructure().size();i++){
            if(LINES.getStructure().get(i).getFlightItself().substring(0,3).equals(GOCITY.substring(0,3).toUpperCase())&&LINES.getStructure().get(i).getFlightItself().substring(5,8).equals(BACKCITY.substring(0,3).toUpperCase())){
                INFO01 = new Label(LINES.getStructure().get(i).getFlightN1());
                INFO02 = new Label(LINES.getStructure().get(i).getFlightN2());
                MINBOX01 = new VBox();
                MINBOX01.getChildren().addAll(INFO01,INFO02);
                INFO1 = new Label(LINES.getStructure().get(i).getFlightItself(),FLAGA);
                INFO1.setFont(new Font(30));        
                TITLEBOX = new HBox(10);
                TITLEBOX.getChildren().addAll(INFO1,MINBOX01);
                INFO03 = new Label(LINES.getStructure().get(i).getDepart());
                INFO04 = new Label(LINES.getStructure().get(i).getArrival());
                INFO05 = new Label(LINES.getStructure().get(i).getStopOver());
                INFO06 = new Label(LINES.getStructure().get(i).getLink1());
                INFO07 = new Label(LINES.getStructure().get(i).getLink2());      
                INFO21 = new Label("Price economy");
                INFO21.setFont(new Font(20));            
                INFO22 = new Label("      $900");  
                INFO31 = new Label("Price economy plus");
                INFO31.setFont(new Font(20));
                INFO32 = new Label("     $1800");
                INFO41 = new Label("Price business");
                INFO41.setFont(new Font(20));
                INFO42 = new Label("     $3600");  

                //Boxes in data
                OTHERINFO = new VBox();
                OTHERINFO.getChildren().addAll(INFO03,INFO04,INFO05,INFO06,INFO07);
                V1BOX = new VBox();
                V1BOX.getChildren().addAll(TITLEBOX,OTHERINFO);
                V1BOX.setPadding(new Insets(1,0,0,10));
                ECON = new VBox();
                ECON.getChildren().addAll(INFO21,INFO22);
                ECONPLUS = new VBox();
                ECONPLUS.getChildren().addAll(INFO31,INFO32);
                BUS = new VBox();
                BUS.getChildren().addAll(INFO41,INFO42);        

                BOXUNIT = new HBox();
                BOXUNIT.setSpacing(10);
                BOXUNIT.getChildren().addAll(V1BOX,ECON,ECONPLUS,BUS);              
                // Lines of flight going from BOXUNIT to CONTAINER
                final int buttonInd = i;                
               
                CONTAINER[i] = new HBox(BOXUNIT);
                CONTAINER[i].setOnMouseClicked(e -> {
                    lastClickedIndex = buttonInd;
                    try {
                        SEATMAP = new SeatMap(MAINWINDOW,USER,lastClickedIndex );
                    } catch (IOException ex) {
                        System.out.println("Error");
                    }
                    MAINWINDOW.setScene(SEATMAP.getScreen());
                }); 
                
                // the box Line by line goes into a big final box 
                BIGONE.getChildren().add(CONTAINER[i]);                 
            }
        }
    }
}
