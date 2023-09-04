<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Vue.js</title>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div id="app">
    <button v-on:click="getData">get user</button>
    <br>
    <div v-for="(data, idx) in user">{{data.name}}{{idx+1}}</div>
</div>
<br />

<script>
    var app = new Vue({
        el: "#app",
        data: {
            user : []
        },
        methods: {
            getData(){
                var vm = this;
                axios.get('https://jsonplaceholder.typicode.com/users/')
                    .then((result) => {
                        console.log(result);
                        vm.user = result.data;
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                    .finally(() => {
                        console.log("finally");
                    })
            }
        }
    });
</script>
</body>
</html>