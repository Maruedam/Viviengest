/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;
 
import es.viviengest.beans.Propietario;
import es.viviengest.beans.Vivienda;
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
public class ViviendasDAO implements IViviendasDAO {
    
    Connection conexion;
    DataSource datasource;
    String cds = "";
     
    @Override
    public List<Vivienda> getViviendasDisponibles() {
        conexion = ConnectionFactory.getConexionMYSQL();
        List<Vivienda> lViviendas = new ArrayList<Vivienda>();
        Vivienda vivienda = null;
        String consulta = "select * from viviendas  where estado='false' ";
        Propietario p = new Propietario();
        PropietariosDAO pdao = new PropietariosDAO();
        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                vivienda = new Vivienda();
                vivienda.setId(resultado.getLong("id"));
                vivienda.setDireccion(resultado.getString("direccion"));
                vivienda.setcPostal(resultado.getInt("c_postal"));
                vivienda.setLocalidad(resultado.getString("localidad"));
                vivienda.setProvincia(resultado.getString("provincia"));
                vivienda.setnHabitaciones(resultado.getInt("n_habitaciones"));
                vivienda.setAscensor(resultado.getBoolean("ascensor"));
                vivienda.setCalefaccion(resultado.getBoolean("calefaccion"));
                vivienda.setAireAcondicionado(resultado.getBoolean("aire_acondicionado"));
                vivienda.setAmueblado(resultado.getBoolean("amueblado"));
                vivienda.setTipoDeSuelo(resultado.getString("tipo_de_suelo"));
                vivienda.setnBanios(resultado.getInt("n_banios"));
                vivienda.setMetrosCuadrados(resultado.getInt("metros_cuadrados"));
                vivienda.setMinimoMeses(resultado.getInt("minimo_meses"));
                vivienda.setImporteMensual(resultado.getDouble("importe_mensual"));
                vivienda.setImporteFinaza(resultado.getDouble("importe_finaza"));
                vivienda.setEstado(resultado.getBoolean("estado"));
                vivienda.setAnioContruccion(resultado.getInt("anio_contruccion"));
                vivienda.setPagadoMes(resultado.getBoolean("pagado_mes"));
                vivienda.setComunidad(resultado.getDouble("comunidad"));
                vivienda.setFoto(resultado.getString("foto"));
                p = pdao.getPropietario(resultado.getLong("idPropietario"));
                vivienda.setPropietario(p);
                
                lViviendas.add(vivienda);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return lViviendas;
    }
    
    @Override
    public List<Vivienda> getViviendas() {
        conexion = ConnectionFactory.getConexionMYSQL();
        List<Vivienda> lViviendas = new ArrayList<Vivienda>();
        Vivienda vivienda = null;
        String consulta = "select * from viviendas";
        Propietario p = new Propietario();
        PropietariosDAO pdao = new PropietariosDAO();
        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                vivienda = new Vivienda();
                vivienda.setId(resultado.getLong("id"));
                vivienda.setDireccion(resultado.getString("direccion"));
                vivienda.setcPostal(resultado.getInt("c_postal"));
                vivienda.setLocalidad(resultado.getString("localidad"));
                vivienda.setProvincia(resultado.getString("provincia"));
                vivienda.setnHabitaciones(resultado.getInt("n_habitaciones"));
                vivienda.setAscensor(resultado.getBoolean("ascensor"));
                vivienda.setCalefaccion(resultado.getBoolean("calefaccion"));
                vivienda.setAireAcondicionado(resultado.getBoolean("aire_acondicionado"));
                vivienda.setAmueblado(resultado.getBoolean("amueblado"));
                vivienda.setTipoDeSuelo(resultado.getString("tipo_de_suelo"));
                vivienda.setnBanios(resultado.getInt("n_banios"));
                vivienda.setMetrosCuadrados(resultado.getInt("metros_cuadrados"));
                vivienda.setMinimoMeses(resultado.getInt("minimo_meses"));
                vivienda.setImporteMensual(resultado.getDouble("importe_mensual"));
                vivienda.setImporteFinaza(resultado.getDouble("importe_finaza"));
                vivienda.setEstado(resultado.getBoolean("estado"));
                vivienda.setAnioContruccion(resultado.getInt("anio_contruccion"));
                vivienda.setPagadoMes(resultado.getBoolean("pagado_mes"));
                vivienda.setComunidad(resultado.getDouble("comunidad"));
                vivienda.setFoto(resultado.getString("foto"));
                p = pdao.getPropietario(resultado.getLong("idPropietario"));
                vivienda.setPropietario(p);
                
                lViviendas.add(vivienda);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return lViviendas;
    }
    
    @Override
    public List<Vivienda> getVivienda(Long idPropietario) {
        conexion = ConnectionFactory.getConexionMYSQL();
        Vivienda vivienda = null;
        List<Vivienda> viviendas = new ArrayList<Vivienda>();
        String consulta = "select * from viviendas where idPropietario='" + idPropietario + "'";
        Propietario p = new Propietario();
        PropietariosDAO pdao = new PropietariosDAO();
        
        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                vivienda = new Vivienda();
                vivienda.setId(resultado.getLong("id"));
                vivienda.setDireccion(resultado.getString("direccion"));
                vivienda.setcPostal(resultado.getInt("c_postal"));
                vivienda.setLocalidad(resultado.getString("localidad"));
                vivienda.setProvincia(resultado.getString("provincia"));
                vivienda.setnHabitaciones(resultado.getInt("n_habitaciones"));
                vivienda.setAscensor(resultado.getBoolean("ascensor"));
                vivienda.setCalefaccion(resultado.getBoolean("calefaccion"));
                vivienda.setAireAcondicionado(resultado.getBoolean("aire_acondicionado"));
                vivienda.setAmueblado(resultado.getBoolean("amueblado"));
                vivienda.setTipoDeSuelo(resultado.getString("tipo_de_suelo"));
                vivienda.setnBanios(resultado.getInt("n_banios"));
                vivienda.setMetrosCuadrados(resultado.getInt("metros_cuadrados"));
                vivienda.setMinimoMeses(resultado.getInt("minimo_meses"));
                vivienda.setImporteMensual(resultado.getDouble("importe_mensual"));
                vivienda.setImporteFinaza(resultado.getDouble("importe_finaza"));
                vivienda.setEstado(resultado.getBoolean("estado"));
                vivienda.setAnioContruccion(resultado.getInt("anio_contruccion"));
                vivienda.setPagadoMes(resultado.getBoolean("pagado_mes"));
                vivienda.setComunidad(resultado.getDouble("comunidad"));
                vivienda.setFoto(resultado.getString("foto"));
                p = pdao.getPropietario(resultado.getLong("idPropietario"));
                vivienda.setPropietario(p); 
                viviendas.add(vivienda);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        return viviendas;
    }
    
    @Override
    public Vivienda getViviendaId(Long id) {
        conexion = ConnectionFactory.getConexionMYSQL();
        Vivienda vivienda = null;
        String consulta = "select * from viviendas where id='" + id + "'";
        Propietario p = new Propietario();
        PropietariosDAO pdao = new PropietariosDAO();
        
        try {
            conexion.setAutoCommit(false);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            while (resultado.next()) {//si resultado que es lo obtenidod e la base de datos tiene usuarios entra en el while para rellenar la lista
                vivienda = new Vivienda();
                vivienda.setId(id);
                vivienda.setDireccion(resultado.getString("direccion"));
                vivienda.setcPostal(resultado.getInt("c_postal"));
                vivienda.setLocalidad(resultado.getString("localidad"));
                vivienda.setProvincia(resultado.getString("provincia"));
                vivienda.setnHabitaciones(resultado.getInt("n_habitaciones"));
                vivienda.setAscensor(resultado.getBoolean("ascensor"));
                vivienda.setCalefaccion(resultado.getBoolean("calefaccion"));
                vivienda.setAireAcondicionado(resultado.getBoolean("aire_acondicionado"));
                vivienda.setAmueblado(resultado.getBoolean("amueblado"));
                vivienda.setTipoDeSuelo(resultado.getString("tipo_de_suelo"));
                vivienda.setnBanios(resultado.getInt("n_banios"));
                vivienda.setMetrosCuadrados(resultado.getInt("metros_cuadrados"));
                vivienda.setMinimoMeses(resultado.getInt("minimo_meses"));
                vivienda.setImporteMensual(resultado.getDouble("importe_mensual"));
                vivienda.setImporteFinaza(resultado.getDouble("importe_finaza"));
                vivienda.setEstado(resultado.getBoolean("estado"));
                vivienda.setAnioContruccion(resultado.getInt("anio_contruccion"));
                vivienda.setPagadoMes(resultado.getBoolean("pagado_mes"));
                vivienda.setComunidad(resultado.getDouble("comunidad"));
                vivienda.setFoto(resultado.getString("foto"));
                p = pdao.getPropietario(resultado.getLong("idPropietario"));
                vivienda.setPropietario(p);
            }
            resultado.close();
            conexion.commit();
        } catch (SQLException e) {
            System.out.println("error al conectar");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConexion(conexion);
        }
        
        return vivienda;
    }
    
    @Override
    public void deleteVivienda(Long id) {
        conexion = ConnectionFactory.getConexionMYSQL();
        
        String query1 = "delete from viviendas  WHERE id in(?)";
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
    public void insertarVivienda(Vivienda v) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "insert into viviendas (direccion, c_postal,localidad,provincia,n_habitaciones,ascensor,calefaccion,aire_acondicionado, amueblado,tipo_de_suelo,n_banios,metros_cuadrados,minimo_meses,importe_mensual,importe_finaza,estado,anio_contruccion,pagado_mes,comunidad,foto,idPropietario) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setString(1, v.getDireccion());
            pa.setInt(2, v.getcPostal());
            pa.setString(3, v.getLocalidad());
            pa.setString(4, v.getProvincia());
            pa.setInt(5, v.getnHabitaciones());
            pa.setBoolean(6, v.getAscensor());
            pa.setBoolean(7, v.getCalefaccion());
            pa.setBoolean(8, v.getAireAcondicionado());
            pa.setBoolean(9, v.getAmueblado());
            pa.setString(10, v.getTipoDeSuelo());
            pa.setInt(11, v.getnBanios());
            pa.setInt(12, v.getMetrosCuadrados());
            pa.setInt(13, v.getMinimoMeses());
            pa.setDouble(14, v.getImporteMensual());
            pa.setDouble(15, v.getImporteFinaza());
            pa.setBoolean(16, v.getEstado());
            pa.setInt(17, v.getAnioContruccion());
            pa.setBoolean(18, v.getPagadoMes());
            pa.setDouble(19, v.getComunidad());
            pa.setString(20, v.getFoto());
            pa.setLong(21, v.getPropietario().getId());
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
    public void actualizarVivienda(Vivienda v) {
        conexion = ConnectionFactory.getConexionMYSQL();
        String query1 = "UPDATE viviendas SET direccion=?, c_postal=?,localidad=?,provincia=?,n_habitaciones=?,ascensor=?,calefaccion=?,aire_acondicionado=?, amueblado=?,tipo_de_suelo=?,n_banios=?,metros_cuadrados=?,minimo_meses=?,importe_mensual=?,importe_finaza=?,estado=?,anio_contruccion=?,pagado_mes=?,comunidad=?,foto=?,idPropietario=? WHERE id=?";
        PreparedStatement pa = null;
        try {
            conexion.setAutoCommit(false);
            pa = conexion.prepareStatement(query1);
            pa.setString(1, v.getDireccion());
            pa.setInt(2, v.getcPostal());
            pa.setString(3, v.getLocalidad());
            pa.setString(4, v.getProvincia());
            pa.setInt(5, v.getnHabitaciones());
            pa.setBoolean(6, v.getAscensor());
            pa.setBoolean(7, v.getCalefaccion());
            pa.setBoolean(8, v.getAireAcondicionado());
            pa.setBoolean(9, v.getAmueblado());
            pa.setString(10, v.getTipoDeSuelo());
            pa.setInt(11, v.getnBanios());
            pa.setInt(12, v.getMetrosCuadrados());
            pa.setInt(13, v.getMinimoMeses());
            pa.setDouble(14, v.getImporteMensual());
            pa.setDouble(15, v.getImporteFinaza());
            pa.setBoolean(16, v.getEstado());
            pa.setInt(17, v.getAnioContruccion());
            pa.setBoolean(18, v.getPagadoMes());
            pa.setDouble(19, v.getComunidad());
            pa.setString(20, v.getFoto());
            pa.setLong(21, v.getPropietario().getId());
            pa.setLong(22, v.getId());
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
