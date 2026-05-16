<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.shivam.monocept.studentcourse.model.Student" %>

<%

Student s =
(Student)request.getAttribute("student");

String error =
(String)request.getAttribute("error");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:Arial;
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

.update{
    background:#28a745;
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

<h2>Update Student</h2>

<%

if(error != null){

%>

<div class="error">
<%= error %>
</div>

<%
}
%>

<!-- FETCH STUDENT -->

<form action="../student/edit" method="get">

<input type="number"
       name="id"
       placeholder="Enter Student ID"
       required>

<button type="submit"
        class="fetch">
    Fetch Student
</button>

</form>

<br>

<%

if(s != null){

%>

<!-- UPDATE FORM -->

<form action="../student/edit" method="post">

<input type="hidden"
       name="id"
       value="<%= s.getStudentId() %>">

<input type="text"
       name="studentName"
       value="<%= s.getStudentName() %>">

<input type="email"
       name="email"
       value="<%= s.getEmail() %>">

<input type="text"
       name="phone"
       value="<%= s.getPhone() %>">

<input type="number"
       name="age"
       value="<%= s.getAge() %>">

<input type="text"
       name="city"
       value="<%= s.getCity() %>">

<button type="submit"
        class="update">
    Update Student
</button>

</form>

<%
}
%>

<a href="../student/list"
   class="back">
   Back
</a>

</div>

</body>
</html>