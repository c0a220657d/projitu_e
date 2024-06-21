<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>ユーザログイン</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f0f0f0;
            }
            .login-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .login-container h2 {
                margin-bottom: 20px;
            }
            .login-container input {
                display: block;
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                border-radius: 5px;
                border: 1px solid #ddd;
            }
            .login-container button {
                display: block;
                width: 100%;
                padding: 10px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            .login-container button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>ユーザログイン</h2>
            <form action="LoginServlet" method="post">
                <input type="text" name="userId" placeholder="ユーザID" required>
                <input type="password" name="password" placeholder="パスワード" required>
                <button type="submit">ログイン</button>
            </form>
            <form action="user_entry.jsp" method="get">
                <button type="submit">新規登録へ</button>
            </form>
        </div>
    </body>
</html>
