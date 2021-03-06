
/*
* 注:
*   此script文件将自动把使浮窗显形的函数绑定到编辑栏(使用edit类样式的div)中的按钮组中(buttonGroup)的各个按钮上
* */
enterPointer="";
//此script用于浮窗的显隐,和按钮的感官调整
//使悬浮窗显形的函数
function floatOut(){
    //更改回车的指针使回车在浮窗弹出时没有任何效果
    enterPointer="";
    var floatId=this.id.substr(0,this.id.length-1);//获取该按钮所属什么主题:append/edit
    var float=$("#"+floatId);//获取与该按钮绑定在一起的浮窗
    var backW=$("#"+floatId+"W");//获取浮窗背景
    //使浮窗显形
    backW.css("visibility","visible");
    backW.css("backgroundColor"," rgba(155, 152, 154, 0.38)");
    float.css("top","10%");
    float.css("opacity","1");
    float.css("backgroundColor","#e1f7fe");
    float.css("visibility","visible");

}

//————————————————————————————————————————————————————————————————————————————————————————————————————————————————

//与上个函数相反
function floatIn(){
    var floatId = this.id.substr(0, this.id.length - 5);
    var float=$("#"+floatId);
    var backW=$("#"+floatId+"W");
    if (this.id.indexOf("Sure")!==-1){
        if (confirm("你真的要执行此操作吗(-_-)!")){
            upDate(floatId);
        }
    }
    backW.css("visibility","hidden");
    backW.css("backgroundColor","rgba(155, 152, 154, 0)");
    float.css("top","-35%");
    float.css("opacity","0");
    float.css("backgroundColor","(240, 248, 255, 0)");
    float.css("visibility","hidden");
    //清空内容
    /*$("#"+floatId+" :text").val(""); old*/
    clearText(float);/*new*/
    /*使一个元素的滑轮滑到顶部*/
    var x = float.scrollTop();//获取当前滑动条的位置
    while(x>0){
        float.scrollTop(--x);//使滑轮移动到指定位置
    }
    enterPointer=floatId+"B";
}

/**
 * 清除输入域的文本内容
 * @param $doc create By JQuery
 */
function clearText($doc){
    var id=$doc.attr("id");
    var $allInput=$("#"+id+" input");
    if ($allInput.length!==0){
        $allInput.val("");
    }
    var $allTestArea=$("#"+id+" textarea");
    if ($allTestArea.length!==0){
        $allTestArea.val("");
    }
}
//————————————————————————————————————————————————————————————————————————————————————————————————————————————————

function upDate(floatId){
    //获取主题
    var uri=$("title").text();
    //拼接该更新操作对应的uri地址
    uri+=floatId+".do";
    //检查
    console.log(uri);
    //获取数据
    var data=$("#"+floatId+" .select");
    console.log(data);
    //拼接json格式的请求参数
    var jsonData="{";
    $.each(data,function(index,doc){
        var docu = $(doc);
        jsonData += "\""+docu.attr("name")+"\":\""+docu.val()+"\",";
    });
    //删去多余的,
    jsonData=jsonData.substr(0,jsonData.length-1);
    jsonData += "}";
    //检查
    console.log(jsonData);
    //发送请求
    $.get(uri,JSON.parse(jsonData),function(data){/*select()*/
       /* setTimeout(function (){window.open(window.self.location,"_self")},370);*/
        checkLoginTimeOut();
        select();
    })
}

//————————————————————————————————————————————————————————————————————————————————————————————————————————————————

/*
* 用于浮窗外部触发浮窗隐藏的方法
* 浮窗外部(父元素使用.backW类,id命名规则为浮窗的id+W)
* */
function floatInByW(){
    var floatInButton=this.id;
    floatInButton=floatInButton.substr(0,floatInButton.length-1);
    floatInButton+="BNot-";
    document.getElementById(floatInButton).click();
}

//————————————————————————————————————————————————————————————————————————————————————————————————————————————————

function allComplete(){
    //将用户栏补充完整
    userComplete();
    //修正数据展示
    baseComplete();
    //检测
    console.log($("#append .select"));
    console.log($("#edit .select"));
    console.log($("#select .select"));

    /*设置带有time输入标签只读*/
    $(".time").attr("readonly","true");
    //将编辑栏的按钮组中的第一个和最后一个设置border-radius属性,目的是使整体观感更协调
    /*buttonGroupComplete();以在baseComplete中调用*/
    floatButtonComplete();
}

function buttonGroupComplete(){
    var $editUiButtonGroup=$(".buttonGroup");
    $.each($editUiButtonGroup,function(index,doc){
        /*查看一组按钮*/
        var $children=$(doc).children();
        /*按钮组的第一个按钮*/
        var first=$children.first();
        /*最后一个*/
        var last=$children.last();
        //如果只有一个按钮,则四角削圆,两个路线都会删除多余的分割线
        if($children.length===1){
            first.css("borderRadius","6px");
            first.css("border","none");
        }else{
            first.css("borderRadius","6px 0 0 6px");
            last.css("borderRadius","0 6px 6px 0");
            last.css("border","none");
        }
    });
}

/**
 * 用于将浮窗的弹出弹入绑定在对应的按钮上
 */
function floatButtonComplete(){
    //将浮窗的弹出,返回绑定在对应的按钮上
    /*获取增删改查的按钮*/
    var $editUiButton=$(".edit .ui-button");
    $.each($editUiButton,function(index,doc){
        $(doc).on("click",floatOut);
    });
    /*获取悬浮窗里的按钮*/
    var $floatUiButton=$(".floatW .ui-button");
    $.each($floatUiButton,function(index,doc){
        $(doc).on("click",floatIn);
    });
    var $backW=$(".backW");
    $.each($backW,function (index,doc) {
        $(doc).on("click",floatInByW)
    });
    // 取消默认的回车事件
    document.onkeydown=function(key){
        if (key.keyCode===13){
            return false;
        }
    };
    //当用户按下回车时使enterPointer所指的浮窗显形
    document.onkeyup=function (key) {
        if (key.keyCode===13){
            $("#"+enterPointer).click();
            //回车按下后使回车在浮窗弹出后没有任何效果
            enterPointer="";
            return false;
        }
    };
}
//————————————————————————————————————————————————————————————————————————————————————————————————————————————————

//修正数据展示的布局
function baseComplete(){
    //
    $("#select").children(":last").click(function (){checkLoginTimeOut();select();});//将查询的函数和inputDiv中的最后一个按钮绑定上(即查询按钮)
    var td=$(".td:gt(0)");
    console.log(td);
    /*定义td类div的宽度*/
    td.css("width","calc( calc(1274.4px - 44.2px) / "+td.length+")");
    pageListComplete(true);
}

//指针指向一页展示的数据数,默认是五
pageSize=5;
//指向页码
page=1;
//指向数据数
base=0;
//对多显示五个页码
maxPageNum=5;
//最大页数
maxPage=0;/*(base-(base%pageSize))/pageSize+1*/
//补全分页相关按钮的函数
/**
 * 重改和补全分页按钮相关
 * false 只把分页按钮补功能充完,true 初始化所有带有under类的按键
 * @param isAll boolean
 */
function pageListComplete(isAll){
    showBase(page,pageSize);
    //添加分页按钮,最多五个按钮
    var $pageList=$("#pageList");
    $pageList.empty();
    $pageList.append("<button class=\"ui-button under\">上一页</button>");
    if(maxPage>maxPageNum) {
        for (var i = 1;i<=maxPageNum;i++){
            $pageList.append(
                "<button id='"+i+"' class=\"ui-button under page\" value='"+i+"'>"+i+"</button>"
            )
        }
    }else{
        //如果数据达不到五个按钮就添加应得的按钮
        for(var i=1;i<=maxPage;i++){
            $pageList.append(
                "<button id='"+i+"' class=\"ui-button under page\" value='"+i+"'>"+i+"</button>"
            )
        }
    }
    $pageList.append("<button class=\"ui-button under\">下一页</button>");
    //给翻页按钮绑定函数
    $.each($(".ui-button.under.page"),function (index,doc) {
        $(doc).click(toPage)
    });
    //默认第页面选中page对应的按钮
    changeColor();
    var $list=$pageList.children();
    //绑定下一页的操作
   $list.first().click(lastPage);
    //绑定下一页的操作
    $list.last().click(nextPage());
    if (isAll){
        //绑定更新数据展示的操作
        $("#pageSizeB").click(changePageSize);
        $("#pageNumB").click(toPageIndex)
    }
    buttonGroupComplete();
}

//翻页
function toPage(){
    //翻页按钮链
    var $pageList=$(".ui-button.under.page");
    if (page!==parseInt(this.value)){
        page=parseInt(this.value);
        showBase(page,pageSize);
        //使按钮连的中间按钮展示当前页,两边按钮递减/递增
        var half=(maxPageNum-maxPageNum%2)/2;
        //一下的判断语句用于如何修改翻页按钮的value和text
        if (page-half>0&&$pageList.length===maxPageNum) {//如果没有达到最大翻页按钮数说明不需要做翻页按钮的修改
            if (page+half<=maxPage){//如果按钮链的最后一个按钮没有超过最大页数
                $.each($pageList,function(index,doc){
                    var endIndex = page+index-half;
                    var $doc=$(doc);
                    //当前页码对应的翻页按钮链
                    //当页码为2时对应的翻页按钮链为 1 2 3 4 5,为5时 对应为3 4 5 6 7,次规律推导
                    $doc.attr("id",endIndex);
                    $doc.val(endIndex);
                    $doc.text(endIndex);
                })
            }else if (page+half>maxPage) {
                //按原来方法超出的部分,超出多少就整体少减多少
                var outLength=page+half-maxPage;
                $.each($pageList,function (index,doc) {
                    var endIndex=page-outLength-half+index;
                    var $doc=$(doc);
                    $doc.attr("id",endIndex);
                    $doc.val(endIndex);
                    $doc.text(endIndex);
                });
            }
        }else if(page-half<1&&$pageList.length===maxPageNum){
            var needLength=1-(page-half);
            $.each($pageList,function (index,doc) {
                var endIndex=page+needLength-half+index;
                var $doc=$(doc);
                $doc.attr("id",endIndex);
                $doc.val(endIndex);
                $doc.text(endIndex);
            });
        }
        changeColor();
    }
}
//下一页
function nextPage(){
    var next = $("#"+(page+1));
    if (next!==undefined){
        next.click();
    }
}
//上一页
function lastPage(){
   var last = $("#"+(page-1));
   if (last !== undefined) {
       last.click();
   }
}

/**
 * 改变一页展示数据数的方法
 */
function changePageSize(){
    var newPageSize=$("#pageSize").val();
    //确保新的pageSize是一个整数并且大于0
    if (!isNaN(newPageSize)&&newPageSize>0&&newPageSize%1===0){
        pageSize=newPageSize;
        page=1;
        $("#pageList").empty();
        pageListComplete(false);
    }
}

/**
 * 跳转至...页面
 */
function toPageIndex(index){
    var newPage;
    if (!isNaN(index)) {
        newPage = index;
    }else{
        newPage = $("#pageNum").val();//获取要跳转到的页面
    }
    //检查是否是一个合法数值
    if (!isNaN(newPage)&&newPage<=maxPage&&newPage>0&&newPage%1===0){
        newPage=parseInt(newPage);
        var hasB=document.getElementById(newPage);
        if(hasB!==null){//如果翻页按钮链中有要跳转的页数则直接点击该按钮
            hasB.click();
        }else{//没有该按钮的话
            var pageB=$("#"+page);
            pageB.val(newPage);
            pageB.text(newPage);
            pageB.attr("id",newPage);
            pageB.click();
        }
    }
}

//更改当前页码按钮颜色
function changeColor(){
    $("#"+page).css("backgroundColor","#66dbff");
    $("#pageList").children().not("#"+page).css("backgroundColor","#f0f0f0")
}
//————————————————————————————————————————————————————————————————————————————————————————————————————————————————
function select(){
    pageListComplete(false);
}

//发送ajax请求的方法,显示数据,该ajax需要传输page=页码,size=一页显示的总条数
function showBase(page,size){
    checkLoginTimeOut();//检验登录是否过时
    $(".base table tbody").empty();
    var $select=$("#select .select");//获取过滤数据
    var json="{";
    //遍历过滤数据,拼接json字符串
    $.each($select,function (index,doc) {
        console.log(doc.value);
        var value = $(doc).val();
        if (value !== ""&&value!==null) {
            var name = $(doc).attr("name");
            json += "\"" + name + "\":\"" + value + "\","
        }
    });
    json+="\"size\":\""+size+"\",";
    json+="\"page\":\""+page+"\"";
    json+="}";
    var completeJson=JSON.parse(json);//将json字符串转化为json
    console.log(completeJson);//检查
    $.ajax({async:false,url:$("title").text()+"select.do",data:completeJson,success:function (data) {
        //检测
        console.log(data);
        //将总记录条写入到id为count的按钮中
        $("#count").text((data===null?0:data["count"])+"条记录");
        //如果数据为空
        if (data===null){
            return;
        }
        //更改指针base的数据
        base=data["count"];
        maxPage=(base-(base%pageSize))/pageSize+((base%pageSize)!==0?1:0);
        $("#maxPage").text(maxPage+"页");
        //数据层对象
        var baseShow = $(".base table tbody");
        //表格元素
        var thead = $(".td");
        //动态添加的数据
        var baseHtml = "";
        //循环遍历服务端返回的json数组[{},{}]
        $.each(data["base"],function (index,json) {
            $.each(thead,function(index,doc){
                //获取表头(<div id="数据名" class="td">
                // 但id需要和服务端返回的json数据中的某个属性名一致,顺序可不一样)
                var parameter=$(doc).attr("id");
                console.log($(doc).attr("id")+doc);
                if (parameter!==undefined){
                    baseHtml+="<td><div class='td'>"+json[parameter]+"</div></td>";
                }else{
                    //每一行前的一个单选按钮
                    baseHtml+="<tr id='"+json["id"]+"'>" +
                        "<td>" +
                        "<div class='td' style='width: 44.2px !important;'>" +
                        "<input type='checkbox' value='"+json["id"]+"' autocomplete=\"off\"/>" +
                        "</div>" +
                        "</td>";
                }
            });
            //在遍历完一行记录后添加一个</tr>
            baseHtml+="</tr>"
        });
        baseShow.append(baseHtml);
    },dataType:"json",type:"post"})
}

//————————————————————————————————————————————————————————————————————————————————————————————————————————————————
/**
 * 一个翻动效果的动画,隐藏,默认会给user类下的所有li元素绑定动画效果
 * @param list jquery数组
 * @return 字符串类型:动画运行总时间
 */
function isHidden(list){
    var waitTime = changeTransition(true,list);
    var $items;
    if(list!==null&&list!==undefined){
        $items = list
    }else {
        $items = $(".user li:not(:first)");
    }
    if($items!=null){
        $.each($items,function (index,doc) {
            var $doc=$(doc);
            $doc.css("margin-top", "-"+$doc.outerHeight(true)+"px");//height()获取元素的高
            if (index===0){
                $doc.css("opacity","0");
            }
            $doc.css("visibility","hidden");
            $doc.css("transform","rotateX(180deg)");
        });
    }
    return waitTime;
}

/**
 * 一个翻动效果的动画,显示,默认会给user类下的所有li元素绑定动画效果
 * @param list jquery数组
 * @return 字符串类型:动画运行总时间
 */
function isVisible(list){
    var waitTime = changeTransition(false,list);
    var $items;
    var hasList=list!==null&&list!==undefined;
    if(hasList){
        $items = list
    }else {
        $items = $(".user li:not(:first)");
    }
    if ($items!=null){
        $.each($items,function(index,doc){
            var $doc = $(doc);
            $doc.css("margin-top",0+"px");
            /*$doc.css("border-bottom-width")||0  这个||表示如果获取的值是undefined或null就用||后的数值代替*/
            //outerHeight(boolean)获取元素的边框(true额外获得外补丁的距离)
            if (index===0){
                $doc.css("opacity","1");
            }
            $doc.css("visibility","visible");
            $doc.css("transform","rotateX(360deg)");
        })
    }
    return waitTime;
}

/**
 * 用于isHidden和isVisible两种方法
 * @param isHidden 是否是隐藏
 * @param List jquery数组
 */
function changeTransition(isHidden,List){
    var $items;
    var waitTime;
    if(List!==undefined&&List!==null) {
        $items=List;
    }else{
        $items = $(".user li:not(:first)");
    }
    $.each($items,function(index,doc){
        waitTime = (isHidden?($items.length-1-index)*0.2:index*0.2);
        var $doc = $(doc);
        $doc.css("transition","margin-top 0.2s "+waitTime+ "s," +
            "opacity 0.2s "+waitTime+ "s," +
            "visibility 0.2s "+waitTime+"s,"+
            "transform 0.2s "+waitTime+"s");
    });
    return waitTime;
}

/**
 * 用户栏动态效果补充
 */
function userComplete(){
    var $user=$(".user");
    if($user!==null){
        $user.mouseenter(function(){isVisible(null)});
        $user.mouseleave(function (){isHidden(null)});
        var links=$(".user a");
        links.css("color","black");
        links.css("cursor","default")
    }
}

/**
 * 垂直居中
 * @param docId 元素的id
 * @param $relativeDoc 通过jquery获取的元素,以当前元素为参照物居中
 */
function centerY(docId,$relativeDoc){
    var $doc=$("#"+docId);
    var relativeHeight=$relativeDoc===undefined?$(window).height():$relativeDoc.height();
    if ($doc!==null){
        $doc.css("top",(relativeHeight/2)-($doc.height()/2))
    }
}

//检查登录是否超时
function checkLoginTimeOut(){
    $.ajax({
        async:false,
        url:"check_loginTimeOut.do",type:"post",success:function (data) {
            if(data["needReLogin"]){
                window.alert("登录已超时,请重新登录");
                window.open("../login.html","_self")
            }
        }
    ,dataType:"json"});
}