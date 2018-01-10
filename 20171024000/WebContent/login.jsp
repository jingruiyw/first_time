<%@ page pageEncoding="utf-8"%>
<html>
	<head>	
		<script type="text/javascript">
			window.onload = function(){
			
				var btn = document.getElementById('btn');
				
				btn.onclick = function(){
					
					var uname = document.getElementById("uname");
					var upass = document.getElementById("upass");
					
					//发送ajax请求
					var xhr = new XMLHttpRequest();
					xhr.open('get','login.do?uname='+uname.value+'&upass='+upass.value,true);
					
	
					
					xhr.onreadystatechange =function(){
						
						//alert(xhr.readyState);
						
						if(xhr.readyState==4&&xhr.status==200){
							alert('ok');
							execute(xhr.responseText);							
						}					
					}
					xhr.send();					
				}
				
				execute = function(resp){
					if(resp=="true"){
						location = "show.jsp";
					}else{
						if(resp=="false"){
							var msg = document.getElementById("msg");
							msg.innerHTML='用户名密码错误';
						}
					}
				}
			}
			
		</script>
	</head>
	
	<body>
		<form action="login.do">	
			<h2 align="center">登录界面</h2>
			<table align="center">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="uname" id="uname" /></td>					
				</tr>
				
				<tr>
					<td>密码：</td>
					<td><input type="password" name="upass" id="upass" /></td>					
				</tr>
				
				<tr>
					<td align="center" colspan="2"  ><input type="button" value="点我" id="btn"/></td>				
				</tr>
				
			</table>
			<p id = "msg" align="center" ></p>
			
		</form>
	</body>
</html>