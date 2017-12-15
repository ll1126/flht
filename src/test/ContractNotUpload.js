var State;
var page = 1;   //页数
var pageSize = 10;  //每页显示数
//页面加载时调用
$(function(){
	State = $("#State").val();
	
	//加载 内容类型
	loadContentType();
	//加载 提交人组别
	loadDepartment();
	//加载 未上传合同的渠道列表
	loadContractNotUpload();
	//加载 总页数之类的...
	loadAllPage();
	//查询按钮  的单击事件
	$("#search").on("click",loadContractNotUpload);
	//当提交人组别的选择发生改变时 显示提交人姓名
	$("#submit-group").change(function(){
		//获取提交人组别的value
		var group = $("#submit-group option:selected").val();
		//清空下拉选
		$("#submit-name").html("");
		//显示全部
		var option = "<option value=''>全部</option>";
		$("#submit-name").append(option);
		//如果组别为空
		if(group==""){
			//显示全部
			var option = "<option value=''>全部</option>";
			$("#submit-name").append(option);
			return;
		}
		//组别不为空
		var url = "/Channel/Contract/loadEmp.do";
		var data = {"group":group};
		$.post(url,data,function(result){
			if(result.state==0){
				var list  = result.data;
				for(var i=0;i<list.length;i++){
					var option = "<option value="+list[i].id+">"+list[i].name+"</option>";
					$("#submit-name").append(option);
				}
			}else{
				alert(result.message);
			}	
		});
	});
	
	
	
	
});

function loadAllPage(){
	var url = "loadAllPage.do";
	var data={
			"page":page,
			"pageSize":pageSize
			
	};
	$.post(url,data,function(result){
		if(result.state==0){
			
		}else{
			alert(result.message);
		}
	});
	
}




function loadContractNotUpload(){
	//获取用户输入的条件
	
	var channel_type =$("#channel-type").val(); //渠道类型
	var content_type =$("#content-type").val(); //内容类型
	console.log(content_type);
	var submit_group =$("#submit-group").val(); //提交人组别
	var submit_name =$("#submit-name").val();   //提交人
	var txtSeach =$("#txtSeach").val();         //渠道名称
	//设置请求参数
	var url = "/Channel/Contract/loadContractNotUpload.do";
	var data={
			"page":page,
			"pageSize":pageSize,
			"TypeId":channel_type,
			"State":State,
			"ContentTypeId":content_type,
			"department_id":submit_group,
			"Applicant":submit_name
			
			//"txtSeach":txtSeach
		};
	//发起请求
	$.post(url,data,function(result){
		
		if(result.state==0){
			//获取list
			var list = result.data;
			//清空tbody
			$("#channel-tbody").html("");
			for(var i = 0;i<list.length;i++){
				//当前处理人还没有
				var map = list[i];
				var tr = Contract.replace('[Id]',map.Id).replace('[Name]',map.Name).replace('[TypeName]',map.TypeName).replace('[nType]',map.nType)
						.replace('[department]',map.department).replace('[name1]',map.name1).replace('[name2]',map.name2).replace('[Id]',map.name3);

				$("#channel-tbody").append(tr);
			}
			
			
		}else{
			alert(result.message);
		}
	});
	
	
}


function loadDepartment(){
	//设置请求参数
	var url = "/Channel/Contract/loadDepartment.do";
	var data = {};
	//发起请求
	$.post(url,data,function(result){
		if(result.state==0){
			var list = result.data;
			//添加option
			for(var i = 0;i<list.length;i++){
				var option = "<option value="+list[i].id+">"+list[i].department+"</option>";
				$("#submit-group").append(option);
			}
		}else{
			alert(result.message);
		}
	});
}

function loadContentType(){
	//设置请求参数
	var url = "/Channel/Contract/loadContentType.do";
	var data = {};
	//发起请求
	$.post(url,data,function(result){
		if(result.state==0){
			var list = result.data;
			//添加option
			for(var i = 0;i<list.length;i++){
				var option = "<option value="+list[i].id+">"+list[i].name+"</option>";
				$("#content-type").append(option);
			}
		}else{
			alert(result.message);
		}
		
	});
	
}

var Contract = "<tr>"+
				"<th>[Id]</th>"+
				"<th>[Name]</th>"+
				"<th>[TypeName]</th>"+
				"<th>[nType]</th>"+
				"<th>[department]</th>"+
				"<th>[name1]</th>"+
				"<th>[name2]</th>"+
				"<th>[name3]</th>"+
				"<th>[Id]</th>"+
				"</tr>";
