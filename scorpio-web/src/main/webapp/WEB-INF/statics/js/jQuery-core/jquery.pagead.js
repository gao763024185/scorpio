(function($){
	var totalPage = $("#totalPage").val();
	var ms = {
		init:function(obj,args){
			return (function(){
				ms.fillHtml(obj,args);
				ms.bindEvent(obj,args);
			})();
		},
		//填充html
		fillHtml:function(obj,args){
			return (function(){
				obj.empty();
				//上一页
				if(args.current > 1){
					obj.append('<a href="javascript:;" class="prevPage"><i class="material-icons">navigate_before</i></a>');
				}else{
					obj.remove('.prevPage');
					obj.append('<span class="disabled"><i class="material-icons">navigate_before</i></span>');
				}
				//中间页码
				if(args.current != 1 && args.current >= 4 && args.pageCount != 4){
					obj.append('<a href="javascript:;" class="tcdNumber">'+1+'</a>');
				}
				if(args.current-2 > 2 && args.current <= args.pageCount && args.pageCount > 5){
					obj.append('<span>...</span>');
				}
				var start = args.current -2,end = args.current+2;
				if((start > 1 && args.current < 4)||args.current == 1){
					end++;
				}
				if(args.current > args.pageCount-4 && args.current >= args.pageCount){
					start--;
				}
				for (;start <= end; start++) {
					if(start <= args.pageCount && start >= 1){
						if(start != args.current){
							obj.append('<a href="javascript:;" class="tcdNumber">'+ start +'</a>');
						}else{
							obj.append('<span class="current">'+ start +'</span>');
						}
					}
				}
				if(args.current + 2 < args.pageCount - 1 && args.current >= 1 && args.pageCount > 5){
					obj.append('<span>...</span>');
				}
				if(args.current != args.pageCount && args.current < args.pageCount -2  && args.pageCount != 4){
					obj.append('<a href="javascript:;" class="tcdNumber">'+args.pageCount+'</a>');
				}
				//下一页
				if(args.current < args.pageCount){
					obj.append('<a href="javascript:;" class="nextPage"><i class="material-icons">navigate_next</i></a>');
				}else{
					obj.remove('.nextPage');
					obj.append('<span class="disabled"><i class="material-icons">navigate_next</i></span>');
				}
			})();
		},
		//绑定事件
		bindEvent:function(obj,args){
			return (function(){
				obj.on("click","a.tcdNumber",function(){
					var current = parseInt($(this).text());
					ms.fillHtml(obj,{"current":current,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current);
					}
                    // var data = {
                    //     pageNum:current
                    // };
                    ajaxShow(current);
				});
				//上一页
				obj.on("click","a.prevPage",function(){
					var current = parseInt(obj.children("span.current").text());
					ms.fillHtml(obj,{"current":current-1,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current-1);
					}
                    // var data = {
                    //     pageNum:current-1
                    // };
                    ajaxShow(current-1);
				});
				//下一页
				obj.on("click","a.nextPage",function(){
					var current = parseInt(obj.children("span.current").text());
					ms.fillHtml(obj,{"current":current+1,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(current+1);
					}
                    // var data = {
                    //     pageNum:current+1
                    // };
                    ajaxShow(current+1);
				});
				function ajaxShow(data1){
					var item = $('#item').val();
                    var logTitle = $('#inlogTitle') .val();
                    var data = {
                        pageNum:data1,
						item:item,
                        logTitle:logTitle
                    };
                    $.ajax({
                        url:"/crainnogao/fenye",
                        type:"post",
                        data:data,
                        dataType:"json",
                        success:function (resp) {
                            var $tr = '<table class="table table-hover"><thead><tr><th>日志ID</th><th>主题</th>'+
								'<th>概要</th><th>上传时间</th><th>时间</th><th>操作</th></tr></thead><tbody>';
                            for (var i = 1;i<=resp.length;i++){
                                $tr += '<tr><td>'+resp[i-1].logId+'</td><td>'+resp[i-1].logTitle+'</td>'+
									   '<td>'+resp[i-1].logSummary+'</td><td>'+resp[i-1].logCreatedStr+'</td>'+
							           '<td>'+resp[i-1].logUpdateStr+'</td><td>操作</td></tr>';
                            }
                            document.getElementById("ajshow0").innerHTML=$tr;
                        },
                        error:function () {
                            alert("网络连接失败！");
                        }
                    })
				}
			})();
		}
	};
	$.fn.createPage = function(options){
		var args = $.extend({
			pageCount : totalPage,
			current : 1,
			backFn : function(){}
		},options);
		ms.init(this,args);
	}
})(jQuery);