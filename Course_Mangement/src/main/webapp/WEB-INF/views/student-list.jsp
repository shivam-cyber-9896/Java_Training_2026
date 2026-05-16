<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.shivam.monocept.studentcourse.model.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students List</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:Arial, sans-serif;
    background:#f2f2f2;
}

.container{
    width:95%;
    margin:30px auto;
    background:white;
    padding:25px;
    border-radius:12px;
    box-shadow:0 0 10px rgba(0,0,0,0.2);
}

h2{
    text-align:center;
    margin-bottom:20px;
    color:#1e3c72;
}

table{
    width:100%;
    border-collapse:collapse;
}

th, td{
    padding:12px;
    border:1px solid #ddd;
    text-align:center;
}

th{
    background:#007bff;
    color:white;
}

tr:nth-child(even){
    background:#f9f9f9;
}

a{
    text-decoration:none;
    color:white;
    padding:8px 14px;
    border-radius:6px;
}

.add{
    background:#28a745;
    display:inline-block;
    margin-bottom:20px;
}

.edit{
    background:#ff9800;
}

.delete{
    background:#dc3545;
}

.back{
    background:#6c757d;
    display:inline-block;
    margin-top:20px;
}

.dashboard{
    background:#007bff;
    display:inline-block;
    margin-top:20px;
    margin-left:10px;
}

</style>

</head>

<body>

<div class="container">

<h2>Students List</h2>

<a href="add"
   class="add">
   Add Student
</a>

<table>

<tr>

<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Age</th>
<th>City</th>
<th>Actions</th>

</tr>

<%

List<Student> students =
(List<Student>)request.getAttribute("students");

for(Student s : students){

%>

<tr>

<td>
<%= s.getStudentId() %>
</td>

<td>
<%= s.getStudentName() %>
</td>

<td>
<%= s.getEmail() %>
</td>

<td>
<%= s.getPhone() %>
</td>

<td>
<%= s.getAge() %>
</td>

<td>
<%= s.getCity() %>
</td>

<td>

<a href="edit?id=<%= s.getStudentId() %>"
   class="edit">
   Edit
</a>

<a href="delete?id=<%= s.getStudentId() %>"
   class="delete"
   onclick="return confirm('Are you sure?')">
   Delete
</a>

</td>

</tr>

<%
}
%>

</table>

<a href="../students"
   class="back">
   Back
</a>

<a href="../dashboard"
   class="dashboard">
   Back To Dashboard
</a>

</div>

</body>
</html>