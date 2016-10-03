<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 

<!-- Dialog combo Asociar Suministro a Contacto -->
<div id="dialogAsociarSuministroContacto" title="B�squeda" class="dialogLupa">	
	<form id="asociarSuministroId" action="listarAsociarSuministros"  method="POST" name="formAsociarSuministro">	
		<input type="hidden" value="${contacto.sfid}" name="sfidContAsociado">
		<div id="busquedaSuministro" class="divEntidad, divLabel">
			<table>
				<tr>
					<td colspan="2" class="tablaBusquedaEtiquetas">
						<label for="filtroNumSuministro">B�squeda por Suministro</label>
					</td>
					<td colspan="2" class="tablaBusquedaEtiquetas">
						<label for="filtroNumSuministro">B�squeda por Direcci�n</label>
					</td>		
				</tr>
				<!-- SuministroPorDireccionController -->
				<tr>
					<td rowspan="3" class="tablaBusquedaEtiquetas">
						<label for="filtroDireccion">N�mero de Suministro</label>
					</td>
					<td class="tablaBusquedaTextos" rowspan="3">
						<input type="text" name="nameSuministro" value="" id="idNumero" class="buttontext">
					</td>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroDireccion">Comuna</label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="text" name="comuna" value="" id="idComuna" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroDireccion">Calle</label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="text" name="calle" value="" id="idCalle" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaBusquedaEtiquetas">
						<label for="filtroDireccion">N�mero</label>
					</td>
					<td class="tablaBusquedaTextos">
						<input type="text" name="numero" value="" id="idNumero" class="buttontext">
					</td>
				</tr>
			</table>
		</div>
		<div>
			<input id="crearCasoDireccion" type="button" name="crearCasoDirecion" value="Crear Caso Direcci�n" onclick="guardarCancelarCaso();"/>
			<input id="buscar" type="button" name="buscar" value="Buscar" />
		</div>		
		<div>
			<table id="tablaSuministros" class="display" style="width: 100%;">
				<thead>
		            <tr>
		            	<th width="20%">N�mero de Suministro</th>
		                <th width="20%">Direcci�n</th>
		                <th width="19%">Comuna</th>
		                <th width="20%">Estado de Conexi�n</th>
		                <th width="20%">Empresa</th>
		                <th width="1%" hidden="true">sfid</th>
		                <th width="1%" hidden="true">calle</th>
		                <th width="1%" hidden="true">numero</th>
		            </tr>
	        	</thead>
			</table>
		</div>
	</form>
</div>