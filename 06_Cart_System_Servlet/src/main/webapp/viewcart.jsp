<%@ page import="java.util.*" %>

<%
    List<String> cart = (List<String>) session.getAttribute("cart");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>

    <style>
        body {
            font-family: Arial;
            background: #121212;
            color: white;
            margin: 0;
            padding: 40px;
            text-align: center;
        }

        .cart-box {
            background: #1e1e1e;
            padding: 30px;
            border-radius: 15px;
            display: inline-block;
            min-width: 400px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #444;
        }

        th {
            background: #333;
        }

        .total {
            margin-top: 20px;
            font-weight: bold;
            color: #00ffcc;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 5px;
        }

        .btn {
            background: #00c6ff;
            color: white;
        }

        .danger {
            background: #ff4d4d;
            color: white;
        }
    </style>
</head>

<body>

<div class="cart-box">

    <h2>🛒 Your Cart</h2>

<%
    if (cart == null || cart.isEmpty()) {
%>
        <h3>Cart is empty 😢</h3>
<%
    } else {
        int total = 0;
%>

<table>
<tr>
    <th>Product</th>
    <th>Price</th>
</tr>

<%
    for (String item : cart) {
        String[] parts = item.split("-");
        String name = parts[0];
        int price = Integer.parseInt(parts[1]);
        total += price;
%>
<tr>
    <td><%= name %></td>
    <td>₹<%= price %></td>
</tr>
<%
    }
%>

</table>

<div class="total">
    Total Items: <%= cart.size() %><br>
    Total Amount: ₹<%= total %>
</div>

<%
    }
%>

<br>
<a href="productlist.jsp" class="btn">Continue Shopping</a>
<a href="clearCart" class="danger">Clear Cart</a>

</div>

</body>
</html>