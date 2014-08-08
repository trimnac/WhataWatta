package RimnacFinal;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;

public class TVs extends Appliance{
    private String type;
    private Timer time;
    private int reminderTime;
    
    public TVs(String name, double watts, int reminderTime){
        super(name, watts);
        
        this.reminderTime = reminderTime;
        time = new Timer();
    }
    
    @Override
    public void turnOn(){
        super.turnOn();
        
        time.schedule(new Reminder(), reminderTime * 1000);
    };
    
    public void turnOff(){
        super.turnOff();
        
        time.cancel();
    }
    
    class Reminder extends TimerTask{
        @Override
        public void run(){
            JOptionPane.showMessageDialog(null, "You've have the tv on for 4 straight "
                    + "hours. Unless you're watching a Netflix marathon, you might want "
                    + "to turn it off to save some power.");
            time.cancel();
        }
    }

}