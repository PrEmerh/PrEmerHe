<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Emergencias App</title>		
	
	<link href="../resources/css/cabecera.css" rel="stylesheet" />
	<link href="../resources/css/body.css" rel="stylesheet" />	

	<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
	</head>
<body>
	<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_case"/>';</script>
	<jsp:include page="cabeceraPage.jsp"/>
	<form:form name="formEntidadCaso" action="actualizarCaso" modelAttribute="caso" method="POST">
		<form:hidden path="id"/>
		<form:hidden path="editMode"/>
		
		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">
					<input id="arrowDetalleCaso" type="image" src="../resources/images/Arrowdown.PNG"  height="15" onclick="showHideCabeceras('detalleCaso','arrowDetalleCaso'); return false;"/>				
					<label><s:message code="entidadCaso_title_label_detalle_caso"/></label>
			</div>
			<div class="botoneraEntidad">
				<ul>
					<li><input id="Modificar" type="button" name="Modificar" value="Modificar"  onclick="modificarButton();" /></li>
					<li><input id="Guardar" type="submit" name="Cancelar" value="Guardar" hidden=true/></li>
					<li><input id="Cancelar" type="button" name="Cancelar" value="Cancelar" hidden=true  onclick="cancelarButton();"/></li>
				</ul>
			</div>
		</div>
		<div id="detalleCaso" class="divEntidad">
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_motivo"/></label>
</div>
				<div>
					<label>${caso.peticion}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_estado"/></label>
				</div>
				<div>
					<label>${caso.estado}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_numcaso"/></label>
				</div>
				<div>
					<label>${caso.numeroCaso}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_subestado"/></label>
				</div>
				<div>
					<label>${caso.subestado}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_numinservice"/></label>
				</div>
				<div>
					<label>${caso.numeroInservice}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_canalorigen"/></label>
				</div>
				<div>
					<label>${caso.canalOrigen}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_fechahoraapertura"/></label>
				</div>
				<div>
					<label>${caso.fechaApertura}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_tiempoNormalizacion"/></label>
				</div>
				<div>
					<label>${caso.fechaEstimadaCierre}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_casoPrincipal"/></label>
				</div>
				<div>
					<label>${caso.parent}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_propietarioCaso"/></label>
				</div>
				<div>
					<label>${caso.propietarioCaso}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_fechaHoraCierre"/></label>
				</div>
				<div>
					<label>${caso.fechaCierre}</label>
				</div>
				<div>
						
				</div>
			</div>						
		</div>	
		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">
				<input id="arrowDatosEmergencia" type="image" src="../resources/images/Arrowdown.PNG"  height="15" onclick="showHideCabeceras('datosEmergencia','arrowDatosEmergencia'); return false;"/>				
				<b><label><s:message code="entidadCaso_title_label_datos_emergencia"/></label></b>
			</div>
		</div>
		<div id="datosEmergencia" class="divEntidad">
			<div>	
				<div >					
				</div>
				<div>						
				</div>	
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_description"/></label>
				</div>
				<div>
					<label id="fieldRead">${caso.description}</label>
					<label id="fieldEdit" style="display:none;"><input type='text' name='description' value="${caso.description}" class="buttontext" ></label>
				</div>		
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_submotivo"/></label>
				</div>
				<div>
					<label>${caso.submotivo}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_condagravante"/></label>
				</div>
				<div>
					<label>${caso.condicionAgravante}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_asunto"/></label>
				</div>
				<div>
					<label>${caso.asunto}</label>
				</div>
			</div>	
		</div>
		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">
			<input id="arrowIdentificacion" type="image" src="../resources/images/Arrowdown.PNG"  height="15" onclick="showHideCabeceras('Identificacion','arrowIdentificacion'); return false;"/>			
			<b><label><s:message code="entidadCaso_title_label_identificacion"/></label></b>
			</div>
		</div>	
		<div id="Identificacion" class="divEntidad">	
			<div>
			    <div >					
				</div>
				<div>						
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_nombreContacto"/></label>
				</div>
				<div>
					<label>${caso.contactoJoin.name}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_canalNotificacion"/></label>
				</div>
				<div>
					<label>${caso.canalNotificacion}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_suministro"/></label>
				</div>
				<div>
					<label>${caso.suministroJoin.numeroSuministro}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_telefonoContacto"/></label>
				</div>
				<div>
					<label>${caso.telefonoContacto}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_detalleDireccion"/></label>
				</div>
				<div>
					<label>${caso.direccionJoin.name}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_emailNotificacion"/></label>
				</div>
				<div>
					<label>${caso.emailNotificacion}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_nombreCuenta"/></label>
				</div>
				<div>
					<label>${caso.cuentaJoin.name}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_idFacebook"/></label>
				</div>
				<div>
					<label>${caso.facebook}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_direccionSuministro"/></label>
				</div>
				<div>
					<label>${caso.direccionSuministro}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_twitter"/></label>
				</div>
				<div>
					<label>${caso.twitter}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_comuna"/></label>
				</div>
				<div>
					<label>${caso.comuna}</label>					
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_actualizarDatosContacto"/></label>
				</div>
				<div>							
					<c:if test="${caso.actDatosContacto}">
				    <label> 
					<input type="checkbox" id="checkbox" value="true" checked="checked" disabled  />
					</label> 					
					</c:if> 
					<c:if test="${caso.actDatosContacto == 'false'}">
					<label> 
					<input type="checkbox" id="checkbox" value="true" disabled  />
					</label>	
					</c:if> 
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_numeroMedidor"/></label>
				</div>
				<div>
					<label>${caso.numeroMedidor}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_ani"/></label>
				</div>
				<div>
					<label>${caso.ani}</label>
				</div>
			</div>
		</div>
		

		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">
			<input id="arrowCuerpoMail" type="image" src="../resources/images/Arrowdown.PNG"  height="15" onclick="showHideCabeceras('cuerpoMail','arrowCuerpoMail'); return false;"/>
			<b><label><s:message code="entidadCaso_title_label_cuerpoMail"/></label></b>
			</div>
		</div>
		<div id="cuerpoMail" class="divEntidad">
			<div>
				<div >					
				</div>
				<div>						
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_title_label_cuerpoMail"/></label>
				</div>
				<div>
					<label>${caso.cuerpoMail}</label>
				</div>
				<div>
						
				</div>
			</div>
		</div>		
		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">
				<input id="arrowSolucion" type="image" src="../resources/images/Arrowdown.PNG"  height="15" onclick="showHideCabeceras('Solucion','arrowSolucion'); return false;"/>			
				<b><label><s:message code="entidadCaso_title_label_solucion"/></label></b>
			</div>
		</div>
		<div id="Solucion" class="divEntidad">
			<div>
				<div >					
				</div>
				<div>						
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_title_label_respuestaCliente"/></label>
				</div>
				<div>
					<label>${caso.respuestaAlCliente}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_title_label_favoravilidadCaso"/></label>
				</div>
				<div>
					<label>${caso.favorabilidadDelCaso}</label>
				</div>
			</div>
		</div>
	</form:form>
	
	<!-- Mostrar y esconder contenido de las pestañas -->
	
	<script type="text/javascript">
	function showHideCabeceras(idDiv,idArrow){
			var div =document.getElementById(idDiv);
			var arrow = document.getElementById(idArrow); 				
				if(div.style.visibility=='')  {
					div.style.visibility='hidden';
				arrow.src="../resources/images/Arrowright.PNG";
				}else{
				div.style.visibility='';
					arrow.src="../resources/images/Arrowdown.PNG";
				}					
	}

	
	
	// Modo edición
	
	function modificarButton(){
		
			var modificar =document.getElementById('Modificar');
			var guardar =document.getElementById('Guardar');
			var cancelar =document.getElementById('Cancelar');
			var descriptionEdit =document.getElementById('fieldEdit');
			var descriptionRead =document.getElementById('fieldRead');
			
			modificar.hidden=true;
			guardar.hidden=false;
			cancelar.hidden=false;		
			descriptionRead.style.display='none'; 
			descriptionEdit.style.display=''; 
	}
	
	
	function cancelarButton(){
		
		var modificar =document.getElementById('Modificar');
		var guardar =document.getElementById('Guardar');
		var cancelar =document.getElementById('Cancelar');
		var descriptionEdit =document.getElementById('fieldEdit');
		var descriptionRead =document.getElementById('fieldRead');
		
		modificar.hidden=false;
		guardar.hidden=true;
		cancelar.hidden=true;	
		descriptionRead.style.display='';
		descriptionEdit.style.display='none'; 
}

	
	
	
	
	
	</script>
	
	
	
  </body>
</html>