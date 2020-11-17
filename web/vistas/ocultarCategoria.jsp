<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <s:include value="../include/cabecera_1.html" />
    <body>
        <!--top-header-->
        <s:include value="../include/headers_1.jsp" />
        <!--top-header-->
        <!--bottom-header-->
        <div class="header-bottom">
            <div class="container">
                <div class="top-nav">
                    <ul class="memenu skyblue"><li class="active"><a href="#">Inicio</a></li>
                        <!-- Comprobamos si es usuario o administrador para mostrar el menu oportuno -->
                        <%
                            session = request.getSession(false);
                            if (session.getAttribute("tipoUsuarioo").equals("user")) {
                        %>

                        <s:include value="../include/menu/menuUser.jsp" ></s:include>

                        <%
                        } else {

                        %>       
                        <s:include value="../include/menu/menuAdmin.jsp" />
                        <%                                }
                        %>
                </div>
            </div>
        </div>
        <!--bottom-header-->
        <!--banner-starts-->
        <div class="bnr" id="home">
            <div  id="top" class="callbacks_container">
                <ul class="rslides" id="slider4">
                    <li>
                        <div class="banner-1"></div>
                    </li>
                    <li>
                        <div class="banner-2"></div>
                    </li>
                    <li>
                        <div class="banner-3"></div>
                    </li>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
        <!--banner-ends--> 
        <!--Slider-Starts-Here-->
        <script src="../js/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function () {
                // Slideshow 4
                $("#slider4").responsiveSlides({
                    auto: true,
                    pager: true,
                    nav: false,
                    speed: 500,
                    namespace: "callbacks",
                    before: function () {
                        $('.events').append("<li>before event fired.</li>");
                    },
                    after: function () {
                        $('.events').append("<li>after event fired.</li>");
                    }
                });

            });
        </script>
        <!--End-slider-script-->
        <!--start-banner-bottom--> 
        <div class="banner-bottom">
            <div class="container">
                <div class="banner-bottom-top">
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!--end-banner-bottom--> 
        <!--start-shoes--> 
        <div class="shoes"> 
            <div class="container"> 
                <div class="product-one">
                    <table align="center">

                        <tr align="center">
                            <td><strong>Nombre</strong></td>
                            <td><strong>Descripción</strong></td>
                            <td><strong>Opciones</strong></td>
                        </tr>
                        <s:iterator value="listaCategoria">
                            <tr>
                                <td><s:property value="nombre" /></td>
                                <td><s:property value="descripcion" /></td>
                                <td>

                                        <s:url action="../actions/ocultarCategoriaPorIds" var="urlTag2" >
                                            <s:param name="idcategoria" value="%{idCategoria}"></s:param>
                                        </s:url>
                                    <a href="<s:property value="#urlTag2" />" ><img src="../img/icons/delete.png"></a>

                                </td>

                            </tr>
                        </s:iterator>
                    </table> 
                </div>
            </div>
        </div>
        <!--end-shoes-->
        <!--start-abt-shoe-->

        <!--end-abt-shoe-->
        <!--start-footer-->
        <!--<div class="footer">
            <div class="container">
                <div class="footer-top">
                    <div class="col-md-3 footer-left">
                        <h3>ABOUT US</h3>
                        <ul>
                            <li><a href="#">Who We Are</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Our Sites</a></li>
                            <li><a href="#">In The News</a></li>
                            <li><a href="#">Team</a></li>
                            <li><a href="#">Carrers</a></li>					 
                        </ul>
                    </div>
                    <div class="col-md-3 footer-left">
                        <h3>YOUR ACCOUNT</h3>
                        <ul>
                            <li><a href="#">Your Account</a></li>
                            <li><a href="#">Personal Information</a></li>
                            <li><a href="#">Addresses</a></li>
                            <li><a href="#">Discount</a></li>
                            <li><a href="#">Track your order</a></li>					 					 
                        </ul>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>-->
        <!--end-footer-->
        <!--end-footer-text-->
        <div class="footer-text">
            <div class="container">
                <div class="footer-main">
                    <s:include value="../include/reserved.html" />
                </div>
            </div>
            <script type="text/javascript">
                $(document).ready(function () {
                    /*
                     var defaults = {
                     containerID: 'toTop', // fading element id
                     containerHoverID: 'toTopHover', // fading element hover id
                     scrollSpeed: 1200,
                     easingType: 'linear' 
                     };
                     */

                    $().UItoTop({easingType: 'easeOutQuart'});

                });
            </script>
            <a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
        </div>
        <!--end-footer-text-->	
    </body>
</html>



