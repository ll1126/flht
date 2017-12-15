function login() {
    var $submit_application = $("#form1");
    var userName = document.getElementById("UserName").value;
    var passWord = document.getElementById("Password").value;
    var flag=true;
    if(userName.replace(/(^s*)|(s*$)/g, "").length ==0){
        alert("用户名不能为空");
        $("#UserName").css({"color":"red"});
        flag=false;
    }
    if(passWord.replace(/(^s*)|(s*$)/g, "").length ==0){
        alert("密码不能为空");
        $("#Password").css({"color":"red"});
        flag=false;
    }
    if(flag)
    {
        $.ajax({
            type:"post",
            data:{"username":userName,"pwd":passWord},
            url:"user/login.do",
            async: false,
            dataType:"json",
            success: function(data){
                if(data.code==0){
                    //	alert(data.data.name);
                    addCookie("id", data.content.id,1);
                    addCookie("username", data.content.userName,1);
                    addCookie("power", data.content.power,1);
                    window.location.href="index.html";
                }else{
                	alert(data.message);
				}

            },
            error:function(e){
                alert("登录失败");

            }

        });


    }
}


function updatePwd(){
	var userName = getCookie("username");
	var oldpwd=$("#oldPassword").val().trim();
	var newpwd=$("#newPassword").val().trim();
	var checkpwd=$("#checkPassword").val().trim();
	var ok=true;
	if(oldpwd==""){
		document.getElementById("pwdMessage").innerHTML = '原密码不能为空';
		ok=false;
	}
	if(newpwd==""){		document.getElementById('newPwdMessage').innerHTML = '新密码不能为空';
		ok=false;
	}else if(newpwd.length<6){
		document.getElementById('newPwdMessage').innerHTML = '密码长度过短';
		ok=false;
	}
	if(newpwd != checkpwd){
		document.getElementById('checkPwdMessage').innerHTML = '前后密码不一致';
		ok=false;
	}
	if(ok){
		$.ajax({
			url:"user/updatePwd.do",
			type:"post",
			data:{"userName":userName,"oldpwd":oldpwd,"newpwd":newpwd},
			datatype:"json",
			success:function(result){
				if(result.code==0){
					alert("修改密码成功");
					window.location.href="index.html";
				}
				if(result.code==1){
					alert("原密码输入错误");
				}
			},
			error:function(){
				alert("修改密码失败！");
			}
		});
	}
	
}

function closeWindow(){
	
	window.location.href="../login.html";
}

    
