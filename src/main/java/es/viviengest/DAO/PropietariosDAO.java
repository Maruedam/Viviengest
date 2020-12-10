/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;

import es.viviengest.beans.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author dwigh
 */
public class PropietariosDAO implements IPropietariosDAO {

    Connection conexion;
    DataSource datasource;
    String cds = "";

    @Override
    public List<Propietario> getPropietarios() {
        conexion = ConnectionFactory.getConexionMYSQL();
        List<Propietario> lPropietarios = new ArrayList<Propietario>();
        Propietario propietario = null;
        String consulta = "select * from propietarios";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                propietario = new Propietario();

                propietario.setId(resultado.getLong("idusuario"));
                propietario.setDireccionpostal(resultado.getString("direccionpostal"));
                propietario.setNumecuenta(resultado.getString("numecuenta"));
                lPropietarios.add(propietario);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return lPropietarios;
    }

    @Override
    public Propietario getPropietario(Long id) {
        conexion = ConnectionFactory.getConexionMYSQL();
        Propietario propietario = null;
        String consulta = "select * from propietarios where idusuario='" + id + "'";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                propietario = new Propietario();
                propietario.setId(id);
                propietario.setDireccionpostal(resultado.getString("direccion_postal"));
                propietario.setNumecuenta(resultado.getString("numecuenta"));
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }

        return propietario;
    }

    @Override
    public void deletePropietario(Long id) {
        conexion = ConnectionFactory.getConexionMYSQL();

        String query1 = "delete from propietarios  WHERE idusuario in(?)";
        PreparedStatement p = null;
        try {
            conexion.setAutoCommit(false);

            p = conexion.prepareStatement(query1);

            p.setLong(1, id);

            p.executeUpdate();
            conexion.commit();
            System.out.println("Se ha eliminado correctamente en la bd");
        } catch (SQLException ex) {
            System.out.println("error al eliminar");
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
    }

    @Override
    public void insertarPropietario(Propietario p) {

        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "insert into propietarios (numecuenta, direccion_postal,idusuario ) values (?, ?, ?)";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setString(1, p.getNumecuenta());
            pa.setString(2, p.getDireccionpostal());
            pa.setLong(3, p.getUsuario().getId());
            pa.executeUpdate();

            conexion.commit();
            System.out.println("Se ha insertado correctamente en la bd");
        } catch (SQLException ex) {
            System.out.println("error al insertar ");
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
    }

    @Override
    public void actualizarPropietario(Propietario p) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "UPDATE propietarios SET numecuenta=?, direccion_postal=? ,idusuario=? WHERE idusuario=?";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setString(1, p.getNumecuenta());
            pa.setString(2, p.getDireccionpostal());
            pa.setLong(3, p.getUsuario().getId());
            pa.setLong(4, p.getUsuario().getId());
            pa.executeUpdate();

            conexion.commit();
            System.out.println("Se ha modificado correctamente en la bd");
        } catch (SQLException ex) {
            System.out.println("error al insertar ");
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
    }

    @Override
    public void closeConnection() {
        //se cierra la conexion
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
