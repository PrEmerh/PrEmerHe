<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.casosemergencias.util.Constantes" %>

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
		<script src="../resources/js/casos.js"></script>
	</head>
	<body>
		<script type="text/javascript">var objetoSeleccionado="<s:message code="cabeceraPage_list_case"/>";</script>
		<jsp:include page="cabeceraPage.jsp"/>
		 
		<form name="formListadoCasos" action="homeCasosAction" method="POST">
			<div class="botoneraListado">
				<ul>
					<li><input type="submit" name="goCrearCaso" value="<s:message code="homeCasos_button_nuevocaso"/>" /></li>
				</ul>
			</div>
			<div>
				<input class="column_filter" id="col0_filter" type="text" value="">
				<input class="column_filter" id="search" type="button" value="Buscar">
				<input type="radio" name="radios" value="rd1" checked>Numero Casos        
            	<input type="radio" name="radios" value="rd2"> Todos
            	<table id="tablaCasos" class="display" style="width: 100%;"> 
					<thead>
			            <tr>
			            <!-- <th data-orderable="false"> -->
			                <th width="20%"><s:message code="homeCasos_table_head_numCasos"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_numInservice"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_canalOrigen"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_estado"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_subestado"/></th>
			                <th width="16%"><s:message code="homeCasos_table_head_submotivo"/></th>
			                <th width="1%" hidden="true">sfid</th>
			            </tr>
		        	</thead>
				</table>
			</div>
		</form>
	</body>
</html>