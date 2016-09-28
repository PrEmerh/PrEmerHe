//Crear caso por suministro
function goCrearCasoBySuministro(){	
	document.getElementById("cargandoGif").hidden=false;
	window.location="../private/goCrearCasoBySuministro";
}

//Crear caso corte por deuda
function crearCasoCorteDeuda(){	
	document.getElementById("cargandoGif").hidden=false;
	$.post( "../private/goCrearCasoBySuministroAndCorte",
		{causa: 'deuda', sfidSum: document.getElementById('sfidSum').value},
		function( data ) {
			if(data!=null){				
				var dataPartes = data.split("$");
				var dataCodigo = dataPartes[0]; 
				var dataMensaje = dataPartes[1]; 
				if(dataCodigo!=null && dataCodigo!=dataPartes && dataMensaje!=null){
					//window.location="../private/entidadSuministro?sfid=a0U5B000000DkEqUAK";
					if(document.getElementById('divInsertError') != null && document.getElementById('divInsertError').style.display=='block'){
						document.getElementById('divInsertError').style.display='none';
					}				
					document.getElementById("cargandoGif").hidden=true;
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
	
	document.getElementById("cargandoGif").hidden=false;
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
					document.getElementById("cargandoGif").hidden=true;
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
