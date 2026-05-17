
package com.mycompany.sistemaclientessql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
     public static Connection conectar() {

        Connection con = null;

        try {

            String url =
                    "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=SISCLIENTE1;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true";

            String user = "sa";
            String password = "aboza27";

            con = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            System.out.println("Conexion exitosa");

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }

        return con;
    }
}
