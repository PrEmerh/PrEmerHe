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
		</div>
		<div id="divEntidadCuentaContactos" class="divEntidad">
			<div class="divTituloCuentaContactoss">
				<label><s:message code="entidadCuenta_title_label_contacts_data_detail" /></label>
			</div>
		</div>
	</body>
</html>