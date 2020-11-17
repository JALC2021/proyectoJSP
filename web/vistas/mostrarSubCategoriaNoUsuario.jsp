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
        <script src="js/responsiveslides.min.js"></script>
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
                    <ul>
                        <s:iterator value="listaSubCategoria">                      
                            <s:hidden value="idSubCategoria"/>
                            <s:url action="../actions/listadoSubcategoriaProducto" var="urlTag" >
                                <s:param name="idSubCategoria" value="%{idSubCategoria}"></s:param>
                            </s:url>
                            <li class="grid"><a href="<s:property value="#urlTag" />"> <s:property value="nombre"/></a></li>
                            </s:iterator>  
                    </ul>
                </div>

            </div>
        </div>
        <!--end-shoes-->
        <!--start-abt-shoe-->
        <!--<div class="abt-shoe">
            <div class="container"> 
                <div class="abt-shoe-main">
                    <div class="col-md-4 abt-shoe-left">
                        <div class="abt-one">
                            <a href="single.html"><img src="images/abt-1.jpg" alt="" /></a>
                            <h4><a href="single.html">Ultimo producto en venta</a></h4>
                            <p>Aquí aparecerá el ultimo producto puesto en venta</p>
                        </div>
                    </div>
                    <div class="col-md-4 abt-shoe-left">
                        <div class="abt-one">
                            <a href="single.html"><img src="images/abt-2.jpg" alt="" /></a>
                            <h4><a href="single.html">Penultimo producto puesto en venta</a></h4>
                            <p>Aquí aparecerá el penultimo producto puesto en venta </p>
                        </div>
                    </div>
                    <div class="col-md-4 abt-shoe-left">
                        <div class="abt-one">
                            <a href="single.html"><img src="images/abt-3.jpg" alt="" /></a>
                            <h4><a href="single.html">Antepenultimo producto puesto en venta</a></h4>
                            <p>Aquí aparecerá el antepenultimo producto puesto en venta</p>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>-->
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
                            <li><a href="account.html">Your Account</a></li>
                            <li><a href="#">Personal Information</a></li>
                            <li><a href="contact.html">Addresses</a></li>
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
