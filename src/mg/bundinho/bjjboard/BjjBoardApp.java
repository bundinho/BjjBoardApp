/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.bundinho.bjjboard;

import com.c05mic.timer.Timer;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mg.bundinho.bjjboard.model.Buddy;
import mg.bundinho.bjjboard.model.timer.CountdownTimer;
import mg.bundinho.bjjboard.view.CtrlBoardController;
import mg.bundinho.bjjboard.view.DisplayBoardController;

/**
 *
 * @author Bundinho
 */
public class BjjBoardApp extends Application {
    private Stage primaryStage;
    private Stage secondaryStage;
    private BorderPane rootLayout;
    private Buddy whiteBuddy;
    private Buddy blueBuddy;
    private Timer cdTimer;
    
    /**
     * Constructor:
     * Creates the two opponents
     */
    public BjjBoardApp(){
        whiteBuddy = new Buddy();
        blueBuddy = new Buddy();
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BJJ Board");
        
        initRootLayout();
        showDisplayBoard();
        showControlPanel();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * initializes the root layout
     */
    public void initRootLayout(){
        try {
            //load root layout from XML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BjjBoardApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            //create the stage
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest((WindowEvent event) -> {
                try {
                    CountdownTimer.futures.get("Counter-thread").cancel(true);
                    System.exit(0);
                } catch (NullPointerException ex) {
                    System.exit(0);
                }
                
            });  
        } catch (IOException ex) {
            ex.printStackTrace();
        }    
    }
    
    public void showControlPanel(){
        try {
            //load root layout from XML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BjjBoardApp.class.getResource("view/CtrlBoard.fxml"));
            AnchorPane controlPanel = (AnchorPane) loader.load();
            
            //set the control panel on the center of the root layout
            rootLayout.setCenter(controlPanel);
            
            //Give the controller access to the main app
            CtrlBoardController controller = loader.getController();
            controller.setBjjBoardApp(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void showDisplayBoard() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(BjjBoardApp.class.getResource("view/DisplayBoard.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            //Create the dialog stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Display Board");
//            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            //Set the person into the controller
            DisplayBoardController controller = loader.getController();
            //controller.setDialogStag(dialogStage);
            //controller.setPerson(person);
            
            //Show the dialog and wait until the user closes it
            dialogStage.show();
        } catch (IOException ex) {
        }
    }
    
    /**
     * gets the white side buddy
     * @return 
     */
    public Buddy getWhiteBuddy(){
        return whiteBuddy;
    }
    
    /**
     * Returns the blue side buddy
     * @return 
     */
    public Buddy getBlueBuddy(){
        return blueBuddy;
    }
    
}
