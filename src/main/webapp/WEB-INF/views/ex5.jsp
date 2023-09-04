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
    <button v-on:click="reverseText">기능테스트</button>
    <div id="textResult"></div>
    <button v-on:click="methodTest">알림테스트</button>
</div>
<br />

<script>
    var app = new Vue({
        el: "#app",
        data: {
            message : "기능테스트"
        },
        methods: {
            methodTest : function (){
                alert("메서드 테스트 입니다.");
            },

            reverseText : function(){
                document.getElementById("textResult").innerText = this.message.split('').reverse().join('');
            }
        }
    });
</script>
</body>
</html>