var tableSuministro;
var tableDireccion;
var urlTable = createUrl();



function createTableDireccion() {	
	
	//Comprobamos si la tabla esta creada
	if(tableDireccion == null){
		tableDireccion= $('#tablaDireccionesPopUp').DataTable( {
			"scrollY": "250px",
			"scrollX": false,
			"scrollCollapse": true,
			"paging": true,
			"serverSide": true,
			"deferLoading": 0,
			"processing": true, 
			"ajax": { 
	        	"type": "POST", 
	        	 "url": urlTable +'/listarDireccionesPopUp', 	        	
	        	 "contentType": 'application/json; charset=utf-8' ,
	        	 "error": function(data){
	        		 alert('Se ha producido un error obteniendo la lista de direcciones. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
	        	 }
	       	}, 
	       	"columns": [ 
	       	            {"data": "name","width" : "15%","defaultContent": ""}, 
	       	            {"data": "numero", "width":"10%", "defaultContent": ""},
	       	            {"data": "literalComuna", "width":"20%", "defaultContent": ""},
	       	            {"data": "direccionConcatenada", "width":"35%", "defaultContent": ""},
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
		$('#searchDireccion').on('click', function() {
			tableDireccion
				.columns(3).search($('#txtNombreDireccion').val())
				.draw();
		});
	}
}


function createTableSuministro() {
	
	//Comprobamos si la tabla esta creada
	if(tableSuministro==null){
		tableSuministro= $('#tablaSuministrosPopUp').DataTable( {
			"scrollY": "250px",
			"scrollX": false,
			"scrollCollapse": true,
			"paging": true,
			"serverSide": true,
			"deferLoading": 0,
			"processing": true, 
			"ajax": { 
	        	"type": "POST", 
	        	 "url": urlTable +'/listarSuministrosPopUp', 	        	
	        	 "contentType": 'application/json; charset=utf-8' ,
	        	 "error": function(data){
	        		 alert('Se ha producido un error obteniendo la lista de suministros. Repita la operación y, si el error persiste, contacte con el administrador de la plataforma.');
	        	 }
	       	}, 
	       	"columns": [ 
	       	            {"data": "name", "width" : "10%","defaultContent": ""}, 
	       	            {"data": "id_empresa__c", "width":"20%", "defaultContent": ""},
	       	            {"data": "comuna__c", "width":"20%", "defaultContent": ""},
	       	            {"data": "DireccionConcatenada__c", "width":"19%", "defaultContent": ""},
	       	            {"data": "sfid", "width":"1%", "defaultContent": "", "visible": false}
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
		$('#searchSuministro').on('click', function() {
			tableSuministro
				.columns(0).search($('#txtNumeroSuministro').val())
				.draw();
		});
	}
	
}