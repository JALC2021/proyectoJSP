/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import DAO.DAOUsuario;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Usuario;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;

public class LoginCheckAnnotations extends ActionSupport implements SessionAware{
    
    public LoginCheckAnnotations() {
    }
    
    private String usuario;
    private String password;
    private DAOUsuario dao = new DAOUsuario();
    private List<Usuario> listaUsuario = new ArrayList<Usuario>();
    private SessionMap<String, Object> session;

    public SessionMap<String, Object> getSession() {
        return session;
    }

    public void setSession(SessionMap<String, Object> session) {
        this.session = session;
    }
    
    

    public String execute() throws Exception {
        
        List<Usuario> u = dao.consultarUsuario(usuario); 
        Usuario e = u.get(0);
        if(e.getPassword().equals(getPassword())){
            listaUsuario = dao.consultarUsuario(usuario);
            session.put("tipoUsuarioo", e.getTipoUsuario());
            session.put("idUsuarioLogado", e.getIdUsuario());
            session.put("nombreUser",e.getNombre());
            return SUCCESS;
        } else {
            this.addActionError("Invalido usuario y/o password");
            return ERROR;
        }
    }

    public DAOUsuario getDao() {
        return dao;
    }

    public void setDao(DAOUsuario dao) {
        this.dao = dao;
    }

    
    
    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    
    /**
     * @return the username
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param username the username to set
     */
    @RequiredStringValidator(key = "Usuario requerido")
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    @StringLengthFieldValidator(key = "Password incorrecta")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = (SessionMap<String, Object>) map;
    }
    
    public String logout(){
        session.clear();
        session.invalidate();      
        return SUCCESS;
    }
}
