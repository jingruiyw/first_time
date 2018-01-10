<%@ page pageEncoding="utf-8" import='com.domain.Car'%>
<html>
	<head>
		<script>
			window.onload = function(){
				//加载时就获取展示数据
				
				var xhr = new XMLHttpRequest();//创建对象
				xhr.open('get','show.do?',true);//设置请求信息
				xhr.onreadystatechange = function(){//设置响应处理
					if(xhr.readyState ==4&& xhr.status==200){
						//alert(xhr.responseText);
						execute(xhr.responseText);
					}
				}
				xhr.send();		//发送请求		
			}			
			function execute(r){
		
				r = eval(r);
				
				alert(r.length);
				
				for(var i=0;i<r.length;i++){
				var c  =r[i];
				
				//将汽车信息装到表格里
				var tr = document.createElement('tr');
				tr.align='center';
				var td1 = document.createElement('td');
				var td2 = document.createElement('td');
				var td3 = document.createElement('td');
				var td4 = document.createElement('td');

				td1.innerHTML = c.cno;
				td2.innerHTML = c.cname;
				td3.innerHTML = c.color;
				td4.innerHTML = c.price;
				
				var tbody = document.getElementById("tb");
				tbody.appendChild(tr);
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);

				}
			}
				
		</script>
	</head>
	<body>
		<h2 align = 'center'>汽车详细信息</h2>
		<table align ="center" border="1" cellspacing ="0" width="90%">
			<thead>
				<tr align="center">
					<th>编号</th>
					<th>名称</th>
					<th>颜色</th>
					<th>价格</th>
				</tr>				
			</thead>
			<tbody id="tb">
			
			</tbody>
		</table>
	</body>
</html>






























