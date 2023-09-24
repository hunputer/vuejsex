<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Vue.js</title>
    <script src="https://cdn.jsdelivr.net/npm/vue@2.5.2/dist/vue.js"></script>
</head>
<body>
<div id="app1">
    <component2></component2>
</div>
<br />

<script>
    var localComponent = {
        template : '<h1>지역템플릿 테스트 입니다.</h1>'
    }

    var app1 = new Vue({
        el : '#app1',
        components : {
            component2 : localComponent
        }
    });
</script>
</body>
</html>