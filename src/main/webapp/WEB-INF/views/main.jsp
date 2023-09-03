<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Vue.js</title>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app">{{ message }}</div>
<br />

<script>
    var app = new Vue({
        el: "#app",
        data: {
            message: "Hello Vue!",
        }
    });
</script>
</body>
</html>