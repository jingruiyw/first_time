<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl实现逻辑操作 -->
<html>
	<head>
		<script>
			window.onload = function (){ 
				var checkAll = document.getElementById('checkAll');
				checkAll.onclick = function(){
					var cnos = document.getElementsByName('cno');
					for(var i=0;i<cnos.length;i++){
						var cno = cnos[i];
						cno.checked = checkAll.checked;
					}
				}	
				
				var trs = document.getElementsByTagName('tr');
				for(var i=1;i<trs.length;i++){
					var tr = trs[i];
					tr.onmouseover = function(){
						this.style.backgroundColor="#cfc";
					}
					tr.onmouseout = function(){
						this.style.backgroundColor="#fff";
					}
				}
			}	
			
			
		</script>
	</head>
	
	<body>
		<h2 align="center">汽车列表</h2>
		<table align="center" border="1" cellspacing="0" width="80%">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkAll"/></th>
					<th>汽车编号</th>
					<th>汽车名称</th>
					<th>汽车颜色</th>
					<th>汽车价格</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
					<c:when test="${cars==null||cars.size()==0}">
						<tr>
							<td align="center" colspan="6">没有任何记录</td>
						</tr>
					</c:when>
					
					<c:otherwise>
						<c:forEach items="${cars }" var="car">
							<tr align="center">
								<td><input type="checkbox" name="cno" value="${car.cno }"/></td>
								<td>${car.cno }</td>
								<td>${car.cname }</td>
								<td>${car.color }</td>
								<td>${car.price }</td>
								<td>
									<a href="">编辑</a>
									<a href="">删除</a>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>	
			</tbody>
		</table>
	</body>
</html>



















