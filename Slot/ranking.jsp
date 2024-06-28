<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ランキング表示</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 50%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        table th, table td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        table th {
            background-color: #f0f0f0;
            color: #333;
        }
        table tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        table tbody tr:hover {
            background-color: #f0f0f0;
        }
        a {
            display: block;
            width: 100px;
            text-align: center;
            padding: 10px;
            background-color: #4CAF50;
            color: #fff;
            text-decoration: none;
            margin: 20px auto;
            border-radius: 5px;
        }
        a:hover {
            background-color: #4CAF50;
        }
    </style>
</head>
<body>
    <h1>あなたの得点: 1000</h1>
    
    <h2>ランキング</h2>
    <table>
        <thead>
            <tr>
                <th>順位</th>
                <th>ユーザー名</th>
                <th>得点</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>a</td>
                <td>2000</td>
            </tr>
            <tr>
                <td>2</td>
                <td>b</td>
                <td>1500</td>
            </tr>
            <tr>
                <td>3</td>
                <td>c</td>
                <td>1000</td>
            </tr>
        </tbody>
    </table>
    
    <a href="home.jsp">home</a>
</body>
</html>
