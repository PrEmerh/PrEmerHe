var tableSuministro;
var tableDireccion;
var urlTable = createUrl();

$(document).ready(function() {

	tableSuministro= $('#tablaSuministrosPopUp').DataTable( {
			"scrollY": "250px",
			"scrollX": true,
			"scrollCollapse": true,
			"paging": true,
			"serverSide": true,
			"deferLoading": 0,
			"processing": true, 
			"ajax": { 
	        	"type": "POST", 
	        	 "url": urlTable +'/listarSuministros', 	        	
	        	 "contentType": 'application/json; charset=utf-8' ,
	        	 "error": function(data){
	        		 alert('error');
	        	 }
	       	}, 
	       	"columns": [ 
	       	            {"data": "name","width" : "30%","defaultContent": ""}, 
	       	            {"data": "idEmpresa", "width":"15%", "defaultContent": ""},
	       	            {"data": "comuna", "width":"15%", "defaultContent": ""},
	       	            {"data": "direccionConcatenada", "width":"39%", "defaultContent": ""},
	       	            {"data": "sfid", "width":"1%", "visible": false, "defaultContent": ""}
	       	            ],
	       "columnDefs": [
	                    {"targets":0,
	                     "render": function (data, type, full, meta){
	                    	 var numeroSuministro = "";
	                    	 var idSuministro = "";
	                    	 if(full.name != null){
	                    		 numeroSuministro = full.name;
	                     	 }
	                    	 if(full.sfid != null){
	                    		 idSuministro = full.sfid;
	                     	 }
	                    	 return '<input type="button" class="buttonLink" onclick="javascript:establecerSuministro(\''+ idSuministro + '\',\'' + numeroSuministro + '\')" value="' + numeroSuministro + '" >';
	                     	}
		    	   		}
		    	   		],
			"lengthMenu": [[10, 25, 100, -1], [10, 25, 100, "All"]],
			"order": [[0, 'asc']],      
	        "deferRender": true, 
	  
		});
	
	$('#searchSuministro').on('click', function(){
		var allCase = true;
		first = false;
		tableSuministro.search($('#txtNumeroSuministro').val(),allCase).draw();
	});
	
	tableDireccion= $('#tablaDireccionesPopUp').DataTable( {
		"scrollY": "250px",
		"scrollX": true,
		"scrollCollapse": true,
		"paging": true,
		"serverSide": true,
		"deferLoading": 0,
		"processing": true, 
		"ajax": { 
        	"type": "POST", 
        	 "url": urlTable +'/listarDirecciones', 	        	
        	 "contentType": 'application/json; charset=utf-8' ,
        	 "error": function(data){
        		 alert('error');
        	 }
       	}, 
       	"columns": [ 
       	            {"data": "name","width" : "30%","defaultContent": ""}, 
       	            {"data": "numero", "width":"10%", "defaultContent": ""},
       	            {"data": "comuna", "width":"20%", "defaultContent": ""},
       	            {"data": "calle", "width":"30%", "defaultContent": ""},
       	            {"data": "departamento", "width":"9%", "defaultContent": ""},
       	            {"data": "sfid", "width":"1%", "visible": false, "defaultContent": ""}
       	            ],
       "columnDefs": [
                    {"targets":0,
                     "render": function (data, type, full, meta){
                    	 var codigoDireccion = "";
                    	 var idDireccion = "";
                    	 if(full.name != null){
                    		 codigoDireccion = full.name;
                     	 }
                    	 if(full.sfid != null){
                    		 idDireccion = full.sfid;
                     	 }
                    	 return '<input type="button" class="buttonLink" onclick="javascript:establecerDireccion(\''+ idDireccion + '\',\'' + codigoDireccion + '\')" value="' + codigoDireccion + '" >';
                     	}
	    	   		}
	    	   		],
		"lengthMenu": [[10, 25, 100, -1], [10, 25, 100, "All"]],
		"order": [[0, 'asc']],      
        "deferRender": true, 
  
	});
	$('#searchDireccion').on('click', function(){
		var allCase = true;
		first = false;
		tableDireccion.search($('#txtNombreDireccion').val(),allCase).draw();
	});
});


function createUrl(){
	var miUrl = window.location.protocol + "//" + window.location.host;
	if(window.location.pathname.includes("/casosEmergencias/")){
		miUrl = miUrl + "/casosEmergencias";
	}
	return miUrl;
}