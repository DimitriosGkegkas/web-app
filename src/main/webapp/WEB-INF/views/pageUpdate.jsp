
<!DOCTYPE html>
<html>
<head>
<title>BestPc</title>
<link rel="stylesheet"
	href="webjars/bootstrap/4.5.1/css/bootstrap.min.css">


</head>

<body>
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
				<li class="nav-item"><a class="nav-link  " href="/basket.do">Basket</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					href="/settings.do">Account Settings</a></li>
			</ul>

			<a class="btn t btn-outline-danger my-2 my-sm-0" href="logout.do">Log
				Out</a>

		</div>
	</nav>


	<div class="container">
		<h1>Your Info</h1>


		<form action="/settings.do" method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Name</label> <input type="text"
						class="form-control" name="name" value="${name}" />
				</div>
				<div class="form-group col-md-6">
					<label for="inputEmail4">Surname</label> <input type="text"
						class="form-control" name="surname" value="${surname}" />
				</div>
			</div>
			<div>Birthday</div>
			<input class="form-control" type="date" name="birthday"
				value="${birthday}" /> <input type="submit"
				class="btn btn-success m-3 float-left" value="Save" />
		</form>

		<form action="/deleteUser.do" class="float-right" method="post">
			<input type="submit" class="btn btn-danger m-3" value="Delete" />
		</form>

	</div>

	<script src="webjars/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.1/js/bootstrap.min.js"></script>

</body>

</html>