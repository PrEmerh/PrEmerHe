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
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_suministro"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<form:form name="formEntidadSuministro" action="actualizarSuministro" modelAttribute="suministro" method="POST">
			<form:hidden path="sfid"/>
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowDetalleSuministro" type="image" src="../resources/images/Arrowdown.PNG"  
							height="15" onclick="showHideCabeceras('detalleSuministro','arrowDetalleSuministro'); return false;"/>
						<b><label><s:message code="entidadSuministro_title_label_detalle_suministro"/></label></b>
					</div>
				</div>
			</div>
			<div id="detalleSuministro" class="divEntidad">
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_numeroSuministro"/></label>
					</div>
					<div>
						<label>${suministro.numeroSuministro}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_detalleDireccion"/></label>
					</div>
					<div>
						<label>${suministro.direccionConcatenada}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_direccionSuministro"/></label>
					</div>
					<div>
						<label>${suministro.direccionCliente}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_tipoSegmento"/></label>
					</div>
					<div>
						<label>${suministro.tipoSegmento}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_comuna"/></label>
					</div>
					<div>
						<label>${suministro.comuna}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_medidaDisciplina"/></label>
					</div>
					<div>
						<label>${suministro.medidaDisciplina}</label>
					</div>
				</div>
				<div>		
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_estadoSuministro"/></label>
					</div>	
					<div>
						<label>${suministro.labelEstadoSuministroPickList}</label>
					</div>
				</div>	
			</div>	
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowCuentaRelacionada" type="image" src="../resources/images/Arrowdown.PNG"  
							height="15" onclick="showHideCabeceras('cuentaRelacionada','arrowCuentaRelacionada'); return false;"/>
						<b><label><s:message code="entidadSuministro_title_label_cuenta_relacionada"/></label></b>								
					</div>
				</div>			
			</div>
			<div id="cuentaRelacionada" class="divEntidad">
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_cuenta"/></label>
					</div>
					<div>
						<label><a href="../private/entidadCuenta?sfid=${suministro.cuentaJoin.sfid}">${suministro.cuentaJoin.name}</a></label>
					</div>		
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_tipoCuenta"/></label>
					</div>
					<div>
						<label>${suministro.tipoCuenta}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_runRut"/></label>
					</div>
					<div>
						<label>${suministro.runRut}</label>
					</div>
				</div>	
			</div>
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowDatosSuministro" type="image" src="../resources/images/Arrowdown.PNG"  
							height="15" onclick="showHideCabeceras('datosSuministro','arrowDatosSuministro'); return false;"/>
						<b><label><s:message code="entidadSuministro_title_label_datos_suministro"/></label></b>
					</div>
				</div>
			</div>	
			<div id="datosSuministro" class="divEntidad">	
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_idEmpresa"/></label>
					</div>
					<div>
						<label>${suministro.labelEmpresaPickList}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_tarifa"/></label>
					</div>
					<div>
						<label>${suministro.tarifa}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_electrodependiente"/></label>
					</div>
					<div>
						<label>${suministro.electrodependiente}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_fullElectric"/></label>
					</div>
					<div>
						<label>${suministro.fullElectric}</label>
					</div>
				</div>			
			</div>
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowDatosComerciales" type="image" src="../resources/images/Arrowdown.PNG"  
							height="15" onclick="showHideCabeceras('datosComerciales','arrowDatosComerciales'); return false;"/>
						<b><label><s:message code="entidadSuministro_title_label_datos_comerciales"/></label></b>
					</div>
				</div>
			</div>
			<div id="datosComerciales" class="divEntidad">
				<div>	
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_nombreBoleta"/></label>
					</div>
					<div>
						<label>${suministro.nombreDuenoBoleta}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_direccionReparto"/></label>
					</div>
					<div>
						<label>${suministro.direccionBoleta}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_ruta"/></label>
					</div>
					<div>
						<label>${suministro.ruta}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_comunaReparto"/></label>
					</div>
					<div>
						<label>${suministro.comunaReparto}</label>
					</div>
				</div>
			</div>		
			<div class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>	
						<input id="arrowDatosTecnicos" type="image" src="../resources/images/Arrowdown.PNG"  
							height="15" onclick="showHideCabeceras('datosTecnicos','arrowDatosTecnicos'); return false;"/>			
						<b><label><s:message code="entidadSuministro_title_label_datos_tecnicos"/></label></b>
					</div>
				</div>
			</div>
			<div id="datosTecnicos" class="divEntidad">
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_propiedadMedidor"/></label>
					</div>
					<div>
						<label>${suministro.propiedadMedidor}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_modeloMedidor"/></label>
					</div>
					<div>
						<label>${suministro.modeloMedidor}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_marcaMedidor"/></label>
					</div>
					<div>
						<label>${suministro.marcaMedidor}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_numeroMedidor"/></label>
					</div>
					<div>
						<label>${suministro.numeroMedidor}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_numeroTransformador"/></label>
					</div>
					<div>
						<label>${suministro.numeroTransformador}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_tipoTransformador"/></label>
					</div>
					<div>
						<label>${suministro.tipoTransformador}</label>
					</div>
			    </div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_tipoConexion"/></label>
					</div>
					<div>
						<label>${suministro.tipoConexion}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_subestacionElectricaConexion"/></label>
					</div>
					<div>
						<label>${suministro.subestacionElectricaConexion}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_tipoMedida"/></label>
					</div>
					<div>
						<label>${suministro.tipoMedida}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_numeroAlimentador"/></label>
					</div>
					<div>
						<label>${suministro.alimentador}</label>
				    </div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_tipoLectura"/></label>
					</div>
					<div>
						<label>${suministro.tipoLectura}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_bloque"/></label>
					</div>
					<div>
						<label>${suministro.bloque}</label>
				    </div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadSuministro_title_label_horarioRacionamientio"/></label>
					</div>
					<div>
						<label>${suministro.horarioRacionamiento}</label>
					</div>
				</div>
			</div>
			<div id="divEntidadSuministroCasos" class="divEntidad">
				<div class="subtitleAltaEntidad">
					<div>
						<input id="arrowTablaContactoCasos" type="image" src="../resources/images/Arrowdown.PNG"  
							height="15" onclick="showHideCabeceras('tablaSuministroCasos','arrowTablaSuministroCasos'); return false;"/>			
						<label><s:message code="entidadCuenta_title_label_supply_data_detail" /></label>
					</div>
				</div>
				<div id="tablaSuministroCasos">
					<table class="basicTable">
						<tr>
							<th><s:message code="entidadSuministro_title_label_caso_caso" /></th>
						    <th><s:message code="entidadSuministro_title_label_caso_estado" /></th>
						    <th><s:message code="entidadSuministro_title_label_caso_fechaApertura" /></th>
						    <th><s:message code="entidadSuministro_title_label_caso_submotivo" /></th>
						    <th><s:message code="entidadSuministro_title_label_caso_tiempoEstimado" /></th>
						    <th><s:message code="entidadSuministro_title_label_caso_canalOrigen" /></th>
						</tr>
						<c:forEach items="${suministro.casos}" var="caso">
							<tr>
								<td><a href="../private/entidadCaso?editMode=VIEW&sfid=${caso.sfid}">${caso.numeroCaso}</a></td>
								<td>${caso.descripcionEstado}</td>
								<td>${caso.fechaApertura}</td>
								<td>${caso.labelSubmotivoPickList}</td>
								<td>${caso.tiempoEstimacion}</td>
								<td>${caso.labelCanalorigenPickList}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</form:form>			
 	</body>
</html>