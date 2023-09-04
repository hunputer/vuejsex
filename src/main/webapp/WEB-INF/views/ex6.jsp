<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Vue.js</title>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div id="app">
    <div>{{message}}</div>
    <input v-model="message">
</div>
<br />

<script>
    var app = new Vue({
        el: "#app",
        data: {
            message : "양방향 테스트"
        }
    });
</script>
</body>
</html>