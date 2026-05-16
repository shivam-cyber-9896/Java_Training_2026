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
<title>Update Course</title>

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
    font-size:15px;
}

button{
    width:100%;
    padding:12px;
    border:none;
    border-radius:8px;
    color:white;
    font-size:16px;
    cursor:pointer;
    transition:0.3s;
}

.fetch{
    background:#007bff;
}

.fetch:hover{
    background:#0056b3;
}

.update{
    background:#28a745;
}

.update:hover{
    background:#1e7e34;
}

.back{
    display:block;
    text-align:center;
    margin-top:15px;
    text-decoration:none;
    background:#ff9800;
    color:white;
    padding:12px;
    border-radius:8px;
}

.back:hover{
    background:#e68900;
}

.error{
    background:#ffebee;
    color:#d32f2f;
    padding:10px;
    border-radius:8px;
    margin-bottom:15px;
    text-align:center;
}

</style>

</head>

<body>

<div class="container">

<h2>Update Course</h2>

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

<form action="../course/edit" method="get">

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

<!-- UPDATE FORM -->

<form action="../course/edit" method="post">

<input type="hidden"
       name="id"
       value="<%= c.getCourseId() %>">

<input type="text"
       name="courseName"
       placeholder="Enter Course Name"
       value="<%= c.getCourseName() %>">

<input type="text"
       name="duration"
       placeholder="Enter Duration"
       value="<%= c.getDuration() %>">

<input type="number"
       step="0.01"
       name="fees"
       placeholder="Enter Fees"
       value="<%= c.getFees() %>">

<input type="text"
       name="trainerName"
       placeholder="Enter Trainer Name"
       value="<%= c.getTrainerName() %>">

<button type="submit"
        class="update">
    Update Course
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