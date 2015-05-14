<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
     <script language="javascript">
     var connection;
     
        function onclickAjax(){
            var xmlHttp;
            //分浏览器创建XMLHttp对象
if(window.XMLHttpRequest){
                xmlHttp=new XMLHttpRequest();
            }else if(window.ActiveXObject){
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP")
            }
            //设置请求类型
            xmlHttp.open("POST","comet?uid=1122334455",true);
            //回调函数
            xmlHttp.onreadystatechange=function(){
                if(xmlHttp.readyState==4){
                    if(xmlHttp.status==200){
                        document.getElementById("btn1").value=xmlHttp.responseText + ':' + document.domain;
                    }else{
                        alert("AJAX服务器返回错误！");
                    }    
                }
            }
            //发送请求
            xmlHttp.send();
        }
        
        function onclickcomet(){
        	connection=document.createElement('iframe');
        	connection.setAttribute('id', 'cometid');
        	connection.setAttribute('src', 'comet?uid=1122334455');
        	with (connection.style) {
        		position = "absolute";
				left = top = "500px";
				height = width = "300px";
        	}
        	
        	document.body.appendChild(connection);
        	
        	 // <iframe frameborder="0" name="i" src="comet?uid=1122334455"></iframe>
        }
     </script>
</head>
<body>
This is index.jsp

<p>
<a href="page1-1">page1-1</a><br>
<a href="page1-2">page1-2(this controller not exist)</a><br>
<a href="page1-3?uid=112233">@ResponseBody void</a><br>
<a href="pages/page1.jsp">/pages/page1.jsp</a><br>
<a href="page1">controller function return void</a><br>
<a href="topage1">controller function return string</a><br>
<a href="ModelPage">toModelAndView</a><br>
<a href="cometpage">cometpage</a><br>
<a href="pages/page1.jsp">/pages/page1.jsp</a><br>
<a href="#" onclick="onclickAjax()" >comet</a><br>
</p>

<input type="button" id="btn1" value="test" onclick="onclickAjax()">
<input type="button" id="btn2" value="comet-test" onclick="onclickcomet()">
</body>
</html>