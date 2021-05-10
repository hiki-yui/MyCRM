$(".time").datetimepicker({
	language:  "zh-CN",
	format: "yyyy-mm-dd hh:ii:ss",//显示格式
	minView: "hour",//设置只显示到月份
	initialDate: new Date(),//初始化当前日期
	autoclose: true,//选中自动关闭
	todayBtn: true, //显示今日按钮
	clearBtn : true,
	pickerPosition: "bottom-left"
});


$(".time").datetimepicker({
	minView: "month",
	language:  'zh-CN',
	format: 'yyyy-mm-dd',
	autoclose: true,
	todayBtn: true,
	pickerPosition: "bottom-left"
});
