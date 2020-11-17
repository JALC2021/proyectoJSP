/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DAO.DAOCategoria;
import DAO.DAOProducto;
import DAO.DAOSubcategoria;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Destroyed;
import javax.servlet.http.HttpServletRequest;
import modelo.Anunciodestacado;
import modelo.Categoria;
import modelo.Producto;
import modelo.Subcategoria;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;


public class ListadoProducto extends ActionSupport implements ServletRequestAware {

    DAOProducto daopro = new DAOProducto();
    DAOCategoria daocat = new DAOCategoria();
    DAOSubcategoria daosubcat = new DAOSubcategoria();
    private String titulo;
    private String descripcion;
    private int precio;
    private String provincia;
    private Integer idProducto;
    private int idSubCategoria;
    private int idUsuario;
    private int activo = 1;
    private Date fechaVendido = null;
    private Date fechaAlta = Calendar.getInstance().getTime();
    List<Producto> listaProductos = new ArrayList<>();
    private int vendido = 0;
    private String imagenArchivoFileName;
    private String imagen;
    private String imagenArchivoContentType;
    private File imagenArchivo;
    List<Categoria> listaCategorias = new ArrayList<Categoria>();
    List<Subcategoria> listaSubcategorias = new ArrayList<Subcategoria>();
    List listaSubCategoriasDeCategorias = new ArrayList();
    private HttpServletRequest servletRequest;
    //private Producto prod;



    public ListadoProducto() {
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String execute() throws Exception {
        listaCategorias = daocat.consultaCategorias();
        listaSubcategorias = daosubcat.consultaSubcategoria();
//        listaSubCategoriasDeCategorias = daosubcat.consultaSubCatMasCat();
        return "success";
    }

    public String mostrarProductoPorID() {
        listaProductos = daopro.consultaProductosPorId(idProducto);
        return "success";

    }

    public String productoVendidoPorId() {
        daopro.productoVendidoPorId(idProducto, fechaAlta);
        return "success";

    }

    public String productoDestacadoPorId() {
        Date fechaDestacada = sumarRestarDiasFecha(fechaAlta, 10); //Sumamos 10 días la fecha actual
        
        Anunciodestacado ad = new Anunciodestacado(0, idProducto, fechaAlta ,fechaDestacada, 1); //Creamos el objeto con el anuncio destacado
        daopro.productoDestacadoPorId(ad); //Guardamos el objeto
        return "success";

    }

    public Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0

        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

    }

    public String consultaProductosIdUsuario() {
        listaProductos = daopro.consultaProductosPorIdUsuario(idUsuario);
        return SUCCESS;
    }

    public String modificarProducto() {
        listaProductos = daopro.actualizarProducto(idProducto, idUsuario, titulo, descripcion, precio, provincia);
        return "success";
    }

    public String ocultarProductoPorIds() {
        daopro.ocultarProductoPorIds(idProducto);
        return SUCCESS;
    }

    //Para la lista
    public String mostrarSubCategoriasProductos() {
        listaSubcategorias = daosubcat.consultaSubcategoria();
        return "success";
    }

    //PAra coger los productos segund subcategoria
    public String consultarProductoSegunSubCategoria() {
        listaProductos = daopro.consultaProductosPorIdSubCategoria(idSubCategoria);
        return "success";
    }

    public String aniadirProducto() {
        try {
            this.setImagenArchivoFileName(String.valueOf(System.currentTimeMillis()) + this.getImagenArchivoFileName());
            ///Users/dominieliaspereirademattos/NetBeansProjects/compraventafinal/web
            String filePath = servletRequest.getSession().getServletContext().getRealPath("/img/products/");
            String filePath2 = filePath.substring(filePath.length() - 17);
            String filePath3 = filePath.substring(0, filePath.indexOf("compraventafinal") + 16);
            String filePath4 = filePath3 + filePath2;
            File fileToCreate = new File(filePath4, this.imagenArchivoFileName);
            FileUtils.copyFile(this.imagenArchivo, fileToCreate);
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());

            return INPUT;
        }

        Producto prod = new Producto(idSubCategoria, titulo, descripcion, precio, vendido, idUsuario, provincia, activo, fechaVendido, fechaAlta, imagenArchivoFileName);
        List<Producto> l = daopro.anadirProducto(prod);

        return "success";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdSubCategoria() {
        return idSubCategoria;
    }

    public String getImagenArchivoFileName() {
        return imagenArchivoFileName;
    }

    public void setImagenArchivoFileName(String imagen) {
        this.imagenArchivoFileName = imagen;
    }

    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    public int getVendido() {
        return vendido;
    }

    public void setVendido(int vendido) {
        this.vendido = vendido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFechaVendido() {
        return fechaVendido;
    }

    public void setFechaVendido(Date fechaVendido) {
        this.fechaVendido = fechaVendido;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public DAOProducto getDaopro() {
        return daopro;
    }

    public void setDaopro(DAOProducto daopro) {
        this.daopro = daopro;
    }

    public DAOCategoria getDaocat() {
        return daocat;
    }

    public void setDaocat(DAOCategoria daocat) {
        this.daocat = daocat;
    }

    public DAOSubcategoria getDaosubcat() {
        return daosubcat;
    }

    public void setDaosubcat(DAOSubcategoria daosubcat) {
        this.daosubcat = daosubcat;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public List<Subcategoria> getListaSubcategorias() {
        return listaSubcategorias;
    }

    public void setListaSubcategorias(List<Subcategoria> listaSubCategorias) {
        this.listaSubcategorias = listaSubCategorias;
    }

    public String getImagenArchivoContentType() {
        return imagenArchivoContentType;
    }

    public void setImagenArchivoContentType(String imagenContentType) {
        this.imagenArchivoContentType = imagenContentType;
    }

    public File getImagenArchivo() {
        return imagenArchivo;
    }

    public void setImagenArchivo(File imagenArchivo) {
        this.imagenArchivo = imagenArchivo;
    }

    public List getListaSubCategoriasDeCategorias() {
        return listaSubCategoriasDeCategorias;
    }

    public void setListaSubCategoriasDeCategorias(List listaSubCategoriasDeCategorias) {
        this.listaSubCategoriasDeCategorias = listaSubCategoriasDeCategorias;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

}
