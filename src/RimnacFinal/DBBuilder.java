package RimnacFinal;
import java.sql.*;

public class DBBuilder{
    static public void main(String[] Args){
        
        final String DB_URL = "jdbc:derby:RimnacFinalDB;create=true";
        
        System.out.print("Starting... ");
        
        try
      {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         
         //Drops the tables if they exist
         dropTables(conn);
         
         createTables(conn);
         
         // Close the connection.
         conn.close();
      }
      catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
    }
    
    public static void dropTables(Connection conn){
        System.out.println("Checking for existing tables.");
        String[] tables = {"UserLights", "UserTVs", "UserComps", "Lights", "TVs",
            "Computers", "UserApps", "SolarPanels", "Rooms", "Houses", "GainedAchs", "Achvmts", "Users"};
                
        try{
            Statement stmt = conn.createStatement();
            
            for(int i = 0; i < tables.length; i++){
                try{
                stmt.execute("DROP TABLE " + tables[i]);
                System.out.println(tables[i] + " dropped.");
                }
                catch(SQLException ex){
                    System.out.println(tables[i] + " could not be dropped.");
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println("All tables successfully dropped");
        }
        catch(SQLException ex){
            System.out.print("There was an error when dropping the tables.");
        }
    }
    
    public static void createTables(Connection conn){
        System.out.println("Building tables");
        
        try{
            Statement stmt = conn.createStatement();
            
            createUsers(stmt);
            createAchvmts(stmt);
            createGainedAchs(stmt);
            createHouses(stmt);
            createRooms(stmt);
            createSolarPanels(stmt);
            createUserApps(stmt);
            createComps(stmt);
            createTVs(stmt);
            createLights(stmt);
            createUserComps(stmt);
            createUserTVs(stmt);
            createUserLights(stmt);
            
            System.out.print("All tables successfully built.");
        }
        catch(SQLException ex){
        }
    }
    
    public static void createUsers(Statement stmt){
        try{
            stmt.execute("CREATE TABLE Users("
                        + "UserID CHAR(5) NOT NULL PRIMARY KEY,"
                        + "UserName CHAR(20), password CHAR(20), email CHAR(30),"
                        + "phone CHAR(12), startDate BIGINT"
                        + ")");
            
            stmt.execute("INSERT INTO Users VALUES('U-000', 'admin', 'rimnacfinal',"
                    + "'timothy.rimnac@gmail.com', '888-888-8888', 0000000)");
        }
        catch(SQLException ex){
            System.out.println("Error creating table Users!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createHouses(Statement stmt){
        try{
            stmt.execute("CREATE TABLE Houses("
                    + "HouseID CHAR(5) NOT NULL PRIMARY KEY,"
                    + "UserID CHAR(5) REFERENCES Users(UserID),"
                    + "Name CHAR(15), kRate DOUBLE"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table Houses!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createGainedAchs(Statement stmt){
        try{
            stmt.execute("CREATE TABLE GainedAchs("
                    + "UserID CHAR(5) REFERENCES Users(UserID),"
                    + "AchvID CHAR(5) REFERENCES Achvmts(AchvID)"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table GainedACHS!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createAchvmts(Statement stmt){
        try{
            stmt.execute("CREATE TABLE Achvmts("
                    + "AchvID CHAR(5) NOT NULL PRIMARY KEY,"
                    + "AchName CHAR(17), Points INT"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table Achvmts!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createRooms(Statement stmt){
        try{
            stmt.execute("CREATE TABLE Rooms("
                    + "RoomID CHAR(5) NOT NULL PRIMARY KEY,"
                    + "HouseID CHAR(5) REFERENCES Houses(HouseID),"
                    + "Name CHAR(15)"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table Rooms!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createUserApps(Statement stmt){
        try{
            stmt.execute("CREATE TABLE UserApps( UserAppID CHAR(7) NOT NULL PRIMARY KEY,"
                    + "RoomID CHAR(5) REFERENCES Rooms(RoomID), name CHAR(15), wattage DOUBLE,"
                    + "startTime BIGINT"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table UserApps!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createUserLights(Statement stmt){
        try{
            stmt.execute("CREATE TABLE UserLights("
                    + "UserLightsID CHAR(5) NOT NULL PRIMARY KEY,"
                    + "UserAppID CHAR(7) REFERENCES UserApps(UserAppID),"
                    + "LightID CHAR(5) REFERENCES Lights(LightID)"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table UserLights!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createLights(Statement stmt){
        try{
            stmt.execute("CREATE TABLE Lights(LightID CHAR(5) NOT NULL PRIMARY KEY, "
                    + "type CHAR(12), numOfBulbs CHAR(2)"
                    + ")");
            
            stmt.execute("INSERT INTO Lights VALUES('L-000', 'Incandescant', '1')");
            stmt.execute("INSERT INTO Lights VALUES('L-001', 'Incandescant', '2')");
            stmt.execute("INSERT INTO Lights VALUES('L-002', 'Incandescant', '3')");
            stmt.execute("INSERT INTO Lights VALUES('L-003', 'Incandescant', '4')");
            stmt.execute("INSERT INTO Lights VALUES('L-005', 'Incandescant', '5')");
            stmt.execute("INSERT INTO Lights VALUES('L-006', 'CFL', '1')");
            stmt.execute("INSERT INTO Lights VALUES('L-007', 'CFL', '2')");
            stmt.execute("INSERT INTO Lights VALUES('L-008', 'CFL', '3')");
            stmt.execute("INSERT INTO Lights VALUES('L-009', 'CFL', '4')");
            stmt.execute("INSERT INTO Lights VALUES('L-010', 'CFL', '5')");
            stmt.execute("INSERT INTO Lights VALUES('L-011', 'LED', '1')");
            stmt.execute("INSERT INTO Lights VALUES('L-012', 'LED', '2')");
            stmt.execute("INSERT INTO Lights VALUES('L-013', 'LED', '3')");
            stmt.execute("INSERT INTO Lights VALUES('L-014', 'LED', '4')");
            stmt.execute("INSERT INTO Lights VALUES('L-015', 'LED', '5')");
            stmt.execute("INSERT INTO Lights VALUES('L-016', 'Halogen', '1')");
            stmt.execute("INSERT INTO Lights VALUES('L-017', 'Halogen', '2')");
            stmt.execute("INSERT INTO Lights VALUES('L-018', 'Halogen', '3')");
            stmt.execute("INSERT INTO Lights VALUES('L-019', 'Halogen', '4')");
            stmt.execute("INSERT INTO Lights VALUES('L-020', 'Halogen', '5')");
            
            
        }
        catch(SQLException ex){
            System.out.println("Error creating table Lights!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createUserTVs(Statement stmt){
        try{
            stmt.execute("CREATE TABLE UserTVs(UserTVID CHAR(5) NOT NULL PRIMARY KEY,"
                    + "UserAppID CHAR(7) REFERENCES UserApps(UserAppID),"
                    + "TVID CHAR(5) REFERENCES TVs(TVID)"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table UserTVs!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createTVs(Statement stmt){
        try{
            stmt.execute("CREATE TABLE TVs(TVID CHAR(5) PRIMARY KEY,"
                    + "Brand CHAR(12), type CHAR(10), size CHAR(10), wattage INT"
                    + ")");
            
            stmt.execute("INSERT INTO TVs VALUES('T-000', 'Sony', 'LCD', '32 in', 30)");
            stmt.execute("INSERT INTO TVs VALUES('T-001', 'Sony', 'LCD', '37 in', 35)");
            stmt.execute("INSERT INTO TVs VALUES('T-002', 'Sony', 'LCD', '42 in', 40)");
            stmt.execute("INSERT INTO TVs VALUES('T-003', 'Sony', 'LCD', '47 in', 50)");
            stmt.execute("INSERT INTO TVs VALUES('T-004', 'Sony', 'LCD', '55 in', 70)");
            stmt.execute("INSERT INTO TVs VALUES('T-005', 'Sony', 'LCD', '60 in', 90)");
            stmt.execute("INSERT INTO TVs VALUES('T-006', 'Sony', 'LED', '42 in', 32)");
            stmt.execute("INSERT INTO TVs VALUES('T-007', 'Sony', 'LED', '55 in', 50)");
            stmt.execute("INSERT INTO TVs VALUES('T-008', 'LG', 'LCD', '37 in', 40)");
            stmt.execute("INSERT INTO TVs VALUES('T-009', 'LG', 'LCD', '47 in', 64)");
            stmt.execute("INSERT INTO TVs VALUES('T-010', 'LG', 'LCD', '55 in', 80)");
            stmt.execute("INSERT INTO TVs VALUES('T-011', 'LG', 'LCD', '60 in', 100)");
            stmt.execute("INSERT INTO TVs VALUES('T-012', 'LG', 'LCD', '65 in', 115)");
            
        }
        catch(SQLException ex){
            System.out.println("Error creating table TVs!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createUserComps(Statement stmt){
        try{
            stmt.execute("CREATE TABLE UserComps(UserCompID CHAR(5) NOT NULL PRIMARY KEY,"
                    + "UserAppID CHAR(7) REFERENCES UserApps(UserAppID),"
                    + "CompID CHAR(5) REFERENCES Computers(CompID)"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table UserComps!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createComps(Statement stmt){
        try{
            stmt.execute("CREATE TABLE Computers(CompID CHAR(5) NOT NULL PRIMARY KEY,"
                    + "brand CHAR(12), type CHAR(15), wattage INT"
                    + ")");
            stmt.execute("INSERT INTO Computers VALUES('C-000', 'Asus', 'Mid-Tower', 350)");
            stmt.execute("INSERT INTO Computers VALUES('C-001', 'Asus', 'Small-Tower', 220)");
            stmt.execute("INSERT INTO Computers VALUES('C-002', 'Asus', 'All-in-One', 300)");
            stmt.execute("INSERT INTO Computers VALUES('C-003', 'Asus', 'Gaming PC', 600)");
            stmt.execute("INSERT INTO Computers VALUES('C-004', 'Acer', 'Mid-Tower', 310)");
            stmt.execute("INSERT INTO Computers VALUES('C-005', 'Acer', 'Small-Tower', 200)");
            stmt.execute("INSERT INTO Computers VALUES('C-006', 'Sony', 'Mid-Tower', 340)");
            stmt.execute("INSERT INTO Computers VALUES('C-007', 'Sony', 'All-in-One', 390)");
            stmt.execute("INSERT INTO Computers VALUES('C-008', 'Alien-Ware', 'Gaming PC', 650)");
            stmt.execute("INSERT INTO Computers VALUES('C-009', 'Lenovo', 'Mid-Tower', 400)");
            stmt.execute("INSERT INTO Computers VALUES('C-010', 'Chrome', 'Mini-Unit', 150)");
            
        }
        catch(SQLException ex){
            System.out.println("Error creating table Comps!");
            System.out.println(ex.getMessage());
        }
    }
    public static void createSolarPanels(Statement stmt){
        try{
            stmt.execute("CREATE TABLE SolarPanels(SolarID CHAR(5) NOT NULL PRIMARY KEY,"
                    + "HouseID CHAR(5) REFERENCES Houses(HouseID), wattage DOUBLE"
                    + ")");
        }
        catch(SQLException ex){
            System.out.println("Error creating table SolarPanels!");
            System.out.println(ex.getMessage());
        }
    }
}

/*input = JOptionPane.showInputDialog("What's the name of this appliance?");
            
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
        appli = new Appliance(input, wattage);
        
        
        container.add(new ApplianceRowPanel(room.getAppliance(index)));
        jScrollPane1.repaint();
        jScrollPane1.revalidate();
        ++index;*/