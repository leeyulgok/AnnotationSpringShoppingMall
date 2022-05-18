<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style>
	.colorconf{
		font-size: 45px;
	}
	.colorconf .nav-link:hover{
		font-style: italic;
		color: #ffc045;
	}
	#logout:hover{
		color: red;
	}
</style>
<nav class="navbar navbar-expand-lg navbar-dark fixed-bottom colorconf">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand colorconf" href="index">Shopping Mall</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active colorconf"><a class="nav-link" href="list">Home</a></li>
            <c:choose>
            	<c:when test="${sessionScope.id eq null}">
	                <li class="nav-item colorconf"><a class="nav-link" href="login">Login</a></li>
	                <li class="nav-item colorconf"><a class="nav-link" href="signup">Sign-Up</a></li>
            	</c:when>
            	<c:otherwise>
            		<li class="nav-item colorconf"><a class="nav-link" href="checkMypage">${id}님</a></li>
            		<li class="nav-item colorconf"><a class="nav-link" href="logoutService" id="logout">Logout</a></li>
            	</c:otherwise>
            </c:choose>
                <li class="nav-item colorconf"><a class="nav-link" href="#!">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>