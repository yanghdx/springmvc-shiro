<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<p>User add</p>
	<div id="container">
		<form id="form" method="post" action="">
			<div> 
				<label>Username</label>
				<input id="username" name="username" v-model="username">
			</div>
			<div> 
				<label>Password</label>
				<input id="password" name="password" v-model="password">
			</div>
			<div> 
				<label>Repeat Password</label>
				<input id="rpassword" name="rpassword" v-model="rpassword">
			</div>
			<div>
				<button type="submit">Submit</button>
			</div>
		</form>
	</div>
</body>
<script src="/js/vue/vue.js"></script>
<script src="/js/jquery/jquery-1.11.1.js"></script>
<script src="/js/jquery.validate/jquery.validate.min.js"></script>
<script>
var vm = new Vue({
	el : "#container",
	data : {
		username : '',
		password : '',
		rpassword: ''
	}
});

$("#form").validate({
	submitHandler: function() {
		alert("Do submit!");
		var arr = [];
		arr.push('Username is: ' + vm.username);
		arr.push('Password is: ' + vm.password);
		alert(arr.join('\n'));
	},
	rules : {
		username: {
			required : true,
			maxlength : 20,
			minlength : 5
		},
		password: {
			required : true,
			maxlength : 20,
			minlength : 5
		},
		rpassword: {
			required : true,
			maxlength : 20,
			minlength : 5,
			equalTo : "#password"
		}
	},
	messages : {
		username : {
			required : 'Cannot be empty.',
			maxlength : 'Max length is 20',
			minlength : 'Min length is 5'
		},
		password : {
			required : 'Cannot be empty.',
			maxlength : 'Max length is 20',
			minlength : 'Min length is 5'
		},
		rpassword : {
			required : 'Cannot be empty.',
			maxlength : 'Max length is 20',
			minlength : 'Min length is 5',
			equalTo : 'Must be same to the Password'
		}
	}
	
});
</script>
</html>