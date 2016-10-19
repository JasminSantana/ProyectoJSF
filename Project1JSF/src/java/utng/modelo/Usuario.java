/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name="usuario")
public class Usuario implements Serializable{
     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id_usuario")
     private Long idUsuario;
    @Column(name="nombre_usuario", length = 10)
    private String nombreUsuario;
    @Column(length = 40)
    private String contrasenia;
    @ManyToOne//(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_rol")
    private Rol rol;

    public Usuario(Long idUsuario, String nombreUsuario, String contrasenia, Rol rol) {
        super();
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public Usuario() {
       this.idUsuario=0L;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

 

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
 
    
}
