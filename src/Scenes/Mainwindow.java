package Scenes;

import Controllers.RecordMe;
import Controllers.UserController;

import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Mainwindow {
    Text TITLE,TITLE2,TITLE3;
    Label ACCOUNTNAME, PASSWORD, EMAILNAME, STAFFID;
    TextField AN,EMAIL,EMAIL2,SID;
    PasswordField PS;
    Button LOGINUP, SIGNUPB, QUIT, STAFF;
    String NAMEUSER;
    HBox TOP,BOTTOM;
    VBox MID,TEST;
    BorderPane PANE;
    Scene ENTRANCE;

    Decorum PROP;    

    SearchFlight HOME;
    StaffPortal SPORTAL;
    UserController USERCONTROLLER;
    
    public Mainwindow(Stage MAINWINDOW) {
        USERCONTROLLER = new UserController();
        
        PROP = new Decorum();    
        
        TITLE2 = new Text();
        TITLE2.setText("Login to Account");
        
        TITLE3 = new Text();
        TITLE3.setText("Staff Login");
        
        ACCOUNTNAME = new Label("Account name:");
        ACCOUNTNAME.setFont(Font.font("verdana",FontWeight.BOLD, FontPosture.REGULAR, 20));
        ACCOUNTNAME.setMaxWidth(400);
        ACCOUNTNAME.setMaxHeight(400);
        ACCOUNTNAME.setTextFill(Color.WHITE);
        
        STAFFID = new Label("Staff ID:");
        STAFFID.setFont(Font.font("verdana",FontWeight.BOLD, FontPosture.REGULAR, 20));
        STAFFID.setMaxWidth(400);
        STAFFID.setMaxHeight(400);
        STAFFID.setTextFill(Color.WHITE);
        
        AN = new TextField();
        AN.setMaxWidth(400);
        AN.setPrefHeight(40);
        AN.setPromptText("Enter your Username");
        
        SID = new TextField();
        SID.setMaxWidth(400);
        SID.setPrefHeight(40);
        SID.setPromptText("Enter your Staff ID");
        
        EMAILNAME = new Label("Email:");
        EMAILNAME.setFont(Font.font("verdana",FontWeight.BOLD, FontPosture.REGULAR, 20));
        EMAILNAME.setMaxWidth(400);
        EMAILNAME.setMaxHeight(400);
        EMAILNAME.setTextFill(Color.WHITE);
        
        EMAIL = new TextField();
        EMAIL.setMaxWidth(400);
        EMAIL.setPrefHeight(40);
        EMAIL.setPromptText("Enter your email");
        
        EMAIL2 = new TextField();
        EMAIL2.setMaxWidth(400);
        EMAIL2.setPrefHeight(40);
        EMAIL2.setPromptText("Confirm your email");
        
        
        PASSWORD = new Label("Password:");
        PASSWORD.setFont(Font.font("verdana",FontWeight.BOLD, FontPosture.REGULAR, 20));
        PASSWORD.setMaxWidth(400);
        PASSWORD.setMaxHeight(400);
        PASSWORD.setTextFill(Color.WHITE);
        
        //password field
        PS = new PasswordField();
        PS.setMaxWidth(400);
        PS.setPrefHeight(40);
        PS.setPromptText("Enter your password");
    
        LOGINUP = new Button("Sign In");
        LOGINUP.setOnAction(e->{
            try{
                if (USERCONTROLLER.readUser(AN.getText(), PS.getText())) {
                    NAMEUSER = AN.getText();
                    HOME = new SearchFlight(MAINWINDOW,NAMEUSER);
                    MAINWINDOW.setScene(HOME.getScreen());
                }else if(USERCONTROLLER.readStaff(AN.getText(), PS.getText())){
                    System.out.println("im staff");
                    SPORTAL = new StaffPortal(MAINWINDOW);
                    MAINWINDOW.setScene(SPORTAL.getScreen());
                }
            } catch (IOException ex){
                System.out.println("PROBLEMS");
            }
        });
        
        SIGNUPB = new Button("Sign Up");
        SIGNUPB.setOnAction(e->{
            MAINWINDOW.setTitle("");
            MID.getChildren().addAll(EMAILNAME,EMAIL,EMAIL2);
            SIGNUPB.setOnAction(f->{
                try{
                    if (EMAIL.getText().equals(EMAIL2.getText()) && !EMAIL.getText().equals("")){
                        USERCONTROLLER = new UserController();
                        USERCONTROLLER.createUser(AN.getText(),PS.getText(),EMAIL.getText(),false);
                        HOME = new SearchFlight(MAINWINDOW,NAMEUSER);
                        MAINWINDOW.setScene(HOME.getScreen());
                    }
                }catch (IOException ex){
                    System.out.println("PROBLEMS");
            }
            });
        });
        
        QUIT = new Button("Exit");
        QUIT.setOnAction(e->{
           MAINWINDOW.close(); 
        });
        
        STAFF = new Button("Staff");
        STAFF.setId("STAFFBUTTON");
        STAFF.setOnAction(e->{
            MAINWINDOW.setTitle("Staff Login");
            MID.getChildren().clear();
            MID.getChildren().addAll(TITLE3,STAFFID,SID,PASSWORD,PS);
        });
        
        BOTTOM = new HBox(20);
        BOTTOM.getChildren().addAll(LOGINUP,SIGNUPB,QUIT);
        BOTTOM.setPadding(new Insets(0,0,0,0));
        BOTTOM.setAlignment(Pos.CENTER);
        
        TEST = new VBox(20);
        TEST.getChildren().addAll(BOTTOM,STAFF);
        TEST.setAlignment(Pos.CENTER);
        TEST.setPadding(new Insets(0,0,100,0));
        
        MID = new VBox(10);
        MID.getChildren().addAll(TITLE2,ACCOUNTNAME,AN,PASSWORD,PS);
        MID.setAlignment(Pos.CENTER);
        MID.setPadding(new Insets(0,0,0,0));
        
        PANE = new BorderPane();
        PANE.setCenter(MID);
        PANE.setBottom(TEST);
        PANE.setBackground(new Background(PROP.BCIMG));
        
        ENTRANCE = new Scene(PANE,800,1400,Color.RED);
        ENTRANCE.getStylesheets().add("Decor.css");
    }
    public Text getTITLE(){
        return TITLE;
    }
    public Scene getScreen(){
        return ENTRANCE;
    }
}
