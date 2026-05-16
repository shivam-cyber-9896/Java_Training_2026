<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Products</title>

    <style>
        body {
            font-family: Arial;
            background: linear-gradient(135deg, #667eea, #764ba2);
            margin: 0;
            padding: 0;
        }

        .container {
            padding: 40px;
            text-align: center;
            color: white;
        }

        h2 {
            margin-bottom: 30px;
        }

        .products {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 20px;
        }

        .card {
            background: rgba(255,255,255,0.1);
            backdrop-filter: blur(10px);
            border-radius: 15px;
            padding: 20px;
            width: 200px;
            text-align: left;
            transition: 0.3s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .price {
            color: #ffd700;
            font-weight: bold;
        }

        button {
            margin-top: 20px;
            padding: 10px 20px;
            background: #00c6ff;
            border: none;
            border-radius: 5px;
            color: white;
            cursor: pointer;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            color: white;
            text-decoration: none;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>🛍️ Product List</h2>

    <form action="addToCart" method="post">

        <div class="products">

            <div class="card">
                <input type="checkbox" name="product" value="Keyboard-800"> Keyboard<br>
                <span class="price">₹800</span>
            </div>

            <div class="card">
                <input type="checkbox" name="product" value="Mouse-500"> Mouse<br>
                <span class="price">₹500</span>
            </div>

            <div class="card">
                <input type="checkbox" name="product" value="Monitor-7000"> Monitor<br>
                <span class="price">₹7000</span>
            </div>

            <div class="card">
                <input type="checkbox" name="product" value="USB Cable-250"> USB Cable<br>
                <span class="price">₹250</span>
            </div>

            <div class="card">
                <input type="checkbox" name="product" value="Laptop Stand-1200"> Laptop Stand<br>
                <span class="price">₹1200</span>
            </div>

        </div>

        <button type="submit">Add to Cart</button>
    </form>

    <a href="viewcart.jsp">🛒 View Cart</a>
</div>

</body>
</html>