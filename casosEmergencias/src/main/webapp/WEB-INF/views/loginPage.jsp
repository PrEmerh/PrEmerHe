<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Page</title>
	</head>
	<body>
		<h1><s:message code="login_label_title"/></h1>
	   	<h3><s:message code="login_label_text"/>:</h3>  
	    
	    <div>
	    
	    <!-- <img alt="logo" src='resources/images/Capture.PNG'/> -->
		   	<form name='loginUser' action="login" method='POST' name='userView'>
		    	<table>
			    	<tr>
			            <td><s:message code="login_form_label_user"/>:</td>
			            <td><input type='text' name='user' value=''></td>
			         </tr>
			         <tr>
			            <td><s:message code="login_form_label_password"/>:</td>
			            <td><input type='password' name='pass' /></td>
			         </tr>
			         <tr>
			            <td colspan="2"><input name="submit" type="submit" value='<s:message code="login_form_button_submit"/>' /></td>
			         </tr>
			         <tr>
						<td colspan="2"><a href="resetPass">Reset Password</a></td>
			         </tr>	         
		    	</table>
		      	
		  	</form>
		</div>
	  	<div>
      		<s:message code="${userView.mensajeError}" text=""/><!-- añadiomos text, si loginNoUser es vacio, no existe ninguna etiqueta en los properties y mostrará el valor de text-->
      	</div>
      <!-- 	<div>	     
      		Language : <a href="changLang.do?lang=en">English</a>|<a href="changLang.do?lang=es">Español</a>
    	</div> -->
	</body>
</html>