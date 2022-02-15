<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Profile</title>

<!-- Custom fonts for this template-->
<%@ include file="../includes/header_includes.jsp" %>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="../includes/sidebar.jsp" %>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<%@ include file="../includes/top_nav_bar.jsp" %>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">Profile</h1>

					<div class="row">

						<div class="col-lg-4">

							<!-- Circle Buttons -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Profile
										Picture</h6>
								</div>
								<div class="card-body text-center">
									<!-- Profile picture image-->
									<img class="img-account-profile rounded-circle mb-2" src="../img/profile-1.png" alt="">
										<!-- src="assets/img/illustrations/profiles/profile-1.png" alt=""> -->
									
								</div>
								<div class="card-body">
									<p>JPG or PNG no larger than 5 MB</p>
									<!-- Circle Buttons (Default) -->
									<a href="#" class="btn btn-primary btn-icon-split"> <span
										class="text">Upload new image</span>
									</a>
								</div>
							</div>


						</div>

						<div class="col-lg-8">

							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Account Details</h6>
								</div>
								<div class="card-body">
									<form>
									<div class="mb-3">
    <!-- <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div> -->
										<div class="mb-3">
											<label class="small mb-1" for="inputUsername">Username</label> 
												<input class="form-control" id="inputUsername" type="text" placeholder="Enter your username" value="username">
										</div>										
										<div class="mb-3">
											<div class="col-md-6">
												<label class="small mb-1" for="inputFirstName">First name</label> 
													<input class="form-control" id="inputFirstName" type="text" placeholder="Enter your first name" value="Valerie">
											</div>
											<div class="col-md-6">
												<label class="small mb-1" for="inputLastName">Last name</label> 
												<input class="form-control" id="inputLastName" type="text" placeholder="Enter your last name" value="Luna">
											</div>
										</div>
										<div class="mb-3">
											<label class="small mb-1" for="inputEmailAddress">Email address</label>
											<input class="form-control" id="inputEmailAddress" type="email" placeholder="Enter your email address" value="name@example.com">
										</div>
										<div class="mb-3">
											<div class="col-md-6">
												<label class="small mb-1" for="inputBirthday">Birthday</label>
												<input class="form-control" id="inputBirthday" type="text" name="birthday" placeholder="Enter your birthday" value="06/10/1988">												
											</div>
											<div class="col-md-6">
												<label class="small mb-1" for="inputLastName">Last name</label> 
												<input class="form-control" id="inputLastName" type="text" placeholder="Enter your last name" value="Luna">
											</div>
										</div>
										<div class="mb-3">
											<a href="#" class="btn btn-primary btn-icon-split"> <span
												class="text">Save Changes</span>
											</a>
										</div>
									</form>
								</div>
							</div>

						</div>

					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@ include file="../includes/copyright.jsp" %>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<%@ include file="../includes/logout.jsp" %>

	<%@ include file="../includes/bottom_includes.jsp" %>

</body>

</html>