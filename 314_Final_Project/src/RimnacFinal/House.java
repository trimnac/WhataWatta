package RimnacFinal;
import java.util.ArrayList;

public class House{
    private long startDate;
    private long currentDate;
    private double totalkWHours;
    private double cost;
    private double totalWattage;
    private final double CHARGE_RATE;
    private ArrayList<Room> rooms;
    private String name;
    
    public House(String name, double rate){
        this.name = name;
        startDate = System.currentTimeMillis();
        totalkWHours = 0;
        rooms = new ArrayList<Room>();
        CHARGE_RATE = rate;
    }
    
    public void changeName(String newName){
        name = newName;
    }
    
    public double getTotalCosts(){
        cost = 0;
        for(int i = 0; i < rooms.size(); i++){
            cost += rooms.get(i).calculateTotalUsage(CHARGE_RATE);
        }
        return cost;
    }
    
    public double getTotalkWHours(){
        totalkWHours = cost / CHARGE_RATE;
        return totalkWHours;
    }
    
    public double getTotalWattage(){
        totalWattage = 0;
        for(int i = 0; i < rooms.size(); i++){
            totalWattage += rooms.get(i).calculateTotalUsage();
        }
        
        return totalWattage;
    }
    
    public void addRoom(Room newRoom){
        rooms.add(newRoom);
    }
    
    public Room getRoom(int index){
        return rooms.get(index);
    }
    
    public ArrayList getRooms(){
        return rooms;
    }
    
    public String getName(){
        return name;
    }
}