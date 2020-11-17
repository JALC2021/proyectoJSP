<%@taglib prefix="s" uri="/struts-tags" %>
<div class="top-header">
    <div class="container">
        <div class="top-header-main">
            <div class="col-md-4 top-header-left"><!--
                <div class="search-bar">
                    <input type="text" value="Buscar producto" onfocus="this.value = '';" onblur="if (this.value == '') {
                                this.value = 'Search';
                            }">
                    <input type="submit" value="">
                </div>-->
            </div>
            <div class="col-md-4 top-header-middle">
                <a href="#"><img src="../images/logo-4.png" alt="" /></a>
            </div>
            <div class="col-md-4 top-header-right">
                <div class="cart box_1">
                    <%
                        session = request.getSession(false);
                        if (session.getAttribute("tipoUsuarioo").equals("user") || session.getAttribute("tipoUsuarioo").equals("admin")) {
                    %>

                    <a href="<s:url action="../actions/desconectar"/>">Logout</a><br>

                    <%
                    } else {

                    %>       
                    <a href="<s:url action="../actions/login"/>">Login</a><br>
                    <%                                }
                    %>



                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>