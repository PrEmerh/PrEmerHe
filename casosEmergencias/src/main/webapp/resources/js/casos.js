var table;
var urlTable = createUrl();

$(document).ready(function() {
	table= $('#tablaCasos').DataTable( {
		"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,
		"paging": true,
		"serverSide": true,
		"processing": true, 
		"ajax": { 
        	"type": "POST", 
        	 "url": urlTable +'/listarCasos', 	        	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data){
        		 alert('error');
        	 }
       	}, 
       	"columns": [ 
       	            {"data": "numeroCaso","width" : "20%","defaultContent": ""}, 
       	            {"data": "numeroInservice", "width":"16%", "defaultContent": ""},
       	            {"data": "canalOrigen", "width":"16%", "defaultContent": ""},
       	            {"data": "descripcionEstado", "width":"16%", "defaultContent": ""},
       	            {"data": "subestado", "width":"16%", "defaultContent": ""},
       	            {"data": "submotivo", "width":"16%", "defaultContent": ""},
       	            {"data": "sfid", "width":"1%", "visible": false, "defaultContent": ""}
       	            ],
       "columnDefs": [
                    {"targets":0,
                     "render": function (data, type, full, meta){
                    	 var sfid = "";
                    	 var txtColumn = "";
                    	 if(full.sfid != null){
                    		 sfid = full.sfid;
                     	}
                    	 if(data != null){
                    		 txtColumn = data;
                    	 }
                    	 return '<a href="../private/entidadCaso?editMode=VIEW&sfid=' + sfid + '">' + txtColumn + '</a>';
                     	}
	    	   		}
	    	   		],
		"lengthMenu": [[2, 3, 5, -1], [2, 100, 200, "All"]],
		"order": [[0, 'asc']],      
        "deferRender": true, 
  
	});
});


function createUrl(){
	var miUrl = window.location.protocol + "//" + window.location.host;
	if(window.location.pathname.includes("/casosEmergencias/")){
		miUrl = miUrl + "/casosEmergencias";
	}
	return miUrl;
}