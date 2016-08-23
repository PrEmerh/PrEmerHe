var table;
var urlTable = createUrl();

$(document).ready(function() {
	table = $('#tablaSuministros').DataTable({
       	"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,
		"paging": true,
		"serverSide": true,
		"processing": true, 
		"ajax": { 
        	"type": "POST", 
        	 "url": urlTable +'/listarSuministros', 	        	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data) {
        		 alert('error');
        	 }
       	},
       	"columns": [
       	            {"data": "name", 				"width": "20%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true}, 
       	            {"data": "estadoConexion",		"width": "19%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "estadoSuministro", 	"width": "19%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "direccion", 			"width": "20%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "comuna", 				"width": "19%", "defaultContent": "", "searchable": false, 	"orderable": true,	"visible": true},
       	            {"data": "n_mero_medidor__c",	"width": "1%", 	"defaultContent": "", "searchable": true, 	"orderable": false,	"visible": false},
       	            {"data": "ruta__c",				"width": "1%", 	"defaultContent": "", "searchable": true, 	"orderable": false,	"visible": false},
       	            {"data": "sfid", 				"width": "1%", 	"defaultContent": "", "searchable": false, 	"orderable": false,	"visible": false}
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
                    	 return '<a href="../private/entidadSuministro?sfid=' + sfid + '">' + txtColumn + '</a>';
                    }
        }],
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"order": [[0, 'asc']],
        "deferRender": true
	});
	
	$('#search').on('click', function() {
		table
			.columns(0).search($('#filtroNumSuministro').val())
			.columns(5).search($('#filtroNumMedidor').val())
			.columns(6).search($('#filtroRutaLectura').val())
			.draw();
	});
});

function createUrl() {
	var miUrl = window.location.protocol + "//" + window.location.host;
	//if (window.location.pathname.includes("/casosEmergencias/")) {
	if (window.location.hash.indexOf("/casosEmergencias/")) {
		miUrl = miUrl + "/casosEmergencias";
	}
	return miUrl;
}