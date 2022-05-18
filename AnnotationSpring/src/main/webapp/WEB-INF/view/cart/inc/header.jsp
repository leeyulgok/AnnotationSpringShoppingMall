<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.searchbox{
		margin-right: 40px;
	}
	.searchbox select{
		height: 35px;
	}
	.searchbox input{
		height: 35px;
	}
	.searchbox button{
		height: 37px;
	}
</style>
<!DOCTYPE html>
 <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="index">Shopping Mall</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="list">Home</a></li>
                        <c:choose>
				          	<c:when test="${sessionScope.id eq null}">
				               <li class="nav-item colorconf"><a class="nav-link" href="login">Login</a></li>
				               <li class="nav-item colorconf"><a class="nav-link" href="signup">Sign-Up</a></li>
				          	</c:when>
				          	<c:otherwise>
				          		<li class="nav-item colorconf"><a class="nav-link" href="checkMypage">${id}님</a></li>
				          		<li class="nav-item colorconf"><a class="nav-link" href="logoutService">Logout</a></li>
				          	</c:otherwise>
			          </c:choose>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="typelist">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="typelist?type=T">TOP</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="typelist?type=T&pNumber=01">Outer</a></li>
                                <li><a class="dropdown-item" href="typelist?type=T&pNumber=02">Shirt</a></li>
                                <li><a class="dropdown-item" href="typelist?type=T&pNumber=03">MtoM</a></li>
                                <li><a class="dropdown-item" href="typelist?type=T&pNumber=04">T-Shirt</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="typelist?type=B">BOTTOM</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="typelist?type=B&pNumber=01">Jean</a></li>
                                <li><a class="dropdown-item" href="typelist?type=B&pNumber=02">Cotton</a></li>
                                <li><a class="dropdown-item" href="typelist?type=B&pNumber=03">Short</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="typelist?type=S">SHOES</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="typelist?type=S&pNumber=01">Sneakers</a></li>
                                <li><a class="dropdown-item" href="typelist?type=S&pNumber=02">Running</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="typelist?type=A">ACC</a></li>
                            </ul>
                        </li>
                        <c:choose>
				          	<c:when test="${sessionScope.id eq 'admin'}">
				                <li class="nav-item dropdown">
		                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Product</a>
		                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		                                <li><a class="dropdown-item" href="register">Register</a></li>
		                                <li><hr class="dropdown-divider" /></li>
		                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
		                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
		                            </ul>
                        </li>
				          	</c:when>
			          </c:choose>
                    </ul>
                    <div class="searchbox">
                    	<form action="search" method="post">
	                    	<select name="searchType">
	                    		<option value="pName">상품명</option>
	                    		<option value="Content">상품내용</option>
	                    	</select>
	                    	<input type="text" name="search" maxlength="10">
	                    	<button class="btn btn-outline-dark mt-auto" type="submit" value="검색">검색</button>
                    	</form>
                    </div>
                    <c:choose>
                    	<c:when test="${sessionScope.id ne null}">
		                    <a class="btn btn-outline-dark" type="button" href="cart">
		                        <i class="bi-cart-fill me-1"></i>
		                        Cart
		                        <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
		                    </a>
                    	</c:when>
                    	<c:otherwise>
	                    	<a class="btn btn-outline-dark" type="button" href="login">
		                        <i class="bi-cart-fill me-1"></i>
		                        Cart
		                        <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
		                    </a>
                    	</c:otherwise>
                    </c:choose>
                </div>
            </div>
        </nav>
        