/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author dwigh
 */
@Entity
@DiscriminatorValue("P")
@Table(name = "propietarios")
public class Propietario extends Usuario {
    @Column(name = "numecuenta")
    private String numecuenta;
    @Column(name = "direccion_postal")
    private String direccionpostal; 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    public Usuario usuario;

    public Propietario(String numecuenta, String direccionpostal, Usuario usuario) {
        this.numecuenta = numecuenta;
        this.direccionpostal = direccionpostal;
        this.usuario = usuario;
    }     

    public Propietario() {
    }

    public String getNumecuenta() {
        return numecuenta;
    }

    public void setNumecuenta(String numecuenta) {
        this.numecuenta = numecuenta;
    } 
    
    public String getDireccionpostal() {
        return direccionpostal;
    }

    public void setDireccionpostal(String direccionpostal) {
        this.direccionpostal = direccionpostal;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
