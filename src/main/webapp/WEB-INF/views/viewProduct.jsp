<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>

<div class="container-wrapper">
	<div class="container">
		<h2>Product Detail</h2>
		<p class="lead">Here is the detail information of the product!</p>
	</div>

	<div class="row justify-content-center">
		<div class="col-4">
			<c:set var="imageFilename" value="/resources/images/${product.id}.jpg" />
			<img src="<c:url value="${imageFilename}"/>" alt="image" style="width:80%" />
		</div>
		
		<div class="col-4">
			<br>
			<h3>${product.name}</h3>
			<p>${product.description}</p>
			<p><b>Manufacturer</b> : ${product.manufacturer}</p>
			<p><b>Category</b> : ${product.category}</p>
			<h3>${product.price}원</h3>
		</div>
	</div>

</div>
