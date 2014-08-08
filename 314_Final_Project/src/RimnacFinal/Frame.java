package RimnacFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.*;

public class Frame extends JFrame {
    final String DBURL = "jdbc:derby:RimnacFinalDB;";
    private double CHARGE_RATE;
    private int roomCount = 0;
    private ArrayList<House> houses;
    private ArrayList<Room> rooms;
    private int blankNameCount;
    private double totalWattage;
    private int index;
    private String in;
    private String userID;
    private User user;
    
    public Frame(String userID, String username) {
        initComponents();
        setLocationRelativeTo(null);
        houses = new ArrayList<House>();
        rooms = new ArrayList<Room>();
        double input = 0;
        blankNameCount = 1;
        index = 0;
        jButton2.setVisible(false);
        in = "";
        this.userID = userID;
        jLabel7.setText(username);
        
        setTitle("What Watt?");
        CHARGE_RATE = input;
        user = new User(username);
        jLabel3.setText(user.calculateDays() + "");
        generateHouses();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setText("Total Cost");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalCost(evt);
            }
        });

        jButton3.setText("Total Current Wattage");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalCurrentWattage(evt);
            }
        });

        jButton4.setText("Add House");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddHouse(evt);
            }
        });

        jLabel1.setText("Days Tracking: ");

        jLabel3.setText("0");

        jButton2.setText("Change House Name");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeHouseName(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Hello, ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangeHouseName(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeHouseName
        in = "";
        in = JOptionPane.showInputDialog("Enter the new name: ");
        if(!in.equals("")){
            jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), in);
        }
    }//GEN-LAST:event_ChangeHouseName

    private void AddHouse(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddHouse
        String input = "";
        double rate = 0.0;
        input = JOptionPane.showInputDialog("What's the name of the house?");
        if(input.equals("")){
            input = "House " + Integer.toString(blankNameCount);
            ++blankNameCount;
        }
        try{
            rate = Double.parseDouble(JOptionPane.showInputDialog("What's your "
                + "electricity charge rate? (in $/kWhour)"));
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "You have to enter a number!");
        }
        houses.add(new House(input, rate));
        if(roomCount == 0){
            jTabbedPane1.remove(roomCount);
            jButton2.setVisible(true);
        }
        String houseID = generateHouseID();
        jTabbedPane1.add(new HousePanel(houseID, new House(input, rate), rate), input, roomCount);
        insertHouseRecord(houseID, userID, input, rate);

        roomCount++;
        pack();
    }//GEN-LAST:event_AddHouse

    private void TotalCurrentWattage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalCurrentWattage
        totalWattage = 0;
        for(int i = 0; i < rooms.size(); i++){
            totalWattage += rooms.get(i).calculateTotalUsage();
        }

        JOptionPane.showMessageDialog(null, "You are currently using "
            + totalWattage + " Watts.");
    }//GEN-LAST:event_TotalCurrentWattage

    private void TotalCost(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalCost
        JOptionPane.showMessageDialog(null, "The cost of all your rooms is $+"
            + houses.get(0).getTotalCosts() +".");
    }//GEN-LAST:event_TotalCost
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private String generateHouseID(){
        String id = "H-";
        int count = 0;
        
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM Houses");
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
    
    private void insertHouseRecord(String id, String uid, String name, double rate){
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            String createHouse = "INSERT INTO Houses VALUES('" + id + "', '" +
                    uid + "', '" + name + "', " + rate + ")";
            
            st.execute(createHouse);
            
            con.close();
            st.close();
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    private void generateHouses(){
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            String query = "SELECT * FROM Houses WHERE UserID = '" + userID + "'";
            ResultSet DBHouses = st.executeQuery(query);
            String name = "";
            double rate = 0;
            String houseID = "";
            
            while(DBHouses.next()){
                name = DBHouses.getString("Name");
                rate = DBHouses.getDouble("kRate");
                houseID = DBHouses.getString("HouseID");
                houses.add(new House(name, rate));
                if(roomCount == 0){
                    jTabbedPane1.remove(roomCount);
                    jButton2.setVisible(true);
                }
                jTabbedPane1.add(new HousePanel(houseID, new House(name, rate), rate), name, roomCount);
                roomCount++;
            }
            
            con.close();
            st.close();
            
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
}
