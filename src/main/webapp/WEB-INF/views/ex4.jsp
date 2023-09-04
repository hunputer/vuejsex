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
    <div v-for="data in data_for">{{data.text}}</div>
</div>
<br />

<script>
    var app = new Vue({
        el: "#app",
        data: {
            data_for:[
                {text : 1},
                {text : 2},
                {text : 3}
            ]
        }
    });
</script>
</body>
</html>