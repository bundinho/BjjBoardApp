/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.bundinho.bjjboard.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import mg.bundinho.bjjboard.utils.DisplayBoardProperties;

/**
 * FXML Controller class
 *
 * @author Bundinho
 */
public class DisplayBoardController implements Initializable {
    @FXML
    private Label timerLabel;
    @FXML
    private Label whiteScoreLabel;
    @FXML
    private Label whiteAdvLabel;
    @FXML
    private Label whitePenLabel;
    @FXML
    private Label blueScoreLabel;
    @FXML
    private Label blueAdvLabel;
    @FXML
    private Label bluePenLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DisplayBoardProperties.TIMER_LABEL.bindBidirectional(timerLabel.textProperty());
        DisplayBoardProperties.WHITE_SCORE_LABEL.bindBidirectional(whiteScoreLabel.textProperty());
        DisplayBoardProperties.WHITE_ADV_LABEL.bindBidirectional(whiteAdvLabel.textProperty());
        DisplayBoardProperties.WHITE_PEN_LABEL.bindBidirectional(whitePenLabel.textProperty());
        DisplayBoardProperties.BLUE_SCORE_LABEL.bindBidirectional(blueScoreLabel.textProperty());
        DisplayBoardProperties.BLUE_ADV_LABEL.bindBidirectional(blueAdvLabel.textProperty());
        DisplayBoardProperties.BLUE_PEN_LABEL.bindBidirectional(bluePenLabel.textProperty());
    }  
    
}
