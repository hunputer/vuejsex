<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Vue.js</title>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <style>
        body {
            margin : 0;
        }
        div {
            box-sizing: border-box;
        }
        .black-bg {
            width: 100%; height:100%;
            background: rgba(0,0,0,0.5);
            position: fixed; padding: 20px;
        }
        .white-bg {
            width: 100%; background: white;
            border-radius: 8px;
            padding: 20px;
        }

        #insertModal, #updateModal{
            width: 500px;
            height: 700px;
            margin: auto;
        }
    </style>
</head>
<body id="axiosBody">
<div id="app">
    <button v-on:click="getAllUsers">get user</button>
    <button v-on:click="popUpRegForm">추가</button>
    <br>
    <div v-for="(data, idx) in user" :key="data.id">
        <span>{{data.name}}</span>
        <button v-on:click="popUpUpdateForm(data.id, $event)">등록</button>
        <button v-on:click="deleteUser(data.id, $event)">삭제</button>
    </div>
</div>
<br />

<div id="insertModal" class="white-bg" style="display:none;">
    <h4>등록창</h4>
    <div>아이디 : <textarea id="userName"></textarea></div>
    <div>나이 : <textarea id="userAge"></textarea></div>
    <button v-on:click="insertUser">등록</button>
    <button v-on:click="closeModal">닫기</button>
</div>

<div id="updateModal" class="white-bg" style="display:none;">
    <h4>수정창</h4>
    <input id="userid_update" type="hidden">
    <div>아이디 : <textarea id="userName_update"></textarea></div>
    <div>나이 : <textarea id="userAge_update"></textarea></div>
    <button v-on:click="insertUser">수정</button>
    <button v-on:click="closeUpdateModal">닫기</button>
</div>

<script>
    var app = new Vue({
        el: "#app",
        data: {
            user : []
        },
        methods: {
            getAllUsers(){
                var vm = this;
                axios.get('http://localhost:8080/users')
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
                axios.delete('http://localhost:8080/users/'+id)
                    .then((result) => {
                        alert("삭제되었습니다.")
                        this.getUser();
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                    .finally(() => {
                        console.log("finally");
                    })
            },
            getUser(id, event){
                axios.get('http://localhost:8080/users/'+id)
                    .then((result) => {
                        var data = result.data;
                        document.getElementById("userName_update").value = data.name;
                        document.getElementById("userAge_update").value = data.age;
                        document.getElementById("userid_update").value = data.id;
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                    .finally(() => {
                        console.log("finally");
                    })
            },
            popUpRegForm(){
                document.getElementById("axiosBody").classList.add("black-bg");
                document.getElementById("insertModal").style.display = "block";
            },
            popUpUpdateForm(id, event){
                this.getUser(id, event)

                document.getElementById("axiosBody").classList.add("black-bg");
                document.getElementById("updateModal").style.display = "block";
            }
        }
    });

    var app2 = new Vue({
        el: "#insertModal",
        data: {
            user : []
        },
        methods: {
            insertUser(){
                var name = document.getElementById("userName").value;
                var age = document.getElementById("userAge").value;
                var data = new FormData();
                data.append("name",name);
                data.append("age", age);
                axios.post('http://localhost:8080/users', {"name" : name, "age" : age})
                    .then((result) => {
                        alert("등록되었습니다.")
                        app.getUser();
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                    .finally(() => {
                        console.log("finally");
                    })
            },
            closeModal(){
                document.getElementById("axiosBody").classList.remove("black-bg");
                document.getElementById("insertModal").style.display = "none";
            }
        }
    });

    var app3 = new Vue({
        el: "#updateModal",
        data: {
            user : []
        },
        methods: {
            updateUser(){
                var name = document.getElementById("userName").value;
                var age = document.getElementById("userAge").value;
                var data = new FormData();
                data.append("name",name);
                data.append("age", age);
                axios.post('http://localhost:8080/users', {"name" : name, "age" : age})
                    .then((result) => {
                        alert("등록되었습니다.")
                        app.getUser();
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                    .finally(() => {
                        console.log("finally");
                    })
            },
            closeUpdateModal(){
                document.getElementById("axiosBody").classList.remove("black-bg");
                document.getElementById("updateModal").style.display = "none";
            }
        }
    });
</script>
</body>
</html>