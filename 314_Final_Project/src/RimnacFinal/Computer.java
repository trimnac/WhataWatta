package RimnacFinal;

import javax.swing.JOptionPane;

public class Computer extends Appliance{
    private boolean heavyUse;
    private int input;
    
    public Computer(String name, double wattage){
        super(name, wattage);
        input = 0;
        heavyUse = false;
    }
    
    @Override
    public void turnOn(){
        super.turnOn();
        input = JOptionPane.showConfirmDialog(null, "Do you plan to be doing heavy usage?(ie gaming)");
        if(input == 1 || input == 2){
            super.changeWattage(super.getWattage() * 0.6);
        }
    }
    
    @Override
    public void turnOff(){
        super.turnOff();
        if(input == 1 || input == 2){
            super.changeWattage(super.getWattage() / 0.6);
        }
    }
}