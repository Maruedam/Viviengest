/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.DAO;

import es.viviengest.beans.Inquilino; 
import java.util.List;

/**
 *
 * @author dwigh
 */
public interface IInquilinosDAO {
    public List<Inquilino> getInquilinos();

    public Inquilino getInquilino(Long id);

    public void deleteInquilino(Long id);

    public void insertarInquilino(Inquilino i);

    public void actualizarInquilino(Inquilino i);

    public void closeConnection();
    
}
