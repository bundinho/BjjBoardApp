/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.bundinho.bjjboard.model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Bundinho
 */
public class Buddy {
    /**
     * BJJ buddy's total score
     */
    private SimpleIntegerProperty score;
    /**
     * BJJ buddy's amount of advantage points 
     */
    private SimpleIntegerProperty advantage;
    /**
     * BJJ buddy's amount of penalty
     */
    private SimpleIntegerProperty penalty;
    
    
    /**
     * Constructor
     */
    public Buddy(){
        score = new SimpleIntegerProperty(0);
        advantage = new SimpleIntegerProperty(0);
        penalty = new SimpleIntegerProperty(0);
    }
    
    //Getters and Setters
    
    public int getScore() {
        return score.get();
    }
    
    public void setScore(int score){
        this.score.set(score);
    }
    
    public SimpleIntegerProperty scoreProperty() {
        return score;
    }
    
    public int getAdvantage(){
        return advantage.get();
    }
    
    public void setAdvantage(int advantage){
        this.advantage.set(advantage);
    }
    
    public SimpleIntegerProperty advantageProperty(){
        return advantage;
    }
    
    public int getPenalty(){
        return penalty.get();
    }
    
    public void setPenalty(int penalty){
        this.penalty.set(penalty);
    }
    
    public SimpleIntegerProperty penaltyProperty () {
        return penalty;
    }
    
    /**
     * Resets all the scores awarded to BJJ Buddy
     */
    private void reset(){
        setScore(0);
        setAdvantage(0);
        setPenalty(0);
    }
    
    /**
     * Add points to score
     * @param point 
     */
    private void addScorePoint(int point) {
        int oldScore = getScore();
        setScore(point + oldScore);
    }
    
    /**
     * Remove points from score
     * @param point 
     */
    private void removeScorePoint(int point){
        int oldScore = getScore();
        setScore(oldScore - point);
    }
    
    /**
     * Add points to advantages
     * @param point 
     */
    private void addAdvantagePoint(int point) {
        int advantagePoint = getAdvantage();
        setAdvantage(advantagePoint + point);
    }
    
    /**
     * Remove advantage points
     * @param point 
     */
    private void removeAdvantagePoint(int point){
        int advantagePoint = getAdvantage();
        setAdvantage(advantagePoint - point);
    }
    
    /**
     * Add penalty point
     * @param point 
     */
    private void addPenaltyPoint(int point){
        int penaltyPoint = getPenalty();
        setPenalty(penaltyPoint + point);
    }
    
    /**
     * Removes penalty point
     * @param point 
     */
    private void removePenaltyPoint(int point){
        int penaltyPoint = getPenalty();
        setPenalty(penaltyPoint - point);
    }
    
}
