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
	<form:form name="formEntidadCasoAlta" action="altaCaso" modelAttribute="caso" method="POST">
		<form:hidden path="sfid"/>		
		<div class="divCabeceraEntidad">
			<div class="divTituloEntidad">
					<label><s:message code="entidadCasoAlta_title_label_detalle_caso"/></label>
			</div>
			<div class="botoneraEntidad">
				<ul>
					<li><input type="submit" name="Guardar" value="Guardar" /></li>
					<li><input type="submit" name="Cancelar" value="Cancelar" /></li>
				</ul>
			</div>
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
			<div class="subtittleAltaEntidad">
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
		</div>	
	</form:form>
</body>
</html>