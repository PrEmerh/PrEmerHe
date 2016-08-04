<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Emergencias App</title>
		<link href="../resources/css/cabecera.css" rel="stylesheet" />
		<link href="../resources/css/body.css" rel="stylesheet" />
		<link href="../resources/css/styles.css" rel="stylesheet" />
		<script src="../resources/js/jquery-1.12.3.js" lang=""></script>
	</head>
	<body>
		<script type="text/javascript">
			var objetoSeleccionado = '<s:message code="entidadCuenta_title_label_account_detail"/>';
		</script>
		<jsp:include page="cabeceraPage.jsp" />
		<div class="divCabeceraCuenta">
			<div class="divTituloCuenta">
				<label><s:message code="entidadCuenta_title_label_person_data_detail" /></label>
			</div>
		</div>
		<div id="divEntidadCuenta" class="divEntidad">
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_account_name" /></label>
				</div>
				<div>
					<label>${cuenta.name}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_birthdate" /></label>
				</div>
				<div>
					<label>${cuenta.fechaNacimiento}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_first_name" /></label>
				</div>
				<div>
					<label>${cuenta.apellidoPaterno}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_run" /></label>
				</div>
				<div>
					<label>-</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_last_name" /></label>
				</div>
				<div>
					<label>${cuenta.apellidoMaterno}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_first_email" /></label>
				</div>
				<div>
					<label>${cuenta.emailPrincipal}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_first_phone" /></label>
				</div>
				<div>
					<label>${cuenta.phone}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_second_email" /></label>
				</div>
				<div>
					<label>${cuenta.emailSecundario}</label>
				</div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_second_phone" /></label>
				</div>
				<div>
					<label>${cuenta.telefonoSecundario}</label>
				</div>
				<div class="divLabel">
				</div>
				<div></div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_identity_type" /></label>
				</div>
				<div>
					<label>${cuenta.tipoIdentidad}</label>
				</div>
				<div class="divLabel">
				</div>
				<div></div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_address" /></label>
				</div>
				<div>
					<label>${cuenta.direccion}</label>
				</div>
				<div class="divLabel">
				</div>
				<div></div>
			</div>
			<div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_main_account" /></label>
				</div>
				<div>
					<label>${cuenta.accountsource}</label>
				</div>
				<div class="divLabel">
					<label><s:message code="entidadCuenta_title_label_company_id" /></label>
				</div>
				<div>
					<label>${cuenta.idEmpresa}</label>
				</div>
			</div>
		</div>
		<div id="divEntidadCuentaSuministros" class="divEntidad">
			<div class="divTituloCuentaSuministros">
				<label><s:message code="entidadCuenta_title_label_supply_data_detail" /></label>
			</div>
			<div>
				<table id="tablaCuentaSuministros" class="basicTable">
					<tr>
						<th><s:message code="entidadCuenta_title_label_supply_number" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_company_id" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_connection_status" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_supply_status" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_electrodependent" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_powercut_date" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_supply_address" /></th>
					    <th><s:message code="entidadCuenta_title_label_supply_commune" /></th>
					</tr>
					<c:forEach items="${cuenta.suministros}" var="suministro">
						<tr>
							<td>${suministro.name}</td>
							<td>${suministro.idEmpresa}</td>
							<td>${suministro.estadoConexion}</td>
							<td>${suministro.estadoSuministro}</td>
							<td>${suministro.electrodependiente}</td>
							<td>${suministro.fechaCorte}</td>
							<td>${suministro.direccion}</td>
							<td>${suministro.comuna}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div id="divEntidadCuentaContactos" class="divEntidad">
			<div class="divTituloCuentaContactoss">
				<label><s:message code="entidadCuenta_title_label_contact_data_detail" /></label>
			</div>
			<table id="tablaCuentaContactos" class="basicTable">
				<tr>
					<th><s:message code="entidadCuenta_title_label_contact_name" /></th>
				    <th><s:message code="entidadCuenta_title_label_contact_run" /></th>
				    <th><s:message code="entidadCuenta_title_label_contact_main_telephone" /></th>
				    <th><s:message code="entidadCuenta_title_label_contact_main_email" /></th>
				</tr>
				<c:forEach items="${cuenta.contactos}" var="contacto">
					<tr>
						<td>${contacto.name}</td>
						<td>${contacto.accountRun}</td>
						<td>${contacto.phone}</td>
						<td>${contacto.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>