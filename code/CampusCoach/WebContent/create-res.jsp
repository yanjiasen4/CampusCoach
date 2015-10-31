<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="yanjiasen4">

    <title>校园教练</title>

    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles -->
    <link href="style/css/style.css" rel="stylesheet">
	
	<script src="style/js/jquery-2.1.1.min.js"></script>
	<script src="style/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<ul class="nav nav-pills">
            	<% if(request.getSession().getAttribute("user") == null) {
            	%>
			    <li role="presentation"><a href="login.jsp">登录</a></li>
			    <li role="presentation"><a href="register.jsp">注册</a></li>
			    <%  
			    } 
            	else {
			    %>
			     <li role="presentation"><a class="nav-brand" href="showusercourses.action" style="padding:0px"><img width="50px" alt="校园教练" src="${sessionScope.avatar}"></a></li>
			    <li role="presentation"><a href="showusercourses">${sessionScope.user}</a></li>
			    <li role="presentation"><a href="logout.action">注销</a></li>
			    <%  } %>
				</ul>
		</div>
	</nav>
	
	<div class="header">
	  <h2>请填写你的需求信息</h2>
	</div>
	
	<div class="container">
		<form class="form-course" action="reservationform" method="post">	
			<label for="inputType" class="sr-only">需求标题</label>
			<input type="text" name="reservation.reservationName" id="inputType" class="form-control" placeholder="需求标题" data-toggle="popover" data-trigger="focus" data-placement="top" tiltle="需求标题"
			data-content="为你的需求单取一个标题吧" required autofocus>
			<label for="inputType" class="sr-only">运动种类</label>
			<input type="text" name="reservation.sportsName" id="inputType" class="form-control" placeholder="培训种类" data-toggle="popover" data-trigger="focus" data-placement="top" title="培训种类" 
			data-content="请输入您要教学的运动" required autofocus>
			<label for="inputType" class="sr-only">培训地点</label>
			<input type="text" name="reservation.place" id="inputAddress" class="form-control" placeholder="培训地点" data-toggle="popover" data-trigger="focus" data-placement="top" title="培训地点" 
			data-content="请输入您的教学地点" required autofocus>
			<label for="inputType" class="sr-only">接受费用</label>
			<input type="text" name="reservation.price" id="inputPrice" class="form-control" placeholder="接受费用" data-toggle="popover" data-trigger="focus" data-placement="top" title="接受费用" 
			data-content="请输入您可接受的培训费用" required autofocus>
			<label for="inputNum" class="sr-only">参加人数</label>
			<input type="text" name="reservation.maxNum" id="inputNum" class="form-control" placeholder="参加人数" data-toggle="popover" data-trigger="focus" data-placement="top" title="参加人数" 
			data-content="请输入培训班的最大人数" required autofocus>
			<label for="inputTime" class="sr-only">培训时间</label>
			<input type="text" name="reservation.time" id="inputTime" class="form-control" placeholder="培训时间" data-toggle="popover" data-trigger="focus" data-placement="top" title="培训时间" 
			data-content="请输入您的教学时间" required autofocus>
			<label for="inputTime" class="sr-only">联系电话</label>
			<input type="telephone" name="reservation.learnerPhone" id="inputTime" class="form-control" placeholder="联系电话" data-toggle="popover" data-trigger="focus" data-placement="top" title="联系电话" 
			data-content="请输入您的联系电话，推荐为手机号" required autofocus pattern="[0-9]{11}" title="请输入正确的手机号码">
			<label for="inputRemark" class="sr-only">详情介绍</label>
			<textarea id="inputRemark" name="reservation.introduction" class="form-control" placeholder="备注" data-toggle="popover" data-trigger="focus" data-placement="top" title="备注" 
			data-content="其他的要求写在这里吧！" required autofocus></textarea>
			<input class="btn btn-lg btn-primary btn-block" type="submit"></input>
		</form>
	</div>
	
	<div class="container content">
		<h3>注意事项</h3>
	</div>
	
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">校园教练</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
             <li><a href="create-res.jsp">发布预约</a></li>
            <li><a href="showcoach.action">发现教练</a></li>
            <li><a href="showreservation.action">查看预约</a></li>
			<%if(request.getSession().getAttribute("coachID") == null){ %>
			<li><a href="becomecoach.jsp">成为教练</a></li>
			<%}
            else {%>
            <li><a href="coachform.jsp">创建课程</a></li>
            <%} %>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	
	<!-- Use popver -->
	<script>
	$(function () {
		$('[data-toggle="popover"]').popover()
	})
	</script>
	
	</body>
</html>
