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
					<label><s:message code="entidadCaso_title_label_detalle_caso"/></label>
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
					<label><s:message code="entidadCaso_table_label_unidad"/></label>
				</div>
				<div>
					<label>${caso.callCenter}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_tiempoestimadonorma"/></label>
				</div>
				<div>
					<label>${caso.fechaEstimadaCierre}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCaso_table_label_casoprincipal"/></label>
				</div>
				<div>
					<label>${caso.parentid}</label>
				</div>
			</div>
		</div>	
	</form:form>
</body>
</html>