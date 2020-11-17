/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DAO.DAOMensaje;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import org.hibernate.Session;


public class mensajesAction extends ActionSupport {

    DAOMensaje dao = new DAOMensaje();
    private int idUsuario;
    private int idMensaje;
    private int idUsuarioLogado;
    private int idUsuarioEmisor;
    private int idUsuarioReceptor;
    private int idProducto;
    private String mensaje;
    private Date fecha;
    private String hora;
    private int leido;
    List<Mensaje> listaMensajes = new ArrayList<>();
    
    
    public String execute() throws Exception {
        listaMensajes = dao.consultarTodosLosMensajes(idUsuario);
        return "success";
    }
    
    public String añadirMensaje(){    
        
    listaMensajes=dao.addMensaje(idUsuarioLogado,idUsuario,idProducto,mensaje,fecha,hora,leido);
    return "success";
    }
    
    public String responderMensaje(){
    listaMensajes=dao.addMensaje(idUsuarioReceptor, idUsuarioEmisor, idProducto, mensaje, fecha, hora, leido);
    return "success";
    }
    
    
    public String buscarMensajeID(){
    listaMensajes = dao.consultarMensajeId(idMensaje);
    return "success";
    }

    public DAOMensaje getDao() {
        return dao;
    }

    public void setDao(DAOMensaje dao) {
        this.dao = dao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public int getIdUsuarioLogado() {
        return idUsuarioLogado;
    }

    public void setIdUsuarioLogado(int idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public int getIdUsuarioEmisor() {
        return idUsuarioEmisor;
    }

    public void setIdUsuarioEmisor(int idUsuarioEmisor) {
        this.idUsuarioEmisor = idUsuarioEmisor;
    }

    public int getIdUsuarioReceptor() {
        return idUsuarioReceptor;
    }

    public void setIdUsuarioReceptor(int idUsuarioReceptor) {
        this.idUsuarioReceptor = idUsuarioReceptor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getLeido() {
        return leido;
    }

    public void setLeido(int leido) {
        this.leido = leido;
    }

    public List<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }
    
   
    
   

    
    
    
}
