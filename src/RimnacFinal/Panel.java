package RimnacFinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Panel extends JPanel{
    private ArrayList<JCheckBox> boxes;
    private ArrayList<Appliance> appliances;
    private int index;
    private double wattage;
    private String input;
    private Room room;
    private final double CHARGE_RATE;
    private int blankNameCount;
    
    public Panel(){
        boxes = new ArrayList<JCheckBox>();
        appliances = new ArrayList<Appliance>();
        wattage = 0.0;
        index = 0;
        input = "";
        CHARGE_RATE = 0.3;
        this.room = new Room("name");
        blankNameCount = 1;
        
        setLayout(new BorderLayout());
        setLayout(new GridLayout(4,1));
        
        setBorder(BorderFactory.createTitledBorder(room.getName()));
        
        JButton button = new JButton("Add appliance");
        button.addActionListener(new AddApplianceListener());
        add(button, BorderLayout.NORTH);
        
        JButton roomName = new JButton("Change room's name");
        roomName.addActionListener(new ChangeRoomNameListener());
        add(roomName, BorderLayout.CENTER);
        
        JButton currentUsage = new JButton("Total usage");
        currentUsage.addActionListener(new UsageListener());
        add(currentUsage, BorderLayout.SOUTH);
        
        JButton currentCost = new JButton("Total cost");
        currentCost.addActionListener(new CostListener());
        add(currentCost, BorderLayout.EAST);  
    }
    
    private class AddApplianceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            input = JOptionPane.showInputDialog("What's the name of this appliance?");
            
            if(input.equals("")){
                input = "misc. " + Integer.toString(blankNameCount);
                ++blankNameCount;
            }
            
            wattage = Double.parseDouble(JOptionPane.showInputDialog("What's the"
                    + " wattage of this appliance? (in Watts)"));
            
            while(wattage <= 0){
                wattage = Double.parseDouble(JOptionPane.showInputDialog("You can't"
                        + " have an appliance that "
                        + " uses negative power! What's the wattage of this appliance?"
                        + " (in Watts)"));
            }
            
            if(wattage > 1000){
                wattage = wattage / 1000;
                boxes.add(new JCheckBox(input + " - " + wattage + " kW"));
                wattage = wattage * 1000;
            }
            else{
                boxes.add(new JCheckBox(input + " - " + wattage + " W"));
            }
            
            room.addAppliance(input, wattage);
            
            boxes.get(index).addActionListener(new UpdateListener());
            
            add(boxes.get(index), BorderLayout.CENTER);
            
            revalidate();
            validate();
            ++index;
        }  
    }
    
    private class ChangeRoomNameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            input = JOptionPane.showInputDialog("What would you like the new name for "
                    + room.getName() + " to be?");
            if(!input.equals(""))
                room.changeName(input);
            setBorder(BorderFactory.createTitledBorder(room.getName()));
        }
    }
    
    private class UpdateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            for(int i = 0; i < boxes.size(); i++){
                if(boxes.get(i).isSelected()){
                    room.getAppliance(i).turnOn();
                }
                else if(room.getAppliance(i).isOn()){
                    room.getAppliance(i).turnOff();
                }
            }
        }
    }
    
    private class UsageListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            double totalWattage = 0.0;
            for(int i = 0; i < boxes.size(); i++){
                if(room.getAppliance(i).isOn()){
                    totalWattage += room.getAppliance(i).getWattage();
                }
            }
            
            JOptionPane.showMessageDialog(null, "The total power being used in the " +
                    room.getName() + " is " + totalWattage + " watts.");
        }
    }
    
    private class CostListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "So far, your " + room.getName() + 
                    " has cost you $" + room.calculateTotalUsage(CHARGE_RATE) + ".");
        }
    }
}