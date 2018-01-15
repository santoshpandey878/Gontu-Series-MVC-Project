<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome to Admission Form</title>
	<style>
		.error {color:red}
	</style>
</head>
<body>

	<h1>Student Admission Form</h1>
	
	<h2>${headerMessage}</h2>
	
	<form:errors path="student1.*" cssClass="error"></form:errors>
	
	<form action="submitAdmissionFormWithModelAttribute.html" method="post">
		<p>
			Student Name : <input type="text" name="studentName" />
		</p>
		<p>
			Student Hobby : <input type="text" name="studentHobby" />
		</p>
		
		<p>
			Student Mobile : <input type="text" name="studentMobile" />
		</p>
		<p>
			Student DOB : <input type="text" name="studentDOB" />
		</p>
		<p>
			Student Skills : <select name="studentSkills" multiple="multiple">
								<option value="Core JAVA">Core Java</option>
								<option value="C++">C++</option>
								<option value="C">C</option>
							</select>
		</p>
		
		<table>
			<tr>
				<td>Country:</td><td><input type="text" name="studentAddress.country" /></td>
				<td>State:</td><td><input type="text" name="studentAddress.state" /></td>
				<td>City:</td><td><input type="text" name="studentAddress.city" /></td>
			</tr>
		</table>
		
		<input type="submit" value="submit">
	</form>

</body>
</html>