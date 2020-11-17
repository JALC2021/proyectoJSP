
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <s:include value="../include/cabecera.html" />
    <body>
        <s:form action="/actions/añadirMensaje" validate="true">           
            <s:textfield name="idUsuarioReceptor" value="%{idRecepctor}" label="Destinattario"></s:textfield>
            <s:hidden name="nombreProducto" value="%{nombreProducto}"></s:hidden>
            <s:textarea name="mensaje" label="Mensaje"></s:textarea>
            <s:submit name="Enviar" label="Enviar"></s:submit>
        </s:form>
    </body>
</html>
