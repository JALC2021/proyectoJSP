package modelo;
// Generated 26-may-2016 13:02:19 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Integer idProducto;
     private int idSubCategoria;
     private String titulo;
     private String descripcion;
     private int precio;
     private int vendido;
     private int idUsuario;
     private String provincia;
     private int activo;
     private Date fechaVendido;
     private Date fechaAlta;
     private String imagen;

    public Producto() {
    }

    public Producto(int idSubCategoria, String titulo, String descripcion, int precio, int vendido, int idUsuario, String provincia, int activo, Date fechaVendido, Date fechaAlta, String imagen) {
       this.idSubCategoria = idSubCategoria;
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.precio = precio;
       this.vendido = vendido;
       this.idUsuario = idUsuario;
       this.provincia = provincia;
       this.activo = activo;
       this.fechaVendido = fechaVendido;
       this.fechaAlta = fechaAlta;
       this.imagen = imagen;
    }

     
    public Integer getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public int getIdSubCategoria() {
        return this.idSubCategoria;
    }
    
    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getVendido() {
        return this.vendido;
    }
    
    public void setVendido(int vendido) {
        this.vendido = vendido;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public int getActivo() {
        return this.activo;
    }
    
    public void setActivo(int activo) {
        this.activo = activo;
    }
    public Date getFechaVendido() {
        return this.fechaVendido;
    }
    
    public void setFechaVendido(Date fechaVendido) {
        this.fechaVendido = fechaVendido;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }




}


