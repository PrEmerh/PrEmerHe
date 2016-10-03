var table;
var urlTable = createUrl();

function funcionOnload(){
	initHeader(); 
	showNotifications(); 
	cargarAsociarSuministro();
}

//Crear caso por contacto
function goCrearCasoByContacto(){
	verCaragando();
	window.location="../private/goCrearCasoByContacto";
}

function ocultarNotificacion(){
	$('#divInsertError').hide();
}

//Cargamos el dialog para asociar suministro a un contacto
function cargarAsociarSuministro() {
	$("#dialogAsociarSuministroContacto").dialog({
		autoOpen: false, 
		modal: true, 
		show: "blind", 
		hide: "blind", 
		height: "auto",
		width: "65%",
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
	if(table == null){
		cargarTablaSuministros();
	}
	$("#dialogAsociarSuministroContacto").dialog('open');
}

function cargarTablaSuministros(){
	
	var formulario = $('#asociarSuministroId');
	
	table = $('#tablaSuministros').DataTable({
       	"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,
		"paging": false,
		"serverSide": true,
		"oLanguage": {
		        sProcessing: "<img src='../resources/images/loading.gif' width='25' > Cargando..."
		    },
		"processing": true, 
		"ajax": { 
        	"type": formulario.attr('method'),
        	 "url": formulario.attr('action'), 	               	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data) {
        		 alert('Se ha producido un error obteniendo la lista de suministros. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
        	 }
      	},
       	"columns": [
       	            {"data": "name", "width": "20%", "defaultContent": "", "searchable": false, "orderable": false, "visible": true}, 
       	            {"data": "direccionConcatenada", "width": "20%", "defaultContent": "", "orderable": false, "searchable": false, "visible": true},
       	            {"data": "comuna", "width": "19%", "defaultContent": "", "searchable": false, "orderable": false, "visible": true},
       	            {"data": "estadoSuministroPickList", "width": "20%", "defaultContent": "", "searchable": false, "orderable": false, "visible": true},
       	            {"data": "empresaPickList", "width": "20%", "defaultContent": "", "searchable": false, "orderable": false, "visible": true},
       	            {"data": "sfid", "width": "1%", "defaultContent": "", "searchable": false, "orderable": false, "visible": false},
       	            {"data": "calle", "width": "1%", "defaultContent": "", "searchable": false, "orderable": false, "visible": false},
       	            {"data": "numero", "width": "1%", "defaultContent": "", "searchable": false, "orderable": false, "visible": false}
		],
		"columnDefs": [
                    {"targets": 0,
                     "render": function (data, type, full, meta) {
                    	 var sfid = "";
                    	 var txtColumn = "";
                    	 if (full.sfid != null) {
                    		 sfid = full.sfid;
                    	 }
                    	 if (data != null) {
                    		 txtColumn = data;
                    	 }
                    	 return '<a href="javaScript:{cargandoGif('+"'" +sfid + "', '"+"entidadSuministro"+"'"+')}">'+ txtColumn + '</a>';
                    }
        }],
        "language": {
            "lengthMenu": "aaaa",
            "zeroRecords": "No records available",
            "info": "aaaa",
            "infoEmpty": "aaaa",
            "infoFiltered": "aaaa"
        },
        "lengthChange": false,
        "deferRender": true,
        "deferLoading": 0
	});
	
	$('#buscar').on('click', function() {
		table
			.columns(0).search($('#idNumero').val())
			.columns(2).search($('#idComuna').val())
			.columns(5).search($('#idCalle').val())
			.columns(6).search($('#idNumero').val())
			.draw();			
	});
	
//	//Añadir opcion de buscar pulsando enter
//	$("#filtroNumSuministro").on("keyup", function (event) {
//	    if (event.keyCode==13) {
//	        $("#search").get(0).click();
//	    }
//	});
//	$("#filtroDireccion").on("keyup", function (event) {
//	    if (event.keyCode==13) {
//	        $("#search").get(0).click();
//	    }
//	});
//	$("#filtroComuna").on("keyup", function (event) {
//	    if (event.keyCode==13) {
//	        $("#search").get(0).click();
//	    }
//	});
}



