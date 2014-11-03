/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.bundinho.bjjboard;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mg.bundinho.bjjboard.model.Buddy;
import mg.bundinho.bjjboard.view.CtrlBoardController;

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
