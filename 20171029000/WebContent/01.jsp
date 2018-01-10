<%@ page pageEncoding="utf-8"%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
		
		<script type="text/javascript" src="easyui/jquery-1.11.3.js"></script>
		<script type="text/javascript" src="easyui/jquery.min.js"></script>
		<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
		
		<script type="text/javascript">
			$(function(){
				/*$('#d2').layout({fit:true});
				$('#d2').layout('add',{
					region:'west',
					width:220,
					title:'主菜单'
				});
				
				$('#d2').layout('add',{
					region:'north',
					height:200,
					title:'登录界面'
					
				});
				
				$('#d2').layout('add',{
					region:'center',
					title:'列表',
				});*/
				
				var users =[
				            {uno:'1001',uname:'jr1',upass:'000',truename:'JR1',flag:'1'},
				            {uno:'1002',uname:'jr2',upass:'000',truename:'JR2',flag:'1'},
				            {uno:'1003',uname:'jr3',upass:'000',truename:'JR3',flag:'1'},
				            {uno:'1004',uname:'jr4',upass:'000',truename:'JR4',flag:'1'},
				            {uno:'1005',uname:'jr5',upass:'000',truename:'JR5',flag:'1'},
				            ]
				
				$('#tab').datagrid({
					columns:[
					 	[
					 	 {field:'uno',title:'用户编号',width:100,align:'center'},
					 	 {field:'uname',title:'用户名',widtth:100,align:'center'},
					 	 {field:'upass',title:'密码',widtth:100,align:'center'},
					 	 {field:'truename',title:'真实姓名',widtth:100,align:'center'},
					 	 {field:'flag',title:'状态',widtth:100,align:'center'},
					 	 ]	
					 ],
					 
					 data:users,
					 
					 //fit:true,
					 fitColumns:true
				});
				
				
			});
		</script>
	</head>
	<body>
		
		<div id="d2"></div>
		<div id="d1"></div>
		<table id="tab"></table>
	</body>
</html>

























