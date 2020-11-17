/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Categoria;
import modelo.HibernateUtil;
import modelo.Producto;
import modelo.Anunciodestacado;
import modelo.Subcategoria;
import org.hibernate.Query;
import org.hibernate.Session;


public class DAOProducto {
    Session ses = null;
    List<Producto> listaProductos =  new ArrayList<>();
    
    public List<Producto> consultaProductos() {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        
        Query q = ses.createQuery("FROM Producto WHERE activo=1 AND vendido=0");
       listaProductos = (List<Producto>) q.list();
        
        tx.commit();
        
        return listaProductos;
    }
    
    public List<Producto> actualizarProducto(int idProducto,int idUsuario,String titulo,String descripcion,int precio,String provincia) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Producto p = (Producto) ses.get(Producto.class, idProducto);      
        p.setDescripcion(descripcion);             
        p.setPrecio(precio);
        p.setProvincia(provincia);
        p.setTitulo(titulo);         
        ses.update(p);        
        tx.commit();
        return listaProductos = consultaProductosPorIdUsuario(idUsuario);
    }
    
    
    public List<Producto> consultaProductosPorId(int idProducto) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();      
        Query q = ses.createQuery("from Producto where idProducto='"+idProducto+"'");
        listaProductos = (List<Producto>) q.list();      
        tx.commit();
        return listaProductos;
    }
    
    public List<Producto> consultaProductosPorIdSubCategoria(int idSubCategoria) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        
        Query q = ses.createQuery("FROM Producto WHERE idSubCategoria='"+idSubCategoria+"'");
        listaProductos = (List<Producto>) q.list();
        
        tx.commit();
        return listaProductos;
    }
    
    public List<Producto> anadirProducto(Producto p) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        ses.save(p);

        Query q = ses.createQuery("from Producto");
        listaProductos = (List<Producto>) q.list();

        tx.commit();

        return listaProductos;
    }
    
    
    public List<Producto> eliminarProducto(int id) {
        Producto p = (Producto) consultaProductosPorId(id);
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        ses.delete(p);

        Query q = ses.createQuery("from Producto");
        listaProductos = (List<Producto>) q.list();

        tx.commit();

        return listaProductos;

    }
    
    public List<Producto> consultaProductosPorIdUsuario(int idUsuario) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        
        Query q = ses.createQuery("FROM Producto WHERE idUsuario='"+idUsuario+"'");
        listaProductos = (List<Producto>) q.list();
        
        tx.commit();
        return listaProductos;
    }
    
     public void ocultarProductoPorIds(Integer idProducto) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Producto c = (Producto) ses.get(Producto.class, idProducto);    
        c.setActivo(0);
        ses.update(c);
        tx.commit();
    }

    public Session getSes() {
        return ses;
    }

    public void setSes(Session ses) {
        this.ses = ses;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void productoVendidoPorId(int idProducto, Date fechaVendido) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Producto p = (Producto) ses.get(Producto.class, idProducto);      
        p.setVendido(1);
        p.setFechaVendido(fechaVendido);
        ses.update(p);        
        tx.commit();
    }
    public List<Anunciodestacado> productoDestacadoPorId(Anunciodestacado ad) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        
        ses.save(ad);
        Query q = ses.createQuery("from Anunciodestacado");
        List<Anunciodestacado> l = (List<Anunciodestacado>) q.list();

        tx.commit();

        return l;
    }
    
}
