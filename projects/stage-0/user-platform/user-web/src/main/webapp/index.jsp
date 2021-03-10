<head>
<jsp:directive.include
	file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
<title>My Home Page</title>
</head>
<body>
	<div class="container-lg">
		<!-- Content here -->
		Hello,World 2021

	</div>
	<form  action="/user/register" method="post">
		用户名：<input type="text" name="username" /> <br/>
		密码：<input type="text" name="password" /><br/>
		邮箱：<input type="text" name="email" /><br/>
		电话号码：<input type="text" name="phonenumber" /><br/>
		<input type="submit" value="注册"/>
	</form>
</body>