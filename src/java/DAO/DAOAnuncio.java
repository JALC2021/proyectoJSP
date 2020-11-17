/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Anunciodestacado;
import modelo.HibernateUtil;
import modelo.Producto;
import org.hibernate.Query;
import org.hibernate.Session;


public class DAOAnuncio {

    Session ses = null;

    public DAOAnuncio() {
        //ses = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Producto> consultaAnuncios() {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createSQLQuery("SELECT p.`idProducto`,p.`titulo`, p.`descripcion`,p.`imagen` FROM `anunciodestacado` ac, `producto` p where ac.`idProducto` = p.`idProducto` ORDER BY ac.`fechaInicio` DESC limit 3");
        List<Producto> l = (List<Producto>) q.list();

        tx.commit();

        return l;
    }

    public List<Anunciodestacado> consultaAnuncioPorId(int id) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        Query q = ses.createQuery("FROM Anunciodestacado WHERE idAnuncioDestacado ="+id);
        List<Anunciodestacado> l = (List<Anunciodestacado>) q.list();

        tx.commit();

        return l;
    }

    public List<Anunciodestacado> anadirAnuncio(Anunciodestacado a) {
        // ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.save(a);
        Query q = ses.createQuery("FROM Anunciodestacado");
        List<Anunciodestacado> l = (List<Anunciodestacado>) q.list();

        tx.commit();

        return l;
    }
    
    public List<Anunciodestacado> eliminarAnuncio(int idAnuncio) {
        Anunciodestacado c = (Anunciodestacado) consultaAnuncioPorId(idAnuncio);
        //ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        ses.delete(c);

        Query q = ses.createQuery("FROM Anunciodestacado");
        List<Anunciodestacado> l = (List<Anunciodestacado>) q.list();

        tx.commit();

        return l;

    }
}