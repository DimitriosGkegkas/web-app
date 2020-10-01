<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function removeFromBasketAjax(id){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.open("GET","\ remove-to-basket.do?item="+id,true);
	xmlhttp.onload=function(event){
		document.getElementById(id).innerHTML = xmlhttp.responseText;

	}
	xmlhttp.send();
}
function deleteFromBasketAjax(id){
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.open("GET","\delete-to-basket.do?item="+id,true);
	xmlhttp.onload=function(event){
		document.getElementById(id).style.display = "none";
	}
	xmlhttp.send();
}
</script>
<html>
<head>
<title>BestPc</title>
<link rel="stylesheet"
	href="webjars/bootstrap/4.5.1/css/bootstrap.min.css">
<style type="text/css">
.buttons {
	width: 150px;
}
</style>
<script type="text/javascript">
	function selectChange(val) {
		//Set the value of action in action attribute of form element.
		//Submit the form
		$('#myForm').submit();
	}
</script>
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

				<li class="nav-item"><a class="nav-link " href="/products.do">Products</a>
				</li>
				<li class="nav-item"><a class="nav-link active "
					href="/basket.do">Basket</a></li>
				<li class="nav-item"><a class="nav-link" href="/settings.do">Account
						Settings</a></li>
			</ul>
			<c:if test="${username!=null}">
				<a class="btn t btn-outline-danger my-2 my-sm-0" href="logout.do">Log
					Out</a>
			</c:if>


		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-lg-9">

				<h1>Your Basket</h1>


				<c:if test="${basket.getTotal()==0}">
					<h2>Your Basket is Empty</h2>
				</c:if>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Product</th>
							<th scope="col">Price</th>
							<th scope="col">Amount</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${basket.retrieveBasket()}" var="pair">

							<tr id=${pair.item.id}>
								<td>${pair.item.name}</td>
								<td>${pair.item.price}</td>
								<td>${pair.amount}</td>
								<td class="buttons">
									<a class="btn btn-outline-success" onClick="removeFromBasketAjax(${pair.item.id})">-</a> 
									<a class="btn btn-outline-danger" onClick="deleteFromBasketAjax(${pair.item.id})">Delete</a>
								</td>
							</tr>
							
						</c:forEach>
						<tr class="table-secondary">
							<td>Total Cost - with out tax</td>
							<td>${basket.getTotal()}</td>
							<td></td>
							<td></td>
						</tr>

						<tr class="table-secondary">
							<td>Tax</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="2"
									value="${basket.getTotal()*basket.getTax()}" /></td>
							<td></td>
							<td></td>
						</tr>
						<c:if
							test="${basket.getTotal()*(basket.getTax()+1)*(1-basket.getDiscount())!=0}">
							<tr class="table-secondary">
								<td>Discount</td>

								<td>-<fmt:formatNumber type="number" maxFractionDigits="2"
										value="${basket.getTotal()*(basket.getTax()+1)*(1-basket.getDiscount())}" /></td>
								<td></td>
								<td></td>
							</tr>
							<tr class="table-secondary" id="discount">
							</tr>
							<tr class="table-dark" style="color: red">
								<td>Total Cost</td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2"
										value="${basket.getTotal()*(basket.getTax()+1)*(basket.getDiscount())}" /></td>
								<td></td>
								<td></td>
							</tr>
						</c:if>
						<c:if test="${basket.getTotal()*(basket.getTax()+1)*(1-basket.getDiscount())==0}">


							<tr class="table-dark">
								<td>Total Cost</td>
								<td><fmt:formatNumber type="number" maxFractionDigits="2"
										value="${basket.getTotal()*(basket.getTax()+1)*(basket.getDiscount())}" /></td>
								<td></td>
								<td></td>
							</tr>

						</c:if>


					</tbody>
				</table>
			</div>
			<div class="col-lg-3">
				<form action="/voucher.do" method="post">
					<input type="text" class="form-control mt-5" name="voucher"
						placeholder="Voucher" />
				</form>
				
				<label class="mt-5">Country</label>
				<form action="/country.do" method="post">
					<select class="form-control" name="country"
						id="exampleFormControlSelect2" onchange="this.form.submit();">
						<option selected disabled="disabled">Select Country</option>
						<c:forEach items="${countries}" var="item">
							<option value="${item}">${item}</option>
						</c:forEach>
					</select>
				</form>
				<form action="/placeOrder.do" method="post">
					<input type="submit" class="form-control mt-5 btn-primary"
						value="Order" />
				</form>

			</div>
		</div>

	</div>



	<script src="webjars/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
	<script src="webjars/bootstrap/4.5.1/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>



				
					