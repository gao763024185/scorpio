$(function () {
    //登录验证
    $(".submit_lgbtn").click(function () {
        var unamevalid = /^[a-zA-Z0-9_\u4e00-\u9fa5]{5,10}$/;  //只含有汉字、数字、字母、下划线，下划线位置不限
        var pwdvalid = /^[a-zA-Z]{1}([a-zA-Z0-9]|[_]){4,19}$/;   //只能输入5-20个以字母开头、可带数字或“_”的字串
        var userName = $("#username").val();
        var password = $("#password").val();
        var codeText = $("#codetext").val();
        if (userName == "") {
            alert("用户名不能为空");
            $("#userName").focus();
        } else if (password == "") {
            alert("密码不能为空");
            $("#password").focus();
        } else if (codeText == "") {
            alert("验证码不能为空");
            $("#codetext").focus();
        } else if (!unamevalid.test(userName)) {
            alert("用户名只含有汉子、数字、字母、下划线的5~10位");
            $("#userName").focus();
        } else if (!pwdvalid.test(password)) {
            alert("只能输入5-20个以字母开头、可带数字或“_”的密码");
            $("#password").focus();
        } else {
            var data = {
                userName: userName,
                password: password,
                codeText: codeText
            };
            $.ajax({
                type: 'POST',
                url: "/admin/loginVal",
                data: data,
                dataType: "json",
                success: function (resp) {
                    if (resp.result == 0) {
                        // alert(JSON.stringify(resp.data));
                        // document.cookie = "uid="+resp.data.uid;
                        // document.cookie = "name="+resp.data.userName;
                        window.location.href='/admin/crainnogao_ad'
                    } else {
                        alert(resp.msg);
                    }
                },
                error: function () {
                    alert("失败");
                }

            });
        }
    });
    //点击刷新图片验证码
    $(".noclear").click(function () {
        var time = new Date().getTime();
       document.getElementById("verPic").src="/VerifyCodeServlet?time="+time;
    });

    $(document).on('click','.issuesubmit',function () {
        var logId = $("#logId").val();
        var codeText = $("#codetext").val();
        var logTitle = $("#logTitle").val();
        var logSummary = $("#logSummary").val();
        var logContent = $("#ts").val();
        var data = {
            logId:logId,
            codeText:codeText,
            logTitle:logTitle,
            logSummary:logSummary,
            logContent:logContent
        };
        $.ajax({
            url:"/issue",
            type:"post",
            data:data,
            dateType:"json",
            success:function (data) {
                if(data.result==0){
                    alert("发表成功!");
                    window.location.href='/admin/crainnogao_ad'
                }else{
                    alert("发表失败!")
                }
            },
            error:function(){
                alert("网络连接失败!");
            }
        })
    });
    //删除日志
        $(document).on('click','.delete',function () {
            var logId = $(this).parent().parent().data('id');
            alert(logId);
            var data = {logId:logId};
            var r=confirm("您真的要删了我嘛?");
            if(r==true){
                $.post('/delete',data,function (resp) {
                    if (resp.result==0){
                        window.location.href='/admin/crainnogao_ad';
                    }else {
                        alert("删除失败!")
                    }
                })
            }
        });
    $(document).on('click','.update',function () {
        var logId = $(this).parent().parent().data('id');
        location.href="/admin/crainnogao_ad?logId="+logId;
    });
    //编辑用户
    $(document).on('click','.edit',function () {
        var id = $("#uid").val();
        layer.open({
            type: 2,
            skin: 'layui-layer-rim', //加上边框
            area: ['600px', '400px'], //宽高
            content: ['userEdit?id='+id]
        });
    });
    $(document).on('click','.avatarSubTn',function () {

        // window.close();
        // window.location.href='/admin/crainnogao_ad';
    });
    /** 日志分页 start **/
    var current = 1;
    setTimeout(
        function () {
            var pageNuminit = $('#pageNuminit').val();
            var totalPage = $('#totalPage').val();
            if(pageNuminit==1){
                $('.prevPage').addClass('disabled');
                $('.prevPage').removeAttr("href");
                document.getElementById('prevPage').style.backgroundColor="#f4f5ef";
            }
        }
    ,1000
    );
    $(document).on('click','.prevPage',function () {
        var logTitle = $('#inlogTitle') .val();
        var data = {
            pageNum:current-1,
            item:2,
            logTitle:logTitle
        };
        ajaxFenye(data);
        if(current-1 == 1){
            $('.prevPage').addClass('disabled');
            document.getElementById('prevPage').style.backgroundColor="#f4f5ef";
        }
        current = current-1;
    });
    $(document).on('click','.nextPage',function () {
        var logTitle = $('#inlogTitle') .val();
        var totalPage = $('#totalPage').val();
        var data = {
            pageNum:current+1,
            item:2,
            logTitle:logTitle
        };
        ajaxFenye(data);
        if(current+1 == totalPage){
            $('.nextPage').addClass('disabled');
            document.getElementById('nextPage').style.backgroundColor="#f4f5ef";
        }
        current = current+1;
    });
    //搜索日志
    $(document).on('click','.search-bt',function () {
        var logTitle = $('#inlogTitle') .val();
        var data={logTitle:logTitle,pageNum:1};
        ajaxFenye(data);
    });
        $(document).on('click','.tcdNumber',function () {
            var logTitle = $('#inlogTitle').val();
            var data = {
                pageNum:$(this).index(),
                item:2,
                logTitle:logTitle
            };
            current = $(this).index();
            ajaxFenye(data);
        });

    function ajaxFenye(data) {
        $.ajax({
            url:"/fenye",
            type:"post",
            data:data,
            dataType:"json",
            success:function (resp) {
                var $str = '<table class="table table-hover"><thead><tr><th>日志ID</th><th>主题</th>'+
                    '<th>概要</th><th>上传时间</th><th>更新时间</th><th>操作</th></tr></thead><tbody>';
                for (var i=1;i<=resp.len;i++){
                    $str += '<tr  data-id="'+resp.logs2[i-1].logId+'" class="logId"><td>'+resp.logs2[i-1].logId+'</td><td>'+resp.logs2[i-1].logTitle+'</td>'+
                        '<td>'+resp.logs2[i-1].logSummary+'</td><td>'+resp.logs2[i-1].logCreatedStr+'</td>'+
                        '<td>'+resp.logs2[i-1].logUpdateStr+'</td><td><a class="delete">删除</a>&nbsp;<a class="update">编辑</a></td></tr>';
                }
                document.getElementById("ajshow0").innerHTML=$str;
                var $str1 = '<div class="tcdPageCode">'+
                    '<a href="javascript:;" class="prevPage" id="prevPage"><i class="material-icons">navigate_before</i></a>';
                for(var i=1 ;i<=resp.toPage;i++){
                    if (i==data.pageNum){
                        $str1 += '<a href="javascript:;" class="tcdNumber current">'+i+'</a>';
                    }else{
                        $str1 += '<a href="javascript:;" class="tcdNumber">'+i+'</a>';
                    }
                }
                $str1 += '<a href="javascript:;" class="nextPage" id="nextPage"><i class="material-icons">navigate_next</i></a></div>';
                document.getElementById("fenye").innerHTML=$str1;
            },
            error:function () {
                alert("网络连接失败！");
            }
        })
    }
    /** 日志分页 end **/

    /**  上传头像 **/
    $(".photobtn").change(function(e){
        var that = $(this);
        if(window.FileReader) {
            var file  = e.target.files[0];
            var reader = new FileReader();
            if(file && file.size > 5242880){
                alert("图片大小不能超过5M,您选择的文件太大，请重试");
            }else if(file && file.type.match("image.*") && file.size < 5242880) {
                reader.readAsDataURL(file);
                reader.onload=function(){
                    that.parent().parent().parent().find("img").attr("src",this.result);
                }
            }else{
                alert("请选择小于5M的jpg、png格式的图片");
                that.val('');
                that.parent().find("img").attr("src", "/images/admin.png");
            }
        }else { // 降级处理
            if( !/\.jpg$|\.png$|\.jpeg/i.test($(this).val()) ) {
                alert("请选择小于5M的jpg、png格式的图片");
                $(this).val('');
            }else{
                $(this).parent().find("img").attr("src",$(this).val());
            }
        }
    });
    $(document).on('click','.avatarSubTn',function () {
        // parent.window.location.reload();
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);
    })
});
