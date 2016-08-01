<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
		
		<div id="cabeceraEnel">
			<div id="divImagenEnel">
				<img src="../resources/images/logo.png" id="logoEnel" />
			</div>
			<div id="divNoImagenEnel">
				<a href="#"><s:message code="cabeceraPage_href_exit"/></a>
			</div>
		</div>
		<div id="menuCabecera">
			<div id="posicionamiento">
				<div style="float:left;">
				<!-- <img src="../resources/images/caso.png" id="imgGeneralMenu" /> -->
				</div>
				<div style="float:left;">
				<label id="lblMenu"><s:message code="cabeceraPage_label_case"/></label>
				</div>
			</div>
			<div id="desplegable">
				<div class="menuListado" onclick="javascript:cambiarLabel('<s:message code="cabeceraPage_label_case"/>');">
					<!-- <img src="../resources/images/caso.png" id="imgCasoMenu" /> -->
					<a href="homeCasos" ><s:message code="cabeceraPage_list_case"/></a>
				</div>
				<div class="menuListado" onclick="javascript:cambiarLabel('<s:message code="cabeceraPage_list_contact"/>');">
					<a href="homeContacts"><s:message code="cabeceraPage_list_contact"/></a>
				</div>
				<div class="menuListado" onclick="javascript:cambiarLabel('Suministros');">
					<a href="#"><s:message code="cabeceraPage_list_suministro"/></a>
				</div>
				<div class="menuListado" onclick="javascript:cambiarLabel('Direcciones');">
					<a href="#"  ><s:message code="cabeceraPage_list_direcction"/></a>
				</div>
				<div class="menuListado" onclick="javascript:cambiarLabel('Cuentas');">
					<a href="#" ><s:message code="cabeceraPage_list_cuentas"/></a>
				</div>
			</div>
			<div id="divBotonDesplegable">			
				<input type="button" id="botonDesplegable" name="botonDesplegable" style="align:right;">
			</div>
			<div id="divTabs">
			&nbsp;
			</div>
		</div>
		
		<script type="text/javascript">
			$(document).ready(function() {
			    $("#botonDesplegable").click(function(){
			    	desplegarMenu();
			    });
			    $(".menuListado").click(function(){
			    	desplegarMenu();
			    });
			    var divLista = $('#desplegable');
			    var botonDes = $("#botonDesplegable");
			    $(document).bind('click',function(event){
			    	if(divLista.is(':visible') && event.target != divLista[0]
			    	 && event.target != botonDes[0]){
			    		$('#desplegable').hide();
			    	}
			    });
			    function desplegarMenu(){
			    	if(divLista.is(':visible')){
			    		$('#desplegable').hide();
			    	}else{
			    		$('#desplegable').show();
			    	}
			    }
			});
			function cambiarLabel(valorMenu){
				var label = objetoSeleccionado;
				if (valorMenu != null && valorMenu != 'undefined' && valorMenu != ''){
					label = valorMenu;
				}
				document.getElementById('lblMenu').innerHTML= label;
			}
		</script>
