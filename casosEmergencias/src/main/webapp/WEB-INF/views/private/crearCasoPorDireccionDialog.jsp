<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Dialog combo Asociar Suministro a Contacto -->
<div id="dialogCrearCasoPorDireccion" title="Nueva Dirección" class="dialogLupa">	
	<form id="crearCasoPorDireccionId" action="crearCasoPorDireccion"  method="POST" name="formCrearCasoPorDireccion">
		<div id="divDireccionErrorSearch" class="divError">
			<label class="labelDivError"><s:message code="notificaciones_label_error_direccion_busqueda"/></label>
		</div>
		<div id="busquedaSDireccion" class="divEntidad, divLabel">
			<table  class="tablaBusqueda">						
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Region</label>
					</td>
					<td class="tablaAsociarSuministroTextos">					
						<select id="idRegionDir" name= "region">
							<c:forEach items="${suministroDial.mapRegion}" var="reg">
								<option value="${reg.key}" >								
									${reg.value}								
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>						
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Comuna</label>
					</td>
					<td class="tablaAsociarSuministroTextos">					
						<select class="requiredTextArea" id="idComunaDir" name= "mapComuna">
							<c:forEach items="${suministroDial.mapComuna}" var="comuna">
								<option value="${comuna.key}">								
									${comuna.value}								
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Calle</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input class="requiredTextArea" type="text" name="calleDir" value="" id="idCalleDir" class="buttontext">
					</td>
					<td colspan="3" align="left">
						<input  id="buscarCalleID" type="button" name="buscarCalleName" value="Buscar Calle" />					
					</td>	
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Número</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input class="requiredTextArea" type="text" name="numeroDir" value="" id="idNumeroDir" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Departamento</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input type="text" name="departamentoDir" value="" id="idDepartamentoDir" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Tipo de Calle</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input type="text" name="tipoCalleDir" value="" id="idTipoCalleDir" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroDireccion">Direccion Concatenada</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input type="text" name="direccionConDir" value="" id="idDireccionCon" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroComuna">Comuna</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input type="text" name="comunaDir" value="" id="idComuna" class="buttontext">
					</td>
				</tr>
				<tr>
					<td class="tablaAsociarSuministroEtiquetas">
						<label for="filtroSfidContacto">Sfid Contacto</label>
					</td>
					<td class="tablaAsociarSuministroTextos">
						<input type="text" name="sfidContactDir" value="" id="idContactSfid" class="buttontext">
					</td>
				</tr>
				<tr>
					<td colspan="3" align="left">
						<input id="crearCasoDireccionID" type="button" name="crearCasoDireccionName" value="Guardar y Crear Caso" onclick="crearCasoPorDireccion()" />					
					</td>					
				</tr>								
			</table>			
		</div>			
	</form>
	<div>
	</div>		
	<div>
		<table id="tablaDirecciones" class="display" style="width: 100%;">
			<thead>
	            <tr>	            	
	            	<th width="1%">Nombre</th>
	                <th width="1%">Tipo</th>
	                <th width="1%" hidden="true">comuna</th>
	                <th width="1%" hidden="true">direccionConcatenada</th>
	            </tr>
        	</thead>
		</table>
	</div>
</div>