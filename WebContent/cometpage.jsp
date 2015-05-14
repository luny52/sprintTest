<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>FirstTest.html</title>
     <script language="javascript">
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
                        document.getElementById("btn1").value=xmlHttp.responseText;
                    }else{
                        alert("AJAX服务器返回错误！");
                    }    
                }
            }
            //发送请求
            xmlHttp.send();
        }
        
        function Change(str){ 
            window.document.getElementById("div1").innerText=str; 
       } 
        
        function htmlfile_test(){ 
            var ifrpush = new ActiveXObject("htmlfile"); // 创建对象 
            ifrpush.open(); //打开
            var ifrDiv = ifrpush.createElement("div"); //添加一个DIV
            ifrpush.appendChild(ifrDiv); //添加到 htmlfile
            ifrpush.parentWindow.Change=Change; //注册 javascript 方法   搞不明白为什么还要注册
            ifrDiv.innerHTML = "<iframe src='comet?uid=1122334455'></iframe>"; //在div里添加 iframe
            ifrpush.close(); //关闭
            
        } 
        
     </script>
  </head>
  
  <body>
    <input type="button" id="btn1" value="test" onclick="onclickAjax()">
    <div id="testid">
    </div>
     <iframe frameborder="0" name="i" src="comet?uid=1122334455"></iframe> 
            <div style=" float:left">now time is：</div> 
        <div id="div1"></div> 
         <input type="button" id="btn2" value="htmlfile-test" onclick="htmlfile_test()">
  </body>
</html>