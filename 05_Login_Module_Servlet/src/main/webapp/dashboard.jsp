<%@ page import="jakarta.servlet.http.*" %>
<%
    HttpSession sessionObj = request.getSession(false);

    if (sessionObj == null || sessionObj.getAttribute("user") == null) {
        response.sendRedirect("login.jsp?msg=session_expired");
        return;
    }

    String user = (String) sessionObj.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>

    <style>
        body {
            font-family: Arial;
            background: #121212;
            color: white;
            text-align: center;
            padding-top: 100px;
        }

        .box {
            background: #1e1e1e;
            padding: 30px;
            border-radius: 10px;
            display: inline-block;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background: #ff4d4d;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>

<body>

<div class="box">
    <h2>Welcome, <%= user %> 👋</h2>
    <p>Session is active</p>

    <a href="logout">Logout</a>
</div>

</body>
</html>