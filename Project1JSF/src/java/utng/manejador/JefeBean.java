/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.JefeDAO;
import utng.modelo.Jefe;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@SessionScoped
public class JefeBean implements Serializable{
    private List<Jefe> jefes;
    private Jefe jefe;

    public JefeBean() {
    }

    public List<Jefe> getJefes() {
        return jefes;
    }

    public void setJefes(List<Jefe> jefes) {
        this.jefes = jefes;
    }

    public Jefe getJefe() {
        return jefe;
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe;
    }

     public String listar(){
           JefeDAO dao=new JefeDAO();
        try{
            jefes=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Jefes";
    }
    public String eliminar(){
     JefeDAO dao=new  JefeDAO();
        try{
            dao.delete(jefe);
            jefes=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Eliminar";
    }
    
    public String iniciar(){
        jefe=new Jefe();
        return "Iniciar";
    }
    public String guardar(){
    JefeDAO dao=new JefeDAO();
    try{
        if(jefe.getIdJefe()!=0){
            dao.update(jefe);
        }else{
            dao.insert(jefe);
        }
        jefes=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
    public String cancelar(){
    return "Cancelar";
    }
public String editar(Jefe jefe){
    this.jefe=jefe;
    return "Editar";
}
 
    
}
