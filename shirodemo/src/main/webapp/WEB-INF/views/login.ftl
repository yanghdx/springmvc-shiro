<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>

<div id="loginDiv">
	<p style="color:red;font-size:12px;">${error}</p>
	<form method="post" action="/login">
	username: <input type="text" id="username" name="username"><br>
	password: <input type="password" id="password" name="password"><br>
	<button type="submit">登录</button><br>
	
	</form>
</div>
</body>
</head>
</html>