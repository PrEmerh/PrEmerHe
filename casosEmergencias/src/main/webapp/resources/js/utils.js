<!-- Mostrar y esconder contenido de las pestañas -->
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