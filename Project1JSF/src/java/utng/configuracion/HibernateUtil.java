/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.configuracion;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author USUARIO
 */
public class HibernateUtil {
    //Atributo para almcenar la sesión en bae de la configuracio
    private static final SessionFactory sessionFactory;
    private static Session session;
        static{
            try{
                sessionFactory=new AnnotationConfiguration().configure("/utng/configuracion/hibernate.cfg.xml").buildSessionFactory();
                session=sessionFactory.openSession();
            }catch(HibernateException e){
                throw new ExceptionInInitializerError("Ocurrio un error al inicializar Session Factory" +e);
                
            }//catch
        }
    public static Session getSession(){
        return session;
    }

    @Override
    protected void finalize() throws Throwable {
      session.close();
      session=null;
    }
    public static void main(String[] args) {
        new HibernateUtil().getSession();
    }
 
}
