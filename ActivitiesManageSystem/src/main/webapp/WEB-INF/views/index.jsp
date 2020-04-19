<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<style type="text/css">
	h2 {
		text-align: center;
	}
	a{
		text-decoration:none;
	}
	table {
		border: 1px solid black;
		border-collapse: collapse;
		margin-left: auto;
		margin-right: auto;
		width: 800px;
	}
	
	td, th {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 5px;
		text-align: center;
		white-space: nowrap;
	}
	.btn{
		color: #0072E3;
	}
	
	input[type='button'] {
		width: 100px;
		height: 30px;
		border: 1px;
		background: #0072E3;
		color: white;
	}

</style>
</head>
<body>
	<h2>活动管理</h2>
	<center><input type="button" value="新增" onclick="location='add'"></center>
	<br>
	<table>
		<thead>
			<tr>
				<th class="width-40">序号</th>
				<th class="width-120">活动类型</th>
				<th class="width-200">活动开始时间</th>
				<th class="width-200">活动结束时间</th>
				<th class="width-120">活动地点</th>
				<th class="width-120">活动人数</th>
				<th class="width-40">操作</th>
			</tr>
		</thead>
		<tbody id="tbodyId">
			<tr>
				<td colspan="7">Data is loading ...</td>
			</tr>
		</tbody>
	</table>
	<script src="/js/jquery.min.js"></script>
	<script src="/js/activity.js"></script>
	<script type="text/javascript">
		$(function() {
			doGetObjects();
		});
	</script>
</body>
</html>