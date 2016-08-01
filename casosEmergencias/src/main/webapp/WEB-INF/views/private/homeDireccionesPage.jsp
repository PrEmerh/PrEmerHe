<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Emergencias App</title>		
		
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />
		<link href="../resources/css/jQueryDatatable.css" rel="stylesheet" />	

		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/jQueryDatatables.js"></script>
		
		
	</head>
	<body>
		<jsp:include page="cabeceraPage.jsp"/>
		 
		<form name='formListadoCasos' action="listar" method='POST'>
			<div class="botoneraListado">
				<ul>
					<li><input type="submit" name="insertar" value="CrearCaso" /></li>
					<li><input type="submit" name="actualizar" value="Actualizar" /></li>
				</ul>
			</div>
			<div>
				<table id="tablaDirecciones" class="display" data-page-length="10" data-order="[[ 1, &quot;asc&quot; ]]">
					<thead>
			            <tr>
		            <!-- <th data-orderable="false"> -->
		           		<th width="20%"><s:message code="homeDirecciones_table_head_codigoDireccion"/></th>
			            <th width="16%"><s:message code="homeDirecciones_table_head_calle"/></th>
			            <th width="16%"><s:message code="homeDirecciones_table_head_numero"/></th>
			            <th width="16%"><s:message code="homeDirecciones_table_head_comuna"/></th>
			            <th width="16%"><s:message code="homeDirecciones_table_head_direccionConcatenada"/></th>
		            	</tr>
	        		</thead>
	        	<tbody>
	        		<c:forEach items="${listaDirecciones}" var="datosDireccion">
						<tr>
							<td>${datosDireccion.name}</td>						
							<td>${datosDireccion.calle}</td>
							<td>${datosDireccion.numero}</td>
							<td>${datosDireccion.comuna}</td>
							<td>${datosDireccion.direccionConcatenada}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
	
    <script type="text/javascript" charset="utf-8">
    $(document).ready(function() {
		$('#tablaDirecciones').DataTable();			    
	});
	</script>
</body>
</html>