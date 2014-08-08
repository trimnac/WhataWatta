package RimnacFinal;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

public class HousePanel extends javax.swing.JPanel {
    final String DBURL = "jdbc:derby:RimnacFinalDB;";
    private ArrayList<Room> rooms;
    private House home;
    private int index, blankNameCount;
    private String input;
    private double rate;
    private String houseID;
    
    public HousePanel(String houseID, House home, double rate) {
        initComponents();
        this.houseID = houseID;
        jLabel2.setText(rate + "");
        this.home = home;
        this.rate = rate;
        rooms = new ArrayList<Room>();
        index = 0;
        input = "";
        blankNameCount = 1;
        jButton3.setVisible(false);
        generateRooms();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(842, 500));

        jButton1.setText("Add Room");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRoom(evt);
            }
        });

        jButton2.setText("Total Home Cost");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalHomeCost(evt);
            }
        });

        jButton3.setText("Change Room Name");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeRoomName(evt);
            }
        });

        jButton4.setText("Total House Wattage");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalHouseWattage(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 874, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel1);

        jLabel1.setText("Rate:");

        jLabel2.setText("0.13");

        jLabel3.setText("$/kwHr");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void AddRoom(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRoom
        input = JOptionPane.showInputDialog("What's the name of the room?");
        if(input.equals("")){
                input = "Room " + Integer.toString(blankNameCount);
                ++blankNameCount;
        }
        home.addRoom(new Room(input));
        if(index == 0){
            jTabbedPane1.remove(index);
            jButton3.setVisible(true);
        }
        String roomID = generateRoomID();
        jTabbedPane1.add(new RoomPanel(roomID, home.getRoom(index), rate), input, index);
        insertRoomRecord(roomID, houseID, input);
        
        index++;
    }//GEN-LAST:event_AddRoom

    private void TotalHouseWattage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalHouseWattage
        JOptionPane.showMessageDialog(null, home.getName() + " is currently using "
                + home.getTotalWattage() + " Watts.");
    }//GEN-LAST:event_TotalHouseWattage

    private void ChangeRoomName(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeRoomName
        input = "";
        input = JOptionPane.showInputDialog("Enter new room name: ");
        if(!input.equals("")){
            jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), input);
        }
    }//GEN-LAST:event_ChangeRoomName

    private void TotalHomeCost(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalHomeCost
        JOptionPane.showMessageDialog(null, "The total cost for " + home.getName() +
                " is: $" + home.getTotalCosts() + ".");
    }//GEN-LAST:event_TotalHomeCost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    private String generateRoomID(){
        String id = "R-";
        int count = 0;
        
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM Rooms");
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
    
    private void insertRoomRecord(String id, String hid, String name){
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            String createRoom = "INSERT INTO Rooms VALUES('" + id + "', '"
                    + hid + "', '" + name + "')";
            
            st.execute(createRoom);
            con.close();
            st.close();
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
    
    private void generateRooms(){
        try{
            Connection con = DriverManager.getConnection(DBURL);
            Statement st = con.createStatement();
            String query = "SELECT * FROM Rooms WHERE HouseID = '" + houseID + "'";
            ResultSet DBRooms = st.executeQuery(query);
            String name = "";
            String RoomID = "";
            
            while(DBRooms.next()){
                name = DBRooms.getString("Name");
                RoomID = DBRooms.getString("RoomID");
                home.addRoom(new Room(name));
                if(index == 0){
                    jTabbedPane1.remove(index);
                    jButton3.setVisible(true);
                }
                jTabbedPane1.add(new RoomPanel(RoomID, home.getRoom(index), rate), name, index);
                
                index++;
            }
            
            con.close();
            st.close();
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }
}
