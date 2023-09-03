<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Vue.js</title>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app">{{ message }}</div>
<div id="app2">
    <div v-if="test=='1'">조건문테스트_true</div>
    <div v-else>조건문테스트_else</div>
</div>
<br />

<script>
    var app = new Vue({
        el: "#app",
        data: {
            message: "Hello Vue!",
        }
    });

    var app2 = new Vue({
        el: "#app2",
        data: {
            test: "2"
        }
    });
</script>
</body>
</html>