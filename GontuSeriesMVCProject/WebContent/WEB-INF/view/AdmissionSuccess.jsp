<html>
<head><h2>Welcome to Student Admission Success Page</h2></head>
<body>
	<h2>${headerMessage}</h2>

	<h3>${msg}</h3>
	
	<table>
		<tr>
			<th>Student Name</th>
			<td>${student1.studentName}</td>
		</tr>
		<tr>
			<th>Student Hobby</th>
			<td>${student1.studentHobby}</td>
		</tr>
		
		<tr>
			<th>Student Mobile</th>
			<td>${student1.studentMobile}</td>
		</tr>
		<tr>
			<th>Student DOB</th>
			<td>${student1.studentDOB}</td>
		</tr>
		<tr>
			<th>Student Skills</th>
			<td>${student1.studentSkills}</td>
		</tr>
		<tr>
			<th>Student Address</th>
			<td>City: ${student1.studentAddress.city}</td>
			<td>State: ${student1.studentAddress.state}</td>
			<td>Country: ${student1.studentAddress.country}</td>
		</tr>
		
	</table>
	
</body>
</html>