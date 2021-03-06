<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Tourist</title>

<!-- Bootstrap core CSS -->
<link href="${path}/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="${path}/resources/css/all.min.css" rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link href="${path}/resources/css/magnific-popup.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${path}/resources/css/creative.min.css" rel="stylesheet">
<!-- Google Map Key -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> 
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/moment.min.js"></script>
</head>
<body id="page-top">
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav" style="background-color:black;">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Tourist</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto" style="color: white;">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">전체</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">지역</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">로그인</a>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>