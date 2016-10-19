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
import javax.faces.context.FacesContext;
import utng.datos.RolDAO;
import utng.datos.UsuarioDAO;
import utng.modelo.Rol;
import utng.modelo.Usuario;

/**
 *
 * @author USUARIO
 */
@ManagedBean(name="usuarioBean") @SessionScoped
public class UsuarioBean implements Serializable{
    private List<Usuario> usuarios;
    private Usuario usuario;
    private List<Rol>roles;

    public UsuarioBean() {
     usuario=new Usuario();
     usuario.setRol(new Rol());
    }
     public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
   
    public Usuario getUsuario() {
        return usuario;
    }
 public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

   
public String listar(){
    UsuarioDAO dao=new UsuarioDAO();
    try{
        usuarios=dao.getAll();
            }catch(Exception e ){
        e.printStackTrace();
    }
    return  "Usuarios";
}
public String eliminar(){
    UsuarioDAO dao=new UsuarioDAO();
    try{
        dao.delete(usuario);
        usuarios=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Eliminar";
}
 public String iniciar(){
        usuario=new Usuario();
        usuario.setRol(new Rol());
        try{
            roles=new RolDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }return "Iniciar";
    }
    public String guardar(){
   UsuarioDAO dao=new UsuarioDAO();
    try{
        if(usuario.getIdUsuario()!=0){
            dao.update(usuario);
        }else{
            dao.insert(usuario);
        }
        usuarios=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
    public String cancelar(){
    return "Cancelar";
    }
public String editar(Usuario usuario){
    this.usuario=usuario;
    try{
        roles=new RolDAO().getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Editar";
}
public String login(){
    usuario=new UsuarioDAO().login(this.usuario);
    if(usuario!=null){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",usuario);
        return "Correcto";
    }else{
        usuario=new Usuario();
        return "Incorrecto";
    }
}

}
