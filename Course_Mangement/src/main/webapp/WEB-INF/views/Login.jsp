<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>

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
    width:400px;
    background:white;
    padding:35px;
    border-radius:15px;
    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h2{
    text-align:center;
    margin-bottom:25px;
    color:#1e3c72;
    font-size:30px;
}

input[type="text"],
input[type="password"]{
    width:100%;
    padding:12px;
    margin:12px 0;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:15px;
}

.checkbox{
    display:flex;
    align-items:center;
    margin:10px 0 20px 0;
    font-size:14px;
}

.checkbox input{
    width:auto;
    margin-right:10px;
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

.project-title{
    text-align:center;
    margin-bottom:10px;
    color:#555;
    font-size:15px;
}

</style>

</head>

<body>

<div class="container">

<div class="project-title">
    Student Course Management System
</div>

<h2>Admin Login</h2>

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

<form action="login-action"
      method="post">

<input type="text"
       name="username"
       placeholder="Enter Username"
       required>

<input type="password"
       name="password"
       placeholder="Enter Password"
       required>

<div class="checkbox">

<input type="checkbox"
       name="remember">

<label>
Remember Username
</label>

</div>

<button type="submit">

    Login

</button>

</form>

</div>

</body>
</html>