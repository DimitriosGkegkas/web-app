
<!DOCTYPE html>
<html>
<head>
<title>BestPc</title>
<link rel="stylesheet" href="webjars/bootstrap/4.5.1/css/bootstrap.min.css" >


</head>

<body >
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <a class="navbar-brand" href="/myHomePage.do">Home</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		
		      <li class="nav-item">
		        <a class="nav-link " href="/products.do">Products</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link  " href="/basket.do">Basket</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link " href="/settings.do">Account Settings</a>
		      </li>
		    </ul>
		
		    

		  </div>
		</nav>


	<div class="container"> 
	<h1>Please Sign in</h1>
	


<form action="/signIn.do" method="post">
<div>Username</div> <input type="text" class="form-control" name="username" value="${username}"/> 
<div>Name</div> <input type="text" class="form-control" name="name"/>
<div>Surname</div> <input type="text" class="form-control" name="surname"/>
<div>Birthday</div> <input type="date" class="form-control" name="birthday"/>
<div>Password</div> <input type="password" class="form-control" name="password"/>
<input type="submit" class="btn btn-success m-3" value="Sign In"/>

</form>
	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>