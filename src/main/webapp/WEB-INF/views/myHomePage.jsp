<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		        <a class="nav-link" href="/settings.do">Account Settings</a>
		      </li>
		    </ul>
		
<c:if test="${username!=null}">
				 <a class="btn t btn-outline-danger my-2 my-sm-0" href="logout.do">Log Out</a>
				</c:if>

		  </div>
		</nav>
	


	<div class="container"> 
	<h1>Welcome Back</h1>
	<h2> ${username}</h2>
	
	</div>


	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>