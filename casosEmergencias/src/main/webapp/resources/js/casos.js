// FUNCIONES PARA MODIFICAR UN CASO
function modificarCasoButton() {
	var modificar = document.getElementById('Modificar');
	var cancelarCaso = document.getElementById('CancelarCaso');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	var datosEmergenciaDiv = document.getElementById('datosEmergencia');
	var arrowDatosEmergenciaDiv = document.getElementById('arrowDatosEmergencia');
	
	modificar.hidden = true;
	cancelarCaso.hidden = true;
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
	var cancelarCaso = document.getElementById('CancelarCaso');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	
	modificar.hidden = false;
	cancelarCaso.hidden = false;
	guardar.hidden = true;
	cancelar.hidden = true;	
	descriptionRead.style.display = '';
	descriptionEdit.style.display = 'none'; 
}

function cargarDialogCancelacion() {
	$("#dialogCancelarCaso").dialog({
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "150",
		width: "350",
		position:{
			my: "center", 
			at: "center",
			of: window 
		},
		
		//resizable: false,
		create: function (event) {}
	});
}

function cancelarCasoButton() {
	$('#subEstadoCanceladion');
	
	
	$('#dialogCancelarCaso').dialog('open');	
	//createTableSuministro();//Funcion de popupsTable.js, crea la tabla
	
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


/*Inicio -- Funciones Comentario de un caso*/
function checkCaseCommentCreation() {	
	if(document.getElementById('comment').value==''){
		$('#divCaseCommentNOCreated').show();		
	}
	else{
		document.getElementById('formComentarioCaso').submit();
	}

}

function newComent(sfid){
	 window.location="../private/casoComentarioPage?sfid="+sfid;
}


function cancelComent(sfid){
	 window.location="../private/entidadCaso?editMode=VIEW&sfid="+sfid;
}
/*Fin -- Funciones Comentario de un caso*/


/*Inicio -- Funciones Alta de un caso*/
function cancelAltaCaso(){
	window.location="../private/cancelAltaCaso";	
}

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
/*Fin -- Funciones Alta de un caso*/