package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student extends User {
    private String StudentUsername;
    private String StudentName;
    private String StudentPassword;
    private int Teacher;
    private String Level;

    public Student(String user, String pass, String name, int teacher) {
        StudentUsername = user;
        StudentPassword = pass;
        StudentName = name;
        Teacher = teacher;
    }

    public static void addStudent(String username, String password, int teacher, String name) {
        MySQL.addStudentToDB(MySQL.establishConnection(), username, password, teacher, name);
    }
    public static void studentLogin(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/?user=root",
                    "root",
                    "CompSci2004%"
            );

            String checkForUsername = "SELECT * FROM `final_destination`.`Students` WHERE username = ?";
            pstmt = conn.prepareStatement(checkForUsername);
            pstmt.setString(1, username);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                String pWord = rs.getString("password");

                if (password.equals(pWord)) {
                    System.out.println("Logged In");
                } else {
                    System.out.println("Incorrect username or password.");
                }
            } else {
                System.out.println("Username not found.");
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e + "has occurred.");
        }
    }

    public String getFirstName() {
        return StudentName;
    }

    public void setFirstName(String firstNameTwo) {
        StudentName = firstNameTwo;
    }

    public String getUsername() {
        return StudentUsername;
    }

    public String getPassword() {
        return StudentPassword;
    }

    public void setPassword(String passwordTwo) {
        StudentPassword = passwordTwo;
    }

    public int getTeacher() {
        return Teacher;
    }

    public void setTeacher(int teacherTwo) {
        Teacher = teacherTwo;
    }

    public void setTotalScore(int minScore) {//to do
    }

    public int getTotalScore() {return 0;//dummy value
    }
}
