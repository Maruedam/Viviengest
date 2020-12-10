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
@DiscriminatorValue("A")
@Table(name = "administrador")
public class Administrador extends Usuario {

    @Column(name = "mododios")
    private Boolean mododios;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private Usuario usuario;

    public Administrador(Boolean mododios, Usuario usuario) {
        this.mododios = mododios;
        this.usuario = usuario;
    }

    public Administrador() {
    }

    public Boolean getMododios() {
        return mododios;
    }

    public void setMododios(Boolean mododios) {
        this.mododios = mododios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
