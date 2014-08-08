package RimnacFinal;
import java.util.ArrayList;

public class User{
    private String name;
    private ArrayList<House> homes;
    private long startDate;
    
    public User(String name){
        this.name = name;
        startDate = System.currentTimeMillis();
        homes = new ArrayList<House>();
    }
    
    public void addHouse(String houseName, double rate){
        homes.add(new House(houseName, rate));
    }
    
    public ArrayList getHouses(){
        return homes;
    }
    
    public House getHouse(int index){
        return homes.get(index);
    }
    
    public void updateStartDate(long actualDate){
        startDate = actualDate;
    }
    
    public long calculateDays(){
        long days = ((System.currentTimeMillis() - startDate)  / 1000 / 60 / 60 / 24) + 1;
        
        return days;
    }
}