package be.intecbrussel.centralblogproject.listener;

import org.apache.ibatis.jdbc.ScriptRunner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String scriptPath = "/Users/Elias/IdeaProjects/CentralBlogProject/src/main/java/be/intecbrussel/centralblogproject/data/MockarooDataListenerScript.sql";

        // Create MySql Connection
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blogApp", "root", "S0wiesoo");
            Statement stmt = null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            // Initialize object for ScripRunner
            ScriptRunner sr = new ScriptRunner(con);

            // Give the input file to Reader
            Reader reader =
                    new BufferedReader(
                            new FileReader(scriptPath));

            // Executute script
            sr.runScript(reader);

        } catch (Exception e) {
            System.err.println("Failed to Execute" + scriptPath
                    + " The error is " + e.getMessage());
        }
    }
}
