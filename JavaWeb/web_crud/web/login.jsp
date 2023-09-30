
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>

<link href="css/login.css" type="text/css" rel="stylesheet" />

</head>
<form action="/tologin" method="post">
<body id="userlogin_body">

<div id="user_login">
	<dl>
		<dd id="user_top">
			<ul>
				<li class="user_top_l"></li>
				<li class="user_top_c"></li>
				<li class="user_top_r"></li>
			</ul>
		</dd>
		<dd id="user_main">
			<ul>
				<li class="user_main_l"></li>
				<li class="user_main_c">
					<div class="user_main_box">
						<ul>
							<li class="user_main_text">用户名： </li>
							<li class="user_main_input"><input name="uname" maxlength="20" id="TxtUserName" class="txtusernamecssclass"> </li>
						</ul>
						<ul>
							<li class="user_main_text">密 码： </li>
							<li class="user_main_input"><input type="password" name="upass" id="TxtPassword" class="txtpasswordcssclass"> </li>
						</ul>
						
						
					</div>
				</li>
				<li class="user_main_r">
				<a href="index.jsp">
				<input type="image" name="IbtnEnter" src="img/user_botton.gif" class="ibtnentercssclass">
				</a>
				</li>
			</ul>
		</dd>
		<dd id="user_bottom">
			<ul>
				<li class="user_bottom_l"></li>
				<li class="user_bottom_c"></li>
				<li class="user_bottom_r"></li>
			</ul>
		</dd>
	</dl>
</div>


</body>
</form>
</html>