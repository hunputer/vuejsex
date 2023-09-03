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
    <div v-if="test=='1'">조건문테스트_1일떄 출력</div>
    <div v-elseif="test=='2'">조건문테스트_2일때 출력</div>
    <div v-else>그외 나머지 출력</div>
</div>
<div id="app3">
    <div v-for="data in data_for">{{data.text}}</div>
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

    var app3 = new Vue({
        el: "#app3",
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