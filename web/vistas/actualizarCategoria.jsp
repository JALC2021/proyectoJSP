<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <s:include value="../include/cabecera.html" />
    <body>
        <h1>Actualizar Categoria</h1>
        <s:form action="/actions/actualizarCategoriaPorId" validate="true" >
            <s:iterator value="listaCategoria">
                <s:textfield key="nombre" label="nombre" value="%{nombre}" ></s:textfield>
                <s:textfield key="descripcion" label="Descripción"  value="%{descripcion}" ></s:textfield>
                <s:hidden name="idCategoria" value="%{idCategoria}"></s:hidden>
            </s:iterator>
            <s:submit value="Actualizar"></s:submit>
        </s:form>
    </body>
</html>
