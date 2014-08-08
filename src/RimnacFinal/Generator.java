package RimnacFinal;

public class Generator extends Appliance{
    public Generator(String name, double wattage){
        super(name, (wattage * -1));
    }
    
    
}