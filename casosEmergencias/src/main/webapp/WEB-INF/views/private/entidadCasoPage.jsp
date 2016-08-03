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
		<form:hidden path="sfid"/>
		<form:hidden path="editMode"/>
		
		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">
					<b><label><s:message code="entidadCaso_title_label_detalle_caso"/></label></b>
			</div>
			<div class="botoneraEntidad">
				<ul>
					<li><input type="submit" name="Guardar" value="Guardar" /></li>
					<li><input type="submit" name="Cancelar" value="Cancelar" /></li>
				</ul>
			</div>
		</div>
		<div id="divEntidadCaso" class="divEntidad">
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_motivo"/></label>
				</div>
				<div>
					<label>${caso.motivo}</label>
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
					<label>${caso.fechaEstimadoNormalizacion}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_casoPrincipal"/></label>
				</div>
				<div>
					<label>${caso.casoPrincipal}</label>
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
				<b><label><s:message code="entidadCaso_title_label_datos_emergencia"/></label></b>
			</div>
		</div>
		<div id="divEntidadContacto" class="divEntidad">
			<div>	
				<div >					
				</div>
				<div>						
				</div>	
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_description"/></label>
				</div>
				<div>
					<label>${caso.description}</label>
				</div>		
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_submotivo"/></label>
				</div>
				<div>
					<label>${caso.subMotivo}</label>
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
			<b><label><s:message code="entidadCaso_title_label_identificacion"/></label></b>
			</div>
		</div>	
		<div id="divEntidadContacto" class="divEntidad">	
			<div>
			    <div >					
				</div>
				<div>						
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_nombreContacto"/></label>
				</div>
				<div>
					<label>${caso.contacto}</label>
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
					<label>${caso.suministro}</label>
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
					<label>${caso.direccion}</label>
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
					<label>${caso.cuenta}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_idFacebook"/></label>
				</div>
				<div>
					<label>${caso.idFacebook}</label>
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
					<label>${caso.actualizarDatosContancto}</label>
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
			<b><label><s:message code="entidadCaso_title_label_cuerpoMail"/></label></b>
			</div>
		</div>
		<div id="divEntidadContacto" class="divEntidad">
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
				<b><label><s:message code="entidadCaso_title_label_solucion"/></label></b>
			</div>
		</div>
		<div id="divEntidadContacto" class="divEntidad">
			<div>
				<div >					
				</div>
				<div>						
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_title_label_respuestaCliente"/></label>
				</div>
				<div>
					<label>${caso.respuestaCliente}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_title_label_favoravilidadCaso"/></label>
				</div>
				<div>
					<label>${caso.favorabilidadCaso}</label>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>