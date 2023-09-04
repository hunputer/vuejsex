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
    <div v-for="(data, idx) in user" :key="data.id">
        <a v-on:click="deleteUser(data.id, $event)">{{data.name}}</a>
    </div>
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
                axios.get('http://localhost:8080/service/getUser')
                    .then((result) => {
                        this.user = result.data;
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                    .finally(() => {
                        console.log("finally");
                    })
            },
            deleteUser(id, event){
                var vm = this;
                axios.delete('http://localhost:8080/service/deleteUser', {
                    params : {
                        id : id
                    }
                })
                    .then((result) => {
                        alert("삭제되었습니다.")
                        this.getData();
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