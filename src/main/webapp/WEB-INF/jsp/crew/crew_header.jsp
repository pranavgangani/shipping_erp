<header
	class="page-header page-header-compact page-header-light border-bottom bg-white mb-4">
	<div class="container-fluid px-4">
		<div class="page-header-content">
			<div class="row align-items-center justify-content-between pt-3">
				<div class="col-auto mb-3">
					<h1 class="page-header-title">
						<div class="page-header-icon">
							<i data-feather="user-plus"></i>
						</div>
						Crew Details
					</h1>
				</div>
				<div class="col-12 col-xl-auto mb-3">
					<c:if test="${crew!=null}">
						${crew.firstName} ${crew.middleName} ${crew.lastName} (${crew.fileNum})
					</c:if>
				</div>
			</div>
		</div>
	</div>
</header>
