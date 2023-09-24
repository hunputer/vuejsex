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
    <component1></component1>
    <component2></component2>
</div>
<br />

<script>
    Vue.component('component1', {
        template : '<div>'
             + '<h1>데이터 템플릿</h1>'
             + '<span>{{var1}}</span>'
             + '<span>{{var2}}</span>'
             + '<span>{{method_test()}}</span>'
             + '</div>',
        data : function (){
            const rtn = {
                var1 : '${var1}',
                var2 : '${var2}'
            }
            return rtn;
        },
        methods : {
            method_test : function(){
                return '메서드 테스트'
            }
        }
    })

    var localComponent = {
        template : '<h1>지역템플릿 테스트 입니다.</h1>'
    }

    var app1 = new Vue({
        el : '#app1',
        component : {
            component2 : localComponent
        }
    });
</script>
</body>
</html>