/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;

import static es.viviengest.DAO.ConnectionFactory.conexion;
import es.viviengest.beans.AlquiladaPor;
import es.viviengest.beans.Alquiler;
import es.viviengest.beans.Inquilino;
import es.viviengest.beans.Propietario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dwigh
 */
public class AlquileresDAO implements IAlquileresDAO {

    @Override
    public List<Alquiler> getAlquileres() {
        conexion = ConnectionFactory.getConexionMYSQL();
        List<Alquiler> lAlquileres = new ArrayList<Alquiler>();
        Propietario p = new Propietario();
        Inquilino i = new Inquilino();
        ViviendasDAO vdao = new ViviendasDAO();
        PropietariosDAO pdao = new PropietariosDAO();
        InquilinosDAO idao = new InquilinosDAO();
        Alquiler alquiler = null;
        String consulta = "select * from alquileres";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                alquiler = new Alquiler();

                alquiler.setId(resultado.getLong("id"));
                alquiler.setPropietario(pdao.getPropietario(resultado.getLong("idPropietario")));
                alquiler.setInquilino(idao.getInquilino(resultado.getLong("idInquilino")));
                alquiler.setFecha_entrada(resultado.getDate("fecha_entrada"));
                alquiler.setFecha_salida(resultado.getDate("fecha_salida"));
                alquiler.setVivienda(vdao.getViviendaId(resultado.getLong("idvivienda")));
                lAlquileres.add(alquiler);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return lAlquileres;
    }

    @Override
    public Alquiler getAlquiler(Long idInquilino) {
        conexion = ConnectionFactory.getConexionMYSQL();
        ViviendasDAO vdao = new ViviendasDAO();
        PropietariosDAO pdao = new PropietariosDAO();
        InquilinosDAO idao = new InquilinosDAO();
        Alquiler alquiler = null;
        String consulta = "select * from alquileres where idInquilino='" + idInquilino + "'";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                alquiler = new Alquiler();
                alquiler.setId(idInquilino);
                alquiler.setPropietario(pdao.getPropietario(resultado.getLong("idPropietario")));
                alquiler.setInquilino(idao.getInquilino(resultado.getLong("idInquilino")));
                alquiler.setFecha_entrada(resultado.getDate("fecha_entrada"));
                alquiler.setFecha_salida(resultado.getDate("fecha_salida"));
                alquiler.setVivienda(vdao.getViviendaId(resultado.getLong("idvivienda")));
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }

        return alquiler;
    }

    @Override
    public List<Alquiler> getAlquileresPropietario(Long idPropietario) {
        conexion = ConnectionFactory.getConexionMYSQL();
        List<Alquiler> lAlquileres = new ArrayList<Alquiler>();
        Propietario p = new Propietario();
        Inquilino i = new Inquilino();
        ViviendasDAO vdao = new ViviendasDAO();
        PropietariosDAO pdao = new PropietariosDAO();
        InquilinosDAO idao = new InquilinosDAO();
        Alquiler alquiler = null;
        String consulta = "select * from alquileres where idPropietario='" + idPropietario + "'";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                alquiler = new Alquiler();

                alquiler.setId(resultado.getLong("id"));
                alquiler.setPropietario(pdao.getPropietario(resultado.getLong("idPropietario")));
                alquiler.setInquilino(idao.getInquilino(resultado.getLong("idInquilino")));
                alquiler.setFecha_entrada(resultado.getDate("fecha_entrada"));
                alquiler.setFecha_salida(resultado.getDate("fecha_salida"));
                alquiler.setVivienda(vdao.getViviendaId(resultado.getLong("idvivienda")));
                lAlquileres.add(alquiler);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return lAlquileres;
    }

    @Override
    public void deleteAlquiler(Long idvivienda) {
        conexion = ConnectionFactory.getConexionMYSQL();

        String query1 = "delete from alquileres  WHERE idvivienda in(?)";
        PreparedStatement p = null;
        try {
            conexion.setAutoCommit(false);

            p = conexion.prepareStatement(query1);

            p.setLong(1, idvivienda);

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
    public void insertarAlquiler(Alquiler alquiler) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "insert into alquileres (idPropietario, idInquilino, fecha_entrada, fecha_salida, idvivienda ) values (?, ?, ?, ?, ?)";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setLong(1, alquiler.getPropietario().getId());
            pa.setLong(2, alquiler.getInquilino().getId());
            pa.setDate(3, (Date) alquiler.getFecha_entrada());
            pa.setDate(4, (Date) alquiler.getFecha_salida());
            pa.setLong(5, alquiler.getVivienda().getId());

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

    
    public AlquiladaPor getAlquiladaPor(Long idvivienda) {
        conexion = ConnectionFactory.getConexionMYSQL();
        ViviendasDAO vdao = new ViviendasDAO();
        InquilinosDAO idao = new InquilinosDAO();
        AlquiladaPor alquiladaPor = null;
        String consulta = "select * from alquiladapor where idvivienda='" + idvivienda + "'";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                alquiladaPor = new AlquiladaPor();
                alquiladaPor.setInquilino(idao.getInquilino(resultado.getLong("idusuario")));
                alquiladaPor.setVivienda(vdao.getViviendaId(resultado.getLong("idvivienda")));
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }

        return alquiladaPor;
    }

    public void deleteAlquiladaPor(Long idvivienda) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String consulta = "delete from alquiladapor where idvivienda in(?)";
        PreparedStatement p = null;
        try {
            conexion.setAutoCommit(false);

            p = conexion.prepareStatement(consulta);

            p.setLong(1, idvivienda);

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
    
     public void insertarAlquiladaPor(AlquiladaPor alquiladaPor) {
         conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "insert into alquiladapor (idusuario, idvivienda) values (?, ?)";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setLong(1, alquiladaPor.getInquilino().getId());
            pa.setLong(2, alquiladaPor.getVivienda().getId());

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
    public void actualizarAlquiler(Alquiler alquiler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
