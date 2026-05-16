<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.shivam.monocept.studentcourse.model.Registration" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrations List</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{
    width:95%;
    margin:30px auto;
    background:white;
    padding:25px;
    border-radius:10px;
}

table{
    width:100%;
    border-collapse:collapse;
}

th, td{
    border:1px solid #ddd;
    padding:12px;
    text-align:center;
}

th{
    background:#007bff;
    color:white;
}

a{
    text-decoration:none;
    color:white;
    padding:8px 12px;
    border-radius:5px;
}

.update{
    background:#ff9800;
}

.delete{
    background:#dc3545;
}

.back{
    background:#28a745;
    display:inline-block;
    margin-top:20px;
}

</style>

</head>

<body>

<div class="container">

<h2>Registrations List</h2>

<table>

<tr>

<th>ID</th>
<th>Student ID</th>
<th>Course ID</th>
<th>Registration Date</th>
<th>Status</th>
<th>Actions</th>

</tr>

<%

List<Registration> registrations =
(List<Registration>)
request.getAttribute("registrations");

for(Registration r : registrations){

%>

<tr>

<td>
<%= r.getRegistrationId() %>
</td>

<td>
<%= r.getStudentId() %>
</td>

<td>
<%= r.getCourseId() %>
</td>

<td>
<%= r.getRegistrationDate() %>
</td>

<td>
<%= r.getStatus() %>
</td>

<td>

<a href="edit?id=<%= r.getRegistrationId() %>"
   class="update">
   Update
</a>

<a href="delete?id=<%= r.getRegistrationId() %>"
   class="delete">
   Delete
</a>

</td>

</tr>

<%
}
%>

</table>

<a href="../registrations"
   class="back">
   Back
</a>

</div>

</body>
</html>