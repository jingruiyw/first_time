<%@page pageEncoding="utf-8" %>
<html>
	<head>
		<style>
			span{
			position:absolute;
			padding-left:4px;
			
			color:red;
			font-size:14px;
			}
		</style>
	
		<script>
			window.onload = function(){
				var saveForm = document.getElementById('saveForm');
				saveForm.onsubmit = function(){
					var cname = document.getElementById('cname');
					var color = document.getElementById('color');
					var price = document.getElementById('price');
					
					var f= true;
					
					var msg = cname.nextElementSibling;
					if(cname.value==''){
						msg.innerHTML = '汽车名称必填';
						f=false;
					}else{
						msg.innerHTML='';
					}
					
					var msg = color.nextElementSibling ;
					var reg = /(white)|(red)|(black)|(blue)/;
					if(!reg.test(color.value)){
						msg.innerHTML = '请填写正确的颜色';
						f=false;
					}else{
						msg.innerHTML = '';
					}
					
					var msg = price.nextElementSibling;
					var reg = /^\d+$/ ;
					if(!reg.test(price.value)){
						msg.innerHTML = '请正确填写价格';
						f=false;
					}else{
						msg.innerHTML = '';
					}
					return f;
				}				
			}
		</script>
	</head>
	<body>
		<h2 align="center">添加信息</h2>
		<form id="saveForm" action="save.do" method="post">
			<table align="center">
				<tr>
					<td>汽车名称:</td>
					<td><input type="text"name="cname" id="cname" /><span ></span></td>					
				</tr>
				
				<tr>
					<td>汽车颜色:</td>
					<td><input type="text"name="color" id="color" /><span></span></td>					
				</tr>
				
				<tr>
					<td>汽车价格:</td>
					<td><input type="text"name="price" id="price" /><span></span></td>					
				</tr>
				
				<tr>
					<td colspan="2" align="center" >
						<input type="submit"/><span></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>