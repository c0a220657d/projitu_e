<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Capsule-Toy</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .container {
            margin-top: 100px;
        }
        .output {
            font-size: 24px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Capsule-Toy</h2>
    <p>Your credit: <span id="credit">100</span></p>
    <p>You need to spin 10 credits to spin the Gacha Gacha.</p>
    <img src="./images/gachagacha.png">
    <button onclick="playGacha()">spin the gacha</button>
    <div class="output" id="randomNumber"></div>
    <p>Rarity Count:</p>
    <ul id="rarityCount">
        <li>Rarity ☆☆☆: <span id="count3Stars">0</span></li>
        <li>Rarity ☆☆: <span id="count2Stars">0</span></li>
        <li>Rarity ☆: <span id="count1Star">0</span></li>
    </ul>
</div>

<div class="container">
    <h2>Add Credits</h2>
    <p>Administrator privileges credits: <input type="number" id="adminCredits" min="0"></p>
    <p>Password: <input type="password" id="adminPassword"></p>
    <button onclick="addCredits()">Add Credits</button>
</div>

<script>
var count3Stars = 0;
var count2Stars = 0;
var count1Star = 0;

function playGacha() {
    var creditElement = document.getElementById("credit");
    var currentCredit = parseInt(creditElement.textContent);

    // Check if enough credits to play
    if (currentCredit >= 10) {
        // Deduct 10 credits
        var newCredit = currentCredit - 10;
        creditElement.textContent = newCredit;

        // Generate a random number between 1 and 100 (inclusive)
        var randomNumber = Math.floor(Math.random() * 100) + 1;

        // Adjust probability for numbers 1 to 9 (reduce their chance)
        if (randomNumber >= 1 && randomNumber <= 9) {
            // Reduce probability by adjusting the range
            var adjustedProbability = Math.random(); // Generate another random number
            if (adjustedProbability < 0.5) {
                // Increase the number to be outside the 1-9 range
                randomNumber = Math.floor(Math.random() * 91) + 10; // 10 to 100
            }
        }

        // Determine rarity based on randomNumber
        var rarity = '';
        if (randomNumber >= 1 && randomNumber <= 9) {
            rarity = 'Rarity: ☆☆☆';
            count3Stars++;
        } else if (randomNumber >= 10 && randomNumber <= 30) {
            rarity = 'Rarity: ☆☆';
            count2Stars++;
        } else {
            rarity = 'Rarity: ☆';
            count1Star++;
        }

        // Display the random number and rarity
        document.getElementById("randomNumber").innerHTML = "Capsule Number: " + randomNumber + '<br>' + rarity;
        updateRarityCount();

    } else {
        alert("Your credits are insufficient");
    }
}

function addCredits() {
    var adminCredits = parseInt(document.getElementById("adminCredits").value);
    var adminPassword = document.getElementById("adminPassword").value;

    // Check if password is correct (assuming password is "0000")
    if (adminPassword === "0000") {
        if (!isNaN(adminCredits) && adminCredits > 0) {
            var creditElement = document.getElementById("credit");
            var currentCredit = parseInt(creditElement.textContent);
            var newCredit = currentCredit + adminCredits;
            creditElement.textContent = newCredit;
            alert(adminCredits + " Credit has been added successfully.");
        } else {
            alert("Please enter a valid number of credits.");
        }
    } else {
        alert("Incorrect password. You are not authorized to add credits.");
    }
}

function updateRarityCount() {
    document.getElementById("count3Stars").textContent = count3Stars;
    document.getElementById("count2Stars").textContent = count2Stars;
    document.getElementById("count1Star").textContent = count1Star;
}
</script>
<a href="home.jsp">Home</a>

</body>
</html>
