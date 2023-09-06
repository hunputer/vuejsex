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

        #insertModal{
            width: 500px;
            height: 700px;
            margin: auto;
        }
    </style>
</head>
<body id="axiosBody">
<div id="app">
    <button v-on:click="getUser">get user</button>
    <button v-on:click="popUpRegForm">추가</button>
    <br>
    <div v-for="(data, idx) in user" :key="data.id">
        <span>{{data.name}}</span>
        <button v-on:click="deleteUser(data.id, $event)">삭제</button>
    </div>
</div>
<br />

<div id="insertModal" class="white-bg" style="display:none;">
    <h4>등록창</h4>
    <div>아이디 : <textarea id="userId"></textarea></div>
    <div>나이 : <textarea id="userAge"></textarea></div>
    <button v-on:click="insertUser">등록</button>
    <button v-on:click="closeModal">닫기</button>
</div>

<script>
    var app = new Vue({
        el: "#app",
        data: {
            user : []
        },
        methods: {
            getUser(){
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
            popUpRegForm(){
                document.getElementById("axiosBody").classList.add("black-bg");
                document.getElementById("insertModal").style.display = "block";
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
                var id = document.getElementById("userId").value;
                var age = document.getElementById("userAge").value;
                axios.delete('http://localhost:8080/service/insertUser', {
                    params : {
                        id : id,
                        age : age
                    }
                })
                    .then((result) => {
                        alert("등록되었습니다.")
                        this.getUser();
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
</script>
</body>
</html>