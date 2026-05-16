<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>

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
    background:#007bff;
    color:white;
    border:none;
    border-radius:8px;
    font-size:16px;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#0056b3;
}

.error{
    background:#ffebee;
    color:#d32f2f;
    padding:10px;
    border-radius:8px;
    margin-bottom:15px;
    text-align:center;
}

.back{
    display:block;
    text-align:center;
    margin-top:15px;
    text-decoration:none;
    background:#28a745;
    color:white;
    padding:12px;
    border-radius:8px;
}

.back:hover{
    background:#1e7e34;
}

</style>

</head>

<body>

<div class="container">

<h2>Add Course</h2>

<%

String error =
(String)request.getAttribute("error");

if(error != null){

%>

<div class="error">
<%= error %>
</div>

<%
}
%>

<form action="add" method="post">

<input type="text"
       name="courseName"
       placeholder="Enter Course Name"
       required>

<input type="text"
       name="duration"
       placeholder="Enter Duration"
       required>

<input type="number"
       step="0.01"
       name="fees"
       placeholder="Enter Fees"
       required>

<input type="text"
       name="trainerName"
       placeholder="Enter Trainer Name"
       required>

<button type="submit">
    Add Course
</button>

</form>

<a href="../courses-page"
   class="back">
   Back To Courses
</a>

</div>

</body>
</html>