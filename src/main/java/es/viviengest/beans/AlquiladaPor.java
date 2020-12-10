/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.beans;

/**
 *
 * @author dwigh
 */
public class AlquiladaPor {

    private Inquilino inquilino;
    private Vivienda vivienda;

    public AlquiladaPor(Inquilino inquilino, Vivienda vivienda) {
        this.inquilino = inquilino;
        this.vivienda = vivienda;
    }

    public AlquiladaPor() {
    }
    
    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    
}
