<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-wrapper">
	<div class="container">
		<h1>Add Product</h1>
		<p class="lead">Fill the below information to add a product:</p>

		<sf:form
			action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
			method="post" modelAttribute="product">

			<div class="form-group">
				<label for="name">Name</label>
				<sf:input class="form-control" path="name" id="name" />
				<sf:errors path="name" cssStyle="color:#ff0000"/>
			</div>

			<div class="form-group">
				<label for="category">Category:</label>
				<sf:radiobutton path="category" id="category" value="컴퓨터" />
				컴퓨터
				<sf:radiobutton path="category" id="category" value="가전" />
				가전
				<sf:radiobutton path="category" id="category" value="잡화" />
				잡화
			</div>

			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea class="form-control" path="description"
					id="description" />
			</div>

			<div class="form-group">
				<label for="price">Price</label>
				<sf:input class="form-control" path="price" id="price" />
				<sf:errors path="price" cssStyle="color:#ff0000"/>
			</div>

			<div class="form-group">
				<label for="unitInStock">Unit In Stock</label>
				<sf:input class="form-control" path="unitInStock" id="unitInStock" />
				<sf:errors path="unitInStock" cssStyle="color:#ff0000"/>
			</div>

			<div class="form-group">
				<label for="manufacturer">Manufacturer</label>
				<sf:input class="form-control" path="manufacturer" id="manufacturer" />
				<sf:errors path="manufacturer" cssStyle="color:#ff0000"/>
			</div>

			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/admin/productInventory" />"
				class="btn btn-default"> Cancel </a>
		</sf:form>
		<br>
	</div>
</div>
