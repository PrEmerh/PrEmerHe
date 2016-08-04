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
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_case"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		 
		<form name='formListadoCasos' action="homeCasosAction" method='POST'>
			<div class="botoneraListado">
				<ul>
					<li><input type="submit" name="goCrearCaso" value="<s:message code="homeCasos_button_nuevocaso"/>" /></li>
				</ul>
			</div>
				<table id="tablaSuministros" class="display" data-page-length="10" data-order="[[ 1, &quot;asc&quot; ]]">
					<thead>
			            <tr>
			            <!-- <th data-orderable="false"> -->
			            	<th width="20%"><s:message code="homeSuministros_table_head_nombreSuministro"/></th>
			                <th width="20%"><s:message code="homeSuministros_table_head_estadoConexion"/></th>
			                <th width="20%"><s:message code="homeSuministros_table_head_estadoSuministro"/></th>
			                <th width="20%"><s:message code="homeSuministros_table_head_direccion"/></th>
			                <th width="20%"><s:message code="homeSuministros_table_head_comuna"/></th>
			                
			            </tr>
		        	</thead>
		        	<tbody>
		        		<c:forEach items="${suministros}" var="datosSuministro">
							<tr>
								<a href="entidadSuministro?sfid=${datosSuministro.sfid}"><td>${datosSuministro.name}</td></a>
								<td>${datosSuministro.estadoConexion}</td>
								<td>${datosSuministro.estadoSuministro}</td>
								<td>${datosSuministro.direccion}</td>
								<td>${datosSuministro.comuna}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
		
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
			    $('#tablaSuministros').DataTable({
		        "scrollY":        "250px",
		        "scrollCollapse": true,
		        "paging":         true
			});
		});
		</script>
	</body>
</html>