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
import utng.datos.RolDAO;
import utng.modelo.Rol;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@SessionScoped
public class RolBean implements Serializable{
    private List<Rol> roles;
    private Rol rol;

    public RolBean() {
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    public String listar(){
        RolDAO dao=new RolDAO();
        try{
            roles=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Roles";
    }
    public String eliminar(){
         RolDAO dao=new RolDAO();
        try{
            dao.delete(rol);
            roles=dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Eliminar";
    }
    public String iniciar(){
        rol=new Rol();
        return "Iniciar";
    }
    public String guardar(){
    RolDAO dao=new RolDAO();
    try{
        if(rol.getIdRol()!=0){
            dao.update(rol);
        }else{
            dao.insert(rol);
        }
        roles=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
    public String cancelar(){
    return "Cancelar";
    }
public String editar(Rol rol){
    this.rol=rol;
    return "Editar";
}
    
}
