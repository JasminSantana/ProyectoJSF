/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Jefe;

/**
 *
 * @author USUARIO
 */
public class JefeDAO extends DAO<Jefe> {
        public JefeDAO(){
     super(new Jefe());
 } 
      public Jefe getOneById(Jefe jefe)
         throws HibernateException{
     return super.getOneById(jefe.getIdJefe());
 }
  
}
