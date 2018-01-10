<%@ page pageEncoding="utf-8" %>
<html>
	<head>
		<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
		<script type="text/javascript">
	
		window.onload = function(){
				
				
				//var js = $('<div id="d1" style="width:100px;height:100px;background:red">dmc</div>');
				
				//$('div').css({width:100,height:100,background:'pink'});
				
				$('div').each(function(i,tag){
					$(tag).css({width:i*100,height:i*100,background:'green'});
				})
				$('p').attr('align','center');
				$('#btn').click(function(){
					$('div').toggle(1000);
					$('#d2').stop();
				});
				
				//$('#d2').remove();
			}
		</script>
	</head>
	
	<body>
		<table align="center" border="1" cellspacing="0" width="80%">
			
			<h2 align="center">汽车信息</h2>
			<p  ><input type="button" value="按钮" id="btn"></input></p>
			
			<thead >
				
				<tr align="center" id="tr">
					<td id="td">编号</td>
					<td>名称</td>
					<td>颜色</td>
					<td>价格</td>
				</tr>
			</thead>
			<tbody id="tb">
				
			</tbody>
		</table>
		<br/>
		<div id="d1">1</div>
		<br>
		<div id="d1">1</div>
		<br>
		<div id="d1">1</div>
		<br>
		<div id="d1">1</div>
		<hr>
		<div id="d2">1</div>
		
	</body>
</html>


























