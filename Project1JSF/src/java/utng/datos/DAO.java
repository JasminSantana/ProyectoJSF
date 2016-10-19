/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utng.configuracion.HibernateUtil;

/**
 *
 * @author USUARIO
 */
public abstract class DAO<T> {

    protected Session session;
    protected T modelo;

    public DAO(T modelo) {
        session = HibernateUtil.getSession();
        this.modelo = modelo;
    }

    public Long insert(T modelo)
            throws HibernateException {
        long id = 0;
        Transaction tx = session.beginTransaction();
        try {
            Serializable result = session.save(modelo);
            id = (Long) result;
            tx.commit();
            session.clear();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        }//catch
        return id;
    }

    public void update(T modelo)
            throws HibernateException {
        Transaction tx = session.beginTransaction();
        try {
            session.merge(modelo);
            tx.commit();
            session.clear();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        }//catch
    }

    public void delete(T modelo)
            throws HibernateException {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(modelo);
            tx.commit();
            session.clear();
        } catch (HibernateException e) {
            tx.rollback();
            session.clear();
            throw e;
        }//     
    }

    public List<T> getAll() throws HibernateException {
        String entityName = modelo.getClass().getName();
        List<T> list = new ArrayList<T>();
        try {
            list = session.createQuery("from " + entityName).list();
            session.clear();
        } catch (Exception e) {
            session.clear();
            throw new HibernateException("Error al consultar todos: " + e);
        }
        return list;
    }
    protected T getOneById(Serializable id)
            throws HibernateException{
        T object=null;
        object=(T)session.get(modelo.getClass(),Long.valueOf(id.toString()));
        session.clear();
        return  object;
    }
protected T query(String sql, List<String> paramNames,List<Object> paramValues){
    Query query=session.createQuery(sql);
    for(int i=0;i<paramNames.size();i++){
        query.setParameter(paramNames.get(i),paramValues.get(i));
    }
    List<T> list=query.list();
    if(list.size()>0){
        return list.get(0);
    }else{
        return null;
    }
}
protected List<T> queryList(String sql, Class<?> entity, 
        List<String> paramNames, List<Object> paramValues){
    SQLQuery query=session.createSQLQuery(sql);
    query.addEntity(entity);
    for(int i=0;i<paramNames.size();i++){
        query.setParameter(paramNames.get(i),paramValues.get(i));
            }
    List<T> list=query.list();
    if(list.size()>0){
        return list;
    }else{
        return  null;
    }
}

}
