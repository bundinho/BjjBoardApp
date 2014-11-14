/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.bundinho.bjjboard.model.timer;

import java.text.DecimalFormat;
import javafx.beans.property.SimpleLongProperty;

/**
 *
 * @author Bundinho
 */
public class TimerProperties {
    public static SimpleLongProperty DURATION = new SimpleLongProperty(300000);
    public static boolean TIMER_PAUSED = true;
    private static final DecimalFormat formatter = new DecimalFormat("00");
    
    public static String format(long duration) {
        String returnString;
        long secDurationLong = duration / 1000;
        float mnDurationFloat = secDurationLong / 60;
        int mnInt = (int) Math.floor(mnDurationFloat);
        int secInt = (int) (secDurationLong - mnInt*60);
        returnString = TimerProperties.formatter.format(mnInt) + ":" + TimerProperties.formatter.format(secInt);
   
        return returnString;
    }
}
