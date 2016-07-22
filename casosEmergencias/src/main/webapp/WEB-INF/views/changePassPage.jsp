<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Change Password Page</title>
	</head>
	<body>
		<div>
		  	<h3><s:message code="changePass_label_title"/>:</h3>  
		    
		    <div>
			  	<form name='changePassForm' action="changePass" method='POST' name='userView'>
			  		<input type="hidden" name="sfid" value="${userView.sfid}"/>
				    <table>
				        <tr>
				           <td><s:message code="changePass_form_label_pass"/>:</td>
				           <td><input type='password' name='pass' /></td>
				        </tr>
				        <tr>
				           <td><input name="submit" type="submit" value='<s:message code="changePass_form_button_submit"/>' /></td>
				        </tr>
					</table>
			 	</form>
		 	</div>
		 	
		 	<div>
			 	<h1><s:message code="${userView.mensajeError}" text=""/></h1>
			 	<h1><s:message code="${userView.mensaje}" text=""/></h1>		
			</div>
	 	 </div>
	</body>
</html>
