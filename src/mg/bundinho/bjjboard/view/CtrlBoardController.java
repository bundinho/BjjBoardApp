/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.bundinho.bjjboard.view;

import com.c05mic.timer.Timer;
import java.text.DecimalFormat;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import mg.bundinho.bjjboard.BjjBoardApp;
import mg.bundinho.bjjboard.model.Buddy;
import mg.bundinho.bjjboard.model.timer.CountdownTimer;
import mg.bundinho.bjjboard.model.timer.TimerProperties;

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
    @FXML 
    private Label timerLabel;
    //reference to the main application
    private BjjBoardApp bjjBoardApp;
    //The Bjj buddies
    private Buddy whiteBuddy ;
    private Buddy blueBuddy;
    private final DecimalFormat formatter = new DecimalFormat("00");
    private Timer cdTimer;
    
    /**
     * Constructor
     */
    public CtrlBoardController(){
        this.blueBuddy = new Buddy();
        this.whiteBuddy = new Buddy();
        this.cdTimer = new CountdownTimer();
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
        
        //timer
        TimerProperties.DURATION.addListener((observable, oldValue, newValue)-> showTimer(newValue));
        
         playTimer();
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
     * Handles Mouse click on blue buddy's advantage points panel
     * @param mouseEvent 
     */
    @FXML
    private void handleBlueAdvantageMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getButton() == MouseButton.PRIMARY){
            handleAddBlueAdvantagePoint();
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            handleRemoveBlueAdvantagePoint();
        }
    }
    
    /**
     * Handles mouse click on blue buddy's penalty point panel
     * @param mouseEvent 
     */
    @FXML
    private void handleBluePenaltyMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getButton() == MouseButton.PRIMARY){
            handleAddBluePenaltyPoint();
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            handleRemoveBluePenaltyPoint();
        }
    }
    
    @FXML
    private void handleBlueScoreMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getButton() == MouseButton.PRIMARY){
            handleAddBlueScorePoint();
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            handleRemoveBlueScorePoint();
        }
    }
    
    /**
     * Handles Mouse click on white buddy's advantage points panel
     * @param mouseEvent 
     */
    @FXML
    private void handleWhiteAdvantageMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getButton() == MouseButton.PRIMARY){
            handleAddWhiteAdvantagePoint();
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            handleRemoveWhiteAdvantagePoint();
        }
    }
    
    /**
     * Handles mouse click on white buddy's penalty point panel
     * @param mouseEvent 
     */
    @FXML
    private void handleWhitePenaltyMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getButton() == MouseButton.PRIMARY){
            handleAddWhitePenaltyPoint();
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            handleRemoveWhitePenaltyPoint();
        }
    }
    
    @FXML
    private void handleWhiteScoreMouseClicked(MouseEvent mouseEvent){
        if(mouseEvent.getButton() == MouseButton.PRIMARY){
            handleAddWhiteScorePoint();
        } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            handleRemoveWhiteScorePoint();
        }
    }
    
    /**
     * handles when an advantage point is added to white side;
     */
    private void handleAddWhiteAdvantagePoint(){
        whiteBuddy.addAdvantagePoint(1);
    }
    
    /**
     * processes when an advantage point is removed from the white side
     */
    private void handleRemoveWhiteAdvantagePoint(){
        if(whiteBuddy.getAdvantage() > 0) 
                whiteBuddy.removeAdvantagePoint(1);        
    }
    
    /**
     * processes when a record point is added to white side
     */
    private void handleAddWhiteScorePoint(){
        whiteBuddy.addScorePoint(1);
    }
    /**
     * Processes when a record point is removed from white side
     */
    private void handleRemoveWhiteScorePoint(){
        if(whiteBuddy.getScore() > 0)
            whiteBuddy.removeScorePoint(1);
    }
    
    /**
     * Processes when a penalty point is added to white side
     */
    private void handleAddWhitePenaltyPoint(){
        whiteBuddy.addPenaltyPoint(1);
    }
    
    /**
     * Processes when a penalty point is removed from white side
     */
    private void handleRemoveWhitePenaltyPoint(){
        if(whiteBuddy.getPenalty() > 0)
            whiteBuddy.removePenaltyPoint(1);
    }
    
     /**
     * handles when an advantage point is added to blue side;
     */
    private void handleAddBlueAdvantagePoint(){
        blueBuddy.addAdvantagePoint(1);
    }
    
    /**
     * processes when an advantage point is removed from the blue side
     */
    private void handleRemoveBlueAdvantagePoint(){
        if(blueBuddy.getAdvantage() > 0) 
                blueBuddy.removeAdvantagePoint(1);        
    }
    
    /**
     * processes when a record point is added to blue side
     */
    private void handleAddBlueScorePoint(){
        blueBuddy.addScorePoint(1);
    }
    /**
     * Processes when a record point is removed from blue side
     */
    private void handleRemoveBlueScorePoint(){
        if(blueBuddy.getScore() > 0)
            blueBuddy.removeScorePoint(1);
    }
    
    /**
     * Processes when a penalty point is added to blue side
     */
    private void handleAddBluePenaltyPoint(){
        blueBuddy.addPenaltyPoint(1);
    }
    
    /**
     * Processes when a penalty point is removed from blue side
     */
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
    
    public void showTimer(Number value){
        String output = TimerProperties.format(value.longValue());
        Platform.runLater(() -> {
            timerLabel.setText(output);
        });
        
    }
    
    public void playTimer() {
        System.out.println("starting");
        long duration = TimerProperties.DURATION.get();
        cdTimer.setDuration(duration);
//Start the timer.
cdTimer.start();
//Pause the timer.
cdTimer.pause();
//Resume the timer
cdTimer.resume();
    }
}
