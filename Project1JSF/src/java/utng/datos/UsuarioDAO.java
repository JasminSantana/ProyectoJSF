/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public class UsuarioDAO extends DAO<Usuario>{
 public UsuarioDAO(){
     super(new Usuario());
 }   
 public Usuario getOneById(Usuario usuario)
         throws HibernateException{
     return super.getOneById(usuario.getIdUsuario());
 }
 public Usuario login(Usuario usuario){
     List<String> parametros=new ArrayList<String>();
     List<Object>valores=new ArrayList<Object>();
     parametros.add("nombreUsuario");
     parametros.add("contrasenia");
     valores.add(usuario.getNombreUsuario());
     valores.add(usuario.getContrasenia());
     usuario=query("SELECT u FROM "+modelo.getClass().getName()
             +" u WHERE u.nombreUsuario=:nombreUsuario "
     +"AND u.contrasenia=:contrasenia",parametros,valores);
     return usuario;
 }
}
