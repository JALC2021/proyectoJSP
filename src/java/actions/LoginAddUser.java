/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DAO.DAOUsuario;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.Usuario;


public class LoginAddUser extends ActionSupport{

    private Usuario user;
    private Integer idUsuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int telefono1;
    private int telefono2;
    private String provincia;
    private String tipoUsuario;
    private String email;
    private String usuario;
    private String password;
    private String repeatpassword;
    private int activo;
    DAOUsuario dao = new DAOUsuario();


    public LoginAddUser() {
    }

    public String execute() throws Exception {
        user = new Usuario(nombre, apellido1, apellido2, telefono1, telefono2, provincia, "user", email, usuario, password, 1);
        List<Usuario> u = dao.addUsuario(user);
        if(u.equals(null)){
        return "error";
        }
        return "success";
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
}
