<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.jpg">
		
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />	
	
		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/utils.js" lang=""></script>
	</head>
<body>
	<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_case"/>';</script>
	<jsp:include page="cabeceraPage.jsp"/>
	<form:form name="formEntidadCasoAlta" action="altaCaso" modelAttribute="caso" method="POST" onsubmit="javascript:return validaDatos();">
		<form:hidden path="sfid"/>		
		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">
					<label><s:message code="entidadCasoAlta_title_label_detalle_caso"/></label>
			</div>
			<div class="botoneraListado">
				<ul>
				<li><input type="submit" name="Guardar" value="<s:message code="entidadCasoAlta_button_guardar"/>" /></li>
				<li><input type="submit" name="GuardarYNuevo" value="<s:message code="entidadCasoAlta_button_guardarynuevo"/>" /></li>
				<li><input type="submit" name="Cancelar" value="<s:message code="entidadCasoAlta_button_cancelar"/>" /></li>
				</ul>
			</div>
		</div>
		<div id="divError" class="divError">
			<label><s:message code="entidadCasoAlta_error_datonovalidos"/></label>
			<br>
			<label><s:message code="entidadCasoAlta_error_revisemensajes"/></label>
			<br>
			<label id="errorMessage"></label>
		</div>
		<div id="divEntidadCasoAlta" class="divEntidad">
			<div class="subtittlePrincipalAltaEntidad">
				<div class="subtittlePrincipalAltaEntidadDivInfo"><label><s:message code="entidadCasoAlta_table_title_label_infoentidad"/></label></div>
				<div class="subtittlePrincipalAltaEntidadDivOblig">
					<div class="tittleObligatorio"></div>
					<label><s:message code="entidadCasoAlta_table_title_label_infoobligatorio"/></label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_motivo"/></label>
				</div>
				<div>
					<!--<form:select path="peticion" items="${caso.mapPeticion}"/>-->
					<label>${caso.peticionLabel}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_estado"/></label>
				</div>
				<div>
					<div class="divObligatorio"></div>
					<form:select path="estado" items="${caso.mapStatus}"/>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_canalorigen"/></label>
				</div>
				<div class="divAnchoEspecial">
					<label>${caso.canalOrigenLabel}</label>
				</div>
			</div>
			<div class="subtitleAltaEntidad">
				<div><label><s:message code="entidadCasoAlta_table_title_label_datosemergencia"/></label></div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_type"/></label>
				</div>
				<div>
					<label>${caso.typeLabel}</label>
				</div>
				<div class="divLabel"><label><s:message code="entidadCaso_table_label_description"/></label></div>
				<div>
					<form:textarea path="description"/>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_submotivo"/></label>
				</div>
				<div class="divAnchoEspecial">
					<form:select path="submotivo" items="${caso.mapSubMotivo}"/>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_condagravante"/></label>
				</div>
				<div class="divAnchoEspecial">
					<form:select path="condicionAgravante" items="${caso.mapCondicionAgravante}"/>
				</div>
			</div>
			<div class="subtitleAltaEntidad">
				<div><label><s:message code="entidadCasoAlta_table_title_label_identificacion"/></label></div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_suministro"/></label>
				</div>
				<div>
					<form:hidden path="suministro"/>
					<input type="text" id="numSumiRecuperado" disabled="disabled"/>
					<input type="button" id="botonLupaSuministro" class="lupa">					
					<input type="button" id="textSuministro" class="limpiarCampo" onclick="javascript:limpiarSuministro();" value="<s:message code="entidadCasoAlta_table_label_limpiar"/>"/>
				</div>
				<div class="divLabel"><label><s:message code="entidadCaso_table_label_canalNotificacion"/></label></div>
				<div>
					<form:select path="canalNotificacion" items="${caso.mapCanalNotificacion}"/>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_detalleDireccion"/></label>
				</div>
				<div>
					<form:hidden path="direccion"/>
					<input type="text" id="dirRecuperada" disabled="disabled"/>
					<input type="button" id="botonLupaSuministro" class="lupa">
					<input type="button" id=textDireccion class="limpiarCampo" onclick="javascript:limpiarDireccion();" value="<s:message code="entidadCasoAlta_table_label_limpiar"/>" />
				</div>
				<div class="divLabel"><label><s:message code="entidadCaso_table_label_telefonoContacto"/></label></div>
				<div>
					<form:input path="telefonoContacto"/>
				</div>
			</div>
			<div>
				<div class="divLabel">&nbsp;</div>
				<div>&nbsp;</div>
				<div class="divLabel"><label><s:message code="entidadCaso_table_label_emailNotificacion"/></label></div>
				<div>
					<form:input path="emailNotificacion"/>
				</div>
			</div>
			<div>
				<div class="divLabel">&nbsp;</div>
				<div>&nbsp;</div>
				<div class="divLabel"><label><s:message code="entidadCaso_table_label_idFacebook"/></label></div>
				<div>
					<form:input path="facebook"/>
				</div>
			</div>
			<div>
				<div class="divLabel">&nbsp;</div>
				<div>&nbsp;</div>
				<div class="divLabel"><label><s:message code="entidadCaso_table_label_twitter"/></label></div>
				<div>
					<form:input path="twitter"/>
				</div>
			</div>
			<div>
				<div class="divLabel">&nbsp;</div>
				<div>&nbsp;</div>
				<div class="divLabel"><label><s:message code="entidadCaso_table_label_actualizarDatosContacto"/></label></div>
				<div>
					<form:checkbox path="actDatosContacto"/>
				</div>
			</div>
			<div class="subtitleAltaEntidad">
				<div><label><s:message code="entidadCasoAlta_table_title_label_solucion"/></label></div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_title_label_respuestaCliente"/></label>
				</div>
				<div>
					<form:textarea path="respuestaAlCliente"/>
				</div>
				<div class="divLabel"><label><s:message code="entidadCaso_title_label_favoravilidadCaso"/></label></div>
				<div>
					<form:select path="favorabilidadDelCaso" items="${caso.mapFavorabilidadCaso}"/>
				</div>
			</div>
		</div>
		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">&nbsp;</div>
			<div class="botoneraListado botoneraBottom">
				<ul>
					<li><input type="submit" name="Guardar" value="<s:message code="entidadCasoAlta_button_guardar"/>" /></li>
					<li><input type="submit" name="GuardarYNuevo" value="<s:message code="entidadCasoAlta_button_guardarynuevo"/>" /></li>
					<li><input type="submit" name="Cancelar" value="<s:message code="entidadCasoAlta_button_cancelar"/>" /></li>
				</ul>
			</div>
		</div>
	</form:form>
</body>
</html>