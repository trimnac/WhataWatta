package RimnacFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.*;

public class RoomPanel extends javax.swing.JPanel {
    final String DBURL = "jdbc:derby:RimnacFinalDB;";
    private ArrayList<Appliance> appliances;
    private int index;
    private double wattage;
    private String input;
    private Room room;
    private final double CHARGE_RATE;
    private int blankNameCount;
    private JPanel container;
    private double totalWatts;
    private String roomID;
    
    public RoomPanel(String roomID, Room rooms, double rate) {
        CHARGE_RATE = rate;
        this.roomID = roomID;
        this.room = rooms;
        appliances = new ArrayList<Appliance>();
        wattage = 0.0;
        input = "";
        blankNameCount = 1;
        index = 0;
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        initComponents();
        jScrollPane1.getViewport().add(container);
        totalWatts = 0;
        
        generateApps();
        
        try{
            Connection c = DriverManager.getConnection(DBURL);
            Statement st = c.createStatement();
            String LightsPull = "SELECT * FROM Lights";
            ResultSet lightsResult = st.executeQuery(LightsPull);
            while(lightsResult.next()){
                jComboBox2.addItem(lightsResult.getString("numOfBulbs") + " Bulb - " + 
                        lightsResult.getString("type"));
            }
            
            String TVsPull = "SELECT * FROM TVs";
            ResultSet TVsResult = st.executeQuery(TVsPull);
            while(TVsResult.next()){
                jComboBox1.addItem(TVsResult.getString("Brand") + " " + 
                        TVsResult.getString("type") + " - " + TVsResult.getString("size"));
            }
            
            String CompsPull = "SELECT * FROM Computers";
            ResultSet CompResult = st.executeQuery(CompsPull);
            while(CompResult.next()){
                jComboBox3.addItem(CompResult.getString("brand") + " " + CompResult.getString("type"));
            }
            
            c.close();
            st.close();
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();

        jButton1.setText("Add Lamp");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLamp(evt);
            }
        });

        jButton2.setText("Add TV");

        jButton3.setText("Add Computer");

        jButton4.setText("Add Other Appliance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOther(evt);
            }
        });

        jButton5.setText("Total Cost");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalCost(evt);
            }
        });

        jButton6.setText("Total Wattage");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalWattage(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddOther(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOther
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
        room.addAppliance(input, wattage);
        insertAppRecord(generateAppID(), input, wattage, room.getAppliance(index));
        
        container.add(new ApplianceRowPanel(room.getAppliance(index)));
        jScrollPane1.repaint();
        jScrollPane1.revalidate();
        ++index;
    }//GEN-LAST:event_AddOther

    private void TotalCost(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalCost
        JOptionPane.showMessageDialog(null, "So far, your " + room.getName() + ""
                + " has cost you $" + room.calculateTotalUsage(CHARGE_RATE) + ".");
    }//GEN-LAST:event_TotalCost

    private void TotalWattage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalWattage
        totalWatts = room.calculateTotalUsage();
        input = "";
        if(totalWatts >= 1000){
            totalWatts /= 1000;
            input = "k";
        }
        JOptionPane.showMessageDialog(null, room.getName() + " is currently using: "
                + totalWatts + " " + input + "Watts");
    }//GEN-LAST:event_TotalWattage

    private void AddLamp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLamp
        int lampType = jComboBox2.getSelectedIndex();
        String LampID = generateID("L-", lampType);
        String name = "";
        double wattage = 0;
        String type = "";
        
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            
            ResultSet r = st.executeQuery("SELECT type FROM Lights WHERE LightID = '" + LampID + "'");
            while(r.next()){
                type = r.getString("type").trim();
            }
            System.out.print(type);
            con.close();
            st.close();
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
        
        name = promptName();
        wattage = promptWattage();
        room.addAppliance(new Light(name, wattage, type));
        
        container.add(new ApplianceRowPanel(room.getAppliance(index)));
        jScrollPane1.repaint();
        jScrollPane1.revalidate();
        ++index;
        
    }//GEN-LAST:event_AddLamp

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
   
    private void generateApps(){
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            
            String query = "Select * FROM UserApps WHERE RoomID = '" + roomID + "'";
            ResultSet DBApps = st.executeQuery(query);
            String name = "";
            double wattage = 0;
            long startTime = 0;
            while(DBApps.next()){
                name = DBApps.getString("name");
                wattage = DBApps.getDouble("wattage");
                startTime = DBApps.getLong("startTime");
                
                room.addAppliance(name, wattage);
                
                container.add(new ApplianceRowPanel(room.getAppliance(index)));
                jScrollPane1.repaint();
                jScrollPane1.revalidate();
                index++;
            }
            
            con.close();
            st.close();
        }
        catch(SQLException ex){
            
        }
    }
    
    private String generateID(String prefix, int count){
        String id = prefix;
        
        if(count < 10){
            id += "00" + count;
        }
        else if(count < 100){
            id += "0" + count;
        }
        else{
            id += count;
        }
        
        return id;
    }
    
    private String generateAppID(){
        String id = "Ap-";
        int count = 0;
        
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM UserApps");
            rs.next();
            count = rs.getInt(1);
            
            con.close();
            st.close();
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
        if(count < 10){
            id += "00" + count;
        }
        else if(count < 100){
            id += "0" + count;
        }
        else{
            id += count;
        }
        
        return id;
    }
    
    public double promptWattage(){
        double wattage = Double.parseDouble(JOptionPane.showInputDialog("What's the"
                + " wattage of this appliance? (in Watts)"));

        while(wattage <= 0){
            wattage = Double.parseDouble(JOptionPane.showInputDialog("You can't"
                    + " have an appliance that "
                    + " uses negative power! What's the wattage of this appliance?"
                    + " (in Watts)"));
        }
        
        return wattage;
    }
    
    public String promptName(){
        String input = JOptionPane.showInputDialog("What's the name of this appliance?");
            
        if(input.equals("")){
            input = "misc. " + Integer.toString(blankNameCount);
            ++blankNameCount;
        }
        
        return input;
    }
    
    public void insertAppRecord(String id, String name, double wattage, Appliance app){
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            
            
            String insert = "INSERT INTO UserApps VALUES('" + id + "', '" + roomID + "', '"
                    + name + "', " + wattage + ", " + app.getStartTime() + ")";
            
            st.execute(insert);
            
            con.close();
            st.close();
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    public void insertTVRecord(){
        
    }
    
    public void insertCompRecord(){
        
    }
    
    public void insertLightRecord(){
        
    }
}
