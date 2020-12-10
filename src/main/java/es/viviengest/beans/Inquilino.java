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
@Table(name = "inquilinos")
public class Inquilino extends Usuario {
    @Column(name = "ultima_nomina")
    private Double ultima_nomina; 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    public Usuario usuario;

    public Inquilino(Usuario usuario,Double ultima_nomina) {
        this.usuario = usuario;
        this.ultima_nomina=ultima_nomina;
    }

    public Inquilino() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getultima_nomina() {
        return ultima_nomina;
    }

    public void setultima_nomina(Double ultima_nomina) {
        this.ultima_nomina = ultima_nomina;
    }
    
    
}
