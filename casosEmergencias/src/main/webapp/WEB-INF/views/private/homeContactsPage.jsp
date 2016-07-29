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
				<table id="tablaContactos" class="display" data-page-length="10" data-order="[[ 1, &quot;asc&quot; ]]">
					<thead>
			            <tr>
		            <!-- <th data-orderable="false"> -->
		           		<th width="20%"><s:message code="homeContacts_table_head_name"/></th>
			            <th width="16%"><s:message code="homeContacts_table_head_id"/></th>
			            <th width="16%"><s:message code="homeContacts_table_head_sfid"/></th>
			            <th width="16%"><s:message code="homeContacts_table_head_accountRun"/></th>
			            <th width="16%"><s:message code="homeContacts_table_head_phone"/></th>
			            <th width="16%"><s:message code="homeContacts_table_head_email"/></th>                               
		            	</tr>
	        		</thead>
	        	<tbody>
	        		<c:forEach items="${listaContactos}" var="datosContacto">
						<tr>
							<td>${datosContacto.name}</td>
							<td>${datosContacto.id}</td>
							<td>${datosContacto.sfid}</td>							
							<td>${datosContacto.accountRun}</td>
							<td>${datosContacto.phone}</td>
							<td>${datosContacto.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
	
    <script type="text/javascript" charset="utf-8">
    $(document).ready(function() {
		$('#tablaContactos').DataTable();			    
	});
	</script>
</body>
</html>