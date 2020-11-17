<%@taglib prefix="s" uri="/struts-tags" %>
<li class="grid"><a href="<s:url action="../actions/MenuAgregarProducto"/>">Agregar Producto</a></li>
<li class="grid"><a href="<s:url action="../actions/misMensajes"><s:param name="idUsuario" value="%{#session.idUsuarioLogado}" /></s:url>">Mis Mensajes</a></li>
<li class="grid"><a href="<s:url action="../actions/mostrarProductos"><s:param name="idUsuario" value="%{#session.idUsuarioLogado}" /></s:url>">Mis Productos</a></li>