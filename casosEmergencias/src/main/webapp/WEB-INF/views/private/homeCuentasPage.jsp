<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Emergencias App</title>		
		
		<link rel="icon" type="image/png" href="../resources/images/favicon.jpg">
		
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />
		<link href="../resources/css/jQueryDatatable.css" rel="stylesheet" />	

		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
		<script src="../resources/js/jQueryDatatables.js"></script>
	</head>
	<body>
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_cuentas"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		 
		<form name='formListadoCasos' action="listar" method='POST'>
			<div class="botoneraListado">
				<ul>
					<li><input type="submit" name="goCrearCaso" value="<s:message code="homeCasos_button_nuevocaso"/>" /></li>
				</ul>
			</div>
			<div>
				<table id="tablaCuentas" class="display" data-page-length="10" data-order="[[ 1, &quot;asc&quot; ]]">
					<thead>
			            <tr>
		            <!-- <th data-orderable="false"> -->
		           		<th width="20%"><s:message code="homeCuentas_table_head_name"/></th>
			            <th width="16%"><s:message code="homeCuentas_table_head_emailPrincipal"/></th>
			            <th width="16%"><s:message code="homeCuentas_table_head_phone"/></th>
<%-- 			        <th width="16%"><s:message code=#homeCuentas_table_head_*=Tipo de registro de cuenta/></th>    --%>                            
		            	</tr>
	        		</thead>
	        	<tbody>
	        		<c:forEach items="${listaCuentas}" var="datosCuenta">
						<tr>
							<td><a href="../private/entidadCuenta?sfid=${datosCuenta.sfid}">${datosCuenta.name}</a></td>
							<td>${datosCuenta.emailPrincipal}</td>
							<td>${datosCuenta.phone}</td>
							<%-- <td>${datosCuenta.tiporgistrocuenta}</td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
	
    <script type="text/javascript" charset="utf-8">
    $(document).ready(function() {
		$('#tablaCuentas').DataTable({
        "scrollY":        "250px",
        "scrollCollapse": true,
        "paging":         true		
		});
	});
	</script>
</body>
</html>