<%@ taglib prefix="s" uri="/struts-tags" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <s:include value="../include/cabecera.html" /> 
    <body>

        <table align="center" border="2">
            <tr>
                <td><img src="../images/logo-4.png"></td>
            </tr>
            <tr align="center">
                <td><h1> Inicio de sesión </h1></td>
            </tr>
            <tr align="center">
                <td>
                    <s:form action="/actions/loginCheck" validate="true">
                        <s:textfield name="usuario" label="Usuario"></s:textfield>  
                        <s:password name="password" label="Password"></s:password>  
                        <s:submit value="login"></s:submit>  
                    </s:form>
                </td>
            </tr>
            <tr align="center">
                <td>
                    <a href="<s:url action="../actions/registroNuevo"/>">Registrarse</a>
                </td>
            </tr>
        </table>
    </body>
</html>
