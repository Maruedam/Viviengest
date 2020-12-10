/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;
 
import es.viviengest.beans.Usuario;
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
public class UsuariosDAO implements IUsuariosDAO {

    Connection conexion;
    DataSource datasource;
    String cds = "";

    @Override
    public List<Usuario> getUsuarios() {
        conexion = ConnectionFactory.getConexionMYSQL();
        List<Usuario> lUsuarios = new ArrayList<Usuario>();
        Usuario usuario = null;
        String consulta = "select * from usuarios"; 

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                usuario = new Usuario();

                usuario.setId(resultado.getLong("id"));
                usuario.setNombre(resultado.getString("nombre")); 
                usuario.setApellidos(resultado.getString("apellidos"));
                usuario.setDni(resultado.getString("nif"));
                usuario.setTelefono(resultado.getInt("telefono"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setPasswd(resultado.getString("password"));
                usuario.setUltimoacceso(resultado.getDate("ultimoacceso"));
                usuario.setRoll(resultado.getString("roll"));
                lUsuarios.add(usuario);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return lUsuarios;
    }

     public List<Usuario> getUsuariosDelete() {
        conexion = ConnectionFactory.getConexionMYSQL();
        List<Usuario> lUsuarios = new ArrayList<Usuario>();
        Usuario usuario = null;
        String consulta = "select * from usuarios where roll='PROPIETARIO' OR roll='INQUILINO'"; 

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                usuario = new Usuario();

                usuario.setId(resultado.getLong("id"));
                usuario.setNombre(resultado.getString("nombre")); 
                usuario.setApellidos(resultado.getString("apellidos"));
                usuario.setDni(resultado.getString("nif"));
                usuario.setTelefono(resultado.getInt("telefono"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setPasswd(resultado.getString("password"));
                usuario.setUltimoacceso(resultado.getDate("ultimoacceso"));
                usuario.setRoll(resultado.getString("roll"));
                lUsuarios.add(usuario);
            }
            resultado.close();
            conexion.commit(); 
            conexion.close();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return lUsuarios;
    }
     
    @Override
    public Usuario getUsuario(Long id) {
        conexion = ConnectionFactory.getConexionMYSQL();
        Usuario usuario = null;
        String consulta = "select * from usuarios where id='" + id + "'";

        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                usuario = new Usuario();
                usuario.setId(resultado.getLong("id"));
                usuario.setNombre(resultado.getString("nombre")); 
                usuario.setApellidos(resultado.getString("apellidos"));
                usuario.setDni(resultado.getString("nif"));
                usuario.setTelefono(resultado.getInt("telefono"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setPasswd(resultado.getString("password"));
                usuario.setUltimoacceso(resultado.getDate("ultimoacceso"));
                usuario.setRoll(resultado.getString("roll"));
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return usuario;
    }

    @Override
    public void deleteUsuario(Long id) {
        conexion = ConnectionFactory.getConexionMYSQL();

        String query1 = "delete from usuarios  WHERE id in(?)";
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
    public void insertarUsuario(Usuario p) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "insert into usuarios (nombre,apellidos,nif,telefono, email, password, ultimoacceso,roll) values (?, ?, ?, ?, ?, ?,  ?, ?)";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setString(1, p.getNombre()); 
            pa.setString(2, p.getApellidos());
            pa.setString(3, p.getDni());
            pa.setLong(4, p.getTelefono());
            pa.setString(5, p.getEmail());
            pa.setString(6, p.getPasswd());
            pa.setDate(7, p.getUltimoacceso());
            pa.setString(8, p.getRoll());
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
    public void actualizarUsuario(Usuario u) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "UPDATE usuarios SET nombre=? ,apellidos=?,nif=?,telefono=?, email=?, password=?, ultimoacceso=?,roll=? WHERE id=?";
        PreparedStatement p = null;
        try {
            conexion.setAutoCommit(false);
            p = conexion.prepareStatement(query1);
            p.setString(1, u.getNombre()); 
            p.setString(2, u.getApellidos());
            p.setString(3, u.getDni());
            p.setLong(4, u.getTelefono());
            p.setString(5, u.getEmail());
            p.setString(6, u.getPasswd());
            p.setDate(7, u.getUltimoacceso());
            p.setString(8, u.getRoll());
            p.setLong(9, u.getId());
            p.executeUpdate();

            conexion.commit(); 
            conexion.close();
            System.out.println("Se ha modificado correctamente en la bd");
        } catch (SQLException ex) {
            System.out.println("error al insertar ");
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
    }

     public boolean buscaUserMail(String email) {
        conexion = ConnectionFactory.getConexionMYSQL();
        boolean esta = false;
        String consulta = "select * from usuarios where email=?";
        try {
            conexion.setAutoCommit(false);
            PreparedStatement preparada = conexion.prepareStatement(consulta);

            preparada.setString(1, email);
            ResultSet resultado = preparada.executeQuery();
            esta = (resultado.next());
            conexion.commit();
            
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return esta;
     }
     
     public boolean buscaUserdni(String dni) {
        conexion = ConnectionFactory.getConexionMYSQL();
        boolean esta = false;
        String consulta = "select * from usuarios where nif=?";
        try {
            conexion.setAutoCommit(false);
            PreparedStatement preparada = conexion.prepareStatement(consulta);

            preparada.setString(1, dni);
            ResultSet resultado = preparada.executeQuery();
            esta = (resultado.next());
            conexion.commit();
            
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return esta;
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
