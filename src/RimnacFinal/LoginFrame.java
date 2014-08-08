package RimnacFinal;

import javax.swing.JOptionPane;
import java.sql.*;

public class LoginFrame extends javax.swing.JFrame {
    private String userName;
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogIn(evt);
            }
        });

        jLabel1.setText("Don't have an account?");

        jButton2.setText("Create One!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccount(evt);
            }
        });

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jTextField1)
                    .addComponent(jPasswordField1))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogIn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn
        String id = checkLogIn();
        
        if(!id.equals("")){
            this.setVisible(false);
            new Frame(id, userName).setVisible(true);
        }
        else{
            
        }
    }//GEN-LAST:event_LogIn

    private void CreateAccount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccount
        this.setVisible(false);
        new CreateAccount().setVisible(true);
    }//GEN-LAST:event_CreateAccount
    
    public void getInfo(){
        
    }
    
    public String checkLogIn(){
        userName = jTextField1.getText().trim();
        char[] pass = jPasswordField1.getPassword();
        String passString = new String(pass).trim();
        String userPass = "";
        String userID = "";
        
        try{
            Connection c = DriverManager.getConnection("jdbc:derby:RimnacFinalDB;");
            
            Statement st = c.createStatement();
            
            ResultSet r = st.executeQuery("SELECT password FROM Users WHERE UserName = '" 
                    + userName + "'");
            
            if(!r.next()){
                JOptionPane.showMessageDialog(null, "No username of " + userName + " exists."
                        + " Go ahead and create one!");
                return "";
            }
            else{
                do{
                    userPass = r.getString("password").trim();
                }while(r.next());
            }
            c.close();
            st.close();
        }
        catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
        
        if(passString.equals(userPass)){
            try{
                Connection c2 = DriverManager.getConnection("jdbc:derby:RimnacFinalDB;");
                Statement st2 = c2.createStatement();
                ResultSet r2 = st2.executeQuery("SELECT UserID FROM Users WHERE password = '"
                + userPass + "'");
                
                while(r2.next()){
                    userID = r2.getString("UserID");
                }
                
                c2.close();
                st2.close();
            }
            catch(SQLException ex){
                System.out.print(ex.getMessage());
            }
            return userID;
        }
        else{
            JOptionPane.showMessageDialog(null, "Sorry that's not the right password!");
            return "";
        }
        //System.out.print("username: " + userName + "\npassword: " + passString);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
