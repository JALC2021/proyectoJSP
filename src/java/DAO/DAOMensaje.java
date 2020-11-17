/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.HibernateUtil;
import modelo.Mensaje;
import org.hibernate.Query;
import org.hibernate.Session;


public class DAOMensaje {

    private int idUsuarioLogado;
    private int idUsuario;
    
    Session ses = null;
    List<Mensaje> listaMensajes = new ArrayList<>();
    public DAOMensaje() {
        this.ses = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Mensaje> consultarTodosLosMensajes(int idUsuario) {
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("from Mensaje where idUsuarioEmisor='"+idUsuario+"' or idUsuarioReceptor='"+idUsuario+"'");
        listaMensajes = (List<Mensaje>) q.list();
        tx.commit();
        return listaMensajes;
    }

    public List<Mensaje> consultarMensaje(int idUsuarioEmisor) {
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("from Mensaje where idUsuarioEmisor="+idUsuarioEmisor);
        listaMensajes = (List<Mensaje>) q.list();
        tx.commit();
        return listaMensajes;
    }
    
    public List<Mensaje> consultarMensajeId(int idMensaje) {
        org.hibernate.Transaction tx = ses.beginTransaction();
        Query q = ses.createQuery("from Mensaje where idMensaje='"+idMensaje+"'");
        listaMensajes = (List<Mensaje>) q.list();
        tx.commit();
        return listaMensajes;
    }

    public List<Mensaje> addMensaje(int idUsuarioLogado,int idUsuario,int idProducto,String mensaje,Date fecha,String hora,int leido) {
        Date date = new Date();
        String hour = Integer.toString(date.getHours());
        Mensaje e= new Mensaje(idUsuarioLogado, idUsuario, idProducto, mensaje,date ,hour, leido);
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.save(e);     
        Query q = ses.createQuery("from Mensaje where idUsuarioEmisor='"+idUsuarioLogado+"' or idUsuarioReceptor='"+idUsuarioLogado+"'");
        listaMensajes = (List<Mensaje>) q.list();       
        tx.commit();
        return listaMensajes;

    }

    public List<Mensaje> eliminarMensaje(Mensaje e) {
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.delete(e);
        Query q = ses.createQuery("from Mensaje");
        listaMensajes = (List<Mensaje>) q.list();
        tx.commit();
        return listaMensajes;

    }

    public int getIdUsuarioLogado() {
        return idUsuarioLogado;
    }

    public void setIdUsuarioLogado(int idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Session getSes() {
        return ses;
    }

    public void setSes(Session ses) {
        this.ses = ses;
    }

    public List<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    
    public List<Mensaje> modificarMensaje(Mensaje e) {
        org.hibernate.Transaction tx = ses.beginTransaction();
        ses.update(e);
        Query q = ses.createQuery("from Mensaje");
        listaMensajes = (List<Mensaje>) q.list();
        tx.commit();
        return listaMensajes;
    }
    
    
}
