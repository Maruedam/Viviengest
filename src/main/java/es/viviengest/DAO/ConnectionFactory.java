package es.viviengest.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwigh
 */
public class ConnectionFactory {
    
    public static final String MYSQL ="java:comp/env/jdbc/User";
    static Connection conexion=null;
    static DataSource datasource = null;
    public static Connection getConexionMYSQL() {
        try {
            Context contextoInicial = new InitialContext();
            datasource = (DataSource) contextoInicial.lookup(MYSQL);
            conexion=datasource.getConnection();
        } catch (NamingException | SQLException ex) {
            System.out.println("Problemas en el acceso a la bd");
            ex.printStackTrace();
        }
        return conexion;
    }

    public static void closeConexion(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
        }catch (SQLException ex){
                ex.printStackTrace();
            }

    }
    
}
