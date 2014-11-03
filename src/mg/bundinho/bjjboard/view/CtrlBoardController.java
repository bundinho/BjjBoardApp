/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.bundinho.bjjboard.view;

import java.text.DecimalFormat;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import mg.bundinho.bjjboard.BjjBoardApp;
import mg.bundinho.bjjboard.model.Buddy;

/**
 *
 * @author Bundinho
 */
public class CtrlBoardController {
    @FXML
    private Label blueScoreLabel;    
    @FXML
    private Label whiteScoreLabel;    
    @FXML 
    private Label whiteAdvantageLabel;
    @FXML
    private Label blueAdvantageLabel;
    @FXML 
    private Label whitePenaltyLabel;
    @FXML 
    private Label bluePenaltyLabel;
    //reference to the main application
    private BjjBoardApp bjjBoardApp;
    //The Bjj buddies
    private Buddy whiteBuddy ;
    private Buddy blueBuddy;
    private final DecimalFormat formatter = new DecimalFormat("00");
    
    /**
     * Constructor
     */
    public CtrlBoardController(){
        this.blueBuddy = new Buddy();
        this.whiteBuddy = new Buddy();
    }
    
    @FXML
    private void initialize(){
        
    }
    
    /**
     * Links the main app to the controller
     * @param bjjBoardApp 
     */
    public void setBjjBoardApp(BjjBoardApp bjjBoardApp){
        this.bjjBoardApp = bjjBoardApp;
        setWhiteBuddy(bjjBoardApp.getWhiteBuddy());
        setBlueBuddy(bjjBoardApp.getBlueBuddy());
        
        //Add listeners in order to synchronize data change with UI
        //white buddy
        SimpleIntegerProperty whiteAdvantageProperty = whiteBuddy.advantageProperty();
        whiteAdvantageProperty.addListener((observable, oldValue, newValue) -> showWhiteAdvantage());
        SimpleIntegerProperty whiteScoreProperty = whiteBuddy.scoreProperty();
        whiteScoreProperty.addListener((observable, oldValue, newValue) -> showWhiteScore());
        SimpleIntegerProperty whitePenaltyProperty = whiteBuddy.penaltyProperty();
        whitePenaltyProperty.addListener((observable, oldValue, newValue) -> showWhitePenalty());
        //blue buddy
        SimpleIntegerProperty blueAdvantageProperty = blueBuddy.advantageProperty();
        blueAdvantageProperty.addListener((observable, oldValue, newValue) -> showBlueAdvantage());
        SimpleIntegerProperty blueScoreProperty = blueBuddy.scoreProperty();
        blueScoreProperty.addListener((observable, oldValue, newValue) -> showBlueScore());
        SimpleIntegerProperty bluePenaltyProperty = blueBuddy.penaltyProperty();
        bluePenaltyProperty.addListener((observable, oldValue, newValue) -> showBluePenalty());
    }
    
    /**
     * sets the white side buddy
     * @param whiteBuddy 
     */
    public void setWhiteBuddy(Buddy whiteBuddy){
        this.whiteBuddy = whiteBuddy;
    }
    
    /**
     * sets the blue side buddy
     * @param blueBuddy 
     */
    public void setBlueBuddy(Buddy blueBuddy){
        this.blueBuddy = blueBuddy;
        
    }
    
    /**
     * handles when an advantage point is added to white side;
     */
    @FXML
    private void handleAddWhiteAdvantagePoint(){
        whiteBuddy.addAdvantagePoint(1);
    }
    
    /**
     * processes when an advantage point is removed from the white side
     */
    @FXML
    private void handleRemoveWhiteAdvantagePoint(){
        if(whiteBuddy.getAdvantage() > 0) 
                whiteBuddy.removeAdvantagePoint(1);        
    }
    
    /**
     * processes when a record point is added to white side
     */
    @FXML
    private void handleAddWhiteScorePoint(){
        whiteBuddy.addScorePoint(1);
    }
    /**
     * Processes when a record point is removed from white side
     */
    @FXML
    private void handleRemoveWhiteScorePoint(){
        if(whiteBuddy.getScore() > 0)
            whiteBuddy.removeScorePoint(1);
    }
    
    /**
     * Processes when a penalty point is added to white side
     */
    @FXML
    private void handleAddWhitePenaltyPoint(){
        whiteBuddy.addPenaltyPoint(1);
    }
    
    /**
     * Processes when a penalty point is removed from white side
     */
    @FXML
    private void handleRemoveWhitePenaltyPoint(){
        if(whiteBuddy.getPenalty() > 0)
            whiteBuddy.removePenaltyPoint(1);
    }
    
     /**
     * handles when an advantage point is added to blue side;
     */
    @FXML
    private void handleAddBlueAdvantagePoint(){
        blueBuddy.addAdvantagePoint(1);
    }
    
    /**
     * processes when an advantage point is removed from the blue side
     */
    @FXML
    private void handleRemoveBlueAdvantagePoint(){
        if(blueBuddy.getAdvantage() > 0) 
                blueBuddy.removeAdvantagePoint(1);        
    }
    
    /**
     * processes when a record point is added to blue side
     */
    @FXML
    private void handleAddBlueScorePoint(){
        blueBuddy.addScorePoint(1);
    }
    /**
     * Processes when a record point is removed from blue side
     */
    @FXML
    private void handleRemoveBlueScorePoint(){
        if(blueBuddy.getScore() > 0)
            blueBuddy.removeScorePoint(1);
    }
    
    /**
     * Processes when a penalty point is added to blue side
     */
    @FXML
    private void handleAddBluePenaltyPoint(){
        blueBuddy.addPenaltyPoint(1);
    }
    
    /**
     * Processes when a penalty point is removed from blue side
     */
    @FXML
    private void handleRemoveBluePenaltyPoint(){
        if(blueBuddy.getPenalty() > 0)
            blueBuddy.removePenaltyPoint(1);
    }
    
    /**
     * Resets all the points on the board
     */
    @FXML
    private void handleResetBoard(){
        blueBuddy.reset();
        whiteBuddy.reset();
    }
    
    /**
     * updates label of white side penalty points
     */
    public void showWhitePenalty(){
        whitePenaltyLabel.setText(formatter.format(whiteBuddy.getPenalty()));
    }
    
    /**
     * updates the label of white side record points
     */
    public void showWhiteScore(){
        whiteScoreLabel.setText(formatter.format(whiteBuddy.getScore()));
    }
    
    /**
     * updates the label of white side advantage points
     */
    public void showWhiteAdvantage(){
        String output = formatter.format(whiteBuddy.getAdvantage());
        whiteAdvantageLabel.setText(output);
    }
    
    /**
     * updates label of blue side penalty points
     */
    public void showBluePenalty(){
        bluePenaltyLabel.setText(formatter.format(blueBuddy.getPenalty()));
    }
    
    /**
     * updates the label of blue side record points
     */
    public void showBlueScore(){
        blueScoreLabel.setText(formatter.format(blueBuddy.getScore()));
    }
    
    /**
     * updates the label of blue side advantage points
     */
    public void showBlueAdvantage(){
        String output = formatter.format(blueBuddy.getAdvantage());
        blueAdvantageLabel.setText(output);
    }
}
