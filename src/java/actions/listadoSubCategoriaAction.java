/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DAO.DAOSubcategoria;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import modelo.Subcategoria;
import org.apache.struts2.dispatcher.SessionMap;


public class listadoSubCategoriaAction extends ActionSupport {
    private DAOSubcategoria dao = new DAOSubcategoria();
    private List<Subcategoria> listaSubCategoria = new ArrayList<Subcategoria>();
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private int idSubcategoria;
    private int activo=1;

    
    
    public listadoSubCategoriaAction() {
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Iniciamos todos los gets y sets de los atributos
    public DAOSubcategoria getDao() {
        return dao;
    }

    public void setDao(DAOSubcategoria dao) {
        this.dao = dao;
    }

    public List<Subcategoria> getListaSubCategoria() {
        return listaSubCategoria;
    }

    public void setListaSubCategoria(List<Subcategoria> listaSubCategoria) {
        this.listaSubCategoria = listaSubCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    //Finalizamos los gets y sets
    
    //Metodo para consultar todas las subcaterogias
    public String consultaSubCategoriasTodas(){
        listaSubCategoria = dao.consultaSubcategoria();     
        return SUCCESS;
    }
    
    //Metodo para consultar todas la subcategorias por idSubcategoria
    public String consultaSubCategoriaPorId(){
        listaSubCategoria = dao.consultaSubCategoriaPorId(idSubcategoria);
        return SUCCESS;
    }
    
    //Metodo para actualizar los datos de la subcategoria por idSubcategoria
    public String actualizarSubCategoriaPorId(){
        dao.actualizarSubCategoriaPorId(idSubcategoria, nombre, descripcion);
        return SUCCESS;
    }
    
    //Metodo para ocultar la subcategoria por idSubcategoria
    public String ocultarSubCategoriaPorIds(){
        dao.ocultarSubCategoriaPorIds(idSubcategoria);
        listaSubCategoria = dao.consultaSubcategoria();
        
        return SUCCESS;
    }
    
    //Metodo para anadir una subcategoria nueva
    public String anadirSubcategoria() {
        Subcategoria s = new Subcategoria(nombre, descripcion, activo, idCategoria);       
        listaSubCategoria = dao.anadirSubcategoria(s);
        return SUCCESS;
    }
    
    public String mostrarSubCategoriaPorIdCategoria(){
    listaSubCategoria = dao.mostrarSubCategoriaPorIdCategoria(idCategoria);
    return SUCCESS;
    }
    
}
