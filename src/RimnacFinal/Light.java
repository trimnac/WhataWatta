package RimnacFinal;
import java.util.Random;
import javax.swing.JOptionPane;

public class Light extends Appliance{
    private int x;
    private Random rand;
    private String type;
    
    public Light(String name, double watts, String type){
        super(name, watts);
        this.type = type;
        rand = new Random();
    }
    
    @Override
    public void turnOn(){
        super.turnOn();
        x = rand.nextInt((10));
        
        if(x == 7 || x == 4){
            if(type.equals("Incandescant")){
                JOptionPane.showMessageDialog(null, "Halogen and CFL Bulbs are more energy efficient than Incandescant.");
            }
            else if(type.equals("Halogen")){
                JOptionPane.showMessageDialog(null, "CFL Bulbs are more energy efficient than Incandescant.");
            }
            else if(type.equals("CFL")){
                JOptionPane.showMessageDialog(null, "LED Bulbs are even more energy efficient than CFLs, and they last much longer too!");
            }
        }
    }
}