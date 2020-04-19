//基于jquery中的ajax函数获取服务端活动信息,并更新到页面的tbody位置.
		function doGetObjects() {
			//1.定义url
			var url = "doGetObject";
			//2.发送异步请求获取数据
			$.getJSON(url, function(result) {//result为服务端返回结果
				//debugger;
				doHandleQueryResult(result);
			});
		};
		//迭代result,并将activities信息呈现到页面上
		function doHandleQueryResult(result) {
			var trs = "";
			var count = 1;
			for (var i = 0; i < result.length; i++, count++) {
				trs += "<tr>" + "<td>" + count + "</td>" + "<td>"
						+ result[i].data.type + "</td>" + "<td>" + result[i].startTime
						+ "</td>" + "<td>"
						+ result[i].endTime
						+ "</td>"+"<td>"
						+ result[i].data.locus
						+ "</td>"+"<td>"
						+ result[i].data.num
						/*+ "</td>" + "<td><a href='"+result[i].url+"?id="+result[i].data.id+"'>"+result[i].operation+"</a></td>"*/
						+ "</td>" + "<td class='btn' id='"+result[i].url+","+result[i].data.id+"' onclick='deleteOrUpdate(this)'>"+result[i].operation+"</td>"
						+ "</tr>";
			}
			$("#tbodyId").html(trs);
		}
		
		function deleteOrUpdate(t){
			//alert($(t).prop("id"));
			//debugger;
			var str = new Array();
			str =  $(t).prop("id").split(",");
			//alert(str[0]);
			if("doDeleteObject"==str[0]){
				$.ajax({
			    	   url:str[0],//必写,后面的参数可以不写用默认
			    	   type:"post",//请求类型
			    	   data:"id="+str[1],//请求参数
			    	   dataType:"json",//响应数据类型
			    	   async:true,//异步
			    	   success:function(result){
			    		   if(result.status == 200){
			    			   alert("删除成功！！！");
			    			   window.location.href="index";
			    		   }else if(result.status == 201){
			    			   alert(result.message);
			    		   }
			    	   }
			       });
				
			}else if("update"==str[0]){
				window.location.href=str[0]+"?id="+str[1];
			}
		}
		
