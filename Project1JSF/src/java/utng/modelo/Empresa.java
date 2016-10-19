/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
   @Entity
@Table(name="empresa")
public class Empresa implements Serializable{

     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id_empresa")
     private Long idEmpresa;
    @Column(name="nombre_empresa", length = 15)
    private String nombreEmpresa;
    @Column(length = 40)
    private String colonia;
   @Column(length = 25)
    private String telefono;
     @Column(length = 20)
    private String rfc;
   
    @ManyToOne//(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_jefe")
    private Jefe jefe;
     @ManyToOne
    @JoinColumn(name="id_rol")
    private Rol rol;

    public Empresa(Long idEmpresa, String nombreEmpresa, String colonia, String telefono, String rfc, Jefe jefe, Rol rol) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.colonia = colonia;
        this.telefono = telefono;
        this.rfc = rfc;
        this.jefe = jefe;
        this.rol = rol;
    }

    public Empresa() {
        this.idEmpresa=0L;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Jefe getJefe() {
        return jefe;
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
    
    
    
}
