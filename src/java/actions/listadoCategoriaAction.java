/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DAO.DAOAnuncio;
import DAO.DAOCategoria;
import DAO.DAOProducto;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Categoria;
import modelo.Producto;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


public class listadoCategoriaAction extends ActionSupport implements SessionAware {

    private DAOCategoria dao = new DAOCategoria();
    private List<Categoria> listaCategoria = new ArrayList<Categoria>();
    private int idCategoria;
    private String nombre;
    private DAOAnuncio daoanuncio = new DAOAnuncio();
    private String descripcion;
    private int activo = 1;
    private SessionMap<String, Object> session;
    private List<Producto> listaAnuncio = new ArrayList<>();

    //Creamos los gets y sets de los atributos del action
    public DAOCategoria getDao() {
        return dao;
    }

    public SessionMap<String, Object> getSession() {
        return session;
    }

    public void setSession(SessionMap<String, Object> session) {
        this.session = session;
    }

    public void setDao(DAOCategoria dao) {
        this.dao = dao;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public DAOAnuncio getDaoanuncio() {
        return daoanuncio;
    }

    public void setDaoanuncio(DAOAnuncio daoanuncio) {
        this.daoanuncio = daoanuncio;
    }

    public List<Producto> getListaAnuncio() {
        return listaAnuncio;
    }

    public void setListaAnuncio(List<Producto> listaAnuncio) {
        this.listaAnuncio = listaAnuncio;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    //Finalizamos los gets y sets

    public listadoCategoriaAction() {
    }

    public String execute() throws Exception {
        listaCategoria = dao.consultaCategorias();
        if (listaCategoria.equals(null)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    //Metodo para eliminar una categoria
    public String eliminarCategoria() {
        listaCategoria = dao.eliminarCategoria(idCategoria);
        return SUCCESS;
    }

    //Metodo para añadir una categoria  
    public String anadirCategoria() {
        Categoria c = new Categoria(nombre, descripcion, activo);
        listaCategoria = dao.anadirCategoria(c);
        return SUCCESS;
    }

    //Metodo para consultar todas las categorias
    public String consultaCategoriasTodas() {
        listaCategoria = dao.consultaCategorias();

        session.put("listaCategoria", listaCategoria);

        return SUCCESS;
    }

    //Metodo para consultar la categoria por idCategoria
    public String consultaCategoriaPorId() {
        listaCategoria = dao.consultaCategoriaPorId(idCategoria);
        return SUCCESS;
    }

    //Metodo para actualizar la categoria por idCategoria
    public String actualizarCategoriaPorId() {
        dao.actualizarCategoriaPorId(idCategoria, nombre, descripcion);
        return SUCCESS;
    }

    //Metodo para ocultar la categoria por idCategoria
    public String ocultarCategoriaPorIds() {
        dao.ocultarCategoriaPorIdss(idCategoria);
        listaCategoria = dao.consultaCategorias();

        session.put("listaCategoria", listaCategoria);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = (SessionMap<String, Object>) map;
    }

}
