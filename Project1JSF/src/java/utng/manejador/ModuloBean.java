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
import utng.datos.ModuloDAO;
import utng.modelo.Modulo;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@SessionScoped
public class ModuloBean implements Serializable {
    private List<Modulo> modulos;
    private Modulo modulo;
    public ModuloBean(){}
    public Modulo getModulo(){
        return modulo;
    }
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

public String listar(){
    ModuloDAO dao=new ModuloDAO();
    try{
    modulos=dao.getAll();
}catch(Exception e)
{
    e.printStackTrace();
}
    return "Modulos";
}
public String eliminar(){
    ModuloDAO dao=new ModuloDAO();
    try{
        dao.delete(modulo);
        modulos=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return  "Eliminar";
}
public String iniciar(){
    modulo =new Modulo();
    return "Iniciar";
}
public String guardar(){
    ModuloDAO dao=new ModuloDAO();
    try{
        if(modulo.getIdModulo()!=0){
            dao.update(modulo);
        }else{
            dao.insert(modulo);
        }
        modulos=dao.getAll();
    }catch(Exception e){
        e.printStackTrace();
    }
    return "Guardar";
}
public String cancelar(){
    return "Cancelar";
    }
public String editar(Modulo modulo){
    this.modulo=modulo;
    return "Editar";
}
}
