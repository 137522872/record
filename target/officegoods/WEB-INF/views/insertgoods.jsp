
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
  
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>添加办公用品</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?bdb993b828cbe079a7fbc1a951f44726";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</head>

	<body class="container">
		<header class="page-header">
			<h1>办公用品添加</h1>
		</header>
 
		<div>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<!-- 表单  水平表单-->

						<!-- 办公用品名称 -->
						<div class="form-group has-feedback">
							<label class="col-sm-3 control-label" for="goodsName">办公用品名称</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="goodsName"
								placeholder="名称" required>
								<span class=""></span>
							</div>
						</div>
						<!-- 办公用品描述 -->
						<div class="form-group has-feedback">
							<label class="col-sm-3 control-label" for="goodsDesc">办公用品描述</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="goodsDesc"
								placeholder="型号/描述" required>
								<span class=""></span>
							</div>
						</div>
						<!-- 办公用品总数 -->
						<div class="form-group has-feedback">
							<label class="col-sm-3 control-label" for="goodsTotal">办公用品总数</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="goodsTotal"
								placeholder="办公用品总数" required>
								<span class=""></span>
							</div>
						</div>
                        
                       <div class="form-group has-feedback">
							<label class="col-sm-3 control-label" for="goodsTotal">可以领用数量</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="goodsNum"
								placeholder="可以领用数量" required>
								<span class=""></span>
							</div>
						</div>


						<br>
						<!-- 功能按钮 -->

						<p class="text-right">
							<button id="btnSubmit" type="submit" class="btn btn-primary">
								提交
							</button>
							<button type="reset" class="btn btn-danger">
								重置
							</button>
						</p>

						<script>
						/**	function checkInput(txt){
                     //追加样式是先移除样式表后追加							
								if(txt.val()==""){
									txt.parent().parent()
										.removeClass()//为空，出现一个x的小图标
										.addClass("form-group has-error has-feedback");
									txt.next().removeClass()
										.addClass("glyphicon glyphicon-remove form-control-feedback");
									return false;
								}else{
									txt.parent().parent()
										.removeClass()//验证成功后出现一个对号的小图标
										.addClass("form-group has-success has-feedback");
									txt.next().removeClass()
										.addClass("glyphicon glyphicon-ok form-control-feedback");
									return true;
								}
							}
                            **/
                            
							$(function(){
							  //逐一的验证
								//$("#email").change(function(){checkInput($("#email"));});
								//$("#username").change(function(){checkInput($("#username"));});
								//$("#password").change(function(){checkInput($("#password"));});
								//提交按钮事件，false:不能提交，抑制提交按钮
								$("#btnSubmit").click(function(){
									$.ajax({
										type: 'POST',
										url: 'http://192.168.12.17:8080/goods/insertGoods',
										data: {
											goodsName: $('#goodsName').val(),
											goodsDesc: $('#goodsDesc').val(),
											goodsTotal: $('#goodsTotal').val(),
											goodsNum: $('#goodsNum').val()
										},
										success: function(res){
											var data=JSON.parse(res);
											console.log(data);
											if (data.code) { // success
												success_();
											} else{ // error
												error_ ();
											}
										}
									})
								});
							});
							function success_ () {
								$('.form-control').val('');
								alert('提交成功！');
							}
							function error_ () {
								alert('提交失败，请重新提交或联系管理员！');
							}
						</script>

				</div>
			</div>
 
		</div>
 
		<footer class="navbar-fixed-bottom text-center">
			&copy; 2015
		</footer>
        
    </body>
        
</html>