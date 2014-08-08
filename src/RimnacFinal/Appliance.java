package RimnacFinal;

import javax.swing.JOptionPane;

public class Appliance{
    private String name;
    private double wattage;
    private long startTime;
    private long endTime;
    private long totalTime; //in minutes
    private boolean onoff; //if true then app is on, false is off
    private double totalWattage;
    
    public Appliance(String name, double wattage){
        this.name = name;
        this.wattage = wattage;
        totalTime = 0;
        onoff = false;
        startTime = 0;
        endTime = 0;
    }
    
    public void turnOn(){
        startTime = System.currentTimeMillis();
        onoff = true;
    }
    
    public void turnOff(){
        endTime = System.currentTimeMillis();
        totalTime += (endTime - startTime) / 1000.0 / 60 /60;
        onoff = false;
    }
    
    public boolean isOn(){
        return onoff;
    }
    
    public double getTotalTime(){
        if(onoff)
        {
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime) / 1000.0 / 60 / 60;
            startTime = endTime;
        }
        
        return totalTime;
    }
    
    public double getWattage(){
        return wattage;
    }
    
    public void changeWattage(double newWattage){
        wattage = newWattage;
    }
    
    public void changeName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public long getStartTime(){
        if(onoff){
            return startTime;
        }
        else{
            return 0;
        }
    }
}