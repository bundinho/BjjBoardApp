/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.bundinho.bjjboard.model.timer;

import com.c05mic.timer.Timer;

/**
 *
 * @author Bundinho
 */
public class CountdownTimer extends Timer{
    
    public CountdownTimer() {
        super();
    }
    
    public CountdownTimer(long interval, long duration){
        super(interval, duration);
    }
    
    public CountdownTimer(long duration) {
        super();
        super.setDuration(duration);
        //mnCountdownState.set(duration);
    }
    
    @Override
    public void onTick() {
        long tickVal = TimerProperties.DURATION.get();
        tickVal -= 1000;
        TimerProperties.DURATION.set(tickVal);
        System.out.println("onTick called! : " + tickVal);
    }
    
    @Override
    public void onFinish(){
        System.out.println("Finished at :" );
    }
}
