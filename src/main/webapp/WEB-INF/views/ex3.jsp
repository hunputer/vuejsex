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
    <div v-if="test=='1'">조건문테스트_1일떄 출력</div>
    <div v-elseif="test=='2'">조건문테스트_2일때 출력</div>
    <div v-else>그외 나머지 출력</div>
</div>
<br />

<script>
    var app = new Vue({
        el: "#app",
        data: {
            test: "2"
        }
    });
</script>
</body>
</html>