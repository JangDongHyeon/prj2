
<%@include file="nav.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).reday(function(){
		
	});
</script>
<header class="masthead text-center text-white d-flex">
	<div class="container my-auto">
		<div class="row">
			<div class="col-lg-6 mx-auto">
				<h1 class="text-uppercase">
					<strong>관광지 놀러가자!!!</strong>
				</h1>
				<hr>
			</div>
		</div>
		<div class="col-lg-10 mx-auto">
			<div class="form-group">
				<label for="sel1">지역</label> <select class="form-control"
					id="sel1">
			
				</select>
			</div>
		</div>
		
		<div class="col-lg-10 mx-auto">
			<div class="form-group">
				<label for="sel2">지역구</label> <select class="form-control"
					id="sel2">
				
				</select>
			</div>
		</div>
		
		<div class="col-lg-10 mx-auto">
			<div class="form-group">
				<label for="sel3">타입</label> <select class="form-control"
					id="sel3">

				</select>
			</div>
		</div>
		

		<div class="col-lg-10 mx-auto">
			<input class="form-control" type="text" id="formGroupInputLarge"
				placeholder="가고싶은 관광지 키워드 검색">
		</div>
		<div class="col-lg-10 mx-auto">
			<button class="btn btn-danger btn-block">검색</button>
		</div>
	</div>
</header>