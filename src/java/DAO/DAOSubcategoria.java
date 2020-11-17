/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Subcategoria;
import org.apache.struts2.dispatcher.SessionMap;
import org.hibernate.Query;
import org.hibernate.Session;
    

public class DAOSubcategoria {

    Session ses = null;
    
    
    //Metodo para consultar todas las subcategoria
    public List<Subcategoria> consultaSubcategoria() {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("FROM Subcategoria WHERE activo=1");
        List<Subcategoria> listaSubCategoria = (List<Subcategoria>) q.list();
        tx.commit();      
        return listaSubCategoria;
    }

    //Metodo para consultar la subcategoria por id de subcategoria
    public List<Subcategoria> consultaSubCategoriaPorId(int idSubCategoria) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        Query q = ses.createQuery("FROM Subcategoria WHERE idSubcategoria=" + idSubCategoria);
        List<Subcategoria> listaSubCategoria = (List<Subcategoria>) q.list();

        tx.commit();

        return listaSubCategoria;
    }

    //metodo para actualizar los datos de la subcategoria por id
    public void actualizarSubCategoriaPorId(int idSubcategoria, String nombre, String descripcion) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Subcategoria c = (Subcategoria) ses.get(Subcategoria.class, idSubcategoria);
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        ses.update(c);
        tx.commit();
    }

    //Metodo para ocultar la subcategoria por idSubcategoria
    public void ocultarSubCategoriaPorIds(int idSubcategoria) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        Subcategoria c = (Subcategoria) ses.get(Subcategoria.class, idSubcategoria);

        c.setActivo(0);
        ses.update(c);
        tx.commit();
    }

    //Metodo para añadir una subcategoria
    public List<Subcategoria> anadirSubcategoria(Subcategoria s) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.save(s);
        Query q = ses.createQuery("from Subcategoria");
        List<Subcategoria> listaSubCategoria = (List<Subcategoria>) q.list();
        
        tx.commit();

        return listaSubCategoria;
    }

    public List<Subcategoria> mostrarSubCategoriaPorIdCategoria(int idCategoria) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("from Subcategoria where idCategoria='"+idCategoria+"'");
        List<Subcategoria> listaSubCategoria = (List<Subcategoria>) q.list();
        tx.commit();
        return listaSubCategoria;

    }
}
