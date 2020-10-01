
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function over(id,fpa) {
	p=parseFloat(document.getElementById(id).innerHTML)*parseFloat(fpa);
	p=p.toFixed(2);
	s=p.toString();
	document.getElementById(id).innerHTML=s;
}
function out(id,price) {
	s=price.toString();
	document.getElementById(id).innerHTML=s;
}
function addToBasketAjax(id){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.open("GET","\add-to-basket.do?item="+id,true);
	xmlhttp.send();
}
</script>

<html>
<head>
<title>BestPc</title>
<link rel="stylesheet"
	href="webjars/bootstrap/4.5.1/css/bootstrap.min.css">
</head>
<body class="text-center">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/myHomePage.do">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">

				<li class="nav-item"><a class="nav-link active"
					href="/products.do">Products</a></li>
				<li class="nav-item"><a class="nav-link " href="/basket.do">Basket</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/settings.do">Account
						Settings</a></li>
			</ul>

			<c:if test="${username!=null}">
				<a class="btn t btn-outline-danger my-2 my-sm-0" href="logout.do">Log
					Out</a>
			</c:if>

		</div>
	</nav>

	<div class="container ">
		<h1>Our Products</h1>


		<c:forEach items="${items}" var="item">
			<div class="card float-left m-5 align-middle " style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title" id="${item.id}"
						onmouseout="out(${item.id},${item.price})"
						onmouseover="over(${item.id},${1+basket.getTax()})">${item.price}</h5>
					<p class="card-text">${item.name}</p>
					<a class="btn btn-primary" onClick="addToBasketAjax(${item.id})">Add To Basket</a>
				</div>
			</div>

		</c:forEach>





	</div>
	<script src="webjars/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
	<script src="webjars/bootstrap/4.5.1/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>
