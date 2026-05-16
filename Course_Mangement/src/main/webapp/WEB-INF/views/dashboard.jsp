<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<style>

body{
    font-family: Arial;
    background:#f2f2f2;
}

.container{
    width:500px;
    margin:50px auto;
    background:white;
    padding:20px;
    border-radius:10px;
    text-align:center;
}

a{
    display:block;
    margin:15px;
    padding:10px;
    background:blue;
    color:white;
    text-decoration:none;
    border-radius:5px;
}

.logout{
    background:red;
}

</style>

</head>

<body>

<div class="container">

<h1>Admin Dashboard</h1>

<h3>
Welcome,
<%= request.getAttribute("username") %>
</h3>

<a href="students">Manage Students</a>

<a href="courses">Manage Courses</a>

<a href="registrations">Manage Registrations</a>

<a href="logout" class="logout">Logout</a>

</div>

</body>
</html>