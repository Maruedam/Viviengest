/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.viviengest.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author dwigh
 */
@Entity
@Table(name = "viviendas")
public class Vivienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "c_Postal")
    private Integer cPostal;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "n_habitaciones")
    private Integer nHabitaciones;
    @Column(name = "ascensor")
    private Boolean ascensor;
    @Column(name = "calefaccion")
    private Boolean calefaccion;
    @Column(name = "aire_acondicionado")
    private Boolean aireAcondicionado;
    @Column(name = "amueblado")
    private Boolean amueblado;
    @Column(name = "tipo_de_suelo")
    private String tipoDeSuelo;
    @Column(name = "n_banios")
    private Integer nBanios;
    @Column(name = "metros_Cuadrados")
    private Integer metrosCuadrados;
    @Column(name = "minimo_meses")
    private Integer minimoMeses;
    @Column(name = "importe_mensual")
    private Double importeMensual;
    @Column(name = "importe_finaza")
    private Double importeFinaza;
    @Column(name = "anio_contruccion")
    private Integer anioContruccion;
    @Column(name = "pagado_mes")
    private Boolean pagadoMes;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "comunidad")
    private Double comunidad;
    @OneToOne
    @JoinColumn(name = "idPropietario", nullable = false)
    private Propietario propietario;

    public Vivienda(Long id, String direccion, Integer cPostal, String localidad, String provincia, Integer nHabitaciones, Boolean ascensor, Boolean calefaccion, Boolean aireAcondicionado, Boolean amueblado, String tipoDeSuelo, Integer nBanios, Integer metrosCuadrados, Integer minimoMeses, Double importeMensual, Double importeFinaza, Integer anioContruccion, Boolean pagadoMes, Boolean estado, Double comunidad, Propietario propietario) {
        this.id = id;
        this.direccion = direccion;
        this.cPostal = cPostal;
        this.localidad = localidad;
        this.provincia = provincia;
        this.nHabitaciones = nHabitaciones;
        this.ascensor = ascensor;
        this.calefaccion = calefaccion;
        this.aireAcondicionado = aireAcondicionado;
        this.amueblado = amueblado;
        this.tipoDeSuelo = tipoDeSuelo;
        this.nBanios = nBanios;
        this.metrosCuadrados = metrosCuadrados;
        this.minimoMeses = minimoMeses;
        this.importeMensual = importeMensual;
        this.importeFinaza = importeFinaza;
        this.anioContruccion = anioContruccion;
        this.pagadoMes = pagadoMes;
        this.estado = estado;
        this.comunidad = comunidad;
        this.propietario = propietario;
    }

    public Vivienda() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getcPostal() {
        return cPostal;
    }

    public void setcPostal(Integer cPostal) {
        this.cPostal = cPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getnHabitaciones() {
        return nHabitaciones;
    }

    public void setnHabitaciones(Integer nHabitaciones) {
        this.nHabitaciones = nHabitaciones;
    }

    public Boolean getAscensor() {
        return ascensor;
    }

    public void setAscensor(Boolean ascensor) {
        this.ascensor = ascensor;
    }

    public Boolean getCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(Boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getAmueblado() {
        return amueblado;
    }

    public void setAmueblado(Boolean amueblado) {
        this.amueblado = amueblado;
    }

    public String getTipoDeSuelo() {
        return tipoDeSuelo;
    }

    public void setTipoDeSuelo(String tipoDeSuelo) {
        this.tipoDeSuelo = tipoDeSuelo;
    }

    public Integer getnBanios() {
        return nBanios;
    }

    public void setnBanios(Integer nBanios) {
        this.nBanios = nBanios;
    }

    public Integer getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(Integer metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public Integer getMinimoMeses() {
        return minimoMeses;
    }

    public void setMinimoMeses(Integer minimoMeses) {
        this.minimoMeses = minimoMeses;
    }

    public Double getImporteMensual() {
        return importeMensual;
    }

    public void setImporteMensual(Double importeMensual) {
        this.importeMensual = importeMensual;
    }

    public Double getImporteFinaza() {
        return importeFinaza;
    }

    public void setImporteFinaza(Double importeFinaza) {
        this.importeFinaza = importeFinaza;
    }

    public Integer getAnioContruccion() {
        return anioContruccion;
    }

    public void setAnioContruccion(Integer anioContruccion) {
        this.anioContruccion = anioContruccion;
    }

    public Boolean getPagadoMes() {
        return pagadoMes;
    }

    public void setPagadoMes(Boolean pagadoMes) {
        this.pagadoMes = pagadoMes;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Double getComunidad() {
        return comunidad;
    }

    public void setComunidad(Double comunidad) {
        this.comunidad = comunidad;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    
}