package Model;

import java.sql.*;

/**
 * Teacher class
 * @author Olivia Greensill
 */
public class Teacher extends User {
    String TeacherName;

    /**
     * Get the teachers first and last name
     * @param username
     */
    public void getName (int username) {
        String userString = Integer.toString(username);
        TeacherName = MySQL.getTeacherFromDB(MySQL.establishConnection(), userString).get(3) + "," + MySQL.getTeacherFromDB(MySQL.establishConnection(), userString).get(4);
    }

    /**
     * Add a new teacher to the database
     * @param username the teachers integer username
     * @param password the teachers hashed password
     * @param fname the teachers first name
     * @param lname the teachers last name
     */
    public static void addTeacher(int username, String password, String fname, String lname) {
        MySQL.addTeacherToDB(MySQL.establishConnection(), username, password, fname, lname);
    }

    /**
     * Get a list of the teachers students
     * @param teacher the teachers username
     */
    public static void getTeachersStudents(int teacher) {
        MySQL.getTeachersStudents(MySQL.establishConnection(), teacher);
    }

}
