<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>

<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{
    width:400px;
    margin:50px auto;
    background:white;
    padding:25px;
    border-radius:10px;
}

input{
    width:100%;
    padding:10px;
    margin:10px 0;
}

button{
    width:100%;
    padding:10px;
    background:blue;
    color:white;
    border:none;
}

.error{
    color:red;
}

</style>

</head>

<body>

<div class="container">

<h2>Add Student</h2>

<%
String error =
(String)request.getAttribute("error");

if(error != null){
%>

<p class="error">
<%= error %>
</p>

<%
}
%>

<form action="add" method="post">

<input type="text"
       name="studentName"
       placeholder="Enter Name">

<input type="email"
       name="email"
       placeholder="Enter Email">

<input type="text"
       name="phone"
       placeholder="Enter Phone">

<input type="number"
       name="age"
       placeholder="Enter Age">

<input type="text"
       name="city"
       placeholder="Enter City">

<button type="submit">
    Add Student
</button>

</form>

</div>

</body>
</html>