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
    <conponent v-bind:is="test3"></conponent>

</div>
<br />

<script>
    Vue.component('component1', {
        template : '<div>'
             + '<h1>전역 데이터 템플릿 테스트 입니다.</h1>'
             + '<h3>{{var1}}</h3>'
             + '<h3>{{var2}}</h3>'
             + '<h3>{{method_test()}}</h3>'
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

    Vue.component('component3', {
        template : '<div>'
            + '<h1>동적 컴포넌트 테스트 입니다.</h1>'
            + '<div>'
    })

    var app1 = new Vue({
        el : '#app1',
        components : {
            component2 : localComponent
        }
    });
</script>
</body>
</html>