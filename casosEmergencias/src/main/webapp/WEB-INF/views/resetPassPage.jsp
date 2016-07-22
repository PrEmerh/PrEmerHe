<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Reset Password Page</title>
	</head>
	<body>
		<div>
			<h1><s:message code="reset_label_title"/></h1>
	  		<h3><s:message code="reset_label_text"/>:</h3>  
	    
	    	<div>
		  		<form name='resetForm' action="sendEmail" method='POST' >
			    	<table>
						<tr>
				           	<td>
				           		<s:message code="reset_form_label_user"/>:
				           	</td>
				        	<td>
				        		<input type='text' name='userName' value=''>
				        	</td>
				        </tr>
				        <tr>
				        	<td>
				        		<input name="submit" type="submit" value='<s:message code="reset_form_button_submit"/>'/>
				        	</td>
				        </tr>
					</table>
			 	</form>
		 	</div>
		 	
		 	<div>
			 	<h1><s:message code="${userView.mensajeError}" text=""/></h1>
			 	<h1><s:message code="${userView.mensaje}" text=""/> <s:message code="${userView.email}" text=""/></h1>		
			</div>
		</div>
	</body>
</html>