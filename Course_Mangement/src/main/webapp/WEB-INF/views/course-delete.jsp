<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.shivam.monocept.studentcourse.model.Course" %>

<%

Course c =
(Course)request.getAttribute("course");

String error =
(String)request.getAttribute("error");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Course</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:Arial, sans-serif;
    background:linear-gradient(135deg,#1e3c72,#2a5298);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:450px;
    background:white;
    padding:30px;
    border-radius:15px;
    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h2{
    text-align:center;
    margin-bottom:20px;
    color:#1e3c72;
}

input{
    width:100%;
    padding:12px;
    margin:10px 0;
    border:1px solid #ccc;
    border-radius:8px;
}

button{
    width:100%;
    padding:12px;
    border:none;
    border-radius:8px;
    color:white;
    font-size:16px;
    cursor:pointer;
}

.fetch{
    background:#007bff;
}

.delete{
    background:#dc3545;
}

.back{
    display:block;
    text-align:center;
    margin-top:15px;
    text-decoration:none;
    background:#6c757d;
    color:white;
    padding:12px;
    border-radius:8px;
}

.error{
    background:#ffebee;
    color:#d32f2f;
    padding:10px;
    border-radius:8px;
    margin-bottom:15px;
    text-align:center;
}

.info{
    margin:10px 0;
    font-size:17px;
}

</style>

</head>

<body>

<div class="container">

<h2>Delete Course</h2>

<%

if(error != null){

%>

<div class="error">
<%= error %>
</div>

<%
}
%>

<!-- FETCH COURSE -->

<form action="../course/delete" method="get">

<input type="number"
       name="id"
       placeholder="Enter Course ID"
       required>

<button type="submit"
        class="fetch">
    Fetch Course
</button>

</form>

<br>

<%

if(c != null){

%>

<div class="info">
<b>ID:</b>
<%= c.getCourseId() %>
</div>

<div class="info">
<b>Course Name:</b>
<%= c.getCourseName() %>
</div>

<div class="info">
<b>Duration:</b>
<%= c.getDuration() %>
</div>

<div class="info">
<b>Fees:</b>
₹ <%= c.getFees() %>
</div>

<div class="info">
<b>Trainer:</b>
<%= c.getTrainerName() %>
</div>

<form action="../course/delete"
      method="post">

<input type="hidden"
       name="id"
       value="<%= c.getCourseId() %>">

<button type="submit"
        class="delete">
    Delete Course
</button>

</form>

<%
}
%>

<a href="../course/list"
   class="back">
   Back To Courses
</a>

</div>

</body>
</html>