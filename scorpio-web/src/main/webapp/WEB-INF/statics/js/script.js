$(function () {
    $(document).on('click','#crainnogao_ad',function () {
        window.location.href="/admin/crainnogao_ad";
    });

    if ($('#detaillogcontentfir').val()!=undefined){
        var detailcontentshow = $('#detaillogcontentfir').val();
        $('#detaillog').html(marked(detailcontentshow));
    }
    var pageCount = $('#pageCount').val();
    for (var i=1;i<=pageCount;i++){
        var contentshow = $('#logcontentfir-'+i).val();
        var partContentArry = contentshow.split("\n");
        if (partContentArry.length<6){
            $('#firstlog-'+i).html(marked(contentshow));
        }
        else {
            var count =0;
            var num=0;
            var partStr = "";
            for (var j=0;j<partContentArry.length;j++){
                if(!partContentArry[j].includes('```')){
                    count++;
                }else{
                    num++;
                }
                if(count<=6){
                    partStr+=partContentArry[j]+'\n';
                }else{
                    if(num % 2 != 0){
                        partStr+='```';
                        break;
                    }
                }
            }
            $('#firstlog-'+i).html(marked(partStr));
        }
    }

    //分页js
    var pageNum = $('#pageNum').val();
    var totalPage = $('#totalPage').val();
    if(pageNum==1){
        $('.prevPage').addClass('disabled');
        $('.prevPage').removeAttr("href");
        document.getElementById('prevPage').style.backgroundColor="#f4f5ef";
    }
    if(pageNum==totalPage){
        $('.nextPage').addClass('disabled');
        $('.nextPage').removeAttr("href");
        document.getElementById('nextPage').style.backgroundColor="#f4f5ef";
    }
    var current ="";
    for (var i =1;i<=totalPage;i++){
       var number = $("#number-"+i).val();
        if (number==pageNum){
            current = i;
            $('.tcdNumber-'+i).addClass('disabled current');
            $('.tcdNumber-'+i).removeAttr("href");
            document.getElementById('tcdNumber-'+i).style.backgroundColor="#f4f5ef";
        }
    }
    $(document).on('click','.prevPage',function () {
        if (current>1){
            location.href='/index/?pageNum='+ --current;
        }
    });
    $(document).on('click','.nextPage',function () {
        if (current<totalPage){
            location.href='/index/?pageNum='+ ++current;
        }
    });

});

