<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Registration</title>

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
    background:#007bff;
    color:white;
    border:none;
    border-radius:8px;
    font-size:16px;
    cursor:pointer;
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

</style>

</head>

<body>

<div class="container">

<h2>Register Student</h2>

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

<input type="number"
       name="studentId"
       placeholder="Enter Student ID"
       required>

<input type="number"
       name="courseId"
       placeholder="Enter Course ID"
       required>

<input type="date"
       name="registrationDate"
       required>

<select name="status" required>

    <option value="">
        Select Status
    </option>

    <option value="Active">
        Active
    </option>

    <option value="Completed">
        Completed
    </option>

    <option value="Cancelled">
        Cancelled
    </option>

</select>

<button type="submit">
    Register Student
</button>

</form>

<a href="../registrations"
   class="back">
   Back To Registrations
</a>

</div>

</body>
</html>