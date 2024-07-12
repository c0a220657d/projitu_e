<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>スロットマシン</title>
    <style>
        .slot-machine {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 50px;
        }
        .slot {
            margin: 0 10px;
        }
        .controls {
            text-align: center;
            margin-top: 20px;
        }
        .control {
            margin: 0 10px;
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
    <script>
        let slots = [];
        let intervals = [];
        let numbers = [1, 1, 1];
        let move = [false, false, false];
        let speeds = [100, 50, 25]; // 回転速度の設定 (ms)

        function updateMoney() {
            document.getElementById('money').innerText = money;
        }

        function incrementNumber(index) {
            numbers[index]++;
            if (numbers[index] > 9) {
                numbers[index] = 1;
            }
            slots[index].src = 'images/' + numbers[index] + '.png';
        }

        function startSlot(index) {
            intervals[index] = setInterval(() => {
                incrementNumber(index);
            }, speeds[0]); // 最初は最も遅い速度で設定
        }

        function stopSlot(index) {
            clearInterval(intervals[index]);
            move[index] = false;
            if (!move[0] && !move[1] && !move[2]) {
                checkMatch();
            }
        }

        function checkMatch() {
            if (numbers[0] === numbers[1] || numbers[1] === numbers[2] || numbers[0] === numbers[2]) {
                money += 20;
            }
            if (numbers[0] === numbers[1] && numbers[1] === numbers[2]) {
                money += 180;
            }
            updateMoney();
        }

        function startSlots() {
            if (!move[0] && !move[1] && !move[2]){
                if (money >= 20) {
                    money -= 20;
                    updateMoney();
                    for (let i = 0; i < 3; i++) {
                        startSlot(i);
                        move[i] = true;
                    }
                } else {
                    alert("所持金が足りません。");
                }
            }else {
                alert("すべてのスロットを止めてください。");
            }
        }

        function stopSlots() {
            for (let i = 0; i < 3; i++) {
                if (move[i]) {
                    stopSlot(i);
                }
            }
        }

        function changeSpeed(speedIndex) {
            for (let i = 0; i < 3; i++) {
                clearInterval(intervals[i]);
                intervals[i] = null;
                move[i] = false;
                startSlot(i);
            }
            speeds[0] = speedIndex === 0 ? 100 : (speedIndex === 1 ? 50 : 25);
        }

        window.onload = function() {
            for (let i = 0; i < 3; i++) {
                slots[i] = document.getElementById('slot' + i);
            }
            updateMoney();
        }
    </script>
</head>
<body>
    <h1 style="text-align: center;">スロットマシン</h1>
    <div style="text-align: center;">
        <p>所持金: <span id="money">200</span></p>
    </div>
    <div class="slot-machine">
        <img id="slot0" class="slot" src="images/1.png" alt="slot">
        <img id="slot1" class="slot" src="images/1.png" alt="slot">
        <img id="slot2" class="slot" src="images/1.png" alt="slot">
    </div>
    <div class="controls">
        <button class="control" onclick="startSlots()">スタート</button>
        <button class="control" onclick="stopSlot(0)">ストップ1</button>
        <button class="control" onclick="stopSlot(1)">ストップ2</button>
        <button class="control" onclick="stopSlot(2)">ストップ3</button>
        <br>
        <button class="control" onclick="changeSpeed(0)">速度1</button>
        <button class="control" onclick="changeSpeed(1)">速度2</button>
        <button class="control" onclick="changeSpeed(2)">速度3</button>
    </div>
    <a href="home.jsp">Home</a>
</body>
</html>
