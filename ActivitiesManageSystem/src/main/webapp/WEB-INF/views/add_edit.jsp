<%@ page pageEncoding="utf-8"%>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>新增</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
h2 {
	text-align: center;
	font-size: 26px;
}

table {
	margin: 30px auto;
	text-align: center;
	border-collapse: collapse;
	width: 36%;
	border: 1px solid black;
}
td{
	white-space: nowrap;
}
input, select, textarea{
	width: 280px;
	height: 30px;
	border: 1px solid #999;
	text-indent: 5px;
	font-size: 15px;
	text-align: left;
	background: white;
}

input[type='submit'], input[type='button'] {
	width: 100px;
	height: 30px;
	border: 1px;
	background: #0072E3;
	color: white;
	text-align: center;
}

td.must:after {
	content: '  *';
	color: red;
	font-size: 20px;
}

td.ac {
	text-align: right;
	width: 140px;
}

#time{
	background-image: url(/image/timg.jpg);/*设置小图标为背景*/
	background-size:30px 30px;/*设置小图标的 大小*/
	background-position: 250px 0px;/*设置小图标的位置*/
	background-repeat:no-repeat ;/*设置小图标不重复*/
	border: 1px solid gray;
}
textarea {
	height: 100px;
	font-size: 15px;
}
</style>
<script src="/laydate/laydate.js"></script>
<script type="text/javascript">
	//日期时间选择器
	laydate.render({
	  elem: '#time'
	  ,type: 'datetime'
	});
</script>
</head>
<body>
	<!-- body-start  -->
	<form action="doAddObject" method="POST">
		<table>
			<tr><td colspan="2" id="new" style="background: #0072E3;color: white;text-align:left">新增</td></tr>
			<tr>
				<td class="must ac">活动类型:</td>
				<td><select name="type" required="required">
						<option value="羽毛球活动">羽毛球活动</option>
						<option value="篮球活动">篮球活动</option>
						<option value="乒乓球活动">乒乓球活动</option>
						<option value="攀岩活动">攀岩活动</option>
						<option value="游泳活动">游泳活动</option>
				</select></td>
			</tr>
			<tr>
				<td class="must ac">活动开始时间:</td>
				<td><input type="text" name="startTime" id="time"
					placeholder="请点击选择日期和时间.." required="required"/></td>
			</tr>
			<tr>
				<td class="must ac">活动时长(小时):</td>
				<td><input type="number" name="duration" placeholder="请输入正整数的小时时间..." required="required"
				     min="1" max="24" step="1"/></td>
			</tr>
			<tr>
				<td class="must ac">活动地点:</td>
				<td><input type="text" name="locus" required="required"/></td>
			</tr>
			<tr>
				<td class="must ac">活动人数:</td>
				<td class="b"><input type="number" name="num" required="required" min="1" step="1" placeholder="请输入正整数人数..."/></td>
			</tr>
			<tr>
				<td class="ac">备注:</td>
				<td><textarea placeholder="备注..." name="remark"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存" /> <input
					type="button" value="取消" onclick="location='index'" /></td>
			</tr>
		</table>
	</form>
</body>
<!-- body-end  -->
</html>



