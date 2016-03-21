
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>


<body>
<a href ="/FirstSpringMVCProject/mainForm.html?siteLanguage=en">English</a> | <a href ="/FirstSpringMVCProject/mainForm.html?siteLanguage=fr">French</a>

<h1>${headerMsg}</h1>
	<h1>HEY DTUITE!! Please provide us with the following info</h1>
	<form:errors path="st1.*"/>
	
	<form action="/FirstSpringMVCProject/CGPA.html" method="post">
	
	<p>
	<spring:message code="label.username"/> : <input type="text" name="username"/>
</p> 
<p>
	<spring:message code="label.password"/>  <input type="password" name="password"/>
	</p>
	
	<input type="submit" value="Submit Your Response"/>
	
	
	
	</form>


</body>
</html>