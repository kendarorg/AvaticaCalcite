package org.kendar.avatica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String args[]) {

        // define the JDBC URL; be sure to specify your own project ID
        String url = "jdbc:avatica:remote:url=http://localhost:8765"
                + ";serialization=JSON"
                + ";username=root"
                + ";password=avatica"
                + ";schema=prova"
                ;

        // get the bearer token from the environment variable
        String token = "avatica";

        // define query directed to "Koalas to the Max" table
        //String query = "SELECT continent, COUNT(*) AS counts FROM \"Koalas to the Max\" GROUP BY 1 ORDER BY counts DESC";
        //String query = "SELECT p.id,p.first,p.second FROM prova AS p";
        String query = "SELECT * FROM prova;";


        // instantiate a Properties object and store the token in the "password" key
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("password", "avatica");
        connectionProperties.setProperty("user", "root");
        //connectionProperties.setProperty("database", "prova");*/

        // establish a connection to the database
        try (Connection connection = DriverManager.getConnection(url, connectionProperties)) {
            //connection.setCatalog("prova");
            try (

                    // create a Statement object for sending SQL statements and execute query
                    final Statement statement = connection.createStatement();
                    final ResultSet rs = statement.executeQuery(query);
            ) {
                // iterate over each row of results and print to stdout
                while (rs.next()) {
                    //rs.get
                    long id = rs.getLong("id");
                    String first = rs.getString("first");
                    String second = rs.getString("second");
                    System.out.println(id + "|" + first + "|" + second);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
