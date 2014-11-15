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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DisplayBoardProperties.TIMER_LABEL.addListener((observable, oldValue, newValue) -> timerLabel.setText(DisplayBoardProperties.TIMER_LABEL.get()) );
    }  
    
}
