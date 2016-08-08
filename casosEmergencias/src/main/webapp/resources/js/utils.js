// Mostrar y esconder contenido de las pestañas
function showHideCabeceras(idDiv,idArrow) {
	var div = document.getElementById(idDiv);
	var arrow = document.getElementById(idArrow); 				
	if (div.style.display == '')  {
		div.style.display = 'none';
		arrow.src="../resources/images/Arrowright.PNG";
	} else {
		div.style.display = '';
		arrow.src="../resources/images/Arrowdown.PNG";
	}
}

// Mostrar botones y datos para poder modificar un caso
function modificarButton() {
	var modificar = document.getElementById('Modificar');
	var guardar = document.getElementById('Guardar');
	var cancelar = document.getElementById('Cancelar');
	var descriptionEdit = document.getElementById('fieldEdit');
	var descriptionRead = document.getElementById('fieldRead');
	
	modificar.hidden = true;
	guardar.hidden = false;
	cancelar.hidden = false;		
	descriptionRead.style.display = 'none'; 
	descriptionEdit.style.display = ''; 
}

// Esconder botones y datos para poder modificar un caso
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

function validaDatos(){
	if (document.getElementById('suministro') && document.getElementById('suministro').value==''
		&& document.getElementById('direccion') && document.getElementById('direccion').value==''){
		document.getElementById('errorMessage').innerHTML= '<s:message code="entidadCasoAlta_error_sumiodire"/>';		    		
		document.getElementById('divError').style.display= 'block';
		return false;
	}
	return true;
}

function limpiarDireccion(){
	if (document.getElementById('direccion') && document.getElementById('direccion').value!=''){
		document.getElementById('direccion').value = '';
		document.getElementById('textDireccion').value = '';
	}
}

function limpiarSuministro(){
	if (document.getElementById('suministro') && document.getElementById('suministro').value!=''){
		document.getElementById('suministro').value = '';
		document.getElementById('textSuministro').value = '';
	}
}
