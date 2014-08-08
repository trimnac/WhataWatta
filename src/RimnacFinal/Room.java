package RimnacFinal;
import java.util.ArrayList;

public class Room{
    private String name;
    private ArrayList<Appliance> appliances;
    private double totalUsage; //in kilowatthours
    private double totalWatts; //in watts
    private boolean inUse;
    
    public Room(String name){
        this.name = name;
        appliances = new ArrayList<Appliance>();
        inUse = false;
    }
    
    public void addAppliance(String name, double wattage){
        appliances.add(new Appliance(name, wattage));
    }
    
    public void addAppliance(Appliance app){
        appliances.add(app);
    }
    
    public String getName(){
        return name;
    }
    
    public void changeName(String newName){
        name = newName;
    }
    
    public Appliance getAppliance(int index){
        return appliances.get(index);
    }
    
    //When called with argument, returns total kWHours
    public double calculateTotalUsage(double rate){
        totalUsage = 0;
        
        for(int i = 0; i < appliances.size(); i++){
            totalUsage += appliances.get(i).getWattage() * appliances.get(i).getTotalTime();
        }
        
        totalUsage = totalUsage / 1000 * rate; //rate goes here
        return totalUsage;
    }
    
    //When called, returns total Watts
    public double calculateTotalUsage(){
        totalWatts = 0;
        
        for(int j = 0; j < appliances.size(); j++){
            if(appliances.get(j).isOn()){
                totalWatts += appliances.get(j).getWattage();
            }
        }
        
        return totalWatts;
    } 
    
    public int getNumOfApps(){
        return appliances.size();
    }
}