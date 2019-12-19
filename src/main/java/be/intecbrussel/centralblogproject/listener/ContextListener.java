package be.intecbrussel.centralblogproject.listener;

import org.apache.ibatis.jdbc.ScriptRunner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String scriptPath = "src/main/java/be/intecbrussel/centralblogproject/data/MockarooDataListenerScript.sql";

        // Create MySql Connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/blogApp",
                    "root",
                    "S0wiesoo");
            // Initialize object for ScripRunner
            ScriptRunner sr = new ScriptRunner(con);

            // Give the input file to Reader
            Reader reader =
                    new BufferedReader(
                            new FileReader(scriptPath));

            // Execute script
            sr.runScript(reader);

            // Close script
            con.close();
        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
