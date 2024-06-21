<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>ホーム画面</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                overflow-x: hidden; /* 横スクロールバーを隠す */
            }
            .container {
                width: 80%;
                margin: auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
            }
            .mypage-icon {
                cursor: pointer;
                font-size: 24px;
            }
            .sidebar {
                height: 100%;
                width: 0;
                position: fixed;
                top: 0;
                left: 0;
                background-color: #333;
                overflow-x: hidden;
                transition: 0.5s;
                padding-top: 60px;
                z-index: 1;
            }
            .sidebar a {
                padding: 10px 15px;
                text-decoration: none;
                font-size: 22px;
                color: #818181;
                display: block;
                transition: 0.3s;
            }
            .sidebar a:hover {
                color: #f1f1f1;
            }
            .closebtn {
                position: absolute;
                top: 20px;
                right: 25px;
                font-size: 36px;
                margin-left: 50px;
            }
            .main-content {
                transition: margin-left 0.5s;
                padding: 16px;
            }
            .button {
                display: block;
                width: 200px;
                padding: 10px;
                margin: 10px auto;
                background-color: #4CAF50;
                color: white;
                text-align: center;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }
            .button:hover {
                background-color: #45a049;
            }
            .grid-container {
                display: grid;
                grid-template-columns: 1fr 1fr;
                grid-template-rows: 1fr 1fr;
                gap: 20px;
                height: 60vh;
                margin: 20px 0;
            }
            .grid-item {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                border: 1px solid #ddd;
                border-radius: 5px;
                padding: 20px;
                background-color: #f9f9f9;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
        </style>
    </head>
    <body>
        <div class="sidebar" id="mySidebar">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
            <h1>マイページ</h1>
        <a href="ranking.jsp">ランキング</a>
        <a href="shop_buy.jsp">アイテム販売</a>
        <a href="shop_sell.jsp">アイテム購入</a>
        <a href="use_item.jsp">所持アイテム</a>
        <a href="user_login.jsp">ログアウト</a>
        </div>

        <div class="main-content">
            <header>
                <div class="logo">
                    <h1>ホームページ</h1>
                </div>
                <div class="mypage-icon" onclick="openNav()">☰</div>
            </header>
            <div class="container">
                <h2>ようこそ、ゲストさん！</h2>
                <p>ここはホームページのメインコンテンツです。</p>
            </div>
            <div class="container">
                <h1>ホーム画面</h1>
                <div class="grid-container">
                    <div class="grid-item">
                        <a href="slot.jsp" class="button">スロット</a>
                        <p>運を試してみよう！</p>
                    </div>
                    <div class="grid-item">
                        <a href="gacha.jsp" class="button">ガチャ</a>
                        <p>素敵なアイテムをゲット！</p>
                    </div>
                    <div class="grid-item">
                        <a href="shop.jsp" class="button">ショップ</a>
                        <p>アイテムを購入しましょう。</p>
                    </div>
                    <div class="grid-item">
                        <a href="user_entry.jsp" class="button">ユーザ登録</a>
                        <p>新規ユーザーはこちらから。</p>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function openNav() {
                document.getElementById("mySidebar").style.width = "250px";
                document.querySelector(".main-content").style.marginLeft = "250px";
            }

            function closeNav() {
                document.getElementById("mySidebar").style.width = "0";
                document.querySelector(".main-content").style.marginLeft = "0";
            }
        </script>
    </body>
</html>
