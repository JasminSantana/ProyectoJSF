/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import utng.modelo.Usuario;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@ViewScoped
public class PlantillaBean implements Serializable{
    public void checkLogin(){
        try{
            FacesContext context=FacesContext.getCurrentInstance();
            Usuario usuario=(Usuario)context.getExternalContext().getSessionMap().get("usuario");
            if(usuario==null){
                context.getExternalContext().redirect("login.xhtml");
            }
        }catch(Exception e){
           // e.printStackTrace();
        }
    }
}
