var table;
var urlTable = createUrl();

$(document).ready(function() {
	table = $('#tablaCuentas').DataTable({
       	"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,
		"paging": true,
		"serverSide": true,
		"processing": true, 
		"ajax": { 
        	"type": "POST", 
        	 "url": urlTable +'/listarCuentas', 	        	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data) {
        		 alert('error');
        	 }
       	},
       	"columns": [
       	            {"data": "name", 					"width": "33%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "tel_fono_principal__c",	"width": "32%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "email_principal__c",		"width": "33%", "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": true},
       	            {"data": "masterrecord__run__c", 	"width": "1%",  "defaultContent": "", "searchable": true, 	"orderable": true,	"visible": false},
       	            {"data": "sfid", 					"width": "1%", 	"defaultContent": "", "searchable": false, 	"orderable": false,	"visible": false}
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
                    	 return '<a href="../private/entidadCuenta?sfid=' + sfid + '">' + txtColumn + '</a>';
                    }
        }],
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
		"order": [[0, 'asc']],
        "deferRender": true
	});
	
	$('#search').on('click', function() {
		if (validateEmail($("#filtroEmail").val())) {
			table
				.columns(0).search($('#filtroRazonSocial').val())
				.columns(1).search($('#filtroTelefono').val())
				.columns(2).search($('#filtroEmail').val())
				.columns(3).search($('#filtroRunRut').val())
				.draw();
		} else {
			alert("Introduzca un email válido");
			$("#filtroEmail").val("");
			$("#filtroEmail").focus();
			return false;
		}
	});
});

function createUrl() {
	var miUrl = window.location.protocol + "//" + window.location.host;
	if (window.location.pathname.includes("/casosEmergencias/")) {
		miUrl = miUrl + "/casosEmergencias";
	}
	return miUrl;
}

function validateEmail(email) {
    var emailRegex = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
    var validated = true;
    if (email != "") {
    	validated =  emailRegex.test(email);
    }
    return validated;
}