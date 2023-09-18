
package sys.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.LibroDAO;
import sys.modelo.Libro;
import sys.util.HibernateUtil;

public class LibroDAOImpl implements LibroDAO{

    @Override
    public List<Libro> select() {
        List<Libro> libros=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction trans=session.beginTransaction();
        String hql= "FROM Libro";
        try{
            libros=session.createQuery(hql).list();
            trans.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            trans.rollback();
        } finally {
            session.close();
        }
        
        return libros;
    }

    @Override
    public void insert(Libro libro) {
        Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(libro);
            session.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void update(Libro libro) {
        Session session=null;
        try{
           session=HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.update(libro);
           session.getTransaction().commit();
        } catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Libro libro) {
        Session session=null;
        try{
           session=HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.delete(libro);
           session.getTransaction().commit();
        } catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
    
}
