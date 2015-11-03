<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
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
			    <li role="presentation" class="active"><a href="login.jsp">登录</a></li>
			    <li role="presentation"><a href="register.jsp">注册</a></li>
			    <%  
			    } 
            	else {
			    %>
			    <li role="presentation"><a class="nav-brand" href="showusercourses.action" style="padding:0px"><img width="50px" alt="校园教练" src="${sessionScope.avatar}"></a></li>
			    <li role="presentation"><a href="showusercourses.action">${sessionScope.user}</a></li>
			    <li role="presentation"><a href="logout.action">注销</a></li>
			    <%  } %>
			</ul>
		</div>
	</nav>
	
	<div class="header">
	  <h1>排行榜</h1>

	  
	</div>
	
	<div class="container-fluid user-inform">
	<div class="row">
      <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="rank-content">
      	<s:iterator value="learners" var="it" status="st">
      		<s:if test="#st.Odd">
        		<div class="rank-list-left">
          			<h2>
          			<span class="rank"><s:property value="#it.rank"/></span>
	         		<span class="ct"><s:property value="#it.username"/></span>
	          		</h2>
        		</div>
	        </s:if>
	        <s:if test="#st.Even">
	        	<div class="rank-list-right">
	          		<h2>
	          		<span class="rank"><s:property value="#it.rank"/></span>
	         		<span class="ct"><s:property value="#it.username"/></span>
	          		</h2>
	        	</div>
	        </s:if>
       	</s:iterator>
      
      	<div class="col-sm-12 col-md-12 col-lg-12"> 
      	<nav>
  		<ul class="pager">
  		<s:if test="%{page.currentPage!=0}">
    		<li class="previous"><a href="showusersrank?currpage=<s:property value="%{page.currentPage-1}"/>"><span aria-hidden="true">&larr;</span>上一页</a></li>
    	</s:if>
    	<s:if test="%{page.currentPage<(page.allPage-1)}">
    		<li class="next"><a href="showusersrank?currpage=<s:property value="%{page.currentPage+1}"/>">下一页<span aria-hidden="true">&rarr;</span></a></li>
    	</s:if>
  		</ul>
		</nav>	
		
		</div>
      
      </div>
	</div>
	</div>
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
			<li><a href="becomecoach.jsp">成为教练</a></li>
            <li><a href="coachform.jsp">创建课程</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	
	<!-- Use tooltip -->
	<script>
	$(function () {
		$('[data-toggle="tooltip"]').tooltip()
	})
	</script>
	</body>
</html>