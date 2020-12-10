/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;

import es.viviengest.beans.Foto;
import es.viviengest.beans.Vivienda;
import java.util.List;

/**
 *
 * @author dwigh
 */
public interface IViviendasDAO {
    
    public List<Vivienda> getViviendasDisponibles() ;

    public List<Vivienda> getViviendas();

    public List<Vivienda> getVivienda(Long id);

    public void deleteVivienda(Long id);

    public void insertarVivienda(Vivienda v);

    public void actualizarVivienda(Vivienda v);

    public Foto getFotoVivienda(Long idVivienda);

    public Vivienda getViviendaId(Long id);

    public void insertarFotoVivienda(Foto foto);
    
    public List<Foto> getFotos();

     public Boolean deleteFotoIdVivienda(Long id);
             
    public void closeConnection();

}
