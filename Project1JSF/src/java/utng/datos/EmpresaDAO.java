/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Empresa;

/**
 *
 * @author USUARIO
 */
public class EmpresaDAO extends DAO<Empresa>{
     public EmpresaDAO(){
     super(new Empresa());
 } 
      public Empresa getOneById(Empresa empresa)
         throws HibernateException{
     return super.getOneById(empresa.getIdEmpresa());
 }
     
    
      
     
}
