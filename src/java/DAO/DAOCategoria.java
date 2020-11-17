/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Categoria;
import org.hibernate.Query;
import org.hibernate.Session;


public class DAOCategoria {

    Session ses = null;

    public DAOCategoria() {
    
    }
    //Metodo para consultar todas las categorias
    public List<Categoria> consultaCategorias() {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("from Categoria where activo =1");
        List<Categoria> l = (List<Categoria>) q.list();
        tx.commit();

        return l;
    }

    //Metodo para consultar todas las categorias por id de categoria
    public List<Categoria> consultaCategoriaPorId(int id) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        Query q = ses.createQuery("FROM Categoria WHERE idCategoria=" + id);
        List<Categoria> l = (List<Categoria>) q.list();

        tx.commit();

        return l;
    }

    //Metodo para anadir categoria
    public List<Categoria> anadirCategoria(Categoria c) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.save(c);
        Query q = ses.createQuery("from Categoria");
        List<Categoria> l = (List<Categoria>) q.list();

        tx.commit();

        return l;
    }

    //Metodo para eliminar una categoria
    public List<Categoria> eliminarCategoria(int idCategoria) {
        Categoria c = (Categoria) consultaCategoriaPorId(idCategoria);
        //ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        ses.delete(c);

        Query q = ses.createQuery("from Categoria");
        List<Categoria> l = (List<Categoria>) q.list();

        tx.commit();

        return l;

    }
    //Metodo para actualizar los datos de una categoria
    public void actualizarCategoriaPorId(int idCategoria, String nombre, String descripcion) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        Categoria c = (Categoria) ses.get(Categoria.class, idCategoria);        
        c.setNombre(nombre);
        c.setDescripcion(descripcion);
        ses.update(c);
        tx.commit();
    }
    
    //Metodo para ocultar una categoria por id de categoria
    public void ocultarCategoriaPorIdss(int idCategoria) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        Categoria c = (Categoria) ses.get(Categoria.class, idCategoria);
        
        c.setActivo(0);
        ses.update(c);
        tx.commit();
    }
}
