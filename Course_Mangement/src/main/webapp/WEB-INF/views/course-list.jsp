<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.shivam.monocept.studentcourse.model.Course" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses List</title>

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

.update{
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

</style>

</head>

<body>

<div class="container">

<h2>Courses List</h2>

<a href="add"
   class="add">
   Add Course
</a>

<table>

<tr>

<th>ID</th>
<th>Course Name</th>
<th>Duration</th>
<th>Fees</th>
<th>Trainer Name</th>
<th>Actions</th>

</tr>

<%

List<Course> courses =
(List<Course>)request.getAttribute("courses");

for(Course c : courses){

%>

<tr>

<td>
<%= c.getCourseId() %>
</td>

<td>
<%= c.getCourseName() %>
</td>

<td>
<%= c.getDuration() %>
</td>

<td>
₹ <%= c.getFees() %>
</td>

<td>
<%= c.getTrainerName() %>
</td>

<td>

<a href="edit?id=<%= c.getCourseId() %>"
   class="update">
   Update
</a>

<a href="delete?id=<%= c.getCourseId() %>"
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

<a href="../courses"
   class="back">
   Back To Courses
</a>

</div>

</body>
</html>