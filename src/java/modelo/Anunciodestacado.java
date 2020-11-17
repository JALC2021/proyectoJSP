package modelo;
// Generated 26-may-2016 13:02:19 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Anunciodestacado generated by hbm2java
 */
public class Anunciodestacado  implements java.io.Serializable {


     private Integer idAnuncioDestacado;
     private int idUsuario;
     private int idProducto;
     private Date fechaInicio;
     private Date fechaFin;
     private int activo;

    public Anunciodestacado() {
    }

    public Anunciodestacado(int idUsuario, int idProducto, Date fechaInicio, Date fechaFin, int activo) {
       this.idUsuario = idUsuario;
       this.idProducto = idProducto;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.activo = activo;
    }
   
    public Integer getIdAnuncioDestacado() {
        return this.idAnuncioDestacado;
    }
    
    public void setIdAnuncioDestacado(Integer idAnuncioDestacado) {
        this.idAnuncioDestacado = idAnuncioDestacado;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public int getActivo() {
        return this.activo;
    }
    
    public void setActivo(int activo) {
        this.activo = activo;
    }




}


