package RimnacFinal;
import java.util.Timer;
import java.util.TimerTask;

public class SolarPanel extends Appliance{
    private Timer time;
    private int sunLightTime;
    
    public SolarPanel(String name, double wattage, int sunLightTime){
        super(name, wattage);
        time = new Timer();
        this.sunLightTime = sunLightTime;
    }
    
    @Override
    public void turnOn(){
        super.turnOn();
        
        time.schedule(new TurnOff(), sunLightTime*60000);
        time.cancel();
    }
    
    class TurnOff extends TimerTask{
        @Override
        public void run(){
            turnOff();
        }
    }
}