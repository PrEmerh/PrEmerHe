var tableSum;
var tableDir
var urlTable = createUrl();

function funcionOnload(){
	initHeader(); 
	showNotifications(); 
	cargarAsociarSuministro();
	cargarCrearCasoPorDireccion();
	checkUpdates();
}

//Crear caso por contacto
function goCrearCasoByContacto(){
	verCargando();
	window.location="../private/goCrearCasoByContacto";
}

function ocultarNotificacion(){
	$('#divInsertError').hide();
}

//Cargamos el dialog para asociar suministro a un contacto
function cargarCrearCasoPorDireccion() {
	$("#dialogCrearCasoPorDireccion").dialog({
		resizable: false,
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "auto",
		width: "40%",
		position:{
			my: "center center", 
			at: "center center",
			of: $('#divEntidadContactoSuministros') 
		},
		create: function (event) {}
	});
}

//Cargamos el dialog para crear caso por Direcciom
function cargarAsociarSuministro() {
	$("#dialogAsociarSuministroContacto").dialog({
		resizable: false,
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "auto",
		width: "40%",
		position:{
			my: "center center", 
			at: "center center",
			of: $('#divEntidadContactoSuministros') 
		},
		create: function (event) {}
	});
}

function abrirAsociarSuministro(){
	ocultarNotificacion();
	$("#dialogAsociarSuministroContacto").dialog('open');
	$('#divAssociationErrorSearch').hide();
	cargarTablaSuministros();
}

function cargarTablaSuministros(){
	if(tableSum == null){
		var formulario = $('#asociarSuministroId');
		
		tableSum = $('#tablaSuministros').DataTable({
	       	"scrollY": "250px",
			"scrollX": false,
			"scrollCollapse": true,
			"paging": false,
			"serverSide": true,
		    "ordering": false,	    
			"processing": true, 
	        "language": {
	        	processing:  "<img src='../resources/images/loading.gif' width='25' > Cargando...",
	            lengthMenu: "",
	            info: "",
	            infoEmpty: "",
	            infoFiltered: "",
	            zeroRecords:"",
	            emptyTable:"No se han encontrado registros"
	        },
	        "lengthChange": false,
	        "deferRender": true,
	        "deferLoading": -1,
			"ajax": { 
	        	"type": formulario.attr('method'),
	        	 "url": formulario.attr('action'), 	               	
	        	 "contentType": 'application/json; charset=utf-8' ,
	        	 "error": function(data) {
	        		 alert('Se ha producido un error obteniendo la lista de suministros. Repita la operaci&oacute;n y, si el error persiste, contacte con el administrador de la plataforma.');
	        	 }
	      	},
	       	"columns": [
	       	            {data: "name", width: "18%", defaultContent: "", orderable: false}, 
	       	            {data: "direccionConcatenada", width: "31%", defaultContent: "", orderable: false},
	       	            {data: "comuna", width: "15%", defaultContent: "", orderable: false},
	       	            {data: "estadoSuministroPickList", width: "18%", defaultContent: "", orderable: false},
	       	            {data: "empresaPickList", width: "15%", defaultContent: "", orderable: false},
	       	            {data: "sfid", width: "1%", defaultContent: "", visible: false, orderable: false},
	       	            {data: "calle", width: "1%", defaultContent: "", visible: false, orderable: false},
	       	            {data: "numero", width: "1%", defaultContent: "", visible: false, orderable: false}
	       	            
			],
			"columnDefs": [
	                    {"targets": 0,
	                     "render": function (data, type, full, meta) {
	                    	 var sfid = "";
	                    	 var contactoSfid=document.getElementById("sfidContAsociadoID").value;
	                    	 var txtColumn = "";
	                    	 if (full.sfid != null) {
	                    		 sfid = full.sfid;
	                    	 }
	                    	 if (data != null) {
	                    		 txtColumn = data;
	                    	 }
	                    	 return '<a href="javaScript:{asociarSuministro('+"'" +sfid + "', '"+contactoSfid+"'"+')}">'+ txtColumn + '</a>';
	                    }
	        }]
//	      	,
//	        "order":[[0, "desc"]]
		});
		
		$('#buscar').on('click', function() {
						
			var numeroSuministro= document.getElementById("idNameSuministro");
			var comuna= document.getElementById("idComuna");
			var calle= document.getElementById("idCalle");
			var numero= document.getElementById("idNumero");
			
			if(numeroSuministro.value=="" && comuna.value=="" && calle.value=="" &&numero.value==""){
				$('#divAssociationErrorSearch').show();
			}
			else{
				$('#divAssociationErrorSearch').hide();
			}
			
			tableSum
				.columns(0).search($('#idNameSuministro').val())
				.columns(2).search($('#idComuna').val())
				.columns(6).search($('#idCalle').val())
				.columns(7).search($('#idNumero').val())
				.draw();			
		});
		
		//A�adir opcion de buscar pulsando enter
		$("#idNameSuministro").on("keyup", function (event) {
		    if (event.keyCode==13) {
		        $("#buscar").get(0).click();
		    }
		});
		$("#idComuna").on("keyup", function (event) {
		    if (event.keyCode==13) {
		        $("#buscar").get(0).click();
		    }
		});
		$("#idCalle").on("keyup", function (event) {
		    if (event.keyCode==13) {
		        $("#buscar").get(0).click();
		    }
		});
		$("#idNumero").on("keyup", function (event) {
		    if (event.keyCode==13) {
		        $("#buscar").get(0).click();
		    }
		});
	}
}

function abrirDialogoCasoDireccion(){		
	$("#dialogAsociarSuministroContacto").dialog('close');
	$("#dialogCrearCasoPorDireccion").dialog('open');
	cargarTablaDirecciones();

}


function asociarSuministro(sfid,contactSfid){
	$("#dialogAsociarSuministroContacto").dialog('close');
	verCargando();	
	window.location="../private/asociarSuministro?sfid=" + sfid +"&contactSfid="+contactSfid ;
	
}

function checkUpdates() {
	if (document.getElementById('editModeId').value == 'ASSOCIATION_ERROR') {
		$('#divAssociationError').show();
	}
	if (document.getElementById('editModeId').value == 'ASSOCIATION_OK') {
		$('#divAssociationOk').show();
	}
}


function cargarTablaDirecciones(){
	if(tableDir == null){
		var formularioDir = $('#crearCasoPorDireccionId');
		
		tableDir = $('#tablaDirecciones').DataTable({
	       	"scrollY": "250px",
			"scrollX": false,
			"scrollCollapse": true,
			"paging": false,
			"serverSide": true,
		    "ordering": false,	    
			"processing": true, 
	        "language": {
	        	processing:  "<img src='../resources/images/loading.gif' width='25' > Cargando...",
	            lengthMenu: "",
	            info: "",
	            infoEmpty: "",
	            infoFiltered: "",
	            zeroRecords:"",
	            emptyTable:"No se han encontrado registros"
	        },
	        "lengthChange": false,
	        "deferRender": true,
	        "deferLoading": -1,
			"ajax": { 
	        	"type": formularioDir.attr('method'),
	        	"url": 'listarDirecciones', 	               	
	        	 "contentType": 'application/json; charset=utf-8' ,
	        	 "error": function(data) {
	        		 alert('Se ha producido un error obteniendo la lista de direcciones. Repita la operacion y, si el error persiste, contacte con el administrador de la plataforma.');
	        	 }
	      	},
	       	"columns": [
	       	            {data: "calle", width: "1%", defaultContent: "", orderable: false}, 
	       	            {data: "tipoCalle", width: "1%", defaultContent: "", orderable: false},
	       	            {data: "comuna", width: "1%", defaultContent: "", visible: false, orderable: false},
	       	            {data: "direccionConcatenada", width: "1%",visible: false, defaultContent: "", orderable: false},
			],
			"columnDefs": [
	                    {"targets": 0,
	                     "render": function (data, type, full, meta) {
	                    	 var txtColumn = "";
	                    	 var tipoCalle ="";
	                    	 if (data!= null) {
	                    		 calle = full.calle;
	                    	 }if (full.tipoCalle != null) {
	                    		 tipoCalle = full.tipoCalle;
	                     	 }if (full.comuna != null) {
	                     		 comuna = full.comuna;
	                     	 }if (full.direccionConcatenada != null) {
	                     		 direccionConcatenada  = full.direccionConcatenada;
	                     	 }
	                    	 return '<a href="javaScript:{agregarDireccion('+"'" +calle +"'"+","+"'"+tipoCalle+"'"+","+"'"+direccionConcatenada+"'"+')}">'+ calle  + '</a>';
	                    }
	        }]
//	      	,
//	        "order":[[0, "desc"]]
		});
		
		$('#buscarCalleID').on('click', function() {
						
			var comunaDir= document.getElementById("idComunaDir");
			var calleDir= document.getElementById("idCalleDir");
			var numeroDir= document.getElementById("idNumeroDir");
			
			if(comunaDir.value=="" || calleDir.value=="" ||calleDir.value.length<3){
				$('#divDireccionErrorSearch').show();
				$('#tablaDirecciones').hide();			
				}
			else{
				$('#tablaDirecciones').show();			
				$('#divDireccionErrorSearch').hide();
				
			tableDir
			    .columns(0).search($('#idCalleDir').val())
				.columns(2).search($('#idComunaDir').val())
				.draw();	
			}
		});
		
		//A�adir opcion de buscar pulsando enter
		$("#idComunaDir").on("keyup", function (event) {
		    if (event.keyCode==13) {
		        $("#buscarCalleID").get(0).click();
		    }
		});
		$("#idCalleDir").on("keyup", function (event) {
		    if (event.keyCode==13) {
		        $("#buscarCalleID").get(0).click();
		    }
		});
	}
}

function agregarDireccion(direccion,tipoCalle,direccionConcatenada){
	document.getElementById("idCalleDir").value=direccion;
	document.getElementById("idTipoCalleDir").value=tipoCalle;
	document.getElementById("idDireccionCon").value=direccionConcatenada;
}



function crearCasoPorDireccion(){
	$("#cargarCrearCasoPorDireccion").dialog('close');
	verCargando();	
	window.location="../private/crearCasoPorDireccion";
	
}

