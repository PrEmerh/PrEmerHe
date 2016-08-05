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
		<script type="text/javascript">var objetoSeleccionado='<s:message code="cabeceraPage_list_contact"/>';</script>
		<jsp:include page="cabeceraPage.jsp"/>
		<form:form name="formEntidadContacto" action="actualizarContacto" modelAttribute="contacto" method="POST">
			<form:hidden path="sfid"/>
	
			
			<div class="divCabeceraEntidad">
				<div class="divTituloEntidad">
						<input id="arrowInformacionPersonal" type="image" src="../resources/images/Arrowdown.PNG"  height="15" onclick="showHideCabeceras('informacionPersonal','arrowInformacionPersonal'); return false;"/>										
						<b><label><s:message code="entidadContacto_title_label_informacion_personal"/></label></b>
				</div>
			</div>
			
			<div id="informacionPersonal" class="divEntidad">
				<div>
					<div >					
					</div>
					<div>						
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_nombre"/></label>
					</div>
					<div>
						<label>${contacto.name}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_apellidoPaterno"/></label>
					</div>
					<div>
						<label>${contacto.apellidoPaterno}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_apellidoMaterno"/></label>
					</div>
					<div>
						<label>${contacto.apellidoMaterno}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_tipoIdentidad"/></label>
					</div>
					<div>
						<label>${contacto.tipoIdentidad}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_run"/></label>
					</div>
					<div>
						<label>${contacto.accountRun}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_canalPreferenteContacto"/></label>
					</div>
					<div>
						<label>${contacto.canalPreferenteContacto}</label>
					</div>
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_telefonoPrincipal"/></label>
					</div>
					<div>
						<label>${contacto.phone}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_telefonoSecundario"/></label>
					</div>
					<div>
						<label>${contacto.telefonoSecundario}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_emailPrincipal"/></label>
					</div>
					<div>
						<label>${contacto.email}</label>
					</div>
					<div>
						
					</div>
				</div>
			</div>	
			
			<div class="divCabeceraEntidad">
				<div class="divTituloEntidad">
						<input id="arrowInformacionSecundaria" type="image" src="../resources/images/Arrowdown.PNG"  height="15" onclick="showHideCabeceras('informacionSecundaria','arrowInformacionSecundaria'); return false;"/>							
						<b><label><s:message code="entidadContacto_title_label_informacion_secundaria"/></label></b>
				</div>
			</div>
			<div id="informacionSecundaria" class="divEntidad">
				<div>
					<div >					
					</div>
					<div>						
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_fechaNacimiento"/></label>
					</div>
					<div>
						<label>${contacto.fechaNacimiento}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_nombreCuenta"/></label>
					</div>
					<div>
						<label><%-- ${contacto.nombrecuenta} --%></label>
					</div>  
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_direccionContacto"/></label>
					</div>
					<div>
						<label>${contacto.dirContacto}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_emailSecundario"/></label>
					</div>
					<div>
						<label>${contacto.emailSecundario}</label>
					</div>
				</div>				
			</div>
			
			<div class="divCabeceraEntidad">
				<div class="divTituloEntidad">
				
						<input id="arrowDatosRSS" type="image" src="../resources/images/Arrowdown.PNG"  height="15" onclick="showHideCabeceras('datosRSS','arrowDatosRSS'); return false;"/>					
						<b><label><s:message code="entidadContacto_title_label_datos_rrss"/></label></b>
				</div>
			</div>
			<div id="datosRSS" class="divEntidad">
				<div>
					<div >					
					</div>
					<div>						
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_nombreUsuarioTwitter"/></label>
					</div>
					<div>
						<label>${contacto.sf4twitterTwitterUsername}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_recuentoSeguidoresTwitter"/></label>
					</div>
					<div>
						<label><%-- ${contacto.recuentoSeguidoresTwitter} --%></label>
					</div>  
				</div>
				<div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_influencer"/></label>
					</div>
					<div>
						<label><%-- ${contacto.influencer} --%></label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_influencerType"/></label>
					</div>
					<div>
						<label><%-- ${contacto.influencerType} --%></label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_biografiaTwitter"/></label>
					</div>
					<div>
						<label><%-- ${contacto.biografiaTwitter} --%></label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_idUsuarioTwitter"/></label>
					</div>
					<div>
						<label>${contacto.sf4twitterTwitterUserId}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_nombreUsuarioFacebook"/></label>
					</div>
					<div>
						<label>${contacto.sf4twitterFcbkUsername}</label>
					</div>
					<div class="divLabel">
						<label><s:message code="entidadContacto_table_label_idUsuarioFacebook"/></label>
					</div>
					<div>
						<label>${contacto.sf4twitterFcbkUserId}</label>
					</div>
				</div>				
			</div>				

		</form:form>	
		<script type="text/javascript">
		function showHideCabeceras(idDiv,idArrow){
				var div =document.getElementById(idDiv);
				var arrow = document.getElementById(idArrow); 				
					if(div.style.visibility=='')  {
						div.style.visibility='hidden';
					arrow.src="../resources/images/Arrowright.PNG";
					}else{
					div.style.visibility='';
						arrow.src="../resources/images/Arrowdown.PNG";
					}					
		}
	</script> 			
	</body>
</html>