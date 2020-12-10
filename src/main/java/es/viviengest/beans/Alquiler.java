/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.beans;

import java.io.Serializable;
import java.util.Date; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author dwigh
 */
@Entity
@Table(name="alquileres")
public class Alquiler implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name="fecha_entrada")
    private Date fecha_entrada;
    @Column(name="fecha_salida")
    private Date fecha_salida;
    
    private Propietario propietario;
    private Inquilino inquilino;
    private Vivienda vivienda;
    
    /*
  `idPropietario` smallint(6),
  `idInquilino` smallint(6),
  `idvivienda` smallint(6),
    */

    public Alquiler(Long id, Date fecha_entrada, Date fecha_salida, Propietario propietario, Inquilino inquilino, Vivienda vivienda) {
        this.id = id;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.propietario = propietario;
        this.inquilino = inquilino;
        this.vivienda = vivienda;
    }

    public Alquiler() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
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
