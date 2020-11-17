/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import modelo.HibernateUtil;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;


public class DAOUsuario {

    Session ses = null;
    List<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public DAOUsuario() {

    }

    public List consultarTodosUsuarios() {
        this.ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("from Usuario where activo =1");
        listaUsuarios = (List<Usuario>) q.list();
        tx.commit();
        return listaUsuarios;
    }

    public List<Usuario> consultarUsuarioId(int idUsuario) {
        this.ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("from Usuario where idUsuario='" + idUsuario + "'");
        listaUsuarios = (List<Usuario>) q.list();
        tx.commit();
        return listaUsuarios;
    }
    
    public List<Usuario> consultarUsuario(String usuario) {
        this.ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("from Usuario where usuario='" + usuario + "'");
        listaUsuarios = (List<Usuario>) q.list();
        tx.commit();
        return listaUsuarios;
    }

    public List<Usuario> addUsuario(Usuario e) {
        this.ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.save(e);
        Query q = ses.createQuery("from Usuario");
        listaUsuarios = (List<Usuario>) q.list();
        tx.commit();
        return listaUsuarios;

    }

    public List<Usuario> eliminarUsuario(Usuario e) {
        this.ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.delete(e);
        Query q = ses.createQuery("from Usuario");
        listaUsuarios = (List<Usuario>) q.list();
        tx.commit();
        return listaUsuarios;

    }

    public void actualizarUsuarioID(int idUsuario,String nombre,String apellido1,String apellido2,int telefono1,int telefono2,String provincia,String email,String usuario,String password) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        Usuario c = (Usuario) ses.get(Usuario.class, idUsuario);
        
        c.setNombre(nombre);
        c.setApellido1(apellido1);
        c.setApellido2(apellido2);
        c.setTelefono1(telefono1);
        c.setTelefono2(telefono2);
        c.setProvincia(provincia);
        c.setEmail(email);
        c.setUsuario(usuario);
        c.setPassword(password);
        ses.update(c);
        tx.commit();
    }

    public void ocultarUsuarioPorIds(int idUsuario) {
        ses = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = ses.beginTransaction();

        Usuario c = (Usuario) ses.get(Usuario.class, idUsuario);
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

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}
