package RimnacFinal;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalDemo extends JFrame{
    private final double CHARGE_RATE;
    private ArrayList<Room> rooms;
    private int index;
    private double totalWattage;
    private House home;
    private double input;
    private int blankNameCount;
    
    public FinalDemo(){
        
        input = Double.parseDouble(JOptionPane.showInputDialog("What's your "
                + "electricity charge rate? (in $/kWhour)"));
        
        while(input < 0 ){
            input = Double.parseDouble(JOptionPane.showInputDialog("You can't "
                    + "have a negative charge rate! "
                    + "What's your electricity charge rate? (in $/kWhour)"));
        }
        
        CHARGE_RATE = input;
        
        //home = new House(CHARGE_RATE);
        rooms =  home.getRooms();
        index = 0;
        blankNameCount = 1;
        
        setTitle("What Watt?");
        setSize(500,500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,5));
        
        //Initiate General Buttons
        JButton addRoom = new JButton("Add Room");
        JButton totalWatts = new JButton("Get total watts being used");
        JButton totalCost = new JButton("Show total costs");
        JButton totalDays = new JButton("How many days have I been tracking?");
        
        //Give action to general buttons
        addRoom.addActionListener(new AddRoomListener());
        totalWatts.addActionListener(new getTotalWattageListener());
        totalCost.addActionListener(new TotalCostsListener());
        totalDays.addActionListener(new TotalTimeListener());  
        
        //display general buttons
        add(addRoom);
        add(totalWatts);
        add(totalCost);
        add(totalDays); 
        
        pack(); 
        setVisible(true);
    }
    
    private class TotalTimeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            
        }
    }
    
    private class AddRoomListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String input = "";
            input = JOptionPane.showInputDialog("What's the name of this room?");
            if(input.equals("")){
                input = "Room " + Integer.toString(blankNameCount);
                ++blankNameCount;
            }
            rooms.add(new Room(input));
            //getContentPane().add(new Panel(rooms.get(index), CHARGE_RATE));
            revalidate();
            validate();
            index++;
        }
    }
        
    private class getTotalWattageListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            totalWattage = 0;
            for(int i = 0; i < rooms.size(); i++){
                totalWattage += rooms.get(i).calculateTotalUsage();
            }
            
            JOptionPane.showMessageDialog(null, "You are currently using " + 
                    totalWattage + " Watts.");
        }
    }
    
    private class TotalCostsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "The cost of all your rooms is $+"
                    + home.getTotalCosts() +".");
        }
    }
   
    public static void main(String[] args){
        
        final String DB_URL = "jdbc:derby:RimnacFinalDB;";
        
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            
            System.out.print("Connection Successful!");
            
            conn.close();
        }
        catch(SQLException ex){
            System.out.print("ERROR: " + ex.getMessage());
        }
        
        new FinalDemo();
        
    }
}