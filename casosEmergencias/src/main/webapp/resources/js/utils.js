
// FUNCIONES ÚTILES PARA TODAS LAS PÁGINAS
function createUrl() {
	var miUrl = window.location.protocol + "//" + window.location.host;
	if (window.location.pathname.indexOf("/casosEmergencias/") != -1) {
		miUrl = miUrl + "/casosEmergencias";
	}
	return miUrl;
}

function showHideCabeceras(idDiv, idArrow) {
	var div = document.getElementById(idDiv);
	var arrow = document.getElementById(idArrow); 				
	if (div.style.display == '')  {
		div.style.display = 'none';
		arrow.src="../resources/images/arrow-right-black.png";
	} else {
		div.style.display = '';
		arrow.src="../resources/images/arrow-down-black.png";
	}
}

function showHideCabecerasServicios(idDiv, idArrow) {
	var div = document.getElementById(idDiv);
	var arrow = document.getElementById(idArrow); 				
	if (div.style.display == '')  {
		div.style.display = 'none';
		arrow.src="../resources/images/arrow-right-white.png";
	} else {
		div.style.display = '';
		arrow.src="../resources/images/arrow-down-white.png";
	}
}
//--------------------------------------------------------------------

// FUNCIONES PARA MODIFICAR UN CASO
function modificarButton() {
	var modificar = document.getElementById('Modificar');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	var datosEmergenciaDiv = document.getElementById('datosEmergencia');
	var arrowDatosEmergenciaDiv = document.getElementById('arrowDatosEmergencia');
	
	modificar.hidden = true;
	guardar.hidden = false;
	cancelar.hidden = false;	
	
	if (datosEmergenciaDiv.style.display == 'none'){
		datosEmergenciaDiv.style.display = '';
		arrowDatosEmergenciaDiv.src="../resources/images/arrow-down-black.png";
	}
	
	descriptionRead.style.display = 'none'; 
	descriptionEdit.style.display = ''; 
}

function cancelarButton() {
	var modificar = document.getElementById('Modificar');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	
	modificar.hidden = false;
	guardar.hidden = true;
	cancelar.hidden = true;	
	descriptionRead.style.display = '';
	descriptionEdit.style.display = 'none'; 
}

function checkUpdates() {
	if ($('#editMode').val() == 'UPDATED_OK') {
		$('#divCaseModifiedOk').show();
	} else if ($('#editMode').val() == 'UPDATED_ERROR') {
		$('#divCaseModifiedError').show();
	} else if ($('#editMode').val() == 'CREATED_OK') {
		$('#divCaseCommentCreated').show();
	} else if ($('#editMode').val() == 'CREATED_ERROR') {
		$('#divCaseCommentNOCreated').show();
	} else if ($('#editMode').val() == 'INSERTED_OK') {
		$('#divCaseCreatedOk').show();
	} else if ($('#editMode').val() == 'INSERTED_ERROR') {
	  $('#divCaseCreatedError').show();
	}
}

function showNotifications() {
	if ($('#divInsertError').length) {
		$('#divInsertError').show();
	} else if ($('#divInsertOk').length) {
		$('#divInsertOk').show();
	}
}
// FUNCIONES DE PÁGINA DE ALTA DE CASOS
function altaCaso() {
	var validado = true; //validaDatos();
	if (validado) {
		$('#formEntidadCasoAlta').submit();
		return true;
	} else {
		return false;
	}
}

function altaCasoYNuevo() {
	var validado = true; //validaDatos();
	if (validado) {
		$('#redirectToNewCase').val("true");
		$('#formEntidadCasoAlta').submit();
		return true;
	} else {
		return false;
	}
}

function checkCaseCommentCreation() {	
	if(document.getElementById('comment').value==''){
		$('#divCaseCommentNOCreated').show();		
	}
	else{
		document.getElementById('formComentarioCaso').submit();
	}

}

function validaDatos() {
	if (document.getElementById('suministro') && document.getElementById('suministro').value == ''
			&& document.getElementById('direccion') && document.getElementById('direccion').value == '') {
		document.getElementById('errorMessage').innerHTML= '<s:message code="entidadCasoAlta_error_sumiodire"/>';		    		
		document.getElementById('divError').style.display= 'block';
		return false;
	}
	return true;
}

function limpiarDireccion() {
	if (document.getElementById('direccion') && document.getElementById('direccion').value != '') {
		document.getElementById('direccion').value = '';
		document.getElementById('dirRecuperada').value = '';
	}
}

function limpiarSuministro() {
	if (document.getElementById('suministro') && document.getElementById('suministro').value != '') {
		document.getElementById('suministro').value = '';
		document.getElementById('numSumiRecuperado').value = '';
	}
}

function cargarDialogSuministro() {
	$('#dialogSuministro').dialog({
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "400",
		width: "750",
		resizable: false,
		create: function (event) {$(event.target).parent().css('position', 'fixed');}
	});
}

function cargarDialogDireccion() {
	$('#dialogDireccion').dialog({
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "400",
		width: "750",
		resizable: false,
		create: function (event) { $(event.target).parent().css('position', 'fixed');}
	});
}

function abrirDialogSuministro() {
	$("#dialogSuministro").dialog( {
		resizable: false,
		height: "auto",
		width: "60%"
	});	
	$("#dialogSuministro").dialog('open');	
	createTableSuministro();//Funcion de popupsTable.js, crea la tabla
}

function abrirDialogDireccion() {
	$("#dialogDireccion").dialog( {
		resizable: false,
		height: "auto",
		width: "60%"
	});	
	$("#dialogDireccion").dialog('open');
	createTableDireccion(); //Funcion de popupsTable.js, crea la tabla
}

function establecerSuministro(sfid, name,direccionSfid,direccionName) {
	document.getElementById('suministro').value = sfid;
	document.getElementById('numSumiRecuperado').value = name;
	if(direccionName!=null && direccionSfid!=null ){
		document.getElementById('direccion').value = direccionSfid;
		document.getElementById('dirRecuperada').value = direccionName;
	}
	$('#dialogSuministro').dialog('close');
}

function establecerDireccion(sfid, name) {
	document.getElementById('direccion').value = sfid;
	document.getElementById('dirRecuperada').value = name;
	$('#dialogDireccion').dialog('close');
}

//Crear caso por suministro

function goCrearCasoBySuministro(){	
	window.location="../private/goCrearCasoBySuministro";
}

//Crear caso por contacto

function goCrearCasoByContacto(){	
	window.location="../private/goCrearCasoByContacto";
}

/*Inici -- funciones Guardar y Cancelar Comentario de un Caso*/
function newComent(sfid){
	 window.location="../private/casoComentarioPage?sfid="+sfid;
}


function cancelComent(sfid){
	 window.location="../private/entidadCaso?editMode=VIEW&sfid="+sfid;
}
/*Fin -- funciones Guardar y Cancelar Comentario de un Caso*/


//Funcion Cancelar Alta de un Caso
function cancelAltaCaso(){
	
	window.location="../private/cancelAltaCaso";
	
	
}

//Limpieza campos del buscador.
function limpiarCamposBuscadorCasos() {
	if (document.getElementById('filtroNumCaso').value != '') {
		document.getElementById('filtroNumCaso').value = '';
	}
}

//Crear caso corte por deuda

function crearCasoCorteDeuda(){	
	
	$.post( "../private/goCrearCasoBySuministroAndCorte",
		{causa: 'deuda', sfidSum: document.getElementById('sfidSum').value},
		function( data ) {
			if(data!=null){	
				var dataPartes = data.split("$");
				var dataCodigo = dataPartes[0]; 
				var dataMensaje = dataPartes[1]; 
				if(dataCodigo!=null && dataCodigo!=dataPartes && dataMensaje!=null){
					if(document.getElementById('divInsertError') != null && document.getElementById('divInsertError').style.display=='block'){
						document.getElementById('divInsertError').style.display='none';
					}
					document.getElementById('idCodigo').innerText ="Código:"+" "+dataCodigo;
					document.getElementById('idMensaje').innerText ="Mensaje:"+" "+dataMensaje;
					document.getElementById('divCaseCorteCreatedError').style.display='block';					
				}
				else{				
					window.location=data;
				}
			}				
		}
	);
}

//Crear caso corte programado

function crearCasoCorteProgramado(){	
	
	$.post( "../private/goCrearCasoBySuministroAndCorte",
		{causa: 'progr', sfidSum: document.getElementById('sfidSum').value},
		function( data ) {
			if(data!=null){	
				var dataPartes = data.split("$");
				var dataCodigo = dataPartes[0]; 
				var dataMensaje = dataPartes[1]; 	
				if(dataCodigo!=null && dataCodigo!=dataPartes && dataMensaje!=null){
					if(document.getElementById('divInsertError') != null && document.getElementById('divInsertError').style.display=='block'){
						document.getElementById('divInsertError').style.display='none';
					}
					document.getElementById('idCodigo').innerText ="Código:"+" "+dataCodigo;
					document.getElementById('idMensaje').innerText ="Mensaje:"+" "+dataMensaje;
					document.getElementById('divCaseCorteCreatedError').style.display='block';
				}
				else{				
					window.location=data;
				}
			}				
		}
	);
}
