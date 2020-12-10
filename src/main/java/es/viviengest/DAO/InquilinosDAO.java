/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;

import es.viviengest.beans.Inquilino; 
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
public class InquilinosDAO implements IInquilinosDAO {

    Connection conexion;
    DataSource datasource;
    String cds = "";

    @Override
    public List<Inquilino> getInquilinos() {
        conexion = ConnectionFactory.getConexionMYSQL();
        List<Inquilino> lInquilinos = new ArrayList<Inquilino>();
        Inquilino inquilino = null;
        String consulta = "select * from inquilinos";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                inquilino = new Inquilino();

                inquilino.setId(resultado.getLong("idusuario"));
                inquilino.setultima_nomina(resultado.getDouble("ultima_Nomina"));
                lInquilinos.add(inquilino);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return lInquilinos;
    }

    @Override
    public Inquilino getInquilino(Long id) {
        conexion = ConnectionFactory.getConexionMYSQL();
        Inquilino inquilino = null;
        String consulta = "select * from inquilinos where idusuario='" + id + "'";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                inquilino = new Inquilino();
                inquilino.setId(resultado.getLong("idusuario"));
                inquilino.setultima_nomina(resultado.getDouble("ultima_Nomina"));
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return inquilino;
    }

    @Override
    public void deleteInquilino(Long id) {
        conexion = ConnectionFactory.getConexionMYSQL();

        String query1 = "delete from inquilinos  WHERE idusuario in(?)";
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
    public void insertarInquilino(Inquilino i) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "insert into inquilinos (idusuario, ultima_nomina) values (?, ?)";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setLong(1, i.getUsuario().getId());
            pa.setDouble(2, i.getultima_nomina());
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
    public void actualizarInquilino(Inquilino i) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "UPDATE inquilinos SET idusuario=?, ultima_nomina=? WHERE idusuario=?";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setLong(1, i.getUsuario().getId());
            pa.setDouble(2, i.getultima_nomina());
            pa.setLong(3, i.getUsuario().getId());
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
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
