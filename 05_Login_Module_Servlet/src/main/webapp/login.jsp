<%
    String error = request.getParameter("error");
    String msg = request.getParameter("msg");

    // 🔐 Get username from cookie
    String savedUser = "";
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                savedUser = c.getValue();
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Login</title>

    <style>
        body {
            font-family: Arial;
            background: linear-gradient(135deg, #667eea, #764ba2);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card {
            background: rgba(255,255,255,0.1);
            padding: 30px;
            border-radius: 15px;
            backdrop-filter: blur(10px);
            color: white;
            width: 300px;
            text-align: center;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
        }

        button {
            width: 100%;
            padding: 10px;
            background: #00c6ff;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        .small-btn {
            margin-top: 10px;
            background: #ff4d4d;
        }

        .error { color: #ff4d4d; }
        .msg { color: #ffd700; }
    </style>
</head>

<body>

<div class="card">
    <h2>Student Login</h2>

    <% if ("invalid".equals(error)) { %>
        <div class="error">❌ Invalid Username or Password</div>
    <% } %>

    <% if ("session_expired".equals(msg)) { %>
        <div class="msg">⚠️ Session Expired. Please login again.</div>
    <% } %>

    <form action="login" method="post">

        <!-- Prefilled username -->
        <input type="text" name="username" placeholder="Username"
               value="<%= savedUser %>" required>

        <input type="password" name="password" placeholder="Password" required>

        <!-- Remember checkbox -->
        <label>
            <input type="checkbox" name="remember"
                <%= (!savedUser.equals("")) ? "checked" : "" %> >
            Remember Username
        </label>

        <button type="submit">Login</button>
    </form>

    <!-- Delete cookie button -->
    <% if (!savedUser.equals("")) { %>
        <form action="deleteCookie" method="get">
            <button class="small-btn">Remove Saved Username</button>
        </form>
    <% } %>

</div>

</body>
</html>