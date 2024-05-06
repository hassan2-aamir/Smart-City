/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author hp
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

interface getInformation {
    String getName();
    String getDescription();
    String getFacilities();
    String getImagePath();
}

class Landmark implements getInformation {
    private String id;
    private String name;
    private String description;
    private String facilities;
    private String imagePath;

    public Landmark(String id, String name, String description, String facilities, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.facilities = facilities;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFacilities() {
        return facilities;
    }

    public String getImagePath() {
        return imagePath;
    }
}

class Campus extends Landmark {
    private String uniName;
    private int campusRating;

    public Campus(String id, String name, String description, String facilities, String imagePath,
                  String uniName, int campusRating) {
        super(id, name, description, facilities, imagePath);
        this.uniName = uniName;
        this.campusRating = campusRating;
    }

    public String getUniName() {
        return uniName;
    }

    public int getCampusRating() {
        return campusRating;
    }
}

class School extends Landmark {
    private String schoolContact;

    public School(String id, String name, String description, String facilities, String imagePath,
                  String schoolContact) {
        super(id, name, description, facilities, imagePath);
        this.schoolContact = schoolContact;
    }

    public String getSchoolContact() {
        return schoolContact;
    }
}

class KeyLocation extends Landmark {
    private String keyLocationType;

    public KeyLocation(String id, String name, String description, String facilities, String imagePath,
                       String keyLocationType) {
        super(id, name, description, facilities, imagePath);
        this.keyLocationType = keyLocationType;
    }

    public String getKeyLocationType() {
        return keyLocationType;
    }
}

class RecreationalSpot extends Landmark {
    private String rating;

    public RecreationalSpot(String id, String name, String description, String facilities, String imagePath,
                            String rating) {
        super(id, name, description, facilities, imagePath);
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }
}

class Hostel extends Landmark {
    private String hostelType;
    private String curfewTiming;
    private String rating;

    

    public Hostel(String id, String name, String description, String facilities, String imagePath,
                  String hostelType,String Rating, String curfewTiming) {
        super(id, name, description, facilities, imagePath);
        this.hostelType = hostelType;
        this.rating = Rating;
        this.curfewTiming = curfewTiming;
    }

    public String getHostelType() {
        return hostelType;
    }

    public String getCurfewTiming() {
        return curfewTiming;
    }
    public String getRating() {
        return rating;
    }
}

class FoodSpot extends Landmark {
    private String cuisineType;
    private String foodRating;

    public FoodSpot(String id, String name, String description, String facilities, String imagePath,
                    String cuisineType, String foodRating) {
        super(id, name, description, facilities, imagePath);
        this.cuisineType = cuisineType;
        this.foodRating = foodRating;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public String getFoodRating() {
        return foodRating;
    }
}


class Actions{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/smartcity";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Hassan200";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
    

    static School schoolAction(String Schoolid){
        String Schools_Campus_code="",School_name="",School_contact="",description="",facilities="",image_path="";
        try (Connection connection = getConnection()) {
            if (connection != null) {
                
                String query = "SELECT * FROM schools WHERE School_Id = \'"+Schoolid+"\'";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query)) {
                    // Process the ResultSet
                    while (resultSet.next()) {
                        Schools_Campus_code = resultSet.getString("Schools_Campus_code");
                        School_name = resultSet.getString("School_name");
                        School_contact = resultSet.getString("School_contact");
                        description = resultSet.getString("description");
                        facilities = resultSet.getString("facilities");
                        image_path = resultSet.getString("Image_path");
                        
                        
                    }
                } catch (SQLException e) {
                    System.err.println("Error executing query: " + e.getMessage());
                }
                
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
        School school = new School(Schoolid, School_name, description, facilities, image_path,School_contact);
        return school;
        
    }
    static Hostel hostelAction(String hostelId){
    String hostelCampusCode = "";
    String hostelName = "";
    double rating = 0.0;
    String hostelType = "";
    String description = "";
    String facilities = "";
    String imagePath = "";
    String openingTime = "";
    String closingTime = "";

    try (Connection connection = getConnection()) {
        if (connection != null) {
            String query = "SELECT * FROM hostels WHERE Hostel_ID = '" + hostelId + "'";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                // Process the ResultSet
                while (resultSet.next()) {
                    hostelCampusCode = resultSet.getString("Hostel_Campus_code");
                    hostelName = resultSet.getString("Hostel_name");
                    rating = resultSet.getDouble("Rating");
                    hostelType = resultSet.getString("Hostel_type");
                    description = resultSet.getString("Description");
                    facilities = resultSet.getString("Facilities");
                    imagePath = resultSet.getString("Image_path");
                    openingTime = resultSet.getString("Opening time");
                    closingTime = resultSet.getString("closing_time");
                }
            } catch (SQLException e) {
                System.err.println("Error executing query: " + e.getMessage());
            }
        }
    } catch (SQLException e) {
        System.err.println("Error connecting to the database: " + e.getMessage());
    }
    //public Hostel(String id, String name, String description, String facilities, String imagePath,String hostelType, String curfewTiming)
    Hostel hostel = new Hostel(hostelId,hostelName,description,facilities ,imagePath,hostelType,String.valueOf(rating) ,openingTime+" to "+closingTime);
    return hostel;
}
static RecreationalSpot recreationalSpotAction(String recreationalSpotId) {
    String recreationalSpotsCampusCode = "";
    String recreationalSpotsName = "";
    String description = "";
    String facilities = "";
    String imagePath = "";
    double rating = 0.0;

    try (Connection connection = getConnection()) {
        if (connection != null) {
            String query = "SELECT * FROM recreational_spots WHERE Recreational_Spots_ID = '" + recreationalSpotId + "'";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                // Process the ResultSet
                while (resultSet.next()) {
                    recreationalSpotsCampusCode = resultSet.getString("Recreational_Spots_Campus_code");
                    recreationalSpotsName = resultSet.getString("Recreational_Spots_name");
                    description = resultSet.getString("Description");
                    facilities = resultSet.getString("Facilities");
                    imagePath = resultSet.getString("Image_path");
                    rating = resultSet.getDouble("Rating");
                }
            } catch (SQLException e) {
                System.err.println("Error executing query: " + e.getMessage());
            }
        }
    } catch (SQLException e) {
        System.err.println("Error connecting to the database: " + e.getMessage());
    }
    
    // Create and return a RecreationalSpot object
    return new RecreationalSpot(recreationalSpotId, recreationalSpotsName, description, facilities, imagePath, String.valueOf(rating));
}


    /*public static KeyLocation keyLocationAction(String id){
        
        
        
        KeyLocation keyLocation;
        return keyLocation;
    }*/
}

public class SmartCampusDisplay extends javax.swing.JFrame {

    /**
     * Creates new form SmartCityDisplay
     */
    public SmartCampusDisplay() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void openSchoolForm(String imagePath,String title, String description,String facilities,String contact) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Campuses_form( imagePath, title,  description, facilities, contact).setVisible(true);
            }
        });
    }
    
    private void clickSchool(String id){
        School thisSchool = Actions.schoolAction(id);
        openSchoolForm(thisSchool.getImagePath(),thisSchool.getName(),thisSchool.getDescription(),thisSchool.getFacilities(),thisSchool.getSchoolContact());
    }
    
    private void openHostelForm(String imagePath,String title, String description,String facilities,String type,String timings,String Rating){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hostels( imagePath, title,  description, facilities, type,timings, Rating).setVisible(true);
            }
        });
    }
    private void clickHostel(String id){
        Hostel thisHostel = Actions.hostelAction(id);
        openHostelForm(thisHostel.getImagePath(),thisHostel.getName(),thisHostel.getDescription(),thisHostel.getFacilities(),thisHostel.getHostelType(),thisHostel.getCurfewTiming(),thisHostel.getRating());
    }
    
    private void openRecreationalSpotForm(String imagePath,String title, String description,String facilities,String Rating){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //recreational_Spot(String imagePath,String title, String description,String facilities,String rating)
                new recreational_Spot( imagePath, title,  description, facilities,Rating).setVisible(true);
            }
        });
    }
    private void clickRecreationalSpot(String id){
        RecreationalSpot thisRecreationalSpot = Actions.recreationalSpotAction(id);
        openRecreationalSpotForm(thisRecreationalSpot.getImagePath(),thisRecreationalSpot.getName(),thisRecreationalSpot.getDescription(),thisRecreationalSpot.getFacilities(),thisRecreationalSpot.getRating());
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        myButton2 = new MyButton();
        myButton5 = new MyButton();
        myButton6 = new MyButton();
        myButton7 = new MyButton();
        myButton8 = new MyButton();
        myButton10 = new MyButton();
        myButton3 = new MyButton();
        myButton4 = new MyButton();
        myButton11 = new MyButton();
        myButton12 = new MyButton();
        myButton13 = new MyButton();
        myButton14 = new MyButton();
        myButton15 = new MyButton();
        myButton16 = new MyButton();
        myButton17 = new MyButton();
        myButton18 = new MyButton();
        myButton19 = new MyButton();
        myButton20 = new MyButton();
        myButton21 = new MyButton();
        myButton22 = new MyButton();
        myButton23 = new MyButton();
        myButton24 = new MyButton();
        myButton25 = new MyButton();
        myButton26 = new MyButton();
        myButton27 = new MyButton();
        myButton28 = new MyButton();
        myButton29 = new MyButton();
        myButton30 = new MyButton();
        myButton31 = new MyButton();
        myButton32 = new MyButton();
        myButton33 = new MyButton();
        myButton34 = new MyButton();
        myButton35 = new MyButton();
        myButton36 = new MyButton();
        myButton37 = new MyButton();
        myButton38 = new MyButton();
        myButton39 = new MyButton();
        myButton40 = new MyButton();
        myButton41 = new MyButton();
        myButton42 = new MyButton();
        myButton43 = new MyButton();
        myButton44 = new MyButton();
        myButton45 = new MyButton();
        myButton46 = new MyButton();
        myButton47 = new MyButton();
        myButton48 = new MyButton();
        myButton49 = new MyButton();
        myButton50 = new MyButton();
        myButton51 = new MyButton();
        myButton52 = new MyButton();
        myButton53 = new MyButton();
        myButton54 = new MyButton();
        myButton55 = new MyButton();
        myButton56 = new MyButton();
        myButton57 = new MyButton();
        myButton61 = new MyButton();
        myButton62 = new MyButton();
        myButton63 = new MyButton();
        myButton64 = new MyButton();
        myButton66 = new MyButton();
        myButton67 = new MyButton();
        myButton68 = new MyButton();
        myButton69 = new MyButton();
        myButton70 = new MyButton();
        myButton65 = new MyButton();
        myButton71 = new MyButton();
        myButton59 = new MyButton();
        myButton72 = new MyButton();
        myButton73 = new MyButton();
        myButton74 = new MyButton();
        myButton75 = new MyButton();
        myButton9 = new MyButton();
        myButton58 = new MyButton();
        myButton76 = new MyButton();
        myButton60 = new MyButton();
        myButton77 = new MyButton();
        myButton78 = new MyButton();
        myButton79 = new MyButton();
        myButton80 = new MyButton();
        myButton81 = new MyButton();
        myButton82 = new MyButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(927, 12, -1, 431));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(933, 383, -1, -1));

        myButton2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton2.setBorderPainted(false);
        myButton2.setRadius(20);
        getContentPane().add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 30, 30));

        myButton5.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton5.setBorderPainted(false);
        myButton5.setRadius(20);
        getContentPane().add(myButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 30, 30));

        myButton6.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton6.setBorderPainted(false);
        myButton6.setRadius(20);
        myButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 30, 30));

        myButton7.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton7.setBorderPainted(false);
        myButton7.setRadius(20);
        getContentPane().add(myButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 30, 30));

        myButton8.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton8.setBorderPainted(false);
        myButton8.setRadius(20);
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 30, 30));

        myButton10.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton10.setBorderPainted(false);
        myButton10.setRadius(20);
        getContentPane().add(myButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, 30, 30));

        myButton3.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton3.setBorderPainted(false);
        myButton3.setRadius(20);
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 30, 30));

        myButton4.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton4.setBorderPainted(false);
        myButton4.setRadius(20);
        getContentPane().add(myButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 440, 30, 30));

        myButton11.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton11.setBorderPainted(false);
        myButton11.setRadius(20);
        getContentPane().add(myButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 360, 30, 30));

        myButton12.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton12.setBorderPainted(false);
        myButton12.setRadius(20);
        getContentPane().add(myButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, 30, 30));

        myButton13.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton13.setBorderPainted(false);
        myButton13.setRadius(20);
        getContentPane().add(myButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 300, 30, 30));

        myButton14.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton14.setBorderPainted(false);
        myButton14.setRadius(20);
        myButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 30, 30));

        myButton15.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton15.setBorderPainted(false);
        myButton15.setRadius(20);
        getContentPane().add(myButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, 30, 30));

        myButton16.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton16.setBorderPainted(false);
        myButton16.setRadius(20);
        myButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 30, 30));

        myButton17.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton17.setBorderPainted(false);
        myButton17.setRadius(20);
        myButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 30, 30));

        myButton18.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton18.setBorderPainted(false);
        myButton18.setRadius(20);
        myButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 30, 30));

        myButton19.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton19.setBorderPainted(false);
        myButton19.setRadius(20);
        myButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 30, 30));

        myButton20.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton20.setBorderPainted(false);
        myButton20.setRadius(20);
        getContentPane().add(myButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 30, 30));

        myButton21.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton21.setBorderPainted(false);
        myButton21.setRadius(20);
        myButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 30, 30));

        myButton22.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton22.setBorderPainted(false);
        myButton22.setRadius(20);
        getContentPane().add(myButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 30, 30));

        myButton23.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton23.setBorderPainted(false);
        myButton23.setRadius(20);
        getContentPane().add(myButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 30, 30));

        myButton24.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton24.setBorderPainted(false);
        myButton24.setRadius(20);
        myButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 30, 30));

        myButton25.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton25.setBorderPainted(false);
        myButton25.setRadius(20);
        myButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton25ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 30, 30));

        myButton26.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton26.setBorderPainted(false);
        myButton26.setRadius(20);
        myButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton26ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 30, 30));

        myButton27.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton27.setBorderPainted(false);
        myButton27.setRadius(20);
        myButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 30, 30));

        myButton28.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton28.setBorderPainted(false);
        myButton28.setRadius(20);
        myButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton28ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 30, 30));

        myButton29.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton29.setBorderPainted(false);
        myButton29.setRadius(20);
        myButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton29ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 30, 30));

        myButton30.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton30.setBorderPainted(false);
        myButton30.setRadius(20);
        getContentPane().add(myButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 30, 30));

        myButton31.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton31.setBorderPainted(false);
        myButton31.setRadius(20);
        getContentPane().add(myButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 30, 30));

        myButton32.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton32.setBorderPainted(false);
        myButton32.setRadius(20);
        getContentPane().add(myButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 30, 30));

        myButton33.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton33.setBorderPainted(false);
        myButton33.setRadius(20);
        getContentPane().add(myButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 30, 30));

        myButton34.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton34.setBorderPainted(false);
        myButton34.setRadius(20);
        getContentPane().add(myButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 30, 30));

        myButton35.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton35.setBorderPainted(false);
        myButton35.setRadius(20);
        getContentPane().add(myButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 30, 30));

        myButton36.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton36.setBorderPainted(false);
        myButton36.setRadius(20);
        getContentPane().add(myButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 30, 30));

        myButton37.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton37.setBorderPainted(false);
        myButton37.setRadius(20);
        myButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton37ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 30, 30));

        myButton38.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton38.setBorderPainted(false);
        myButton38.setRadius(20);
        getContentPane().add(myButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 30, 30));

        myButton39.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton39.setBorderPainted(false);
        myButton39.setRadius(20);
        myButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton39ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 30, 30));

        myButton40.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton40.setBorderPainted(false);
        myButton40.setRadius(20);
        getContentPane().add(myButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 30, 30));

        myButton41.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton41.setBorderPainted(false);
        myButton41.setRadius(20);
        myButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton41ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 30, 30));

        myButton42.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton42.setBorderPainted(false);
        myButton42.setRadius(20);
        myButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton42ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 30, 30));

        myButton43.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton43.setBorderPainted(false);
        myButton43.setRadius(20);
        myButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton43ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 30, 30));

        myButton44.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton44.setBorderPainted(false);
        myButton44.setRadius(20);
        myButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton44ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 30, 30));

        myButton45.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton45.setBorderPainted(false);
        myButton45.setRadius(20);
        myButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton45ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 30, 30));

        myButton46.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton46.setBorderPainted(false);
        myButton46.setRadius(20);
        myButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton46ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 30, 30));

        myButton47.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton47.setBorderPainted(false);
        myButton47.setRadius(20);
        myButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton47ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 30, 30));

        myButton48.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton48.setBorderPainted(false);
        myButton48.setRadius(20);
        myButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton48ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 30, 30));

        myButton49.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton49.setBorderPainted(false);
        myButton49.setRadius(20);
        myButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton49ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 30, 30));

        myButton50.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton50.setBorderPainted(false);
        myButton50.setRadius(20);
        getContentPane().add(myButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 30, 30));

        myButton51.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton51.setBorderPainted(false);
        myButton51.setRadius(20);
        myButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton51ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 30, 30));

        myButton52.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton52.setBorderPainted(false);
        myButton52.setRadius(20);
        myButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton52ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 30, 30));

        myButton53.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton53.setBorderPainted(false);
        myButton53.setRadius(20);
        myButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton53ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 30, 30));

        myButton54.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton54.setBorderPainted(false);
        myButton54.setRadius(20);
        getContentPane().add(myButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, -1, 30));

        myButton55.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton55.setBorderPainted(false);
        myButton55.setRadius(20);
        getContentPane().add(myButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 30, 30));

        myButton56.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton56.setBorderPainted(false);
        myButton56.setRadius(20);
        getContentPane().add(myButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, 30, 30));

        myButton57.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton57.setBorderPainted(false);
        myButton57.setRadius(20);
        myButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton57ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 30, 30));

        myButton61.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton61.setBorderPainted(false);
        myButton61.setRadius(20);
        myButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton61ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 30, 30));

        myButton62.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton62.setBorderPainted(false);
        myButton62.setRadius(20);
        myButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton62ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 30, 30));

        myButton63.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton63.setBorderPainted(false);
        myButton63.setRadius(20);
        myButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton63ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 30, 30));

        myButton64.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton64.setBorderPainted(false);
        myButton64.setRadius(20);
        myButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton64ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 30, 30));

        myButton66.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton66.setBorderPainted(false);
        myButton66.setRadius(20);
        myButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton66ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, 30, 30));

        myButton67.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton67.setBorderPainted(false);
        myButton67.setRadius(20);
        myButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton67ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton67, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 30, 30));

        myButton68.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton68.setBorderPainted(false);
        myButton68.setRadius(20);
        getContentPane().add(myButton68, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 340, 30, 30));

        myButton69.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton69.setBorderPainted(false);
        myButton69.setRadius(20);
        myButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton69ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton69, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, 30, 30));

        myButton70.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton70.setBorderPainted(false);
        myButton70.setRadius(20);
        myButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton70ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton70, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 30, 30));

        myButton65.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton65.setBorderPainted(false);
        myButton65.setRadius(20);
        myButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton65ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 30, 30));

        myButton71.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton71.setBorderPainted(false);
        myButton71.setRadius(20);
        getContentPane().add(myButton71, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 190, 30, 30));

        myButton59.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton59.setBorderPainted(false);
        myButton59.setRadius(20);
        myButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton59ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 30, 30));

        myButton72.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton72.setBorderPainted(false);
        myButton72.setRadius(20);
        myButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton72ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton72, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 30, 30));

        myButton73.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton73.setBorderPainted(false);
        myButton73.setRadius(20);
        myButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton73ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton73, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 30, 30));

        myButton74.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton74.setBorderPainted(false);
        myButton74.setRadius(20);
        myButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton74ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton74, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 30, 30));

        myButton75.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton75.setBorderPainted(false);
        myButton75.setRadius(20);
        myButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton75ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton75, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 30, 30));

        myButton9.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton9.setBorderPainted(false);
        myButton9.setRadius(20);
        myButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 30, 30));

        myButton58.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton58.setBorderPainted(false);
        myButton58.setRadius(20);
        myButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton58ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 30, 30));

        myButton76.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton76.setBorderPainted(false);
        myButton76.setRadius(20);
        myButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton76ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton76, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 30, 30));

        myButton60.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton60.setBorderPainted(false);
        myButton60.setRadius(20);
        myButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton60ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 30, 30));

        myButton77.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton77.setBorderPainted(false);
        myButton77.setRadius(20);
        myButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton77ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton77, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 30, 30));

        myButton78.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton78.setBorderPainted(false);
        myButton78.setRadius(20);
        myButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton78ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton78, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 30, 30));

        myButton79.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton79.setBorderPainted(false);
        myButton79.setRadius(20);
        myButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton79ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton79, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 30, 30));

        myButton80.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton80.setBorderPainted(false);
        myButton80.setRadius(20);
        myButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton80ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton80, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 30, 30));

        myButton81.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton81.setBorderPainted(false);
        myButton81.setRadius(20);
        myButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton81ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton81, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 30, 30));

        myButton82.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        myButton82.setBorderPainted(false);
        myButton82.setRadius(20);
        myButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton82ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton82, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Downloads\\Screenshot 2024-04-21 183638.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -230, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton6ActionPerformed
        clickRecreationalSpot("RS-13");// TODO add your 
    }//GEN-LAST:event_myButton6ActionPerformed
    
    private void myButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton61ActionPerformed

    private void myButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton62ActionPerformed
        clickSchool("HSMME-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton62ActionPerformed

    private void myButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton63ActionPerformed
       clickRecreationalSpot("RS-22");
        
    }//GEN-LAST:event_myButton63ActionPerformed

    private void myButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton64ActionPerformed
        clickRecreationalSpot("RS-6");// TODO add your handling code here:
    }//GEN-LAST:event_myButton64ActionPerformed

    private void myButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton66ActionPerformed
        clickRecreationalSpot("RS-7");// TODO add your handling code here:
    }//GEN-LAST:event_myButton66ActionPerformed

    private void myButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton67ActionPerformed
        clickSchool("HSNS-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton67ActionPerformed

    private void myButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton27ActionPerformed
        // TODO add your handling code here:
        clickSchool("HASAB-12");
    }//GEN-LAST:event_myButton27ActionPerformed

    private void myButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton53ActionPerformed
        clickSchool("HIAEC-12");
    }//GEN-LAST:event_myButton53ActionPerformed

    private void myButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton65ActionPerformed
        clickSchool("HRIMS-12");
    }//GEN-LAST:event_myButton65ActionPerformed

    private void myButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton51ActionPerformed
        clickSchool("HIESE-12");
    }//GEN-LAST:event_myButton51ActionPerformed

    private void myButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton52ActionPerformed
        clickSchool("HIGIS-12");
    }//GEN-LAST:event_myButton52ActionPerformed

    private void myButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton29ActionPerformed
        clickSchool("HNBS-12");        // TODO add your handling code here:
    }//GEN-LAST:event_myButton29ActionPerformed

    private void myButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton69ActionPerformed
        clickSchool("HSINES-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton69ActionPerformed

    private void myButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton28ActionPerformed
        clickSchool("HSEECS-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton28ActionPerformed

    private void myButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton14ActionPerformed
        clickSchool("HNSHS-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton14ActionPerformed

    private void myButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton25ActionPerformed
        clickSchool("HS3H-12");
    }//GEN-LAST:event_myButton25ActionPerformed

    private void myButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton26ActionPerformed
        clickSchool("HSADA-12");
    }//GEN-LAST:event_myButton26ActionPerformed

    private void myButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton47ActionPerformed
        clickSchool("HUSPC-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton47ActionPerformed

    private void myButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton46ActionPerformed
        clickSchool("HNICE-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton46ActionPerformed

    private void myButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton41ActionPerformed
        clickHostel("GZL-H12");
    }//GEN-LAST:event_myButton41ActionPerformed

    private void myButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton59ActionPerformed
        clickHostel("BRN-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton59ActionPerformed

    private void myButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton16ActionPerformed
        clickHostel("AMN-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton16ActionPerformed

    private void myButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton72ActionPerformed
        clickHostel("ATR-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton72ActionPerformed

    private void myButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton18ActionPerformed
        clickHostel("AYS-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton18ActionPerformed

    private void myButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton24ActionPerformed
        clickHostel("FTM-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton24ActionPerformed

    private void myButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton45ActionPerformed
        clickHostel("HJR-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton45ActionPerformed

    private void myButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton73ActionPerformed
        clickHostel("RMI-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton73ActionPerformed

    private void myButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton37ActionPerformed
        clickHostel("AMR-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton37ActionPerformed

    private void myButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton74ActionPerformed
        clickHostel("JHR-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton74ActionPerformed

    private void myButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton39ActionPerformed
        clickHostel("LQT-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton39ActionPerformed

    private void myButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton43ActionPerformed
        clickHostel("RHM-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton43ActionPerformed

    private void myButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton75ActionPerformed
        clickHostel("RZI-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton75ActionPerformed

    private void myButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton44ActionPerformed
        clickHostel("ZKR-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton44ActionPerformed

    private void myButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton19ActionPerformed
        clickHostel("ZNB-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton19ActionPerformed

    private void myButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton17ActionPerformed
        clickHostel("MRM-H12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton17ActionPerformed

    private void myButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton48ActionPerformed
        clickSchool("HSCME-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton48ActionPerformed

    private void myButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton21ActionPerformed
        clickRecreationalSpot("RS-1");// TODO add your handling code here:
    }//GEN-LAST:event_myButton21ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        clickRecreationalSpot("RS-2");// TODO add your handling code here:
    }//GEN-LAST:event_myButton3ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        clickRecreationalSpot("RS-3");// TODO add your handling code here:
    }//GEN-LAST:event_myButton8ActionPerformed

    private void myButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton9ActionPerformed
        clickRecreationalSpot("RS-4");// TODO add your handling code here:
    }//GEN-LAST:event_myButton9ActionPerformed

    private void myButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton57ActionPerformed
        clickRecreationalSpot("RS-5");// TODO add your handling code here:
    }//GEN-LAST:event_myButton57ActionPerformed

    private void myButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton58ActionPerformed
        clickRecreationalSpot("RS-8");// TODO add your handling code here:
    }//GEN-LAST:event_myButton58ActionPerformed

    private void myButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton76ActionPerformed
        clickRecreationalSpot("RS-9");// TODO add your handling code here:
    }//GEN-LAST:event_myButton76ActionPerformed

    private void myButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton60ActionPerformed
        clickRecreationalSpot("RS-10");// TODO add your handling code here:
    }//GEN-LAST:event_myButton60ActionPerformed

    private void myButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton77ActionPerformed
        clickRecreationalSpot("RS-11");// TODO add your handling code here:
    }//GEN-LAST:event_myButton77ActionPerformed

    private void myButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton70ActionPerformed
        clickRecreationalSpot("RS-12");// TODO add your handling code here:
    }//GEN-LAST:event_myButton70ActionPerformed

    private void myButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton49ActionPerformed
        clickRecreationalSpot("RS-14");// TODO add your handling code here:
    }//GEN-LAST:event_myButton49ActionPerformed

    private void myButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton78ActionPerformed
        clickRecreationalSpot("RS-15");// TODO add your handling code here:
    }//GEN-LAST:event_myButton78ActionPerformed

    private void myButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton79ActionPerformed
        clickRecreationalSpot("RS-16");// TODO add your handling code here:
    }//GEN-LAST:event_myButton79ActionPerformed

    private void myButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton80ActionPerformed
        clickRecreationalSpot("RS-18");// TODO add your handling code here:
    }//GEN-LAST:event_myButton80ActionPerformed

    private void myButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton81ActionPerformed
        clickRecreationalSpot("RS-20");// TODO add your handling code here:
    }//GEN-LAST:event_myButton81ActionPerformed

    private void myButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton82ActionPerformed
        clickRecreationalSpot("RS-21");// TODO add your handling code here:
    }//GEN-LAST:event_myButton82ActionPerformed

    private void myButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton42ActionPerformed
        clickRecreationalSpot("RS-23");// TODO add your handling code here:
    }//GEN-LAST:event_myButton42ActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SmartCampusDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SmartCampusDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SmartCampusDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SmartCampusDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmartCampusDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private MyButton myButton10;
    private MyButton myButton11;
    private MyButton myButton12;
    private MyButton myButton13;
    private MyButton myButton14;
    private MyButton myButton15;
    private MyButton myButton16;
    private MyButton myButton17;
    private MyButton myButton18;
    private MyButton myButton19;
    private MyButton myButton2;
    private MyButton myButton20;
    private MyButton myButton21;
    private MyButton myButton22;
    private MyButton myButton23;
    private MyButton myButton24;
    private MyButton myButton25;
    private MyButton myButton26;
    private MyButton myButton27;
    private MyButton myButton28;
    private MyButton myButton29;
    private MyButton myButton3;
    private MyButton myButton30;
    private MyButton myButton31;
    private MyButton myButton32;
    private MyButton myButton33;
    private MyButton myButton34;
    private MyButton myButton35;
    private MyButton myButton36;
    private MyButton myButton37;
    private MyButton myButton38;
    private MyButton myButton39;
    private MyButton myButton4;
    private MyButton myButton40;
    private MyButton myButton41;
    private MyButton myButton42;
    private MyButton myButton43;
    private MyButton myButton44;
    private MyButton myButton45;
    private MyButton myButton46;
    private MyButton myButton47;
    private MyButton myButton48;
    private MyButton myButton49;
    private MyButton myButton5;
    private MyButton myButton50;
    private MyButton myButton51;
    private MyButton myButton52;
    private MyButton myButton53;
    private MyButton myButton54;
    private MyButton myButton55;
    private MyButton myButton56;
    private MyButton myButton57;
    private MyButton myButton58;
    private MyButton myButton59;
    private MyButton myButton6;
    private MyButton myButton60;
    private MyButton myButton61;
    private MyButton myButton62;
    private MyButton myButton63;
    private MyButton myButton64;
    private MyButton myButton65;
    private MyButton myButton66;
    private MyButton myButton67;
    private MyButton myButton68;
    private MyButton myButton69;
    private MyButton myButton7;
    private MyButton myButton70;
    private MyButton myButton71;
    private MyButton myButton72;
    private MyButton myButton73;
    private MyButton myButton74;
    private MyButton myButton75;
    private MyButton myButton76;
    private MyButton myButton77;
    private MyButton myButton78;
    private MyButton myButton79;
    private MyButton myButton8;
    private MyButton myButton80;
    private MyButton myButton81;
    private MyButton myButton82;
    private MyButton myButton9;
    // End of variables declaration//GEN-END:variables
}
