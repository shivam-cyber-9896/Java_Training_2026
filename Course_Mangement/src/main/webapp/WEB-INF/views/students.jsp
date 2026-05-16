<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg,#1e3c72,#2a5298);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:500px;
    background:white;
    padding:40px;
    border-radius:15px;
    text-align:center;
    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h1{
    margin-bottom:30px;
    color:#1e3c72;
}

a{
    display:block;
    margin:15px 0;
    padding:15px;
    text-decoration:none;
    color:white;
    font-size:18px;
    border-radius:8px;
    transition:0.3s;
}

.add{
    background:#007bff;
}

.view{
    background:#28a745;
}

.back{
    background:#ff9800;
}

.logout{
    background:#dc3545;
}

a:hover{
    transform:scale(1.03);
    opacity:0.9;
}

</style>

</head>

<body>

<div class="container">

    <h1>Student Management Module</h1>

    <a href="student/add" class="add">
        Add Student
    </a>

    <a href="student/list" class="view">
        View Students
    </a>
    <a href="student/edit" class="view">
        Update Student
    </a>
    <a href="student/delete" class="view">
        Delete Student
    </a>
    <a href="dashboard" class="back">
        Back To Dashboard
    </a>

    <a href="logout" class="logout">
        Logout
    </a>

</div>

</body>
</html>