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
import javax.persistence.Table;



/**
 *
 * @author USUARIO
 */
@Entity
@Table(name="modulo")
public class Modulo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_modulo")
    private Long idModulo;
    @Column(name="nombre", length = 100)
    private String nombre;
    @Column(length = 150)
    private String ruta;
    public Modulo(Long idModulo,String nombre, String ruta){
        super();
        this.idModulo=idModulo;
        this.nombre=nombre;
        this.ruta=ruta;
    }
    public Modulo(){
        this(0L,"","");
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
}
